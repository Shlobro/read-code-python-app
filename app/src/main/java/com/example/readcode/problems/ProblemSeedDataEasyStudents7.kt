package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents7 = listOf(
    Problem(
        id = "bug_easy_student_7_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Case sensitivity",
        summary = "A variable is used with the wrong capitalization.",
        prompt = "Why does this code result in a NameError?",
        code = """
            name = "Alice"
            print("Hello " + Name)
        """.trimIndent(),
        options = listOf(
            "Variable names are case-sensitive",
            "You need a comma instead of +",
            "Strings cannot be added together",
            "name must be inside quotes"
        ),
        answerIndex = 0,
        explanation = "Python is case-sensitive. `Name` with a capital 'N' is considered a completely different variable from `name`."
    ),
    Problem(
        id = "output_easy_student_7_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Modulo operation",
        summary = "Finding the remainder of division.",
        prompt = "What does this code print?",
        code = """
            x = 5
            y = 2
            print(x % y)
        """.trimIndent(),
        options = listOf(
            "1",
            "2.5",
            "2",
            "10"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` gives the remainder of division. 5 divided by 2 is 2 with a remainder of 1."
    ),
    Problem(
        id = "purpose_easy_student_7_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check if even",
        summary = "A function checking a number's divisibility by 2.",
        prompt = "What does this function do?",
        code = """
            def is_even(num):
                return num % 2 == 0
        """.trimIndent(),
        options = listOf(
            "Returns True if the number is even",
            "Divides the number by 2",
            "Returns 0 if the number is even",
            "Makes the number even"
        ),
        answerIndex = 0,
        explanation = "The function checks if the remainder when dividing by 2 is 0. If it is, the number is even, and the function returns `True`."
    ),
    Problem(
        id = "fill_easy_student_7_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Add to list",
        summary = "Adding an item to the end of a list.",
        prompt = "Which method fills the blank to add 'green' to the list?",
        code = """
            colors = ["red", "blue"]
            colors.___("green")
        """.trimIndent(),
        options = listOf(
            "append",
            "add",
            "insert",
            "push"
        ),
        answerIndex = 0,
        explanation = "To add a single item to the end of a list in Python, use the `append()` method."
    ),
    Problem(
        id = "order_easy_student_7_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Define and call function",
        summary = "Creating a simple function and calling it.",
        prompt = "Arrange the lines to define a greeting function and call it.",
        code = "",
        options = listOf(
            "def greet(name):",
            "    print('Hello ' + name)",
            "greet('Alice')"
        ),
        answerIndex = 0, // Ignored for ORDER_STEPS
        correctOrder = listOf(0, 1, 2),
        explanation = "First, define the function signature. Second, indent the body. Finally, call the function outside the definition."
    ),
    Problem(
        id = "complexity_easy_student_7_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Range loop count",
        summary = "Counting iterations in a for loop.",
        prompt = "How many times will 'Looping' be printed?",
        code = """
            for i in range(3):
                print("Looping")
        """.trimIndent(),
        options = listOf(
            "3 times",
            "2 times",
            "1 time",
            "Infinite times"
        ),
        answerIndex = 0,
        explanation = "`range(3)` creates a sequence of 3 numbers (0, 1, 2). The loop runs once for each number."
    ),
    Problem(
        id = "trace_easy_student_7_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Math updates",
        summary = "Tracking a variable's value through subtraction and multiplication.",
        prompt = "What is the final value of `score`?",
        code = """
            score = 10
            score = score - 2
            score = score * 2
        """.trimIndent(),
        options = listOf(
            "16",
            "8",
            "10",
            "6"
        ),
        answerIndex = 0,
        explanation = "First, `score` becomes 8 (10 - 2). Then it is multiplied by 2 to become 16."
    ),
    Problem(
        id = "match_easy_student_7_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print specific string",
        summary = "Finding the code that outputs a string with a space.",
        prompt = "Which code produces the exact output: `Hello World`?",
        code = "",
        options = listOf(
            "print('Hello' + ' ' + 'World')",
            "print('HelloWorld')",
            "print('Hello' * 2)",
            "print('World Hello')"
        ),
        answerIndex = 0,
        explanation = "Concatenating 'Hello', a space ' ', and 'World' creates the exact string `Hello World`."
    )
)
