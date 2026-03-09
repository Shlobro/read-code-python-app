package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents4 = listOf(
    Problem(
        id = "bug_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Assignment instead of comparison",
        summary = "Using = instead of == inside a condition.",
        prompt = "Why will this code cause a SyntaxError?",
        code = """
            x = 10
            if x = 10:
                print("ten")
        """.trimIndent(),
        options = listOf(
            "= is assignment; == is needed for comparison",
            "10 must be written as \"10\"",
            "The if block needs an else branch",
            "print must come before the if"
        ),
        answerIndex = 0,
        explanation = "In Python, `=` assigns a value and cannot appear inside a condition. Use `==` to compare two values."
    ),
    Problem(
        id = "output_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Adding two strings together.",
        prompt = "What does this code print?",
        code = """
            a = "Hello"
            b = "World"
            print(a + b)
        """.trimIndent(),
        options = listOf(
            "HelloWorld",
            "Hello World",
            "Hello",
            "World"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings exactly as they are. Since there is no space in either string, they are glued together as \"HelloWorld\"."
    ),
    Problem(
        id = "purpose_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "List sum",
        summary = "Adding up numbers in a loop.",
        prompt = "What is the overall purpose of this code?",
        code = """
            total = 0
            for n in [1, 2, 3, 4]:
                total += n
        """.trimIndent(),
        options = listOf(
            "To calculate the sum of all the numbers in the list",
            "To find the largest number in the list",
            "To count how many items are in the list",
            "To multiply all the numbers together"
        ),
        answerIndex = 0,
        explanation = "The variable `total` starts at 0, and each number in the list is added to it, calculating the sum."
    ),
    Problem(
        id = "fill_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Print statement",
        summary = "Displaying text on the screen.",
        prompt = "Which function fills the blank to display the name?",
        code = """
            name = "Alice"
            ___(name)
        """.trimIndent(),
        options = listOf(
            "print",
            "show",
            "display",
            "output"
        ),
        answerIndex = 0,
        explanation = "In Python, `print()` is the built-in function used to display output to the screen."
    ),
    Problem(
        id = "order_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple addition",
        summary = "Arrange the lines to define variables and print their sum.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "x = 10",
            "y = 20",
            "print(x + y)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "Variables `x` and `y` must be defined before they can be added together in the `print` statement."
    ),
    Problem(
        id = "complexity_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Single loop",
        summary = "Counting loop executions.",
        prompt = "How many times does the print statement run?",
        code = """
            for i in range(5):
                print(i)
        """.trimIndent(),
        options = listOf("5", "4", "1", "0"),
        answerIndex = 0,
        explanation = "`range(5)` generates 5 numbers (0, 1, 2, 3, 4), so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Increment counter",
        summary = "Tracking a variable as it increases.",
        prompt = "What is the value of `count` after all the code runs?",
        code = """
            count = 0
            count = count + 1
            count = count + 2
        """.trimIndent(),
        options = listOf("3", "1", "2", "0"),
        answerIndex = 0,
        explanation = "`count` starts at 0. It increases by 1 (becoming 1), and then increases by 2 (becoming 3)."
    ),
    Problem(
        id = "match_easy_student_5",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Math output",
        summary = "Which snippet prints exactly the number 10?",
        prompt = "Which code produces the exact output `10`?",
        code = "",
        options = listOf(
            "print(5 + 5)",
            "print(\"5 + 5\")",
            "print(10 + 10)",
            "print(5 * 5)"
        ),
        answerIndex = 0,
        explanation = "`print(5 + 5)` evaluates the math expression and prints `10`. `print(\"5 + 5\")` prints the string literally as `5 + 5`."
    )
)
