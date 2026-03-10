package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 37.
// One senior-level problem per problem type.
val hardProblems37 = listOf(
    Problem(
        id = "bug_hard_38",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "asyncio task fire-and-forget loses exception",
        summary = "A background task raises silently because its result is never awaited.",
        prompt = "Why does this code print `Done` without raising the `ValueError` from the background task?",
        code = """
            import asyncio

            async def failing_task():
                await asyncio.sleep(0)
                raise ValueError("task failed")

            async def main():
                asyncio.create_task(failing_task())  # fire and forget
                await asyncio.sleep(0.1)
                print("Done")

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "`create_task` schedules the coroutine but its exception is silently discarded when the Task object is garbage-collected because no code awaits or calls `.result()` on it",
            "`asyncio.sleep(0)` inside `failing_task` cancels all pending exceptions before they propagate",
            "`ValueError` cannot propagate across `asyncio.run` boundaries; it is converted to a `RuntimeError`",
            "Exceptions from coroutines created with `create_task` are always re-raised in the event loop thread after `asyncio.run` returns"
        ),
        answerIndex = 0,
        explanation = "When `create_task` is used without saving the returned `Task` object and awaiting it (or adding a done callback), any exception the task raises is stored inside the `Task` but never re-raised to calling code. Python logs a 'Task exception was never retrieved' warning when the `Task` is garbage-collected, but the program continues normally. The fix is to either `await` the task or attach an error-handling callback via `task.add_done_callback`."
    ),
    Problem(
        id = "output_hard_38",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set_name__ and inheritance",
        summary = "Descriptor names are assigned at class-creation time via __set_name__.",
        prompt = "What is printed when this module-level code runs?",
        code = """
            class Validated:
                def __set_name__(self, owner, name):
                    self.public_name = name
                    self.private_name = '_' + name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.private_name, None)

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError(f"{self.public_name} must be int")
                    setattr(obj, self.private_name, value)

            class Point:
                x = Validated()
                y = Validated()

            p = Point()
            p.x = 3
            p.y = 7
            print(p.x, p.y)
            print(Point.x.public_name, Point.y.public_name)
        """.trimIndent(),
        options = listOf(
            "3 7\nx y",
            "None None\nx y",
            "3 7\nValidated Validated",
            "AttributeError: 'Point' object has no attribute '_x'"
        ),
        answerIndex = 0,
        explanation = "`__set_name__` is called automatically by the metaclass when the class body is executed. For `Point.x = Validated()`, Python calls `Validated.__set_name__(descriptor, Point, 'x')`, setting `public_name='x'` and `private_name='_x'`. The same happens for `y`. `__set__` stores the value on the instance under `_x` / `_y`, and `__get__` retrieves it. So `p.x` returns `3`, `p.y` returns `7`, and accessing the descriptor on the class (`Point.x`) returns the descriptor object itself (because `obj is None`), from which `public_name` is readable."
    ),
    Problem(
        id = "purpose_hard_38",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager with exception suppression",
        summary = "A generator-based context manager that conditionally swallows exceptions.",
        prompt = "What is the primary purpose of this context manager?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def suppress_http(code):
                try:
                    yield
                except Exception as exc:
                    status = getattr(exc, 'status_code', None)
                    if status != code:
                        raise
        """.trimIndent(),
        options = listOf(
            "Suppress any exception whose `status_code` attribute matches `code`, while re-raising all other exceptions",
            "Catch all exceptions and convert them to HTTP responses with the given status code",
            "Retry the block up to `code` times before re-raising",
            "Log exceptions with HTTP status `code` and then continue silently for all exceptions"
        ),
        answerIndex = 0,
        explanation = "The `@contextmanager` decorator turns a generator function into a context manager. The `yield` hands control to the `with` block body. If that block raises an exception, execution resumes in the `except` clause. The manager inspects `exc.status_code`: if it matches `code`, the `except` block exits normally, which suppresses the exception; if it does not match (or the attribute is absent), `raise` re-raises the original exception. This pattern is common when wrapping HTTP-client calls to selectively ignore expected error responses (e.g., 404)."
    ),
    Problem(
        id = "fill_hard_38",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "weakref to avoid reference cycles",
        summary = "Choose the correct call to create a weak reference to an object.",
        prompt = "Which expression fills the blank so that `ref()` returns the original object without preventing garbage collection of `obj`?",
        code = """
            import weakref

            class Node:
                pass

            obj = Node()
            ref = ___(obj)
            print(ref() is obj)  # True
            del obj
            print(ref())         # None (object collected)
        """.trimIndent(),
        options = listOf(
            "weakref.ref",
            "weakref.proxy",
            "weakref.finalize",
            "weakref.WeakSet"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref(obj)` creates a callable weak-reference object. Calling `ref()` returns the referent if it is still alive, or `None` once it has been garbage-collected. This avoids keeping `obj` alive artificially. `weakref.proxy` also creates a weak reference but forwards attribute access transparently and raises `ReferenceError` (not `None`) on access after collection — it is not callable in the same way. `weakref.finalize` registers a cleanup callback. `weakref.WeakSet` is a container, not a single-object reference."
    ),
    Problem(
        id = "order_hard_37",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the core steps of Kahn's BFS-based topological sort in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph):",
            "    in_degree = {v: 0 for v in graph}",
            "    for v in graph:",
            "        for nbr in graph[v]:",
            "            in_degree[nbr] += 1",
            "    queue = deque(v for v in graph if in_degree[v] == 0)",
            "    order = []",
            "    while queue:",
            "        v = queue.popleft()",
            "        order.append(v)",
            "        for nbr in graph[v]:",
            "            in_degree[nbr] -= 1",
            "            if in_degree[nbr] == 0:",
            "                queue.append(nbr)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
        explanation = "Kahn's algorithm initialises in-degrees for all vertices, seeds the queue with zero-in-degree nodes, then repeatedly dequeues a node, appends it to the result, and decrements in-degrees of its neighbours — adding any neighbour that reaches zero to the queue. This produces a valid topological ordering as long as the graph is a DAG."
    ),
    Problem(
        id = "complexity_hard_37",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Amortised cost of dynamic array append",
        summary = "Analyse the amortised time per append in a doubling dynamic array.",
        prompt = "What is the amortised time complexity per `append` call in a dynamic array that doubles its capacity when full?",
        code = """
            class DynArray:
                def __init__(self):
                    self._data = [None]
                    self._size = 0
                    self._cap = 1

                def append(self, item):
                    if self._size == self._cap:
                        new = [None] * (self._cap * 2)
                        for i in range(self._size):
                            new[i] = self._data[i]
                        self._data = new
                        self._cap *= 2
                    self._data[self._size] = item
                    self._size += 1
        """.trimIndent(),
        options = listOf(
            "O(1) amortised — each element is copied at most O(log n) times in total across all doublings, so the average cost per append is constant",
            "O(n) amortised — every append triggers a full copy of the array",
            "O(log n) amortised — the number of doublings grows logarithmically with n",
            "O(n log n) amortised — doubling is O(n) and occurs O(log n) times, each charged separately to the triggering append"
        ),
        answerIndex = 0,
        explanation = "Using the accounting (potential) argument: assign each `append` a charge of 3 units — 1 for the insert and 2 stored as credit. When a doubling occurs, the n/2 new elements (those inserted since the last doubling) have each saved 2 credits, giving exactly n credits to pay for copying all n elements. The total work across n appends is therefore O(n), making the amortised cost per append O(1). The O(log n) doubling count matters for worst-case individual calls (O(n)), but not for the amortised bound."
    ),
    Problem(
        id = "trace_hard_37",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and coroutine state",
        summary = "Track the value of `received` after a sequence of send() calls.",
        prompt = "What value does `received` hold inside the generator after the third `send` call?",
        code = """
            def accumulator():
                total = 0
                received = None
                while True:
                    received = yield total
                    if received is not None:
                        total += received

            gen = accumulator()
            next(gen)        # prime the generator
            gen.send(10)     # first send
            gen.send(20)     # second send
            gen.send(5)      # third send — generator is paused here
        """.trimIndent(),
        options = listOf("5", "10", "35", "None"),
        answerIndex = 0,
        explanation = "Each `send(value)` resumes the generator and assigns `value` to `received` via the `yield` expression. After `next(gen)` primes it (generator pauses at `yield total` with `total=0`), `send(10)` sets `received=10` and `total` becomes 10, then pauses again at `yield`. `send(20)` sets `received=20`, `total` becomes 30. `send(5)` sets `received=5`, `total` becomes 35, and the generator pauses at `yield total` again with `received` still holding 5 — the value just received before the next `yield` suspends execution."
    ),
    Problem(
        id = "match_hard_37",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [0, 1, 1, 2, 3, 5, 8]",
        summary = "Pick the snippet that generates Fibonacci numbers using a generator and islice.",
        prompt = "Which code prints `[0, 1, 1, 2, 3, 5, 8]`?",
        code = "[0, 1, 1, 2, 3, 5, 8]",
        options = listOf(
            "from itertools import islice\ndef fib():\n    a, b = 0, 1\n    while True:\n        yield a\n        a, b = b, a + b\nprint(list(islice(fib(), 7)))",
            "from itertools import islice\ndef fib():\n    a, b = 1, 1\n    while True:\n        yield a\n        a, b = b, a + b\nprint(list(islice(fib(), 7)))",
            "from itertools import islice\ndef fib():\n    a, b = 0, 1\n    while True:\n        yield b\n        a, b = b, a + b\nprint(list(islice(fib(), 7)))",
            "from itertools import islice\ndef fib():\n    a, b = 0, 2\n    while True:\n        yield a\n        a, b = b, a + b\nprint(list(islice(fib(), 7)))"
        ),
        answerIndex = 0,
        explanation = "Option A seeds with `a=0, b=1` and yields `a` before the swap, producing the standard Fibonacci sequence starting at 0: `[0, 1, 1, 2, 3, 5, 8]`. Option B seeds with `a=1, b=1`, so it starts at 1: `[1, 1, 2, 3, 5, 8, 13]`. Option C seeds with `a=0, b=1` but yields `b`, so the first value is 1: `[1, 1, 2, 3, 5, 8, 13]`. Option D seeds with `b=2`, producing `[0, 2, 2, 4, 6, 10, 16]`. Only option A matches `[0, 1, 1, 2, 3, 5, 8]`."
    )
)
