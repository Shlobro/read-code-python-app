package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents38 = listOf(
    Problem(
        id = "bug_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Indentation Error",
        summary = "Code blocks must be indented in Python.",
        prompt = "Why will this code crash?",
        code = """
            def greet():
            print("Hello there!")
            
            greet()
        """.trimIndent(),
        options = listOf(
            "The print statement is not indented",
            "The function name is invalid",
            "You cannot print inside a function",
            "There are no arguments in the function"
        ),
        answerIndex = 0,
        explanation = "In Python, the body of a function must be indented to show that it belongs to the function block."
    ),
    Problem(
        id = "output_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Dictionary Value",
        summary = "Accessing a value by key.",
        prompt = "What does this code print?",
        code = """
            student = {"name": "Bob", "grade": "A"}
            print(student["grade"])
        """.trimIndent(),
        options = listOf(
            "A",
            "Bob",
            "grade",
            "name"
        ),
        answerIndex = 0,
        explanation = "Dictionaries store key-value pairs. Using the key 'grade' returns the associated value 'A'."
    ),
    Problem(
        id = "purpose_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Finding Length",
        summary = "Using the len() function.",
        prompt = "What does this code do overall?",
        code = """
            word = "Python"
            size = len(word)
        """.trimIndent(),
        options = listOf(
            "Finds how many characters are in the string",
            "Converts the string to lowercase",
            "Checks if the string is empty",
            "Reverses the string"
        ),
        answerIndex = 0,
        explanation = "The built-in len() function returns the number of items in an object, which for a string is the number of characters."
    ),
    Problem(
        id = "fill_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Returning a Value",
        summary = "Giving data back from a function.",
        prompt = "Which keyword sends a value back from a function?",
        code = """
            def get_five():
                ___ 5
                
            num = get_five()
        """.trimIndent(),
        options = listOf(
            "return",
            "send",
            "give",
            "output"
        ),
        answerIndex = 0,
        explanation = "The 'return' keyword is used to exit a function and pass a value back to the caller."
    ),
    Problem(
        id = "order_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Variable Assignment",
        summary = "Creating and using a variable.",
        prompt = "Arrange these lines to correctly create and print a variable.",
        code = "",
        options = listOf(
            "score = 100",
            "score = score + 50",
            "print(score)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "You must define the variable first with an initial value, then modify it, and finally print it."
    ),
    Problem(
        id = "complexity_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple List Iteration",
        summary = "Looping through elements in a list.",
        prompt = "How many times does the print statement run?",
        code = """
            colors = ["red", "blue", "green"]
            for color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "1 time",
            "4 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "The loop iterates once for each element in the list. Since there are 3 colors, it runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Updating a Number",
        summary = "Changing a numeric variable.",
        prompt = "What is the value of 'count' at the end?",
        code = """
            count = 10
            count = count - 2
            count = count * 2
        """.trimIndent(),
        options = listOf(
            "16",
            "20",
            "8",
            "18"
        ),
        answerIndex = 0,
        explanation = "First, 10 - 2 = 8. Then, 8 * 2 = 16. The final value is 16."
    ),
    Problem(
        id = "match_easy_student_38",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Joining two strings.",
        prompt = "Which code correctly prints 'IceCream'?",
        code = "",
        options = listOf(
            "print(\"Ice\" + \"Cream\")",
            "print(\"Ice\", \"Cream\")",
            "print(\"IceCream\" - \"\")",
            "print(\"Ice\" * \"Cream\")"
        ),
        answerIndex = 0,
        explanation = "The '+' operator is used to concatenate (join) strings together without adding a space."
    )
)
