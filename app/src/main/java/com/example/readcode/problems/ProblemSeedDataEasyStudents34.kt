package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents34 = listOf(
    Problem(
        id = "bug_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Dictionary Key Error",
        summary = "Accessing a missing key in a dictionary.",
        prompt = "Why does this code cause an error?",
        code = """
            student = {"name": "Bob", "grade": "A"}
            print(student["age"])
        """.trimIndent(),
        options = listOf(
            "\"age\" is not a key in the dictionary",
            "The dictionary should be created with []",
            "The print function does not work on dictionaries",
            "\"Bob\" is not an integer"
        ),
        answerIndex = 0,
        explanation = "Accessing a dictionary key that does not exist directly using square brackets raises a KeyError."
    ),
    Problem(
        id = "output_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Repetition",
        summary = "Multiplying a string by an integer.",
        prompt = "What does this code print?",
        code = """
            echo = "Ha"
            print(echo * 3)
        """.trimIndent(),
        options = listOf(
            "HaHaHa",
            "Ha * 3",
            "Ha3",
            "Ha Ha Ha"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times."
    ),
    Problem(
        id = "purpose_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "List Append",
        summary = "Adding an item to a list.",
        prompt = "What does the second line do?",
        code = """
            colors = ["red", "blue"]
            colors.append("green")
        """.trimIndent(),
        options = listOf(
            "Adds \"green\" to the end of the list",
            "Replaces \"red\" with \"green\"",
            "Creates a new list with only \"green\"",
            "Sorts the list alphabetically"
        ),
        answerIndex = 0,
        explanation = "The `append` method adds a single item to the end of a list."
    ),
    Problem(
        id = "fill_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "If-Else Syntax",
        summary = "Completing an if statement.",
        prompt = "Which character is missing at the end of the `if` condition?",
        code = """
            temperature = 30
            if temperature > 25___
                print("It is hot outside")
        """.trimIndent(),
        options = listOf(
            ":",
            ";",
            ",",
            "."
        ),
        answerIndex = 0,
        explanation = "In Python, a colon `:` is required at the end of an `if`, `elif`, or `else` statement to start a new block."
    ),
    Problem(
        id = "order_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Define a function",
        summary = "Creating and calling a simple function.",
        prompt = "Arrange the lines to define a function that greets a user and then call it.",
        code = "",
        options = listOf(
            "def greet(name):",
            "    message = \"Hello, \" + name",
            "    print(message)",
            "greet(\"Alice\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First define the function with `def`, indent the body to create and print the message, and finally call the function without indentation."
    ),
    Problem(
        id = "complexity_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List Traversal",
        summary = "Iterating over a list of items.",
        prompt = "How many times does the print statement execute?",
        code = """
            letters = ["a", "b", "c"]
            for char in letters:
                print(char)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "1 time",
            "4 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "The list has 3 elements, so the `for` loop executes exactly once for each item (3 times)."
    ),
    Problem(
        id = "trace_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Update",
        summary = "Tracking a variable as it changes.",
        prompt = "What is the final value of x?",
        code = """
            x = 10
            x = x + 5
            x = x * 2
        """.trimIndent(),
        options = listOf(
            "30",
            "20",
            "25",
            "15"
        ),
        answerIndex = 0,
        explanation = "`x` starts at 10, becomes 15 after adding 5, and then 30 after multiplying by 2."
    ),
    Problem(
        id = "match_easy_student_34",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print Multiple Items",
        summary = "Formatting output with variables.",
        prompt = "Assuming `name=\"Alice\"` and `age=20`, which line prints `Name: Alice, Age: 20`?",
        code = "",
        options = listOf(
            "print(f\"Name: {name}, Age: {age}\")",
            "print(\"Name: name, Age: age\")",
            "print(f\"Name {name} Age {age}\")",
            "print(\"Name: \" + name + \" Age: \" + age)"
        ),
        answerIndex = 0,
        explanation = "An f-string evaluates expressions inside `{}` and directly substitutes their values into the string."
    )
)
