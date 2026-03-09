package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents6 = listOf(
    Problem(
        id = "bug_easy_student_6_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "An if-statement is missing its colon.",
        prompt = "Why does this code result in a SyntaxError?",
        code = """
            age = 18
            if age >= 18
                print("Adult")
        """.trimIndent(),
        options = listOf(
            "Missing colon ':' at the end of the if statement",
            "The print statement is not indented",
            "age must be in parentheses",
            "if should be capitalized"
        ),
        answerIndex = 0,
        explanation = "In Python, control flow statements like `if`, `for`, and `while` must end with a colon `:`."
    ),
    Problem(
        id = "output_easy_student_6_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Order of operations",
        summary = "Basic arithmetic with multiplication and subtraction.",
        prompt = "What does this code print?",
        code = """
            a = 10
            b = 5
            print(a - b * 2)
        """.trimIndent(),
        options = listOf(
            "0",
            "10",
            "20",
            "-10"
        ),
        answerIndex = 0,
        explanation = "Multiplication happens before subtraction. `5 * 2` is `10`, and `10 - 10` is `0`."
    ),
    Problem(
        id = "purpose_easy_student_6_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Greeting function",
        summary = "A function that concatenates strings.",
        prompt = "What does this function do?",
        code = """
            def greet(name):
                return "Hello " + name
        """.trimIndent(),
        options = listOf(
            "Returns a greeting string with the provided name",
            "Prints a greeting directly to the screen",
            "Asks the user to input their name",
            "Calculates the length of the name"
        ),
        answerIndex = 0,
        explanation = "The function takes a `name` and returns a new string combining 'Hello ' and the name. It uses `return`, not `print`."
    ),
    Problem(
        id = "fill_easy_student_6_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List syntax",
        summary = "Closing a list correctly.",
        prompt = "Which character fills the blank to properly close the list?",
        code = """
            colors = ["red", "green", "blue"___
        """.trimIndent(),
        options = listOf(
            "]",
            ")",
            "}",
            ";"
        ),
        answerIndex = 0,
        explanation = "Lists in Python are created and enclosed using square brackets `[]`."
    ),
    Problem(
        id = "order_easy_student_6_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap variables",
        summary = "Swapping two values using a temporary variable.",
        prompt = "Arrange the lines to swap the values of x and y using a temporary variable.",
        code = "",
        options = listOf(
            "x = y",
            "temp = x",
            "y = temp"
        ),
        answerIndex = 0, // Ignored for ORDER_STEPS
        correctOrder = listOf(1, 0, 2),
        explanation = "First, save `x` in `temp`. Then, assign `y` to `x`. Finally, assign the saved `temp` value to `y`."
    ),
    Problem(
        id = "complexity_easy_student_6_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple loop count",
        summary = "Determining the number of loop iterations.",
        prompt = "How many times will 'Hello' be printed?",
        code = """
            for i in range(5):
                print("Hello")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "`range(5)` generates numbers from 0 to 4 (5 numbers in total), so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_6_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable update",
        summary = "Tracking a variable's value as it changes.",
        prompt = "What is the final value of `count`?",
        code = """
            count = 0
            count = count + 1
            count = count + 2
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "1",
            "0"
        ),
        answerIndex = 0,
        explanation = "`count` starts at 0. Adding 1 makes it 1. Then adding 2 makes it 3."
    ),
    Problem(
        id = "match_easy_student_6_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Match integer output",
        summary = "Finding the code that produces a specific number.",
        prompt = "Which code produces the exact output: `10`?",
        code = "",
        options = listOf(
            "print(5 + 5)",
            "print(\"5 + 5\")",
            "print(5 * 5)",
            "print(\"10\" + \"0\")"
        ),
        answerIndex = 0,
        explanation = "`5 + 5` evaluates to the integer 10. `\"5 + 5\"` prints the literal string, `5 * 5` is 25, and `\"10\" + \"0\"` prints '100'."
    )
)
