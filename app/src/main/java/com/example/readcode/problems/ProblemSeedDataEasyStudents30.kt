package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents30 = listOf(
    Problem(
        id = "easy_students_30_find_bug",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Type Error on Addition",
        summary = "Trying to add a string and an integer.",
        prompt = "Why does this code crash?",
        code = """
            age_string = "20"
            next_year = age_string + 1
            print(next_year)
        """.trimIndent(),
        options = listOf(
            "You cannot add an integer to a string directly",
            "The variable name 'age_string' is invalid",
            "The print statement is missing quotes",
            "'next_year' must be declared before adding"
        ),
        answerIndex = 0,
        explanation = "In Python, you must convert the string to an integer using `int()` before performing mathematical addition."
    ),
    Problem(
        id = "easy_students_30_output",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Joining two strings together.",
        prompt = "What does this code print?",
        code = """
            first = "Hello"
            second = "World"
            print(first + " " + second)
        """.trimIndent(),
        options = listOf(
            "Hello World",
            "HelloWorld",
            "Hello+World",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings together. Here, it adds a space character between 'Hello' and 'World'."
    ),
    Problem(
        id = "easy_students_30_purpose",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Even Number Check",
        summary = "Using the modulo operator.",
        prompt = "What is the purpose of this function?",
        code = """
            def check_number(n):
                if n % 2 == 0:
                    return True
                else:
                    return False
        """.trimIndent(),
        options = listOf(
            "To check if a number is even",
            "To divide a number by 2",
            "To check if a number is positive",
            "To double the number"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder of division. If `n % 2` is 0, the number is evenly divisible by 2 (it is even)."
    ),
    Problem(
        id = "easy_students_30_fill_blank",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List Appending",
        summary = "Adding an item to an existing list.",
        prompt = "Which method adds 'David' to the end of the list?",
        code = """
            students = ["Alice", "Bob", "Charlie"]
            students.__("David")
            print(students)
        """.trimIndent(),
        options = listOf(
            "append",
            "add",
            "insert",
            "push"
        ),
        answerIndex = 0,
        explanation = "The `append()` method adds a single item to the end of a list in Python."
    ),
    Problem(
        id = "easy_students_30_order_steps",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Variable Swap",
        summary = "Swapping the values of two variables using a temporary variable.",
        prompt = "Arrange the lines to correctly swap the values of 'x' and 'y'.",
        code = "",
        options = listOf(
            "x = 10\ny = 20",
            "temp = x",
            "x = y",
            "y = temp",
            "print(x, y)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First initialize variables, then save 'x' to 'temp', overwrite 'x' with 'y', and finally overwrite 'y' with the saved 'temp'."
    ),
    Problem(
        id = "easy_students_30_complexity",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "While Loop Iterations",
        summary = "Counting loop executions.",
        prompt = "How many times will 'Hello' be printed?",
        code = """
            count = 0
            while count < 3:
                print("Hello")
                count = count + 1
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "2 times",
            "It will loop forever"
        ),
        answerIndex = 0,
        explanation = "The loop runs for `count` equal to 0, 1, and 2. When `count` becomes 3, the condition is false and the loop stops."
    ),
    Problem(
        id = "easy_students_30_trace_var",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a Total",
        summary = "Accumulating a sum in a for loop.",
        prompt = "What is the final value of 'total' after the loop finishes?",
        code = """
            total = 0
            for i in [1, 2, 3]:
                total = total + i
        """.trimIndent(),
        options = listOf(
            "6",
            "3",
            "0",
            "5"
        ),
        answerIndex = 0,
        explanation = "The loop adds each number to 'total': 0+1=1, then 1+2=3, then 3+3=6."
    ),
    Problem(
        id = "easy_students_30_match_output",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Last Item",
        summary = "Getting the last item from a list.",
        prompt = "Which code correctly prints 'cherry'?",
        code = "",
        options = listOf(
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[-1])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[3])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[1])",
            "fruits = ['apple', 'banana', 'cherry']\nprint(fruits[last])"
        ),
        answerIndex = 0,
        explanation = "In Python, using an index of `-1` accesses the last element of the list."
    )
)
