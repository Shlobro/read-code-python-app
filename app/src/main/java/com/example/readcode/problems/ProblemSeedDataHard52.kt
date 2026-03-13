package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 52.
// One senior-level problem per problem type.
val hardProblems52 = listOf(
    Problem(
        id = "bug_hard_53",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Dataclass equality without hashing",
        summary = "The instances are used as dictionary keys after dataclass defaults remove hash support.",
        prompt = "What is the actual bug here?",
        code = """
            from dataclasses import dataclass

            @dataclass
            class Job:
                name: str
                retries: int

            counts = {Job("sync", 3): 1}
            print(counts[Job("sync", 3)])
        """.trimIndent(),
        options = listOf(
            "Dataclass instances cannot be compared",
            "The key is unhashable by default here",
            "Dictionary keys must be strings",
            "The second `Job` call mutates the first one"
        ),
        answerIndex = 1,
        explanation = "A mutable dataclass generates `__eq__` but not `__hash__`, so instances are unhashable and cannot be used as dictionary keys unless the class is frozen or given an explicit hash policy."
    ),
    Problem(
        id = "output_hard_53",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Mixed `except` and `finally` control flow",
        summary = "An exception path returns, but `finally` still mutates local state first.",
        prompt = "What does this code print?",
        code = """
            def run():
                value = []
                try:
                    value.append("try")
                    raise RuntimeError("boom")
                except RuntimeError:
                    value.append("except")
                    return value
                finally:
                    value.append("finally")

            print(run())
        """.trimIndent(),
        options = listOf(
            "['try', 'except']",
            "['try', 'finally']",
            "['try', 'except', 'finally']",
            "RuntimeError after appending 'finally'"
        ),
        answerIndex = 2,
        explanation = "The `except` block handles the error and prepares the return value, but `finally` runs before the function actually returns, so `\"finally\"` is appended to the same list."
    ),
    Problem(
        id = "purpose_hard_53",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Stable priority queue entries",
        summary = "A monotonically increasing counter is packed into heap entries with the priority.",
        prompt = "What does this pattern do overall?",
        code = """
            import heapq
            import itertools

            counter = itertools.count()
            heap = []

            def push(priority, task):
                heapq.heappush(heap, (priority, next(counter), task))
        """.trimIndent(),
        options = listOf(
            "It breaks ties by insertion order",
            "It deduplicates tasks before pushing them",
            "It makes every push run in constant time",
            "It turns the heap into a max-heap"
        ),
        answerIndex = 0,
        explanation = "The sequence number provides a deterministic tiebreaker. Tasks with equal priority are ordered by insertion time instead of forcing Python to compare the task objects themselves."
    ),
    Problem(
        id = "fill_hard_53",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Abstract property marker",
        summary = "The subclass should be forced to implement a read-only property.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            from abc import ABC, abstractmethod

            class Config(ABC):
                @property
                @___
                def path(self):
                    pass
        """.trimIndent(),
        options = listOf(
            "classmethod",
            "staticmethod",
            "cached_property",
            "abstractmethod"
        ),
        answerIndex = 3,
        explanation = "Stacking `@property` with `@abstractmethod` defines an abstract property that concrete subclasses must implement."
    ),
    Problem(
        id = "order_hard_52",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Async iterator wrapper",
        summary = "Arrange the lines to define an async iterator that yields values from an async iterable.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "class Wrapper:",
            "    def __init__(self, source):",
            "        self.source = source",
            "    async def __aiter__(self):",
            "        async for item in self.source:",
            "            yield item"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the class and initializer first, then implement `__aiter__` as an async generator that relays each item from the wrapped async iterable."
    ),
    Problem(
        id = "complexity_hard_52",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Membership check after one-time indexing",
        summary = "The code sorts once, then answers each query with binary search.",
        prompt = "If `values` has length `n` and `queries` has length `m`, what is the worst-case time complexity?",
        code = """
            from bisect import bisect_left

            def count_hits(values, queries):
                ordered = sorted(values)
                hits = 0
                for q in queries:
                    i = bisect_left(ordered, q)
                    if i < len(ordered) and ordered[i] == q:
                        hits += 1
                return hits
        """.trimIndent(),
        options = listOf(
            "O((n + m) log n)",
            "O(n + m log n)",
            "O(nm)",
            "O(n log n + m log n + m)"
        ),
        answerIndex = 0,
        explanation = "Sorting the input costs O(n log n). Each of the `m` binary searches costs O(log n), so the total is O(n log n + m log n), which is equivalently O((n + m) log n)."
    ),
    Problem(
        id = "trace_hard_52",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Re-entering a shared generator",
        summary = "Two references point to the same generator object and consume it in sequence.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def numbers():
                yield 1
                yield 2
                yield 3

            g = numbers()
            a = g
            b = g

            result = [next(a), next(b), list(g)]
        """.trimIndent(),
        options = listOf(
            "[1, 1, [1, 2, 3]]",
            "[1, 2, [3]]",
            "[1, 2, [2, 3]]",
            "[1, 2, []]"
        ),
        answerIndex = 1,
        explanation = "All three names reference the same generator. `next(a)` yields `1`, `next(b)` advances the same generator and yields `2`, and the remaining items in `g` are `[3]`."
    ),
    Problem(
        id = "match_hard_52",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {'a': [1], 'b': [1]}",
        summary = "Pick the snippet that accidentally shares one mutable list across both keys.",
        prompt = "Which code produces this output?",
        code = "{'a': [1], 'b': [1]}",
        options = listOf(
            "shared = []; groups = dict.fromkeys(['a', 'b'], shared); groups['a'].append(1); print(groups)",
            "groups = {k: [] for k in ['a', 'b']}; groups['a'].append(1); print(groups)",
            "groups = dict.fromkeys(['a', 'b'], []); groups['a'] = groups['a'] + [1]; print(groups)",
            "shared = []; groups = dict.fromkeys(['a', 'b'], shared); groups['a'] += [1]; groups['b'] += [2]; print(groups)"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet keeps both keys bound to the same shared list and mutates it once through `groups['a']`, so both dictionary entries show `[1]`."
    )
)
