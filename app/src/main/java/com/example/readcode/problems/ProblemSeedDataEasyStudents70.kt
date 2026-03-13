package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents70 = listOf(
    Problem(
        id = "bug_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Total Is Replaced",
        summary = "The code should add all values in the list.",
        prompt = "What is the real bug in this code?",
        code = """
            total = 0
            for number in [1, 2, 3]:
                total = number
            print(total)
        """.trimIndent(),
        options = listOf(
            "The list should start with 0.",
            "It replaces `total` instead of adding.",
            "`print(total)` must be in the loop.",
            "The loop needs `range()`."
        ),
        answerIndex = 1,
        explanation = "Each loop pass overwrites `total` with the current number, so the code never builds a running sum."
    ),
    Problem(
        id = "output_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Subtract Then Double",
        summary = "One variable changes through two arithmetic steps.",
        prompt = "What does this code print?",
        code = """
            count = 4
            count -= 1
            count *= 2
            print(count)
        """.trimIndent(),
        options = listOf(
            "4",
            "8",
            "5",
            "6"
        ),
        answerIndex = 3,
        explanation = "The value goes from 4 to 3, then from 3 to 6."
    ),
    Problem(
        id = "purpose_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Keep Two-Letter Names",
        summary = "A loop adds only some names to a new list.",
        prompt = "What does this code do overall?",
        code = """
            names = ["Ana", "Bo", "Cy"]
            short_names = []
            for name in names:
                if len(name) == 2:
                    short_names.append(name)
        """.trimIndent(),
        options = listOf(
            "It joins all the names into one string.",
            "It sorts the names by length.",
            "It keeps names with 2 letters.",
            "It changes each name to uppercase."
        ),
        answerIndex = 2,
        explanation = "Only names whose length is 2 are appended to `short_names`."
    ),
    Problem(
        id = "fill_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Count List Items",
        summary = "A built-in function is missing from the print call.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            numbers = [10, 20, 30]
            print(__(numbers))
        """.trimIndent(),
        options = listOf(
            "sum",
            "len",
            "list",
            "max"
        ),
        answerIndex = 1,
        explanation = "`len(numbers)` returns how many items are in the list, which is 3."
    ),
    Problem(
        id = "order_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print When Number Is Big",
        summary = "Arrange the lines to check a number and print a message.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "    print(\"big\")",
            "number = 5",
            "if number > 3:"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0),
        explanation = "Store the number first, then check the condition, then print inside the `if` block."
    ),
    Problem(
        id = "complexity_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Plus One More Print",
        summary = "A loop prints several times, and one extra print runs after it.",
        prompt = "How many times does `print(...)` run?",
        code = """
            for i in range(4):
                print(i)
            print("done")
        """.trimIndent(),
        options = listOf(
            "4 times",
            "5 times",
            "8 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "The loop prints 4 times, and the final line prints once more, for 5 total prints."
    ),
    Problem(
        id = "trace_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `points`",
        summary = "The variable changes with subtraction, addition, and floor division.",
        prompt = "What is the value of `points` after the code finishes?",
        code = """
            points = 10
            points -= 3
            points += 5
            points = points // 2
        """.trimIndent(),
        options = listOf(
            "5",
            "6",
            "7",
            "4"
        ),
        answerIndex = 1,
        explanation = "The value becomes 7, then 12, and finally `12 // 2`, which is 6."
    ),
    Problem(
        id = "match_easy_student_70",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints the number 4.",
        prompt = "Which code produces `4`?",
        code = "",
        options = listOf(
            "print(2 + 2)",
            "print(2 * 3)",
            "print(8 // 3)",
            "print(5 - 2)"
        ),
        answerIndex = 0,
        explanation = "`2 + 2` evaluates to 4, so that snippet prints the required output."
    )
)
