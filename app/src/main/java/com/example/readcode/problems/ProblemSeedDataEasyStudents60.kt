package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents60 = listOf(
    Problem(
        id = "bug_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong Start Value",
        summary = "A total starts with the wrong number before a loop.",
        prompt = "What is the real bug?",
        code = """
            total = 1
            for score in [4, 5]:
                total += score
            print(total)
        """.trimIndent(),
        options = listOf(
            "The loop should use `while`.",
            "The total should start at 0.",
            "The scores must be strings.",
            "The print line needs more spaces."
        ),
        answerIndex = 1,
        explanation = "The code is trying to add the scores, so `total` should start at 0 instead of 1."
    ),
    Problem(
        id = "output_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "One More Added",
        summary = "A number changes twice before it is printed.",
        prompt = "What does this code print?",
        code = """
            value = 2
            value = value + 3
            value = value + 1
            print(value)
        """.trimIndent(),
        options = listOf(
            "5",
            "7",
            "6",
            "8"
        ),
        answerIndex = 2,
        explanation = "Start at 2, add 3 to get 5, then add 1 to get 6."
    ),
    Problem(
        id = "purpose_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Passing Scores",
        summary = "The loop increases a counter only for values at least 50.",
        prompt = "What does this code do overall?",
        code = """
            scores = [40, 75, 60]
            passed = 0
            for score in scores:
                if score >= 50:
                    passed += 1
        """.trimIndent(),
        options = listOf(
            "It counts scores that passed.",
            "It finds the largest score.",
            "It sorts the scores.",
            "It adds 50 to every score first."
        ),
        answerIndex = 0,
        explanation = "The variable `passed` goes up by 1 only when a score is 50 or higher."
    ),
    Problem(
        id = "fill_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Find List Size",
        summary = "Use the built-in function that returns how many items are in a list.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            names = ["Ana", "Bo", "Chen"]
            print(__(names))
        """.trimIndent(),
        options = listOf(
            "str",
            "len",
            "sum",
            "int"
        ),
        answerIndex = 1,
        explanation = "`len(names)` returns the number of items in the list."
    ),
    Problem(
        id = "order_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Store Then Print",
        summary = "Arrange the lines to save a word and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(word)",
            "word = \"hello\"",
            "word = word.upper()"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0),
        explanation = "Create the variable first, change it to uppercase, then print the final value."
    ),
    Problem(
        id = "complexity_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop of Five",
        summary = "The `range` call controls how many times the body runs.",
        prompt = "How many times does the loop run?",
        code = """
            for number in range(5):
                print(number)
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "2 times"
        ),
        answerIndex = 0,
        explanation = "`range(5)` produces 0, 1, 2, 3, and 4, so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `points`",
        summary = "The variable increases and then doubles.",
        prompt = "What is the value of `points` at the end?",
        code = """
            points = 3
            points = points + 2
            points = points * 2
        """.trimIndent(),
        options = listOf(
            "7",
            "10",
            "12",
            "8"
        ),
        answerIndex = 1,
        explanation = "Start at 3, add 2 to get 5, then multiply by 2 to get 10."
    ),
    Problem(
        id = "match_easy_student_60",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints the number four.",
        prompt = "Which code produces `4`?",
        code = "",
        options = listOf(
            "print(2 + 1)",
            "print(2 * 2)",
            "print(8 / 4)",
            "print(5 - 3)"
        ),
        answerIndex = 1,
        explanation = "`2 * 2` evaluates to 4, so that code prints the required output."
    )
)
