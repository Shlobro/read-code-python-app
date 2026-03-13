package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents57 = listOf(
    Problem(
        id = "bug_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Method Not Called",
        summary = "The code prints a method object instead of uppercase text.",
        prompt = "What is the real bug?",
        code = """
            name = "ada"
            print(name.upper)
        """.trimIndent(),
        options = listOf(
            "The name should be capitalized first.",
            "It needs `()` after `upper`.",
            "`print` only works on numbers.",
            "Strings cannot use methods."
        ),
        answerIndex = 1,
        explanation = "`upper` is a method. Without `()`, Python prints the method reference instead of calling it."
    ),
    Problem(
        id = "output_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Print",
        summary = "Track one variable through two updates.",
        prompt = "What does this code print?",
        code = """
            total = 4
            total = total + 3
            print(total - 2)
        """.trimIndent(),
        options = listOf(
            "9",
            "7",
            "5",
            "2"
        ),
        answerIndex = 2,
        explanation = "`total` becomes 7, and `7 - 2` prints 5."
    ),
    Problem(
        id = "purpose_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Names",
        summary = "The function returns how many items are in a list.",
        prompt = "What does this function do?",
        code = """
            def how_many(names):
                return len(names)
        """.trimIndent(),
        options = listOf(
            "Sorts the names.",
            "Prints each name.",
            "Counts the names.",
            "Removes blank names."
        ),
        answerIndex = 2,
        explanation = "`len(names)` returns the number of items in the list."
    ),
    Problem(
        id = "fill_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Loop Four Times",
        summary = "Choose the value that makes the loop print 0, 1, 2, 3.",
        prompt = "Fill in the blank correctly.",
        code = """
            for i in range(___):
                print(i)
        """.trimIndent(),
        options = listOf(
            "3",
            "5",
            "4",
            "1"
        ),
        answerIndex = 2,
        explanation = "`range(4)` produces 0, 1, 2, and 3."
    ),
    Problem(
        id = "order_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Build a Full Name",
        summary = "Arrange the lines to join two strings and print the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "last = \"Lee\"",
            "print(full_name)",
            "full_name = first + \" \" + last",
            "first = \"Sam\""
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 0, 2, 1),
        explanation = "Set `first`, set `last`, build `full_name`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Scores",
        summary = "The loop visits each item in the list once.",
        prompt = "How many times does `print(score)` run?",
        code = """
            for score in [70, 80, 90]:
                print(score)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "3 times",
            "2 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "The list has 3 items, so the loop runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `coins`",
        summary = "The variable changes twice before the end.",
        prompt = "What is the value of `coins` at the end?",
        code = """
            coins = 5
            coins = coins + 2
            coins = coins - 1
        """.trimIndent(),
        options = listOf(
            "6",
            "5",
            "8",
            "7"
        ),
        answerIndex = 0,
        explanation = "Start at 5, add 2 to get 7, then subtract 1 to get 6."
    ),
    Problem(
        id = "match_easy_student_57",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `bye`",
        summary = "Choose the snippet that prints the exact word.",
        prompt = "Which code produces `bye`?",
        code = "",
        options = listOf(
            "print(\"BYE\")",
            "print(\"bye\" + \"!\")",
            "print(\"bye\")",
            "print(\"by\")"
        ),
        answerIndex = 2,
        explanation = "Only `print(\"bye\")` prints exactly `bye`."
    )
)
