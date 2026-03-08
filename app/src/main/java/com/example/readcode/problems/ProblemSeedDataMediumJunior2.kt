package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior2 = listOf(
    Problem(
        id = "bug_medium_junior_2",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared nested state",
        summary = "A shallow copy leaves nested lists aliased.",
        prompt = "Why does changing `backup[\"steps\"]` also change `config[\"steps\"]`?",
        code = """
            config = {"steps": ["parse", "validate"]}
            backup = config.copy()
            backup["steps"].append("save")
            print(config["steps"])
        """.trimIndent(),
        options = listOf(
            "`.copy()` only duplicates the outer dictionary, so both entries still reference the same inner list",
            "Appending to a list inside a dictionary always updates every dictionary in scope",
            "Dictionary keys are immutable, so Python reuses the same value list automatically",
            "The bug is that `append()` should be `extend()` when the value came from `copy()`"
        ),
        answerIndex = 0,
        explanation = "`dict.copy()` is shallow. `config` and `backup` become separate outer dictionaries, but both `\"steps\"` keys still point to the same list object, so mutating that list through either dictionary changes what both see."
    ),
    Problem(
        id = "output_medium_junior_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Negative slicing",
        summary = "Extracting elements using a negative step.",
        prompt = "What does this code print?",
        code = """
            letters = ['a', 'b', 'c', 'd', 'e']
            print(letters[3:0:-1])
        """.trimIndent(),
        options = listOf(
            "['d', 'c', 'b']",
            "['d', 'c', 'b', 'a']",
            "['e', 'd', 'c', 'b']",
            "[]"
        ),
        answerIndex = 0,
        explanation = "The slice starts at index 3 ('d') and moves backwards to, but not including, index 0 ('a')."
    ),
    Problem(
        id = "purpose_medium_junior_2",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Last write wins",
        summary = "A dictionary comprehension collapses duplicate keys.",
        prompt = "What ends up stored in `lookup` after this code runs?",
        code = """
            pairs = [("us", 1), ("eu", 2), ("us", 3)]
            lookup = {region: value for region, value in pairs}
        """.trimIndent(),
        options = listOf(
            "A dictionary where duplicate keys keep only the last value, so `\"us\"` maps to `3`",
            "A dictionary that keeps the first value for each key, so `\"us\"` maps to `1`",
            "A list of `(region, value)` pairs with duplicates removed",
            "A dictionary with both `\"us\"` values stored under the same key as a list"
        ),
        answerIndex = 0,
        explanation = "Dictionary keys must be unique. As the comprehension processes the list, the later `(\"us\", 3)` assignment overwrites the earlier `(\"us\", 1)`, so the final dictionary is `{\"us\": 3, \"eu\": 2}`."
    ),
    Problem(
        id = "fill_medium_junior_2",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Snapshot before clearing",
        summary = "Appending a reusable list requires preserving each pair before the working buffer is cleared.",
        prompt = "Fill in the blank so the final print is `[[1, 2], [3, 4]]` instead of two references to the same cleared list.",
        code = """
            groups = []
            current = []
            for value in [1, 2, 3, 4]:
                current.append(value)
                if len(current) == 2:
                    groups.append(___)
                    current.clear()
            print(groups)
        """.trimIndent(),
        options = listOf("current.copy()", "current", "tuple(current)", "set(current)"),
        answerIndex = 0,
        explanation = "`current.copy()` captures the pair before `current.clear()` empties the reusable buffer. Appending `current` itself would store the same list object twice, so both entries would end up empty after the clears."
    )
)
