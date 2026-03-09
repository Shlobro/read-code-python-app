package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents8 = listOf(
    Problem(
        id = "bug_easy_student_8_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "A syntax error prevents the function from running.",
        prompt = "What is causing the syntax error?",
        code = """
            def say_hello()
                print("Hello!")
        """.trimIndent(),
        options = listOf(
            "A colon is missing at the end of the def line",
            "The print statement is indented incorrectly",
            "The function needs an argument",
            "Functions cannot print directly"
        ),
        answerIndex = 0,
        explanation = "In Python, structural statements like function definitions, loops, and conditionals must end with a colon `:`."
    ),
    Problem(
        id = "output_easy_student_8_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Joining two strings together.",
        prompt = "What does this code print?",
        code = """
            first = "Py"
            second = "thon"
            print(first + second)
        """.trimIndent(),
        options = listOf(
            "Python",
            "Py thon",
            "\"Py\" \"thon\"",
            "An error occurs"
        ),
        answerIndex = 0,
        explanation = "The `+` operator concatenates (joins) strings without adding any extra spaces."
    ),
    Problem(
        id = "purpose_easy_student_8_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Calculate area",
        summary = "A function performing a geometric calculation.",
        prompt = "What does this function do?",
        code = """
            def compute(length, width):
                return length * width
        """.trimIndent(),
        options = listOf(
            "Computes the area of a rectangle",
            "Finds the perimeter of a rectangle",
            "Adds two numbers together",
            "Squares the length"
        ),
        answerIndex = 0,
        explanation = "Multiplying length by width is the standard formula for calculating the area of a rectangle."
    ),
    Problem(
        id = "fill_easy_student_8_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Importing a module",
        summary = "Bringing in external functionality.",
        prompt = "Which keyword fills the blank to use the math module?",
        code = """
            ___ math
            print(math.sqrt(16))
        """.trimIndent(),
        options = listOf(
            "import",
            "include",
            "use",
            "require"
        ),
        answerIndex = 0,
        explanation = "In Python, the `import` statement is used to bring in external modules like `math`."
    ),
    Problem(
        id = "order_easy_student_8_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Basic if-else",
        summary = "Writing a simple conditional statement.",
        prompt = "Arrange the lines to check an age correctly.",
        code = "",
        options = listOf(
            "age = 20",
            "if age >= 18:",
            "    print('Adult')",
            "else:",
            "    print('Minor')"
        ),
        answerIndex = 0, // Ignored for ORDER_STEPS
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First set the variable, then start the `if` condition, indent the true block, write `else:`, and finally indent the false block."
    ),
    Problem(
        id = "complexity_easy_student_8_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Single loop count",
        summary = "Counting how many times a simple loop runs.",
        prompt = "How many times will this loop iterate?",
        code = """
            for count in range(5):
                print("Running...")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "Infinite times"
        ),
        answerIndex = 0,
        explanation = "`range(5)` generates a sequence of 5 numbers (0, 1, 2, 3, 4), so the loop runs exactly 5 times."
    ),
    Problem(
        id = "trace_easy_student_8_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable reassignment",
        summary = "Tracking a variable as it gets new values.",
        prompt = "What is the final value of x?",
        code = """
            x = 10
            x = x + 5
            x = 3
        """.trimIndent(),
        options = listOf(
            "3",
            "15",
            "10",
            "18"
        ),
        answerIndex = 0,
        explanation = "Variables hold the most recent value assigned to them. The final assignment `x = 3` completely replaces previous values."
    ),
    Problem(
        id = "match_easy_student_8_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print a list",
        summary = "Finding the code that outputs a formatted list.",
        prompt = "Which code produces the exact output: `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(1, 2, 3)",
            "print(1 + 2 + 3)",
            "print(\"1 2 3\")"
        ),
        answerIndex = 0,
        explanation = "Printing a list directly preserves its structure, outputting it with square brackets and commas."
    )
)
