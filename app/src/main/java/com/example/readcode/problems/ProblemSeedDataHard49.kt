package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 49.
// One senior-level problem per problem type.
val hardProblems49 = listOf(
    Problem(
        id = "bug_hard_50",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Caching with a list argument",
        summary = "A memoized function is called with a mutable input type.",
        prompt = "What is the actual bug here?",
        code = """
            from functools import lru_cache

            @lru_cache
            def total(values):
                return sum(values)

            print(total([1, 2, 3]))
        """.trimIndent(),
        options = listOf(
            "The decorator works only on methods",
            "The list argument cannot be used as a cache key",
            "`sum` consumes the list and empties it",
            "The function must return a tuple"
        ),
        answerIndex = 1,
        explanation = "`lru_cache` stores results by argument value, so its arguments must be hashable. A list is mutable and unhashable, so the call fails before the body runs."
    ),
    Problem(
        id = "output_hard_50",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Diamond MRO with super",
        summary = "Each override delegates to the next class in the method resolution order.",
        prompt = "What does this code print?",
        code = """
            class A:
                def label(self):
                    return "A"

            class B(A):
                def label(self):
                    return "B" + super().label()

            class C(A):
                def label(self):
                    return "C" + super().label()

            class D(B, C):
                pass

            print(D().label())
        """.trimIndent(),
        options = listOf(
            "BA",
            "BCA",
            "CA",
            "BACA"
        ),
        answerIndex = 1,
        explanation = "For `D`, Python follows the MRO `D -> B -> C -> A`. `B.label()` calls `C.label()`, which calls `A.label()`, so the result is `BCA`."
    ),
    Problem(
        id = "purpose_hard_50",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Chunking an iterator lazily",
        summary = "The function repeatedly slices from a single iterator until it is exhausted.",
        prompt = "What does this function do overall?",
        code = """
            from itertools import islice

            def chunked(iterable, size):
                it = iter(iterable)
                while batch := list(islice(it, size)):
                    yield batch
        """.trimIndent(),
        options = listOf(
            "It sorts the iterable into size-based buckets",
            "It yields consecutive chunks of up to `size` items",
            "It removes duplicates while preserving order",
            "It pairs neighboring items into tuples"
        ),
        answerIndex = 1,
        explanation = "The function keeps one iterator, pulls `size` items at a time with `islice`, and yields each non-empty batch until nothing remains."
    ),
    Problem(
        id = "fill_hard_50",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Fixed instance layout",
        summary = "The class should avoid a per-instance attribute dictionary.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            class Token:
                ___ = ("kind", "value")

                def __init__(self, kind, value):
                    self.kind = kind
                    self.value = value
        """.trimIndent(),
        options = listOf(
            "__dict__",
            "__slots__",
            "__all__",
            "__mro__"
        ),
        answerIndex = 1,
        explanation = "`__slots__` declares the allowed instance attributes and prevents Python from creating the usual per-instance `__dict__`."
    ),
    Problem(
        id = "order_hard_49",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Context-managed lock",
        summary = "Arrange the lines to build a context manager that always releases a lock.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    lock.acquire()",
            "    try:",
            "from contextlib import contextmanager",
            "@contextmanager",
            "def locked(lock):",
            "        yield",
            "    finally:",
            "        lock.release()"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 4, 0, 1, 5, 6, 7),
        explanation = "Import and apply `@contextmanager`, define the function, acquire the lock, then wrap `yield` in `try/finally` so release always runs."
    ),
    Problem(
        id = "complexity_hard_49",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Heapify then drain",
        summary = "A list is converted to a heap once and then emptied one item at a time.",
        prompt = "If `values` has length `n`, what is the worst-case time complexity?",
        code = """
            import heapq

            def consume(values):
                heapq.heapify(values)
                while values:
                    heapq.heappop(values)
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n log n)",
            "O(n)",
            "O(n²)"
        ),
        answerIndex = 1,
        explanation = "`heapify` is O(n), then there are `n` heap pops at O(log n) each. The total is O(n log n)."
    ),
    Problem(
        id = "trace_hard_49",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shallow copy and rebind",
        summary = "A copied dictionary briefly shares an inner list, then stops sharing it.",
        prompt = "What is the value of `original[\"items\"]` after this code runs?",
        code = """
            original = {"items": [1]}
            copy = original.copy()
            copy["items"].append(2)
            copy["items"] = copy["items"] + [3]
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "[1, 2, 3]",
            "[1]",
            "KeyError"
        ),
        answerIndex = 0,
        explanation = "`.copy()` is shallow, so both dictionaries initially point at the same inner list and the append affects both. The later `+ [3]` creates a new list and rebinds only `copy`."
    ),
    Problem(
        id = "match_hard_49",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [(1, ['a', 'c']), (2, ['bb'])]",
        summary = "Pick the snippet that groups words by their length and keeps insertion order inside each group.",
        prompt = "Which code produces this output?",
        code = "[(1, ['a', 'c']), (2, ['bb'])]",
        options = listOf(
            "groups = {}; [groups.setdefault(len(w), []).append(w) for w in [\"a\", \"bb\", \"c\"]]; print(sorted(groups.items()))",
            "groups = {}; [groups.__setitem__(len(w), [w]) for w in [\"a\", \"bb\", \"c\"]]; print(sorted(groups.items()))",
            "groups = {}; [groups.setdefault(w, []).append(len(w)) for w in [\"a\", \"bb\", \"c\"]]; print(sorted(groups.items()))",
            "groups = {}; [groups.setdefault(i, []).append(w) for i, w in enumerate([\"a\", \"bb\", \"c\"])]; print(sorted(groups.items()))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet accumulates words in a list keyed by `len(w)`. The others overwrite values or group by the wrong key."
    )
)
