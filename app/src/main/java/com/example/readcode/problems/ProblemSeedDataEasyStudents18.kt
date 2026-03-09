package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents18 = listOf(
    Problem(
        id = "bug_easy_student_18_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Return Statement",
        summary = "A function calculates a value but doesn't hand it back.",
        prompt = "Why does `print(result)` output `None`?",
        code = """
            def multiply(a, b):
                product = a * b

            result = multiply(4, 5)
            print(result)
        """.trimIndent(),
        options = listOf(
            "The function is missing a `return` statement",
            "The variables `a` and `b` are not defined",
            "You cannot print a variable named `result`",
            "The product is calculated incorrectly"
        ),
        answerIndex = 0,
        explanation = "In Python, a function returns `None` by default unless you explicitly use a `return` statement to send a value back to the caller."
    ),
    Problem(
        id = "output_easy_student_18_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String vs Integer Addition",
        summary = "Adding strings behaves differently than adding integers.",
        prompt = "What does this code print?",
        code = """
            x = "2"
            y = "3"
            print(x + y)
        """.trimIndent(),
        options = listOf(
            "23",
            "5",
            "Error",
            "6"
        ),
        answerIndex = 0,
        explanation = "Since `x` and `y` are strings (enclosed in quotes), the `+` operator concatenates them side-by-side instead of performing mathematical addition."
    ),
    Problem(
        id = "purpose_easy_student_18_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Area Calculation",
        summary = "A function takes two dimensions and multiplies them.",
        prompt = "What is the purpose of this function?",
        code = """
            def calc(width, height):
                return width * height
        """.trimIndent(),
        options = listOf(
            "Calculates the area of a rectangle",
            "Calculates the perimeter of a rectangle",
            "Finds the larger of two numbers",
            "Adds the width and height together"
        ),
        answerIndex = 0,
        explanation = "Multiplying width by height calculates the area of a rectangle."
    ),
    Problem(
        id = "fill_easy_student_18_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String Length",
        summary = "Finding how many characters are in a string.",
        prompt = "Fill in the blank to print the number of characters in the word.",
        code = """
            word = "programming"
            print(___(word))
        """.trimIndent(),
        options = listOf(
            "len",
            "length",
            "size",
            "count"
        ),
        answerIndex = 0,
        explanation = "The built-in `len()` function returns the number of items in an object, including the number of characters in a string."
    ),
    Problem(
        id = "order_easy_student_18_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple For Loop",
        summary = "Arrange the code to loop over a list and print each item.",
        prompt = "Put the lines in the correct order to print each number in the list.",
        code = "",
        options = listOf(
            "    print(num)",
            "for num in numbers:",
            "numbers = [1, 2, 3]"
        ),
        answerIndex = -1,
        correctOrder = listOf(2, 1, 0),
        explanation = "First define the list, then start the `for` loop, and finally indent the action to be performed on each item."
    ),
    Problem(
        id = "complexity_easy_student_18_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Iteration Count",
        summary = "Counting iterations of a basic while loop.",
        prompt = "How many times will the print statement execute?",
        code = """
            count = 0
            while count < 3:
                print("Hello")
                count = count + 1
        """.trimIndent(),
        options = listOf(
            "3 times",
            "4 times",
            "2 times",
            "Infinite times"
        ),
        answerIndex = 0,
        explanation = "The loop runs when `count` is 0, 1, and 2. When `count` becomes 3, the condition is false, so it stops. Thus, it runs exactly 3 times."
    ),
    Problem(
        id = "trace_easy_student_18_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a Counter",
        summary = "Tracking the value of a variable modified in a loop.",
        prompt = "What is the final value of `total`?",
        code = """
            total = 0
            for i in [10, 20]:
                total = total + i
        """.trimIndent(),
        options = listOf(
            "30",
            "10",
            "20",
            "0"
        ),
        answerIndex = 0,
        explanation = "Initially 0. In the first pass, it adds 10 (total = 10). In the second pass, it adds 20 (total = 10 + 20 = 30)."
    ),
    Problem(
        id = "match_easy_student_18_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Getting a Character",
        summary = "Pick the code that extracts the second character of a string.",
        prompt = "Which code snippet prints `b`?",
        code = "",
        options = listOf(
            "word = 'abc'; print(word[1])",
            "word = 'abc'; print(word[2])",
            "word = 'abc'; print(word[0])",
            "word = 'abc'; print(word[-1])"
        ),
        answerIndex = 0,
        explanation = "String indexing starts at 0. So `word[1]` extracts the second character, which is 'b'."
    )
)
