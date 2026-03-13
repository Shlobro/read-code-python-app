package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents68 = listOf(
    Problem(
        id = "bug_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Total Never Grows",
        summary = "A loop tries to add values into a running total.",
        prompt = "What is the real bug in this code?",
        code = """
            total = 0
            for value in [1, 2, 3]:
                total + value
            print(total)
        """.trimIndent(),
        options = listOf(
            "The loop needs `range(3)`.",
            "The sum is never stored.",
            "`print(total)` is misplaced.",
            "`total` should start at 1."
        ),
        answerIndex = 1,
        explanation = "`total + value` computes a result, but it does not assign it back to `total`."
    ),
    Problem(
        id = "output_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Check the Limit",
        summary = "A small condition compares one number to a boundary.",
        prompt = "What does this code print?",
        code = """
            score = 8
            if score >= 8:
                print("pass")
            else:
                print("retry")
        """.trimIndent(),
        options = listOf(
            "pass",
            "8",
            "retry",
            "Nothing"
        ),
        answerIndex = 0,
        explanation = "Because `score` is 8, the condition `score >= 8` is true and `pass` is printed."
    ),
    Problem(
        id = "purpose_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Long Words",
        summary = "The loop increases a counter when a word has more than three letters.",
        prompt = "What does this code do overall?",
        code = """
            words = ["sun", "planet", "book", "pen"]
            count = 0
            for word in words:
                if len(word) > 3:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "It sorts the words by size.",
            "It joins the words together.",
            "It counts words longer than 3 letters.",
            "It removes short words from the list."
        ),
        answerIndex = 2,
        explanation = "The counter increases only for words whose length is greater than 3."
    ),
    Problem(
        id = "fill_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Measure the List",
        summary = "One built-in function is missing from the print statement.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            items = ["pen", "book", "bag"]
            print(__(items))
        """.trimIndent(),
        options = listOf(
            "sum",
            "list",
            "len",
            "count"
        ),
        answerIndex = 2,
        explanation = "`len(items)` returns the number of elements in the list."
    ),
    Problem(
        id = "order_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Store and Print a Sum",
        summary = "Arrange the lines to add two numbers and print the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(total)",
            "b = 5",
            "a = 2",
            "total = a + b"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 3, 0),
        explanation = "The variables must be created before `total = a + b`, and `print(total)` comes last."
    ),
    Problem(
        id = "complexity_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple Loop Count",
        summary = "A single loop prints the same word once per iteration.",
        prompt = "How many times does `print(\"go\")` run?",
        code = """
            for i in range(4):
                print("go")
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "5 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "`range(4)` produces 4 loop iterations, so the print runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `points`",
        summary = "The variable changes through one assignment and one update.",
        prompt = "What is the value of `points` after the code finishes?",
        code = """
            points = 3
            points = points + 4
            points = points - 2
        """.trimIndent(),
        options = listOf(
            "3",
            "9",
            "5",
            "7"
        ),
        answerIndex = 2,
        explanation = "The value goes from 3 to 7, then from 7 to 5."
    ),
    Problem(
        id = "match_easy_student_68",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `6`",
        summary = "Choose the code that prints the sum of 2 and 4.",
        prompt = "Which code produces `6`?",
        code = "",
        options = listOf(
            "a = 2\nb = 4\nprint(a * b)",
            "a = 2\nb = 4\nprint(a - b)",
            "a = 2\nb = 4\nprint(str(a) + str(b))",
            "a = 2\nb = 4\nprint(a + b)"
        ),
        answerIndex = 3,
        explanation = "Adding 2 and 4 with `a + b` prints `6`."
    )
)
