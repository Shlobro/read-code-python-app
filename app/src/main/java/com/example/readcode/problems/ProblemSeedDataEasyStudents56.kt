package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents56 = listOf(
    Problem(
        id = "bug_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Comparison Instead of Update",
        summary = "The total never changes inside the loop.",
        prompt = "What is the real bug in this code?",
        code = """
            total = 0
            for value in [2, 3, 4]:
                total == total + value
            print(total)
        """.trimIndent(),
        options = listOf(
            "`==` should be `=`.",
            "`total` should start at 1.",
            "`print(total)` should be inside the loop.",
            "`value` must be in quotes."
        ),
        answerIndex = 0,
        explanation = "`==` only compares values. The code needs assignment so `total` actually changes."
    ),
    Problem(
        id = "output_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Multiply Then Add",
        summary = "Follow the value of one variable through two steps.",
        prompt = "What does this code print?",
        code = """
            count = 1
            count = count * 2
            print(count + 1)
        """.trimIndent(),
        options = listOf(
            "2",
            "3",
            "4",
            "1"
        ),
        answerIndex = 1,
        explanation = "`count` becomes 2, and then `count + 1` prints 3."
    ),
    Problem(
        id = "purpose_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Even Check",
        summary = "The function uses the remainder operator.",
        prompt = "What does this function do?",
        code = """
            def is_even(n):
                return n % 2 == 0
        """.trimIndent(),
        options = listOf(
            "Adds 2 to a number.",
            "Rounds a number down.",
            "Checks if a number is even.",
            "Builds a list of even numbers."
        ),
        answerIndex = 2,
        explanation = "A number is even when dividing by 2 leaves a remainder of 0."
    ),
    Problem(
        id = "fill_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Lowercase Method",
        summary = "Pick the string method that changes capitals to lowercase.",
        prompt = "Fill in the blank so this prints `sam`.",
        code = """
            name = "Sam"
            print(name.___())
        """.trimIndent(),
        options = listOf(
            "upper",
            "title",
            "lower",
            "strip"
        ),
        answerIndex = 2,
        explanation = "`lower()` returns a lowercase version of the string."
    ),
    Problem(
        id = "order_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Square a Value",
        summary = "Arrange the lines to square a number and print the result.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "print(square)",
            "square = value * value",
            "print(\"done\")",
            "value = 5"
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 1, 0, 2),
        explanation = "Create `value`, compute `square`, print it, and then print `done`."
    ),
    Problem(
        id = "complexity_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Letters in a Word",
        summary = "A loop visits each character in a short string once.",
        prompt = "How many times does `print(letter)` run?",
        code = """
            for letter in "code":
                print(letter)
        """.trimIndent(),
        options = listOf(
            "3 times",
            "5 times",
            "4 times",
            "1 time"
        ),
        answerIndex = 2,
        explanation = "The string `code` has 4 characters, so the loop runs 4 times."
    ),
    Problem(
        id = "trace_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Growing `points`",
        summary = "The loop adds the same amount each time.",
        prompt = "What is the value of `points` at the end?",
        code = """
            points = 2
            for _ in range(3):
                points += 2
        """.trimIndent(),
        options = listOf(
            "6",
            "8",
            "5",
            "4"
        ),
        answerIndex = 1,
        explanation = "Start at 2 and add 2 three times, giving 8."
    ),
    Problem(
        id = "match_easy_student_56",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is 0, 1, 2",
        summary = "Choose the snippet that prints three lines in order.",
        prompt = "Which code produces this output?",
        code = """
            0
            1
            2
        """.trimIndent(),
        options = listOf(
            """
            for i in range(1, 4):
                print(i)
            """.trimIndent(),
            "print([0, 1, 2])",
            """
            for i in range(3):
                print(i + 1)
            """.trimIndent(),
            """
            for i in range(3):
                print(i)
            """.trimIndent()
        ),
        answerIndex = 3,
        explanation = "`range(3)` produces 0, 1, and 2, and each value is printed on its own line."
    )
)
