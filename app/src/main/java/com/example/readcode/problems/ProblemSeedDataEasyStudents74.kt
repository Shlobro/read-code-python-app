package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents74 = listOf(
    Problem(
        id = "bug_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Undefined Variable",
        summary = "A variable is incremented before it has ever been assigned.",
        prompt = "What is the real bug in this code?",
        code = """
            total = 0
            for n in [1, 2, 3]:
                total += n
            count += 1
            print(total)
        """.trimIndent(),
        options = listOf(
            "`print(total)` should be removed.",
            "The list should start at 0.",
            "`count` was never created before it is used.",
            "The loop should use `range(4)`."
        ),
        answerIndex = 2,
        explanation = "The code uses `count += 1`, but no variable named `count` was assigned earlier."
    ),
    Problem(
        id = "output_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Add in a Loop",
        summary = "The loop adds the same amount twice.",
        prompt = "What does this code print?",
        code = """
            total = 1
            for i in range(2):
                total += 2
            print(total)
        """.trimIndent(),
        options = listOf(
            "2",
            "5",
            "4",
            "3"
        ),
        answerIndex = 1,
        explanation = "The loop adds 2 two times, so `total` changes from 1 to 3 to 5."
    ),
    Problem(
        id = "purpose_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Print Short Words",
        summary = "An `if` statement filters words by length.",
        prompt = "What does this code do overall?",
        code = """
            words = ["cat", "tree", "sun"]
            for word in words:
                if len(word) == 3:
                    print(word)
        """.trimIndent(),
        options = listOf(
            "It prints only 3-letter words.",
            "It prints the longest word.",
            "It joins all words together.",
            "It counts the letters in each word."
        ),
        answerIndex = 0,
        explanation = "Only words with length 3 pass the `if len(word) == 3` check."
    ),
    Problem(
        id = "fill_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Choose the List Function",
        summary = "Fill the blank to count how many items are in a list.",
        prompt = "Which choice fills the blank so the code prints `4`?",
        code = """
            values = [5, 6, 7, 8]
            print(__(values))
        """.trimIndent(),
        options = listOf(
            "sum",
            "size",
            "count",
            "len"
        ),
        answerIndex = 3,
        explanation = "`len(values)` returns the number of items in the list, which is 4."
    ),
    Problem(
        id = "order_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Create and Print a Total",
        summary = "Arrange the lines to add two numbers and print the result.",
        prompt = "Arrange these lines into the correct order.",
        code = "",
        options = listOf(
            "print(total)",
            "total = first + second",
            "first = 2",
            "second = 5"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 1, 0),
        explanation = "Set the two variables first, compute `total`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "How Many Prints?",
        summary = "Count the number of times the loop body runs.",
        prompt = "How many times does `print(i)` execute?",
        code = """
            for i in range(4):
                print(i)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "5 times",
            "2 times",
            "4 times"
        ),
        answerIndex = 3,
        explanation = "`range(4)` produces 0, 1, 2, and 3, so the loop runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Trace `score`",
        summary = "The variable changes once before the final print.",
        prompt = "What is the value of `score` when `print(score)` runs?",
        code = """
            score = 10
            score = score - 3
            print(score)
        """.trimIndent(),
        options = listOf(
            "13",
            "10",
            "7",
            "3"
        ),
        answerIndex = 2,
        explanation = "The code subtracts 3 from 10, so `score` becomes 7."
    ),
    Problem(
        id = "match_easy_student_74",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `yes`",
        summary = "Choose the code that prints the exact text `yes`.",
        prompt = "Which code produces `yes`?",
        code = "",
        options = listOf(
            "print(\"YES\")",
            "print(\"yes!\")",
            "print(\"yes\")",
            "print(\"no\")"
        ),
        answerIndex = 2,
        explanation = "Only `print(\"yes\")` matches the required output exactly."
    )
)
