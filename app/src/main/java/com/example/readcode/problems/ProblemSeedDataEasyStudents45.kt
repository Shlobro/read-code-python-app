package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents45 = listOf(
    Problem(
        id = "bug_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Incorrect Addition",
        summary = "Adding strings instead of numbers.",
        prompt = "Why does this print '55' instead of 10?",
        code = """
            a = "5"
            b = "5"
            print(a + b)
        """.trimIndent(),
        options = listOf(
            "Variables are strings",
            "The + operator does not work with variables assigned the same value.",
            "Python automatically converts string digits to integers when they are equal.",
            "The variables need to be converted with int() first."
        ),
        answerIndex = 0,
        explanation = "Quotes around the numbers make them strings. The + operator concatenates strings."
    ),
    Problem(
        id = "output_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Negative Indexing",
        summary = "Accessing a list from the end.",
        prompt = "What does this code print?",
        code = """
            letters = ["A", "B", "C", "D"]
            print(letters[-1])
        """.trimIndent(),
        options = listOf(
            "C",
            "B",
            "D",
            "A"
        ),
        answerIndex = 2,
        explanation = "A negative index counts from the end of the list. -1 is the last item."
    ),
    Problem(
        id = "purpose_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Absolute Value",
        summary = "Using the built-in abs function.",
        prompt = "What does this code compute?",
        code = """
            value = -10
            result = abs(value)
        """.trimIndent(),
        options = listOf(
            "The square root of -10",
            "It negates the value",
            "The absolute value",
            "It subtracts 10 from -10 and returns -20"
        ),
        answerIndex = 2,
        explanation = "The built-in abs() function returns the absolute (positive) value of a number."
    ),
    Problem(
        id = "fill_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Dictionary Key Assignment",
        summary = "Adding a new key-value pair to a dictionary.",
        prompt = "Fill the blank to set 'age' to 20.",
        code = """
            student = {"name": "Alice"}
            student__ = 20
        """.trimIndent(),
        options = listOf(
            ".set('age')",
            "['age']",
            ".update('age')",
            ".add('age')"
        ),
        answerIndex = 1,
        explanation = "You can add or update a dictionary entry using square brackets with the key name."
    ),
    Problem(
        id = "order_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Function Definition",
        summary = "Creating and calling a simple function.",
        prompt = "Arrange these lines to define a function and then call it.",
        code = "",
        options = listOf(
            "def say_hello():",
            "    print('Hello!')",
            "say_hello()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the function with 'def', indent its body, and finally call it without indentation."
    ),
    Problem(
        id = "complexity_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Single Loop Runs",
        summary = "Counting iterations in a standard for loop.",
        prompt = "How many times will this loop execute?",
        code = """
            for x in [1, 2, 3, 4, 5]:
                print(x)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "3 times",
            "5 times",
            "6 times"
        ),
        answerIndex = 2,
        explanation = "The loop iterates exactly once for each item in the list, which has 5 items."
    ),
    Problem(
        id = "trace_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "String Multiplication",
        summary = "Repeating a string with the multiplication operator.",
        prompt = "What is the value of 'text'?",
        code = """
            text = "Go" * 3
        """.trimIndent(),
        options = listOf(
            "GoGoGo",
            "Go 3",
            "['Go', 'Go', 'Go']",
            "GoGo"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer N repeats the string N times."
    ),
    Problem(
        id = "match_easy_student_45",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print List Length",
        summary = "Outputting the number of items in a list.",
        prompt = "Which code correctly outputs 3?",
        code = "",
        options = listOf(
            "print(count(['a', 'b', 'c']))",
            "print(['a', 'b', 'c'].size())",
            "print(len(['a', 'b', 'c']))",
            "print(['a', 'b', 'c'].length)"
        ),
        answerIndex = 2,
        explanation = "The len() function returns the number of items in an object, like a list."
    )
)