package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 60.
// One senior-level problem per problem type.
val hardProblems60 = listOf(
    Problem(
        id = "bug_hard_61",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Mutable default argument mutation",
        summary = "A mutable default argument is shared across all calls that use the default.",
        prompt = "What is the bug in this code?",
        code = """
            def append_item(item, lst=[]):
                lst.append(item)
                return lst

            print(append_item(1))
            print(append_item(2))
        """.trimIndent(),
        options = listOf(
            "The default list `[]` is created once and shared, so the second call returns `[1, 2]` instead of `[2]`",
            "`lst.append` returns `None`, so both prints show `None`",
            "`item` shadows `lst` in the function body when both are passed",
            "Default arguments are re-evaluated on every call, causing `lst` to reset each time"
        ),
        answerIndex = 0,
        explanation = "Default argument values are evaluated once at function definition time, not at each call. The same list object is reused across calls that rely on the default. The fix is `def append_item(item, lst=None): if lst is None: lst = []`."
    ),
    Problem(
        id = "output_hard_61",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__slots__ and missing __dict__",
        summary = "A class using `__slots__` has no `__dict__`, so assigning an unlisted attribute raises AttributeError.",
        prompt = "What does this code print?",
        code = """
            class Point:
                __slots__ = ('x', 'y')

            p = Point()
            p.x = 1
            try:
                p.z = 3
            except AttributeError:
                print("no z")
            print(p.x)
        """.trimIndent(),
        options = listOf(
            "no z\n1",
            "1\nno z",
            "no z\nAttributeError",
            "1"
        ),
        answerIndex = 0,
        explanation = "`__slots__` restricts instances to only the named attributes. Setting `p.x = 1` works because `x` is in the slots. Setting `p.z = 3` raises `AttributeError` because `z` is not declared. The `try/except` prints `no z`, then `p.x` prints `1`."
    ),
    Problem(
        id = "purpose_hard_61",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Context manager with __enter__ / __exit__",
        summary = "A class implements the context-manager protocol to time a block of code.",
        prompt = "What does this class do?",
        code = """
            import time

            class Timer:
                def __enter__(self):
                    self.start = time.perf_counter()
                    return self

                def __exit__(self, *args):
                    self.elapsed = time.perf_counter() - self.start
        """.trimIndent(),
        options = listOf(
            "Records elapsed wall-clock time for a `with` block in `self.elapsed`",
            "Measures CPU time and raises `TimeoutError` if the block exceeds a threshold",
            "Retries the `with` block until it completes without raising an exception",
            "Logs the start and end timestamps of a `with` block to a file"
        ),
        answerIndex = 0,
        explanation = "`__enter__` captures the current high-resolution clock time. `__exit__` is called automatically when the `with` block finishes (normally or via exception) and stores the elapsed duration. No timeout or retry logic is present."
    ),
    Problem(
        id = "fill_hard_61",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.reduce for running product",
        summary = "Use `reduce` with a lambda to compute the product of all list elements.",
        prompt = "Fill the blank so `result` equals the product of all elements in `nums`.",
        code = """
            from functools import reduce

            nums = [2, 3, 4, 5]
            result = reduce(___, nums)
            print(result)  # 120
        """.trimIndent(),
        options = listOf(
            "lambda a, b: a * b",
            "lambda a, b: a + b",
            "lambda a, b: max(a, b)",
            "sum"
        ),
        answerIndex = 0,
        explanation = "`reduce(lambda a, b: a * b, nums)` repeatedly applies multiplication: ((2*3)*4)*5 = 120. `lambda a, b: a + b` sums instead. `max` finds the maximum. `sum` is a built-in that doesn't work as a two-argument reducer here."
    ),
    Problem(
        id = "order_hard_60",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search on a sorted list",
        summary = "Arrange the lines of a standard iterative binary search.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "lo, hi = 0, len(arr) - 1",
            "while lo <= hi:",
            "    mid = (lo + hi) // 2",
            "    if arr[mid] == target: return mid",
            "    elif arr[mid] < target: lo = mid + 1",
            "    else: hi = mid - 1",
            "return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Initialise the search range to the full array. Each iteration computes the midpoint and either returns it (match) or narrows the range by moving `lo` up or `hi` down. After the loop no match exists, so return -1."
    ),
    Problem(
        id = "complexity_hard_60",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "All permutations via backtracking",
        summary = "A recursive backtracker generates every permutation by swapping and recursing.",
        prompt = "What is the time complexity?",
        code = """
            def permutations(arr, start=0):
                if start == len(arr):
                    yield list(arr)
                    return
                for i in range(start, len(arr)):
                    arr[start], arr[i] = arr[i], arr[start]
                    yield from permutations(arr, start + 1)
                    arr[start], arr[i] = arr[i], arr[start]
        """.trimIndent(),
        options = listOf(
            "O(n * n!)",
            "O(n!)",
            "O(2^n)",
            "O(n^2)"
        ),
        answerIndex = 0,
        explanation = "There are n! permutations and each takes O(n) to copy into a list. The total work is therefore O(n * n!). The recursion tree itself has n! leaves and O(n) depth, confirming the O(n * n!) bound."
    ),
    Problem(
        id = "trace_hard_60",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable vs instance variable assignment",
        summary = "Assigning to an attribute on an instance creates an instance variable, leaving the class variable unchanged.",
        prompt = "What does this code print?",
        code = """
            class Counter:
                count = 0

            a = Counter()
            b = Counter()
            a.count += 1
            print(Counter.count, a.count, b.count)
        """.trimIndent(),
        options = listOf(
            "0 1 0",
            "1 1 1",
            "0 1 1",
            "1 1 0"
        ),
        answerIndex = 0,
        explanation = "`a.count += 1` reads `Counter.count` (0), adds 1, then assigns 1 to `a.count` as a new instance attribute. The class variable stays 0. `b.count` still finds the class variable (0) because no instance attribute was set on `b`."
    ),
    Problem(
        id = "match_hard_60",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 4, 9]",
        summary = "Pick the snippet whose output is exactly `[1, 4, 9]`.",
        prompt = "Which code produces this output?",
        code = "[1, 4, 9]",
        options = listOf(
            "print([x**2 for x in range(1,4)])",
            "print(list(map(lambda x: x*2, range(1,4))))",
            "print([x**2 for x in range(4)])",
            "print([x**2 for x in range(1,5)])"
        ),
        answerIndex = 0,
        explanation = "`[x**2 for x in range(1,4)]` squares 1, 2, 3 giving `[1, 4, 9]`. Option B doubles instead of squaring: `[2, 4, 6]`. Option C includes 0: `[0, 1, 4, 9]`. Option D includes 4²=16: `[1, 4, 9, 16]`."
    )
)
