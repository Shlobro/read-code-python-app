package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents44 = listOf(
    Problem(
        id = "bug_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Loop Iteration Mistake",
        summary = "A for loop that doesn't reach the expected number.",
        prompt = "Why does this code only print 1 and 2?",
        code = """
            for i in range(1, 3):
                print(i)
        """.trimIndent(),
        options = listOf(
            "range(1, 3) stops at 2, not 3.",
            "The loop variable is poorly named and must be called 'number' instead of 'i'.",
            "The print statement is placed inside the loop when it should be outside.",
            "Python does not support printing integers directly inside a for loop block."
        ),
        answerIndex = 0,
        explanation = "The range(start, stop) function goes up to, but does not include, the stop value."
    ),
    Problem(
        id = "output_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Variable Reassignment",
        summary = "Updating a variable inside a loop.",
        prompt = "What is the final printed value?",
        code = """
            x = 0
            for i in range(2):
                x = i
            print(x)
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "2",
            "3"
        ),
        answerIndex = 1,
        explanation = "The loop runs for i=0 and i=1. The final value assigned to x is 1."
    ),
    Problem(
        id = "purpose_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Even Number Check",
        summary = "A basic conditional statement.",
        prompt = "What does this function do?",
        code = """
            def check(n):
                if n % 2 == 0:
                    return True
                return False
        """.trimIndent(),
        options = listOf(
            "Returns true if the number is an odd number and false otherwise.",
            "Calculates the remainder of dividing the provided integer by two.",
            "It checks if a given number is even.",
            "Checks if a number can be divided by the number two without a remainder, mathematically speaking."
        ),
        answerIndex = 2,
        explanation = "The modulo operator (%) returns the remainder. A remainder of 0 when divided by 2 means the number is even."
    ),
    Problem(
        id = "fill_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Adding to a List",
        summary = "Using the correct method to add an item.",
        prompt = "Fill in the blank to add 'cherry' to the list.",
        code = """
            fruits = ["apple", "banana"]
            fruits.__("cherry")
        """.trimIndent(),
        options = listOf(
            "push_back",
            "add_to_end",
            "extend",
            "append"
        ),
        answerIndex = 3,
        explanation = "In Python, the append() method is used to add a single item to the end of a list."
    ),
    Problem(
        id = "order_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swapping Variables",
        summary = "Using a temporary variable to swap values.",
        prompt = "Arrange these lines to correctly swap variables a and b.",
        code = "",
        options = listOf(
            "temp = a",
            "a = b",
            "b = temp"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "Store 'a' in 'temp', then assign 'b' to 'a', and finally assign 'temp' (the original 'a') to 'b'."
    ),
    Problem(
        id = "complexity_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Nested Loop Runs",
        summary = "Counting total executions in a nested loop.",
        prompt = "How many times does 'Hi' print?",
        code = """
            for i in range(2):
                for j in range(2):
                    print("Hi")
        """.trimIndent(),
        options = listOf(
            "4 times",
            "2 times",
            "3 times",
            "1 time"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs 2 times. For each iteration, the inner loop runs 2 times. 2 * 2 = 4."
    ),
    Problem(
        id = "trace_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "List Element Access",
        summary = "Accessing an item by its index.",
        prompt = "What is the value of 'item'?",
        code = """
            colors = ["red", "blue", "green"]
            item = colors[1]
        """.trimIndent(),
        options = listOf(
            "red",
            "green",
            "blue",
            "The code raises an IndexError because there is no item at index 1 in the list."
        ),
        answerIndex = 2,
        explanation = "Python lists are zero-indexed, so index 1 refers to the second item, which is 'blue'."
    ),
    Problem(
        id = "match_easy_student_44",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Concatenation",
        summary = "Joining two strings.",
        prompt = "Which code correctly produces 'HelloWorld'?",
        code = "",
        options = listOf(
            "f'Hello' + f'World'",
            "'Hello' * 'World'",
            "'Hello' + 'World'",
            "'Hello' - 'World'"
        ),
        answerIndex = 2,
        explanation = "The '+' operator is used to concatenate (join) two strings together in Python."
    )
)
