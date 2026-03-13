package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents64 = listOf(
    Problem(
        id = "bug_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Total Never Grows",
        summary = "The loop should add each number to `total`, but one line breaks that idea.",
        prompt = "What is the bug in this code?",
        code = """
            total = 0
            for number in [2, 4, 6]:
                total = number
            print(total)
        """.trimIndent(),
        options = listOf(
            "It should use `+=`.",
            "The list should start with 0.",
            "`print(total)` must be inside the loop.",
            "`for` cannot loop over a list."
        ),
        answerIndex = 0,
        explanation = "Each loop pass replaces `total` with the current number, so the earlier values are lost."
    ),
    Problem(
        id = "output_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Small Countdown",
        summary = "A variable decreases in a loop and is printed once at the end.",
        prompt = "What does this code print?",
        code = """
            count = 5
            for _ in range(2):
                count -= 1
            print(count)
        """.trimIndent(),
        options = listOf(
            "2",
            "3",
            "4",
            "5"
        ),
        answerIndex = 1,
        explanation = "The loop runs twice, so `count` goes from 5 to 4 to 3."
    ),
    Problem(
        id = "purpose_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Collect Long Words",
        summary = "A loop keeps words whose length is greater than 3.",
        prompt = "What does this code do overall?",
        code = """
            words = ["sun", "planet", "sky", "cloud"]
            result = []
            for word in words:
                if len(word) > 3:
                    result.append(word)
            print(result)
        """.trimIndent(),
        options = listOf(
            "It sorts the words by length.",
            "It removes the last word.",
            "It builds a list of long words.",
            "It counts how many words start with `s`."
        ),
        answerIndex = 2,
        explanation = "Only words with length greater than 3 are appended into `result`."
    ),
    Problem(
        id = "fill_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Loop Through a List",
        summary = "Use the keyword that gives one item at a time from the list.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            colors = ["red", "blue", "green"]
            ___ color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "if",
            "for",
            "def",
            "while"
        ),
        answerIndex = 1,
        explanation = "A `for` loop visits each item in the list one by one."
    ),
    Problem(
        id = "order_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Build a Double",
        summary = "Arrange the lines to make a number, double it, and print the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "total = 4",
            "total = total * 2",
            "print(\"ready\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0, 3),
        explanation = "Define `total`, update it, print the doubled value, and then print `ready`."
    ),
    Problem(
        id = "complexity_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Four Loop Passes",
        summary = "The number inside `range` tells you how many times the body runs.",
        prompt = "How many times does the loop run?",
        code = """
            for step in range(4):
                print(step)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "5 times",
            "3 times",
            "1 time"
        ),
        answerIndex = 0,
        explanation = "`range(4)` produces 0, 1, 2, and 3, so the loop body runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `coins`",
        summary = "The variable changes by adding and subtracting simple amounts.",
        prompt = "What is the value of `coins` at the end?",
        code = """
            coins = 2
            coins = coins + 5
            coins = coins - 3
        """.trimIndent(),
        options = listOf(
            "7",
            "5",
            "4",
            "6"
        ),
        answerIndex = 2,
        explanation = "Start at 2, add 5 to get 7, then subtract 3 to get 4."
    ),
    Problem(
        id = "match_easy_student_64",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `6`",
        summary = "Choose the code that prints 6 after adding two small numbers.",
        prompt = "Which code produces `6`?",
        code = "",
        options = listOf(
            "value = 2\nprint(value + 3)",
            "value = 2\nprint(value * 3)",
            "value = 2\nprint(value + 4)",
            "value = 2\nprint(value - 1)"
        ),
        answerIndex = 2,
        explanation = "Adding 4 to 2 gives 6, so the third option matches the output."
    )
)
