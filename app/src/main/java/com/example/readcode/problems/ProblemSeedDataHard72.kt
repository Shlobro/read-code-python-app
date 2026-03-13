package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 72.
// One senior-level problem per problem type.
val hardProblems72 = listOf(
    Problem(
        id = "bug_hard_73",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "asyncio task lost to GC",
        summary = "A fire-and-forget coroutine is silently cancelled before it completes.",
        prompt = "What is the bug in this code?",
        code = """
            import asyncio

            async def background():
                await asyncio.sleep(1)
                print("done")

            async def main():
                asyncio.ensure_future(background())
                await asyncio.sleep(2)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "The task is not retained in a variable, so the garbage collector can cancel it before it finishes",
            "`asyncio.ensure_future` is deprecated; `asyncio.create_task` must be used instead",
            "`await asyncio.sleep(2)` blocks the event loop and prevents `background` from running",
            "Calling `asyncio.run` inside an async function raises `RuntimeError`"
        ),
        answerIndex = 0,
        explanation = "CPython's garbage collector may collect the task object created by `ensure_future` if no strong reference is kept. When collected, the task is cancelled mid-execution. The fix is `task = asyncio.ensure_future(background())` (or `asyncio.create_task`) and keeping `task` alive. `ensure_future` itself is not deprecated."
    ),
    Problem(
        id = "output_hard_73",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook",
        summary = "Trace the output produced when a subclass is defined.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def __init_subclass__(cls, tag="", **kwargs):
                    super().__init_subclass__(**kwargs)
                    print(f"registered:{tag}")

            class A(Base, tag="alpha"):
                pass

            class B(Base):
                pass
        """.trimIndent(),
        options = listOf(
            "registered:alpha\nregistered:",
            "registered:alpha",
            "registered:\nregistered:alpha",
            "Nothing is printed until instances of A or B are created"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called on the parent class each time a new subclass is defined, passing any keyword arguments given in the class line. `A` passes `tag='alpha'` and `B` passes no tag, so it defaults to `''`. Both trigger the hook at class-definition time, not at instantiation, so both lines print immediately. Output order matches definition order."
    ),
    Problem(
        id = "purpose_hard_73",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "sys.audit and PEP 578",
        summary = "Intercept security-sensitive interpreter events at runtime.",
        prompt = "What is the primary purpose of this code?",
        code = """
            import sys

            def audit_hook(event, args):
                if event == "open":
                    print(f"file open: {args[0]}")

            sys.addaudithook(audit_hook)
            open("secret.txt", "r")
        """.trimIndent(),
        options = listOf(
            "Log every file-open call by monkey-patching the built-in `open` function",
            "Register a hook that the interpreter calls for security-sensitive events such as file opens",
            "Prevent the file from being opened by raising an exception inside the hook",
            "Capture the return value of `open` so it can be inspected before the caller receives it"
        ),
        answerIndex = 1,
        explanation = "`sys.addaudithook` registers a callable that the CPython interpreter invokes for audited events (PEP 578). When `open` is called, the interpreter fires the `'open'` event before executing the syscall, passing the path and mode as `args`. The hook cannot intercept the return value and does not replace `open`; it is purely an observation/enforcement point."
    ),
    Problem(
        id = "fill_hard_73",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "operator.attrgetter",
        summary = "Sort a list of objects by a nested attribute using a key function.",
        prompt = "Fill the blank so `people` is sorted by `address.city` without a lambda.",
        code = """
            import operator

            people.sort(key=operator.___(\"address.city\"))
        """.trimIndent(),
        options = listOf(
            "attrgetter",
            "itemgetter",
            "methodcaller",
            "getattr"
        ),
        answerIndex = 0,
        explanation = "`operator.attrgetter('address.city')` returns a callable that navigates dotted attribute paths, making it suitable as a sort key for nested attributes. `itemgetter` works on subscript access (dicts/lists), not attributes. `methodcaller` calls a method by name. `operator.getattr` does not exist."
    ),
    Problem(
        id = "order_hard_72",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest path",
        summary = "Arrange the priority-queue implementation of Dijkstra's algorithm.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def dijkstra(graph, src):",
            "    dist = {node: float('inf') for node in graph}",
            "    dist[src] = 0",
            "    heap = [(0, src)]",
            "    while heap:",
            "        d, u = heapq.heappop(heap)",
            "        if d > dist[u]:",
            "            continue",
            "        for v, w in graph[u]:",
            "            if dist[u] + w < dist[v]:",
            "                dist[v] = dist[u] + w",
            "                heapq.heappush(heap, (dist[v], v))",
            "    return dist"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
        explanation = "Initialise all distances to infinity except the source (0). Use a min-heap seeded with (0, src). Each pop retrieves the nearest unprocessed node; the staleness check (`d > dist[u]`) skips outdated entries. Relaxing each outgoing edge and pushing improved distances drives the algorithm to completion."
    ),
    Problem(
        id = "complexity_hard_72",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sieve of Eratosthenes",
        summary = "Classic prime sieve up to n.",
        prompt = "What is the time complexity of this algorithm (n = upper bound)?",
        code = """
            def sieve(n):
                is_prime = [True] * (n + 1)
                is_prime[0] = is_prime[1] = False
                p = 2
                while p * p <= n:
                    if is_prime[p]:
                        for i in range(p * p, n + 1, p):
                            is_prime[i] = False
                    p += 1
                return [i for i in range(2, n + 1) if is_prime[i]]
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(n log log n)",
            "O(n²)",
            "O(n√n)"
        ),
        answerIndex = 1,
        explanation = "The sieve marks each composite number once per prime factor. The total work across all primes p ≤ √n is n/2 + n/3 + n/5 + … which converges to O(n log log n) by Mertens' theorem. O(n log n) is the bound for the Sieve of Sundaram; O(n√n) would describe a naive primality test for every number."
    ),
    Problem(
        id = "trace_hard_72",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "nonlocal vs global rebind",
        summary = "Trace whether a nested function's rebind affects the enclosing scope.",
        prompt = "What does this code print?",
        code = """
            x = 10

            def outer():
                x = 20
                def inner():
                    nonlocal x
                    x = 30
                inner()
                print(x)

            outer()
            print(x)
        """.trimIndent(),
        options = listOf(
            "30\n10",
            "30\n30",
            "20\n10",
            "30\n20"
        ),
        answerIndex = 0,
        explanation = "`nonlocal x` inside `inner` binds to the `x` in `outer`'s local scope (value 20), not the global `x`. After `inner()` runs, `outer`'s `x` is 30, so `print(x)` inside `outer` prints `30`. The global `x` is untouched and remains `10`, so the final `print(x)` prints `10`."
    ),
    Problem(
        id = "match_hard_72",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: True",
        summary = "Identify which isinstance check against an ABC prints True.",
        prompt = "Which snippet prints `True`?",
        code = "",
        options = listOf(
            "from collections.abc import Mapping\nprint(isinstance({}, Mapping))",
            "from collections.abc import Sequence\nprint(isinstance({}, Sequence))",
            "print(issubclass(list, dict))",
            "print(isinstance([], dict))"
        ),
        answerIndex = 0,
        explanation = "Option A: `dict` is registered as a virtual subclass of `collections.abc.Mapping`, so `isinstance({}, Mapping)` is `True`. Option B: `dict` does not implement the `Sequence` protocol (no integer indexing or `index`/`count` methods), so `isinstance({}, Sequence)` is `False`. Option C: `list` is not a subclass of `dict` → `False`. Option D: `[]` is a `list`, not a `dict` → `False`."
    )
)
