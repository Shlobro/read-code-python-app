package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 38.
// One senior-level problem per problem type.
val hardProblems38 = listOf(
    Problem(
        id = "bug_hard_39",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__slots__ breaks pickle across subclasses",
        summary = "A class with __slots__ fails to unpickle when a subclass also defines __slots__.",
        prompt = "Why does pickling `child` raise a `TypeError` about `__reduce_ex__`?",
        code = """
            import pickle

            class Base:
                __slots__ = ('x',)
                def __init__(self, x):
                    self.x = x

            class Child(Base):
                __slots__ = ('y',)
                def __init__(self, x, y):
                    super().__init__(x)
                    self.y = y

            child = Child(1, 2)
            data = pickle.dumps(child)
            obj = pickle.loads(data)
        """.trimIndent(),
        options = listOf(
            "Neither `Base` nor `Child` defines `__dict__`, so the default pickle protocol cannot find a `__getstate__`/`__setstate__` pair to serialise slot values — `__reduce_ex__` falls back to a path that requires `__dict__`",
            "`pickle` never supports classes that use `__slots__`; you must use `json` instead",
            "The `super().__init__` call inside `Child.__init__` prevents the MRO from being pickled",
            "`pickle.dumps` only works on classes defined at module top level, not nested under other classes"
        ),
        answerIndex = 0,
        explanation = "When a class uses `__slots__` and has no `__dict__` (because no ancestor omits `__slots__`), the default pickle machinery cannot find slot values via `__dict__`. The fix is to add `__getstate__` and `__setstate__` methods that explicitly collect and restore slot values, or to leave `__dict__` available by omitting `__slots__` from at least one level of the hierarchy."
    ),
    Problem(
        id = "output_hard_39",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO diamond with cooperative super()",
        summary = "Method Resolution Order determines which __init__ runs and in what order.",
        prompt = "What is printed when this module-level code runs?",
        code = """
            class A:
                def __init__(self):
                    print("A")
                    super().__init__()

            class B(A):
                def __init__(self):
                    print("B")
                    super().__init__()

            class C(A):
                def __init__(self):
                    print("C")
                    super().__init__()

            class D(B, C):
                def __init__(self):
                    print("D")
                    super().__init__()

            D()
        """.trimIndent(),
        options = listOf(
            "D\nB\nC\nA",
            "D\nB\nA\nC\nA",
            "D\nC\nB\nA",
            "D\nB\nA"
        ),
        answerIndex = 0,
        explanation = "Python's C3 linearisation gives `D` the MRO `[D, B, C, A, object]`. Each `super().__init__()` call dispatches to the *next* class in that MRO, not to the immediate parent. So `D.__init__` → prints 'D', calls `super()` → `B.__init__` → prints 'B', calls `super()` → `C.__init__` → prints 'C', calls `super()` → `A.__init__` → prints 'A', calls `super()` → `object.__init__`. `A.__init__` runs exactly once because cooperative `super()` follows the shared MRO rather than each class's individual parent chain."
    ),
    Problem(
        id = "purpose_hard_39",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Proxy object via __getattr__ delegation",
        summary = "A wrapper class that transparently forwards attribute access to an inner object.",
        prompt = "What is the primary purpose of this class?",
        code = """
            class ReadOnlyProxy:
                def __init__(self, target):
                    object.__setattr__(self, '_target', target)

                def __getattr__(self, name):
                    return getattr(object.__getattribute__(self, '_target'), name)

                def __setattr__(self, name, value):
                    raise AttributeError("read-only proxy")
        """.trimIndent(),
        options = listOf(
            "Wrap an object so its attributes can be read but not written through the proxy",
            "Cache all attribute reads on the wrapped object to avoid repeated lookups",
            "Lazily initialise the target object on first attribute access",
            "Log every attribute access on the target object without modifying it"
        ),
        answerIndex = 0,
        explanation = "`__setattr__` unconditionally raises `AttributeError`, preventing any attribute assignment through the proxy. `__getattr__` is called only when normal lookup fails, and it delegates to `getattr` on the stored `_target`. `object.__setattr__` and `object.__getattribute__` are used directly during `__init__` to bypass the overridden `__setattr__` and avoid infinite recursion, allowing `_target` itself to be stored on the proxy instance."
    ),
    Problem(
        id = "fill_hard_39",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "asyncio.gather with return_exceptions",
        summary = "Collect results from multiple coroutines, capturing errors as values.",
        prompt = "Which argument fills the blank so that exceptions from individual tasks are returned as values rather than re-raised?",
        code = """
            import asyncio

            async def may_fail(n):
                if n == 0:
                    raise ValueError("zero")
                return n * 2

            async def main():
                results = await asyncio.gather(
                    may_fail(1),
                    may_fail(0),
                    may_fail(3),
                    ___=True,
                )
                print(results)

            asyncio.run(main())
            # [2, ValueError('zero'), 6]
        """.trimIndent(),
        options = listOf(
            "return_exceptions",
            "suppress_errors",
            "capture_exceptions",
            "ignore_errors"
        ),
        answerIndex = 0,
        explanation = "`asyncio.gather(*coros, return_exceptions=True)` runs all coroutines concurrently and, instead of propagating the first exception immediately, captures each exception as the corresponding result value. This lets callers inspect all outcomes — successes and failures — in a single pass. The default (`return_exceptions=False`) re-raises the first exception as soon as it occurs, cancelling the other tasks."
    ),
    Problem(
        id = "order_hard_38",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search on a sorted list",
        summary = "Arrange the steps of an iterative binary search in correct source order.",
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
        explanation = "Binary search keeps a `lo`/`hi` window and repeatedly narrows it by comparing the midpoint to the target. If `arr[mid] == target` the index is returned immediately. If the target is larger, the left half is discarded by advancing `lo`; if smaller, the right half is discarded by retreating `hi`. When `lo > hi` the target is absent and `-1` is returned."
    ),
    Problem(
        id = "complexity_hard_38",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive Fibonacci — time vs space",
        summary = "Analyse the time and space complexity of naive recursive Fibonacci.",
        prompt = "What are the time and space complexities of this `fib` function for input `n`?",
        code = """
            def fib(n):
                if n <= 1:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf(
            "Time O(2^n), Space O(n) — the call tree has ~2^n nodes but max recursion depth is n",
            "Time O(n^2), Space O(n^2) — each level of the tree adds n more calls",
            "Time O(2^n), Space O(2^n) — all call frames exist simultaneously",
            "Time O(n), Space O(n) — each subproblem is solved once on the way down"
        ),
        answerIndex = 0,
        explanation = "The recursion tree for `fib(n)` branches into two calls at each node, giving roughly `2^n` total nodes and therefore `O(2^n)` time. However, the *space* complexity is determined by the maximum call-stack depth at any one moment, not the total number of nodes. The deepest path from root to leaf is at most `n` frames (following the `fib(n-1)` branch all the way down), so the stack holds `O(n)` frames simultaneously. Memoisation or iteration reduces time to `O(n)` while keeping space `O(n)` or even `O(1)`."
    ),
    Problem(
        id = "trace_hard_38",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in a loop",
        summary = "Track what value a captured loop variable has when the lambda is called.",
        prompt = "What value does `funcs[0]()` return when called after the loop finishes?",
        code = """
            funcs = []
            for i in range(5):
                funcs.append(lambda: i)

            result = funcs[0]()
        """.trimIndent(),
        options = listOf("4", "0", "1", "5"),
        answerIndex = 0,
        explanation = "Python closures capture variables by *reference*, not by value. All five lambdas share the same `i` variable from the enclosing scope. After the loop, `i` is `4` (the last value assigned by `range(5)`). Calling any of the lambdas — including `funcs[0]()` — therefore returns `4`. The fix is to use a default argument to capture the current value: `lambda i=i: i`."
    ),
    Problem(
        id = "match_hard_38",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {1: 'a', 2: 'b', 3: 'c'}",
        summary = "Pick the snippet that produces a dict by zipping two sequences.",
        prompt = "Which code prints `{1: 'a', 2: 'b', 3: 'c'}`?",
        code = "{1: 'a', 2: 'b', 3: 'c'}",
        options = listOf(
            "print(dict(zip([1,2,3], ['a','b','c'])))",
            "print(dict(zip(['a','b','c'], [1,2,3])))",
            "print({v: k for k, v in zip([1,2,3], ['a','b','c'])})",
            "print({k: v for k, v in zip(['a','b','c'], [1,2,3])})"
        ),
        answerIndex = 0,
        explanation = "Option A zips `[1,2,3]` with `['a','b','c']`, producing pairs `(1,'a'), (2,'b'), (3,'c')`, which `dict()` turns into `{1: 'a', 2: 'b', 3: 'c'}`. Option B reverses the zip order, giving `{'a': 1, 'b': 2, 'c': 3}`. Option C swaps keys and values in the comprehension, also giving `{'a': 1, ...}`. Option D iterates with string keys first and integer values, giving `{'a': 1, 'b': 2, 'c': 3}`. Only option A produces integer keys mapped to string values."
    )
)
