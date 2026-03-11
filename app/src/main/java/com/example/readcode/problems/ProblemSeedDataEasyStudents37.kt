package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Easy student problems batch 37.
val easyProblemsStudents37 = listOf(
    Problem(
        id = "bug_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Parenthesis",
        summary = "A syntax error caused by unmatched brackets.",
        prompt = "Why will this code result in a syntax error?",
        code = """
            print("Hello, world"
            
            name = "Alice"
        """.trimIndent(),
        options = listOf(
            "The print statement is missing a closing parenthesis",
            "name is not defined properly",
            "You cannot print strings with a comma",
            "The variable must be defined first"
        ),
        answerIndex = 0,
        explanation = "Every open parenthesis '(' must have a matching closing parenthesis ')'. The print statement is missing the closing one."
    ),
    Problem(
        id = "output_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Slicing",
        summary = "Getting a portion of a list.",
        prompt = "What does this code print?",
        code = """
            letters = ["A", "B", "C", "D"]
            print(letters[0:2])
        """.trimIndent(),
        options = listOf(
            "['A', 'B']",
            "['A', 'B', 'C']",
            "['B', 'C']",
            "['A']"
        ),
        answerIndex = 0,
        explanation = "List slicing `[start:end]` includes the start index but stops before the end index. Index 0 is 'A' and 1 is 'B', so it returns `['A', 'B']`."
    ),
    Problem(
        id = "purpose_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Total Sum",
        summary = "Using the built-in sum function.",
        prompt = "What does this code do overall?",
        code = """
            prices = [5, 10, 15]
            total_cost = sum(prices)
        """.trimIndent(),
        options = listOf(
            "Adds all the numbers in the list together",
            "Finds the largest number in the list",
            "Counts how many items are in the list",
            "Subtracts the numbers from each other"
        ),
        answerIndex = 0,
        explanation = "The built-in `sum()` function adds up all the numeric items in an iterable, calculating the total of the list."
    ),
    Problem(
        id = "fill_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Else If Keyword",
        summary = "Checking multiple conditions.",
        prompt = "Which keyword fills in the blank to check another condition if the first one is false?",
        code = """
            score = 80
            if score >= 90:
                print("A")
            ___ score >= 80:
                print("B")
        """.trimIndent(),
        options = listOf(
            "elif",
            "else if",
            "elseif",
            "if else"
        ),
        answerIndex = 0,
        explanation = "In Python, `elif` is short for 'else if' and is used to chain multiple conditions together."
    ),
    Problem(
        id = "order_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple For Loop",
        summary = "Iterating multiple times.",
        prompt = "Arrange these lines to print 'Hi' three times.",
        code = "",
        options = listOf(
            "for i in range(3):",
            "    print(\"Hi\")",
            "print(\"Done\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "The loop statement `for i in range(3):` must come first, followed by the indented body. The un-indented `print(\"Done\")` runs after the loop finishes."
    ),
    Problem(
        id = "complexity_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Range Function",
        summary = "Looping a set number of times.",
        prompt = "How many times will this loop run?",
        code = """
            for num in range(5):
                print(num)
        """.trimIndent(),
        options = listOf(
            "5 times",
            "4 times",
            "6 times",
            "1 time"
        ),
        answerIndex = 0,
        explanation = "The `range(5)` function generates a sequence of 5 numbers (0, 1, 2, 3, 4), causing the loop to run 5 times."
    ),
    Problem(
        id = "trace_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracing a String",
        summary = "Appending characters to a string.",
        prompt = "What is the value of 'result' after this code runs?",
        code = """
            result = ""
            for char in ["a", "b"]:
                result = result + char
        """.trimIndent(),
        options = listOf(
            "ab",
            "a",
            "b",
            "ba"
        ),
        answerIndex = 0,
        explanation = "The loop starts with an empty string, appends 'a', and then appends 'b', resulting in 'ab'."
    ),
    Problem(
        id = "match_easy_student_37",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Uppercase String",
        summary = "Changing text casing.",
        prompt = "Which code correctly prints 'HELLO'?",
        code = "",
        options = listOf(
            "print(\"hello\".upper())",
            "print(\"hello\".lower())",
            "print(\"hello\".capitalize())",
            "print(upper(\"hello\"))"
        ),
        answerIndex = 0,
        explanation = "The `.upper()` string method converts all characters in a string to uppercase."
    )
)
