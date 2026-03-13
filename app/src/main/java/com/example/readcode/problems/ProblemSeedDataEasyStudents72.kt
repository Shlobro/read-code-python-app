package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents72 = listOf(
    Problem(
        id = "bug_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Name Before Assignment",
        summary = "The code tries to use a variable too early.",
        prompt = "What is the actual bug in this program?",
        code = """
            total = number + 2
            number = 5
            print(total)
        """.trimIndent(),
        options = listOf(
            "`print(total)` should be above both lines.",
            "`number` is used before it gets a value.",
            "The `+` should be `*`.",
            "`total` should be a list."
        ),
        answerIndex = 1,
        explanation = "`number` must be assigned before Python can use it in `number + 2`."
    ),
    Problem(
        id = "output_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Update a Counter",
        summary = "A variable changes inside a short loop.",
        prompt = "What does this code print?",
        code = """
            count = 2
            for i in range(2):
                count += 3
            print(count)
        """.trimIndent(),
        options = listOf(
            "5",
            "6",
            "8",
            "7"
        ),
        answerIndex = 2,
        explanation = "The loop runs twice, so 3 is added two times: 2 -> 5 -> 8."
    ),
    Problem(
        id = "purpose_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Build a Small Countdown",
        summary = "A loop prints values while a number decreases.",
        prompt = "What does this code do overall?",
        code = """
            n = 3
            while n > 0:
                print(n)
                n -= 1
        """.trimIndent(),
        options = listOf(
            "It prints 3, 2, 1.",
            "It adds numbers from 1 to 3.",
            "It prints only even numbers.",
            "It stores values in a list."
        ),
        answerIndex = 0,
        explanation = "The code prints the current value of `n` and then decreases it until `n` is no longer greater than 0."
    ),
    Problem(
        id = "fill_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Get a List Length",
        summary = "A built-in function is missing.",
        prompt = "Which choice fills the blank so the code prints `4`?",
        code = """
            values = [10, 20, 30, 40]
            print(__(values))
        """.trimIndent(),
        options = listOf(
            "size",
            "count",
            "len",
            "sum"
        ),
        answerIndex = 2,
        explanation = "`len(values)` returns the number of items in the list, which is 4."
    ),
    Problem(
        id = "order_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Check If a Number Is Big",
        summary = "Arrange the lines into a working `if` statement.",
        prompt = "Arrange these lines into the correct order.",
        code = "",
        options = listOf(
            "if score > 10:",
            "score = 12",
            "    print(\"big\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 0, 2),
        explanation = "Assign `score` first, then write the `if` line, then the indented print."
    ),
    Problem(
        id = "complexity_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Iterations",
        summary = "Count how many times the loop body runs.",
        prompt = "How many times does `total += 1` execute?",
        code = """
            total = 0
            for i in range(4):
                total += 1
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "5 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "`range(4)` gives four values: 0, 1, 2, and 3."
    ),
    Problem(
        id = "trace_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `result`",
        summary = "The variable is updated by two statements.",
        prompt = "What is the value of `result` after line 3?",
        code = """
            result = 4      # line 1
            result += 1     # line 2
            result = result * 2  # line 3
        """.trimIndent(),
        options = listOf(
            "8",
            "10",
            "5",
            "6"
        ),
        answerIndex = 1,
        explanation = "After line 2, `result` is 5. After line 3, it becomes 10."
    ),
    Problem(
        id = "match_easy_student_72",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `9`",
        summary = "Choose the code that prints the exact value `9`.",
        prompt = "Which code produces `9`?",
        code = "",
        options = listOf(
            "print(3 + 3)",
            "print(10 - 2)",
            "print(3 * 3)",
            "print(12 // 2)"
        ),
        answerIndex = 2,
        explanation = "Only `3 * 3` evaluates to 9."
    )
)
