package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents41 = listOf(
    Problem(
        id = "bug_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "List Append Return",
        summary = "A list method does not return a new list.",
        prompt = "Why does this code print 'None' instead of the list?",
        code = """
            my_list = [1, 2, 3]
            new_list = my_list.append(4)
            print(new_list)
        """.trimIndent(),
        options = listOf(
            "It returns None because append changes the list in-place",
            "The my_list variable is immutable and cannot be changed after creation",
            "The number 4 must be enclosed in brackets to be appended",
            "The method name should be add instead of append in Python"
        ),
        answerIndex = 0,
        explanation = "The `append` method modifies the list directly and returns `None`, so `new_list` is assigned `None`."
    ),
    Problem(
        id = "output_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Modulo Arithmetic",
        summary = "Getting the remainder of division.",
        prompt = "What does this code print?",
        code = """
            x = 17
            y = 5
            print(x % y)
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "1",
            "17"
        ),
        answerIndex = 1,
        explanation = "The modulo operator `%` returns the remainder of the division. 17 divided by 5 is 3 with a remainder of 2."
    ),
    Problem(
        id = "purpose_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "String Formatting",
        summary = "Using f-strings to format output.",
        prompt = "What is the purpose of this code?",
        code = """
            name = "Alice"
            age = 20
            greeting = f"User {name} is {age} years old."
            print(greeting)
        """.trimIndent(),
        options = listOf(
            "It creates and prints a string with embedded variables",
            "It adds the numerical value of age to the letters in name",
            "It converts the string variables into integers for math operations",
            "It checks if the name and age variables match the string"
        ),
        answerIndex = 0,
        explanation = "The code uses an f-string to embed the variables `name` and `age` directly into a new formatted string."
    ),
    Problem(
        id = "fill_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Importing Modules",
        summary = "Using the math module for square roots.",
        prompt = "How do you complete this code to print 5.0?",
        code = """
            import ___
            print(math.sqrt(25))
        """.trimIndent(),
        options = listOf(
            "cmath",
            "math",
            "numbers",
            "calculus"
        ),
        answerIndex = 1,
        explanation = "The `math` module provides mathematical functions like `sqrt` in Python."
    ),
    Problem(
        id = "order_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Reading a File",
        summary = "Opening, reading, and closing a file using a context manager.",
        prompt = "Arrange these lines to safely read a file and print its contents.",
        code = "",
        options = listOf(
            "with open('data.txt', 'r') as file:",
            "    content = file.read()",
            "    print(content)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "The `with` statement opens the file, the nested `read()` gets the content, and then the content is printed."
    ),
    Problem(
        id = "complexity_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Nested Loops",
        summary = "Two loops iterating over small ranges.",
        prompt = "How many times will 'print' be called?",
        code = """
            for i in range(3):
                for j in range(4):
                    print(i, j)
        """.trimIndent(),
        options = listOf(
            "12 times",
            "7 times",
            "3 times",
            "4 times"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs 3 times, and for each of those, the inner loop runs 4 times, making 3 * 4 = 12 total executions."
    ),
    Problem(
        id = "trace_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Dictionary Update",
        summary = "Changing values in a dictionary.",
        prompt = "What is the value of 'inventory[\"apples\"]' at the end?",
        code = """
            inventory = {"apples": 5, "bananas": 2}
            inventory["apples"] = inventory["apples"] + 3
        """.trimIndent(),
        options = listOf(
            "5",
            "8",
            "2",
            "10"
        ),
        answerIndex = 1,
        explanation = "The value associated with the key `\"apples\"` starts at 5, and 3 is added to it, resulting in 8."
    ),
    Problem(
        id = "match_easy_student_41",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Comprehension Filter",
        summary = "Filtering a list for even numbers.",
        prompt = "Which code produces the list `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "[x for x in range(1, 7) if x % 2 == 0]",
            "[x for x in range(1, 8) if x % 2 != 0 and x > 0]",
            "[x * 2 for x in range(1, 4) if x > 1]",
            "[x for x in range(2, 6)]"
        ),
        answerIndex = 0,
        explanation = "This list comprehension loops through numbers 1 to 6 and only includes the numbers that are evenly divisible by 2 (even numbers)."
    )
)
