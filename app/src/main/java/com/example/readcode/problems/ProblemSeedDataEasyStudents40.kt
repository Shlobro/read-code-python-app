package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents40 = listOf(
    Problem(
        id = "bug_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Return",
        summary = "A function that does not give back a result.",
        prompt = "Why does this print 'None' instead of the sum?",
        code = """
            def add_numbers(x, y):
                total = x + y

            result = add_numbers(3, 4)
            print(result)
        """.trimIndent(),
        options = listOf(
            "The function is missing a 'return total' statement",
            "The variables should be called a and b",
            "You cannot print a variable named result",
            "Addition requires the 'math' module"
        ),
        answerIndex = 0,
        explanation = "If a function doesn\'t explicitly return a value using the `return` keyword, it returns `None` by default."
    ),
    Problem(
        id = "output_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Dictionary Lookup",
        summary = "Accessing a value using a key.",
        prompt = "What does this code print?",
        code = """
            scores = {"Alice": 90, "Bob": 85}
            print(scores["Alice"])
        """.trimIndent(),
        options = listOf(
            "90",
            "85",
            "Alice",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Using the key `\"Alice\"` retrieves its associated value, which is 90."
    ),
    Problem(
        id = "purpose_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Finding Maximum",
        summary = "Comparing numbers in a loop.",
        prompt = "What does this function do?",
        code = """
            def find_best(scores):
                best = scores[0]
                for s in scores:
                    if s > best:
                        best = s
                return best
        """.trimIndent(),
        options = listOf(
            "Returns the highest number in the list",
            "Returns the first number in the list",
            "Sorts the list from highest to lowest",
            "Returns the lowest number in the list"
        ),
        answerIndex = 0,
        explanation = "The loop checks each score and updates the `best` variable if it finds a higher one, effectively finding the maximum."
    ),
    Problem(
        id = "fill_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Else Condition",
        summary = "Handling the alternative case.",
        prompt = "Which keyword handles the case when the 'if' condition is false?",
        code = """
            age = 15
            if age >= 18:
                print("Adult")
            ___:
                print("Minor")
        """.trimIndent(),
        options = listOf(
            "else",
            "elif",
            "otherwise",
            "catch"
        ),
        answerIndex = 0,
        explanation = "The `else` block runs when all preceding `if` and `elif` conditions evaluate to false."
    ),
    Problem(
        id = "order_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Function Definition and Call",
        summary = "Creating and using a simple function.",
        prompt = "Arrange these lines to define a function and then call it.",
        code = "",
        options = listOf(
            "def greet():",
            "    print(\"Hello there!\")",
            "greet()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "A function must first be defined with `def`, followed by its indented body, before it can be called later in the code."
    ),
    Problem(
        id = "complexity_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop Over List",
        summary = "Iterating through every element.",
        prompt = "If 'names' has 10 items, how many times does 'print' run?",
        code = """
            for name in names:
                print("Hello " + name)
        """.trimIndent(),
        options = listOf(
            "10 times",
            "1 time",
            "9 times",
            "11 times"
        ),
        answerIndex = 0,
        explanation = "A `for` loop over a list will execute its body once for each element in the list."
    ),
    Problem(
        id = "trace_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Increment",
        summary = "Adding to a variable inside a loop.",
        prompt = "What is the value of 'count' after the loop finishes?",
        code = """
            count = 0
            for i in range(3):
                count += 2
        """.trimIndent(),
        options = listOf(
            "6",
            "2",
            "3",
            "5"
        ),
        answerIndex = 0,
        explanation = "The loop runs 3 times (for 0, 1, 2). In each iteration, 2 is added to `count` (0 -> 2 -> 4 -> 6)."
    ),
    Problem(
        id = "match_easy_student_40",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Slicing",
        summary = "Extracting part of a string.",
        prompt = "Which code correctly prints the word 'sun'?",
        code = "",
        options = listOf(
            "print(\"sunflower\"[0:3])",
            "print(\"sunflower\"[1:4])",
            "print(\"sunflower\"[3:])",
            "print(\"sunflower\"[:4])"
        ),
        answerIndex = 0,
        explanation = "The slice `[0:3]` extracts characters starting at index 0 up to (but not including) index 3."
    )
)
