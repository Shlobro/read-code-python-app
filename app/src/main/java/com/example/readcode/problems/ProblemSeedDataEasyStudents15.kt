package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents15 = listOf(
    Problem(
        id = "bug_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Scope issue",
        summary = "Trying to access a local variable outside its function.",
        prompt = "Why does this code cause an error?",
        code = """
            def create_greeting(name):
                message = "Hello " + name
                
            print(message)
        """.trimIndent(),
        options = listOf(
            "The variable `message` only exists inside the function",
            "The function is missing a `return` statement",
            "`name` is not defined",
            "You cannot add a string and a variable"
        ),
        answerIndex = 0,
        explanation = "Variables created inside a function are local to that function and cannot be used outside of it."
    ),
    Problem(
        id = "output_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Integer division",
        summary = "Using the `//` operator.",
        prompt = "What does this code print?",
        code = """
            x = 7
            y = 2
            print(x // y)
        """.trimIndent(),
        options = listOf("3", "3.5", "4", "14"),
        answerIndex = 0,
        explanation = "The `//` operator performs floor division, rounding down to the nearest whole number."
    ),
    Problem(
        id = "purpose_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Calculate area",
        summary = "A simple math function.",
        prompt = "What does this function do?",
        code = """
            def calc(w, h):
                return w * h
        """.trimIndent(),
        options = listOf(
            "Calculates the area of a rectangle given width and height",
            "Adds the width and height together",
            "Calculates the perimeter of a rectangle",
            "Finds the largest of the two numbers"
        ),
        answerIndex = 0,
        explanation = "Multiplying width and height computes the area of a rectangle."
    ),
    Problem(
        id = "fill_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "For loop syntax",
        summary = "Iterating over a list of items.",
        prompt = "Which keyword fills the blank to loop over the list?",
        code = """
            colors = ["red", "blue", "green"]
            for color ___ colors:
                print(color)
        """.trimIndent(),
        options = listOf("in", "from", "on", "of"),
        answerIndex = 0,
        explanation = "In Python, `for item in sequence:` is the syntax to loop over elements."
    ),
    Problem(
        id = "order_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap variables",
        summary = "Exchange the values of two variables.",
        prompt = "Arrange the code to swap the values of `a` and `b`.",
        code = """
            a = 5
            b = 10
            # Swap logic below:
        """.trimIndent(),
        options = listOf(
            "temp = a",
            "a = b",
            "b = temp"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "To swap two variables safely without overriding one, you first save one to a temporary variable, then overwrite it, then set the other to the temporary value."
    ),
    Problem(
        id = "complexity_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Loop iterations",
        summary = "Counting how many times a simple loop runs.",
        prompt = "How many times will this loop print 'Hello'?",
        code = """
            for i in range(5):
                print("Hello")
        """.trimIndent(),
        options = listOf("5", "4", "6", "0"),
        answerIndex = 0,
        explanation = "`range(5)` generates the numbers 0, 1, 2, 3, 4, which is exactly 5 items."
    ),
    Problem(
        id = "trace_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Variable updates",
        summary = "Tracking a number as it changes.",
        prompt = "What is the final value of `score`?",
        code = """
            score = 10
            score = score + 5
            score = score * 2
        """.trimIndent(),
        options = listOf("30", "20", "25", "15"),
        answerIndex = 0,
        explanation = "First `score` becomes 10 + 5 = 15. Then it becomes 15 * 2 = 30."
    ),
    Problem(
        id = "match_easy_student_15",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Range list",
        summary = "Creating a list of numbers.",
        prompt = "Which code produces the output: `[0, 1, 2]`?",
        code = "",
        options = listOf(
            "print(list(range(3)))",
            "print(list(range(1, 3)))",
            "print(list(range(4)))",
            "print([1, 2, 3])"
        ),
        answerIndex = 0,
        explanation = "`range(3)` creates a sequence of 0, 1, 2. `list()` converts it to a list."
    )
)
