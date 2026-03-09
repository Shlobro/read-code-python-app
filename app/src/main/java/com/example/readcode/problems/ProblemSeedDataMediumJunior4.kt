package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior4 = listOf(
    Problem(
        id = "bug_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Iteration",
        summary = "Modifying dictionary size during iteration.",
        prompt = "Why does this code crash?",
        code = """
            cache = {"a": 1, "b": 2}
            for k, v in cache.items():
                if v == 1:
                    cache["c"] = 3
            print(cache)
        """.trimIndent(),
        options = listOf(
            "Dictionary changed size during iteration",
            "Keys cannot be added inside a loop",
            "Values in a dictionary cannot be modified during iteration",
            "The loop must iterate over `cache.keys()` to add elements"
        ),
        answerIndex = 0,
        explanation = "In Python, adding or removing items from a dictionary while iterating over it raises a `RuntimeError`."
    ),
    Problem(
        id = "output_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "zip truncates at shortest iterable",
        summary = "zip stops producing pairs as soon as any one of its iterables is exhausted.",
        prompt = "What is the output of this code?",
        code = """
            names = ['Alice', 'Bob', 'Carol']
            scores = [95, 80]

            for name, score in zip(names, scores):
                print(f'{name}: {score}')
        """.trimIndent(),
        options = listOf(
            "Alice: 95\nBob: 80",
            "Alice: 95\nBob: 80\nCarol: None",
            "Alice: 95\nBob: 80\nCarol: ",
            "ValueError"
        ),
        answerIndex = 0,
        explanation = "`zip` stops as soon as the shortest iterable (`scores`, with 2 elements) is exhausted. `Carol` has no matching score, so it is silently dropped. If you need to pad shorter iterables use `itertools.zip_longest`."
    ),
    Problem(
        id = "purpose_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Flatten a Matrix",
        summary = "Nested list comprehension to flatten a 2D list.",
        prompt = "What does this list comprehension do?",
        code = """
            matrix = [[1, 2], [3, 4]]
            flattened = [num for row in matrix for num in row]
        """.trimIndent(),
        options = listOf(
            "Flattens the 2D matrix into a 1D list `[1, 2, 3, 4]`",
            "Creates a transposed matrix `[[1, 3], [2, 4]]`",
            "Sums the numbers in each row `[3, 7]`",
            "Raises a SyntaxError because of multiple `for` clauses"
        ),
        answerIndex = 0,
        explanation = "The nested list comprehension evaluates from left to right, iterating through each row and then each number, flattening the 2D list into a single list."
    ),
    Problem(
        id = "fill_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Catching Multiple Exceptions",
        summary = "Catching more than one exception type in a single `except` block.",
        prompt = "Fill in the blank to catch both `ValueError` and `ZeroDivisionError`.",
        code = """
            raw = input("Enter a number: ")
            try:
                divisor = int(raw)
                result = 100 / divisor
            except ____:
                print("Invalid input or division by zero")
        """.trimIndent(),
        options = listOf(
            "(ValueError, ZeroDivisionError)",
            "ValueError, ZeroDivisionError",
            "[ValueError, ZeroDivisionError]",
            "ValueError or ZeroDivisionError"
        ),
        answerIndex = 0,
        explanation = "To catch multiple exceptions in a single `except` statement, you must provide them as a tuple."
    ),
    Problem(
        id = "order_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Class Method Definition",
        summary = "Arrange the lines to define a class with a method.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "class Person:",
            "    def __init__(self, name):",
            "        self.name = name",
            "    def greet(self):",
            "        print(f\"Hi, I am {self.name}\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the class first, followed by the `__init__` constructor, its body, then the `greet` method and its body."
    ),
    Problem(
        id = "complexity_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "join vs repeated concatenation",
        summary = "Compare the total characters copied by join versus repeated concatenation for n equal-length fragments.",
        prompt = "Assume n fragments each of length k. How many total characters are copied by repeated `+=` versus `''.join(parts)`?",
        code = """
            # Approach A
            result = ""
            for s in parts:   # n strings, each length k
                result += s

            # Approach B
            result = "".join(parts)
        """.trimIndent(),
        options = listOf(
            "A copies O(n²·k) characters; B copies O(n·k) characters",
            "Both copy O(n·k) characters",
            "A copies O(n·k) characters; B copies O(n²·k) characters",
            "A copies O(n·log n·k) characters; B copies O(n·k) characters"
        ),
        answerIndex = 0,
        explanation = "Each `+=` in approach A creates a new string containing all characters accumulated so far. After i iterations the result has i·k characters, so iteration i copies i·k characters. Summing from 1 to n gives k·(1+2+…+n) = O(n²·k) total characters copied. `''.join(parts)` makes a single allocation of n·k characters and copies each fragment once, so it copies exactly O(n·k) characters regardless of Python version."
    ),
    Problem(
        id = "trace_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "List Reference",
        summary = "Modifying a list through an aliased reference.",
        prompt = "What is the value of `a` after the code runs?",
        code = """
            a = [1, 2, 3]
            b = a
            b.append(4)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 4]",
            "[1, 2, 3]",
            "[4]",
            "[1, 2, 3, [4]]"
        ),
        answerIndex = 0,
        explanation = "Both `a` and `b` reference the same list object in memory. Appending to `b` mutates the list, so `a` also reflects the change."
    ),
    Problem(
        id = "match_medium_junior_4",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'x': 2, 'y': 1}",
        summary = "Which snippet builds a dictionary with these counts?",
        prompt = "Which code produces `{'x': 2, 'y': 1}`?",
        code = "",
        options = listOf(
            "print(dict(x=2, y=1))",
            "print(dict(\"x\"=2, \"y\"=1))",
            "print({\"x\": 1, \"y\": 2})",
            "print(dict([(\"x\", 1), (\"y\", 2)]))"
        ),
        answerIndex = 0,
        explanation = "Keyword arguments in `dict()` are treated as string keys. `dict(x=2, y=1)` creates `{'x': 2, 'y': 1}`. The second option causes a syntax error."
    )
)
