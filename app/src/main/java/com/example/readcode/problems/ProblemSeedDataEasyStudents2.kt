package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents2 = listOf(
    Problem(
        id = "bug_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "A structural statement is missing its colon.",
        prompt = "Why will this code cause a SyntaxError?",
        code = """
            age = 20
            if age >= 18
                print("Adult")
        """.trimIndent(),
        options = listOf(
            "The if statement is missing a colon at the end",
            "age must be a string",
            "print needs to be capitalized",
            "18 should be in quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, structural statements like `if`, `for`, `while`, and `def` must end with a colon `:`."
    ),
    Problem(
        id = "output_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Simple Math",
        summary = "Basic arithmetic operations.",
        prompt = "What does this code print?",
        code = """
            x = 5
            y = 3
            print(x + y * 2)
        """.trimIndent(),
        options = listOf(
            "11",
            "16",
            "10",
            "8"
        ),
        answerIndex = 0,
        explanation = "Python follows standard order of operations. Multiplication happens first (3 * 2 = 6), then addition (5 + 6 = 11)."
    ),
    Problem(
        id = "purpose_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count down",
        summary = "A while loop that decreases a variable.",
        prompt = "What is the overall purpose of this code?",
        code = """
            n = 3
            while n > 0:
                print(n)
                n = n - 1
            print("Go!")
        """.trimIndent(),
        options = listOf(
            "To print a countdown from 3 to 1 and then say Go!",
            "To print numbers from 1 to 3",
            "To count how many numbers are greater than 0",
            "To add numbers together until reaching 0"
        ),
        answerIndex = 0,
        explanation = "The loop prints the current value of `n` and decreases it by 1 each time until `n` is 0, acting as a countdown."
    ),
    Problem(
        id = "fill_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Function definition",
        summary = "Defining a new function in Python.",
        prompt = "Which keyword is used to define a function?",
        code = """
            ___ say_hello():
                print("Hello there!")
            
            say_hello()
        """.trimIndent(),
        options = listOf(
            "def",
            "function",
            "fun",
            "create"
        ),
        answerIndex = 0,
        explanation = "In Python, the `def` keyword is used to define a new function."
    ),
    Problem(
        id = "order_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Assign and print",
        summary = "Arrange the lines to create two variables and print their sum.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "print(x + y)",
            "y = 5",
            "x = 10"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 0),
        explanation = "The variables `x` and `y` must be assigned values before they can be added and printed."
    ),
    Problem(
        id = "complexity_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Print count",
        summary = "How many times does the print statement run?",
        prompt = "How many times does `print(\"Hello\")` execute?",
        code = """
            for i in range(3):
                print("Hello")
        """.trimIndent(),
        options = listOf("3", "0", "1", "4"),
        answerIndex = 0,
        explanation = "`range(3)` produces the sequence 0, 1, 2, which consists of exactly 3 items, so the loop runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track total",
        summary = "What is the value of a variable after two additions?",
        prompt = "What is the value of `total` after the third line?",
        code = """
            total = 0
            total = total + 5
            total = total + 2
        """.trimIndent(),
        options = listOf("7", "5", "2", "0"),
        answerIndex = 0,
        explanation = "`total` starts at 0, becomes 5, and then 2 is added to make it 7."
    ),
    Problem(
        id = "match_easy_student_3",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: HelloWorld",
        summary = "Which snippet prints the concatenated string?",
        prompt = "Which code produces the output `HelloWorld`?",
        code = "",
        options = listOf(
            "print(\"Hello\" + \"World\")",
            "print(\"Hello\", \"World\")",
            "print(\"HelloWorld\" - \" \")",
            "print(\"Hello\" * \"World\")"
        ),
        answerIndex = 0,
        explanation = "Using `+` concatenates strings without adding a space. Using a comma `,` automatically adds a space."
    )
)
