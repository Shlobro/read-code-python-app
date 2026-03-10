package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents23 = listOf(
    Problem(
        id = "bug_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Assignment vs Equality",
        summary = "Using the wrong operator for checking equality.",
        prompt = "What is the error in this conditional statement?",
        code = """
            score = 100
            if score = 100:
                print("Perfect score!")
        """.trimIndent(),
        options = listOf(
            "`=` assigns a value, `==` checks for equality",
            "`score` must be declared as an integer",
            "The `if` statement is missing parenthesis",
            "100 cannot be assigned to a variable"
        ),
        answerIndex = 0,
        explanation = "In Python, `=` is used to assign values to variables, whereas `==` is used to compare two values."
    ),

    Problem(
        id = "output_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String repetition",
        summary = "Multiplying a string by an integer.",
        prompt = "What does this code output?",
        code = """
            cheer = "Go! "
            print(cheer * 3)
        """.trimIndent(),
        options = listOf(
            "Go! Go! Go! ",
            "Go! 3",
            "Go! * 3",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer `n` repeats the string `n` times."
    ),

    Problem(
        id = "purpose_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Identify even numbers",
        summary = "Using the modulo operator to test divisibility.",
        prompt = "What is the purpose of this function?",
        code = """
            def check_number(n):
                return n % 2 == 0
        """.trimIndent(),
        options = listOf(
            "It checks if a number is even",
            "It checks if a number is odd",
            "It divides a number by 2",
            "It finds the remainder of 2"
        ),
        answerIndex = 0,
        explanation = "The expression `n % 2 == 0` evaluates to True when `n` is perfectly divisible by 2, which means it is an even number."
    ),

    Problem(
        id = "fill_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Looping over a list",
        summary = "Iterating through elements in a list.",
        prompt = "Fill in the blank to print each fruit in the list.",
        code = """
            fruits = ["apple", "banana", "cherry"]
            ___ fruit in fruits:
                print(fruit)
        """.trimIndent(),
        options = listOf(
            "for",
            "while",
            "if",
            "loop"
        ),
        answerIndex = 0,
        explanation = "A `for` loop is used in Python to iterate over elements of a sequence, such as a list or a string."
    ),

    Problem(
        id = "order_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swapping variables",
        summary = "Using a temporary variable to swap values.",
        prompt = "Arrange the lines to swap the values of `x` and `y`.",
        code = "",
        options = listOf(
            "x = y",
            "y = temp",
            "temp = x"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1),
        explanation = "First, store `x` in a temporary variable. Then, assign the value of `y` to `x`. Finally, assign the stored `temp` value to `y`."
    ),

    Problem(
        id = "complexity_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Iterating characters",
        summary = "Counting the number of loop executions over a string.",
        prompt = "How many times will this loop execute?",
        code = """
            word = "Code"
            for letter in word:
                print(letter)
        """.trimIndent(),
        options = listOf(
            "4",
            "1",
            "5",
            "It causes an infinite loop"
        ),
        answerIndex = 0,
        explanation = "The loop runs once for every character in the string. The word 'Code' has 4 letters, so it runs 4 times."
    ),

    Problem(
        id = "trace_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Updating a variable",
        summary = "Tracing variable value changes.",
        prompt = "What is the value of `x` after the code finishes?",
        code = """
            x = 5
            x = x + 2
            x = x * 2
        """.trimIndent(),
        options = listOf(
            "14",
            "7",
            "10",
            "5"
        ),
        answerIndex = 0,
        explanation = "First `x` is 5. Then `x = 5 + 2` sets it to 7. Finally, `x = 7 * 2` sets it to 14."
    ),

    Problem(
        id = "match_easy_students_23_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: [1, 2, 3, 4]",
        summary = "Which code appends an element to a list?",
        prompt = "Which of the following code snippets produces the output `[1, 2, 3, 4]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nnums.append(4)\nprint(nums)",
            "nums = [1, 2, 3]\nnums.add(4)\nprint(nums)",
            "nums = [1, 2, 3]\nnums[3] = 4\nprint(nums)",
            "nums = [1, 2, 3]\nnums + 4\nprint(nums)"
        ),
        answerIndex = 0,
        explanation = "The `append()` method adds a single item to the end of a list in Python."
    )
)
