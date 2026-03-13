package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior52 = listOf(
    Problem(
        id = "bug_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing Fallback Result",
        summary = "The function returns the first even number, but one path never assigns the return value.",
        prompt = "What is the real bug in this function?",
        code = """
            def first_even(values):
                for value in values:
                    if value % 2 == 0:
                        result = value
                        break
                return result
        """.trimIndent(),
        options = listOf(
            "The loop should start from the second item",
            "`break` should be replaced with `continue` after finding an even value",
            "`result` is undefined when the list has no even numbers",
            "The function must return from inside the loop"
        ),
        answerIndex = 2,
        explanation = "If no even value is found, `result` is never assigned, so `return result` raises an error."
    ),
    Problem(
        id = "output_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Mutate",
        summary = "A slice is changed after it is copied from the original list.",
        prompt = "What gets printed?",
        code = """
            values = [1, 2, 3]
            part = values[1:]
            part[0] = 9
            print(values)
        """.trimIndent(),
        options = listOf(
            "[1, 9, 3]",
            "[1, 2, 3]",
            "[9, 2, 3]",
            "Error"
        ),
        answerIndex = 1,
        explanation = "The slice `values[1:]` creates a new list, so changing `part` does not change `values`."
    ),
    Problem(
        id = "purpose_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group Names by Score",
        summary = "A dictionary collects multiple names under the same numeric key.",
        prompt = "What does this function return?",
        code = """
            def group_by_score(rows):
                grouped = {}
                for name, score in rows:
                    grouped.setdefault(score, []).append(name)
                return grouped
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each name to its score",
            "A list of names sorted by their score",
            "A dictionary counting how many times each score appears",
            "A dictionary mapping each score to the names that have it"
        ),
        answerIndex = 3,
        explanation = "Each score is used as a dictionary key, and every matching name is appended to that score's list."
    ),
    Problem(
        id = "fill_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Create a List per Key",
        summary = "Each key should get a list the first time it appears.",
        prompt = "Fill in the blank so both appends work without a KeyError.",
        code = """
            grouped = {}
            grouped.__("a", []).append(1)
            grouped.__("b", []).append(2)
        """.trimIndent(),
        options = listOf(
            "get",
            "setdefault",
            "update",
            "pop"
        ),
        answerIndex = 1,
        explanation = "`setdefault(key, [])` creates the list when the key is missing and returns the existing list otherwise."
    ),
    Problem(
        id = "order_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build Name Lengths",
        summary = "Arrange the lines to return a dictionary of each name and its length.",
        prompt = "Arrange the lines so the function builds the dictionary correctly.",
        code = "",
        options = listOf(
            "def name_lengths(names):",
            "    result = {}",
            "    for name in names:",
            "        result[name] = len(name)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the function, create the dictionary, loop over the names, store each length, and return the result."
    ),
    Problem(
        id = "complexity_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Fixed Inner Work",
        summary = "The inner loop always runs three times for each item.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            def score(values):
                total = 0
                for value in values:
                    for _ in range(3):
                        total += value
                return total
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs once per item, and the inner loop is a constant-size 3-step loop, so the growth is linear."
    ),
    Problem(
        id = "trace_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Alias Then Rebind",
        summary = "One variable keeps pointing to the old dictionary after another name is rebound.",
        prompt = "What is the value of `current[\"a\"]` after this code runs?",
        code = """
            counts = {"a": 1}
            current = counts
            counts = {"a": 2}
            current["a"] += 3
        """.trimIndent(),
        options = listOf(
            "1",
            "2",
            "4",
            "5"
        ),
        answerIndex = 2,
        explanation = "`current` still refers to the original dictionary `{\"a\": 1}`, so incrementing it changes that value to 4."
    ),
    Problem(
        id = "match_medium_junior_52",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 0, 1, 4",
        summary = "Pick the snippet that prints squares on separate lines.",
        prompt = "Which snippet produces this exact output?",
        code = """
            0
            1
            4
        """.trimIndent(),
        options = listOf(
            "for n in range(3):\n    print(n)",
            "for n in range(1, 4):\n    print(n * n)",
            "for n in range(3):\n    print(n * n)",
            "print([n * n for n in range(3)])"
        ),
        answerIndex = 2,
        explanation = "Squaring 0, 1, and 2 inside the loop prints 0, then 1, then 4 on separate lines."
    )
)
