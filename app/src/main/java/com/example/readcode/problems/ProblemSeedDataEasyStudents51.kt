package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents51 = listOf(
    Problem(
        id = "bug_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Update",
        summary = "A loop is meant to count upward.",
        prompt = "Why does this loop never end?",
        code = """
            count = 1
            while count < 4:
                print(count)
        """.trimIndent(),
        options = listOf(
            "The condition should use `<=`.",
            "`print(count)` should be outside the loop.",
            "`count` never changes inside the loop.",
            "The variable must start at 0."
        ),
        answerIndex = 2,
        explanation = "The condition stays true because `count` is never updated inside the loop."
    ),
    Problem(
        id = "output_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Repeat Text",
        summary = "A short string is repeated.",
        prompt = "What does this code print?",
        code = """
            message = "go"
            print(message * 2)
        """.trimIndent(),
        options = listOf(
            "gogo",
            "go2",
            "go go",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by 2 repeats it twice, so the result is `gogo`."
    ),
    Problem(
        id = "purpose_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count Names",
        summary = "A function returns the size of a list.",
        prompt = "What does this function do?",
        code = """
            def count_names(names):
                return len(names)
        """.trimIndent(),
        options = listOf(
            "It prints each name in the list.",
            "It returns how many names are in the list.",
            "It sorts the names alphabetically.",
            "It removes empty names from the list."
        ),
        answerIndex = 1,
        explanation = "`len(names)` gives the number of items in the list."
    ),
    Problem(
        id = "fill_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Start a Loop",
        summary = "A keyword is missing from a simple loop.",
        prompt = "Fill in the blank so the code prints each number.",
        code = """
            numbers = [1, 2, 3]
            ___ n in numbers:
                print(n)
        """.trimIndent(),
        options = listOf(
            "if",
            "for",
            "def",
            "while"
        ),
        answerIndex = 1,
        explanation = "A `for` loop is used to go through each item in a list."
    ),
    Problem(
        id = "order_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make and Print a Total",
        summary = "Arrange the lines to add two numbers.",
        prompt = "Arrange these lines to store the sum and print it.",
        code = "",
        options = listOf(
            "print(total)",
            "a = 2",
            "total = a + b",
            "b = 5"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 3, 2, 0),
        explanation = "Set `a` and `b` first, then calculate `total`, then print it."
    ),
    Problem(
        id = "complexity_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Four Items",
        summary = "Count how often the loop body runs.",
        prompt = "How many times does `print(letter)` run?",
        code = """
            letters = ["a", "b", "c", "d"]
            for letter in letters:
                print(letter)
        """.trimIndent(),
        options = listOf(
            "2 times",
            "3 times",
            "4 times",
            "5 times"
        ),
        answerIndex = 2,
        explanation = "The list has four items, so the loop body runs four times."
    ),
    Problem(
        id = "trace_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track Score",
        summary = "A variable changes twice.",
        prompt = "What is the final value of `score`?",
        code = """
            score = 10
            score = score - 4
            score = score + 1
        """.trimIndent(),
        options = listOf(
            "5",
            "6",
            "7",
            "11"
        ),
        answerIndex = 2,
        explanation = "Start at 10, subtract 4 to get 6, then add 1 to get 7."
    ),
    Problem(
        id = "match_easy_student_51",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `cat`",
        summary = "Choose the code that prints one word.",
        prompt = "Which code produces the output `cat`?",
        code = "",
        options = listOf(
            "word = \"cat\"\nprint(word)",
            "word = \"cat\"\nprint(word.upper())",
            "word = \"cat\"\nprint(word + \"!\")",
            "word = \"ca\"\nprint(word)"
        ),
        answerIndex = 0,
        explanation = "Printing the variable `word` directly outputs `cat`."
    )
)
