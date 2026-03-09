package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents10 = listOf(
    Problem(
        id = "bug_easy_student_10_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Loop limits",
        summary = "Range stops before the second argument.",
        prompt = "Why does this loop fail to print 5?",
        code = """
            # Print numbers 1 through 5
            for i in range(1, 5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "`range(1, 5)` stops at 4, not 5",
            "The loop starts at 0",
            "`print(i)` needs quotes",
            "You cannot use `1` in `range()`"
        ),
        answerIndex = 0,
        explanation = "The `range(start, stop)` function in Python generates numbers up to, but not including, the `stop` value."
    ),
    Problem(
        id = "output_easy_student_10_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Division results",
        summary = "Using the `//` operator in Python.",
        prompt = "What does this code print?",
        code = """
            apples = 10
            people = 3
            print(apples // people)
        """.trimIndent(),
        options = listOf(
            "3",
            "3.333",
            "1",
            "10"
        ),
        answerIndex = 0,
        explanation = "The `//` operator performs floor division, which drops any remainder and returns an integer."
    ),
    Problem(
        id = "purpose_easy_student_10_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Variable swap",
        summary = "Reassigning two variables at once.",
        prompt = "What does this code accomplish?",
        code = """
            a = 5
            b = 10
            a, b = b, a
        """.trimIndent(),
        options = listOf(
            "Swaps the values of `a` and `b`",
            "Sets both `a` and `b` to 10",
            "Sets both `a` and `b` to 5",
            "Adds `a` and `b` together"
        ),
        answerIndex = 0,
        explanation = "Python evaluates the right side `(b, a)` as a tuple first, then unpacks those values into `a` and `b`, cleanly swapping them."
    ),
    Problem(
        id = "fill_easy_student_10_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Even check",
        summary = "Using modulo to find even numbers.",
        prompt = "Which operator checks if the number is even?",
        code = """
            num = 4
            is_even = (num ___ 2 == 0)
            print(is_even)
        """.trimIndent(),
        options = listOf(
            "%",
            "/",
            "//",
            "**"
        ),
        answerIndex = 0,
        explanation = "The `%` (modulo) operator returns the remainder of division. If `num % 2` is 0, the number is evenly divisible by 2."
    ),
    Problem(
        id = "order_easy_student_10_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Age checker",
        summary = "A basic conditional block.",
        prompt = "Arrange the code to form a complete if/else statement.",
        code = "",
        options = listOf(
            "age = 18",
            "if age >= 18:",
            "    print(\"Adult\")",
            "else:",
            "    print(\"Minor\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Variables must be defined before use. The `if` statement checks the condition, followed by an indented block, then the `else` with its own indented block."
    ),
    Problem(
        id = "complexity_easy_student_10_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "List lookup",
        summary = "Finding an item when the index is known.",
        prompt = "How fast is looking up an item by its index?",
        code = """
            names = ["Alice", "Bob", "Charlie"]
            print(names[1])
        """.trimIndent(),
        options = listOf(
            "O(1) because lists use continuous memory to jump right to the index",
            "O(N) because it checks each item until it finds index 1",
            "O(log N) because it splits the list in half",
            "O(N^2) because strings are complex"
        ),
        answerIndex = 0,
        explanation = "Arrays and Python lists store references in continuous memory, allowing the program to calculate the exact location of any index immediately (O(1))."
    ),
    Problem(
        id = "trace_easy_student_10_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Loop counter",
        summary = "Watching a variable change inside a loop.",
        prompt = "What is the value of `count` after the loop finishes?",
        code = """
            count = 0
            while count < 3:
                count += 1
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "4",
            "0"
        ),
        answerIndex = 0,
        explanation = "The loop runs for `count` = 0, 1, and 2. When `count` becomes 3, the condition `count < 3` becomes false, and the loop stops. The final value is 3."
    ),
    Problem(
        id = "match_easy_student_10_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List formatting",
        summary = "Printing the list directly vs joining.",
        prompt = "Which code prints `[1, 2, 3]` exactly as shown?",
        code = "",
        options = listOf(
            "print([1, 2, 3])",
            "print(\"1, 2, 3\")",
            "print(1, 2, 3)",
            "print(\"1\" + \"2\" + \"3\")"
        ),
        answerIndex = 0,
        explanation = "Passing a Python list directly to `print()` outputs it with square brackets and commas, just like its literal representation."
    )
)
