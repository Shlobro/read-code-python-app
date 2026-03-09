package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 12.
// One senior-level problem per problem type.
val hardProblems12 = listOf(
    Problem(
        id = "bug_hard_13",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Caching with an unhashable argument",
        summary = "An `lru_cache`-decorated function is called with a dictionary.",
        prompt = "Why does this code fail on the first call?",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=None)
            def render(config):
                return tuple(sorted(config.items()))

            print(render({"mode": "fast"}))
        """.trimIndent(),
        options = listOf(
            "`lru_cache` requires hashable arguments, but dictionaries are unhashable",
            "`sorted(config.items())` returns an iterator that cannot be converted to a tuple",
            "Decorated functions cannot return tuples when `maxsize=None` is used",
            "The cache key is valid, but `.items()` mutates the dictionary during iteration"
        ),
        answerIndex = 0,
        explanation = "`lru_cache` builds its cache key from the function arguments before the function body runs. A `dict` is mutable and therefore unhashable, so calling `render({...})` raises `TypeError` immediately."
    ),
    Problem(
        id = "output_hard_13",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Return in `finally`",
        summary = "A `finally` block also returns a value.",
        prompt = "What does this script print?",
        code = """
            def choose():
                try:
                    return "try"
                finally:
                    return "finally"

            print(choose())
        """.trimIndent(),
        options = listOf("finally", "try", "tryfinally", "It raises an exception"),
        answerIndex = 0,
        explanation = "A `return` in `finally` overrides the earlier `return` from the `try` block, so the function returns `\"finally\"`."
    ),
    Problem(
        id = "purpose_hard_13",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Layered configuration fallback",
        summary = "A `ChainMap` combines request, environment, and global settings.",
        prompt = "What does this function do overall?",
        code = """
            from collections import ChainMap

            def resolve_settings(request_overrides, env_defaults, global_defaults):
                return ChainMap(request_overrides, env_defaults, global_defaults)
        """.trimIndent(),
        options = listOf(
            "It creates a single view where lookups prefer request values, then environment defaults, then global defaults",
            "It merges the three dictionaries into a brand-new dictionary and deep-copies every nested value",
            "It validates that the three dictionaries have exactly the same keys before returning them",
            "It sorts the dictionaries by size so the smallest one is searched first"
        ),
        answerIndex = 0,
        explanation = "`ChainMap` creates a layered mapping view. Reads fall through in order, so request-specific overrides win first, then environment defaults, then global defaults."
    ),
    Problem(
        id = "fill_hard_13",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Safe dataclass defaults",
        summary = "Each dataclass instance should receive its own list.",
        prompt = "Fill the blank so every `Job` gets an independent `tags` list.",
        code = """
            from dataclasses import dataclass, field

            @dataclass
            class Job:
                tags: list[str] = ___
        """.trimIndent(),
        options = listOf(
            "field(default_factory=list)",
            "[]",
            "list()",
            "field(default=[])"
        ),
        answerIndex = 0,
        explanation = "`field(default_factory=list)` creates a fresh list for each instance. Using a single list object as the default would incorrectly share mutable state across instances."
    ),
    Problem(
        id = "order_hard_12",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Leftmost binary-search insertion point",
        summary = "Arrange the lines to return the first index where `target` can be inserted while keeping the list sorted.",
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
        explanation = "The function keeps a half-open search range `[left, right)`, narrows it with binary search, and returns the first position whose value is not less than `target`."
    ),
    Problem(
        id = "complexity_hard_12",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Outer loop with logarithmic inner work",
        summary = "The inner loop repeatedly halves a value derived from the outer index.",
        prompt = "What is the overall time complexity in terms of n?",
        code = """
            def cost(n):
                total = 0
                for i in range(1, n + 1):
                    j = i
                    while j > 0:
                        total += 1
                        j //= 2
                return total
        """.trimIndent(),
        options = listOf("O(n log n)", "O(n)", "O(log n)", "O(n^2)"),
        answerIndex = 0,
        explanation = "For each `i`, the inner loop runs O(log i) times because `j` is halved on each iteration. Summing that from 1 through n gives O(n log n)."
    ),
    Problem(
        id = "trace_hard_12",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late-bound loop variable",
        summary = "Closures are created inside a loop and called later.",
        prompt = "What is the value of `value` after this code runs?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)

            value = funcs[1]()
        """.trimIndent(),
        options = listOf("2", "1", "0", "It raises `NameError`"),
        answerIndex = 0,
        explanation = "The lambdas close over the same `i` variable, not a per-iteration snapshot. After the loop ends, `i` is 2, so every stored lambda returns 2."
    ),
    Problem(
        id = "match_hard_12",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {'host': 'db', 'port': 5432}",
        summary = "Pick the snippet where later mapping values override earlier ones during a merge.",
        prompt = "Which code produces exactly `{'host': 'db', 'port': 5432}`?",
        code = "",
        options = listOf(
            "defaults = {'host': 'localhost', 'port': 5432}; overrides = {'host': 'db'}; print({**defaults, **overrides})",
            "defaults = {'host': 'localhost', 'port': 5432}; overrides = {'host': 'db'}; print({**overrides, **defaults})",
            "defaults = {'host': 'localhost', 'port': 5432}; overrides = {'host': 'db'}; defaults.update(overrides); print(overrides)",
            "defaults = {'host': 'localhost', 'port': 5432}; overrides = {'host': 'db'}; print(defaults | {'port': 3306})"
        ),
        answerIndex = 0,
        explanation = "Dictionary unpacking applies later mappings last, so `overrides` replaces only the `host` value while the original `port` remains `5432`."
    )
)
