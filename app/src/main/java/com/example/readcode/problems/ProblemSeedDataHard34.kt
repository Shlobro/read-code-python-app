package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 34.
// One senior-level problem per problem type.
val hardProblems34 = listOf(
    Problem(
        id = "bug_hard_35",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__slots__ with inheritance breaks pickle",
        summary = "A slotted subclass loses state when pickled because __getstate__ is missing.",
        prompt = "Why does unpickling `ColorPoint(1, 2, 'red')` silently lose the `color` attribute?",
        code = """
            import pickle

            class Point:
                __slots__ = ('x', 'y')

                def __init__(self, x, y):
                    self.x = x
                    self.y = y

            class ColorPoint(Point):
                __slots__ = ('color',)

                def __init__(self, x, y, color):
                    super().__init__(x, y)
                    self.color = color

            cp = ColorPoint(1, 2, 'red')
            cp2 = pickle.loads(pickle.dumps(cp))
            print(cp2.color)  # AttributeError
        """.trimIndent(),
        options = listOf(
            "`ColorPoint` inherits `__slots__` but no `__getstate__`/`__setstate__`, so the default pickle protocol only saves `__dict__` (which is empty for slotted classes); slot values like `color` are silently dropped. Fix: implement `__getstate__` to collect all slots and `__setstate__` to restore them.",
            "Subclassing a slotted class always raises `TypeError` during pickling regardless of protocol",
            "The `pickle` module requires a `__repr__` method on every class before it can serialise instances",
            "`__slots__` is incompatible with `super().__init__()` calls in subclasses"
        ),
        answerIndex = 0,
        explanation = "When a class uses `__slots__` without defining `__getstate__`, Python's default pickle protocol captures only `__dict__` (empty for slotted classes) and silently skips slot values. `Point`'s `x` and `y` are also slots and would be lost, but because `ColorPoint` inherits from `Point` which has no `__dict__`, the round-trip raises `AttributeError` on `cp2.color`. The fix is to add `__getstate__ = lambda self: {s: getattr(self, s) for s in (*Point.__slots__, *ColorPoint.__slots__)}` and a matching `__setstate__`."
    ),
    Problem(
        id = "output_hard_35",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "asyncio gather exception propagation",
        summary = "One coroutine raises; the other completes. What does gather return?",
        prompt = "What is printed when this script runs?",
        code = """
            import asyncio

            async def ok():
                return 42

            async def fail():
                raise ValueError("boom")

            async def main():
                try:
                    results = await asyncio.gather(ok(), fail())
                    print(results)
                except ValueError as e:
                    print(f"caught: {e}")

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "caught: boom",
            "[42, ValueError('boom')]",
            "[42]",
            "Nothing is printed; the process exits with a non-zero code"
        ),
        answerIndex = 0,
        explanation = "By default, `asyncio.gather` propagates the first exception it encounters: it cancels the remaining awaitables and re-raises the exception to the caller. The `try/except` block catches the `ValueError`, printing `caught: boom`. To collect all results (including exceptions as values), pass `return_exceptions=True`."
    ),
    Problem(
        id = "purpose_hard_35",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager as a two-phase setup",
        summary = "A generator-based context manager splits setup and teardown.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            from contextlib import contextmanager
            import tempfile, os

            @contextmanager
            def temp_directory():
                path = tempfile.mkdtemp()
                try:
                    yield path
                finally:
                    import shutil
                    shutil.rmtree(path, ignore_errors=True)

            with temp_directory() as d:
                open(os.path.join(d, "data.txt"), "w").write("hi")
        """.trimIndent(),
        options = listOf(
            "Create a temporary directory for use inside the `with` block and unconditionally delete it — including its contents — when the block exits, even if an exception is raised",
            "Create a permanent scratch directory and log its path for later cleanup by a separate maintenance job",
            "Cache the directory path so repeated `with temp_directory()` calls reuse the same folder",
            "Wrap the directory creation in a transaction that rolls back if any write inside the block fails"
        ),
        answerIndex = 0,
        explanation = "`@contextmanager` turns a generator function into a context manager. Code before `yield` runs on `__enter__`, and the `yield` value is bound by `as`. Code in `finally` runs on `__exit__` regardless of exceptions. Here, `mkdtemp()` creates a unique directory that is unconditionally removed by `shutil.rmtree` when the `with` block ends — whether normally or via exception."
    ),
    Problem(
        id = "fill_hard_35",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Protocol for structural subtyping",
        summary = "Choose the correct base so static type checkers accept duck-typed classes.",
        prompt = "Which import fills the blank so that `Drawable` acts as a structural interface (duck-typing protocol) recognised by mypy and pyright?",
        code = """
            from typing import ___

            class Drawable(___):
                def draw(self) -> None: ...

            class Circle:
                def draw(self) -> None:
                    print("O")

            def render(obj: Drawable) -> None:
                obj.draw()

            render(Circle())  # should type-check without Circle inheriting Drawable
        """.trimIndent(),
        options = listOf(
            "Protocol",
            "ABC",
            "TypeVar",
            "Generic"
        ),
        answerIndex = 0,
        explanation = "`typing.Protocol` (PEP 544) enables *structural subtyping*: any class that implements the required methods is considered a subtype without needing to explicitly inherit from the protocol. `ABC` requires explicit registration or inheritance. `TypeVar` and `Generic` are unrelated to interface definition. With `class Drawable(Protocol)`, mypy accepts `Circle` as a valid `Drawable` because `Circle` has a compatible `draw` method."
    ),
    Problem(
        id = "order_hard_34",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Binary search on a sorted list",
        summary = "Arrange an iterative binary search implementation in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def binary_search(arr, target):",
            "    lo, hi = 0, len(arr) - 1",
            "    while lo <= hi:",
            "        mid = (lo + hi) // 2",
            "        if arr[mid] == target:",
            "            return mid",
            "        elif arr[mid] < target:",
            "            lo = mid + 1",
            "        else:",
            "            hi = mid - 1",
            "    return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Binary search maintains a [lo, hi] window. Each iteration computes the midpoint and compares `arr[mid]` to the target. If equal, the index is returned immediately. If the target is larger, the left half is discarded by setting `lo = mid + 1`. If smaller, the right half is discarded with `hi = mid - 1`. When `lo > hi`, the target is absent and `-1` is returned."
    ),
    Problem(
        id = "complexity_hard_34",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive tree traversal with set membership",
        summary = "Determine the overall complexity when visited tracking uses a set.",
        prompt = "What is the time complexity of `dfs(graph, start)` where `graph` has V nodes and E edges?",
        code = """
            def dfs(graph, start):
                visited = set()
                stack = [start]
                while stack:
                    node = stack.pop()
                    if node in visited:
                        continue
                    visited.add(node)
                    for neighbour in graph[node]:
                        stack.append(neighbour)
        """.trimIndent(),
        options = listOf("O(V + E)", "O(V²)", "O(E log V)", "O(V log V)"),
        answerIndex = 0,
        explanation = "Each node is added to `visited` at most once (O(V) total). Each edge is examined at most twice — once when pushing the neighbour and once when the neighbour is popped and found already visited (O(E) total). `set` membership and insertion are O(1) average. Overall: O(V + E), the standard DFS bound for adjacency-list graphs."
    ),
    Problem(
        id = "trace_hard_34",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "ChainMap lookup and write semantics",
        summary = "Track which underlying dict is mutated after a ChainMap write.",
        prompt = "What does `defaults['color']` equal after this code runs?",
        code = """
            from collections import ChainMap

            defaults = {'color': 'red', 'size': 10}
            overrides = {}
            config = ChainMap(overrides, defaults)

            config['color'] = 'blue'
            config['size'] = 20
        """.trimIndent(),
        options = listOf("'red'", "'blue'", "KeyError", "20"),
        answerIndex = 0,
        explanation = "`ChainMap` reads from maps in order (first match wins) but always *writes* to the first map — `overrides` here. So `config['color'] = 'blue'` and `config['size'] = 20` both go into `overrides`, leaving `defaults` unchanged. `defaults['color']` is still `'red'`. Reads via `config['color']` would return `'blue'` because `overrides` is checked first."
    ),
    Problem(
        id = "match_hard_34",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\nTrue\nFalse",
        summary = "Pick the snippet that prints exactly True then False.",
        prompt = "Which code prints exactly `True` on line 1 and `False` on line 2?",
        code = "True\nFalse",
        options = listOf(
            "x = [1, 2]; y = x[:]; print(x == y); print(x is y)",
            "x = [1, 2]; y = x; print(x == y); print(x is y)",
            "x = (1, 2); y = (1, 2); print(x is y); print(x == y)",
            "x = 256; y = 256; print(x is y); print(x == y)"
        ),
        answerIndex = 0,
        explanation = "`y = x[:]` creates a *shallow copy* of the list. The two lists are equal by value (`x == y` is `True`) but are different objects in memory (`x is y` is `False`). Option B uses `y = x`, so both names point to the same object — `is` returns `True`. Options C and D involve CPython small-integer and tuple interning, which makes `is` behave unreliably across implementations."
    )
)
