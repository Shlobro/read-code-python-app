package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents58 = listOf(
    Problem(
        id = "bug_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Update",
        summary = "The loop should count up, but one line is missing.",
        prompt = "What is the bug?",
        code = """
            count = 1
            while count <= 3:
                print(count)
        """.trimIndent(),
        options = listOf(
            "`count` never changes.",
            "`print` is in the wrong place.",
            "`while` cannot use `<=`.",
            "`count` should start at 0."
        ),
        answerIndex = 0,
        explanation = "Because `count` is never updated, the condition stays true and the loop never ends."
    ),
    Problem(
        id = "output_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Greeting Text",
        summary = "A variable is changed once before printing.",
        prompt = "What does this code print?",
        code = """
            word = "hi"
            word = word + "!"
            print(word)
        """.trimIndent(),
        options = listOf(
            "hi",
            "!",
            "hi!",
            "hihi"
        ),
        answerIndex = 2,
        explanation = "`word` becomes `hi!`, so that is what gets printed."
    ),
    Problem(
        id = "purpose_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "First Item",
        summary = "The function reads one value from a list.",
        prompt = "What does this function do?",
        code = """
            def get_first(items):
                return items[0]
        """.trimIndent(),
        options = listOf(
            "Gets the first item.",
            "Sorts the whole list.",
            "Counts all the items.",
            "Removes the last item."
        ),
        answerIndex = 0,
        explanation = "`items[0]` accesses and returns the first element."
    ),
    Problem(
        id = "fill_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Start at Zero",
        summary = "Pick the value that makes the condition true.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            score = 0
            if score ___ 0:
                print("start")
        """.trimIndent(),
        options = listOf(
            ">",
            "==",
            "<",
            "!="
        ),
        answerIndex = 1,
        explanation = "`score == 0` is true, so Python prints `start`."
    ),
    Problem(
        id = "order_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print Double",
        summary = "Arrange the lines to double a number and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(result)",
            "result = number * 2",
            "number = 4"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 0),
        explanation = "Set `number`, calculate `result`, then print the answer."
    ),
    Problem(
        id = "complexity_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Five Repeats",
        summary = "The loop uses a simple `range`.",
        prompt = "How many times does the loop run?",
        code = """
            for i in range(5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "6 times",
            "5 times",
            "1 time"
        ),
        answerIndex = 2,
        explanation = "`range(5)` produces 0, 1, 2, 3, and 4, so the loop runs 5 times."
    ),
    Problem(
        id = "trace_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `pages`",
        summary = "The variable increases and then increases again.",
        prompt = "What is the value of `pages` at the end?",
        code = """
            pages = 2
            pages = pages + 3
            pages = pages + 1
        """.trimIndent(),
        options = listOf(
            "5",
            "4",
            "6",
            "3"
        ),
        answerIndex = 2,
        explanation = "Start at 2, add 3 to get 5, then add 1 to get 6."
    ),
    Problem(
        id = "match_easy_student_58",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `8`",
        summary = "Choose the code that prints exactly 8.",
        prompt = "Which code produces `8`?",
        code = "",
        options = listOf(
            "print(4 + 4)",
            "print(\"eight\")",
            "print(2 * 3)",
            "print(8 - 1)"
        ),
        answerIndex = 0,
        explanation = "Only `print(4 + 4)` evaluates to the number 8."
    )
)
