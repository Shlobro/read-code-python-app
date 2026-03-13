package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents63 = listOf(
    Problem(
        id = "bug_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong Variable Changes",
        summary = "The loop should increase `score`, but a different variable is updated.",
        prompt = "What is the bug in this code?",
        code = """
            score = 0
            bonus = 1
            for _ in range(3):
                bonus += 2
            print(score)
        """.trimIndent(),
        options = listOf(
            "The loop should run 2 times.",
            "It prints too early.",
            "`score` never changes.",
            "`bonus` should start at 0."
        ),
        answerIndex = 2,
        explanation = "The code updates `bonus`, but the printed variable is `score`, so `score` stays 0."
    ),
    Problem(
        id = "output_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Two Small Updates",
        summary = "A number is changed by multiplication and subtraction before printing.",
        prompt = "What does this code print?",
        code = """
            value = 3
            value = value * 2
            value = value - 1
            print(value)
        """.trimIndent(),
        options = listOf(
            "6",
            "5",
            "12",
            "7"
        ),
        answerIndex = 1,
        explanation = "The value changes from 3 to 6, then from 6 to 5."
    ),
    Problem(
        id = "purpose_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Up to a Limit",
        summary = "A loop adds the numbers 1 through 4 into one total.",
        prompt = "What does this code do overall?",
        code = """
            total = 0
            for number in range(1, 5):
                total += number
            print(total)
        """.trimIndent(),
        options = listOf(
            "It adds 1 through 4.",
            "It prints each number twice.",
            "It builds a list of numbers.",
            "It finds the largest number in the range."
        ),
        answerIndex = 0,
        explanation = "The loop adds 1, 2, 3, and 4 into `total`, then prints that sum."
    ),
    Problem(
        id = "fill_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Add One Item",
        summary = "Use the list method that adds a single value at the end.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            names = ["Ava", "Noah"]
            names.__( "Liam" )
            print(names)
        """.trimIndent(),
        options = listOf(
            "append",
            "count",
            "sort",
            "reverse"
        ),
        answerIndex = 0,
        explanation = "`append()` adds one item to the end of the list."
    ),
    Problem(
        id = "order_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make and Print a Total",
        summary = "Arrange the lines to create a variable, change it, and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "total = total + 2",
            "total = 5",
            "print(\"done\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 0, 3),
        explanation = "Create `total` first, update it, print the value, and then print `done`."
    ),
    Problem(
        id = "complexity_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Loop Passes",
        summary = "A `range` call decides how many times the loop body runs.",
        prompt = "How many times does the loop run?",
        code = """
            for step in range(3):
                print(step)
        """.trimIndent(),
        options = listOf(
            "2 times",
            "10 times",
            "1 time",
            "3 times"
        ),
        answerIndex = 3,
        explanation = "`range(3)` produces 0, 1, and 2, so the loop body runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `pages`",
        summary = "The variable is updated by one addition and one subtraction.",
        prompt = "What is the value of `pages` at the end?",
        code = """
            pages = 7
            pages = pages + 4
            pages = pages - 2
        """.trimIndent(),
        options = listOf(
            "8",
            "9",
            "10",
            "11"
        ),
        answerIndex = 1,
        explanation = "Start at 7, add 4 to get 11, then subtract 2 to get 9."
    ),
    Problem(
        id = "match_easy_student_63",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints the result of adding 1 to 3.",
        prompt = "Which code produces `4`?",
        code = "",
        options = listOf(
            "number = 3\nprint(number)",
            "number = 3\nprint(number - 10)",
            "number = 3\nprint(number + 1)",
            "number = 3\nprint(number * 10)"
        ),
        answerIndex = 2,
        explanation = "Adding 1 to 3 gives 4, so the third option matches the output."
    )
)
