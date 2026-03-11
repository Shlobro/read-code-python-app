package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 47.
// One senior-level problem per problem type.
val hardProblems47 = listOf(
    Problem(
        id = "bug_hard_48",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Shared list from fromkeys",
        summary = "Two dictionary keys look independent but start from the same mutable default object.",
        prompt = "What is the real bug in this code?",
        code = """
            buckets = dict.fromkeys(("ok", "fail"), [])
            buckets["ok"].append("job-1")
            print(buckets)
        """.trimIndent(),
        options = listOf(
            "`append` should be `extend` for list values",
            "`dict.fromkeys(..., [])` reuses one shared list",
            "The tuple of keys must be converted to a set first",
            "Printing the dict mutates the shared state"
        ),
        answerIndex = 1,
        explanation = "The second argument to `dict.fromkeys` is used as-is for every key. Because that object is one mutable list, appending through one key also changes the value seen through the other key."
    ),
    Problem(
        id = "output_hard_48",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Suppressing an exception in __exit__",
        summary = "The context manager logs the exception type and then suppresses it.",
        prompt = "What does this code print?",
        code = """
            class Quiet:
                def __enter__(self):
                    return self

                def __exit__(self, exc_type, exc, tb):
                    print(exc_type.__name__)
                    return True

            with Quiet():
                1 / 0

            print("after")
        """.trimIndent(),
        options = listOf(
            "after",
            "ZeroDivisionError",
            "ZeroDivisionError\nafter",
            "A traceback for `ZeroDivisionError`"
        ),
        answerIndex = 2,
        explanation = "`__exit__` receives the raised exception type, prints `ZeroDivisionError`, and returns `True`, which tells Python to suppress the exception. Execution then continues and prints `after`."
    ),
    Problem(
        id = "purpose_hard_48",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Layered config view",
        summary = "A standard-library mapping combines override values with defaults without copying either dict.",
        prompt = "What is this function primarily used for?",
        code = """
            from collections import ChainMap

            def build_config(overrides, defaults):
                return ChainMap(overrides, defaults)
        """.trimIndent(),
        options = listOf(
            "Build one merged dict and then detach it from both inputs",
            "Create a layered mapping where overrides win on lookup",
            "Return only keys that exist in both dictionaries",
            "Validate that both dictionaries have identical schemas"
        ),
        answerIndex = 1,
        explanation = "`ChainMap` creates a composite mapping view over multiple dictionaries. Lookups check `overrides` first and fall back to `defaults`, which is useful for config layering without eagerly merging data."
    ),
    Problem(
        id = "fill_hard_48",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Rebinding an outer local",
        summary = "The nested function must modify the variable from the enclosing function scope.",
        prompt = "Which keyword fills the blank so this function works?",
        code = """
            def counter():
                total = 0

                def inc():
                    ___ total
                    total += 1
                    return total

                return inc
        """.trimIndent(),
        options = listOf(
            "global",
            "nonlocal",
            "local",
            "static"
        ),
        answerIndex = 1,
        explanation = "`nonlocal` tells Python that `total` lives in the nearest enclosing function scope. Without it, `total += 1` would try to assign to a new local variable inside `inc` and fail."
    ),
    Problem(
        id = "order_hard_47",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Generator-style context manager",
        summary = "Arrange the lines to build a context manager that always prints a closing tag.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "        print(f\"</{name}>\")",
            "@contextmanager",
            "    try:",
            "def open_tag(name):",
            "from contextlib import contextmanager",
            "        yield",
            "    finally:",
            "    print(f\"<{name}>\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(4, 1, 3, 7, 2, 5, 6, 0),
        explanation = "Import and apply `@contextmanager`, define the function, emit the opening tag, then wrap `yield` in `try/finally` so the closing tag always prints when the context exits."
    ),
    Problem(
        id = "complexity_hard_47",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Draining a list from the front",
        summary = "Each removal shortens the list, but removing index 0 shifts the remaining elements every time.",
        prompt = "If `items` is a Python list of length `n`, what is the worst-case time complexity?",
        code = """
            def drain(items):
                while items:
                    items.pop(0)
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n)",
            "O(n log n)",
            "O(n²)"
        ),
        answerIndex = 3,
        explanation = "Each `pop(0)` is O(k) for the current list length because Python must shift the remaining elements left. Summed across all iterations, that becomes O(n²)."
    ),
    Problem(
        id = "trace_hard_47",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Deque overflow behavior",
        summary = "A bounded deque silently drops items from the opposite side when it overflows.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            from collections import deque

            window = deque([1, 2], maxlen=3)
            window.append(3)
            window.appendleft(0)
            result = list(window)
        """.trimIndent(),
        options = listOf(
            "[0, 1, 2]",
            "[0, 1, 2, 3]",
            "[1, 2, 3]",
            "[0, 2, 3]"
        ),
        answerIndex = 0,
        explanation = "After `append(3)`, the deque is `[1, 2, 3]`. `appendleft(0)` would exceed `maxlen`, so the rightmost item is discarded and the final deque becomes `[0, 1, 2]`."
    ),
    Problem(
        id = "match_hard_47",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: ['b', 'a', 'c']",
        summary = "Pick the snippet that removes duplicates while preserving first-seen order.",
        prompt = "Which code produces this output?",
        code = "['b', 'a', 'c']",
        options = listOf(
            "print(sorted(set(\"bbacac\")))",
            "print(list(dict.fromkeys(\"bbacac\")))",
            "print([*\"bbacac\"])",
            "print(list(reversed(\"bbacac\"[:3])))"
        ),
        answerIndex = 1,
        explanation = "`dict.fromkeys` preserves insertion order, so the first occurrences are kept in the order `b`, `a`, `c`. The other snippets either sort, keep duplicates, or produce a different order."
    )
)
