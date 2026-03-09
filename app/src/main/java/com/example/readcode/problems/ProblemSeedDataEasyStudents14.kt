package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents14 = listOf(
    Problem(
        id = "bug_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing syntax",
        summary = "A structural character is left out.",
        prompt = "Why does this code cause a SyntaxError?",
        code = """
            def say_hello(name)
                print("Hello", name)
        """.trimIndent(),
        options = listOf(
            "There is no colon `:` after the parameter list",
            "`print` needs to return a value",
            "`say_hello` is not a valid function name",
            "The string needs to use single quotes"
        ),
        answerIndex = 0,
        explanation = "In Python, block statements like `def`, `if`, and `for` must end with a colon `:`."
    ),
    Problem(
        id = "output_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Order of operations",
        summary = "Math operations with different priorities.",
        prompt = "What does this code print?",
        code = """
            x = 10
            y = 5
            print(x - y * 2)
        """.trimIndent(),
        options = listOf(
            "0",
            "10",
            "20",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Multiplication happens before subtraction, so `5 * 2` is `10`, and then `10 - 10` is `0`."
    ),
    Problem(
        id = "purpose_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Even or odd",
        summary = "Using the modulo operator.",
        prompt = "What does this function do?",
        code = """
            def check(n):
                if n % 2 == 0:
                    return True
                else:
                    return False
        """.trimIndent(),
        options = listOf(
            "Returns True if the number is even",
            "Returns True if the number is odd",
            "Divides the number by 2",
            "Returns True if the number is positive"
        ),
        answerIndex = 0,
        explanation = "The `% 2` operation gives the remainder when divided by 2. A remainder of 0 means the number is even."
    ),
    Problem(
        id = "fill_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Combining strings together.",
        prompt = "Which string fills the blank to print `Hello World`?",
        code = """
            message = "Hello"
            message = message + " ___"
            print(message)
        """.trimIndent(),
        options = listOf(
            "World",
            "world",
            "Hello",
            "User"
        ),
        answerIndex = 0,
        explanation = "Adding `\" World\"` to `\"Hello\"` creates the exact string `\"Hello World\"`."
    ),
    Problem(
        id = "order_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Ask and greet",
        summary = "Taking user input and showing a result.",
        prompt = "Arrange the code to ask for a name and then greet the user.",
        code = "",
        options = listOf(
            "print(greeting)",
            "name = input(\"Name: \")",
            "greeting = \"Hi, \" + name"
        ),
        answerIndex = -1,
        correctOrder = listOf(1, 2, 0),
        explanation = "You must get the `name` first, then use it to build the `greeting`, and finally `print` the greeting."
    ),
    Problem(
        id = "complexity_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Search a list",
        summary = "Using the `in` keyword on a list.",
        prompt = "How does the time taken by the `in` operator grow as the list gets larger?",
        code = """
            def is_present(target, numbers):
                return target in numbers
        """.trimIndent(),
        options = listOf(
            "Proportional to the number of items (O(N))",
            "It is always instant (O(1))",
            "It grows quadratically (O(N^2))",
            "It grows exponentially (O(2^N))"
        ),
        answerIndex = 0,
        explanation = "Checking if an item is in an unsorted list requires looking at each item one by one, so it takes linear time (O(N))."
    ),
    Problem(
        id = "trace_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Decreasing total",
        summary = "Subtracting from a variable inside a loop.",
        prompt = "What is the value of `total` on the last line?",
        code = """
            total = 10
            for i in [1, 2]:
                total -= i
            # What is total here?
        """.trimIndent(),
        options = listOf(
            "7",
            "10",
            "9",
            "8"
        ),
        answerIndex = 0,
        explanation = "First `total` becomes `10 - 1 = 9`. Then it becomes `9 - 2 = 7`."
    ),
    Problem(
        id = "match_easy_student_14",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print each item",
        summary = "Displaying list items on separate lines.",
        prompt = "Which code produces this output?",
        code = """
            1
            2
            3
        """.trimIndent(),
        options = listOf(
            "for x in [1, 2, 3]:\n    print(x)",
            "print([1, 2, 3])",
            "for x in [1, 2, 3]:\n    print(x, end=\" \")",
            "print(\"1, 2, 3\")"
        ),
        answerIndex = 0,
        explanation = "A `for` loop iterates over the list, and `print()` automatically adds a newline after each item."
    )
)
