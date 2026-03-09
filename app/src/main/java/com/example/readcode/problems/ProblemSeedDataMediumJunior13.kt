package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior13 = listOf(
    Problem(
        id = "bug_medium_junior_13",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Default Mutable Arguments",
        summary = "Using a mutable object as a default argument leads to unexpected behavior.",
        prompt = "Why does `add_to_list` return `[1, 2]` on the second call?",
        code = """
            def add_to_list(val, my_list=[]):
                my_list.append(val)
                return my_list
            
            print(add_to_list(1))
            print(add_to_list(2))
        """.trimIndent(),
        options = listOf(
            "The default list is created only once when the function is defined, and shared across all calls",
            "The second call appends to a globally defined `my_list` variable",
            "Lists in Python do not reset their size unless explicitly cleared",
            "Function arguments are evaluated lazily upon first access"
        ),
        answerIndex = 0,
        explanation = "In Python, default arguments are evaluated at function definition time, not at call time. So the same list instance is used for every call that omits the second argument."
    ),
    Problem(
        id = "output_medium_junior_13",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Scope and Global Variables",
        summary = "Modifying a variable inside a function without the `global` keyword.",
        prompt = "What does this code print?",
        code = """
            count = 0
            def increment():
                count = 1
                return count
            
            increment()
            print(count)
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "Error: UnboundLocalError",
            "None"
        ),
        answerIndex = 0,
        explanation = "Inside `increment()`, `count = 1` creates a new local variable `count` and assigns 1 to it. The global variable `count` remains 0."
    ),
    Problem(
        id = "purpose_medium_junior_13",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Zip with unequal lengths",
        summary = "Combining lists of different sizes using `zip`.",
        prompt = "What does the `zip` function do in this code?",
        code = """
            names = ["Alice", "Bob", "Charlie"]
            ages = [25, 30]
            combined = list(zip(names, ages))
        """.trimIndent(),
        options = listOf(
            "Creates a list of tuples `[('Alice', 25), ('Bob', 30)]`, stopping at the shortest iterable",
            "Raises an exception because the lists have different lengths",
            "Creates a list `[('Alice', 25), ('Bob', 30), ('Charlie', None)]`",
            "Creates a dictionary mapping names to ages"
        ),
        answerIndex = 0,
        explanation = "The `zip()` function stops combining elements as soon as the shortest iterable is exhausted."
    ),
    Problem(
        id = "fill_medium_junior_13",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Generator Expression",
        summary = "Creating a memory-efficient sequence of squares.",
        prompt = "Fill in the blank to create a generator expression.",
        code = """
            squares = ___
            for sq in squares:
                pass
        """.trimIndent(),
        options = listOf(
            "(x * x for x in range(5))",
            "[x * x for x in range(5)]",
            "{x * x for x in range(5)}",
            "list(x * x for x in range(5))"
        ),
        answerIndex = 0,
        explanation = "A generator expression uses parentheses `()` to lazily evaluate items one by one, saving memory compared to a list comprehension `[]`."
    )
)
