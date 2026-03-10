package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents25 = listOf(
    Problem(
        id = "bug_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Division by zero risk",
        summary = "A basic arithmetic error.",
        prompt = "What is the bug in this code that calculates the average of a list?",
        code = """
            def average(scores):
                total = sum(scores)
                return total / len(scores)

            print(average([]))
        """.trimIndent(),
        options = listOf(
            "It divides by zero if the list is empty",
            "`sum()` cannot be used on a list",
            "It returns an integer instead of a float",
            "`len()` doesn't work on empty lists"
        ),
        answerIndex = 0,
        explanation = "When the list is empty, `len(scores)` evaluates to 0, causing a `ZeroDivisionError`."
    ),

    Problem(
        id = "output_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Modulo Operator",
        summary = "Finding the remainder of division.",
        prompt = "What does this code output?",
        code = """
            x = 10
            y = 3
            print(x % y)
        """.trimIndent(),
        options = listOf(
            "1",
            "3",
            "3.33",
            "0"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder of the division. 10 divided by 3 is 3 with a remainder of 1."
    ),

    Problem(
        id = "purpose_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Filtering even numbers",
        summary = "Using a loop and conditional to filter data.",
        prompt = "What is the purpose of this function?",
        code = """
            def process(data):
                result = []
                for item in data:
                    if item % 2 == 0:
                        result.append(item)
                return result
        """.trimIndent(),
        options = listOf(
            "Returns a list of all even numbers from the input",
            "Returns a list of all odd numbers from the input",
            "Multiplies each number by 2",
            "Removes all zeros from the list"
        ),
        answerIndex = 0,
        explanation = "The function iterates through `data` and uses the modulo operator to append only numbers evenly divisible by 2 (even numbers) to the result list."
    ),

    Problem(
        id = "fill_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String length",
        summary = "Getting the number of characters in a string.",
        prompt = "Fill in the blank to print the number of characters in the `message`.",
        code = """
            message = "Hello, World!"
            print(___(message))
        """.trimIndent(),
        options = listOf(
            "len",
            "count",
            "size",
            "length"
        ),
        answerIndex = 0,
        explanation = "In Python, `len()` is the built-in function used to get the length (number of items or characters) of an object like a string."
    ),

    Problem(
        id = "order_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple while loop",
        summary = "Setting up a loop that counts down.",
        prompt = "Arrange the lines to create a countdown loop that prints numbers from 3 down to 1.",
        code = "",
        options = listOf(
            "count = 3",
            "while count > 0:",
            "    print(count)",
            "    count -= 1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First initialize the variable, then start the loop with a condition, then print the value, and finally decrement the counter to avoid an infinite loop."
    ),

    Problem(
        id = "complexity_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Nested loop iterations",
        summary = "Determining the total number of iterations for a nested loop.",
        prompt = "How many times will the string \"Hello\" be printed?",
        code = """
            for i in range(2):
                for j in range(3):
                    print("Hello")
        """.trimIndent(),
        options = listOf(
            "6",
            "5",
            "3",
            "2"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs 2 times, and for each iteration, the inner loop runs 3 times. The total is 2 * 3 = 6 times."
    ),

    Problem(
        id = "trace_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Dictionary updates",
        summary = "Tracing changes to a dictionary's values.",
        prompt = "What is the value of `counts['apple']` at the end?",
        code = """
            counts = {'apple': 1, 'banana': 2}
            counts['apple'] = counts['apple'] + 1
            counts['apple'] += 2
        """.trimIndent(),
        options = listOf(
            "4",
            "1",
            "3",
            "2"
        ),
        answerIndex = 0,
        explanation = "The value of 'apple' starts at 1. It is first incremented by 1 (becoming 2), then incremented by 2 (becoming 4)."
    ),

    Problem(
        id = "match_easy_students_25_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: [1, 2, 3]",
        summary = "Creating a basic list in Python.",
        prompt = "Which code snippet prints `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(1, 2, 3)",
            "print({1, 2, 3})",
            "print((1, 2, 3))"
        ),
        answerIndex = 0,
        explanation = "Square brackets `[]` are used to define a list in Python, which prints out as `[1, 2, 3]`."
    )
)
