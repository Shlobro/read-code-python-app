package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems — batch 10. One problem per type.
// All problems target senior developers with 5+ years of Python experience.
val hardProblems10 = listOf(

    // ── FIND_BUG ──────────────────────────────────────────────────────────────

    Problem(
        id = "bug_hard_10",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Cached singleton reinitialisation",
        summary = "A factory caches instances in `__new__`, but later constructions still mutate the shared object.",
        prompt = "The developer expects the first session's state to stay `primary`, but the final print shows `shadow`. What is the bug?",
        code = """
            class Session:
                _instances = {}

                def __new__(cls, name):
                    if name not in cls._instances:
                        cls._instances[name] = super().__new__(cls)
                    return cls._instances[name]

                def __init__(self, name):
                    self.name = name

            a = Session("primary")
            b = Session("primary")
            b.name = "shadow"
            print(a.name)
        """.trimIndent(),
        options = listOf(
            "`__new__` returns the same object for the same key, so `a` and `b` alias the same mutable instance",
            "`__init__` is skipped when `__new__` returns an existing object, so `b` is uninitialised",
            "Reassigning `b.name` only mutates the local variable `b`, not the shared object",
            "Instances cached in a class dictionary are copied on assignment, so `a` and `b` should diverge automatically"
        ),
        answerIndex = 0,
        explanation = "The cache in `__new__` makes `Session(\"primary\")` return the same object every time for that key, so `a is b` is true. Mutating `b.name` therefore mutates `a.name` as well. This pattern needs either immutable cached objects, guarded reinitialisation, or a different factory boundary so callers do not accidentally share mutable session state."
    ),

    // ── OUTPUT ────────────────────────────────────────────────────────────────

    Problem(
        id = "output_hard_10",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__getattr__ vs __getattribute__ dispatch",
        summary = "Predict what is printed when attribute lookup falls through __getattribute__ to __getattr__.",
        prompt = "What does this script print?",
        code = """
            class Proxy:
                def __init__(self, data):
                    object.__setattr__(self, '_data', data)

                def __getattribute__(self, name):
                    if name.startswith('_'):
                        return object.__getattribute__(self, name)
                    raise AttributeError(name)

                def __getattr__(self, name):
                    return self._data.get(name, 'missing')

            p = Proxy({'x': 42})
            print(p.x)
            print(p.y)
        """.trimIndent(),
        options = listOf(
            "42\nmissing",
            "42\nAttributeError",
            "AttributeError\nmissing",
            "missing\nmissing"
        ),
        answerIndex = 0,
        explanation = "`__getattribute__` intercepts every attribute access. For non-underscore names it raises `AttributeError`, which causes Python to fall back to `__getattr__`. `__getattr__` then looks up the name in `self._data` (accessed via `object.__getattribute__` because the name starts with `_`). `p.x` returns `42` and `p.y` returns `'missing'`."
    ),

    // ── PURPOSE ───────────────────────────────────────────────────────────────

    Problem(
        id = "purpose_hard_10",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Narrow exception boundary with suppress",
        summary = "Only the optional parse step is allowed to fail quietly while the rest of the load still fails loudly.",
        prompt = "What problem does this pattern solve better than wrapping the whole function body in one broad `try/except ValueError`?",
        code = """
            import contextlib

            def load_config(lines):
                timeout = 30
                name = lines[0].strip()
                with contextlib.suppress(ValueError):
                    timeout = int(lines[1])
                enabled = lines[2].strip().lower() == "true"
                return name, timeout, enabled
        """.trimIndent(),
        options = listOf(
            "It limits the ignored `ValueError` to the optional timeout parse, so unrelated `ValueError`s elsewhere still surface instead of being swallowed",
            "It retries the timeout conversion until the string becomes numeric",
            "It converts any exception in `load_config` into the default timeout of `30`",
            "It guarantees `enabled` is always parsed before `name` to avoid partial state"
        ),
        answerIndex = 0,
        explanation = "The code intentionally tolerates a malformed timeout line and keeps the default of `30`, but it does not want to hide unrelated problems in the rest of the function. Scoping `contextlib.suppress(ValueError)` around only `int(lines[1])` makes that boundary explicit. A broad `try/except ValueError` around the whole function could also swallow unexpected parsing bugs from other lines."
    ),

    // ── FILL_BLANK ────────────────────────────────────────────────────────────

    Problem(
        id = "fill_hard_10",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Protocol structural subtyping",
        summary = "A function accepts any object that has a `draw` method, checked via a Protocol.",
        prompt = "Fill the blank so the type checker accepts any object with a `draw()` method without requiring explicit inheritance.",
        code = """
            from typing import ___

            class Drawable(___):
                def draw(self) -> None: ...

            def render(shape: Drawable) -> None:
                shape.draw()
        """.trimIndent(),
        options = listOf("Protocol", "ABC", "TypeVar", "Generic"),
        answerIndex = 0,
        explanation = "`typing.Protocol` enables structural subtyping (duck-typing checked at type-check time). Any class that implements `draw()` satisfies `Drawable` without explicitly inheriting from it, unlike `ABC` which requires explicit registration or inheritance."
    ),

    // ── ORDER_STEPS ───────────────────────────────────────────────────────────

    Problem(
        id = "order_hard_10",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache from scratch",
        summary = "Arrange the lines to implement a basic LRU cache using an OrderedDict.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import OrderedDict",
            "class LRUCache:",
            "    def __init__(self, capacity):",
            "        self.cap = capacity",
            "        self.cache = OrderedDict()",
            "    def get(self, key):",
            "        if key not in self.cache:",
            "            return -1",
            "        self.cache.move_to_end(key)",
            "        return self.cache[key]",
            "    def put(self, key, value):",
            "        if key in self.cache:",
            "            self.cache.move_to_end(key)",
            "        self.cache[key] = value",
            "        if len(self.cache) > self.cap:",
            "            self.cache.popitem(last=False)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "An LRU cache with `OrderedDict` works by moving accessed or updated keys to the end (most-recently-used end) and evicting from the front (least-recently-used end) via `popitem(last=False)` whenever capacity is exceeded."
    ),

    // ── COMPLEXITY ────────────────────────────────────────────────────────────

    Problem(
        id = "complexity_hard_10",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sliding window with a deque",
        summary = "A function computes the maximum of every k-element window in O(n) using a deque.",
        prompt = "What is the time complexity of `sliding_max` with respect to n = len(nums)?",
        code = """
            from collections import deque

            def sliding_max(nums, k):
                dq = deque()
                result = []
                for i, val in enumerate(nums):
                    while dq and nums[dq[-1]] <= val:
                        dq.pop()
                    dq.append(i)
                    if dq[0] <= i - k:
                        dq.popleft()
                    if i >= k - 1:
                        result.append(nums[dq[0]])
                return result
        """.trimIndent(),
        options = listOf(
            "O(n) — each element is pushed and popped from the deque at most once",
            "O(n·k) — the inner while loop runs up to k times for each element",
            "O(n log n) — the deque maintains a sorted structure like a heap",
            "O(k) — only the current window is kept in memory"
        ),
        answerIndex = 0,
        explanation = "Despite the nested `while` loop, each index is appended to the deque exactly once and removed at most once, giving O(n) total operations across the entire run. The inner loop does not execute k times per outer iteration on average — amortised, the total number of pops equals the total number of pushes, which is n."
    ),

    // ── TRACE_VAR ─────────────────────────────────────────────────────────────

    Problem(
        id = "trace_hard_10",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ dispatch",
        summary = "A data descriptor intercepts attribute access on a class and its instances.",
        prompt = "What is the value of `obj.value` after these lines execute?",
        code = """
            class Doubled:
                def __set_name__(self, owner, name):
                    self.attr = "_" + name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.attr, 0) * 2

                def __set__(self, obj, value):
                    setattr(obj, self.attr, value)

            class Box:
                value = Doubled()

            obj = Box()
            obj.value = 7
        """.trimIndent(),
        options = listOf("14", "7", "0", "AttributeError"),
        answerIndex = 0,
        explanation = "`Doubled.__set__` stores `7` in `obj._value`. When `obj.value` is read, `Doubled.__get__` retrieves `obj._value` (which is `7`) and multiplies by 2, returning `14`. The descriptor protocol intercepts both the write and the read transparently."
    ),

    // ── OUTPUT (additional) ───────────────────────────────────────────────────

    Problem(
        id = "match_hard_10",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "contextlib.suppress and exception flow",
        summary = "Predict which lines execute when suppress silences a specific exception.",
        prompt = "What does this code print?",
        code = """
            from contextlib import suppress

            results = []
            for i in range(3):
                with suppress(ValueError):
                    if i == 1:
                        raise ValueError("skip")
                    results.append(i)
            print(results)
        """.trimIndent(),
        options = listOf(
            "[0, 2]",
            "[0, 1, 2]",
            "[0]",
            "ValueError: skip"
        ),
        answerIndex = 0,
        explanation = "`suppress(ValueError)` silently swallows `ValueError` and continues to the next iteration. When `i=0`: no exception, 0 is appended. When `i=1`: `ValueError` is raised inside the `with` block; `suppress` catches it, the `append` is skipped, and the loop continues. When `i=2`: no exception, 2 is appended. Final result is `[0, 2]`."
    )
)
