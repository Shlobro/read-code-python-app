package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents9 = listOf(
    Problem(
        id = "bug_easy_student_9_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Assignment vs comparison",
        summary = "Using the wrong equals sign in an if statement.",
        prompt = "Why does this code cause a SyntaxError?",
        code = """
            score = 10
            if score = 10:
                print("Perfect!")
        """.trimIndent(),
        options = listOf(
            "A single equals sign is for assignment, not comparison",
            "score must be a string",
            "print needs double quotes around the text",
            "The colon should be a semicolon"
        ),
        answerIndex = 0,
        explanation = "In Python, `==` is used to compare values. A single `=` tries to assign a value inside the `if` statement, which causes a SyntaxError."
    ),
    Problem(
        id = "output_easy_student_9_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Dictionary lookup",
        summary = "Accessing a value by its key.",
        prompt = "What does this code print?",
        code = """
            colors = {"apple": "red", "banana": "yellow"}
            print(colors["apple"])
        """.trimIndent(),
        options = listOf(
            "red",
            "apple",
            "yellow",
            "['red', 'yellow']"
        ),
        answerIndex = 0,
        explanation = "A dictionary looks up a key (like 'apple') and returns its associated value ('red')."
    ),
    Problem(
        id = "purpose_easy_student_9_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Count items",
        summary = "A loop that tallies items.",
        prompt = "What does this function do?",
        code = """
            def process(items):
                total = 0
                for item in items:
                    total += 1
                return total
        """.trimIndent(),
        options = listOf(
            "Counts how many items are in the list",
            "Adds up the values of the items in the list",
            "Finds the largest number in the list",
            "Creates a new list of items"
        ),
        answerIndex = 0,
        explanation = "The function adds 1 to `total` for every item in the list, effectively calculating the length of the list."
    ),
    Problem(
        id = "fill_easy_student_9_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List slicing",
        summary = "Getting the first two items.",
        prompt = "Which slice returns the first two letters?",
        code = """
            letters = ["A", "B", "C", "D"]
            first_two = letters[___]
            print(first_two)
        """.trimIndent(),
        options = listOf(
            "0:2",
            "1:2",
            "0:1",
            "2:4"
        ),
        answerIndex = 0,
        explanation = "Slicing `0:2` starts at index 0 and stops before index 2, giving the first two elements."
    ),
    Problem(
        id = "order_easy_student_9_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Define and call function",
        summary = "Setting up a function and using it.",
        prompt = "Arrange the lines to define and call the function.",
        code = "",
        options = listOf(
            "def greet(name):",
            "    print('Hi, ' + name)",
            "greet('Alice')",
            "greet('Bob')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "A function must be defined and its body indented before it can be called. After defining it, you can call it multiple times."
    ),
    Problem(
        id = "complexity_easy_student_9_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "String length",
        summary = "How Python stores string lengths.",
        prompt = "Why is checking string length fast in Python?",
        code = """
            text = "hello"
            print(len(text))
        """.trimIndent(),
        options = listOf(
            "O(1) because Python stores the length of strings",
            "O(N) because it must count every character",
            "O(N^2) because strings are immutable",
            "O(log N) because it splits the string"
        ),
        answerIndex = 0,
        explanation = "Python strings store their length internally, so `len()` doesn't need to count characters one by one. It returns the stored value immediately in O(1) time."
    ),
    Problem(
        id = "trace_easy_student_9_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "List append",
        summary = "Tracking list contents as elements are added.",
        prompt = "What is the value of `nums` after these lines?",
        code = """
            nums = [1]
            nums.append(2)
            nums.append(3)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]",
            "[3, 2, 1]",
            "[3]",
            "[[1], 2, 3]"
        ),
        answerIndex = 0,
        explanation = "The `append()` method adds each new element to the end of the existing list."
    ),
    Problem(
        id = "match_easy_student_9_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print multiple times",
        summary = "Repeating a string.",
        prompt = "Which code prints `HiHiHi`?",
        code = "",
        options = listOf(
            "print('Hi' * 3)",
            "print('Hi' + 3)",
            "print('Hi', 3)",
            "print('Hi' ** 3)"
        ),
        answerIndex = 0,
        explanation = "In Python, multiplying a string by an integer repeats the string that many times."
    )
)
