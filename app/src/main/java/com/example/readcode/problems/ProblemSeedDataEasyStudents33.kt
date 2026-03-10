package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents33 = listOf(
    Problem(
        id = "bug_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Forgotten Return",
        summary = "A function prints instead of returning the result.",
        prompt = "Why does this code print 'None' at the end?",
        code = """
            def double_number(x):
                print(x * 2)

            result = double_number(5)
            print(result)
        """.trimIndent(),
        options = listOf(
            "The function prints the value but does not return it",
            "`x * 2` is invalid syntax in Python",
            "The `result` variable must be declared with `var`",
            "You cannot print `result` if it is an integer"
        ),
        answerIndex = 0,
        explanation = "Functions that don't have a `return` statement return `None`. It prints 10, but the result assigned is `None`."
    ),
    Problem(
        id = "output_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Simple subtraction",
        summary = "Calculating remaining change.",
        prompt = "What does this code print?",
        code = """
            paid = 20
            cost = 15
            change = paid - cost
            print(change)
        """.trimIndent(),
        options = listOf(
            "5",
            "35",
            "-5",
            "0"
        ),
        answerIndex = 0,
        explanation = "The code subtracts the cost (15) from the amount paid (20), which is 5."
    ),
    Problem(
        id = "purpose_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Boolean flag",
        summary = "Setting a flag based on a condition.",
        prompt = "What does `is_passing` represent?",
        code = """
            score = 85
            is_passing = score >= 50
        """.trimIndent(),
        options = listOf(
            "True if the score is at least 50, False otherwise",
            "It rounds the score up to 50",
            "It checks if the score is exactly 50",
            "It causes an error because `>=` cannot assign values"
        ),
        answerIndex = 0,
        explanation = "The expression `score >= 50` evaluates to a boolean (`True`), which is then stored in the `is_passing` variable."
    ),
    Problem(
        id = "fill_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Creating a list",
        summary = "Defining a list of numbers.",
        prompt = "Which syntax correctly defines a list?",
        code = """
            scores = ___90, 85, 95___
        """.trimIndent(),
        options = listOf(
            "[90, 85, 95]",
            "(90, 85, 95)",
            "{90, 85, 95}",
            "\"90, 85, 95\""
        ),
        answerIndex = 0,
        explanation = "In Python, lists are created using square brackets `[]`."
    ),
    Problem(
        id = "order_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Read file lines",
        summary = "Open and read a file step by step.",
        prompt = "Arrange the lines to open a file, read its lines, print them, and close the file.",
        code = "",
        options = listOf(
            "file = open('data.txt', 'r')",
            "lines = file.readlines()",
            "for line in lines:",
            "    print(line)",
            "file.close()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First open the file, then read the lines. Next, iterate over the lines and print them. Finally, close the file."
    ),
    Problem(
        id = "complexity_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop execution",
        summary = "A simple range loop.",
        prompt = "How many times does this loop run?",
        code = """
            for i in range(5):
                print("Hello")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "1 time"
        ),
        answerIndex = 0,
        explanation = "`range(5)` generates numbers from 0 to 4 (5 numbers in total), so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Accumulator trace",
        summary = "Tracking a sum using +=.",
        prompt = "What is the value of `total` after the code runs?",
        code = """
            total = 0
            total += 2
            total += 3
        """.trimIndent(),
        options = listOf(
            "5",
            "0",
            "2",
            "3"
        ),
        answerIndex = 0,
        explanation = "The variable starts at 0, adds 2 (becoming 2), then adds 3 (becoming 5)."
    ),
    Problem(
        id = "match_easy_student_33",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print formatting",
        summary = "Printing variables inside strings.",
        prompt = "Which line correctly prints 'Hello Alice' using f-strings?",
        code = "",
        options = listOf(
            "print(f\"Hello {name}\")",
            "print(\"Hello {name}\")",
            "print(f\"Hello name\")",
            "print(\"Hello\" + \"name\")"
        ),
        answerIndex = 0,
        explanation = "An f-string starts with `f` and evaluates variables placed inside curly braces `{}`."
    )
)
