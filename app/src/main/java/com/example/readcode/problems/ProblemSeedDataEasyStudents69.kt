package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents69 = listOf(
    Problem(
        id = "bug_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Last Item Is Skipped",
        summary = "A loop should print every color in the list.",
        prompt = "What is the real bug in this code?",
        code = """
            colors = ["red", "blue", "green"]
            for i in range(len(colors) - 1):
                print(colors[i])
        """.trimIndent(),
        options = listOf(
            "The print needs more indentation.",
            "The list must be sorted first.",
            "The loop stops before the last index.",
            "Strings cannot be stored in a list."
        ),
        answerIndex = 2,
        explanation = "`range(len(colors) - 1)` only uses indexes 0 and 1, so `green` is never printed."
    ),
    Problem(
        id = "output_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Multiply Then Add",
        summary = "The variable changes in two simple steps.",
        prompt = "What does this code print?",
        code = """
            value = 2
            value = value * 3
            value = value + 1
            print(value)
        """.trimIndent(),
        options = listOf(
            "5",
            "7",
            "6",
            "9"
        ),
        answerIndex = 1,
        explanation = "The value goes from 2 to 6, then from 6 to 7."
    ),
    Problem(
        id = "purpose_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Build a Running Total",
        summary = "A loop adds each number into one variable.",
        prompt = "What does this code do overall?",
        code = """
            numbers = [2, 4, 6]
            total = 0
            for number in numbers:
                total += number
        """.trimIndent(),
        options = listOf(
            "It adds the numbers in the list.",
            "It finds the biggest number.",
            "It removes even values.",
            "It prints each item twice."
        ),
        answerIndex = 0,
        explanation = "The loop updates `total` by adding each list item, so it computes the sum."
    ),
    Problem(
        id = "fill_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Loop Over Five Values",
        summary = "One built-in function is missing from the `for` loop.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            for i in __(5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "list",
            "len",
            "print",
            "range"
        ),
        answerIndex = 3,
        explanation = "`range(5)` produces the values 0 through 4 for the loop."
    ),
    Problem(
        id = "order_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Count Items",
        summary = "Arrange the lines to store a list and print its length.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "size = len(items)",
            "print(size)",
            "items = [\"pen\", \"book\"]"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1),
        explanation = "Create `items` first, then compute `size`, then print the result."
    ),
    Problem(
        id = "complexity_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Two Prints Per Turn",
        summary = "A loop prints one line twice in each iteration.",
        prompt = "How many times does `print(\"hi\")` run?",
        code = """
            for i in range(3):
                print("hi")
                print("hi")
        """.trimIndent(),
        options = listOf(
            "3 times",
            "5 times",
            "6 times",
            "2 times"
        ),
        answerIndex = 2,
        explanation = "The loop runs 3 times, and each iteration prints `hi` twice, for 6 total prints."
    ),
    Problem(
        id = "trace_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `score`",
        summary = "The variable changes inside a short loop.",
        prompt = "What is the value of `score` after the code finishes?",
        code = """
            score = 1
            for i in range(3):
                score += 2
        """.trimIndent(),
        options = listOf(
            "5",
            "7",
            "6",
            "3"
        ),
        answerIndex = 1,
        explanation = "Starting from 1, the loop adds 2 three times, so the final value is 7."
    ),
    Problem(
        id = "match_easy_student_69",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `[0, 1, 2]`",
        summary = "Choose the code that prints the first three counting numbers starting at zero.",
        prompt = "Which code produces `[0, 1, 2]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(list(range(1, 3)))",
            "print(list(range(3)))",
            "print([0, 1, 2, 3])"
        ),
        answerIndex = 2,
        explanation = "`range(3)` generates 0, 1, 2, and converting it to a list prints `[0, 1, 2]`."
    )
)
