package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems — batch 8. One problem per type.
// All problems target senior developers with 5+ years of Python experience.
val hardProblems8 = listOf(

    // ── FIND_BUG ──────────────────────────────────────────────────────────────

    Problem(
        id = "bug_hard_8",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor cache leaks across instances",
        summary = "A descriptor caches method results, but the cache is shared across every instance.",
        prompt = "The developer expects `a.scale(5)` to print `10` and `b.scale(5)` to print `15`, but both calls print `10`. What is the bug?",
        code = """
            class CachedMethod:
                def __init__(self, fn):
                    self.fn = fn
                    self.cache = {}

                def __get__(self, obj, objtype=None):
                    def wrapper(*args):
                        if args not in self.cache:
                            self.cache[args] = self.fn(obj, *args)
                        return self.cache[args]
                    return wrapper

            class Multiplier:
                def __init__(self, factor):
                    self.factor = factor

                @CachedMethod
                def scale(self, value):
                    return self.factor * value

            a = Multiplier(2)
            b = Multiplier(3)
            print(a.scale(5))
            print(b.scale(5))
        """.trimIndent(),
        options = listOf(
            "The descriptor instance is shared on the class, and its cache key ignores `obj`, so one instance reuses another instance's result",
            "`self.fn(obj, *args)` creates a fresh bound method each time, so caching can never work",
            "Descriptors only run for reads on the class, not for calls through an instance",
            "The `wrapper` closure copies `args`, so cached values are always recomputed"
        ),
        answerIndex = 0,
        explanation = "The `CachedMethod` object lives once on `Multiplier.scale`, so every `Multiplier` instance shares the same `self.cache`. Because the cache key is only `args`, `a.scale(5)` stores the result under `(5,)`, and `b.scale(5)` reuses that cached `10` instead of computing `15`. Include `obj` (or an instance-specific key) in the cache key, or store the cache on each instance."
    ),

    // ── OUTPUT ────────────────────────────────────────────────────────────────

    Problem(
        id = "output_hard_8",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ on class vs instance",
        summary = "A data descriptor is accessed on both the class and an instance.",
        prompt = "What does this script print?",
        code = """
            class Validator:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.name, 0)

                def __set__(self, obj, value):
                    obj.__dict__[self.name] = max(0, value)

            class Account:
                balance = Validator()

            a = Account()
            a.balance = -50
            print(a.balance)
            print(type(Account.balance).__name__)
        """.trimIndent(),
        options = listOf(
            "0\nValidator",
            "-50\nValidator",
            "0\nint",
            "AttributeError"
        ),
        answerIndex = 0,
        explanation = "`__set__` clamps the value to `max(0, -50) = 0`, stored in `obj.__dict__['balance']`. `__get__` on an instance returns `obj.__dict__.get('balance', 0)` → `0`. Accessing `Account.balance` calls `__get__` with `obj=None`, which returns the descriptor object itself — a `Validator` instance — so `type(Account.balance).__name__` is `'Validator'`."
    ),

    // ── PURPOSE ───────────────────────────────────────────────────────────────

    Problem(
        id = "purpose_hard_8",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager teardown",
        summary = "A generator-based context manager wraps resource setup and teardown.",
        prompt = "What problem does this pattern solve compared to a plain try/finally block in user code?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def managed_connection(url):
                conn = connect(url)
                try:
                    yield conn
                finally:
                    conn.close()

            with managed_connection("db://host/db") as conn:
                conn.execute("SELECT 1")
        """.trimIndent(),
        options = listOf(
            "Encapsulates setup and teardown in one reusable place so callers cannot accidentally forget cleanup",
            "Prevents the connection from being used outside the `with` block by raising an error if accessed later",
            "Runs `conn.close()` in a background thread so the caller is not blocked",
            "Retries the connection automatically if `connect` raises an exception"
        ),
        answerIndex = 0,
        explanation = "`@contextmanager` turns a generator into a context manager. Code before `yield` is setup; code after (in `finally`) is teardown. This packages the resource lifecycle into a single reusable unit, so every caller gets guaranteed cleanup without duplicating try/finally logic."
    ),

    // ── FILL_BLANK ────────────────────────────────────────────────────────────

    Problem(
        id = "fill_hard_8",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "LRU cache for recursive Fibonacci",
        summary = "Apply the correct decorator to memoize a recursive function.",
        prompt = "Fill the blank so that repeated sub-problems are computed only once, reducing the time complexity from O(2^n) to O(n).",
        code = """
            from functools import ___

            @___(maxsize=None)
            def fib(n):
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)

            print(fib(50))
        """.trimIndent(),
        options = listOf("lru_cache", "wraps", "partial", "reduce"),
        answerIndex = 0,
        explanation = "`functools.lru_cache(maxsize=None)` caches every result keyed by arguments. With caching, each unique `n` is computed exactly once and subsequent calls return immediately from the cache, reducing total work to O(n). `wraps` only copies metadata; `partial` binds arguments; `reduce` folds a sequence."
    ),

    // ── ORDER_STEPS ───────────────────────────────────────────────────────────

    Problem(
        id = "order_hard_3",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search implementation",
        summary = "Arrange the lines in source order to implement iterative binary search.",
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
        explanation = "Define the function, initialise lo/hi bounds, loop while the search space is non-empty, compute mid, return mid on a hit, narrow lo upward on a low miss, narrow hi downward on a high miss, and return -1 when the loop exits without a match."
    ),

    // ── COMPLEXITY ────────────────────────────────────────────────────────────

    Problem(
        id = "complexity_hard_3",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loop with shrinking inner range",
        summary = "The inner loop bound decreases as the outer counter grows.",
        prompt = "What is the time complexity of this function?",
        code = """
            def count_pairs(n):
                result = 0
                for i in range(n):
                    for j in range(i + 1, n):
                        result += 1
                return result
        """.trimIndent(),
        options = listOf(
            "O(n²) — the total iterations are n*(n-1)/2",
            "O(n log n) — the inner loop halves each time",
            "O(n) — the outer and inner loops share the same counter",
            "O(n³) — two nested loops always mean cubic growth"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs n times. The inner loop runs n-1, n-2, …, 0 iterations respectively. The total is the sum 0+1+…+(n-1) = n*(n-1)/2, which is Θ(n²). The shrinking inner range does not change the quadratic class — it only halves the constant."
    ),

    // ── TRACE_VAR ─────────────────────────────────────────────────────────────

    Problem(
        id = "trace_hard_3",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and yield expression",
        summary = "A generator uses `yield` as an expression and receives values via `send()`.",
        prompt = "What is the value of `result` after these three lines execute?",
        code = """
            def accumulator():
                total = 0
                while True:
                    value = yield total
                    if value is None:
                        break
                    total += value

            gen = accumulator()
            next(gen)          # prime the generator
            gen.send(10)
            result = gen.send(5)
        """.trimIndent(),
        options = listOf("15", "5", "10", "0"),
        answerIndex = 0,
        explanation = "`next(gen)` runs until the first `yield total`, suspending with `total=0` (the yielded value is discarded). `gen.send(10)` resumes, sets `value=10`, `total` becomes 10, loops back, and yields 10. `gen.send(5)` resumes, sets `value=5`, `total` becomes 15, loops back, and yields 15. `result` captures that yielded value: 15."
    ),

    // ── OUTPUT (additional) ───────────────────────────────────────────────────

    Problem(
        id = "match_hard_3",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__missing__ on a dict subclass",
        summary = "A dict subclass implements __missing__ to auto-insert computed defaults.",
        prompt = "What does this code print?",
        code = """
            class AutoDict(dict):
                def __missing__(self, key):
                    self[key] = key * 2
                    return self[key]

            d = AutoDict()
            print(d[3])
            print(d[3])
            print(d[5])
            print(len(d))
        """.trimIndent(),
        options = listOf(
            "6\n6\n10\n2",
            "6\n6\n10\n3",
            "6\nKeyError\n10\n1",
            "None\nNone\nNone\n0"
        ),
        answerIndex = 0,
        explanation = "`__missing__` is called by `dict.__getitem__` only when the key is absent. On `d[3]`, `__missing__` fires, stores `3*2=6` under key `3`, and returns 6. On the second `d[3]`, the key now exists so `__missing__` is not called — returns the cached 6. `d[5]` fires `__missing__`, stores 10, returns 10. Two keys (3 and 5) were inserted, so `len(d)` is 2."
    )
)
