package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents20 = listOf(
    Problem(
        id = "bug_easy_student_20_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Invalid Variable Name",
        summary = "A variable is given an invalid name.",
        prompt = "Why will this code crash?",
        code = """
            1st_place = "Alice"
            print(1st_place)
        """.trimIndent(),
        options = listOf(
            "Variable names cannot start with a number",
            "The variable value must be a number",
            "You cannot print strings",
            "Variables need to be declared with var"
        ),
        answerIndex = 0,
        explanation = "In Python, variable names must start with a letter or an underscore, never a number."
    ),
    Problem(
        id = "output_easy_student_20_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Adding two strings together.",
        prompt = "What does this print?",
        code = """
            first = "Cat"
            second = "Dog"
            print(first + second)
        """.trimIndent(),
        options = listOf(
            "CatDog",
            "Cat Dog",
            "Cat+Dog",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings together without adding any extra spaces."
    ),
    Problem(
        id = "purpose_easy_student_20_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Absolute Value",
        summary = "Using a built-in math function.",
        prompt = "What does the `abs()` function do here?",
        code = """
            num = -5
            result = abs(num)
        """.trimIndent(),
        options = listOf(
            "Returns the positive distance from zero",
            "Makes the number negative",
            "Rounds the number",
            "Subtracts the number from itself"
        ),
        answerIndex = 0,
        explanation = "The `abs()` function returns the absolute value of a number, turning negative numbers into positive ones."
    ),
    Problem(
        id = "fill_easy_student_20_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check Equality",
        summary = "Comparing two values.",
        prompt = "Fill in the blank to check if the score is exactly 100.",
        code = """
            score = 100
            if score ___ 100:
                print("Perfect!")
        """.trimIndent(),
        options = listOf(
            "==",
            "=",
            "!=",
            ">"
        ),
        answerIndex = 0,
        explanation = "The `==` operator checks if two values are equal. A single `=` is used for assigning values to variables."
    ),
    Problem(
        id = "order_easy_student_20_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple Loop",
        summary = "Arrange the code to create a loop that prints a message and then finishes.",
        prompt = "Put the lines in the correct order.",
        code = "",
        options = listOf(
            "print(\"Done\")",
            "for i in range(3):",
            "    print(\"Looping\")"
        ),
        answerIndex = -1,
        correctOrder = listOf(1, 2, 0),
        explanation = "The loop header starts first, followed by the indented body. The final print is unindented, executing after the loop finishes."
    ),
    Problem(
        id = "complexity_easy_student_20_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List Iteration",
        summary = "Looping through elements in a list.",
        prompt = "How many times does the print statement run?",
        code = """
            colors = ["red", "green", "blue"]
            for c in colors:
                print(c)
        """.trimIndent(),
        options = listOf(
            "3",
            "1",
            "4",
            "0"
        ),
        answerIndex = 0,
        explanation = "The loop runs once for each item in the list. Since there are 3 colors, it prints 3 times."
    ),
    Problem(
        id = "trace_easy_student_20_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Reassignment",
        summary = "Tracking a variable as its value changes.",
        prompt = "What is the final value of `x`?",
        code = """
            x = 10
            x = 20
            x = x + 5
        """.trimIndent(),
        options = listOf(
            "25",
            "15",
            "30",
            "20"
        ),
        answerIndex = 0,
        explanation = "The variable `x` is assigned 10, then reassigned 20. Finally, 5 is added to 20, making it 25."
    ),
    Problem(
        id = "match_easy_student_20_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print Hello",
        summary = "Printing a simple greeting.",
        prompt = "Which snippet prints exactly `Hello World`?",
        code = "",
        options = listOf(
            "print(\"Hello World\")",
            "print(\"Hello\" + \"World\")",
            "print(\"HelloWorld\")",
            "print(\"Hello, World\")"
        ),
        answerIndex = 0,
        explanation = "Only `print(\"Hello World\")` prints exactly 'Hello World' with the space. The others either miss the space or add a comma."
    )
)
