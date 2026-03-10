package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents22 = listOf(
    Problem(
        id = "bug_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing quotes",
        summary = "A string is not properly defined.",
        prompt = "What is wrong with this variable assignment?",
        code = """
            message = Hello World
            print(message)
        """.trimIndent(),
        options = listOf(
            "The text needs quotes around it",
            "`message` is not a valid variable name",
            "`print` needs a capital P",
            "There should be a semicolon at the end"
        ),
        answerIndex = 0,
        explanation = "In Python, string literals must be enclosed in single or double quotes."
    ),

    Problem(
        id = "output_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List indexing",
        summary = "Accessing an item from a list.",
        prompt = "What does this code print?",
        code = """
            colors = ["red", "green", "blue"]
            print(colors[1])
        """.trimIndent(),
        options = listOf("green", "red", "blue", "colors"),
        answerIndex = 0,
        explanation = "Python lists are 0-indexed, so `colors[1]` refers to the second item, which is 'green'."
    ),

    Problem(
        id = "purpose_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check for empty",
        summary = "Using the length of a list.",
        prompt = "What does this function check?",
        code = """
            def check_list(items):
                if len(items) == 0:
                    return True
                else:
                    return False
        """.trimIndent(),
        options = listOf(
            "If the list is empty",
            "If the list has negative numbers",
            "If the list contains zeros",
            "If the list is too long"
        ),
        answerIndex = 0,
        explanation = "The function returns `True` if the length of the list is 0, which means the list is empty."
    ),

    Problem(
        id = "fill_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Joining two strings together.",
        prompt = "Fill in the blank to combine the strings.",
        code = """
            first = "Super"
            second = "man"
            hero = first ___ second
            print(hero)
        """.trimIndent(),
        options = listOf("+", "-", "*", "/"),
        answerIndex = 0,
        explanation = "The `+` operator is used to concatenate (join) strings together in Python."
    ),

    Problem(
        id = "order_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Calculate area",
        summary = "Multiply width and height.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "print(area)",
            "width = 5",
            "height = 10",
            "area = width * height"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 3, 0),
        explanation = "First, define the width and height, then calculate the area, and finally print the result."
    ),

    Problem(
        id = "complexity_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Print twice",
        summary = "How many times does print run?",
        prompt = "How many times does the print statement execute?",
        code = """
            for i in range(2):
                print("Hello")
        """.trimIndent(),
        options = listOf("2", "1", "3", "0"),
        answerIndex = 0,
        explanation = "The `range(2)` function creates a sequence of 2 numbers (0 and 1), so the loop runs 2 times."
    ),

    Problem(
        id = "trace_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Count down",
        summary = "Decreasing a variable.",
        prompt = "What is the value of `count` at the end of the code?",
        code = """
            count = 3
            count = count - 1
            count = count - 1
        """.trimIndent(),
        options = listOf("1", "2", "0", "3"),
        answerIndex = 0,
        explanation = "The count starts at 3, decreases by 1 to become 2, and then decreases by 1 again to become 1."
    ),

    Problem(
        id = "match_easy_students_22_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: 10",
        summary = "Which snippet prints the number 10?",
        prompt = "Which code produces exactly the output `10`?",
        code = "",
        options = listOf(
            "print(5 + 5)",
            "print(5 * 5)",
            "print(5 - 5)",
            "print(5 / 5)"
        ),
        answerIndex = 0,
        explanation = "`5 + 5` evaluates to 10, which is then printed."
    )
)
