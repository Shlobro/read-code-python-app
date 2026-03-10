package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior35 = listOf(
    Problem(
        id = "bug_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "String used as a number",
        summary = "The loop reads numbers from text, but the total line fails.",
        prompt = "What is the actual bug in this code?",
        code = """
            values = ["10", "20", "30"]
            total = 0

            for value in values:
                total += value

            print(total)
        """.trimIndent(),
        options = listOf(
            "`value` is a string, so it must be converted before adding to `total`",
            "The loop should start at index 1",
            "`total` should start as an empty string",
            "The `print` call must be inside the loop"
        ),
        answerIndex = 0,
        explanation = "The items in `values` are strings, so `total += value` tries to add a string to an integer. Converting with `int(value)` fixes it."
    ),
    Problem(
        id = "output_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sorted names",
        summary = "The list is sorted alphabetically before indexing.",
        prompt = "What does this code print?",
        code = """
            names = ["Mia", "Ava", "Zoe"]
            names.sort()
            print(names[1])
        """.trimIndent(),
        options = listOf("Mia", "Ava", "Zoe", "Error"),
        answerIndex = 0,
        explanation = "After sorting, the list becomes `[\"Ava\", \"Mia\", \"Zoe\"]`, so index 1 is `Mia`."
    ),
    Problem(
        id = "purpose_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group passing scores",
        summary = "The function keeps only names whose scores meet the threshold.",
        prompt = "What does this function return overall?",
        code = """
            def passed_students(scores):
                result = []
                for name, score in scores.items():
                    if score >= 60:
                        result.append(name)
                return result
        """.trimIndent(),
        options = listOf(
            "A list of student names whose scores are at least 60",
            "A dictionary mapping each student name to `True` or `False`",
            "The highest score in the dictionary",
            "A list of scores that are below 60"
        ),
        answerIndex = 0,
        explanation = "The function loops through each `(name, score)` pair and appends only the names whose scores are 60 or higher."
    ),
    Problem(
        id = "fill_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Create a fallback value",
        summary = "The code should use 0 when the key is missing.",
        prompt = "Which option fills the blank correctly?",
        code = """
            data = {"apples": 4}
            oranges = data.get("oranges", ___)
            print(oranges)
        """.trimIndent(),
        options = listOf("0", "None", "\"0\"", "[]"),
        answerIndex = 0,
        explanation = "Passing `0` as the second argument to `get()` returns 0 when the key is not present."
    ),
    Problem(
        id = "order_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count long words",
        summary = "Arrange the lines so the code counts words longer than three letters and prints the count.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "words = [\"ant\", \"bear\", \"cat\", \"tiger\"]",
            "count = 0",
            "for word in words:",
            "    if len(word) > 3:",
            "        count += 1",
            "print(count)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the input list and counter first, loop over the words, increment inside the `if`, and print after the loop finishes."
    ),
    Problem(
        id = "complexity_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Single pass maximum",
        summary = "The code scans the list once to track the largest value.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            largest = items[0]
            for item in items:
                if item > largest:
                    largest = item
        """.trimIndent(),
        options = listOf("O(n)", "O(n^2)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "The loop examines each item once, so the total work grows linearly with the number of items."
    ),
    Problem(
        id = "trace_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace after slicing",
        summary = "A list is shortened and then extended.",
        prompt = "What is the value of `items` after the code finishes?",
        code = """
            items = [1, 2, 3, 4]
            items = items[1:3]
            items.append(9)
        """.trimIndent(),
        options = listOf("[2, 3, 9]", "[1, 2, 3, 9]", "[2, 3]", "[1, 2, 9]"),
        answerIndex = 0,
        explanation = "The slice `items[1:3]` creates `[2, 3]`, and then `append(9)` changes it to `[2, 3, 9]`."
    ),
    Problem(
        id = "match_medium_junior_35",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 3",
        summary = "Which snippet counts how many values are greater than 5?",
        prompt = "Which code prints `3`?",
        code = "",
        options = listOf(
            "values = [2, 8, 5, 9, 7]\ncount = 0\nfor value in values:\n    if value > 5:\n        count += 1\nprint(count)",
            "values = [2, 8, 5, 9, 7]\nprint(sum(values))",
            "values = [2, 8, 5, 9, 7]\nprint(values[3])",
            "values = [2, 8, 5, 9, 7]\nprint(len(values))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet counts values greater than 5. In that list, 8, 9, and 7 match, so it prints 3."
    )
)
