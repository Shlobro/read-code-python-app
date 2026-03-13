package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 77. One senior-level problem per problem type.
// Correct answers are intentionally NOT the longest option to avoid a length-gives-it-away pattern.
val hardProblems77 = listOf(
    // FIND_BUG — correct answer is index 0 (shortest option; indices 1 and 3 are much longer)
    Problem(
        id = "bug_hard_78",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "asyncio coroutine not awaited",
        summary = "Calling a coroutine function without `await` returns a coroutine object instead of running it.",
        prompt = "What is the bug in this code?",
        code = """
            import asyncio

            async def fetch_data():
                await asyncio.sleep(0.1)
                return 42

            async def main():
                result = fetch_data()
                print(result)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "`fetch_data()` is called without `await`, so `result` is a coroutine object, not `42`",
            "`asyncio.run(main())` is the wrong entry point for coroutines defined with `async def`; the correct form is `asyncio.get_event_loop().run_until_complete(main())`, which properly schedules all pending tasks before the loop exits",
            "`asyncio.sleep(0.1)` cannot be used inside a coroutine that is called from `main` because each `async def` function owns its own event loop and nested event loops raise a `RuntimeError` at the `await` site",
            "Returning a plain integer from `fetch_data` is incompatible with `asyncio`'s coroutine protocol; the return value must be wrapped in `asyncio.Future` before it can be unpacked with `await` in the calling coroutine"
        ),
        answerIndex = 0,
        explanation = "Calling `fetch_data()` without `await` produces a coroutine object but never schedules it to run. `result` holds the coroutine object, so `print(result)` prints something like `<coroutine object fetch_data at 0x...>`. Fix: `result = await fetch_data()`."
    ),
    // OUTPUT — correct answer is index 2 (not the longest; index 3 is longer)
    Problem(
        id = "output_hard_78",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__new__ controls instance creation",
        summary = "Trace the output when __new__ returns an instance of a different class.",
        prompt = "What does this code print?",
        code = """
            class Singleton:
                _instance = None

                def __new__(cls):
                    if cls._instance is None:
                        cls._instance = super().__new__(cls)
                    return cls._instance

            a = Singleton()
            b = Singleton()
            print(a is b)
            print(type(a).__name__)
        """.trimIndent(),
        options = listOf(
            "False\nSingleton",
            "True\nobject",
            "True\nSingleton",
            "False\nobject — `super().__new__(cls)` delegates to `object.__new__`, which sets `type(a)` to `object` rather than to the subclass `Singleton`"
        ),
        answerIndex = 2,
        explanation = "`__new__` is called before `__init__`. The first call creates one instance and stores it in `_instance`. The second call returns the same stored instance. So `a is b` is `True`. `super().__new__(cls)` creates an instance whose type is `cls` (i.e. `Singleton`), so `type(a).__name__` is `'Singleton'`."
    ),
    // PURPOSE — correct answer is index 1 (not the longest; indices 0 and 3 are longer)
    Problem(
        id = "purpose_hard_78",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set_name__",
        summary = "__set_name__ lets a descriptor discover the attribute name it was assigned to.",
        prompt = "What is the primary purpose of this code?",
        code = """
            class Validated:
                def __set_name__(self, owner, name):
                    self.name = name

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError(f"{self.name} must be an int")
                    obj.__dict__[self.name] = value

            class Config:
                timeout = Validated()
                retries = Validated()

            c = Config()
            c.timeout = 30
        """.trimIndent(),
        options = listOf(
            "Intercept every attribute assignment on `Config` instances using `__setattr__` and delegate to a central validator, so that a single `Validated` object can enforce the same rule across all attribute names without storing the name explicitly at definition time",
            "Define a reusable descriptor that validates an attribute is an integer, using `__set_name__` to automatically capture the attribute name so error messages are precise",
            "Use `__init_subclass__` on `Validated` so that any class inheriting from it gains automatic integer validation for all class-level attributes, replacing the need to assign `Validated()` individually",
            "Create a metaclass-powered validation layer that intercepts class creation for `Config`, scans its namespace for `Validated` instances, and wires each one to a type-checking slot descriptor backed by `__slots__` to avoid `__dict__` overhead"
        ),
        answerIndex = 1,
        explanation = "`__set_name__(owner, name)` is called automatically by Python's type machinery when the class body is processed, passing the attribute name the descriptor was assigned to. This lets `Validated` store `self.name` without requiring it to be passed manually. `__set__` then enforces the type and uses `self.name` in the error message."
    ),
    // FILL_BLANK — correct answer is index 3 (not the longest; index 2 is longer)
    Problem(
        id = "fill_hard_78",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "dataclasses.field with default_factory",
        summary = "Use field(default_factory=...) to give each instance its own mutable default.",
        prompt = "Fill the blank so that each `Node` instance gets its own independent list of children.",
        code = """
            from dataclasses import dataclass, ___

            @dataclass
            class Node:
                value: int
                children: list = ___(default_factory=list)
        """.trimIndent(),
        options = listOf(
            "attr(default=[])",
            "property(lambda self: [])",
            "dataclass_field(mutable=True, factory=list)",
            "field"
        ),
        answerIndex = 3,
        explanation = "`dataclasses.field(default_factory=list)` tells the dataclass machinery to call `list()` for each new instance, giving every `Node` its own separate list. Using `children: list = []` directly would raise a `ValueError` because mutable defaults are forbidden in dataclasses to prevent shared-state bugs."
    ),
    // ORDER_STEPS — correct answer fixed at index 0 per convention
    Problem(
        id = "order_hard_77",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the steps of Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph, in_degree):",
            "    queue = [n for n in graph if in_degree[n] == 0]",
            "    order = []",
            "    while queue:",
            "        node = queue.pop(0)",
            "        order.append(node)",
            "        for nb in graph[node]:",
            "            in_degree[nb] -= 1",
            "            if in_degree[nb] == 0:",
            "                queue.append(nb)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Kahn's algorithm starts by enqueuing all nodes with in-degree zero. Each iteration removes a node, appends it to the result, and decrements the in-degree of its neighbours. When a neighbour's in-degree reaches zero it is enqueued. The result is a valid topological order (or, if the graph has a cycle, the result will be shorter than the node count)."
    ),
    // COMPLEXITY — correct answer is index 1 (not the longest; index 2 is longer)
    Problem(
        id = "complexity_hard_77",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Building a heap from an unsorted list",
        summary = "Determine the time complexity of heapq.heapify.",
        prompt = "What is the time complexity of `heapq.heapify(data)`?",
        code = """
            import heapq

            data = [9, 4, 7, 1, 8, 3]
            heapq.heapify(data)
        """.trimIndent(),
        options = listOf(
            "O(n log n) — each of the n elements is sifted down through a heap that can be up to log n levels deep, giving n multiplied by log n total comparisons",
            "O(n)",
            "O(n log n) — `heapify` internally sorts the list and then reads off the heap structure, inheriting the sort's n log n lower bound for comparison-based ordering",
            "O(log n) — only the root and its two children need to be repositioned because the leaf nodes already satisfy the heap property without any work"
        ),
        answerIndex = 1,
        explanation = "`heapq.heapify` uses the sift-down (bottom-up) approach: it processes only the non-leaf nodes, which are the top half of the array. The work at each level is proportional to the height, and the sum over all levels converges to O(n) — a tighter bound than the naive O(n log n) from calling `heappush` n times."
    ),
    // TRACE_VAR — correct answer is index 0 (shortest option)
    Problem(
        id = "trace_hard_77",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "ChainMap lookup order",
        summary = "Trace which value is returned when a key appears in multiple maps.",
        prompt = "What is the value of `result` after the last line?",
        code = """
            from collections import ChainMap

            defaults = {"color": "blue", "size": "M"}
            overrides = {"color": "red"}

            config = ChainMap(overrides, defaults)
            result = config["color"]
        """.trimIndent(),
        options = listOf(
            "'red'",
            "'blue'",
            "['red', 'blue'] — ChainMap collects all values for a key from every child map into a list",
            "KeyError — ChainMap raises an error when the same key appears in more than one child map because the lookup is ambiguous"
        ),
        answerIndex = 0,
        explanation = "`ChainMap` searches its child maps in the order they were passed to the constructor. `overrides` is first, so `config['color']` finds `'red'` there and returns it without consulting `defaults`. The key in `defaults` is shadowed, not merged."
    ),
    // MATCH_OUTPUT — correct answer is index 3 (not the longest; index 1 is longer)
    Problem(
        id = "match_hard_77",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {1, 2, 3}",
        summary = "Identify which snippet produces the set difference that removes one element from a four-element set.",
        prompt = "Which snippet prints `{1, 2, 3}`?",
        code = "",
        options = listOf(
            "a = {1, 2, 3, 4}\nb = {1, 2, 3, 4}\nprint(a ^ b)",
            "a = {1, 2, 3, 4}\nb = {4, 5, 6}\nprint(a.intersection(b).union({1, 2, 3}))",
            "a = {1, 2, 3, 4}\nb = {1, 2, 3, 4, 5}\nprint(a - b)",
            "a = {1, 2, 3, 4}\nb = {4}\nprint(a - b)"
        ),
        answerIndex = 3,
        explanation = "`a - b` is set difference: elements in `a` but not in `b`. `{1,2,3,4} - {4}` yields `{1,2,3}`. Option A gives `set()` (empty). Option B's chain produces `{4}.union({1,2,3})` = `{1,2,3,4}`. Option C gives `set()` because every element of `a` is also in `b`."
    )
)
