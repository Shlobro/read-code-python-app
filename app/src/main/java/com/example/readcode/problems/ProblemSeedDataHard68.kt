package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 68.
// One senior-level problem per problem type.
val hardProblems68 = listOf(
    Problem(
        id = "bug_hard_69",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "weakref to a local object",
        summary = "A weak reference to a short-lived object becomes dead immediately.",
        prompt = "What is the bug in this code?",
        code = """
            import weakref

            class Config:
                pass

            def get_ref():
                obj = Config()
                return weakref.ref(obj)

            ref = get_ref()
            print(ref())
        """.trimIndent(),
        options = listOf(
            "`obj` is garbage-collected when `get_ref` returns, so `ref()` is `None`",
            "`weakref.ref` cannot reference user-defined classes without `__weakref__` in `__slots__`",
            "The object must be created outside the function to be referenced",
            "`weakref.ref` raises `TypeError` when called on a locally scoped object"
        ),
        answerIndex = 0,
        explanation = "Once `get_ref` returns, nothing holds a strong reference to `obj`. The garbage collector immediately collects it. Calling `ref()` returns `None` because the referent is gone. User-defined classes support weak references by default; the bug is the lifetime mismatch, not the type."
    ),
    Problem(
        id = "output_hard_69",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook fires on subclass creation",
        summary = "Trace what __init_subclass__ prints as subclasses are defined.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def __init_subclass__(cls, tag="?", **kw):
                    super().__init_subclass__(**kw)
                    print(f"{cls.__name__}:{tag}")

            class A(Base, tag="x"): pass
            class B(Base): pass
            class C(A, tag="z"): pass
        """.trimIndent(),
        options = listOf(
            "A:x\nB:?\nC:z",
            "A:x\nC:z",
            "Base:?\nA:x\nB:?\nC:z",
            "A:?\nB:?\nC:z"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` fires whenever a subclass is created. Defining `A` triggers it with `tag='x'`, `B` with the default `tag='?'`, and `C` with `tag='z'`. `Base` itself does not trigger the hook. Output: `A:x`, `B:?`, `C:z`."
    ),
    Problem(
        id = "purpose_hard_69",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "functools.singledispatch",
        summary = "Register type-specific implementations of a generic function.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from functools import singledispatch

            @singledispatch
            def process(val):
                raise NotImplementedError(type(val))

            @process.register(int)
            def _(val):
                return val * 2

            @process.register(str)
            def _(val):
                return val.upper()
        """.trimIndent(),
        options = listOf(
            "Cache the result of `process` for repeated calls with the same value",
            "Dispatch `process` to a type-specific implementation based on the first argument's type",
            "Overload `process` so it accepts both `int` and `str` at the same time",
            "Validate that `process` is only called with registered types and raise otherwise"
        ),
        answerIndex = 1,
        explanation = "`functools.singledispatch` implements function overloading by runtime type. Calling `process(3)` routes to the `int` handler; `process('hi')` routes to the `str` handler. The base implementation raises `NotImplementedError` for unregistered types."
    ),
    Problem(
        id = "fill_hard_69",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with threading.Lock",
        summary = "Guard a shared counter with the correct context-manager syntax.",
        prompt = "Fill the blank so `count` is safely incremented across threads.",
        code = """
            import threading

            lock = threading.Lock()
            count = 0

            def increment():
                global count
                ___ lock:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "with",
            "acquire",
            "lock()",
            "async with"
        ),
        answerIndex = 0,
        explanation = "`with lock:` acquires the lock on entry and releases it on exit, even if an exception is raised. `acquire` is a method call, not a statement. `lock()` is not valid syntax for a lock. `async with` requires an async context manager and an async function."
    ),
    Problem(
        id = "order_hard_68",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest-path algorithm",
        summary = "Arrange the core steps of the heap-based Dijkstra implementation.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def dijkstra(graph, src):",
            "    dist = {n: float('inf') for n in graph}",
            "    dist[src] = 0",
            "    heap = [(0, src)]",
            "    while heap:",
            "        d, u = heapq.heappop(heap)",
            "        if d > dist[u]: continue",
            "        for v, w in graph[u]:",
            "            if dist[u] + w < dist[v]:",
            "                dist[v] = dist[u] + w",
            "                heapq.heappush(heap, (dist[v], v))",
            "    return dist"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
        explanation = "Initialise all distances to infinity except the source (0). Push the source onto a min-heap. Each iteration pops the cheapest node, skips stale entries, then relaxes outgoing edges by pushing updated distances."
    ),
    Problem(
        id = "complexity_hard_68",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Merge sort with linked list",
        summary = "Recursive merge sort that splits by slow/fast pointers.",
        prompt = "What is the time complexity of this algorithm?",
        code = """
            def merge_sort(head):
                if not head or not head.next:
                    return head
                slow, fast = head, head.next
                while fast and fast.next:
                    slow = slow.next
                    fast = fast.next.next
                mid = slow.next
                slow.next = None
                left = merge_sort(head)
                right = merge_sort(mid)
                return merge(left, right)
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(n²)",
            "O(n)",
            "O(log n)"
        ),
        answerIndex = 0,
        explanation = "The list is halved at each recursion level (O(log n) levels). Each level merges a total of n nodes. Overall: O(n log n). The slow/fast pointer split is O(n) per level and does not change the asymptotic class."
    ),
    Problem(
        id = "trace_hard_68",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "dataclass field with mutable default_factory",
        summary = "Trace how default_factory isolates mutable defaults per instance.",
        prompt = "What does this code print?",
        code = """
            from dataclasses import dataclass, field

            @dataclass
            class Bag:
                items: list = field(default_factory=list)

            a = Bag()
            b = Bag()
            a.items.append(1)
            print(b.items)
        """.trimIndent(),
        options = listOf(
            "[]",
            "[1]",
            "None",
            "AttributeError"
        ),
        answerIndex = 0,
        explanation = "`default_factory=list` calls `list()` for each new instance, so `a.items` and `b.items` are distinct lists. Appending to `a.items` does not affect `b.items`, which remains `[]`."
    ),
    Problem(
        id = "match_hard_68",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 2] from asyncio.gather",
        summary = "Identify which gather call returns results in argument order.",
        prompt = "Which snippet prints `[1, 2]`?",
        code = "[1, 2]",
        options = listOf(
            "import asyncio\nasync def f(n): return n\nasync def main():\n    r = await asyncio.gather(f(1), f(2))\n    print(r)\nasyncio.run(main())",
            "import asyncio\nasync def f(n): return n\nasync def main():\n    r = await asyncio.gather(f(2), f(1))\n    print(r)\nasyncio.run(main())",
            "import asyncio\nasync def f(n): return n\nasync def main():\n    r = [await f(1), await f(2)]\n    print(sorted(r, reverse=True))\nasyncio.run(main())",
            "import asyncio\nasync def f(n): return n\nr = asyncio.run(asyncio.gather(f(1), f(2)))\nprint(list(reversed(r)))"
        ),
        answerIndex = 0,
        explanation = "`asyncio.gather` returns results in the same order as its arguments regardless of completion order. `gather(f(1), f(2))` returns `[1, 2]`. Option B passes arguments reversed so the result is `[2, 1]`. Option C sorts descending, giving `[2, 1]`. Option D reverses the result, also giving `[2, 1]`."
    )
)
