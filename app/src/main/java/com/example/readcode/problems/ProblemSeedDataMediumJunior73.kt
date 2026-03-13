package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior73 = listOf(
    Problem(
        id = "bug_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Mutable Default Argument",
        summary = "A function uses a list as a default parameter value, causing it to accumulate items across calls.",
        prompt = "What is the real bug in this code?",
        code = """
            def add_item(item, bucket=[]):
                bucket.append(item)
                return bucket

            print(add_item("a"))
            print(add_item("b"))
        """.trimIndent(),
        options = listOf(
            "You cannot append a string to a list inside a function",
            "The default value `[]` is created once and shared across all calls, so the second call sees `['a', 'b']`",
            "The function must return `None` instead of `bucket`",
            "Python does not allow default parameter values that are collections"
        ),
        answerIndex = 1,
        explanation = "Default argument values are evaluated once when the function is defined, not on each call. The same list object is reused, so calling `add_item('b')` appends to the list that already contains `'a'`, printing `['a', 'b']` instead of `['b']`."
    ),
    Problem(
        id = "output_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Skip the Middle",
        summary = "The loop ignores one value and adds the rest.",
        prompt = "What does this code print?",
        code = """
            nums = [4, 5, 6]
            total = 0

            for n in nums:
                if n == 5:
                    continue
                total += n

            print(total)
        """.trimIndent(),
        options = listOf(
            "15",
            "10",
            "11",
            "9"
        ),
        answerIndex = 1,
        explanation = "The loop skips `5`, so it adds only `4` and `6`, which gives `10`."
    ),
    Problem(
        id = "purpose_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Invert a Mapping",
        summary = "Keys and values are swapped while building a new dictionary.",
        prompt = "What does this code build in `result`?",
        code = """
            codes = {"red": "#f00", "blue": "#00f"}
            result = {}

            for name, code in codes.items():
                result[code] = name
        """.trimIndent(),
        options = listOf(
            "A copy of the original dictionary",
            "A dictionary of color names sorted alphabetically by their hex code",
            "A list of code strings",
            "A reverse lookup from hex code to color name"
        ),
        answerIndex = 3,
        explanation = "Each original value becomes a key in `result`, and each original key becomes the mapped value."
    ),
    Problem(
        id = "fill_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy Before Editing",
        summary = "The second list should change without modifying the first one.",
        prompt = "Which choice fills the blank so `backup` starts as a separate copy of `scores`?",
        code = """
            scores = [7, 8, 9]
            backup = scores[___]
            backup.append(10)
            print(scores)
        """.trimIndent(),
        options = listOf(
            ":1",
            ":",
            "-1:",
            "1:"
        ),
        answerIndex = 1,
        explanation = "`scores[:]` creates a shallow copy, so appending to `backup` does not change `scores`."
    ),
    Problem(
        id = "order_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Positive Values",
        summary = "Arrange the lines so the function counts positive numbers in a list.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "    return count",
            "    for value in values:",
            "def count_positive(values):",
            "    count = 0",
            "        if value > 0:",
            "            count += 1"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 1, 4, 5, 0),
        explanation = "The function header comes first, then initialization, then the loop, the conditional increment, and the return."
    ),
    Problem(
        id = "complexity_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Membership Inside a Loop",
        summary = "Each loop iteration performs a linear search in another list.",
        prompt = "What is the time complexity in terms of `n = len(a)` and `m = len(b)`?",
        code = """
            matches = 0
            for item in a:
                if item in b:
                    matches += 1
        """.trimIndent(),
        options = listOf(
            "O(n + m)",
            "O(n * m)",
            "O(n)",
            "O(m)"
        ),
        answerIndex = 1,
        explanation = "The outer loop runs `n` times, and each `item in b` check can scan up to `m` elements, giving O(n * m)."
    ),
    Problem(
        id = "trace_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Shared List Reference",
        summary = "Two variables point to the same list before one value is changed.",
        prompt = "What is the value of `items` after this code runs?",
        code = """
            items = [1, 2]
            alias = items
            alias.append(3)
            items[0] = 9
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]",
            "[9, 2]",
            "[9, 2, 3]",
            "[1, 2]"
        ),
        answerIndex = 2,
        explanation = "`alias` and `items` reference the same list, so both the append and the index assignment affect `items`."
    ),
    Problem(
        id = "match_medium_junior_73",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each value in the list before printing it.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [2, 4, 6]\nprint(nums[1:])",
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n for n in nums if n % 2 == 0])"
        ),
        answerIndex = 2,
        explanation = "Only the third snippet multiplies each value by 2 and prints `[2, 4, 6]`."
    )
)
