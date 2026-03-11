package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents42 = listOf(
    Problem(
        id = "bug_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "String Index Out of Bounds",
        summary = "Trying to access an invalid index.",
        prompt = "Why does this code cause an error?",
        code = """
            word = "cat"
            print(word[3])
        """.trimIndent(),
        options = listOf(
            "The index is out of bounds for the string length",
            "Strings in Python do not support bracket indexing at all",
            "The string 'cat' must be converted to a list before accessing it",
            "The variable name 'word' is a reserved keyword in Python"
        ),
        answerIndex = 0,
        explanation = "Python uses zero-based indexing. The valid indices for 'cat' are 0, 1, and 2. Index 3 is out of bounds."
    ),
    Problem(
        id = "output_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Boolean Logic",
        summary = "Evaluating logical AND.",
        prompt = "What does this code print?",
        code = """
            is_raining = True
            has_umbrella = False
            print(is_raining and has_umbrella)
        """.trimIndent(),
        options = listOf(
            "True",
            "False",
            "None",
            "Error"
        ),
        answerIndex = 1,
        explanation = "The 'and' operator returns True only if both operands are True. Since has_umbrella is False, the result is False."
    ),
    Problem(
        id = "purpose_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Absolute Value Logic",
        summary = "Using an if statement to handle negative numbers.",
        prompt = "What is the purpose of this code?",
        code = """
            num = -15
            if num < 0:
                num = num * -1
            print(num)
        """.trimIndent(),
        options = listOf(
            "It checks if the number is less than zero and squares it",
            "It converts negative numbers into positive numbers",
            "It multiplies the number by negative one if it is greater than zero",
            "It creates a loop that stops when the number reaches exactly zero"
        ),
        answerIndex = 1,
        explanation = "The code checks if the number is negative, and if so, multiplies it by -1 to make it positive, effectively calculating the absolute value."
    ),
    Problem(
        id = "fill_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Checking Equality",
        summary = "Using the equality operator in an if statement.",
        prompt = "How do you check if the password matches?",
        code = """
            password = "admin"
            if password ___ "admin":
                print("Access granted")
        """.trimIndent(),
        options = listOf(
            "=",
            "==",
            "is equal to",
            "==="
        ),
        answerIndex = 1,
        explanation = "In Python, the '==' operator is used to check for equality, whereas '=' is used for assignment."
    ),
    Problem(
        id = "order_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Defining a Function",
        summary = "Defining and calling a simple function.",
        prompt = "Arrange these lines to define and call a greeting function.",
        code = "",
        options = listOf(
            "def say_hello():",
            "    print('Hello!')",
            "say_hello()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the function with 'def', then indent the body, and finally call the function outside."
    ),
    Problem(
        id = "complexity_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple While Loop",
        summary = "A while loop that increments a counter.",
        prompt = "How many times does the loop body execute?",
        code = """
            count = 0
            while count < 5:
                count += 1
        """.trimIndent(),
        options = listOf(
            "5 times",
            "It runs infinitely because the condition never changes",
            "It executes 6 times because it starts at zero",
            "It executes 4 times since the condition is strictly less than 5"
        ),
        answerIndex = 0,
        explanation = "The loop condition is checked for count values 0, 1, 2, 3, and 4, executing the body exactly 5 times."
    ),
    Problem(
        id = "trace_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Reassignment",
        summary = "Assigning new values to a variable.",
        prompt = "What is the final value of the 'score' variable?",
        code = """
            score = 10
            score = score + 5
            score = 20
        """.trimIndent(),
        options = listOf(
            "10",
            "15",
            "20",
            "35"
        ),
        answerIndex = 2,
        explanation = "Variables hold the most recently assigned value. The final assignment 'score = 20' overrides all previous values."
    ),
    Problem(
        id = "match_easy_student_42",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Combining strings with operators.",
        prompt = "Which code correctly produces the string 'HelloWorld'?",
        code = "",
        options = listOf(
            "'Hello' * 'World'",
            "'Hello' + 'World'",
            "'Hello' - 'World'",
            "'Hello' / 'World'"
        ),
        answerIndex = 1,
        explanation = "The '+' operator concatenates (joins) two strings together in Python."
    )
)
