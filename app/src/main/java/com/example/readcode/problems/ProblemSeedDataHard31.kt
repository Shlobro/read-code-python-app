package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 31.
// One senior-level problem per problem type.
val hardProblems31 = listOf(
    Problem(
        id = "bug_hard_32",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__eq__ without __hash__ breaks sets",
        summary = "Defining __eq__ silently makes a class unhashable.",
        prompt = "Why does adding instances of `Point` to a set raise a TypeError?",
        code = """
            class Point:
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

                def __eq__(self, other):
                    return self.x == other.x and self.y == other.y

            s = {Point(1, 2), Point(1, 2)}
        """.trimIndent(),
        options = listOf(
            "Defining __eq__ sets __hash__ to None, making instances unhashable",
            "Sets cannot hold objects; only primitives like ints and strings are allowed",
            "The two Point objects are equal, so the set raises a duplicate-key error",
            "__init__ must call super().__init__() before __eq__ is usable"
        ),
        answerIndex = 0,
        explanation = "In Python 3, defining `__eq__` without `__hash__` implicitly sets `__hash__ = None`, making instances unhashable. Any attempt to add them to a set or use them as dict keys raises `TypeError: unhashable type`. Fix: also define `__hash__`, e.g. `return hash((self.x, self.y))`."
    ),
    Problem(
        id = "output_hard_32",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Class vs instance variable shadowing",
        summary = "Assigning to an instance attribute shadows the class attribute.",
        prompt = "What does this code print?",
        code = """
            class Counter:
                count = 0

                def increment(self):
                    self.count += 1

            a = Counter()
            b = Counter()
            a.increment()
            a.increment()
            b.increment()
            print(Counter.count, a.count, b.count)
        """.trimIndent(),
        options = listOf(
            "0 2 1",
            "3 2 1",
            "0 0 0",
            "2 2 1"
        ),
        answerIndex = 0,
        explanation = "`self.count += 1` is equivalent to `self.count = self.count + 1`. The right-hand side reads the class attribute (0), then the result is stored as a new instance attribute on `self`. The class attribute `Counter.count` is never mutated, so it stays 0. `a.count` is 2 and `b.count` is 1 because each now has its own instance attribute."
    ),
    Problem(
        id = "purpose_hard_32",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Context manager via __enter__ / __exit__",
        summary = "A class that suppresses a specific exception type.",
        prompt = "What is the primary purpose of this class?",
        code = """
            class suppress:
                def __init__(self, *exceptions):
                    self.exceptions = exceptions

                def __enter__(self):
                    return self

                def __exit__(self, exc_type, exc_val, exc_tb):
                    return exc_type is not None and issubclass(exc_type, self.exceptions)
        """.trimIndent(),
        options = listOf(
            "Silently swallow specified exception types and continue execution",
            "Re-raise every exception it receives as a RuntimeError",
            "Log exceptions to stderr without interrupting the program",
            "Retry the body of the with-block whenever an exception occurs"
        ),
        answerIndex = 0,
        explanation = "`__exit__` returns `True` when the raised exception is a subclass of one of the suppressed types, which tells Python not to propagate the exception. This is the same behavior as `contextlib.suppress`. Returning a falsy value (or when no exception occurred, `exc_type` is `None`) lets exceptions propagate normally."
    ),
    Problem(
        id = "fill_hard_32",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "weakref to avoid keeping objects alive",
        summary = "Store explicit weak references so the cache releases objects when they are collected.",
        prompt = "Which stdlib call fills the blank so `register` stores a weak reference and `lookup` returns the live object (or `None` if collected)?",
        code = """
            import weakref

            class Registry:
                def __init__(self):
                    self._cache = {}

                def register(self, key, obj):
                    self._cache[key] = ___(obj)

                def lookup(self, key):
                    ref = self._cache.get(key)
                    return ref() if ref is not None else None
        """.trimIndent(),
        options = listOf(
            "weakref.ref",
            "weakref.WeakValueDictionary",
            "weakref.WeakKeyDictionary",
            "collections.defaultdict"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref(obj)` creates a callable weak-reference object. Storing it in `_cache` means the cache does not count as a strong reference, so the object can be garbage-collected. `lookup` calls `ref()` to dereference: it returns the live object if still alive, or `None` if collected. `WeakValueDictionary` would store weak values automatically but its `.get()` returns the object directly — calling `ref()` on a plain object would raise `TypeError`. `WeakKeyDictionary` weakens keys, not values."
    ),
    Problem(
        id = "order_hard_31",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest path",
        summary = "Arrange a heap-based Dijkstra implementation in the correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "import heapq",
            "def dijkstra(graph, start):",
            "    dist = {node: float('inf') for node in graph}",
            "    dist[start] = 0",
            "    heap = [(0, start)]",
            "    while heap:",
            "        cost, node = heapq.heappop(heap)",
            "        if cost > dist[node]:",
            "            continue",
            "        for neighbor, weight in graph[node].items():",
            "            new_cost = cost + weight",
            "            if new_cost < dist[neighbor]:",
            "                dist[neighbor] = new_cost",
            "                heapq.heappush(heap, (new_cost, neighbor))",
            "    return dist"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
        explanation = "Dijkstra initialises all distances to infinity except the start node (0). A min-heap drives exploration in cost order. The `cost > dist[node]` guard skips stale heap entries. For each neighbour, if the new path cost is lower it updates `dist` and pushes a fresh heap entry."
    ),
    Problem(
        id = "complexity_hard_31",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive Fibonacci with memoization",
        summary = "Determine the time complexity after @lru_cache is applied.",
        prompt = "What is the time complexity of `fib(n)` with `@lru_cache`?",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=None)
            def fib(n):
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf("O(n)", "O(2^n)", "O(n log n)", "O(n²)"),
        answerIndex = 0,
        explanation = "Without caching, `fib` runs in O(2^n) because every call branches into two recursive calls. `@lru_cache` memoizes results so each unique argument from 0 to n is computed exactly once, reducing the total number of calls to O(n). Space complexity is also O(n) for the cache and call stack."
    ),
    Problem(
        id = "trace_hard_31",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set__ intercepts assignment",
        summary = "A data descriptor's __set__ runs instead of writing to __dict__.",
        prompt = "What is the value of `obj.value` after this code runs?",
        code = """
            class Clamped:
                def __set_name__(self, owner, name):
                    self.name = '_' + name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.name, 0)

                def __set__(self, obj, value):
                    setattr(obj, self.name, max(0, min(100, value)))

            class Sensor:
                value = Clamped()

            obj = Sensor()
            obj.value = 150
        """.trimIndent(),
        options = listOf("100", "150", "0", "AttributeError"),
        answerIndex = 0,
        explanation = "Because `Clamped` defines both `__get__` and `__set__`, it is a data descriptor. The assignment `obj.value = 150` calls `Clamped.__set__(obj, 150)`, which clamps the value to `max(0, min(100, 150)) = 100` and stores it under `obj._value`. A subsequent `obj.value` read calls `__get__`, which returns `obj._value` = 100."
    ),
    Problem(
        id = "match_hard_31",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output:\n[1, 4, 9, 16]",
        summary = "Pick the snippet that produces a list of squares using a lazy pipeline.",
        prompt = "Which code produces exactly `[1, 4, 9, 16]`?",
        code = "[1, 4, 9, 16]",
        options = listOf(
            "print(list(map(lambda x: x**2, range(1, 5))))",
            "print(list(map(lambda x: x**2, range(5))))",
            "print([x**2 for x in range(5)])",
            "print(list(filter(lambda x: x**2, range(1, 5))))"
        ),
        answerIndex = 0,
        explanation = "`map(lambda x: x**2, range(1, 5))` applies the squaring function lazily to 1, 2, 3, 4 and `list()` materialises it to `[1, 4, 9, 16]`. Option B uses `range(5)` which starts at 0, giving `[0, 1, 4, 9, 16]`. Option C also uses `range(5)` (starts at 0). Option D uses `filter`, which keeps items where the predicate is truthy — it does not square them, and 0 would be dropped anyway, but the values remain unsquared."
    )
)
