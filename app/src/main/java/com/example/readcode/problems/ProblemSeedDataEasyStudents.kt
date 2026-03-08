package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents = listOf(
    Problem(
        id = "bug_easy_student_2",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing parentheses",
        summary = "A function call is missing its parentheses.",
        prompt = "Why does this code not print 'Hello'?",
        code = """
            def greet():
                print("Hello")
                
            greet
        """.trimIndent(),
        options = listOf(
            "`greet` needs parentheses to be called",
            "The function needs a return statement",
            "`print` should be uppercase",
            "The function name is invalid"
        ),
        answerIndex = 0,
        explanation = "In Python, simply writing the name of a function does not run it. You must add `()` to call the function."
    ),
    Problem(
        id = "output_easy_student_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Boolean logic",
        summary = "Using `and` and `not` operators.",
        prompt = "What does this code print?",
        code = """
            is_weekend = True
            is_raining = False
            print(is_weekend and not is_raining)
        """.trimIndent(),
        options = listOf(
            "True",
            "False",
            "None",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Since `is_weekend` is True and `is_raining` is False (so `not is_raining` is True), both sides of the `and` are True."
    ),
    Problem(
        id = "purpose_easy_student_2",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Find maximum",
        summary = "A function that returns the largest of two numbers.",
        prompt = "What does this function do?",
        code = """
            def compare(x, y):
                if x > y:
                    return x
                return y
        """.trimIndent(),
        options = listOf(
            "Returns the larger of the two numbers",
            "Returns the smaller of the two numbers",
            "Checks if the numbers are equal",
            "Adds the two numbers together"
        ),
        answerIndex = 0,
        explanation = "If `x` is greater than `y`, it returns `x`. Otherwise, it returns `y`. This finds the maximum value."
    ),
    Problem(
        id = "fill_easy_student_2",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List index",
        summary = "Accessing the first element of a list.",
        prompt = "Which index fills the blank to print 'apple'?",
        code = """
            fruits = ["apple", "banana", "orange"]
            print(fruits[___])
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "apple",
            "first"
        ),
        answerIndex = 0,
        explanation = "Lists in Python are zero-indexed, meaning the first element is at index `0`."
    )
)
