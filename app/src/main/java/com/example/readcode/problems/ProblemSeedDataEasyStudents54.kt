package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents54 = listOf(
    Problem(
        id = "bug_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "String Plus Number",
        summary = "The code tries to join text and a number directly.",
        prompt = "Why does this code fail?",
        code = """
            age = 20
            print("Age: " + age)
        """.trimIndent(),
        options = listOf(
            "The string should use single quotes and a different print format.",
            "Python cannot add a string and an integer directly.",
            "The print call needs a colon after it.",
            "Variables cannot be named `age`."
        ),
        answerIndex = 1,
        explanation = "The `+` operator cannot directly combine a string with an integer. Convert the number first or print them separately."
    ),
    Problem(
        id = "output_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Multiply After Add",
        summary = "A number changes twice before it is printed.",
        prompt = "What does this code print?",
        code = """
            score = 2
            score = score + 1
            score = score * 2
            print(score)
        """.trimIndent(),
        options = listOf(
            "6",
            "4",
            "3",
            "8"
        ),
        answerIndex = 0,
        explanation = "Start with 2, add 1 to get 3, then multiply by 2 to get 6."
    ),
    Problem(
        id = "purpose_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "First Item",
        summary = "A function returns one part of a list.",
        prompt = "What does this function do?",
        code = """
            def first_number(nums):
                return nums[0]
        """.trimIndent(),
        options = listOf(
            "It returns the first item in the list.",
            "It sorts the list from smallest to largest.",
            "It counts how many items are in the list.",
            "It removes the first item from the list."
        ),
        answerIndex = 0,
        explanation = "Index `0` means the first element in a Python list."
    ),
    Problem(
        id = "fill_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Print a Variable",
        summary = "Use a built-in function to show a value.",
        prompt = "Fill in the blank so the code displays the value of `name`.",
        code = """
            name = "Mia"
            __(name)
        """.trimIndent(),
        options = listOf(
            "show",
            "print",
            "echo",
            "write"
        ),
        answerIndex = 1,
        explanation = "The `print` function displays a value on the screen in Python."
    ),
    Problem(
        id = "order_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Count Apples",
        summary = "Arrange the lines to store a number and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(apples)",
            "apples = apples + 1",
            "apples = 2",
            "print(\"done\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 0, 3),
        explanation = "Set `apples` first, update it, print the value, and then print `done`."
    ),
    Problem(
        id = "complexity_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop of Four",
        summary = "A `range` decides how many loop turns happen.",
        prompt = "How many times does `print(\"hi\")` run?",
        code = """
            for _ in range(4):
                print("hi")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "3 times",
            "1 time"
        ),
        answerIndex = 1,
        explanation = "`range(4)` gives four values, so the loop body runs four times."
    ),
    Problem(
        id = "trace_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track `money`",
        summary = "The same variable is updated with simple arithmetic.",
        prompt = "What is the final value of `money`?",
        code = """
            money = 10
            money = money - 4
            money = money + 1
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
        id = "match_easy_student_54",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `cat`",
        summary = "Choose the code that prints one lowercase word.",
        prompt = "Which code produces the output `cat`?",
        code = "",
        options = listOf(
            "word = \"cat\"\nprint(word)",
            "word = \"Cat\"\nprint(word)",
            "word = \"cat\"\nprint(word + \"!\")",
            "word = \"cat\"\nprint(len(word))"
        ),
        answerIndex = 0,
        explanation = "Printing the string variable directly gives exactly `cat`."
    )
)
