package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents28 = listOf(
    Problem(
        id = "easy_students_28_find_bug",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "A basic function with an indentation error.",
        prompt = "Why will this code cause an error?",
        code = """
            def greet():
            print("Hello, world!")
            
            greet()
        """.trimIndent(),
        options = listOf(
            "The print statement is not indented",
            "The function name is invalid",
            "Missing parameters in the function definition",
            "The string needs single quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, the body of a function must be indented."
    ),
    Problem(
        id = "easy_students_28_output",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Simple Math",
        summary = "Evaluating a basic mathematical expression.",
        prompt = "What is the output of this code?",
        code = """
            x = 10
            y = 3
            print(x - y * 2)
        """.trimIndent(),
        options = listOf("4", "14", "20", "7"),
        answerIndex = 0,
        explanation = "Multiplication has higher precedence than subtraction, so it calculates 10 - 6, which is 4."
    ),
    Problem(
        id = "easy_students_28_purpose",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "List Appender",
        summary = "A function that collects numbers into a list.",
        prompt = "What does this code do?",
        code = """
            results = []
            for i in range(3):
                results.append(i)
            print(results)
        """.trimIndent(),
        options = listOf(
            "Creates a list with numbers 0, 1, and 2",
            "Creates a list with numbers 1, 2, and 3",
            "Calculates the sum of numbers up to 3",
            "Prints the numbers 0, 1, and 2 on separate lines"
        ),
        answerIndex = 0,
        explanation = "The loop runs for i = 0, 1, 2, and appends each to the list, resulting in [0, 1, 2]."
    ),
    Problem(
        id = "easy_students_28_fill_blank",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "If Condition",
        summary = "Completing an if statement.",
        prompt = "Fill in the blank to print 'Positive' if x is greater than 0.",
        code = """
            x = 5
            if x ___ 0:
                print("Positive")
        """.trimIndent(),
        options = listOf(">", "<", "==", "!="),
        answerIndex = 0,
        explanation = "The greater-than symbol `>` checks if x is strictly larger than 0."
    ),
    Problem(
        id = "easy_students_28_order_steps",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap Variables",
        summary = "Swapping two variables using a temporary variable.",
        prompt = "Arrange the lines to swap the values of a and b correctly.",
        code = "",
        options = listOf(
            "a = 10\nb = 20",
            "temp = a",
            "a = b",
            "b = temp",
            "print(a, b)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the variables, store 'a' in 'temp', assign 'b' to 'a', and finally assign 'temp' to 'b'."
    ),
    Problem(
        id = "easy_students_28_complexity",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Single Loop",
        summary = "Iterating through a list once.",
        prompt = "How many times does the print statement run?",
        code = """
            items = ["apple", "banana", "cherry", "date"]
            for item in items:
                print(item)
        """.trimIndent(),
        options = listOf("4 times", "1 time", "16 times", "0 times"),
        answerIndex = 0,
        explanation = "The loop runs once for each of the 4 items in the list."
    ),
    Problem(
        id = "easy_students_28_trace_var",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a Total",
        summary = "Following a variable's value through a loop.",
        prompt = "What is the value of 'total' after the second iteration of the loop (when i is 2)?",
        code = """
            total = 0
            for i in range(1, 4):
                total = total + i
                # What is 'total' here when i == 2?
        """.trimIndent(),
        options = listOf("3", "1", "6", "2"),
        answerIndex = 0,
        explanation = "Iteration 1 (i=1): total becomes 0 + 1 = 1. Iteration 2 (i=2): total becomes 1 + 2 = 3."
    ),
    Problem(
        id = "easy_students_28_match_output",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Joining two strings.",
        prompt = "Which code produces the output `HelloWorld` (no space)?",
        code = "",
        options = listOf(
            "print(\"Hello\" + \"World\")",
            "print(\"Hello\", \"World\")",
            "print(\"Hello World\")",
            "print(\"Hello\" * \"World\")"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings without adding a space. A comma `,` adds a space by default."
    )
)
