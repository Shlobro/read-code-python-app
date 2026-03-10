package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents24 = listOf(
    Problem(
        id = "bug_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Range boundaries",
        summary = "A loop that stops earlier than expected.",
        prompt = "What is the bug in this code intended to print 1 through 5?",
        code = """
            # Print numbers 1 to 5
            for i in range(1, 5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "The loop stops before reaching 5",
            "`range()` cannot take two arguments",
            "`i` is not defined before the loop",
            "The `print` function requires a string"
        ),
        answerIndex = 0,
        explanation = "In Python, `range(start, stop)` generates numbers up to, but not including, the stop value. It should be `range(1, 6)`."
    ),

    Problem(
        id = "output_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List indexing",
        summary = "Accessing an element from a list by its index.",
        prompt = "What does this code output?",
        code = """
            colors = ["red", "blue", "green"]
            print(colors[1])
        """.trimIndent(),
        options = listOf(
            "red",
            "blue",
            "green",
            "Error"
        ),
        answerIndex = 1,
        explanation = "Python uses zero-based indexing, so index 0 is 'red' and index 1 is 'blue'."
    ),

    Problem(
        id = "purpose_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Accumulator pattern",
        summary = "A common pattern for aggregating data in a sequence.",
        prompt = "What is the purpose of this function?",
        code = """
            def compute(arr):
                res = 0
                for num in arr:
                    res = res + num
                return res
        """.trimIndent(),
        options = listOf(
            "Calculates the sum of all numbers in the list",
            "Counts the number of items in the list",
            "Finds the largest number in the list",
            "Adds the first and last number"
        ),
        answerIndex = 0,
        explanation = "The function iterates through the list, adding each number to a running total `res`, which effectively calculates the sum."
    ),

    Problem(
        id = "fill_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Function return",
        summary = "Sending a result back to the caller.",
        prompt = "Fill in the blank to send the greeting back from the function.",
        code = """
            def get_greeting(name):
                ___ "Hello, " + name
        """.trimIndent(),
        options = listOf(
            "return",
            "print",
            "yield",
            "output"
        ),
        answerIndex = 0,
        explanation = "The `return` statement is used to exit a function and pass a value back to the caller."
    ),

    Problem(
        id = "order_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Conditional logic",
        summary = "Writing a simple if-else statement inside a function.",
        prompt = "Arrange the lines to create a function that returns 'Pass' if the score is at least 50, otherwise 'Fail'.",
        code = "",
        options = listOf(
            "def check_grade(score):",
            "if score >= 50:",
            "return 'Pass'",
            "else:",
            "return 'Fail'"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the function, check the condition, return 'Pass' if true, otherwise fallback to the else block to return 'Fail'."
    ),

    Problem(
        id = "complexity_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop iterations",
        summary = "Determining the number of times a loop body executes.",
        prompt = "How many times will the `print` function be called?",
        code = """
            names = ["Alice", "Bob", "Charlie"]
            for name in names:
                print(len(name))
        """.trimIndent(),
        options = listOf(
            "3",
            "1",
            "4",
            "0"
        ),
        answerIndex = 0,
        explanation = "The loop iterates exactly once for each item in the list. Since there are 3 names, it runs 3 times."
    ),

    Problem(
        id = "trace_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Sequential assignment",
        summary = "Tracing how variables update step-by-step.",
        prompt = "What is the value of `b` at the end?",
        code = """
            a = 10
            b = 5
            a = a - b
            b = a + b
        """.trimIndent(),
        options = listOf(
            "15",
            "10",
            "5",
            "0"
        ),
        answerIndex = 1,
        explanation = "First, `a` becomes 10 - 5 = 5. Then, `b` becomes 5 + 5 = 10."
    ),

    Problem(
        id = "match_easy_students_24_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: Score: 100",
        summary = "Choosing the correct way to concatenate a string and an integer.",
        prompt = "Which code snippet prints `Score: 100`?",
        code = "",
        options = listOf(
            "score = 100\nprint('Score: ' + str(score))",
            "score = 100\nprint('Score: ' + score)",
            "score = 100\nprint(Score: 100)",
            "score = 100\nprint('Score: score')"
        ),
        answerIndex = 0,
        explanation = "In Python, you must convert an integer to a string using `str()` before you can concatenate it with another string using `+`."
    )
)
