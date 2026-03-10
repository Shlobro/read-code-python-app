package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents21 = listOf(
    Problem(
        id = "bug_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "A syntax error stops the code from running.",
        prompt = "What is wrong with this function definition?",
        code = """
            def say_hello()
                print("Hello")
        """.trimIndent(),
        options = listOf(
            "The `def` line is missing a colon `:` at the end",
            "`print` should be uppercase",
            "Functions must return a value",
            "The function name needs spaces"
        ),
        answerIndex = 0,
        explanation = "In Python, a colon `:` is required at the end of function definitions, loops, and conditional statements."
    ),

    Problem(
        id = "output_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print sum",
        summary = "Adding two integer variables.",
        prompt = "What does this code print?",
        code = """
            x = 5
            y = 3
            print(x + y)
        """.trimIndent(),
        options = listOf("8", "53", "x + y", "15"),
        answerIndex = 0,
        explanation = "The `+` operator adds the two numbers together, so 5 + 3 evaluates to 8."
    ),

    Problem(
        id = "purpose_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check parity",
        summary = "Using the modulo operator.",
        prompt = "What is the purpose of this function?",
        code = """
            def check(n):
                if n % 2 == 0:
                    return "Even"
                else:
                    return "Odd"
        """.trimIndent(),
        options = listOf(
            "It checks if a number is even or odd",
            "It divides a number by 2",
            "It returns the remainder of division",
            "It checks if a number is positive or negative"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder. If dividing by 2 leaves no remainder (`% 2 == 0`), the number is even."
    ),

    Problem(
        id = "fill_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Assigning a variable",
        summary = "Setting a value for the first time.",
        prompt = "Fill in the blank to assign the string to the variable.",
        code = """
            name ___ "Alice"
            print(name)
        """.trimIndent(),
        options = listOf("=", "==", ":", "->"),
        answerIndex = 0,
        explanation = "The single equals sign `=` is the assignment operator in Python."
    ),

    Problem(
        id = "order_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Make a sandwich",
        summary = "Combine strings in the right order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "print(sandwich)",
            "bread = 'wheat'",
            "filling = 'turkey'",
            "sandwich = bread + ' and ' + filling"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 3, 0),
        explanation = "Define the ingredients first, then combine them into the `sandwich` variable, and finally print the result."
    ),

    Problem(
        id = "complexity_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple assignment",
        summary = "How many times does this code execute?",
        prompt = "How many times does the print statement run?",
        code = """
            x = 100
            y = x + 50
            print(y)
        """.trimIndent(),
        options = listOf("1", "150", "100", "2"),
        answerIndex = 0,
        explanation = "There are no loops in this code, so it simply runs from top to bottom exactly 1 time."
    ),

    Problem(
        id = "trace_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Incrementing a score",
        summary = "Updating a variable multiple times.",
        prompt = "What is the value of `score` at the end of the code?",
        code = """
            score = 0
            score = score + 10
            score = score + 5
        """.trimIndent(),
        options = listOf("15", "10", "5", "0"),
        answerIndex = 0,
        explanation = "The score starts at 0, increases to 10, and then increases by another 5, ending at 15."
    ),

    Problem(
        id = "match_easy_students_21_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: Hi!",
        summary = "Which snippet prints a simple greeting?",
        prompt = "Which code produces exactly the output `Hi!`?",
        code = "",
        options = listOf(
            "print('Hi!')",
            "print('Hi')",
            "print(Hi!)",
            "print('hi!')"
        ),
        answerIndex = 0,
        explanation = "The string must exactly match the capitalization and punctuation of the requested output. `print(Hi!)` would cause an error because it lacks quotes."
    )
)
