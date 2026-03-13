package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents66 = listOf(
    Problem(
        id = "bug_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Update",
        summary = "A loop checks a limit, but the tracked value never changes.",
        prompt = "What is the bug in this code?",
        code = """
            count = 0
            while count < 3:
                print(count)
        """.trimIndent(),
        options = listOf(
            "`print` should be outside the loop.",
            "`count` is never increased.",
            "The loop needs `range(3)`.",
            "`count` should start at 1."
        ),
        answerIndex = 1,
        explanation = "Because `count` never changes, `count < 3` stays true and the loop never ends."
    ),
    Problem(
        id = "output_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Subtract Then Add",
        summary = "A number changes twice before being printed.",
        prompt = "What does this code print?",
        code = """
            total = 10
            total = total - 4
            total = total + 1
            print(total)
        """.trimIndent(),
        options = listOf(
            "10",
            "5",
            "7",
            "6"
        ),
        answerIndex = 2,
        explanation = "The value goes from 10 to 6, then from 6 to 7, so it prints 7."
    ),
    Problem(
        id = "purpose_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Short Words",
        summary = "The loop adds one for each word with fewer than five letters.",
        prompt = "What does this code do overall?",
        code = """
            words = ["cat", "apple", "book", "sun"]
            total = 0
            for word in words:
                if len(word) < 5:
                    total += 1
            print(total)
        """.trimIndent(),
        options = listOf(
            "It counts short words.",
            "It prints every word in order.",
            "It finds the longest word.",
            "It joins the words together."
        ),
        answerIndex = 0,
        explanation = "The code increases `total` only when a word has length 4 or less."
    ),
    Problem(
        id = "fill_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Use the Length",
        summary = "Fill in the built-in function that counts list items.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            names = ["Ava", "Leo", "Ivy"]
            print(____(names))
        """.trimIndent(),
        options = listOf(
            "size",
            "count",
            "len",
            "sum"
        ),
        answerIndex = 2,
        explanation = "`len(names)` returns the number of items in the list."
    ),
    Problem(
        id = "order_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Store and Print a Total",
        summary = "Arrange the lines so the program adds two values and prints the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "total = a + b",
            "print(total)",
            "b = 5",
            "a = 2"
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 2, 0, 1),
        explanation = "Both variables must be assigned before the addition, and `total` must exist before it is printed."
    ),
    Problem(
        id = "complexity_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "How Many Iterations?",
        summary = "The loop runs once for each number produced by `range(4)`.",
        prompt = "How many times does the loop body run?",
        code = """
            for number in range(4):
                print(number)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "5 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "`range(4)` produces 0, 1, 2, and 3, so the loop runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `steps`",
        summary = "A variable is updated twice before the final print.",
        prompt = "What is the value of `steps` at the end?",
        code = """
            steps = 2
            steps = steps + 3
            steps = steps - 1
        """.trimIndent(),
        options = listOf(
            "2",
            "3",
            "6",
            "4"
        ),
        answerIndex = 3,
        explanation = "The value changes from 2 to 5, then from 5 to 4."
    ),
    Problem(
        id = "match_easy_student_66",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `9`",
        summary = "Choose the snippet that prints 9.",
        prompt = "Which code produces `9`?",
        code = "",
        options = listOf(
            "value = 4\nprint(value + 4)",
            "value = 3\nprint(value * 2)",
            "value = 3\nprint(value * 3)",
            "value = 10\nprint(value - 2)"
        ),
        answerIndex = 2,
        explanation = "Only `3 * 3` prints 9."
    )
)
