package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 28.
// One senior-level problem per problem type.
val hardProblems28 = listOf(
    Problem(
        id = "bug_hard_29",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__eq__ without __hash__",
        summary = "A custom class overrides equality but breaks set/dict usage.",
        prompt = "What silent bug does this class introduce?",
        code = """
            class Point:
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

                def __eq__(self, other):
                    return self.x == other.x and self.y == other.y

            p1 = Point(1, 2)
            p2 = Point(1, 2)
            seen = {p1}
            print(p2 in seen)
        """.trimIndent(),
        options = listOf(
            "Defining `__eq__` sets `__hash__` to None, making Point unhashable and unusable in sets or as dict keys",
            "`__eq__` must call `super().__eq__` or it raises RecursionError",
            "The set literal `{p1}` creates a set with one element; `p2 in seen` always returns False for any new instance",
            "Instance attributes cannot be compared with `==`; you must use `is`"
        ),
        answerIndex = 0,
        explanation = "In Python 3, defining `__eq__` without `__hash__` implicitly sets `__hash__ = None`. The class becomes unhashable, so `{p1}` raises `TypeError: unhashable type: 'Point'`. The fix is to also define `__hash__` (e.g., `return hash((self.x, self.y))`)."
    ),
    Problem(
        id = "output_hard_29",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO and super() chain",
        summary = "Cooperative multiple inheritance calls each __init__ once via MRO.",
        prompt = "What does this code print?",
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
            "D\nB\nA",
            "D\nC\nB\nA"
        ),
        answerIndex = 0,
        explanation = "Python's MRO for D is [D, B, C, A, object]. Each `super().__init__()` delegates to the *next class in the MRO*, not to the direct parent. So D→B→C→A each prints once, and `A`'s `super().__init__()` calls `object.__init__()` which is silent."
    ),
    Problem(
        id = "purpose_hard_29",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Lazy attribute via __get__",
        summary = "A descriptor computes and caches a value on first access.",
        prompt = "What is the primary purpose of this descriptor?",
        code = """
            class lazy_property:
                def __init__(self, func):
                    self.func = func
                    self.attr = func.__name__

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    value = self.func(obj)
                    setattr(obj, self.attr, value)
                    return value
        """.trimIndent(),
        options = listOf(
            "Compute an expensive attribute once and cache the result directly on the instance, bypassing the descriptor on subsequent access",
            "Prevent the attribute from being set after the first read by making it read-only",
            "Forward attribute access to a parent class transparently without caching",
            "Validate the return value of the function before storing it on the instance"
        ),
        answerIndex = 0,
        explanation = "On first access `__get__` calls `self.func(obj)`, then uses `setattr` to write the result directly onto the instance's `__dict__`. Because instance `__dict__` entries shadow non-data descriptors, subsequent accesses hit the cached value directly without calling `__get__` again."
    ),
    Problem(
        id = "fill_hard_29",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "asyncio gather concurrency",
        summary = "Running multiple coroutines concurrently and collecting results.",
        prompt = "Which function fills the blank to run both coroutines concurrently and return their results as a list?",
        code = """
            import asyncio

            async def fetch(url):
                await asyncio.sleep(0)
                return url

            async def main():
                results = await asyncio.___(
                    fetch("https://a.example"),
                    fetch("https://b.example"),
                )
                print(results)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf("gather", "wait", "create_task", "run_coroutine_threadsafe"),
        answerIndex = 0,
        explanation = "`asyncio.gather(*coros)` schedules all coroutines concurrently and returns a list of their results in the same order they were passed. `asyncio.wait` returns sets of futures and requires explicit result extraction. `create_task` schedules a single coroutine. `run_coroutine_threadsafe` is for cross-thread use."
    ),
    Problem(
        id = "order_hard_28",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge sort",
        summary = "Arrange a correct recursive merge sort implementation in source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sort(arr):",
            "    if len(arr) <= 1:",
            "        return arr",
            "    mid = len(arr) // 2",
            "    left = merge_sort(arr[:mid])",
            "    right = merge_sort(arr[mid:])",
            "    result = []",
            "    i = j = 0",
            "    while i < len(left) and j < len(right):",
            "        if left[i] <= right[j]:",
            "            result.append(left[i]); i += 1",
            "        else:",
            "            result.append(right[j]); j += 1",
            "    return result + left[i:] + right[j:]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
        explanation = "Merge sort: base case for length ≤ 1, split at the midpoint, recursively sort each half, then merge by comparing front elements until one side is exhausted, and append any remaining elements."
    ),
    Problem(
        id = "complexity_hard_28",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loop with shrinking inner bound",
        summary = "The inner loop iterates over a slice that shrinks logarithmically.",
        prompt = "What is the time complexity of `process`?",
        code = """
            def process(data):
                n = len(data)
                result = []
                i = 1
                while i < n:
                    for j in range(i):
                        result.append(data[j])
                    i *= 2
                return result
        """.trimIndent(),
        options = listOf("O(n)", "O(n log n)", "O(n^2)", "O(log n)"),
        answerIndex = 0,
        explanation = "The outer loop runs log₂(n) times (i = 1, 2, 4, …, n). The inner loop runs i iterations each time: 1 + 2 + 4 + … + n/2 = n − 1 total iterations, which is O(n). The geometric series converges to O(n), not O(n log n)."
    ),
    Problem(
        id = "trace_hard_28",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable vs instance variable",
        summary = "Augmented assignment on a class variable creates an instance variable instead of mutating the class.",
        prompt = "What is `B.count` after this code runs?",
        code = """
            class B:
                count = 0

                def increment(self):
                    self.count += 1

            b1 = B()
            b2 = B()
            b1.increment()
            b1.increment()
            b2.increment()
        """.trimIndent(),
        options = listOf("0", "3", "2", "1"),
        answerIndex = 0,
        explanation = "`self.count += 1` is sugar for `self.count = self.count + 1`. The read of `self.count` falls through to the class variable (0), but the write creates a new *instance* variable on `self`. The class variable `B.count` is never modified, so it remains 0."
    ),
    Problem(
        id = "match_hard_28",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n[0, 1, 1, 2, 3, 5, 8]",
        summary = "Pick the snippet that produces the first 7 Fibonacci numbers as a list.",
        prompt = "Which code produces exactly `[0, 1, 1, 2, 3, 5, 8]`?",
        code = "[0, 1, 1, 2, 3, 5, 8]",
        options = listOf(
            "a, b, seq = 0, 1, []\nfor _ in range(7):\n    seq.append(a)\n    a, b = b, a + b\nprint(seq)",
            "seq = [0, 1]\nwhile len(seq) < 7:\n    seq.append(seq[-1] + seq[-2])\nprint(seq[1:])",
            "print([i for i in range(7)])",
            "a, b, seq = 1, 1, []\nfor _ in range(7):\n    seq.append(a)\n    a, b = b, a + b\nprint(seq)"
        ),
        answerIndex = 0,
        explanation = "Option A starts with a=0, b=1 and appends `a` before the swap, producing [0,1,1,2,3,5,8]. Option B starts with [0,1] then appends sums correctly, but `print(seq[1:])` omits the leading 0, giving [1,1,2,3,5,8]. Option C prints [0,1,2,3,4,5,6]. Option D starts at a=1, giving [1,1,2,3,5,8,13]."
    )
)
