package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents65 = listOf(
    Problem(
        id = "bug_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong Variable Printed",
        summary = "The code updates one variable but prints the other one.",
        prompt = "What is the bug in this code?",
        code = """
            score = 4
            bonus = 2
            score = score + bonus
            print(bonus)
        """.trimIndent(),
        options = listOf(
            "`score` should start at 0.",
            "It needs a loop.",
            "It prints the wrong variable.",
            "`bonus` must be a string."
        ),
        answerIndex = 2,
        explanation = "The code correctly updates `score`, but the last line prints `bonus` instead of the new score."
    ),
    Problem(
        id = "output_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Double",
        summary = "A number is increased once and then multiplied.",
        prompt = "What does this code print?",
        code = """
            value = 3
            value = value + 1
            value = value * 2
            print(value)
        """.trimIndent(),
        options = listOf(
            "6",
            "8",
            "7",
            "4"
        ),
        answerIndex = 1,
        explanation = "The value changes from 3 to 4, then 4 to 8."
    ),
    Problem(
        id = "purpose_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Big Numbers",
        summary = "The loop adds one whenever it sees a number above 5.",
        prompt = "What does this code do overall?",
        code = """
            numbers = [2, 8, 5, 9]
            count = 0
            for number in numbers:
                if number > 5:
                    count += 1
            print(count)
        """.trimIndent(),
        options = listOf(
            "It adds all the numbers together.",
            "It finds the biggest number.",
            "It counts numbers greater than 5.",
            "It removes numbers below 5."
        ),
        answerIndex = 2,
        explanation = "The variable `count` goes up by one only for values larger than 5."
    ),
    Problem(
        id = "fill_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check Equality",
        summary = "Use the operator that compares two values.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            if total ___ 10:
                print("ten")
        """.trimIndent(),
        options = listOf(
            "==",
            "=",
            "+=",
            "!="
        ),
        answerIndex = 0,
        explanation = "`==` checks whether `total` has the value 10."
    ),
    Problem(
        id = "order_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print the First Name",
        summary = "Arrange the lines to store a list and print its first item.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(names[0])",
            "names = [\"Mia\", \"Noah\"]",
            "print(\"done\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 0, 2),
        explanation = "The list must be created before `names[0]` can be printed."
    ),
    Problem(
        id = "complexity_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Size",
        summary = "The body runs once for each value produced by `range`.",
        prompt = "How many times does the loop run?",
        code = """
            for step in range(6):
                print(step)
        """.trimIndent(),
        options = listOf(
            "5 times",
            "7 times",
            "6 times",
            "1 time"
        ),
        answerIndex = 2,
        explanation = "`range(6)` produces 0 through 5, so the loop body runs 6 times."
    ),
    Problem(
        id = "trace_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `pages`",
        summary = "The variable changes in a short loop with fixed additions.",
        prompt = "What is the value of `pages` at the end?",
        code = """
            pages = 1
            for _ in range(3):
                pages += 2
        """.trimIndent(),
        options = listOf(
            "5",
            "7",
            "6",
            "8"
        ),
        answerIndex = 1,
        explanation = "Starting from 1, adding 2 three times gives 7."
    ),
    Problem(
        id = "match_easy_student_65",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints 4 from a small list.",
        prompt = "Which code produces `4`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint(len(nums))",
            "nums = [4, 5]\nprint(nums[1])",
            "nums = [2, 2]\nprint(nums[0])",
            "nums = [4, 1]\nprint(nums[0])"
        ),
        answerIndex = 3,
        explanation = "The last option prints the item at index 0, which is 4."
    )
)
