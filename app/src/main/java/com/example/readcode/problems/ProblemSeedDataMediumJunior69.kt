package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior69 = listOf(
    Problem(
        id = "bug_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Sorted Result Is Missing",
        summary = "A list is sorted, but the next line treats the return value like a new list.",
        prompt = "What is the real bug in this code?",
        code = """
            names = ["zoe", "amy", "li"]
            sorted_names = names.sort()
            print(sorted_names[0])
        """.trimIndent(),
        options = listOf(
            "The list should contain only numbers before sorting",
            "The code should print `names[0]` before the call to `sort()`",
            "`sort()` returns `None`, so `sorted_names` is not a list",
            "The list needs to be copied before it can be reordered"
        ),
        answerIndex = 2,
        explanation = "`list.sort()` changes the existing list in place and returns `None`, so indexing `sorted_names` crashes."
    ),
    Problem(
        id = "output_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Shallow Copy Surprise",
        summary = "A copied dictionary still shares the same inner list.",
        prompt = "What does this code print?",
        code = """
            scores = {"math": [80, 90], "art": [70]}
            snapshot = scores.copy()
            snapshot["math"].append(100)
            print(scores["math"])
        """.trimIndent(),
        options = listOf(
            "[80, 90]",
            "[80, 90, 100]",
            "[100, 80, 90]",
            "It raises an error"
        ),
        answerIndex = 1,
        explanation = "`copy()` makes a shallow copy of the dictionary, so both dictionaries still refer to the same inner `math` list."
    ),
    Problem(
        id = "purpose_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep the Latest Total",
        summary = "The loop stores a growing total after each number is processed.",
        prompt = "What does this code build in `running`?",
        code = """
            numbers = [2, 5, 1]
            running = []
            total = 0
            for number in numbers:
                total += number
                running.append(total)
        """.trimIndent(),
        options = listOf(
            "It stores each number doubled in a new list",
            "It keeps only the final sum in a one-item list",
            "It records the running total after each step",
            "It sorts the numbers before adding them"
        ),
        answerIndex = 2,
        explanation = "After each addition, the current total is appended, so the list becomes `[2, 7, 8]`."
    ),
    Problem(
        id = "fill_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent Backup List",
        summary = "The second list should be a separate copy before it is changed.",
        prompt = "Which choice fills the blank so `print(items)` still shows `[1, 2, 3]`?",
        code = """
            items = [1, 2, 3]
            backup = items.___()
            backup.append(4)
            print(items)
        """.trimIndent(),
        options = listOf(
            "copy",
            "sort",
            "clear",
            "reverse"
        ),
        answerIndex = 0,
        explanation = "`copy()` creates a new list, so appending to `backup` does not change `items`."
    ),
    Problem(
        id = "order_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect Long Names",
        summary = "Arrange the lines so the function returns only names longer than three letters.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def long_names(names):",
            "    result = []",
            "    for name in names:",
            "        if len(name) > 3:",
            "            result.append(name)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The result list must be created before the loop, updated inside the conditional, and returned after the loop finishes."
    ),
    Problem(
        id = "complexity_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Passes Over One List",
        summary = "The code makes one pass to count and another pass to print.",
        prompt = "What is the time complexity in terms of `n = len(values)`?",
        code = """
            count = 0
            for value in values:
                if value > 0:
                    count += 1

            for value in values:
                print(value)
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(n)",
            "O(n log n)",
            "O(n^2)"
        ),
        answerIndex = 1,
        explanation = "The code makes two separate linear passes over the list, which is still O(n)."
    ),
    Problem(
        id = "trace_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the Chosen Slice",
        summary = "A slice is reassigned after the list is extended.",
        prompt = "What is the value of `picked` after this code runs?",
        code = """
            values = [1, 2, 3]
            values.extend([4, 5])
            picked = values[1:4]
            picked.pop()
        """.trimIndent(),
        options = listOf(
            "[2, 3, 4, 5]",
            "[1, 2, 3]",
            "[2, 3]",
            "[3, 4]"
        ),
        answerIndex = 2,
        explanation = "After `extend`, the slice `values[1:4]` is `[2, 3, 4]`, and `pop()` removes the last item, leaving `[2, 3]`."
    ),
    Problem(
        id = "match_medium_junior_69",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['a', 'c']",
        summary = "Pick the snippet that keeps only words with length 1.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"a\", \"bb\", \"c\"]\nresult = []\nfor word in words:\n    if len(word) > 1:\n        result.append(word)\nprint(result)",
            "words = [\"a\", \"bb\", \"c\"]\nresult = []\nfor word in words:\n    result.append(word[0])\nprint(result)",
            "words = [\"a\", \"bb\", \"c\"]\nresult = [word for word in words if \"b\" not in word]\nprint(result)",
            "words = [\"a\", \"bb\", \"c\"]\nprint([word for word in words if len(word) == 1])"
        ),
        answerIndex = 3,
        explanation = "Only the last snippet filters the list down to the single-character strings `\"a\"` and `\"c\"`."
    )
)
