package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents50 = listOf(
    Problem(
        id = "bug_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Number and Text",
        summary = "A string is joined with a number.",
        prompt = "Why does this code fail?",
        code = """
            age = 20
            print("Age: " + age)
        """.trimIndent(),
        options = listOf(
            "The string uses double quotes instead of single quotes.",
            "The `print` function cannot show values stored in variables.",
            "Python cannot add a string and an integer without converting one of them.",
            "The variable name `age` is reserved and cannot be used here."
        ),
        answerIndex = 2,
        explanation = "The code tries to concatenate a string with an integer. Convert `age` to a string or print the values separately."
    ),
    Problem(
        id = "output_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Second Item",
        summary = "Reading one value from a list.",
        prompt = "What does this code print?",
        code = """
            values = [10, 20, 30]
            print(values[1])
        """.trimIndent(),
        options = listOf(
            "20",
            "10",
            "30",
            "It raises an error."
        ),
        answerIndex = 0,
        explanation = "List indexes start at 0, so index `1` refers to the second item, which is `20`."
    ),
    Problem(
        id = "purpose_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Passing Scores",
        summary = "A loop tracks how many values meet a rule.",
        prompt = "What does this function do?",
        code = """
            def count_passes(scores):
                total = 0
                for score in scores:
                    if score >= 50:
                        total += 1
                return total
        """.trimIndent(),
        options = listOf(
            "It adds all the scores together.",
            "It counts how many scores are 50 or higher.",
            "It returns the highest score in the list.",
            "It changes failing scores into passing scores."
        ),
        answerIndex = 1,
        explanation = "The loop increases `total` once for each score that is at least 50, then returns that count."
    ),
    Problem(
        id = "fill_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Length Function",
        summary = "Getting the size of a list.",
        prompt = "Fill in the blank so the code prints `3`.",
        code = """
            items = ["pen", "book", "bag"]
            print(____(items))
        """.trimIndent(),
        options = listOf(
            "size",
            "count",
            "list",
            "len"
        ),
        answerIndex = 3,
        explanation = "`len(items)` returns the number of items in the list, which is 3."
    ),
    Problem(
        id = "order_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Print Each Color",
        summary = "Build a simple loop in the right order.",
        prompt = "Arrange these lines to print each color in the list.",
        code = "",
        options = listOf(
            "colors = [\"red\", \"blue\"]",
            "for color in colors:",
            "    print(color)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First create the list, then start the loop, then print each item inside the loop."
    ),
    Problem(
        id = "complexity_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Three Repeats",
        summary = "Count loop executions.",
        prompt = "How many times does `print(name)` run?",
        code = """
            names = ["Ava", "Ben", "Chen"]
            for name in names:
                print(name)
        """.trimIndent(),
        options = listOf(
            "1 time",
            "2 times",
            "3 times",
            "4 times"
        ),
        answerIndex = 2,
        explanation = "The list has three items, so the loop body runs three times."
    ),
    Problem(
        id = "trace_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Points Total",
        summary = "Follow a variable through a few updates.",
        prompt = "What is the final value of `points`?",
        code = """
            points = 4
            points = points + 3
            points = points - 2
        """.trimIndent(),
        options = listOf(
            "4",
            "5",
            "6",
            "7"
        ),
        answerIndex = 1,
        explanation = "Start at 4, add 3 to get 7, then subtract 2 to get 5."
    ),
    Problem(
        id = "match_easy_student_50",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `6`",
        summary = "Choose the code that prints one value.",
        prompt = "Which code produces the output `6`?",
        code = "",
        options = listOf(
            "x = 2\nprint(x)",
            "x = 3\nprint(x + 1)",
            "x = 6\nprint(x - 1)",
            "x = 3\nprint(x * 2)"
        ),
        answerIndex = 3,
        explanation = "`x * 2` evaluates to `6` when `x` is `3`."
    )
)
