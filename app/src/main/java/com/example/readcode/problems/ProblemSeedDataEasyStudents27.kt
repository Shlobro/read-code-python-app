package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents27 = listOf(
    Problem(
        id = "bug_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "A function body must be indented.",
        prompt = "What is the error in this function definition?",
        code = """
            def greet():
            print("Hello, world!")
        """.trimIndent(),
        options = listOf(
            "The print statement is not indented",
            "The function needs arguments",
            "def should be uppercase",
            "print should use single quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, the body of a function must be indented to show that it belongs to the function block."
    ),

    Problem(
        id = "output_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Boolean Logic",
        summary = "Evaluating a simple condition.",
        prompt = "What does this code output?",
        code = """
            is_raining = True
            has_umbrella = False
            print(is_raining and has_umbrella)
        """.trimIndent(),
        options = listOf(
            "False",
            "True",
            "None",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The 'and' operator returns True only if both sides are True. Since has_umbrella is False, the result is False."
    ),

    Problem(
        id = "purpose_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Absolute Value",
        summary = "Using a built-in math function.",
        prompt = "What is the purpose of this code?",
        code = """
            number = -15
            result = abs(number)
            print(result)
        """.trimIndent(),
        options = listOf(
            "It converts a negative number to positive",
            "It rounds the number to the nearest ten",
            "It subtracts 15 from the number",
            "It prints the negative number"
        ),
        answerIndex = 0,
        explanation = "The abs() function calculates the absolute value, which turns negative numbers into positive numbers without changing their magnitude."
    ),

    Problem(
        id = "fill_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List Appending",
        summary = "Adding an element to a list.",
        prompt = "Fill in the blank to add 'apple' to the end of the list.",
        code = """
            fruits = ["banana", "orange"]
            fruits.____("apple")
        """.trimIndent(),
        options = listOf(
            "append",
            "add",
            "insert",
            "push"
        ),
        answerIndex = 0,
        explanation = "The append() method is used in Python to add a single item to the end of a list."
    ),

    Problem(
        id = "order_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple For Loop",
        summary = "Printing elements of a list.",
        prompt = "Arrange the lines to print each animal in the list.",
        code = "",
        options = listOf(
            "animals = [\"cat\", \"dog\"]",
            "for animal in animals:",
            "    print(animal)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the list, then start the for loop to iterate over it, and finally print each element."
    ),

    Problem(
        id = "complexity_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Fixed iterations",
        summary = "Determining loop count.",
        prompt = "How many times does this loop run?",
        code = """
            for i in range(5):
                print("Running")
        """.trimIndent(),
        options = listOf(
            "5",
            "4",
            "6",
            "1"
        ),
        answerIndex = 0,
        explanation = "The range(5) function generates the numbers 0, 1, 2, 3, 4, which is exactly 5 items. The loop runs once for each."
    ),

    Problem(
        id = "trace_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a string",
        summary = "Tracing a variable that changes type.",
        prompt = "What is the final value of `data`?",
        code = """
            data = "Hello"
            data = 42
            data = data + 8
        """.trimIndent(),
        options = listOf(
            "50",
            "Hello42",
            "Hello8",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Python variables can change type. `data` starts as a string, is replaced by the integer 42, and then 8 is added to make it 50."
    ),

    Problem(
        id = "match_easy_students_27_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: [1, 2, 3]",
        summary = "Creating a simple list.",
        prompt = "Which code snippet prints `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(1, 2, 3)",
            "print(\"[1; 2; 3]\")",
            "print((1, 2, 3))"
        ),
        answerIndex = 0,
        explanation = "Square brackets are used to define a list in Python. Printing it directly gives the output `[1, 2, 3]`."
    )
)
