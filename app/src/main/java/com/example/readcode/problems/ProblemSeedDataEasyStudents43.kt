package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents43 = listOf(
    Problem(
        id = "bug_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Division by Zero Error",
        summary = "A basic division calculation that fails when the denominator is zero.",
        prompt = "Why does this program crash when calculating the average?",
        code = """
            total = 100
            count = 0
            average = total / count
            print(average)
        """.trimIndent(),
        options = listOf(
            "The division causes a ZeroDivisionError because count is 0",
            "The total variable must be explicitly converted to a floating point number first",
            "You cannot divide an integer by another integer in Python",
            "The variable average is a reserved language keyword"
        ),
        answerIndex = 0,
        explanation = "Dividing any number by zero is mathematically undefined and raises a ZeroDivisionError in Python."
    ),
    Problem(
        id = "output_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Modulo Operator",
        summary = "Calculating the remainder.",
        prompt = "What is the exact output of this code?",
        code = """
            cookies = 14
            people = 3
            leftover = cookies % people
            print(leftover)
        """.trimIndent(),
        options = listOf(
            "4",
            "2",
            "4",
            "14"
        ),
        answerIndex = 1,
        explanation = "The '%' operator calculates the remainder. 14 divided by 3 is 4 with a remainder of 2."
    ),
    Problem(
        id = "purpose_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Appending to a List",
        summary = "Using append in a loop to collect data.",
        prompt = "What is the main purpose of this code?",
        code = """
            data = []
            for i in range(3):
                data.append(i * 10)
            print(data)
        """.trimIndent(),
        options = listOf(
            "It creates a list containing three numbers: 0, 10, and 20",
            "It creates a list containing the squares of 0, 1, and 2",
            "It multiplies all existing numbers inside the list by ten",
            "It deletes any items in the list that are strictly less than three"
        ),
        answerIndex = 0,
        explanation = "The loop runs for i=0, 1, and 2. It appends 0*10, 1*10, and 2*10 to the list, resulting in [0, 10, 20]."
    ),
    Problem(
        id = "fill_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String Formatting",
        summary = "Using an f-string to insert a variable.",
        prompt = "Fill in the blank to correctly format the string with the given variable.",
        code = """
            name = "Alice"
            greeting = f"Hello, ___"
            print(greeting)
        """.trimIndent(),
        options = listOf(
            "(name)",
            "[name]",
            "%name%",
            "{name}"
        ),
        answerIndex = 3,
        explanation = "In Python f-strings, variables are inserted directly into the string by wrapping them in curly braces {}."
    ),
    Problem(
        id = "order_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Iterating Over a List",
        summary = "A simple for loop that prints each item.",
        prompt = "Arrange these lines to correctly print each fruit from the list.",
        code = "",
        options = listOf(
            "fruits = ['apple', 'banana', 'cherry']",
            "for fruit in fruits:",
            "    print(fruit)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the list of fruits, then set up the for loop to iterate over it, and finally indent the print statement inside the loop."
    ),
    Problem(
        id = "complexity_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Consecutive Loops",
        summary = "Two separate loops running one after the other.",
        prompt = "How many times in total does the word 'Hi' get printed?",
        code = """
            for i in range(2):
                print("Hi")
            for j in range(3):
                print("Hi")
        """.trimIndent(),
        options = listOf(
            "5 times",
            "6 times",
            "3 times",
            "2 times"
        ),
        answerIndex = 0,
        explanation = "These are sequential (not nested) loops. The first loop runs 2 times and the second runs 3 times, for a total of 5 times."
    ),
    Problem(
        id = "trace_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Swap",
        summary = "Swapping variables using a temporary variable.",
        prompt = "What is the final value of the variable 'a'?",
        code = """
            a = 5
            b = 10
            temp = a
            a = b
            b = temp
        """.trimIndent(),
        options = listOf(
            "10",
            "5",
            "None",
            "15"
        ),
        answerIndex = 0,
        explanation = "The value of 'a' (5) is saved in 'temp'. Then 'a' is assigned the value of 'b' (10). Finally, 'b' gets the value of 'temp' (5)."
    ),
    Problem(
        id = "match_easy_student_43",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Repeated String",
        summary = "Multiplying a string by an integer.",
        prompt = "Which code correctly produces the output 'HaHaHa'?",
        code = "",
        options = listOf(
            "'Ha' + 3",
            "'Ha' * 3",
            "'Ha' + 'Ha' + 'Ha'",
            "'Ha' / 3"
        ),
        answerIndex = 1,
        explanation = "In Python, multiplying a string by an integer repeats that string the specified number of times."
    )
)
