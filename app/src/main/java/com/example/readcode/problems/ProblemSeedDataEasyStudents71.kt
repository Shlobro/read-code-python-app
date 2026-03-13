package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents71 = listOf(
    Problem(
        id = "bug_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong Starting Value",
        summary = "The code wants to multiply numbers together.",
        prompt = "What is the bug in this program?",
        code = """
            product = 0
            for number in [2, 3, 4]:
                product *= number
            print(product)
        """.trimIndent(),
        options = listOf(
            "The loop should use `range(2, 4)`.",
            "It should print inside the loop.",
            "`product` should start at 1.",
            "The list needs strings, not numbers."
        ),
        answerIndex = 2,
        explanation = "A product accumulator should start at 1. Starting at 0 keeps the result at 0."
    ),
    Problem(
        id = "output_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Subtract",
        summary = "A variable changes twice before it is printed.",
        prompt = "What does this code print?",
        code = """
            score = 5
            score += 4
            score -= 2
            print(score)
        """.trimIndent(),
        options = listOf(
            "7",
            "9",
            "2",
            "5"
        ),
        answerIndex = 0,
        explanation = "The value goes from 5 to 9, then from 9 to 7."
    ),
    Problem(
        id = "purpose_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Positive Numbers",
        summary = "A loop increases a counter only for values above zero.",
        prompt = "What does this code do overall?",
        code = """
            values = [3, -1, 0, 5]
            count = 0
            for value in values:
                if value > 0:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "It adds all numbers in the list.",
            "It counts how many values are positive.",
            "It removes negative numbers from the list.",
            "It finds the largest value."
        ),
        answerIndex = 1,
        explanation = "The counter goes up once for each value greater than 0."
    ),
    Problem(
        id = "fill_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check Two Conditions",
        summary = "The `if` statement should be true only when both comparisons are true.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            age = 19
            has_id = True
            if age >= 18 __ has_id:
                print("allowed")
        """.trimIndent(),
        options = listOf(
            "or",
            "not",
            "and",
            "in"
        ),
        answerIndex = 2,
        explanation = "The code should require both conditions, so it needs `and`."
    ),
    Problem(
        id = "order_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make and Print a Sum",
        summary = "Arrange the lines into a small working program.",
        prompt = "Arrange these lines into the correct order.",
        code = "",
        options = listOf(
            "print(total)",
            "a = 2",
            "b = 5",
            "total = a + b"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 3, 0),
        explanation = "Define `a` and `b`, compute `total`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Two Simple Loops",
        summary = "Each loop prints a fixed number of times.",
        prompt = "How many times does `print(...)` run in total?",
        code = """
            for i in range(2):
                print(i)

            for j in range(3):
                print(j)
        """.trimIndent(),
        options = listOf(
            "6 times",
            "5 times",
            "3 times",
            "2 times"
        ),
        answerIndex = 1,
        explanation = "The first loop prints 2 times and the second loop prints 3 times, so the total is 5."
    ),
    Problem(
        id = "trace_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `steps`",
        summary = "The variable changes in a short loop.",
        prompt = "What is the value of `steps` after the code finishes?",
        code = """
            steps = 1
            for i in range(3):
                steps += 2
        """.trimIndent(),
        options = listOf(
            "6",
            "9",
            "7",
            "5"
        ),
        answerIndex = 2,
        explanation = "The loop runs 3 times. Starting from 1 and adding 2 three times gives 7."
    ),
    Problem(
        id = "match_easy_student_71",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `go!`",
        summary = "Choose the code that prints the exact text `go!`.",
        prompt = "Which code produces `go!`?",
        code = "",
        options = listOf(
            "print(\"go\")",
            "print(\"GO!\")",
            "print(\"go!\")",
            "print(\"go\", \"!\")"
        ),
        answerIndex = 2,
        explanation = "Only `print(\"go!\")` prints the exact text `go!`."
    )
)
