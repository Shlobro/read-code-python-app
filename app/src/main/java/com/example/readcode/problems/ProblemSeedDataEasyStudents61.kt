package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents61 = listOf(
    Problem(
        id = "bug_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Counter Starts Too High",
        summary = "A loop is counting names, but the starting value is wrong.",
        prompt = "What is the real bug?",
        code = """
            names = ["Ava", "Ben", "Cara"]
            count = 1
            for name in names:
                count += 1
            print(count)
        """.trimIndent(),
        options = listOf(
            "The loop should use indexes instead of names.",
            "The list should contain numbers.",
            "`count` should start at 0.",
            "The print line should be inside the loop."
        ),
        answerIndex = 2,
        explanation = "To count items correctly, the counter should begin at 0 before the loop."
    ),
    Problem(
        id = "output_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Subtract",
        summary = "One variable changes two times before it is printed.",
        prompt = "What does this code print?",
        code = """
            score = 10
            score = score + 4
            score = score - 3
            print(score)
        """.trimIndent(),
        options = listOf(
            "11",
            "7",
            "14",
            "13"
        ),
        answerIndex = 0,
        explanation = "The value goes from 10 to 14, then from 14 to 11."
    ),
    Problem(
        id = "purpose_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Build a Doubled List",
        summary = "The loop adds each number times two into a new list.",
        prompt = "What does this code do overall?",
        code = """
            values = [2, 4, 6]
            doubled = []
            for value in values:
                doubled.append(value * 2)
        """.trimIndent(),
        options = listOf(
            "It removes duplicate numbers.",
            "It creates a list with each value doubled.",
            "It finds the largest value.",
            "It turns the numbers into strings."
        ),
        answerIndex = 1,
        explanation = "Each loop pass multiplies the current value by 2 and stores it in `doubled`."
    ),
    Problem(
        id = "fill_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check for Equality",
        summary = "Use the operator that makes the condition true when the values match.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            answer = 8
            if answer __ 8:
                print("correct")
        """.trimIndent(),
        options = listOf(
            "=",
            "!=",
            "==",
            ">"
        ),
        answerIndex = 2,
        explanation = "`==` compares two values and is true when they are equal."
    ),
    Problem(
        id = "order_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make and Print Total",
        summary = "Arrange the lines to add two numbers and print the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "right = 5",
            "total = left + right",
            "left = 2"
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 1, 2, 0),
        explanation = "Assign both variables first, then compute `total`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Repeats",
        summary = "Count how many times the loop body runs.",
        prompt = "How many times does the loop run?",
        code = """
            for step in range(3):
                print(step)
        """.trimIndent(),
        options = listOf(
            "2 times",
            "4 times",
            "1 time",
            "3 times"
        ),
        answerIndex = 3,
        explanation = "`range(3)` gives 0, 1, and 2, so the loop runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `total`",
        summary = "The variable is updated inside a short loop.",
        prompt = "What is the value of `total` at the end?",
        code = """
            total = 1
            for n in [2, 3]:
                total += n
        """.trimIndent(),
        options = listOf(
            "5",
            "6",
            "4",
            "3"
        ),
        answerIndex = 1,
        explanation = "Start at 1, add 2 to get 3, then add 3 to get 6."
    ),
    Problem(
        id = "match_easy_student_61",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `9`",
        summary = "Choose the code that prints nine.",
        prompt = "Which code produces `9`?",
        code = "",
        options = listOf(
            "print(3 + 5)",
            "print(12 - 4)",
            "print(3 * 3)",
            "print(18 / 3)"
        ),
        answerIndex = 2,
        explanation = "`3 * 3` evaluates to 9."
    )
)
