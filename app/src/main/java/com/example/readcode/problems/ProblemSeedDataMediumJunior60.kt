package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior60 = listOf(
    Problem(
        id = "bug_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Last Item Never Checked",
        summary = "The loop is meant to search the whole list, but one value is skipped.",
        prompt = "What is the real bug in this function?",
        code = """
            def contains_zero(values):
                for i in range(len(values) - 1):
                    if values[i] == 0:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "It should return `False` inside the loop",
            "`values[i]` should be `values[i + 1]`",
            "The range stops before the final element",
            "The function must sort the list first"
        ),
        answerIndex = 2,
        explanation = "Using `range(len(values) - 1)` checks indexes `0` through `len(values) - 2`, so the last item is never tested."
    ),
    Problem(
        id = "output_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Split and Count",
        summary = "The string is broken into words before measuring the result.",
        prompt = "What gets printed?",
        code = """
            message = "red blue green"
            words = message.split()
            print(len(words[1]))
        """.trimIndent(),
        options = listOf(
            "3",
            "4",
            "9",
            "2"
        ),
        answerIndex = 1,
        explanation = "`split()` makes `['red', 'blue', 'green']`, and `words[1]` is `blue`, which has length 4."
    ),
    Problem(
        id = "purpose_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group by First Letter",
        summary = "The function builds lists under dictionary keys as it walks the input.",
        prompt = "What does this function return?",
        code = """
            def group_names(names):
                grouped = {}
                for name in names:
                    first = name[0]
                    grouped.setdefault(first, []).append(name)
                return grouped
        """.trimIndent(),
        options = listOf(
            "A sorted list of the names",
            "A count of how many letters each name has",
            "A single string made from all names",
            "A dictionary of names grouped by first character"
        ),
        answerIndex = 3,
        explanation = "Each name is appended to the list stored under its first character, so the result groups names by starting letter."
    ),
    Problem(
        id = "fill_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Keep a Snapshot",
        summary = "The second variable should keep the old list even after the original changes.",
        prompt = "Which option fills the blank so `backup` stays `[1, 2, 3]`?",
        code = """
            numbers = [1, 2, 3]
            backup = numbers.___()
            numbers.append(4)
            print(backup)
        """.trimIndent(),
        options = listOf(
            "copy",
            "clear",
            "sort",
            "pop"
        ),
        answerIndex = 0,
        explanation = "`copy()` creates a separate list, so later changes to `numbers` do not affect `backup`."
    ),
    Problem(
        id = "order_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect Long Words",
        summary = "Arrange the lines to return words with more than three letters.",
        prompt = "Arrange the lines so the function filters the list correctly.",
        code = "",
        options = listOf(
            "def long_words(words):",
            "    result = []",
            "    for word in words:",
            "        if len(word) > 3:",
            "            result.append(word)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function needs a result list before the loop, the length check inside the loop, and the return at the end."
    ),
    Problem(
        id = "complexity_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Membership Inside a Loop",
        summary = "Each item from one list is checked against another list.",
        prompt = "What is the time complexity in terms of `n`, if both lists have length `n`?",
        code = """
            matches = 0
            for item in first:
                if item in second:
                    matches += 1
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(log n)",
            "O(n)",
            "O(n^2)"
        ),
        answerIndex = 3,
        explanation = "The loop runs `n` times, and each `item in second` list lookup can take `O(n)`, giving `O(n^2)` overall."
    ),
    Problem(
        id = "trace_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trim Then Extend",
        summary = "The list is sliced and then one more element is attached.",
        prompt = "What is the value of `data` after the code finishes?",
        code = """
            data = [5, 6, 7, 8]
            data = data[:-1]
            data.append(len(data))
        """.trimIndent(),
        options = listOf(
            "[5, 6, 7, 8, 3]",
            "[5, 6, 7, 3]",
            "[6, 7, 8, 4]",
            "[5, 6, 7]"
        ),
        answerIndex = 1,
        explanation = "After slicing, `data` becomes `[5, 6, 7]`. Its length is then 3, so append adds `3`."
    ),
    Problem(
        id = "match_medium_junior_60",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each item from the input list.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nresult = []\nfor n in nums:\n    result.append(n + 2)\nprint(result)",
            "nums = [1, 2, 3]\nresult = [n * 2 for n in nums if n > 1]\nprint(result)",
            "nums = [1, 2, 3]\nresult = []\nfor n in nums:\n    result.append(n * 2)\nprint(result)",
            "nums = [1, 2, 3]\nprint(nums * 2)"
        ),
        answerIndex = 2,
        explanation = "Only the third snippet doubles every element and appends the results one by one, producing `[2, 4, 6]`."
    )
)
