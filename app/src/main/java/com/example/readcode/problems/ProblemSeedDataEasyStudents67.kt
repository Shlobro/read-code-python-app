package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents67 = listOf(
    Problem(
        id = "bug_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Score Never Changes",
        summary = "A value is printed after a loop, but the update line uses the wrong operator.",
        prompt = "What is the real bug in this code?",
        code = """
            score = 0
            for point in [2, 3, 1]:
                score == score + point
            print(score)
        """.trimIndent(),
        options = listOf(
            "`print(score)` should be inside the loop.",
            "The list needs parentheses, not brackets.",
            "The update line should use `=`.",
            "`score` should start at 1 instead."
        ),
        answerIndex = 2,
        explanation = "`==` only compares values. The code needs `=` to store the new score each time."
    ),
    Problem(
        id = "output_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Double Then Subtract",
        summary = "One variable is updated in two simple arithmetic steps.",
        prompt = "What does this code print?",
        code = """
            value = 4
            value = value * 2
            value = value - 3
            print(value)
        """.trimIndent(),
        options = listOf(
            "8",
            "5",
            "3",
            "4"
        ),
        answerIndex = 1,
        explanation = "The value changes from 4 to 8, then from 8 to 5."
    ),
    Problem(
        id = "purpose_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Collect Big Numbers",
        summary = "The loop builds a new list from values that pass a condition.",
        prompt = "What does this code do overall?",
        code = """
            numbers = [1, 5, 2, 7]
            result = []
            for number in numbers:
                if number > 3:
                    result.append(number)
        """.trimIndent(),
        options = listOf(
            "It removes the last item.",
            "It adds 3 to each number.",
            "It keeps only values above 3.",
            "It sorts the numbers first."
        ),
        answerIndex = 2,
        explanation = "Only numbers larger than 3 are appended to `result`."
    ),
    Problem(
        id = "fill_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Add to a Total",
        summary = "Fill in the operator so the running total increases.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            total = 6
            total __ 4
            print(total)
        """.trimIndent(),
        options = listOf(
            "+=",
            "-=",
            "*=",
            "/="
        ),
        answerIndex = 0,
        explanation = "`+=` adds the value on the right and stores the result back into `total`."
    ),
    Problem(
        id = "order_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Show a List and First Item",
        summary = "Arrange the lines to create a list, print it, then print the first item again from a variable.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "colors = [\"red\", \"blue\"]",
            "first = colors[0]",
            "print(colors)",
            "print(first)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 2, 1, 3),
        explanation = "The list must be created first. After that, the program can print the whole list, store the first item in `first`, and print `first`."
    ),
    Problem(
        id = "complexity_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Nested Loop Count",
        summary = "A small nested loop repeats the inner print for each outer value.",
        prompt = "How many times does `print(\"hi\")` run?",
        code = """
            for i in range(2):
                for j in range(3):
                    print("hi")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "6 times",
            "3 times",
            "2 times"
        ),
        answerIndex = 1,
        explanation = "The inner loop runs 3 times for each of the 2 outer-loop iterations, so it prints 6 times."
    ),
    Problem(
        id = "trace_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `count`",
        summary = "The variable changes inside a loop with the same update each time.",
        prompt = "What is the value of `count` after the loop ends?",
        code = """
            count = 1
            for _ in range(3):
                count = count + 2
        """.trimIndent(),
        options = listOf(
            "5",
            "6",
            "7",
            "8"
        ),
        answerIndex = 2,
        explanation = "Starting at 1 and adding 2 three times gives 7."
    ),
    Problem(
        id = "match_easy_student_67",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `catcat`",
        summary = "Choose the code that repeats the same word twice.",
        prompt = "Which code produces `catcat`?",
        code = "",
        options = listOf(
            "word = \"cat\"\nprint(word + word)",
            "word = \"cat\"\nprint(word + \"dog\")",
            "word = \"cat\"\nprint(word * 3)",
            "word = \"cat\"\nprint(word.upper())"
        ),
        answerIndex = 0,
        explanation = "Concatenating `word + word` prints `catcat`."
    )
)
