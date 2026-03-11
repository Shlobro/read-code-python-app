package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Easy student problems batch 36.
val easyProblemsStudents36 = listOf(
    Problem(
        id = "bug_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "An indented block is missing.",
        prompt = "Why will this code cause an error?",
        code = """
            def greet():
            print("Hello!")
            
            greet()
        """.trimIndent(),
        options = listOf(
            "The print statement is not indented",
            "The function name is not valid",
            "You cannot define functions in Python",
            "The string needs single quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, the body of a function must be indented. Otherwise, Python throws an IndentationError."
    ),
    Problem(
        id = "output_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Joining strings together.",
        prompt = "What does this code print?",
        code = """
            greeting = "Hi"
            name = "Tom"
            print(greeting + " " + name)
        """.trimIndent(),
        options = listOf(
            "Hi Tom",
            "HiTom",
            "Hi + Tom",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Using the `+` operator with strings joins them together. The code includes a space string in the middle, resulting in \"Hi Tom\"."
    ),
    Problem(
        id = "purpose_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Max Value",
        summary = "Using the built-in max function.",
        prompt = "What does this code do?",
        code = """
            scores = [85, 92, 78, 90]
            best_score = max(scores)
        """.trimIndent(),
        options = listOf(
            "Finds the highest number in the list",
            "Sorts the list from highest to lowest",
            "Adds all the numbers together",
            "Removes the lowest number"
        ),
        answerIndex = 0,
        explanation = "The `max()` function returns the largest item in an iterable, so it finds the highest score."
    ),
    Problem(
        id = "fill_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check Equality",
        summary = "Using the equality operator.",
        prompt = "Which operator checks if the answer is exactly 4?",
        code = """
            answer = 4
            if answer ___ 4:
                print("Correct!")
        """.trimIndent(),
        options = listOf(
            "==",
            "=",
            "!=",
            ">="
        ),
        answerIndex = 0,
        explanation = "The double equals sign `==` is used to compare two values for equality. A single equals sign `=` is used for assignment."
    ),
    Problem(
        id = "order_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Greeting Function",
        summary = "Defining and calling a function.",
        prompt = "Arrange the lines to define a function and then call it.",
        code = "",
        options = listOf(
            "def say_hello():",
            "    print(\"Hello world\")",
            "say_hello()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the function with `def`, then indent the function body, and finally call the function after it is defined."
    ),
    Problem(
        id = "complexity_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "String Length Loop",
        summary = "Looping over characters in a string.",
        prompt = "How many times will this loop run?",
        code = """
            word = "cat"
            for letter in word:
                print(letter)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "1 time",
            "0 times"
        ),
        answerIndex = 0,
        explanation = "A `for` loop over a string iterates once for each character. Since \"cat\" has 3 characters, it runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracing a Counter",
        summary = "Watching a variable increment.",
        prompt = "What is the value of 'count' after this loop finishes?",
        code = """
            count = 0
            for i in range(2):
                count = count + 1
        """.trimIndent(),
        options = listOf(
            "2",
            "1",
            "0",
            "3"
        ),
        answerIndex = 0,
        explanation = "The loop runs 2 times (for i=0 and i=1). Each time, `count` increases by 1, so it ends at 2."
    ),
    Problem(
        id = "match_easy_student_36",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Modulo Operator",
        summary = "Finding the remainder of division.",
        prompt = "Which code correctly prints '1'?",
        code = "",
        options = listOf(
            "print(10 % 3)",
            "print(10 / 3)",
            "print(10 // 3)",
            "print(10 * 3)"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder of a division. 10 divided by 3 is 9 with a remainder of 1, so `10 % 3` evaluates to 1."
    )
)
