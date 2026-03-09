package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents3 = listOf(
    Problem(
        id = "bug_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Incorrect comparison",
        summary = "A conditional statement uses the wrong operator.",
        prompt = "Why will this code cause a SyntaxError?",
        code = """
            x = 10
            if x = 10:
                print("Ten")
        """.trimIndent(),
        options = listOf(
            "The `=` operator is used for assignment, not comparison",
            "`x` must be a string",
            "The `if` statement must have an `else` block",
            "`print` should be capitalized"
        ),
        answerIndex = 0,
        explanation = "In Python, `=` is the assignment operator. To compare equality in an `if` statement, you must use the `==` operator."
    ),
    Problem(
        id = "output_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String length math",
        summary = "Calculating the length of a string and adding to it.",
        prompt = "What does this code print?",
        code = """
            word = "code"
            print(len(word) + 1)
        """.trimIndent(),
        options = listOf(
            "5",
            "4",
            "code1",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The string \"code\" has 4 characters. `len(\"code\")` returns 4, and 4 + 1 = 5."
    ),
    Problem(
        id = "purpose_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check even or odd",
        summary = "Using the modulo operator to check divisibility.",
        prompt = "What is the overall purpose of this code?",
        code = """
            number = 7
            if number % 2 == 0:
                print("Even")
            else:
                print("Odd")
        """.trimIndent(),
        options = listOf(
            "To check if the number is even or odd and print the result",
            "To divide the number by 2 and print the remainder",
            "To check if 7 is less than 2",
            "To generate a random odd number"
        ),
        answerIndex = 0,
        explanation = "The `% 2` operation checks the remainder when dividing by 2. A remainder of 0 means the number is even, otherwise it's odd."
    ),
    Problem(
        id = "fill_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Import module",
        summary = "Bringing an external module into the script.",
        prompt = "Which keyword is used to bring the math module into the script?",
        code = """
            ___ math
            
            result = math.sqrt(16)
            print(result)
        """.trimIndent(),
        options = listOf(
            "import",
            "include",
            "require",
            "using"
        ),
        answerIndex = 0,
        explanation = "In Python, the `import` keyword is used to load modules, such as `math`, so their functions can be used."
    ),
    Problem(
        id = "order_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Create and greet",
        summary = "Arrange the lines to greet a person by name.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "name = \"Alice\"",
            "greeting = \"Hello, \" + name",
            "print(greeting)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "You must define the `name` variable before using it to create the `greeting`, and then print the greeting last."
    ),
    Problem(
        id = "complexity_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Double loop",
        summary = "How many times does the print statement run in nested loops?",
        prompt = "How many times does `print(\"Hi\")` execute?",
        code = """
            for i in range(2):
                for j in range(3):
                    print("Hi")
        """.trimIndent(),
        options = listOf("6", "5", "2", "3"),
        answerIndex = 0,
        explanation = "The outer loop runs 2 times, and for each of those times, the inner loop runs 3 times. 2 * 3 = 6 executions."
    ),
    Problem(
        id = "trace_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track score",
        summary = "What is the value of a variable after multiple operations?",
        prompt = "What is the value of `score` after the third line?",
        code = """
            score = 10
            score -= 3
            score *= 2
        """.trimIndent(),
        options = listOf("14", "17", "20", "7"),
        answerIndex = 0,
        explanation = "`score` starts at 10. After `score -= 3` it becomes 7. After `score *= 2` it becomes 14."
    ),
    Problem(
        id = "match_easy_student_4",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: list",
        summary = "Which snippet prints a Python list representation?",
        prompt = "Which code produces the exact output `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(1, 2, 3)",
            "print(\"1\", \"2\", \"3\")",
            "print(list(1, 2, 3))"
        ),
        answerIndex = 0,
        explanation = "Passing a list literal `[1, 2, 3]` to `print()` formats it with brackets. `print(1, 2, 3)` prints items separated by spaces without brackets."
    )
)
