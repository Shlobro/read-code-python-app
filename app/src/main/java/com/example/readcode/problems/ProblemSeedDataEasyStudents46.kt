package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents46 = listOf(
    Problem(
        id = "bug_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "Failing to indent a block.",
        prompt = "Why does this code cause an error?",
        code = """
            def greet():
            print("Hello")
        """.trimIndent(),
        options = listOf(
            "Missing indentation",
            "The function lacks a return statement inside it",
            "You need to call the function before defining it",
            "The print command requires double quotes always"
        ),
        answerIndex = 0,
        explanation = "Python uses indentation to define code blocks. The body of a function must be indented."
    ),
    Problem(
        id = "output_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Type Conversion",
        summary = "Converting string to integer.",
        prompt = "What is the output?",
        code = """
            x = "10"
            y = int(x) + 5
            print(y)
        """.trimIndent(),
        options = listOf(
            "105",
            "15",
            "Error: cannot add string and int together",
            "Nothing, the program crashes immediately"
        ),
        answerIndex = 1,
        explanation = "The string '10' is converted to the integer 10, then 5 is added to it."
    ),
    Problem(
        id = "purpose_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Modulo Operator",
        summary = "Checking for even numbers.",
        prompt = "What does this code check?",
        code = """
            if num % 2 == 0:
                print("Yes")
        """.trimIndent(),
        options = listOf(
            "It checks if the variable num is an even number",
            "It verifies whether the number is perfectly even",
            "If the number is even",
            "It determines if the number can be divided by two"
        ),
        answerIndex = 2,
        explanation = "The modulo operator (%) returns the remainder. A remainder of 0 when dividing by 2 means the number is even."
    ),
    Problem(
        id = "fill_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "List Length",
        summary = "Finding the size of a list.",
        prompt = "Fill the blank to find the number of elements.",
        code = """
            items = [1, 2, 3]
            size = ___(items)
        """.trimIndent(),
        options = listOf(
            "length",
            "count",
            "size",
            "len"
        ),
        answerIndex = 3,
        explanation = "The len() function returns the number of items in a list or other collection."
    ),
    Problem(
        id = "order_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Simple Conditional",
        summary = "Arranging an if-else statement.",
        prompt = "Arrange these lines to check the age and print a message.",
        code = "",
        options = listOf(
            "age = 18",
            "if age >= 18:",
            "    print('Adult')",
            "else:",
            "    print('Minor')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Set the variable first, check the condition with if, and provide the fallback with else."
    ),
    Problem(
        id = "complexity_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Print Loop",
        summary = "Counting iterations over a short list.",
        prompt = "How many times does the print statement run?",
        code = """
            names = ["Alice", "Bob"]
            for name in names:
                print(name)
        """.trimIndent(),
        options = listOf(
            "It runs exactly twice because there are two names",
            "2",
            "It will execute one time for each item in the list",
            "The loop runs a total of three times overall here"
        ),
        answerIndex = 1,
        explanation = "The loop runs once for every item in the list. Since there are 2 items, it runs 2 times."
    ),
    Problem(
        id = "trace_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable Update",
        summary = "Tracking a variable's value after basic math.",
        prompt = "What is the final value of score?",
        code = """
            score = 0
            score = score + 10
            score = score - 2
        """.trimIndent(),
        options = listOf(
            "It ends up being 8",
            "The value is now 8",
            "8",
            "The final score is 8"
        ),
        answerIndex = 2,
        explanation = "Starts at 0, adds 10 to become 10, then subtracts 2 to become 8."
    ),
    Problem(
        id = "match_easy_student_46",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Basic Print",
        summary = "Outputting a simple string.",
        prompt = "Which code prints 'Python'?",
        code = "",
        options = listOf(
            "print('Python')",
            "console.log('Python');",
            "System.out.println('Python');",
            "document.write('Python');"
        ),
        answerIndex = 0,
        explanation = "In Python, the print() function is used to output text."
    )
)
