package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 25.
// One senior-level problem per problem type.
val hardProblems25 = listOf(
    Problem(
        id = "bug_hard_26",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread-unsafe singleton",
        summary = "A double-checked locking pattern is broken without a memory fence.",
        prompt = "What is the real bug in this code?",
        code = """
            import threading

            class Singleton:
                _instance = None
                _lock = threading.Lock()

                @classmethod
                def get(cls):
                    if cls._instance is None:
                        with cls._lock:
                            cls._instance = cls()
                    return cls._instance
        """.trimIndent(),
        options = listOf(
            "The outer `None` check runs without the lock, so two threads can both pass it and race to create the instance",
            "`threading.Lock` cannot be a class variable; it must live inside `__init__`",
            "The `@classmethod` decorator prevents `cls()` from calling `__init__`",
            "Returning `cls._instance` outside the `with` block raises `RuntimeError`"
        ),
        answerIndex = 0,
        explanation = "Classic double-checked locking: the outer `if cls._instance is None` guard is unsynchronized, so two threads can both see `None` simultaneously. Thread A creates the instance, releases the lock, then Thread B re-enters the lock and creates a second instance, discarding Thread A's. The fix is to also check `_instance` again *inside* the lock."
    ),
    Problem(
        id = "output_hard_26",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in a loop",
        summary = "All closures capture the same loop variable by reference.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(3)]
            print(funcs[0](), funcs[1](), funcs[2]())
        """.trimIndent(),
        options = listOf(
            "2 2 2",
            "0 1 2",
            "0 0 0",
            "It raises NameError"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variables by reference, not by value. After the loop `i` equals 2, so every lambda returns 2 when called."
    ),
    Problem(
        id = "purpose_hard_26",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "LRU cache eviction",
        summary = "A fixed-capacity mapping evicts the least-recently-used entry on overflow.",
        prompt = "What does this class implement?",
        code = """
            from collections import OrderedDict

            class LRUCache:
                def __init__(self, capacity):
                    self.cap = capacity
                    self.cache = OrderedDict()

                def get(self, key):
                    if key not in self.cache:
                        return -1
                    self.cache.move_to_end(key)
                    return self.cache[key]

                def put(self, key, value):
                    if key in self.cache:
                        self.cache.move_to_end(key)
                    self.cache[key] = value
                    if len(self.cache) > self.cap:
                        self.cache.popitem(last=False)
        """.trimIndent(),
        options = listOf(
            "An LRU (Least Recently Used) cache with O(1) get and put",
            "A FIFO queue that drops the oldest item when full",
            "A thread-safe bounded dictionary using a lock",
            "A write-through cache that persists every entry to disk"
        ),
        answerIndex = 0,
        explanation = "`move_to_end` marks an entry as most-recently-used. `popitem(last=False)` evicts the least-recently-used entry when the cache exceeds capacity, giving O(1) amortized get and put."
    ),
    Problem(
        id = "fill_hard_26",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with a lock",
        summary = "A shared counter must be incremented safely across threads.",
        prompt = "Which choice fills the blank so the counter is thread-safe?",
        code = """
            import threading

            counter = 0
            lock = threading.___()

            def increment():
                global counter
                with lock:
                    counter += 1
        """.trimIndent(),
        options = listOf(
            "Lock",
            "Semaphore",
            "Event",
            "Condition"
        ),
        answerIndex = 0,
        explanation = "`threading.Lock()` is a mutual-exclusion primitive. The `with lock:` block ensures only one thread increments `counter` at a time, preventing lost updates."
    ),
    Problem(
        id = "order_hard_25",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search implementation",
        summary = "Arrange a correct iterative binary search that returns the target index or -1.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def binary_search(nums, target):",
            "    lo, hi = 0, len(nums) - 1",
            "    while lo <= hi:",
            "        mid = (lo + hi) // 2",
            "        if nums[mid] == target:",
            "            return mid",
            "        elif nums[mid] < target:",
            "            lo = mid + 1",
            "        else:",
            "            hi = mid - 1",
            "    return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "The function sets up lo/hi bounds, loops while the search space is non-empty, computes the midpoint, and narrows the range based on the comparison before returning -1 if the target is absent."
    ),
    Problem(
        id = "complexity_hard_25",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive tree traversal with memoization",
        summary = "Each node is visited once; the memo prevents redundant recomputation.",
        prompt = "What is the time complexity of `count_paths` given a tree with `n` nodes?",
        code = """
            from functools import lru_cache

            def count_paths(graph, node, target, memo=None):
                if memo is None:
                    memo = {}
                if node in memo:
                    return memo[node]
                if node == target:
                    memo[node] = 1
                    return 1
                total = sum(
                    count_paths(graph, child, target, memo)
                    for child in graph.get(node, [])
                )
                memo[node] = total
                return total
        """.trimIndent(),
        options = listOf("O(n)", "O(n log n)", "O(n^2)", "O(2^n)"),
        answerIndex = 0,
        explanation = "With memoization each node is computed exactly once, and each edge is visited once when iterating over children. Total work is O(n + e) which for a tree (e = n-1) simplifies to O(n)."
    ),
    Problem(
        id = "trace_hard_25",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "MRO attribute resolution",
        summary = "Python's C3 linearisation picks which parent's attribute is found first.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            class A:
                val = 1

            class B(A):
                val = 2

            class C(A):
                val = 3

            class D(B, C):
                pass

            result = D.val
        """.trimIndent(),
        options = listOf(
            "2",
            "3",
            "1",
            "It raises AttributeError"
        ),
        answerIndex = 0,
        explanation = "Python's MRO for D is [D, B, C, A]. The search walks left to right and finds `val` on B first, so `D.val` is 2."
    ),
    Problem(
        id = "match_hard_25",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n[0, 1, 1, 2, 3]",
        summary = "Pick the snippet that prints exactly the first five Fibonacci numbers as a list.",
        prompt = "Which code produces exactly this output?",
        code = "[0, 1, 1, 2, 3]",
        options = listOf(
            "def fib(n):\n    a, b = 0, 1\n    result = []\n    for _ in range(n):\n        result.append(a)\n        a, b = b, a + b\n    return result\nprint(fib(5))",
            "print([i for i in range(5)])",
            "import math\nprint([math.factorial(i) for i in range(5)])",
            "a = 0\nb = 1\nfor _ in range(5):\n    print(a)\n    a, b = b, a + b"
        ),
        answerIndex = 0,
        explanation = "The iterative generator builds the list [0, 1, 1, 2, 3] by advancing (a, b) five times. Option B prints [0,1,2,3,4], option C prints factorials, and option D prints each number on a separate line instead of as a list."
    )
)
