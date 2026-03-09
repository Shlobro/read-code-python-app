package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents17 = listOf(
    Problem(
        id = "bug_easy_student_17_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "Code inside a function must be indented.",
        prompt = "Why does this code cause an IndentationError?",
        code = """
            def print_message():
            print("Hello World")
        """.trimIndent(),
        options = listOf(
            "The print statement needs to be indented",
            "There are too many parentheses",
            "The function name is invalid",
            "Strings cannot contain spaces"
        ),
        answerIndex = 0,
        explanation = "In Python, the body of a function must be indented to show that it belongs to the function block."
    ),
    Problem(
        id = "output_easy_student_17_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Variable Reassignment",
        summary = "A variable is assigned a new value.",
        prompt = "What does this code print?",
        code = """
            x = 5
            x = x + 2
            x = 10
            print(x)
        """.trimIndent(),
        options = listOf(
            "10",
            "7",
            "5",
            "17"
        ),
        answerIndex = 0,
        explanation = "The variable `x` is updated multiple times, but the final assignment sets it directly to 10."
    ),
    Problem(
        id = "purpose_easy_student_17_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Compare Two Numbers",
        summary = "A function returns one of two numbers.",
        prompt = "What is the purpose of this function?",
        code = """
            def get_largest(a, b):
                if a > b:
                    return a
                else:
                    return b
        """.trimIndent(),
        options = listOf(
            "Returns the larger of the two numbers",
            "Adds the two numbers together",
            "Checks if the numbers are equal",
            "Always returns the first number"
        ),
        answerIndex = 0,
        explanation = "The function compares `a` and `b` and returns whichever one is greater."
    ),
    Problem(
        id = "fill_easy_student_17_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "First Item in List",
        summary = "Accessing the beginning of a list.",
        prompt = "Fill in the blank to print the very first color in the list.",
        code = """
            colors = ["red", "green", "blue"]
            print(colors[___])
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "first",
            "red"
        ),
        answerIndex = 0,
        explanation = "In Python, lists are zero-indexed, meaning the first item is at position `0`."
    ),
    Problem(
        id = "order_easy_student_17_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple If/Else",
        summary = "Arrange the code to check a condition and print a result.",
        prompt = "Put the lines in the correct order to form an if/else statement.",
        code = """
            temperature = 30
            if temperature > 25:
                print("Hot")
            else:
                print("Cold")
        """.trimIndent(),
        options = listOf(
            "else:",
            "    print(\"Hot\")",
            "    print(\"Cold\")",
            "if temperature > 25:"
        ),
        answerIndex = -1,
        correctOrder = listOf(3, 1, 0, 2),
        explanation = "First comes the `if` condition, followed by its indented block. Then the `else` keyword, and finally its indented block."
    ),
    Problem(
        id = "complexity_easy_student_17_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List Iteration Count",
        summary = "Counting how many times a loop runs over a list.",
        prompt = "How many times will this loop execute?",
        code = """
            items = [10, 20, 30, 40]
            for item in items:
                print(item)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "1 time",
            "40 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "The loop runs exactly once for each item in the list. There are 4 items, so it runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_17_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "String Building",
        summary = "Tracking a string as parts are added to it.",
        prompt = "What is the final value of `word`?",
        code = """
            word = "cat"
            word = word + "s"
            word = "my " + word
        """.trimIndent(),
        options = listOf(
            "my cats",
            "cats my",
            "mycat",
            "cats"
        ),
        answerIndex = 0,
        explanation = "First 's' is added to make 'cats', then 'my ' is added to the beginning to make 'my cats'."
    ),
    Problem(
        id = "match_easy_student_17_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Basic Arithmetic",
        summary = "Pick the code that outputs exactly '15'.",
        prompt = "Which code snippet prints `15`?",
        code = "",
        options = listOf(
            "print(10 + 5)",
            "print(15 * 0)",
            "print(20 - 15)",
            "print(3 * 4)"
        ),
        answerIndex = 0,
        explanation = "`10 + 5` evaluates to 15."
    )
)
