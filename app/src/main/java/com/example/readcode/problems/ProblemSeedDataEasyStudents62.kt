package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents62 = listOf(
    Problem(
        id = "bug_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Total Gets Reset",
        summary = "A running total should grow, but one line wipes it out each loop.",
        prompt = "What is the real bug?",
        code = """
            total = 0
            for mark in [4, 5, 6]:
                total = 0
                total += mark
            print(total)
        """.trimIndent(),
        options = listOf(
            "The list should be sorted first.",
            "`total = 0` is inside the loop.",
            "`print(total)` must come first.",
            "The variable should be named `sum`."
        ),
        answerIndex = 1,
        explanation = "Resetting `total` inside the loop means earlier additions are lost on every pass."
    ),
    Problem(
        id = "output_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Step-by-Step Increase",
        summary = "A number is updated in a short loop before being printed.",
        prompt = "What does this code print?",
        code = """
            count = 1
            for _ in range(3):
                count += 2
            print(count)
        """.trimIndent(),
        options = listOf(
            "5",
            "8",
            "6",
            "7"
        ),
        answerIndex = 3,
        explanation = "The loop adds 2 three times, so the value changes from 1 to 3, 5, and then 7."
    ),
    Problem(
        id = "purpose_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Collect Long Words",
        summary = "The loop builds a new list using a simple length check.",
        prompt = "What does this code do overall?",
        code = """
            words = ["hi", "book", "sun", "plane"]
            long_words = []
            for word in words:
                if len(word) > 3:
                    long_words.append(word)
        """.trimIndent(),
        options = listOf(
            "It keeps words with more than 3 letters.",
            "It joins all the words into one string.",
            "It puts the words in alphabetical order.",
            "It counts how many vowels appear in each word."
        ),
        answerIndex = 0,
        explanation = "Only words whose length is greater than 3 are appended to `long_words`."
    ),
    Problem(
        id = "fill_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Get the List Size",
        summary = "Use the built-in function that returns how many items are in a list.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            scores = [7, 8, 9, 10]
            print(__(scores))
        """.trimIndent(),
        options = listOf(
            "count",
            "size",
            "len",
            "sum"
        ),
        answerIndex = 2,
        explanation = "`len(scores)` returns the number of items in the list, which is 4."
    ),
    Problem(
        id = "order_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Store Then Print Name",
        summary = "Arrange the lines to save a name and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "name = \"Mia\"",
            "print(name)",
            "greeting = \"Hello\"",
            "print(greeting)"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 3, 1),
        explanation = "Create both variables first, then print the greeting and the name."
    ),
    Problem(
        id = "complexity_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Over Four Items",
        summary = "Count how many times the loop body runs for a fixed-size list.",
        prompt = "How many times does the loop run?",
        code = """
            colors = ["red", "blue", "green", "gold"]
            for color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "5 times",
            "4 times",
            "1 time"
        ),
        answerIndex = 2,
        explanation = "The loop runs once for each item in `colors`, and the list has 4 items."
    ),
    Problem(
        id = "trace_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `points`",
        summary = "A variable changes in two simple steps.",
        prompt = "What is the value of `points` at the end?",
        code = """
            points = 10
            points = points - 3
            points = points + 5
        """.trimIndent(),
        options = listOf(
            "15",
            "8",
            "12",
            "13"
        ),
        answerIndex = 2,
        explanation = "Start at 10, subtract 3 to get 7, then add 5 to get 12."
    ),
    Problem(
        id = "match_easy_student_62",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `blue`",
        summary = "Choose the code that prints the second item from a list.",
        prompt = "Which code produces `blue`?",
        code = "",
        options = listOf(
            "colors = [\"red\", \"blue\", \"green\"]\nprint(colors[0])",
            "colors = [\"red\", \"blue\", \"green\"]\nprint(colors[1])",
            "colors = [\"red\", \"blue\", \"green\"]\nprint(len(colors))",
            "colors = [\"red\", \"blue\", \"green\"]\nprint(colors[2])"
        ),
        answerIndex = 1,
        explanation = "List index 1 refers to the second item, which is `blue`."
    )
)
