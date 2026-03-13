package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents47 = listOf(
    Problem(
        id = "bug_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "String Multiplication",
        summary = "Trying to repeat a string the wrong way.",
        prompt = "Why does this code throw an error?",
        code = """
            text = "Hi"
            print(text + 3)
        """.trimIndent(),
        options = listOf(
            "Cannot add int to string",
            "The text string should not start with an uppercase letter H at all",
            "You need to convert the text to an integer before adding three to it",
            "The print statement is completely incorrect and should be rewritten"
        ),
        answerIndex = 0,
        explanation = "In Python, use '*' to repeat a string. '+' is only for concatenating strings."
    ),
    Problem(
        id = "output_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Floor Division",
        summary = "Using the double slash operator.",
        prompt = "What does this code output?",
        code = """
            x = 5
            y = 2
            print(x // y)
        """.trimIndent(),
        options = listOf(
            "This will output the number 2.5 because it does floating point division",
            "It will throw an error since you cannot divide these variables in Python",
            "It gives 2.5",
            "2"
        ),
        answerIndex = 3,
        explanation = "The // operator performs floor division, so 5 // 2 is 2."
    ),
    Problem(
        id = "purpose_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Accumulator Pattern",
        summary = "Adding numbers in a loop.",
        prompt = "What is the overall purpose of this loop?",
        code = """
            total = 0
            for n in [10, 20, 30]:
                total += n
        """.trimIndent(),
        options = listOf(
            "It iterates through the provided numbers and multiplies them together",
            "It creates a new list containing only the positive integers from the given list",
            "It finds the maximum value present within the provided list of integers",
            "Calculates the sum"
        ),
        answerIndex = 3,
        explanation = "It iterates through the list, adding each number to 'total'."
    ),
    Problem(
        id = "fill_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String Slicing",
        summary = "Extracting part of a string.",
        prompt = "Fill the blank to print only 'World'.",
        code = """
            greeting = "Hello World"
            print(greeting[___])
        """.trimIndent(),
        options = listOf(
            "It is necessary to use index 6 to 11 to extract the second word",
            "You should use the split function instead of attempting to slice",
            "6:",
            "The correct way is to use a negative index to slice from the end"
        ),
        answerIndex = 2,
        explanation = "Slicing [6:] starts at index 6 ('W') and goes to the end of the string."
    ),
    Problem(
        id = "order_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Return Boolean",
        summary = "A function that returns True or False.",
        prompt = "Arrange these lines to create a function that checks if a number is positive.",
        code = "",
        options = listOf(
            "def is_positive(num):",
            "    if num > 0:",
            "        return True",
            "    else:",
            "        return False"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the function, then check the condition, return True if met, else return False."
    ),
    Problem(
        id = "complexity_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Early Break",
        summary = "Stopping a loop prematurely.",
        prompt = "How many times does the print statement run?",
        code = """
            items = ["apple", "banana", "cherry"]
            for item in items:
                print(item)
                break
        """.trimIndent(),
        options = listOf(
            "1",
            "It iterates over every single item present in the entire list structure completely",
            "The loop will actually execute exactly three times because there are three strings",
            "An infinite loop is created which causes it to run forever until the program crashes"
        ),
        answerIndex = 0,
        explanation = "The 'break' statement stops the loop immediately after the first iteration."
    ),
    Problem(
        id = "trace_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Swapping Values",
        summary = "Variables changing values step by step.",
        prompt = "What is the final value of b?",
        code = """
            a = 10
            b = 5
            a = a - b
            b = a + b
        """.trimIndent(),
        options = listOf(
            "b becomes exactly 5 after the code finishes",
            "The variable b will ultimately hold the value of fifteen at the end",
            "b is unchanged and remains 5 throughout the entire script execution",
            "10"
        ),
        answerIndex = 3,
        explanation = "'a' becomes 5 (10 - 5). Then 'b' becomes 10 (5 + 5)."
    ),
    Problem(
        id = "match_easy_student_47",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Generate Sequence",
        summary = "Creating a list of numbers.",
        prompt = "Which code produces the output `[0, 1, 2]`?",
        code = "",
        options = listOf(
            "list(range(3))",
            "This creates a list containing the numbers one, two, and three in that order",
            "You would need to use a while loop that appends numbers to an empty list manually",
            "The range function is called with the arguments one and four to generate the list"
        ),
        answerIndex = 0,
        explanation = "range(3) produces the sequence 0, 1, 2. Using list() converts it into a list."
    )
)
