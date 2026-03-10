package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Easy student problems batch 35.
val easyProblemsStudents35 = listOf(
    Problem(
        id = "bug_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Incorrect String Formatting",
        summary = "F-string is missing the 'f' prefix.",
        prompt = "Why does this not print the expected greeting?",
        code = """
            name = "Alice"
            print("{name} is here!")
        """.trimIndent(),
        options = listOf(
            "It is missing the 'f' prefix before the string",
            "The variable name must be capitalized",
            "Strings cannot use curly braces",
            "There is no comma after the variable"
        ),
        answerIndex = 0,
        explanation = "In Python, to evaluate variables inside curly braces within a string, the string must be prefixed with 'f' to make it an f-string."
    ),
    Problem(
        id = "output_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Length",
        summary = "Finding how many items are in a list.",
        prompt = "What does this code print?",
        code = """
            colors = ["red", "green", "blue", "yellow"]
            print(len(colors))
        """.trimIndent(),
        options = listOf(
            "4",
            "3",
            "5",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `len()` function returns the total number of items in a list. There are 4 colors."
    ),
    Problem(
        id = "purpose_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Sum of List",
        summary = "Using the built-in sum function.",
        prompt = "What does this code do?",
        code = """
            scores = [10, 20, 30]
            result = sum(scores)
        """.trimIndent(),
        options = listOf(
            "Calculates the total of all numbers in the list",
            "Finds the highest number in the list",
            "Counts how many numbers are in the list",
            "Sorts the numbers in the list"
        ),
        answerIndex = 0,
        explanation = "The `sum()` function adds up all the numeric values inside the iterable provided."
    ),
    Problem(
        id = "fill_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String Uppercase",
        summary = "Converting a string to uppercase.",
        prompt = "Which method converts the string to 'HELLO'?",
        code = """
            word = "hello"
            print(word.___)
        """.trimIndent(),
        options = listOf(
            "upper()",
            "upper",
            "capitalize()",
            "UPPER()"
        ),
        answerIndex = 0,
        explanation = "The `.upper()` string method returns a copy of the string with all characters converted to uppercase."
    ),
    Problem(
        id = "order_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Calculate Average",
        summary = "Finding the average of two numbers.",
        prompt = "Arrange the lines to calculate and print the average.",
        code = "",
        options = listOf(
            "a = 10",
            "b = 20",
            "total = a + b",
            "average = total / 2",
            "print(average)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the values, then calculate their sum, divide the sum by 2 to get the average, and finally print it."
    ),
    Problem(
        id = "complexity_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Range Iterations",
        summary = "Looping with range.",
        prompt = "How many times will this loop run?",
        code = """
            for i in range(5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "1 time"
        ),
        answerIndex = 0,
        explanation = "The `range(5)` function generates numbers from 0 up to 4, which is exactly 5 numbers, so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracing Loop Variable",
        summary = "Watching the loop variable change.",
        prompt = "What is the value of 'x' during the final iteration of this loop?",
        code = """
            for x in [10, 20, 30]:
                print(x)
        """.trimIndent(),
        options = listOf(
            "30",
            "20",
            "10",
            "0"
        ),
        answerIndex = 0,
        explanation = "The loop iterates through each item in the list in order. The last item is 30, so 'x' will be 30 on the final iteration."
    ),
    Problem(
        id = "match_easy_student_35",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Math Output",
        summary = "Basic arithmetic operations.",
        prompt = "Which code correctly prints '15'?",
        code = "",
        options = listOf(
            "print(5 * 3)",
            "print(5 + 3)",
            "print(15 / 3)",
            "print(5 ** 3)"
        ),
        answerIndex = 0,
        explanation = "The expression `5 * 3` performs multiplication, resulting in 15."
    )
)
