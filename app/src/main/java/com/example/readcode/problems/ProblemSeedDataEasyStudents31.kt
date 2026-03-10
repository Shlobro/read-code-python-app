package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents31 = listOf(
    Problem(
        id = "bug_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Type mismatch",
        summary = "Trying to add a string and an integer.",
        prompt = "Why will this code crash?",
        code = """
            age = 20
            message = "I am " + age + " years old"
            print(message)
        """.trimIndent(),
        options = listOf(
            "You cannot concatenate a string and an integer directly",
            "age should be defined with let or var",
            "message is not a valid variable name",
            "print needs single quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, you must convert the integer to a string using str(age) before adding it to other strings."
    ),
    Problem(
        id = "output_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String repetition",
        summary = "Multiplying a string by an integer.",
        prompt = "What does this code print?",
        code = """
            word = "Hi"
            print(word * 3)
        """.trimIndent(),
        options = listOf("HiHiHi", "Hi3", "Hi Hi Hi", "Error"),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times without spaces."
    ),
    Problem(
        id = "purpose_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Greet user",
        summary = "A function that takes a name and prints a greeting.",
        prompt = "What does this code do?",
        code = """
            def greet(name):
                print("Welcome, " + name + "!")
            
            greet("Alice")
        """.trimIndent(),
        options = listOf(
            "It prints a personalized welcome message",
            "It returns the word Welcome",
            "It asks the user to type their name",
            "It checks if the name is Alice"
        ),
        answerIndex = 0,
        explanation = "The function takes a parameter `name` and prints a greeting containing that name."
    ),
    Problem(
        id = "fill_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Check equality",
        summary = "Using the equality operator in a condition.",
        prompt = "Fill in the blank to check if the score is exactly 100.",
        code = """
            score = 100
            if score ___ 100:
                print("Perfect!")
        """.trimIndent(),
        options = listOf("==", "=", "===", "is equal"),
        answerIndex = 0,
        explanation = "In Python, `==` is used to compare two values for equality. A single `=` is used for assignment."
    ),
    Problem(
        id = "order_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "List creation",
        summary = "Create a list, add an item, and print it.",
        prompt = "Arrange the lines in the correct logical order.",
        code = "",
        options = listOf(
            "print(colors)",
            "colors.append(\"blue\")",
            "colors = [\"red\", \"green\"]"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 1, 0),
        explanation = "First you create the list, then you append an item to it, and finally you print the updated list."
    ),
    Problem(
        id = "complexity_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop iterations",
        summary = "Count how many times a simple loop runs.",
        prompt = "How many times will \"Looping\" be printed?",
        code = """
            count = 0
            while count < 4:
                print("Looping")
                count = count + 1
        """.trimIndent(),
        options = listOf("4", "3", "5", "Infinite"),
        answerIndex = 0,
        explanation = "The loop runs for count = 0, 1, 2, and 3. That is exactly 4 times."
    ),
    Problem(
        id = "trace_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Update variable",
        summary = "Track the value of x through reassignments.",
        prompt = "What is the final value of x?",
        code = """
            x = 10
            x = x + 5
            x = x * 2
        """.trimIndent(),
        options = listOf("30", "20", "15", "10"),
        answerIndex = 0,
        explanation = "x starts at 10. Then 10 + 5 makes it 15. Finally, 15 * 2 makes it 30."
    ),
    Problem(
        id = "match_easy_student_31",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: 0 1 2",
        summary = "Pick the loop that prints 0, 1, and 2 on separate lines.",
        prompt = "Which code produces the output:\n0\n1\n2?",
        code = "",
        options = listOf(
            "for i in range(3):\n    print(i)",
            "for i in range(1, 3):\n    print(i)",
            "for i in [1, 2, 3]:\n    print(i)",
            "for i in range(2):\n    print(i)"
        ),
        answerIndex = 0,
        explanation = "`range(3)` produces the sequence 0, 1, 2. Each value is printed on a new line."
    )
)
