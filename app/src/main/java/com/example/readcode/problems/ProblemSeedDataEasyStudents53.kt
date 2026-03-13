package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents53 = listOf(
    Problem(
        id = "bug_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong List Index",
        summary = "The code tries to read past the end of a short list.",
        prompt = "Why does this code crash?",
        code = """
            names = ["Ada", "Lin"]
            print(names[2])
        """.trimIndent(),
        options = listOf(
            "The list needs parentheses.",
            "Strings cannot be in a list.",
            "Index 2 is past the last item.",
            "The print line must be indented."
        ),
        answerIndex = 2,
        explanation = "A list with two items has valid indexes 0 and 1, so index 2 is out of range."
    ),
    Problem(
        id = "output_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add Then Print",
        summary = "A variable is updated once before it is shown.",
        prompt = "What does this code print?",
        code = """
            total = 4
            total = total + 3
            print(total)
        """.trimIndent(),
        options = listOf(
            "4",
            "7",
            "3",
            "43"
        ),
        answerIndex = 1,
        explanation = "The code starts at 4, adds 3, and prints 7."
    ),
    Problem(
        id = "purpose_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check for an A",
        summary = "A function looks for one letter inside a word.",
        prompt = "What does this function do?",
        code = """
            def has_a(word):
                return "a" in word
        """.trimIndent(),
        options = listOf(
            "It changes the word to uppercase.",
            "It counts every letter in the word.",
            "It checks whether the word contains `a`.",
            "It removes `a` from the word."
        ),
        answerIndex = 2,
        explanation = "The `in` operator returns `True` when `a` appears in the string."
    ),
    Problem(
        id = "fill_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Make a List",
        summary = "A pair of symbols is missing from a list literal.",
        prompt = "Fill in the blank so `nums` becomes a list with 1 and 2.",
        code = """
            nums = __
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "(1, 2)",
            "{1: 2}",
            "\"1, 2\""
        ),
        answerIndex = 0,
        explanation = "Square brackets create a list literal in Python."
    ),
    Problem(
        id = "order_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Build and Print a Name",
        summary = "Arrange the lines to store a name and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(name)",
            "name = first + last",
            "first = \"Al\"",
            "last = \"ex\""
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 1, 0),
        explanation = "Set `first` and `last`, combine them into `name`, and then print the result."
    ),
    Problem(
        id = "complexity_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Loop Turns",
        summary = "A small `range` controls how often the loop body runs.",
        prompt = "How many times does `print(i)` run?",
        code = """
            for i in range(3):
                print(i)
        """.trimIndent(),
        options = listOf(
            "2 times",
            "4 times",
            "0 times",
            "3 times"
        ),
        answerIndex = 3,
        explanation = "`range(3)` gives 0, 1, and 2, so the loop body runs three times."
    ),
    Problem(
        id = "trace_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `points`",
        summary = "One variable is updated step by step.",
        prompt = "What is the final value of `points`?",
        code = """
            points = 1
            points = points + 2
            points = points * 3
        """.trimIndent(),
        options = listOf(
            "9",
            "3",
            "6",
            "5"
        ),
        answerIndex = 0,
        explanation = "Start at 1, add 2 to get 3, then multiply by 3 to get 9."
    ),
    Problem(
        id = "match_easy_student_53",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `blue`",
        summary = "Choose the snippet that prints one exact word.",
        prompt = "Which code produces the output `blue`?",
        code = "",
        options = listOf(
            "color = \"blue\"\nprint(color + \"!\")",
            "color = \"Blue\"\nprint(color)",
            "color = \"blue\"\nprint(color)",
            "color = \"blue\"\nprint(len(color))"
        ),
        answerIndex = 2,
        explanation = "Printing the variable directly outputs `blue` with the same lowercase spelling."
    )
)
