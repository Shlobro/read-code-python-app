package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents48 = listOf(
    Problem(
        id = "bug_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Colon",
        summary = "A very common syntax error.",
        prompt = "Why does this code fail to run?",
        code = """
            def greet(name)
                print("Hello " + name)
        """.trimIndent(),
        options = listOf(
            "Missing colon",
            "The print statement needs to use an f-string to work properly in this specific context",
            "You must explicitly declare the type of the name parameter before using it in the function",
            "The string concatenation operator is completely invalid for these particular data types"
        ),
        answerIndex = 0,
        explanation = "Python requires a colon `:` at the end of a function definition."
    ),
    Problem(
        id = "output_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Appending",
        summary = "Adding an item to a list.",
        prompt = "What does this code print?",
        code = """
            nums = [1, 2]
            nums.append(3)
            print(nums)
        """.trimIndent(),
        options = listOf(
            "It will throw an AttributeError because lists do not have an append method in Python",
            "The output will simply be the number 3 because append returns the newly added item",
            "A new list containing only the integer three will be created and subsequently printed",
            "[1, 2, 3]"
        ),
        answerIndex = 3,
        explanation = "The `append` method modifies the list in place by adding the element to the end."
    ),
    Problem(
        id = "purpose_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Check Even",
        summary = "Using the modulo operator.",
        prompt = "What does this function check?",
        code = """
            def is_even(num):
                return num % 2 == 0
        """.trimIndent(),
        options = listOf(
            "If a number is even",
            "It calculates the percentage of the given number and compares it against zero to find a remainder",
            "The function performs a complex mathematical operation to divide the number by two completely",
            "It is designed to automatically convert any odd numbers into even numbers by dividing them by two"
        ),
        answerIndex = 0,
        explanation = "The modulo operator `%` returns the remainder of division. If the remainder is 0 when dividing by 2, it is even."
    ),
    Problem(
        id = "fill_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Print Statement",
        summary = "Displaying text on the screen.",
        prompt = "Fill in the blank to print 'Welcome'.",
        code = """
            ___("Welcome")
        """.trimIndent(),
        options = listOf(
            "The correct way to display output on the screen in Python is to use the console.log method",
            "You should utilize the System.out.println command to properly format and show the text string",
            "print",
            "In order to output text you must first import the standard input output library module"
        ),
        answerIndex = 2,
        explanation = "The `print()` function is used in Python to display output."
    ),
    Problem(
        id = "order_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple Loop",
        summary = "Looping through a list of names.",
        prompt = "Arrange these lines to loop through and print each name.",
        code = "",
        options = listOf(
            "names = ['Alice', 'Bob']",
            "for name in names:",
            "    print(name)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First define the list, then start the for loop, and finally print each item inside the loop."
    ),
    Problem(
        id = "complexity_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List Length",
        summary = "Counting elements in a list.",
        prompt = "How many elements will be printed?",
        code = """
            colors = ["red", "blue", "green"]
            for color in colors:
                print(color)
        """.trimIndent(),
        options = listOf(
            "It prints the entire array object as a single string representation without separating them",
            "The loop continues indefinitely because there is no explicit break condition to terminate it",
            "3",
            "It will only print the very first item and then immediately exit the execution block"
        ),
        answerIndex = 2,
        explanation = "The list has 3 items, so the loop runs 3 times."
    ),
    Problem(
        id = "trace_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Update",
        summary = "Reassigning a variable.",
        prompt = "What is the final value of x?",
        code = """
            x = 5
            x = x + 2
            x = x - 1
        """.trimIndent(),
        options = listOf(
            "The variable x is going to be precisely ten by the time the entire script has finished running",
            "6",
            "It remains exactly five because you cannot simply reassign variables in this specific manner",
            "The output will actually cause an unexpected crash due to mathematical integer type mismatches"
        ),
        answerIndex = 1,
        explanation = "x starts at 5, becomes 7, and finally becomes 6."
    ),
    Problem(
        id = "match_easy_student_48",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String Formatting",
        summary = "Using f-strings.",
        prompt = "Which code produces the output 'Score: 10'?",
        code = "",
        options = listOf(
            "The correct approach is to utilize the older percent formatting syntax to achieve this precise string",
            "You are required to use the format method on the string object passing the score as an argument",
            "score = 10\nprint(f'Score: {score}')",
            "It is necessary to concatenate the string 'Score: ' with the integer 10 after converting it to a string"
        ),
        answerIndex = 2,
        explanation = "An f-string allows embedding expressions inside string literals, using curly braces {}."
    )
)
