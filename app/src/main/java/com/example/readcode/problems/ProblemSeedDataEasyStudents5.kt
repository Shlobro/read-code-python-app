package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents5 = listOf(
    Problem(
        id = "bug_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong variable name",
        summary = "A typo causes an error when trying to print a variable.",
        prompt = "Why will this code cause a NameError?",
        code = """
            message = "Welcome to Python"
            print(mesage)
        """.trimIndent(),
        options = listOf(
            "The variable is spelled `mesage` in the print statement but defined as `message`",
            "Strings cannot contain spaces",
            "`Welcome` must be in uppercase",
            "There are missing parentheses around the string"
        ),
        answerIndex = 0,
        explanation = "Variables must be spelled exactly as they were defined. `mesage` does not exist, so Python throws a NameError."
    ),
    Problem(
        id = "output_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List indexing",
        summary = "Accessing the first item in a list.",
        prompt = "What does this code print?",
        code = """
            colors = ["red", "blue", "green"]
            print(colors[0])
        """.trimIndent(),
        options = listOf(
            "red",
            "blue",
            "green",
            "colors"
        ),
        answerIndex = 0,
        explanation = "In Python, lists are zero-indexed, meaning the first item is accessed with `[0]`."
    ),
    Problem(
        id = "purpose_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check start",
        summary = "Looking at the beginning of a word.",
        prompt = "What does this function do?",
        code = """
            def check_word(word):
                return word.startswith("A")
        """.trimIndent(),
        options = listOf(
            "Returns True if the word begins with a capital 'A'",
            "Changes the first letter to 'A'",
            "Adds an 'A' to the start of the word",
            "Returns the first letter of the word"
        ),
        answerIndex = 0,
        explanation = "`startswith` is a built-in method that checks if a string begins with a specific substring, returning True or False."
    ),
    Problem(
        id = "fill_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Equality check",
        summary = "Comparing two numbers.",
        prompt = "Which operator completes the if statement to check if x is exactly 10?",
        code = """
            x = 10
            if x ___ 10:
                print("It is ten!")
        """.trimIndent(),
        options = listOf(
            "==",
            "=",
            "=>",
            "equals"
        ),
        answerIndex = 0,
        explanation = "In Python, `==` is the equality operator used to compare values, whereas `=` is used to assign values."
    ),
    Problem(
        id = "order_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "List append",
        summary = "Create an empty list, add an item, and print it.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "items = []",
            "items.append(\"apple\")",
            "print(items)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First you must create the list, then you can append to it, and finally you can print the updated list."
    ),
    Problem(
        id = "complexity_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "While loop count",
        summary = "Counting executions in a while loop.",
        prompt = "How many times will `hello` be printed?",
        code = """
            n = 3
            while n > 0:
                print("hello")
                n -= 1
        """.trimIndent(),
        options = listOf("3", "4", "2", "0"),
        answerIndex = 0,
        explanation = "`n` starts at 3 and decreases by 1 each time. The loop runs for `n = 3`, `n = 2`, and `n = 1`."
    ),
    Problem(
        id = "trace_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Reassign variable",
        summary = "Changing the value of a string variable.",
        prompt = "What is the final value of the `pet` variable?",
        code = """
            pet = "dog"
            pet = "cat"
            pet = "bird"
        """.trimIndent(),
        options = listOf("bird", "dog", "cat", "dogcatbird"),
        answerIndex = 0,
        explanation = "A variable holds the last value assigned to it. `pet` is completely replaced each time, ending up as `bird`."
    ),
    Problem(
        id = "match_easy_student_6",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String formatting",
        summary = "Which snippet prints a greeting correctly?",
        prompt = "Which code produces the exact output `Hi, Bob!`?",
        code = "",
        options = listOf(
            "name = \"Bob\"\nprint(f\"Hi, {name}!\")",
            "name = \"Bob\"\nprint(\"Hi, {name}!\")",
            "name = \"Bob\"\nprint(\"Hi, name!\")",
            "name = \"Bob\"\nprint(f\"Hi Bob!\")"
        ),
        answerIndex = 0,
        explanation = "An f-string (`f\"...\"`) correctly substitutes the value of the `name` variable into the text, including the comma and exclamation mark."
    )
)
