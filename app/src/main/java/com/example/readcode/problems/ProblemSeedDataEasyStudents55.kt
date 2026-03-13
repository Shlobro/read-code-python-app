package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents55 = listOf(
    Problem(
        id = "bug_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Update",
        summary = "A loop condition never changes.",
        prompt = "Why does this loop never stop?",
        code = """
            count = 3
            while count > 0:
                print(count)
        """.trimIndent(),
        options = listOf(
            "The condition is wrong.",
            "`print` needs parentheses around `count`.",
            "The loop never changes `count`.",
            "The loop should use `for` with a `range` value instead."
        ),
        answerIndex = 2,
        explanation = "Because `count` never changes, `count > 0` stays true forever."
    ),
    Problem(
        id = "output_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Name Tag",
        summary = "Two strings are joined with a space.",
        prompt = "What does this code print?",
        code = """
            first = "Ada"
            last = "Lovelace"
            print(first + " " + last)
        """.trimIndent(),
        options = listOf(
            "AdaLovelace",
            "Ada Lovelace",
            "Ada Lovelace!",
            "Ada"
        ),
        answerIndex = 1,
        explanation = "The code joins the two strings with a space in the middle."
    ),
    Problem(
        id = "purpose_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Add One",
        summary = "A function changes the number it receives.",
        prompt = "What does this function do?",
        code = """
            def next_value(n):
                return n + 1
        """.trimIndent(),
        options = listOf(
            "Adds 1 to `n`.",
            "Returns the number minus one.",
            "Returns the number times one.",
            "Returns the original input unchanged."
        ),
        answerIndex = 0,
        explanation = "The function adds 1 to `n` and returns the result."
    ),
    Problem(
        id = "fill_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Loop Variable",
        summary = "Choose the keyword that starts a `for` loop.",
        prompt = "Fill in the blank to loop through the list.",
        code = """
            colors = ["red", "blue"]
            __ color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "if",
            "for",
            "def",
            "while"
        ),
        answerIndex = 1,
        explanation = "Python `for` loops start with the keyword `for`."
    ),
    Problem(
        id = "order_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print Double",
        summary = "Arrange the lines to double a number and show it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "number = 4",
            "total = number * 2",
            "print(\"ready\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0, 3),
        explanation = "Create `number`, compute `total`, print it, and then print `ready`."
    ),
    Problem(
        id = "complexity_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Turns",
        summary = "A small `range` controls the loop.",
        prompt = "How many times does `print(i)` run?",
        code = """
            for i in range(3):
                print(i)
        """.trimIndent(),
        options = listOf(
            "2 times",
            "4 times",
            "3 times",
            "1 time"
        ),
        answerIndex = 2,
        explanation = "`range(3)` gives 0, 1, and 2, so the loop runs three times."
    ),
    Problem(
        id = "trace_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `score`",
        summary = "A variable changes with one subtraction.",
        prompt = "What is the value of `score` at the end?",
        code = """
            score = 9
            score = score - 2
            score = score + 5
        """.trimIndent(),
        options = listOf(
            "12",
            "7",
            "14",
            "11"
        ),
        answerIndex = 0,
        explanation = "Start at 9, subtract 2 to get 7, then add 5 to get 12."
    ),
    Problem(
        id = "match_easy_student_55",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `5`",
        summary = "Choose the code that prints exactly one number.",
        prompt = "Which code produces the output `5`?",
        code = "",
        options = listOf(
            "print(2 + 2)",
            "print(10 // 2)",
            "print(5 + 1)",
            "print(\"5\")"
        ),
        answerIndex = 1,
        explanation = "`10 // 2` evaluates to the number `5`."
    )
)
