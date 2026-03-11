package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents39 = listOf(
    Problem(
        id = "bug_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Colon",
        summary = "If statements require a colon at the end.",
        prompt = "Why will this code result in a syntax error?",
        code = """
            weather = "rain"
            if weather == "rain"
                print("Take an umbrella")
        """.trimIndent(),
        options = listOf(
            "The if statement is missing a colon (:)",
            "The print statement is not indented properly",
            "weather is not a boolean",
            "You cannot use == with strings"
        ),
        answerIndex = 0,
        explanation = "In Python, control flow statements like `if`, `for`, and `while` must end with a colon (:) ."
    ),
    Problem(
        id = "output_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Indexing",
        summary = "Accessing an element by its position.",
        prompt = "What does this code print?",
        code = """
            animals = ["cat", "dog", "bird"]
            print(animals[1])
        """.trimIndent(),
        options = listOf(
            "dog",
            "cat",
            "bird",
            "Error"
        ),
        answerIndex = 0,
        explanation = "List indices start at 0, so index 1 refers to the second item in the list, which is 'dog'."
    ),
    Problem(
        id = "purpose_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "String Upper",
        summary = "Converting string cases.",
        prompt = "What does this code do overall?",
        code = """
            name = "alice"
            shout = name.upper()
        """.trimIndent(),
        options = listOf(
            "Converts the string to all uppercase letters",
            "Reverses the string",
            "Capitalizes only the first letter",
            "Checks if the string is uppercase"
        ),
        answerIndex = 0,
        explanation = "The `upper()` method returns a new string with all lowercase letters converted to uppercase."
    ),
    Problem(
        id = "fill_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Function Definition",
        summary = "Creating a new function.",
        prompt = "Which keyword starts a function definition in Python?",
        code = """
            ___ say_hello():
                print("Hello!")
        """.trimIndent(),
        options = listOf(
            "def",
            "func",
            "function",
            "create"
        ),
        answerIndex = 0,
        explanation = "The `def` keyword is used to define a new function in Python."
    ),
    Problem(
        id = "order_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Greeting Logic",
        summary = "Setting up a personalized message.",
        prompt = "Arrange these lines to correctly set a name and print a greeting.",
        code = "",
        options = listOf(
            "name = \"Alice\"",
            "greeting = \"Hello \" + name",
            "print(greeting)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "You must assign the name before you use it in the greeting string, and finally print the result."
    ),
    Problem(
        id = "complexity_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Fixed Range Loop",
        summary = "Looping a specific number of times.",
        prompt = "How many times does the print statement run?",
        code = """
            for i in range(5):
                print("Jump!")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "1 time",
            "6 times"
        ),
        answerIndex = 0,
        explanation = "The `range(5)` function generates numbers from 0 to 4, causing the loop to run exactly 5 times."
    ),
    Problem(
        id = "trace_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Swap Step",
        summary = "Following the values of variables.",
        prompt = "What is the value of 'a' at the end?",
        code = """
            a = 3
            b = 7
            a = b
            b = 2
        """.trimIndent(),
        options = listOf(
            "7",
            "3",
            "2",
            "10"
        ),
        answerIndex = 0,
        explanation = "`a` takes the value of `b` (which is 7). Modifying `b` afterwards does not change `a`."
    ),
    Problem(
        id = "match_easy_student_39",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Division Operator",
        summary = "Performing basic arithmetic.",
        prompt = "Which code correctly prints the number 4.0?",
        code = "",
        options = listOf(
            "print(8 / 2)",
            "print(8 * 2)",
            "print(8 + 2)",
            "print(8 - 2)"
        ),
        answerIndex = 0,
        explanation = "The `/` operator performs division, returning a float. 8 divided by 2 is 4.0."
    )
)
