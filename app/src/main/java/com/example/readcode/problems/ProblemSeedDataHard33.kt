package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 33.
// One senior-level problem per problem type.
val hardProblems33 = listOf(
    Problem(
        id = "bug_hard_34",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set__ corrupts state before raising",
        summary = "A validating descriptor writes the bad value before it raises.",
        prompt = "What is the bug in this descriptor's `__set__` method?",
        code = """
            class Validated:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.name)

                def __set__(self, obj, value):
                    obj.__dict__[self.name] = value
                    if not isinstance(value, int):
                        raise TypeError("int required")

            class MyModel:
                x = Validated()

            obj = MyModel()
            obj.x = "hi"  # raises TypeError, but obj.__dict__ is already corrupted
            print(obj.__dict__)
        """.trimIndent(),
        options = listOf(
            "`obj.__dict__[self.name] = value` runs before the type check, so the invalid value is stored even though `TypeError` is raised; the fix is to validate first, then store",
            "`__set__` is never called because `Validated` does not define `__get__`, so it is a non-data descriptor",
            "Once a value exists in `obj.__dict__`, Python uses it directly and skips the descriptor entirely",
            "`__set_name__` is never called unless the descriptor is used in a dataclass"
        ),
        answerIndex = 0,
        explanation = "The bug is that `obj.__dict__[self.name] = value` executes before the `isinstance` check. Even though `TypeError` is raised, the invalid value has already been written into the instance dict. A data descriptor (one that defines both `__get__` and `__set__`) always intercepts attribute access, so the instance dict is not bypassed — but here the ordering is wrong. Fix: move the validation before the store: `if not isinstance(value, int): raise TypeError(...)` first, then `obj.__dict__[self.name] = value`."
    ),
    Problem(
        id = "output_hard_34",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "WeakRef callback timing",
        summary = "A weak-reference callback fires during garbage collection.",
        prompt = "What does this code print (CPython, reference counting enabled)?",
        code = """
            import weakref

            class Node:
                def __init__(self, name):
                    self.name = name

            def on_finalize(ref):
                print("gone")

            n = Node("root")
            ref = weakref.ref(n, on_finalize)
            print(ref() is not None)
            del n
            print(ref() is None)
        """.trimIndent(),
        options = listOf(
            "True\ngone\nTrue",
            "True\nTrue\ngone",
            "True\ngone\nFalse",
            "False\ngone\nTrue"
        ),
        answerIndex = 0,
        explanation = "In CPython, reference counting means the object is collected immediately when `del n` drops the last strong reference. The finalizer callback fires at that point, printing `gone` before execution returns to the next statement. After deletion, `ref()` returns `None`, so `ref() is None` is `True`."
    ),
    Problem(
        id = "purpose_hard_34",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ as a plugin registry",
        summary = "A base class automatically registers every subclass.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            class PluginBase:
                _registry: dict[str, type] = {}

                def __init_subclass__(cls, plugin_name: str = "", **kwargs):
                    super().__init_subclass__(**kwargs)
                    if plugin_name:
                        PluginBase._registry[plugin_name] = cls

            class CSVLoader(PluginBase, plugin_name="csv"):
                def load(self, path): ...

            class JSONLoader(PluginBase, plugin_name="json"):
                def load(self, path): ...

            loader_cls = PluginBase._registry["csv"]
        """.trimIndent(),
        options = listOf(
            "Automatically record every subclass in a central registry keyed by a name given at class-definition time, enabling lookup without explicit registration calls",
            "Prevent direct instantiation of `PluginBase` by raising an error in `__init_subclass__`",
            "Inject a shared `load` method into every subclass at definition time",
            "Enforce that every subclass must declare a `plugin_name` or a `TypeError` is raised"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called automatically by Python whenever a class inherits from `PluginBase`. The optional `plugin_name` keyword argument is passed in the class definition line. If provided, the subclass is stored in `_registry` under that name. This makes the registry self-maintaining — callers need only define a subclass with the right keyword, and the base class handles cataloguing it."
    ),
    Problem(
        id = "fill_hard_34",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.wraps in a decorator",
        summary = "Preserve the wrapped function's metadata.",
        prompt = "Which decorator fills the blank so that `wrapper.__name__ == 'greet'` after decoration?",
        code = """
            import functools

            def log_calls(func):
                @___(func)
                def wrapper(*args, **kwargs):
                    print(f"calling {func.__name__}")
                    return func(*args, **kwargs)
                return wrapper

            @log_calls
            def greet(name):
                return f"Hello, {name}"

            print(greet.__name__)  # should print: greet
        """.trimIndent(),
        options = listOf(
            "functools.wraps",
            "functools.lru_cache",
            "functools.partial",
            "functools.reduce"
        ),
        answerIndex = 0,
        explanation = "`@functools.wraps(func)` copies `__name__`, `__doc__`, `__module__`, `__qualname__`, and `__annotations__` from the wrapped function onto `wrapper`. Without it, `greet.__name__` would return `'wrapper'`, breaking introspection tools, `help()`, and stack traces."
    ),
    Problem(
        id = "order_hard_33",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest path (min-heap)",
        summary = "Arrange a heap-based shortest-path implementation in correct source order.",
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
        explanation = "Dijkstra's algorithm initialises all distances to infinity except the start node (0), then uses a min-heap to always relax the cheapest unvisited edge first. The stale-entry check (`cost > dist[node]`) skips heap entries that were superseded by a shorter path found later. Valid shorter paths update the distance table and push a new heap entry."
    ),
    Problem(
        id = "complexity_hard_33",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "LRU-cached recursive Fibonacci",
        summary = "Determine the time complexity when memoization is applied.",
        prompt = "What is the time complexity of `fib(n)` with `@lru_cache`?",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=None)
            def fib(n):
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf("O(n)", "O(n²)", "O(2^n)", "O(n log n)"),
        answerIndex = 0,
        explanation = "Without memoization, the call tree is a binary tree of depth n — O(2^n). With `@lru_cache`, each unique argument from 0 to n is computed exactly once and then retrieved in O(1) on repeated calls. There are n+1 unique inputs, each doing a constant amount of work (one addition), so the total time complexity is O(n)."
    ),
    Problem(
        id = "trace_hard_33",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable vs instance variable shadowing",
        summary = "Track which `count` each expression reads after attribute assignment.",
        prompt = "What value does `B.count` hold after this code runs?",
        code = """
            class A:
                count = 0

            class B(A):
                pass

            b = B()
            b.count += 1   # line 1
            B.count += 10  # line 2
            a = A()
            a.count += 100 # line 3
        """.trimIndent(),
        options = listOf("10", "11", "111", "1"),
        answerIndex = 0,
        explanation = "Line 1: `b.count += 1` reads `A.count` (0), computes 1, then creates an *instance* attribute `b.count = 1`. `A.count` and `B.count` (still shared with A) both remain 0. Line 2: `B.count += 10` reads the class-level value (0 inherited from A), computes 10, and creates a *class* attribute on B itself: `B.count = 10`. A.count is still 0. Line 3: `a.count += 100` creates an instance attribute `a.count = 100` on `a`; `A.count` stays 0. Final state: `B.count = 10`."
    ),
    Problem(
        id = "match_hard_33",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n[1, 4, 9, 16, 25]",
        summary = "Pick the snippet that produces exactly this list.",
        prompt = "Which code produces exactly `[1, 4, 9, 16, 25]`?",
        code = "[1, 4, 9, 16, 25]",
        options = listOf(
            "print(list(map(lambda x: x**2, range(1, 6))))",
            "print([x**2 for x in range(6)])",
            "print(list(map(lambda x: x*2, range(1, 6))))",
            "print([x**2 for x in range(5)])"
        ),
        answerIndex = 0,
        explanation = "`map(lambda x: x**2, range(1, 6))` squares each of 1, 2, 3, 4, 5, giving `[1, 4, 9, 16, 25]`. Option B uses `range(6)` which starts at 0, producing `[0, 1, 4, 9, 16, 25]`. Option C doubles instead of squaring: `[2, 4, 6, 8, 10]`. Option D uses `range(5)` (0–4): `[0, 1, 4, 9, 16]`."
    )
)
