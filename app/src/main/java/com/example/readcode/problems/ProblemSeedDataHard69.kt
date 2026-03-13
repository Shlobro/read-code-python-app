package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 69.
// One senior-level problem per problem type.
val hardProblems69 = listOf(
    Problem(
        id = "bug_hard_70",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Generator exhausted silently",
        summary = "A generator is consumed on first use and returns nothing on subsequent iteration.",
        prompt = "What is the bug in this code?",
        code = """
            def evens(n):
                return (x for x in range(n) if x % 2 == 0)

            gen = evens(10)
            first = list(gen)
            second = list(gen)
            print(second)
        """.trimIndent(),
        options = listOf(
            "Generators are exhausted after one full iteration; `second` is `[]`",
            "`range(n)` does not support even filtering with the modulo operator",
            "A generator expression inside `return` raises `StopIteration` immediately",
            "Calling `list()` on a generator expression raises `TypeError` because generators are not sequences"
        ),
        answerIndex = 0,
        explanation = "Once `list(gen)` consumes the generator, its internal iterator is at the end. A second call to `list(gen)` returns `[]` because there are no more values to yield. The fix is to call `evens(10)` again or use a reusable iterable such as a list."
    ),
    Problem(
        id = "output_hard_70",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__set_name__ called at class creation",
        summary = "Trace the descriptor protocol hook that fires when a class body is evaluated.",
        prompt = "What does this code print?",
        code = """
            class Descriptor:
                def __set_name__(self, owner, name):
                    self.name = name
                    print(f"set:{name}")

            class MyClass:
                x = Descriptor()
                y = Descriptor()

            obj = MyClass()
        """.trimIndent(),
        options = listOf(
            "set:x\nset:y",
            "set:x",
            "set:y\nset:x",
            "Nothing is printed until an attribute is accessed on `obj`"
        ),
        answerIndex = 0,
        explanation = "`__set_name__` is called by the metaclass `type.__new__` as it processes each descriptor in the class body, in definition order. Both `x` and `y` trigger the hook at class creation time, before any instance is created. Instantiating `obj` prints nothing additional."
    ),
    Problem(
        id = "purpose_hard_70",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager as a protocol adapter",
        summary = "Convert a setup/teardown pair into a context manager without writing a class.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def managed_resource(name):
                print(f"acquire {name}")
                try:
                    yield name
                finally:
                    print(f"release {name}")

            with managed_resource("db") as r:
                print(f"using {r}")
        """.trimIndent(),
        options = listOf(
            "Retry the body of the `with` block if an exception is raised",
            "Define a reusable context manager using a generator instead of a class",
            "Suppress exceptions raised inside the `with` block and log them instead",
            "Ensure the resource `db` is only acquired once across all threads by using a global lock"
        ),
        answerIndex = 1,
        explanation = "`@contextmanager` turns a generator function into a context manager. Code before `yield` runs on `__enter__`; the `yield` value becomes the `as` target; the `finally` block runs on `__exit__`. This avoids writing an explicit `__enter__`/`__exit__` class."
    ),
    Problem(
        id = "fill_hard_70",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "LRU cache invalidation via cache_clear",
        summary = "Call the correct method to discard all cached results of a decorated function.",
        prompt = "Fill the blank to clear all cached results of `compute`.",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=128)
            def compute(n):
                return n ** 2

            compute(5)
            compute.___(  )
        """.trimIndent(),
        options = listOf(
            "cache_clear",
            "cache_reset",
            "invalidate",
            "clear_cache"
        ),
        answerIndex = 0,
        explanation = "`lru_cache` attaches a `cache_clear()` method to the wrapped function. Calling `compute.cache_clear()` discards every stored result. The other names (`cache_reset`, `invalidate`, `clear_cache`) do not exist on the wrapper and would raise `AttributeError`."
    ),
    Problem(
        id = "order_hard_69",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the steps of Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph):",
            "    in_degree = {u: 0 for u in graph}",
            "    for u in graph:",
            "        for v in graph[u]:",
            "            in_degree[v] += 1",
            "    queue = [u for u in graph if in_degree[u] == 0]",
            "    order = []",
            "    while queue:",
            "        u = queue.pop(0)",
            "        order.append(u)",
            "        for v in graph[u]:",
            "            in_degree[v] -= 1",
            "            if in_degree[v] == 0:",
            "                queue.append(v)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
        explanation = "Build in-degree counts for every node. Seed the queue with all zero-in-degree nodes. Each iteration removes a node from the queue, appends it to the result, decrements the in-degree of its neighbours, and enqueues any neighbour whose in-degree drops to zero."
    ),
    Problem(
        id = "complexity_hard_69",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "All simple paths in a DAG",
        summary = "DFS that enumerates every path from source to sink in a directed acyclic graph.",
        prompt = "What is the worst-case time complexity of this algorithm (V = vertices, E = edges)?",
        code = """
            def all_paths(graph, src, dst):
                paths = []
                def dfs(node, path):
                    if node == dst:
                        paths.append(list(path))
                        return
                    for nb in graph.get(node, []):
                        path.append(nb)
                        dfs(nb, path)
                        path.pop()
                dfs(src, [src])
                return paths
        """.trimIndent(),
        options = listOf(
            "O(V + E)",
            "O(V * E)",
            "O(2^V)",
            "O(V!)"
        ),
        answerIndex = 2,
        explanation = "In the worst case (e.g., a complete DAG where every subset of vertices is a valid path), the number of simple paths grows exponentially. Each path can be up to V nodes long and there can be 2^V paths in the worst case, so the time complexity is O(2^V). O(V + E) describes simple traversal with no path enumeration."
    ),
    Problem(
        id = "trace_hard_69",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Slots block instance __dict__",
        summary = "Trace what happens when you set an undeclared attribute on a slotted class.",
        prompt = "What does this code print?",
        code = """
            class Point:
                __slots__ = ("x", "y")

            p = Point()
            p.x = 1
            try:
                p.z = 9
            except AttributeError:
                print("no slot")
            print(p.x)
        """.trimIndent(),
        options = listOf(
            "no slot\n1",
            "1",
            "no slot",
            "AttributeError is raised and propagates, nothing prints"
        ),
        answerIndex = 0,
        explanation = "`__slots__` removes the per-instance `__dict__`, so assigning to any name not listed in `__slots__` raises `AttributeError`. The `except` block catches it and prints `no slot`. The slot `x` was set successfully, so `print(p.x)` then prints `1`."
    ),
    Problem(
        id = "match_hard_69",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "deque maxlen eviction",
        summary = "Identify which snippet produces a deque with exactly [3, 4, 5] after overflow.",
        prompt = "Which snippet prints `deque([3, 4, 5], maxlen=3)`?",
        code = "",
        options = listOf(
            "from collections import deque\nd = deque([1,2,3], maxlen=3)\nd.extend([4,5])\nprint(d)",
            "from collections import deque\nd = deque(maxlen=3)\nd.extend([1,2,3,4,5])\nd.appendleft(0)\nprint(d)",
            "from collections import deque\nd = deque([3,4,5,6], maxlen=3)\nprint(d)",
            "from collections import deque\nd = deque([1,2,3], maxlen=3)\nd.appendleft(4)\nd.appendleft(5)\nprint(d)"
        ),
        answerIndex = 0,
        explanation = "A `deque` with `maxlen=3` drops from the left when elements are appended to the right. Starting with `[1,2,3]` and extending with `[4,5]` evicts `1` then `2`, leaving `[3,4,5]`. Option B ends with `[0,4,5]` because `appendleft(0)` pushes `5` off the right. Option C yields `[4,5,6]` since the rightmost three are kept. Option D uses `appendleft`, so items are added to the left and the right element is evicted, giving `[5,4,3]`."
    )
)
