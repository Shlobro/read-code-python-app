package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents73 = listOf(
    Problem(
        id = "bug_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indent After `for`",
        summary = "A loop body is not indented.",
        prompt = "What is the actual bug in this program?",
        code = """
            for n in range(3):
            print(n)
        """.trimIndent(),
        options = listOf(
            "The loop needs a larger range.",
            "The `print` line needs indentation.",
            "`n` should start at 1.",
            "The colon should be removed."
        ),
        answerIndex = 1,
        explanation = "Python requires the loop body to be indented under the `for` statement."
    ),
    Problem(
        id = "output_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Print",
        summary = "A variable is updated once before printing.",
        prompt = "What does this code print?",
        code = """
            total = 7
            total = total + 2
            print(total)
        """.trimIndent(),
        options = listOf(
            "7",
            "9",
            "5",
            "14"
        ),
        answerIndex = 1,
        explanation = "The code adds 2 to 7, so `total` becomes 9."
    ),
    Problem(
        id = "purpose_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count List Items",
        summary = "A loop increases a counter once per element.",
        prompt = "What does this code do overall?",
        code = """
            names = ["Ana", "Bo", "Chen"]
            count = 0
            for name in names:
                count += 1
            print(count)
        """.trimIndent(),
        options = listOf(
            "It prints the last name.",
            "It counts the names.",
            "It joins the names into one string.",
            "It sorts the names."
        ),
        answerIndex = 1,
        explanation = "The loop adds 1 for each item in `names`, so it prints the number of items."
    ),
    Problem(
        id = "fill_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Choose the Comparison",
        summary = "Fill the blank to test whether two values match.",
        prompt = "Which choice fills the blank so the code prints `same`?",
        code = """
            score = 4
            if score __ 4:
                print("same")
        """.trimIndent(),
        options = listOf(
            ">",
            "=",
            "==",
            "!="
        ),
        answerIndex = 2,
        explanation = "`==` checks whether two values are equal."
    ),
    Problem(
        id = "order_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print a Doubled Value",
        summary = "Arrange the lines into a small working program.",
        prompt = "Arrange these lines into the correct order.",
        code = "",
        options = listOf(
            "    print(number * 2)",
            "number = 6",
            "if number > 3:"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0),
        explanation = "Assign `number`, check the condition, then print the doubled value inside the `if` block."
    ),
    Problem(
        id = "complexity_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Nested Loop Count",
        summary = "Count how often a print statement runs.",
        prompt = "How many times does `print(\"hi\")` execute?",
        code = """
            for i in range(2):
                for j in range(3):
                    print("hi")
        """.trimIndent(),
        options = listOf(
            "6 times",
            "5 times",
            "3 times",
            "2 times"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs 2 times and the inner loop runs 3 times each round, so 2 x 3 = 6."
    ),
    Problem(
        id = "trace_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `value` in a Loop",
        summary = "The variable changes by the same amount twice.",
        prompt = "What is the value of `value` after the loop ends?",
        code = """
            value = 1
            for i in range(2):
                value += 4
        """.trimIndent(),
        options = listOf(
            "5",
            "9",
            "8",
            "6"
        ),
        answerIndex = 1,
        explanation = "Starting at 1, the loop adds 4 two times: 1 -> 5 -> 9."
    ),
    Problem(
        id = "match_easy_student_73",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints the exact value `4`.",
        prompt = "Which code produces `4`?",
        code = "",
        options = listOf(
            "print(2 + 1)",
            "print(8 // 2)",
            "print(2 * 3)",
            "print(5 - 2)"
        ),
        answerIndex = 1,
        explanation = "Only `8 // 2` evaluates to 4."
    )
)
