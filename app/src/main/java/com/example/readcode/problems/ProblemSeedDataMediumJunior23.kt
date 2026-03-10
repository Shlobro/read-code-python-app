package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior23 = listOf(
    Problem(
        id = "bug_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing counter update",
        summary = "A frequency dictionary is initialized correctly but never increases past 1.",
        prompt = "What is the real bug in this code?",
        code = """
            votes = ["red", "blue", "red"]
            counts = {}

            for vote in votes:
                counts[vote] = 1
        """.trimIndent(),
        options = listOf(
            "Each loop resets the count for that vote instead of incrementing it",
            "Dictionaries cannot use strings as keys",
            "The loop should use `range(len(votes))` instead",
            "The `counts` dictionary must start as an empty list"
        ),
        answerIndex = 0,
        explanation = "Assigning `1` on every pass overwrites any previous count. The code should increase the existing value instead of resetting it."
    ),
    Problem(
        id = "output_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slicing after append",
        summary = "A list grows and then a slice skips the first element.",
        prompt = "What does this code print?",
        code = """
            values = [1, 2]
            values.append(4)
            print(values[1:])
        """.trimIndent(),
        options = listOf(
            "[2, 4]",
            "[1, 2]",
            "[1, 2, 4]",
            "4"
        ),
        answerIndex = 0,
        explanation = "After `append`, the list is `[1, 2, 4]`. The slice `[1:]` returns everything from index 1 onward, which is `[2, 4]`."
    ),
    Problem(
        id = "purpose_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep unfinished tasks",
        summary = "A loop filters dictionaries based on a boolean field.",
        prompt = "What does this function return?",
        code = """
            def open_tasks(tasks):
                result = []
                for task in tasks:
                    if not task["done"]:
                        result.append(task["title"])
                return result
        """.trimIndent(),
        options = listOf(
            "A list of titles for tasks that are not done",
            "A dictionary of all tasks by title",
            "The number of completed tasks",
            "A list of titles sorted alphabetically"
        ),
        answerIndex = 0,
        explanation = "The function checks `task[\"done\"]` and appends only the titles of tasks where that value is false."
    ),
    Problem(
        id = "fill_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Shared reference mutation",
        summary = "Assigning a list to a second name creates an alias, not a copy.",
        prompt = "Which blank makes `print(original)` output `[1, 2, 3, 4]`?",
        code = """
            original = [1, 2, 3]
            other = _____
            other.append(4)
            print(original)
        """.trimIndent(),
        options = listOf(
            "original",
            "list(original)",
            "original[:]",
            "original.copy()"
        ),
        answerIndex = 0,
        explanation = "`other = original` makes both names point to the same list object. Appending 4 to `other` modifies that shared object, so `original` also shows `[1, 2, 3, 4]`. The other options all produce independent copies, leaving `original` as `[1, 2, 3]`."
    ),
    Problem(
        id = "order_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect passing scores",
        summary = "Arrange the lines to build a list of scores that are at least 60.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "scores = [55, 72, 60]",
            "passing = []",
            "    if score >= 60:",
            "for score in scores:",
            "        passing.append(score)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 3, 2, 4),
        explanation = "The input list and result list come first, then the loop, then the condition, then the append inside the `if` block."
    ),
    Problem(
        id = "complexity_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two separate passes",
        summary = "The code loops over the same list twice, but not nested.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for item in items:
                total += item

            count = 0
            for item in items:
                if item > 0:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The list is scanned twice in sequence, so the work is about `2n`. Constant factors do not change Big-O, so the complexity is O(n)."
    ),
    Problem(
        id = "trace_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the current label",
        summary = "A variable changes only when a score beats the current best.",
        prompt = "What is the value of `winner` after the loop finishes?",
        code = """
            records = [("Ava", 5), ("Ben", 9), ("Cy", 7)]
            winner = ""
            best_score = 0

            for name, score in records:
                if score > best_score:
                    best_score = score
                    winner = name
        """.trimIndent(),
        options = listOf(
            "\"Ben\"",
            "\"Ava\"",
            "\"Cy\"",
            "\"\""
        ),
        answerIndex = 0,
        explanation = "Ava becomes the winner first with 5, then Ben replaces her with 9, and Cy does not replace Ben because 7 is not greater than 9."
    ),
    Problem(
        id = "match_medium_junior_23",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 15",
        summary = "Which snippet sums the numbers in the list before printing?",
        prompt = "Which code prints `15`?",
        code = "",
        options = listOf(
            "numbers = [4, 5, 6]\ntotal = 0\nfor number in numbers:\n    total += number\nprint(total)",
            "numbers = [4, 5, 6]\nprint(len(numbers))",
            "numbers = [4, 5, 6]\nprint(numbers[1] + numbers[2])",
            "numbers = [4, 5, 6]\nprint(max(numbers))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet adds all three numbers, producing 15. The others print 3, 11, and 6."
    )
)
