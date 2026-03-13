package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior66 = listOf(
    Problem(
        id = "bug_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "String Math Instead of Number Math",
        summary = "Two values are split from text and combined into the wrong type of result.",
        prompt = "What is the real bug in this code?",
        code = """
            rows = ["10,20", "30,40"]
            totals = []
            for row in rows:
                left, right = row.split(",")
                totals.append(left + right)
        """.trimIndent(),
        options = listOf(
            "The loop should stop after the first row",
            "The values from `split()` should be converted to integers before adding",
            "`totals` should be a dictionary instead of a list",
            "The code must sort `rows` before processing it"
        ),
        answerIndex = 1,
        explanation = "`split()` returns strings, so `left + right` joins text like `\"10\" + \"20\"` into `\"1020\"` instead of adding numbers."
    ),
    Problem(
        id = "output_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Copy Mutation",
        summary = "A sliced list is changed after it is copied from the original.",
        prompt = "What does this code print?",
        code = """
            values = [1, 2, 3]
            result = values[1:]
            result[0] = 9
            print(values)
            print(result)
        """.trimIndent(),
        options = listOf(
            "[1, 9, 3]\n[9, 3]",
            "[1, 2, 3]\n[2, 3]",
            "[1, 2, 3]\n[9, 3]",
            "[1, 9, 3]\n[2, 3]"
        ),
        answerIndex = 2,
        explanation = "`values[1:]` makes a new list `[2, 3]`, so changing `result[0]` does not modify `values`."
    ),
    Problem(
        id = "purpose_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group Values By Key",
        summary = "A loop appends each value into a list stored under its matching key.",
        prompt = "What does this code build in `grouped`?",
        code = """
            pairs = [("a", 1), ("b", 2), ("a", 3)]
            grouped = {}
            for key, value in pairs:
                grouped.setdefault(key, []).append(value)
        """.trimIndent(),
        options = listOf(
            "It builds a dictionary where each key stores a list of its values",
            "It keeps only the last value seen for each key",
            "It sorts the pairs by key before storing them",
            "It removes duplicate pairs from the original list"
        ),
        answerIndex = 0,
        explanation = "`setdefault(key, [])` creates a list for each key when needed, and `append(value)` collects all values seen for that key."
    ),
    Problem(
        id = "fill_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Accumulate Hours Per Name",
        summary = "The blank should make the dictionary keep a running total for each person.",
        prompt = "Which choice fills the blank so `totals[\"Bob\"]` becomes `4`?",
        code = """
            rows = [("Ana", 3), ("Bob", 4)]
            totals = {}
            for name, hours in rows:
                totals[name] = totals.get(name, 0) __ hours
            print(totals["Bob"])
        """.trimIndent(),
        options = listOf(
            "*",
            "+",
            "-",
            "//"
        ),
        answerIndex = 1,
        explanation = "The code is building running totals, so it needs `+` to add the current `hours` onto the previous total."
    ),
    Problem(
        id = "order_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect First Letters",
        summary = "Arrange the lines so the function returns the first letter of each non-empty word.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def first_letters(words):",
            "    result = []",
            "    for word in words:",
            "        if word:",
            "            result.append(word[0])",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function must define the result list before the loop, append inside the `if`, and return after the loop finishes."
    ),
    Problem(
        id = "complexity_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Duplicate Check With a List",
        summary = "Each item is checked against a growing list before it is appended.",
        prompt = "What is the time complexity in terms of `n = len(items)`?",
        code = """
            uniques = []
            for item in items:
                if item not in uniques:
                    uniques.append(item)
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(n)",
            "O(n log n)",
            "O(n^2)"
        ),
        answerIndex = 3,
        explanation = "The loop runs `n` times, and `item not in uniques` can scan up to `n` elements, giving quadratic time overall."
    ),
    Problem(
        id = "trace_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a Running Total",
        summary = "A split string is converted to numbers and then adjusted once more.",
        prompt = "What is the value of `total` after this code runs?",
        code = """
            total = 0
            for part in "3-5-7".split("-"):
                total += int(part)
            if total > 10:
                total -= 4
        """.trimIndent(),
        options = listOf(
            "15",
            "10",
            "11",
            "7"
        ),
        answerIndex = 2,
        explanation = "The loop sums `3 + 5 + 7` to get 15, then the final `if` subtracts 4, leaving 11."
    ),
    Problem(
        id = "match_medium_junior_66",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 3, 4]",
        summary = "Pick the snippet that increases each number in the list by one.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [1, 2, 3]\nprint(nums[1:] + [4])",
            "nums = [1, 2, 3]\nprint(list(range(2, 4)))"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet adds 1 to every item, producing `[2, 3, 4]`."
    )
)
