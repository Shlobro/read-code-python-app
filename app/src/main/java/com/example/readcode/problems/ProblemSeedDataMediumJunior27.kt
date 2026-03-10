package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior27 = listOf(
    Problem(
        id = "bug_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong dictionary key",
        summary = "The loop should count each word, but one line updates the wrong entry.",
        prompt = "What is the real bug in this code?",
        code = """
            words = ["red", "blue", "red"]
            counts = {}

            for word in words:
                counts["word"] = counts.get("word", 0) + 1
        """.trimIndent(),
        options = listOf(
            "It uses the string `\"word\"` instead of the variable `word` as the key",
            "The dictionary should be a list",
            "The loop should start at index 1",
            "`get()` cannot be used with dictionaries"
        ),
        answerIndex = 0,
        explanation = "Using `\"word\"` creates or updates one literal key. To count each item, the code must use the variable `word`."
    ),
    Problem(
        id = "output_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Insert before print",
        summary = "A list is modified in place before it is printed.",
        prompt = "What does this code print?",
        code = """
            nums = [1, 3, 4]
            nums.insert(1, 2)
            print(nums[-3:])
        """.trimIndent(),
        options = listOf(
            "[2, 3, 4]",
            "[1, 2, 3]",
            "[1, 2, 3, 4]",
            "[3, 4]"
        ),
        answerIndex = 0,
        explanation = "After `insert(1, 2)`, the list becomes `[1, 2, 3, 4]`. The slice `[-3:]` keeps the last three items."
    ),
    Problem(
        id = "purpose_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep the latest status",
        summary = "A dictionary is updated as records are processed in order.",
        prompt = "What does this function return overall?",
        code = """
            def latest_status(records):
                result = {}
                for user_id, status in records:
                    result[user_id] = status
                return result
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each user to their most recent status in the records",
            "A list of users who appear more than once",
            "A dictionary counting how many statuses each user has",
            "A list of statuses sorted alphabetically"
        ),
        answerIndex = 0,
        explanation = "Each assignment stores the current status under that user ID, so later records overwrite earlier ones for the same user."
    ),
    Problem(
        id = "fill_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Skip missing values",
        summary = "The loop should ignore `None` items and keep only real scores.",
        prompt = "Which option fills the blank correctly?",
        code = """
            scores = [10, None, 8, None, 7]
            cleaned = []

            for score in scores:
                if score is __:
                    continue
                cleaned.append(score)
        """.trimIndent(),
        options = listOf(
            "None",
            "False",
            "0",
            "\"\""
        ),
        answerIndex = 0,
        explanation = "The loop should skip only missing entries, and Python checks that with `is None`."
    ),
    Problem(
        id = "order_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build lowercase tags",
        summary = "Arrange the lines so unique lowercase tags are collected from a list.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "tags = []",
            "for label in labels:",
            "labels = [\"UI\", \"api\", \"UI\", \"Docs\"]",
            "    value = label.lower()",
            "    if value not in tags:",
            "        tags.append(value)",
            "print(tags)"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1, 3, 4, 5, 6),
        explanation = "The source list and result list must exist before the loop. Each label is lowercased, checked for duplicates, and appended before printing."
    ),
    Problem(
        id = "complexity_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Compare every pair",
        summary = "Two loops visit every ordered pair of positions in the list.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            def count_matches(values):
                total = 0
                for i in range(len(values)):
                    for j in range(len(values)):
                        if values[i] == values[j]:
                            total += 1
                return total
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "For each of the `n` outer iterations, the inner loop also runs `n` times, so the total work grows quadratically."
    ),
    Problem(
        id = "trace_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the queue",
        summary = "The list is updated from both ends before its final value is checked.",
        prompt = "What is the value of `queue` after the code finishes?",
        code = """
            queue = ["a", "b", "c"]
            first = queue.pop(0)
            queue.append(first.upper())
            queue.remove("b")
        """.trimIndent(),
        options = listOf(
            "['c', 'A']",
            "['a', 'c', 'A']",
            "['b', 'c', 'A']",
            "['c', 'a']"
        ),
        answerIndex = 0,
        explanation = "Popping index 0 removes `'a'`, appending `first.upper()` adds `'A'`, and removing `'b'` leaves `['c', 'A']`."
    ),
    Problem(
        id = "match_medium_junior_27",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'pen': 2, 'book': 1}",
        summary = "Which snippet counts repeated strings into a dictionary?",
        prompt = "Which code prints `{'pen': 2, 'book': 1}`?",
        code = "",
        options = listOf(
            "items = [\"pen\", \"book\", \"pen\"]\ncounts = {}\nfor item in items:\n    counts[item] = counts.get(item, 0) + 1\nprint(counts)",
            "items = [\"pen\", \"book\", \"pen\"]\ncounts = {}\nfor item in items:\n    counts[item] = 1\nprint(counts)",
            "items = [\"pen\", \"book\", \"pen\"]\nprint(set(items))",
            "items = [\"pen\", \"book\", \"pen\"]\nprint(len(items))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet increments each key as it appears, producing the required counts for both items."
    )
)
