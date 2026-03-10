package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents26 = listOf(
    Problem(
        id = "bug_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Incorrect list index",
        summary = "Accessing an element that doesn't exist.",
        prompt = "What is the bug when trying to print the last element of this list?",
        code = """
            colors = ["red", "green", "blue"]
            print(colors[3])
        """.trimIndent(),
        options = listOf(
            "Index 3 is out of bounds, it should be 2",
            "Lists use parentheses for indexing",
            "The list doesn't have a 'yellow' color",
            "Print needs a format string"
        ),
        answerIndex = 0,
        explanation = "List indices start at 0. A list with 3 elements has valid indices 0, 1, and 2. Attempting to access index 3 causes an IndexError."
    ),

    Problem(
        id = "output_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Joining strings together.",
        prompt = "What does this code output?",
        code = """
            greeting = "Hello"
            name = "Alice"
            print(greeting + " " + name)
        """.trimIndent(),
        options = listOf(
            "Hello Alice",
            "HelloAlice",
            "Hello + name",
            "greeting Alice"
        ),
        answerIndex = 0,
        explanation = "The `+` operator joins strings. It concatenates 'Hello', a space ' ', and 'Alice' to form 'Hello Alice'."
    ),

    Problem(
        id = "purpose_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Sum of a list",
        summary = "Iterating through a list to add numbers.",
        prompt = "What is the purpose of this function?",
        code = """
            def calculate(numbers):
                total = 0
                for num in numbers:
                    total += num
                return total
        """.trimIndent(),
        options = listOf(
            "It calculates the sum of all numbers in the list",
            "It finds the maximum number in the list",
            "It counts how many numbers are in the list",
            "It calculates the average of the numbers"
        ),
        answerIndex = 0,
        explanation = "The loop adds each `num` to `total`, resulting in the sum of all elements in the `numbers` list."
    ),

    Problem(
        id = "fill_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Return statement",
        summary = "Sending a value back from a function.",
        prompt = "Fill in the blank to make the function return the doubled value.",
        code = """
            def double_number(x):
                ___ x * 2
        """.trimIndent(),
        options = listOf(
            "return",
            "print",
            "output",
            "send"
        ),
        answerIndex = 0,
        explanation = "The `return` keyword is used to send a computed value back to the caller of the function."
    ),

    Problem(
        id = "order_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "If-else structure",
        summary = "Checking a condition and printing a result.",
        prompt = "Arrange the lines to correctly check if a number is positive.",
        code = "",
        options = listOf(
            "number = 5",
            "if number > 0:",
            "    print(\"Positive\")",
            "else:",
            "    print(\"Not positive\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the variable, then check the condition with `if`, print if true, handle the alternative with `else`, and print the other result."
    ),

    Problem(
        id = "complexity_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Sequential loops",
        summary = "Counting iterations in non-nested loops.",
        prompt = "How many total times will a message be printed?",
        code = """
            for i in range(3):
                print("First loop")
                
            for j in range(4):
                print("Second loop")
        """.trimIndent(),
        options = listOf(
            "7",
            "12",
            "3",
            "4"
        ),
        answerIndex = 0,
        explanation = "The first loop runs 3 times. After it finishes, the second loop runs 4 times. They are not nested, so the total is 3 + 4 = 7."
    ),

    Problem(
        id = "trace_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable reassignment",
        summary = "Tracking a variable as it gets new values.",
        prompt = "What is the final value of `score`?",
        code = """
            score = 10
            score = score + 5
            score = 20
        """.trimIndent(),
        options = listOf(
            "20",
            "15",
            "10",
            "35"
        ),
        answerIndex = 0,
        explanation = "`score` starts at 10, becomes 15, but then is completely reassigned to 20 on the last line."
    ),

    Problem(
        id = "match_easy_students_26_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: 8",
        summary = "Basic multiplication in Python.",
        prompt = "Which code snippet prints `8`?",
        code = "",
        options = listOf(
            "print(2 * 4)",
            "print(2 ** 4)",
            "print(10 - 3)",
            "print(8 / 1)"
        ),
        answerIndex = 0,
        explanation = "The `*` operator performs multiplication. 2 * 4 equals 8."
    )
)
