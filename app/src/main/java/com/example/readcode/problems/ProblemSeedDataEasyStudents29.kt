package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents29 = listOf(
    Problem(
        id = "easy_students_29_find_bug",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Return",
        summary = "A function that calculates a value but doesn't return it.",
        prompt = "Why does this code print `None` instead of 10?",
        code = """
            def double_number(n):
                result = n * 2
                
            value = double_number(5)
            print(value)
        """.trimIndent(),
        options = listOf(
            "The function doesn't return the result",
            "`result` is a reserved word",
            "The print statement is outside the function",
            "`double_number(5)` is an invalid call"
        ),
        answerIndex = 0,
        explanation = "Without a `return` statement, a function evaluates and returns `None`."
    ),
    Problem(
        id = "easy_students_29_output",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Multiplier",
        summary = "Using the multiplication operator on a string.",
        prompt = "What does this print?",
        code = """
            greeting = "Hi"
            print(greeting * 3)
        """.trimIndent(),
        options = listOf(
            "HiHiHi",
            "Hi 3",
            "Hi, Hi, Hi",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times without adding spaces."
    ),
    Problem(
        id = "easy_students_29_purpose",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Name Printer",
        summary = "Iterating over a list of names.",
        prompt = "What does this code do?",
        code = """
            names = ["Alice", "Bob", "Charlie"]
            for name in names:
                print("Hello " + name)
        """.trimIndent(),
        options = listOf(
            "Prints a greeting for each person in the list",
            "Prints the names exactly as they appear in the list",
            "Adds 'Hello' to the beginning of the list",
            "Creates a new list of greetings"
        ),
        answerIndex = 0,
        explanation = "The loop iterates through each name in the list and prints 'Hello ' followed by the name."
    ),
    Problem(
        id = "easy_students_29_fill_blank",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List Length",
        summary = "Finding the length of a list.",
        prompt = "Which function finds how many items are in the list?",
        code = """
            colors = ["red", "blue", "green"]
            count = ___(colors)
            print(count)
        """.trimIndent(),
        options = listOf(
            "len",
            "size",
            "count",
            "length"
        ),
        answerIndex = 0,
        explanation = "In Python, the `len()` function returns the number of items in an object like a list."
    ),
    Problem(
        id = "easy_students_29_order_steps",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Find Maximum",
        summary = "Finding the larger of two numbers.",
        prompt = "Arrange the lines to print the larger number correctly.",
        code = "",
        options = listOf(
            "a = 5\nb = 8",
            "if a > b:",
            "    print(a)",
            "else:",
            "    print(b)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the variables, then check if 'a' is larger than 'b', print 'a' if true, otherwise print 'b'."
    ),
    Problem(
        id = "easy_students_29_complexity",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple Range",
        summary = "Iterating with range.",
        prompt = "How many times does this loop run?",
        code = """
            for i in range(5):
                print("Running")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "The `range(5)` function generates numbers from 0 to 4, which means the loop runs 5 times."
    ),
    Problem(
        id = "easy_students_29_trace_var",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a Flag",
        summary = "Following a boolean flag in a loop.",
        prompt = "What is the value of 'found' after the loop finishes?",
        code = """
            numbers = [1, 3, 5, 8, 9]
            found = False
            for num in numbers:
                if num == 5:
                    found = True
        """.trimIndent(),
        options = listOf(
            "True",
            "False",
            "5",
            "None"
        ),
        answerIndex = 0,
        explanation = "When the loop reaches 5, `found` is set to `True`. It stays `True` for the rest of the loop."
    ),
    Problem(
        id = "easy_students_29_match_output",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Access",
        summary = "Accessing an item in a list by index.",
        prompt = "Which code produces the output `banana`?",
        code = "",
        options = listOf(
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[1])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[2])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[0])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits['banana'])"
        ),
        answerIndex = 0,
        explanation = "Python lists are zero-indexed, so `fruits[1]` accesses the second item, which is 'banana'."
    )
)
