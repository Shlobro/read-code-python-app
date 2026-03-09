package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents16 = listOf(
    Problem(
        id = "bug_easy_student_16_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Colon",
        summary = "An if-statement is missing its colon.",
        prompt = "Why does this code cause a SyntaxError?",
        code = """
            age = 20
            if age >= 18
                print("Adult")
        """.trimIndent(),
        options = listOf(
            "The if-statement is missing a colon at the end",
            "The age must be in quotes",
            "print should not be indented",
            "The greater-than sign is backwards"
        ),
        answerIndex = 0,
        explanation = "In Python, control flow statements like `if`, `for`, and `while` must end with a colon."
    ),
    Problem(
        id = "output_easy_student_16_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Adding two strings together.",
        prompt = "What does this code print?",
        code = """
            greeting = "Hello"
            name = "Bob"
            print(greeting + " " + name)
        """.trimIndent(),
        options = listOf(
            "Hello Bob",
            "HelloBob",
            "Hello + Bob",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings together. Including `\" \"` adds a space between them."
    ),
    Problem(
        id = "purpose_easy_student_16_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Greeting Function",
        summary = "A function that returns a greeting string.",
        prompt = "What is the purpose of this function?",
        code = """
            def make_greeting(name):
                return "Hi " + name
        """.trimIndent(),
        options = listOf(
            "Creates a greeting message for a given name",
            "Prints a greeting to the screen",
            "Checks if the name is a string",
            "Removes the word 'Hi' from the name"
        ),
        answerIndex = 0,
        explanation = "The function takes a name and returns a new string combining 'Hi ' with the name."
    ),
    Problem(
        id = "fill_easy_student_16_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Type Conversion",
        summary = "Converting a string to an integer.",
        prompt = "Fill in the blank to convert the string to a number so it can be added.",
        code = """
            age_str = "15"
            age = ___(age_str)
            print(age + 5)
        """.trimIndent(),
        options = listOf(
            "int",
            "str",
            "num",
            "convert"
        ),
        answerIndex = 0,
        explanation = "`int()` converts a string containing digits into an integer number."
    ),
    Problem(
        id = "order_easy_student_16_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Define and Call",
        summary = "Arrange the code to define a function and then call it.",
        prompt = "Put the lines in the correct order to define the function and then call it.",
        code = """
            def say_hi():
                print("Hi!")
                
            say_hi()
        """.trimIndent(),
        options = listOf(
            "say_hi()",
            "    print(\"Hi!\")",
            "def say_hi():"
        ),
        answerIndex = -1,
        correctOrder = listOf(2, 1, 0),
        explanation = "First define the function with `def`, then indent the code inside it, and finally call the function without indentation."
    ),
    Problem(
        id = "complexity_easy_student_16_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Count",
        summary = "Counting how many times a simple loop runs.",
        prompt = "How many times will 'Hello' be printed?",
        code = """
            for i in range(3):
                print("Hello")
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "2 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "`range(3)` generates numbers 0, 1, and 2, which makes the loop run exactly 3 times."
    ),
    Problem(
        id = "trace_easy_student_16_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Update",
        summary = "Tracking a number as it increases and decreases.",
        prompt = "What is the final value of `score`?",
        code = """
            score = 10
            score = score + 5
            score = score - 2
        """.trimIndent(),
        options = listOf(
            "13",
            "15",
            "10",
            "8"
        ),
        answerIndex = 0,
        explanation = "Starts at 10, becomes 15 after adding 5, and then 13 after subtracting 2."
    ),
    Problem(
        id = "match_easy_student_16_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Match the Output",
        summary = "Pick the code that outputs exactly '100'.",
        prompt = "Which code snippet prints `100`?",
        code = "",
        options = listOf(
            "print(10 * 10)",
            "print(10 + 10)",
            "print(50 + 25)",
            "print(100 * 0)"
        ),
        answerIndex = 0,
        explanation = "`10 * 10` evaluates to 100."
    )
)
