package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 63.
// One senior-level problem per problem type.
val hardProblems63 = listOf(
    Problem(
        id = "bug_hard_64",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__slots__ rejects undeclared attributes",
        summary = "Assigning an attribute not listed in __slots__ raises AttributeError.",
        prompt = "What is the bug in this code?",
        code = """
            class Point:
                __slots__ = ('x', 'y')
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

            p = Point(1, 2)
            p.z = 3
            print(p.z)
        """.trimIndent(),
        options = listOf(
            "`__slots__` prevents adding attributes not listed in it; `p.z = 3` raises `AttributeError`",
            "`__slots__` is ignored after `__init__` runs, so `p.z = 3` silently creates a new slot",
            "`__slots__` must include `'__dict__'` for attribute assignment to work at all",
            "There is no bug; `__slots__` only restricts class-level attributes, not instance attributes"
        ),
        answerIndex = 0,
        explanation = "`__slots__` replaces the instance `__dict__` with a fixed set of descriptors. Any attempt to assign an attribute not named in `__slots__` raises `AttributeError: 'Point' object has no attribute 'z'`."
    ),
    Problem(
        id = "output_hard_64",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Class variable shared mutation",
        summary = "Appending to a class-level list via an instance mutates the shared list.",
        prompt = "What does this code print?",
        code = """
            class Bag:
                items = []
                def add(self, v):
                    self.items.append(v)

            a = Bag()
            b = Bag()
            a.add(1)
            b.add(2)
            print(a.items)
        """.trimIndent(),
        options = listOf(
            "[1]",
            "[1, 2]",
            "[2]",
            "AttributeError"
        ),
        answerIndex = 1,
        explanation = "`items` is a class variable. Both `a` and `b` refer to the same list object. `a.add(1)` and `b.add(2)` both mutate it, so `a.items` is `[1, 2]`."
    ),
    Problem(
        id = "purpose_hard_64",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Thread-safe counter with a lock",
        summary = "A class wraps an integer and a Lock to allow safe concurrent increments.",
        prompt = "What does this class do?",
        code = """
            import threading

            class Counter:
                def __init__(self):
                    self._val = 0
                    self._lock = threading.Lock()

                def increment(self):
                    with self._lock:
                        self._val += 1

                def value(self):
                    with self._lock:
                        return self._val
        """.trimIndent(),
        options = listOf(
            "Prevents any thread from reading `_val` while another thread is writing to a shared log file",
            "Provides a thread-safe integer whose reads and writes are serialised by a mutex",
            "Logs every increment atomically and raises RuntimeError when the lock is already held by the caller",
            "Limits the counter to a maximum value and signals waiting threads when the limit is reached"
        ),
        answerIndex = 1,
        explanation = "The lock serialises both `increment` and `value`, so no two threads can read or write `_val` simultaneously. This makes all operations on the counter race-free, not just writes."
    ),
    Problem(
        id = "fill_hard_64",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.reduce for product",
        summary = "Use reduce to multiply all elements in a list.",
        prompt = "Fill the blank so `result` holds the product of all numbers.",
        code = """
            from functools import reduce
            import operator

            nums = [2, 3, 4, 5]
            result = reduce(___, nums)
            print(result)   # 120
        """.trimIndent(),
        options = listOf(
            "operator.add",
            "operator.mul",
            "lambda a, b: a * b + 0",
            "sum"
        ),
        answerIndex = 1,
        explanation = "`operator.mul` is the two-argument multiplication function. `reduce(operator.mul, [2,3,4,5])` computes ((2*3)*4)*5 = 120. `operator.add` would sum instead. The lambda would also work but is not the blank's expected fill."
    ),
    Problem(
        id = "order_hard_63",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search",
        summary = "Arrange the lines of an iterative binary search into the correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "lo, hi = 0, len(arr) - 1",
            "    mid = (lo + hi) // 2",
            "while lo <= hi:",
            "    if arr[mid] == target: return mid",
            "    elif arr[mid] < target: lo = mid + 1",
            "    else: hi = mid - 1",
            "return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 2, 1, 3, 4, 5, 6),
        explanation = "Initialise the bounds, enter the while loop, compute mid, check equality, then narrow the search window left or right. Return -1 only if the loop exits without a match."
    ),
    Problem(
        id = "complexity_hard_63",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Two-pointer deduplication",
        summary = "In-place removal of duplicates from a sorted list using two pointers.",
        prompt = "What is the time and space complexity of this algorithm?",
        code = """
            def dedupe(arr):
                if not arr:
                    return 0
                write = 1
                for read in range(1, len(arr)):
                    if arr[read] != arr[write - 1]:
                        arr[write] = arr[read]
                        write += 1
                return write
        """.trimIndent(),
        options = listOf(
            "O(n log n) time, O(1) space",
            "O(n) time, O(1) space",
            "O(n) time, O(n) space",
            "O(n²) time, O(1) space"
        ),
        answerIndex = 1,
        explanation = "The single `for` loop visits each element once, giving O(n) time. The two-pointer technique mutates the array in-place with only `write` and `read` as extra state, so space is O(1)."
    ),
    Problem(
        id = "trace_hard_63",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "nonlocal rebind across calls",
        summary = "A counter factory uses nonlocal; trace the value after two separate counter calls.",
        prompt = "What does this code print?",
        code = """
            def make_counter():
                count = 0
                def inc():
                    nonlocal count
                    count += 1
                    return count
                return inc

            c1 = make_counter()
            c2 = make_counter()
            c1()
            c1()
            c2()
            print(c1(), c2())
        """.trimIndent(),
        options = listOf(
            "2 1",
            "3 2",
            "3 1",
            "2 2"
        ),
        answerIndex = 1,
        explanation = "`c1` and `c2` each close over their own independent `count` variable. Before the print: c1 has been called twice (count=2), c2 once (count=1). The print statement itself calls both: c1() increments to 3, c2() increments to 2. Output is `3 2`."
    ),
    Problem(
        id = "match_hard_63",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: defaultdict result",
        summary = "Pick the snippet that prints exactly `defaultdict(<class 'int'>, {'a': 3})`.",
        prompt = "Which code produces that output?",
        code = "defaultdict(<class 'int'>, {'a': 3})",
        options = listOf(
            "from collections import defaultdict\nd = defaultdict(int)\nd['a'] += 1\nd['a'] += 2\nprint(d)",
            "from collections import defaultdict\nd = defaultdict(int)\nd['a'] = 3\ndel d['a']\nprint(d)",
            "from collections import Counter\nd = Counter('aaa')\nprint(d)",
            "from collections import defaultdict\nd = defaultdict(list)\nd['a'].extend([1,2,3])\nprint(d)"
        ),
        answerIndex = 0,
        explanation = "Two increments of 1 and 2 on `d['a']` sum to 3, giving `defaultdict(<class 'int'>, {'a': 3})`. Option B deletes the key, leaving an empty dict. Option C prints a `Counter`, not a `defaultdict`. Option D uses `defaultdict(list)` and stores a list, not an int."
    )
)
