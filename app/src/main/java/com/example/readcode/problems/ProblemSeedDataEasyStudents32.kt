package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents32 = listOf(
    Problem(
        id = "bug_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "String concatenation instead of addition",
        summary = "Trying to add two numbers from input.",
        prompt = "Why does this code print '12' instead of '3'?",
        code = """
            a = "1"
            b = "2"
            result = a + b
            print(result)
        """.trimIndent(),
        options = listOf(
            "The variables are strings, so they are joined together",
            "Addition always results in a string in Python",
            "The print statement is formatted incorrectly",
            "The plus operator is not supported for variables"
        ),
        answerIndex = 0,
        explanation = "Since the values are enclosed in quotes, they are strings. The `+` operator concatenates strings, turning \"1\" and \"2\" into \"12\"."
    ),
    Problem(
        id = "output_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Remainder calculation",
        summary = "Using the modulo operator.",
        prompt = "What does this code print?",
        code = """
            apples = 10
            friends = 3
            leftovers = apples % friends
            print(leftovers)
        """.trimIndent(),
        options = listOf(
            "1",
            "3",
            "0",
            "10"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder of division. 10 divided by 3 is 9 with a remainder of 1."
    ),
    Problem(
        id = "purpose_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Substring check",
        summary = "Checking if a character exists in a string.",
        prompt = "What does this code check?",
        code = """
            email = "user@example.com"
            is_valid = "@" in email
        """.trimIndent(),
        options = listOf(
            "If the email contains the '@' symbol",
            "If the email starts with the '@' symbol",
            "If the email is exactly '@'",
            "If the email removes the '@' symbol"
        ),
        answerIndex = 0,
        explanation = "The `in` operator checks if the substring on the left exists anywhere within the string on the right."
    ),
    Problem(
        id = "fill_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Dictionary assignment",
        summary = "Adding a new key-value pair.",
        prompt = "Fill in the blank to give the player a score of 100.",
        code = """
            player = {"name": "Alex"}
            player[___] = 100
        """.trimIndent(),
        options = listOf(
            "\"score\"",
            "score",
            "100",
            "0"
        ),
        answerIndex = 0,
        explanation = "To add a new key, use square brackets with the string key name, like `player[\"score\"]`."
    ),
    Problem(
        id = "order_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap variables",
        summary = "Using a temporary variable to swap values.",
        prompt = "Arrange the lines to swap the values of x and y using a temp variable.",
        code = "",
        options = listOf(
            "x = 5\ny = 10",
            "temp = x",
            "x = y",
            "y = temp",
            "print(x, y)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define x and y. Then save x's value in temp. Next, overwrite x with y's value. Finally, assign the saved temp value to y."
    ),
    Problem(
        id = "complexity_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List iteration",
        summary = "Looping through a list of names.",
        prompt = "How many times will 'print' be called?",
        code = """
            guests = ["Sam", "Jo", "Max"]
            for guest in guests:
                print("Welcome")
        """.trimIndent(),
        options = listOf(
            "3 times",
            "1 time",
            "0 times",
            "4 times"
        ),
        answerIndex = 0,
        explanation = "The `for` loop executes its body once for each item in the list. There are 3 items, so it prints 3 times."
    ),
    Problem(
        id = "trace_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracing a counter",
        summary = "A while loop that counts down.",
        prompt = "What is the value of 'count' after the loop finishes?",
        code = """
            count = 3
            while count > 0:
                count = count - 1
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "3",
            "-1"
        ),
        answerIndex = 0,
        explanation = "The loop runs as long as `count` is greater than 0. When `count` becomes 0, the condition `0 > 0` is false, and the loop ends."
    ),
    Problem(
        id = "match_easy_student_32",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String repetition",
        summary = "Multiplying a string by an integer.",
        prompt = "Which code correctly prints 'HaHaHa'?",
        code = "",
        options = listOf(
            "print(\"Ha\" * 3)",
            "print(\"Ha\" + 3)",
            "print(\"HaHa\" * 3)",
            "print(\"Ha\" * \"Ha\" * \"Ha\")"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times. `\"Ha\" * 3` gives `\"HaHaHa\"`."
    )
)
