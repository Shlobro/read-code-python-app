package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior26 = listOf(
    Problem(
        id = "bug_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Repeated last value",
        summary = "The loop should compare each score to a target score, but it does not.",
        prompt = "What is the real bug in this code?",
        code = """
            scores = [8, 10, 7]
            target = 10

            for i in range(len(scores)):
                if scores[-1] == target:
                    print("found")
        """.trimIndent(),
        options = listOf(
            "It checks `scores[-1]` every time instead of `scores[i]`",
            "The loop should start at index 1",
            "`target` must be a string",
            "`range(len(scores))` skips the last item"
        ),
        answerIndex = 0,
        explanation = "Inside the loop, `scores[-1]` always reads the last element. The code never checks the current loop position."
    ),
    Problem(
        id = "output_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort then trim",
        summary = "A list is sorted in place and then sliced before printing.",
        prompt = "What does this code print?",
        code = """
            values = [4, 1, 3, 2]
            values.sort()
            print(values[1:3])
        """.trimIndent(),
        options = listOf(
            "[2, 3]",
            "[1, 2]",
            "[1, 2, 3]",
            "[3, 4]"
        ),
        answerIndex = 0,
        explanation = "After sorting, the list becomes `[1, 2, 3, 4]`. The slice `values[1:3]` returns the items at indexes 1 and 2."
    ),
    Problem(
        id = "purpose_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group by first letter",
        summary = "A dictionary is built by appending words under a shared key.",
        prompt = "What does this function do overall?",
        code = """
            def group_words(words):
                groups = {}
                for word in words:
                    key = word[0]
                    groups.setdefault(key, []).append(word)
                return groups
        """.trimIndent(),
        options = listOf(
            "Groups words into a dictionary by their first letter",
            "Counts how many times each letter appears in one string",
            "Sorts the words alphabetically",
            "Removes duplicate words from the list"
        ),
        answerIndex = 0,
        explanation = "Each word is appended to the list stored under its first character, so words with the same starting letter are grouped together."
    ),
    Problem(
        id = "fill_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy before editing",
        summary = "The code should avoid mutating the original list while removing the first item from a copy.",
        prompt = "Which option fills the blank correctly?",
        code = """
            original = [10, 20, 30]
            updated = original._____()
            updated.pop(0)
            print(original)
        """.trimIndent(),
        options = listOf(
            "copy",
            "clear",
            "sort",
            "remove"
        ),
        answerIndex = 0,
        explanation = "`copy()` creates a shallow copy of the list. Removing from `updated` then leaves `original` unchanged."
    ),
    Problem(
        id = "order_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a totals map",
        summary = "Arrange the lines so repeated product names are summed into a dictionary.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "totals = {}",
            "for name, amount in sales:",
            "sales = [(\"pen\", 3), (\"book\", 5), (\"pen\", 2)]",
            "print(totals)",
            "    totals[name] = totals.get(name, 0) + amount"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1, 4, 3),
        explanation = "The source data and result dictionary must be defined before the loop. The update line belongs inside the loop, and printing happens last."
    ),
    Problem(
        id = "complexity_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "One scan with early return",
        summary = "The function stops when it finds a match or reaches the end.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            def contains_name(names, target):
                for name in names:
                    if name == target:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "In the worst case, the loop checks every item once before returning, so the runtime grows linearly with `n`."
    ),
    Problem(
        id = "trace_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track merged names",
        summary = "The code builds a dictionary of joined names for active users only.",
        prompt = "What is the value of `result` after the loop finishes?",
        code = """
            users = [("a1", "Maya", True), ("b2", "Noam", False), ("c3", "Lia", True)]
            result = {}

            for user_id, name, active in users:
                if active:
                    result[user_id] = name.lower()
        """.trimIndent(),
        options = listOf(
            "{'a1': 'maya', 'c3': 'lia'}",
            "{'a1': 'Maya', 'b2': 'Noam', 'c3': 'Lia'}",
            "{'b2': 'noam'}",
            "['maya', 'lia']"
        ),
        answerIndex = 0,
        explanation = "Only active users are added, and each stored name is converted to lowercase before assignment."
    ),
    Problem(
        id = "match_medium_junior_26",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Which snippet doubles each value in a list before printing it?",
        prompt = "Which code prints `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [2, 4, 6]\nprint(nums[1:])",
            "nums = [1, 2, 3]\nprint(sum(nums))"
        ),
        answerIndex = 0,
        explanation = "The list comprehension multiplies each number by 2, producing `[2, 4, 6]`. The other snippets produce different outputs."
    )
)
