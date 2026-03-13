package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents49 = listOf(
    Problem(
        id = "bug_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Variable Initialization",
        summary = "Using an undefined variable.",
        prompt = "Why does this code fail to run?",
        code = """
            def multiply(a, b):
                result = a * c
                return result
        """.trimIndent(),
        options = listOf(
            "The function must explicitly declare the data types of both `a` and `b` in the signature.",
            "`c` is not defined.",
            "The `return` statement is positioned incorrectly and will cause an indentation error at runtime.",
            "You cannot multiply two variables without importing the math library module first."
        ),
        answerIndex = 1,
        explanation = "The variable `c` has not been initialized or passed as an argument before being used."
    ),
    Problem(
        id = "output_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Repetition",
        summary = "Multiplying a string by an integer.",
        prompt = "What does this code print?",
        code = """
            word = "hi"
            print(word * 3)
        """.trimIndent(),
        options = listOf(
            "A TypeError will be thrown because you cannot multiply a string by an integer value directly.",
            "It will print \"hi\" three times on separate lines because multiplication implies newlines.",
            "hihihi",
            "hi3"
        ),
        answerIndex = 2,
        explanation = "Multiplying a string by an integer repeats the string that many times."
    ),
    Problem(
        id = "purpose_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Max Value Check",
        summary = "Returning the maximum of two numbers.",
        prompt = "What does this function do?",
        code = """
            def check(x, y):
                if x > y:
                    return x
                return y
        """.trimIndent(),
        options = listOf(
            "The function accurately calculates the absolute difference between the two provided parameters.",
            "It is designed to combine the two inputs and return their sum if the first is strictly positive.",
            "The method will invariably return the first argument regardless of the values passed to it.",
            "Returns the larger number."
        ),
        answerIndex = 3,
        explanation = "The code checks if `x` is greater than `y`. If it is, it returns `x`; otherwise, it returns `y`."
    ),
    Problem(
        id = "fill_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Append Element",
        summary = "Adding an item to a list.",
        prompt = "Fill in the blank to add 30 to the end of the list.",
        code = """
            items = [10, 20]
            items.____(30)
        """.trimIndent(),
        options = listOf(
            "You must use the push method, which is the standard way to add elements to the end of arrays.",
            "append",
            "Insert the element by utilizing the add_to_back function available in the collections module.",
            "concatenate_element"
        ),
        answerIndex = 1,
        explanation = "The `append` method adds an item to the end of a list."
    ),
    Problem(
        id = "order_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Calculate Sum",
        summary = "Looping to find a total sum.",
        prompt = "Arrange these lines to calculate the sum of numbers.",
        code = "",
        options = listOf(
            "total = 0",
            "for x in [1, 2, 3]:",
            "    total += x"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First initialize the total to 0, then start the loop, and finally add each number to the total."
    ),
    Problem(
        id = "complexity_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple Loop Range",
        summary = "Understanding the range function.",
        prompt = "How many times does the print statement execute?",
        code = """
            for i in range(5):
                print("Hello")
        """.trimIndent(),
        options = listOf(
            "The loop will actually iterate six times because it includes both zero and five inclusively.",
            "It will run four times since the upper bound in Python range functions is always excluded.",
            "The system will execute the print statement infinitely because there is no loop counter update.",
            "5"
        ),
        answerIndex = 3,
        explanation = "The `range(5)` function generates 5 values (0, 1, 2, 3, 4), causing the loop to run 5 times."
    ),
    Problem(
        id = "trace_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Swap",
        summary = "Swapping two variables.",
        prompt = "What is the value of `a` after the swap?",
        code = """
            a = 1
            b = 2
            a, b = b, a
        """.trimIndent(),
        options = listOf(
            "The value becomes exactly one because the tuple assignment fails to swap them simultaneously.",
            "2",
            "An unpacking error occurs because there are not enough variables on the left side of the assignment.",
            "Both variables will end up pointing to the memory location of the original value of a."
        ),
        answerIndex = 1,
        explanation = "Tuple unpacking `a, b = b, a` swaps the values of `a` and `b`, making `a` equal to 2."
    ),
    Problem(
        id = "match_easy_student_49",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Hello World",
        summary = "Printing text to the console.",
        prompt = "Which code correctly prints 'Hello'?",
        code = "",
        options = listOf(
            "System.out.println(\"Hello\");  # The standard approach for outputting text strings in console.",
            "console.log(\"Hello\");  // JavaScript's built in logging mechanism which is often confused with Python.",
            "print(\"Hello\")",
            "output_to_screen(\"Hello\", format=True, end_with_newline=True)"
        ),
        answerIndex = 2,
        explanation = "The built-in `print()` function outputs the provided text to the console in Python."
    )
)
