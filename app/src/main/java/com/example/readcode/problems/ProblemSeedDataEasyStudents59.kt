package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents59 = listOf(
    Problem(
        id = "bug_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "One Step Too Far",
        summary = "A list is read using an index that does not exist.",
        prompt = "What is the real bug?",
        code = """
            scores = [10, 20, 30]
            print(scores[3])
        """.trimIndent(),
        options = listOf(
            "The list should use parentheses.",
            "The numbers should be strings.",
            "Index 3 is out of range.",
            "print must be inside a loop."
        ),
        answerIndex = 2,
        explanation = "The valid indexes are 0, 1, and 2, so `scores[3]` goes past the end of the list."
    ),
    Problem(
        id = "output_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Count by Twos",
        summary = "The variable changes inside a short loop.",
        prompt = "What does this code print?",
        code = """
            total = 1
            for _ in range(2):
                total = total + 2
            print(total)
        """.trimIndent(),
        options = listOf(
            "3",
            "5",
            "4",
            "6"
        ),
        answerIndex = 1,
        explanation = "Start at 1, add 2 twice, and the final value is 5."
    ),
    Problem(
        id = "purpose_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Total Cost",
        summary = "A loop adds each price into one variable.",
        prompt = "What does this code do overall?",
        code = """
            prices = [4, 3, 2]
            total = 0
            for price in prices:
                total += price
        """.trimIndent(),
        options = listOf(
            "It sorts the prices from low to high.",
            "It removes the last price.",
            "It prints every price twice.",
            "It adds the prices together."
        ),
        answerIndex = 3,
        explanation = "The loop visits each price and adds it into `total`, so it computes the sum."
    ),
    Problem(
        id = "fill_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Loop Over a List",
        summary = "Choose the keyword that starts a simple loop.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            colors = ["red", "blue"]
            ___ color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "for",
            "if",
            "def",
            "while"
        ),
        answerIndex = 0,
        explanation = "`for` starts a loop that goes through each item in `colors`."
    ),
    Problem(
        id = "order_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make and Print a Sum",
        summary = "Arrange the lines to add two values and print the answer.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "left = 7",
            "total = left + right",
            "right = 2"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 3, 2, 0),
        explanation = "Create both variables first, then calculate `total`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Iterations",
        summary = "A `range` decides how many times the loop body runs.",
        prompt = "How many times does the loop run?",
        code = """
            for i in range(3):
                print(i)
        """.trimIndent(),
        options = listOf(
            "2 times total",
            "4 times total",
            "Only 1 time",
            "3 times"
        ),
        answerIndex = 3,
        explanation = "`range(3)` produces 0, 1, and 2, so the loop runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `level`",
        summary = "The variable goes up and then down once.",
        prompt = "What is the value of `level` at the end?",
        code = """
            level = 5
            level = level + 4
            level = level - 3
        """.trimIndent(),
        options = listOf(
            "6",
            "7",
            "9",
            "8"
        ),
        answerIndex = 0,
        explanation = "Start at 5, add 4 to get 9, then subtract 3 to get 6."
    ),
    Problem(
        id = "match_easy_student_59",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `catcat`",
        summary = "Choose the code that repeats the word exactly twice.",
        prompt = "Which code produces `catcat`?",
        code = "",
        options = listOf(
            "print(\"cat\" + \"dog\")",
            "print(\"cat\")",
            "print(\"catcatcat\")",
            "print(\"cat\" * 2)"
        ),
        answerIndex = 3,
        explanation = "Repeating the string with `* 2` makes `catcat`."
    )
)
