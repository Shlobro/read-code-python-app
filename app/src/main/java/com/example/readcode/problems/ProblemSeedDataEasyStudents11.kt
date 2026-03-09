package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents11 = listOf(
    Problem(
        id = "bug_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Off by one",
        summary = "Loop not printing the last number.",
        prompt = "Why does this code not print 5?",
        code = """
            def count_to_five():
                for i in range(1, 5):
                    print(i)
        """.trimIndent(),
        options = listOf(
            "`range(1, 5)` stops at 4, not 5",
            "The loop starts at 0",
            "`print(i)` is missing parentheses",
            "The function name should be `count`"
        ),
        answerIndex = 0,
        explanation = "`range(1, 5)` generates numbers from 1 up to but not including 5. It should be `range(1, 6)` to include 5."
    ),
    Problem(
        id = "output_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String multiplication",
        summary = "Multiplying a string by an integer.",
        prompt = "What does this code print?",
        code = """
            message = "ha"
            print(message * 3)
        """.trimIndent(),
        options = listOf(
            "hahaha",
            "ha3",
            "ha ha ha",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times without spaces."
    ),
    Problem(
        id = "purpose_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Is it even?",
        summary = "Checking if a number is even.",
        prompt = "What does this function check?",
        code = """
            def check(number):
                if number % 2 == 0:
                    return True
                return False
        """.trimIndent(),
        options = listOf(
            "Returns True if the number is even",
            "Returns True if the number is positive",
            "Returns False if the number is zero",
            "Divides the number by 2"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` gives the remainder of division. `number % 2 == 0` is true for even numbers."
    ),
    Problem(
        id = "fill_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Appending to list",
        summary = "Add an item to a list.",
        prompt = "Which method fills the blank to add 'green' to the list?",
        code = """
            colors = ["red", "blue"]
            colors.___("green")
            print(colors)
        """.trimIndent(),
        options = listOf(
            "append",
            "add",
            "insert",
            "push"
        ),
        answerIndex = 0,
        explanation = "The `append()` method adds a single item to the end of a Python list."
    ),
    Problem(
        id = "order_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap variables",
        summary = "Swap the values of x and y.",
        prompt = "Arrange the code to swap the values of x and y using a temporary variable.",
        code = "",
        options = listOf(
            "y = temp",
            "temp = x",
            "x = y"
        ),
        answerIndex = -1,
        correctOrder = listOf(1, 2, 0),
        explanation = "First save x into temp, then overwrite x with y, and finally overwrite y with the saved temp value."
    ),
    Problem(
        id = "complexity_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Single loop",
        summary = "A single loop iterating N times.",
        prompt = "How many times does print run compared to the size of the list?",
        code = """
            def print_all(items):
                for item in items:
                    print(item)
        """.trimIndent(),
        options = listOf(
            "Once for each item (Linear / O(N))",
            "Only once total (Constant / O(1))",
            "N squared times (Quadratic / O(N^2))",
            "Half the time (Logarithmic / O(log N))"
        ),
        answerIndex = 0,
        explanation = "The loop runs once for each item in the list, so the time it takes grows linearly with the size of the list."
    ),
    Problem(
        id = "trace_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Accumulator trace",
        summary = "Tracking a sum inside a loop.",
        prompt = "What is the value of `total` after the loop finishes?",
        code = """
            total = 0
            for i in [1, 2]:
                total += i
            # What is total here?
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "1",
            "0"
        ),
        answerIndex = 0,
        explanation = "The loop adds 1 to total, making it 1. Then it adds 2, making it 3."
    ),
    Problem(
        id = "match_easy_student_11",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print list elements",
        summary = "Choose the code that prints elements on separate lines.",
        prompt = "Which code prints 'A' on one line and 'B' on the next?",
        code = """
            A
            B
        """.trimIndent(),
        options = listOf(
            "for x in ['A', 'B']: print(x)",
            "print(['A', 'B'])",
            "print('A', 'B')",
            "for x in 'AB': print(x, end='')"
        ),
        answerIndex = 0,
        explanation = "A simple `for` loop over a list calls `print()` once for each element, and `print()` adds a newline by default."
    )
)
