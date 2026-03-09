package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 14.
// One senior-level problem per problem type.
val hardProblems14 = listOf(
    Problem(
        id = "bug_hard_15",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-bound loop variable",
        summary = "Callbacks created in a loop all read the same final loop value.",
        prompt = "What is the real bug in this code?",
        code = """
            callbacks = []
            for i in range(3):
                callbacks.append(lambda: i)

            results = [fn() for fn in callbacks]
            print(results)
        """.trimIndent(),
        options = listOf(
            "Each lambda closes over the same `i`, so they all use its final value",
            "Lambdas cannot be appended to a list in Python",
            "`range(3)` should be `range(1, 3)` to avoid an off-by-one error",
            "List comprehensions cannot call functions stored in variables"
        ),
        answerIndex = 0,
        explanation = "Closures capture the variable, not its value at each iteration. By the time the lambdas run, the loop has finished and `i` is 2 for all of them."
    ),
    Problem(
        id = "output_hard_15",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Cooperative multiple inheritance",
        summary = "Trace the `super()` chain through a diamond-shaped hierarchy.",
        prompt = "What does this script print?",
        code = """
            class A:
                def run(self):
                    print("A")

            class B(A):
                def run(self):
                    print("B")
                    super().run()

            class C(A):
                def run(self):
                    print("C")
                    super().run()

            class D(B, C):
                def run(self):
                    print("D")
                    super().run()

            D().run()
        """.trimIndent(),
        options = listOf(
            "D\nB\nC\nA",
            "D\nB\nA\nC",
            "D\nC\nB\nA",
            "D\nB\nC"
        ),
        answerIndex = 0,
        explanation = "The MRO for `D` is `D, B, C, A`. Each method prints its class name and then delegates once with `super()`, so the output follows that linearization."
    ),
    Problem(
        id = "purpose_hard_15",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Interval coalescing",
        summary = "The function rewrites sorted overlapping ranges into a minimal set.",
        prompt = "What does this function do overall?",
        code = """
            def merge_ranges(ranges):
                merged = []
                for start, end in sorted(ranges):
                    if not merged or start > merged[-1][1]:
                        merged.append([start, end])
                    else:
                        merged[-1][1] = max(merged[-1][1], end)
                return merged
        """.trimIndent(),
        options = listOf(
            "It merges overlapping intervals into non-overlapping ranges",
            "It removes duplicate intervals but keeps overlaps unchanged",
            "It computes the intersection shared by every interval",
            "It sorts intervals by length and drops the shortest ones"
        ),
        answerIndex = 0,
        explanation = "After sorting, the function either starts a new interval or extends the end of the current merged interval when an overlap is detected."
    ),
    Problem(
        id = "fill_hard_15",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Dataclass mutable default",
        summary = "The field should create a fresh list for each instance.",
        prompt = "Fill the blank so each `Job` gets its own `tags` list.",
        code = """
            from dataclasses import dataclass, field

            @dataclass
            class Job:
                name: str
                tags: list[str] = ___
        """.trimIndent(),
        options = listOf(
            "field(default_factory=list)",
            "field(default=list)",
            "[]",
            "list()"
        ),
        answerIndex = 0,
        explanation = "`field(default_factory=list)` creates a new list per instance. Using `[]` or `list()` as a class-level default would share one mutable list across instances."
    ),
    Problem(
        id = "order_hard_14",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search left boundary",
        summary = "Arrange the lines to return the first index where `target` could be inserted.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def lower_bound(values, target):",
            "    left = 0",
            "    right = len(values)",
            "    while left < right:",
            "        mid = (left + right) // 2",
            "        if values[mid] < target:",
            "            left = mid + 1",
            "        else:",
            "            right = mid",
            "    return left"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        explanation = "The algorithm keeps a half-open search range, moves `left` past values that are still too small, and tightens `right` otherwise until both pointers meet at the insertion point."
    ),
    Problem(
        id = "complexity_hard_14",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Heap build then drain",
        summary = "A heap is built once and then fully popped.",
        prompt = "What is the overall time complexity in terms of n?",
        code = """
            import heapq

            def consume(values):
                heapq.heapify(values)
                out = []
                while values:
                    out.append(heapq.heappop(values))
                return out
        """.trimIndent(),
        options = listOf("O(n log n)", "O(n)", "O(log n)", "O(n^2)"),
        answerIndex = 0,
        explanation = "`heapify` is O(n), but the loop performs `n` heap pops and each `heappop` is O(log n). That dominates the total cost, giving O(n log n)."
    ),
    Problem(
        id = "trace_hard_14",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Nonlocal state across closures",
        summary = "Track a captured counter that is mutated by repeated calls.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def make_counter():
                total = 0
                def inc(step):
                    nonlocal total
                    total += step
                    return total
                return inc

            counter = make_counter()
            counter(2)
            result = counter(5)
        """.trimIndent(),
        options = listOf("7", "5", "2", "0"),
        answerIndex = 0,
        explanation = "The closure keeps `total` alive between calls. After `counter(2)`, total is 2, and the next call adds 5 more, so `result` is 7."
    ),
    Problem(
        id = "match_hard_14",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [('a', 3), ('b', 2)]",
        summary = "Pick the snippet that counts characters with `collections.Counter`.",
        prompt = "Which code produces exactly `[('a', 3), ('b', 2)]`?",
        code = "",
        options = listOf(
            "from collections import Counter; counts = Counter('ababa'); print(sorted(counts.items()))",
            "from collections import Counter; counts = Counter('ababa'); print(counts.most_common(1))",
            "from collections import Counter; counts = Counter('ababa'); print(list(counts.elements()))",
            "from collections import Counter; counts = Counter({'a': 3, 'b': 2}); print(counts)"
        ),
        answerIndex = 0,
        explanation = "Counting `ababa` yields `a: 3` and `b: 2`, and `sorted(counts.items())` prints those key-count pairs as a list of tuples in key order."
    )
)
