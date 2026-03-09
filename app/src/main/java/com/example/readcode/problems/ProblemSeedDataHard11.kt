package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 11.
// One senior-level problem per problem type.
val hardProblems11 = listOf(
    Problem(
        id = "bug_hard_12",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Mutating a heap entry after push",
        summary = "A list stored inside a heap is mutated in place after insertion.",
        prompt = "Why can this code return tasks in the wrong priority order?",
        code = """
            import heapq

            tasks = []
            entry = [5, "ship release"]
            heapq.heappush(tasks, entry)
            entry[0] = 1
            print(heapq.heappop(tasks))
        """.trimIndent(),
        options = listOf(
            "Mutating an item after pushing it breaks the heap invariant because `heapq` does not re-heapify automatically",
            "`heappush` copies the list, so changing `entry[0]` cannot affect the stored value",
            "Heaps in Python require tuples, not lists, so the push is ignored",
            "`heappop` always returns the most recently inserted item rather than the smallest one"
        ),
        answerIndex = 0,
        explanation = "`heapq` assumes items already inside the heap do not change in a way that affects ordering. After `entry` is pushed, mutating its priority in place leaves the underlying array in an invalid heap state. If a task's priority needs to change, push a new entry or re-heapify explicitly."
    ),
    Problem(
        id = "output_hard_12",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Method resolution with `super()`",
        summary = "A diamond-shaped inheritance graph calls `super()` from each implementation.",
        prompt = "What does this script print?",
        code = """
            class A:
                def f(self):
                    return ["A"]

            class B(A):
                def f(self):
                    return ["B"] + super().f()

            class C(A):
                def f(self):
                    return ["C"] + super().f()

            class D(B, C):
                def f(self):
                    return ["D"] + super().f()

            print("".join(D().f()))
        """.trimIndent(),
        options = listOf("DBCA", "DBA", "DCA", "DCBA"),
        answerIndex = 0,
        explanation = "The MRO of `D` is `D, B, C, A`. Each method prepends its own marker and delegates with `super()`, so the final list is `['D', 'B', 'C', 'A']`, which joins to `DBCA`."
    ),
    Problem(
        id = "purpose_hard_12",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Snapshotting an iterator stream",
        summary = "`itertools.tee` is used before one branch is partially consumed.",
        prompt = "What problem is this code solving?",
        code = """
            from itertools import tee

            def split_head_and_tail(events):
                first_stream, second_stream = tee(events)
                head = next(first_stream, None)
                return head, second_stream
        """.trimIndent(),
        options = listOf(
            "It lets the code inspect the first item without permanently consuming it from the stream returned as `second_stream`",
            "It makes iteration thread-safe by locking the underlying iterator for both consumers",
            "It converts a lazy iterator into two fully materialized lists so they can be indexed independently",
            "It guarantees both iterators stay in sync even if either one is exhausted first"
        ),
        answerIndex = 0,
        explanation = "`tee` creates linked iterator branches that buffer values as needed. Advancing `first_stream` to read the head would normally consume the underlying iterator, but `second_stream` still sees that same first value because the buffered data is replayed there."
    ),
    Problem(
        id = "fill_hard_12",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Delegating a subgenerator",
        summary = "A generator should yield every value from another generator transparently.",
        prompt = "Fill the blank so `outer()` forwards all yielded values from `inner()` without writing an explicit loop.",
        code = """
            def inner():
                yield 1
                yield 2

            def outer():
                ___ inner()
                yield 3
        """.trimIndent(),
        options = listOf("yield from", "return from", "await", "yield"),
        answerIndex = 0,
        explanation = "`yield from inner()` delegates iteration to the subgenerator, forwarding its yielded values directly before execution continues with `yield 3`."
    ),
    Problem(
        id = "order_hard_11",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Stable deduplication preserving order",
        summary = "Arrange the lines to remove duplicates from a sequence while preserving the first occurrence of each item.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def dedupe(values):",
            "    seen = set()",
            "    result = []",
            "    for value in values:",
            "        if value not in seen:",
            "            seen.add(value)",
            "            result.append(value)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "The function initializes tracking structures, scans the input in order, records the first time each value appears, and returns the preserved-order result list."
    ),
    Problem(
        id = "complexity_hard_11",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sorting before a two-pointer scan",
        summary = "A duplicate check sorts first, then makes one linear pass.",
        prompt = "What is the overall time complexity with respect to n = len(values)?",
        code = """
            def has_duplicate(values):
                values = sorted(values)
                for i in range(1, len(values)):
                    if values[i] == values[i - 1]:
                        return True
                return False
        """.trimIndent(),
        options = listOf("O(n log n)", "O(n)", "O(log n)", "O(n^2)"),
        answerIndex = 0,
        explanation = "The linear scan is O(n), but the `sorted(values)` call dominates at O(n log n), so the whole function is O(n log n)."
    ),
    Problem(
        id = "trace_hard_11",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shared closure state",
        summary = "Two returned functions mutate the same nonlocal variable.",
        prompt = "What is the value of `value` after these lines execute?",
        code = """
            def make_counter():
                total = 0

                def inc():
                    nonlocal total
                    total += 1
                    return total

                def dec():
                    nonlocal total
                    total -= 1
                    return total

                return inc, dec

            inc, dec = make_counter()
            inc()
            inc()
            value = dec()
        """.trimIndent(),
        options = listOf("1", "2", "0", "-1"),
        answerIndex = 0,
        explanation = "Both closures reference the same `total` cell. After two `inc()` calls, `total` is 2. `dec()` then decrements that shared value to 1, so `value` becomes 1."
    ),
    Problem(
        id = "match_hard_11",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [('a', 2), ('b', 1)]",
        summary = "Pick the snippet that counts characters while preserving insertion order.",
        prompt = "Which code produces exactly `[('a', 2), ('b', 1)]`?",
        code = "",
        options = listOf(
            "from collections import Counter; print(list(Counter('aba').items()))",
            "print(list(set('aba')))",
            "from collections import defaultdict; d = defaultdict(int); d['b'] += 1; d['a'] += 2; print(list(d.items()))",
            "print(sorted({'a': 2, 'b': 1}.values()))"
        ),
        answerIndex = 0,
        explanation = "`Counter('aba')` counts `'a'` twice and `'b'` once, and its `.items()` iteration preserves first-seen order for these keys in modern Python, producing `[('a', 2), ('b', 1)]`."
    )
)
