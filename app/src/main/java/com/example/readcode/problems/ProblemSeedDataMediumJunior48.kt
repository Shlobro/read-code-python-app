package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior48 = listOf(
    Problem(
        id = "bug_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Iterating and Modifying",
        summary = "Removing items from a list while iterating over it.",
        prompt = "What is the issue with this function?",
        code = """
            def remove_evens(numbers):
                for n in numbers:
                    if n % 2 == 0:
                        numbers.remove(n)
                return numbers
        """.trimIndent(),
        options = listOf(
            "The `remove()` function creates a completely new copy of the list every time it is called, making the operation extremely slow and memory intensive",
            "It skips elements because the list shifts during iteration",
            "The loop will result in an infinite cycle because modifying the list length continuously resets the internal loop counter back to zero",
            "You cannot call `remove()` inside a `for` loop without explicitly casting the iterable to a different type before modifying it"
        ),
        answerIndex = 1,
        explanation = "Removing elements from a list while iterating over it causes the internal index to shift, resulting in skipped elements."
    ),
    Problem(
        id = "output_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Nested List Multiplication",
        summary = "Multiplying a list containing a mutable object.",
        prompt = "What gets printed?",
        code = """
            matrix = [[0] * 2] * 2
            matrix[0][0] = 1
            print(matrix)
        """.trimIndent(),
        options = listOf(
            "[[1, 0], [1, 0]]",
            "[[1, 0], [0, 0]]",
            "The program will output a single flat list instead of a nested one because of the multiplication operator",
            "It throws an IndexError because the multidimensional array was not properly initialized before assignment"
        ),
        answerIndex = 0,
        explanation = "Multiplying a list containing a list creates shallow copies of the inner list. Modifying one modifies all references."
    ),
    Problem(
        id = "purpose_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Comprehension",
        summary = "A list comprehension with two for-clauses.",
        prompt = "What does this code do?",
        code = """
            def process(items):
                return [x for row in items for x in row]
        """.trimIndent(),
        options = listOf(
            "The code calculates the sum of all elements within a complex deeply nested data structure and returns a single integer",
            "It creates a nested list of elements by duplicating the elements inside the existing inner lists twice",
            "This function filters out all empty sub-lists from the provided 2D array, ensuring only populated sequences remain",
            "It converts a 2D list into a flat 1D list"
        ),
        answerIndex = 3,
        explanation = "This list comprehension iterates over each row, and then over each item in the row, flattening a 2D list."
    ),
    Problem(
        id = "fill_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Handling Missing Keys",
        summary = "Using try-except to handle dictionary lookups.",
        prompt = "Fill the blank to handle the missing dictionary key.",
        code = """
            def fetch_data(key, data):
                try:
                    return data[key]
                ____ KeyError:
                    return "Not Found"
        """.trimIndent(),
        options = listOf(
            "catch",
            "handle exception as",
            "except",
            "on error resume next for"
        ),
        answerIndex = 2,
        explanation = "In Python, exceptions are caught using the `except` keyword."
    ),
    Problem(
        id = "order_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Class Definition",
        summary = "Defining a basic class and its initializer.",
        prompt = "Arrange the lines to correctly define the Server class.",
        code = "",
        options = listOf(
            "class Server:",
            "    def __init__(self, host):",
            "        self.host = host",
            "        self.active = False"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First define the class, then the `__init__` method, and finally assign the instance variables inside it."
    ),
    Problem(
        id = "complexity_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Membership",
        summary = "Finding duplicates using a set.",
        prompt = "What is the time complexity of the `has_duplicate` function?",
        code = """
            def has_duplicate(data):
                seen = set()
                for item in data:
                    if item in seen:
                        return True
                    seen.add(item)
                return False
        """.trimIndent(),
        options = listOf(
            "O(1) because sets inherently prevent duplicates from ever being added",
            "O(N^2) since membership checking in a Python set takes linear time and we do it inside a loop",
            "O(N)",
            "O(N log N) because the elements must be sorted internally before they can be placed into the hash set structure"
        ),
        answerIndex = 2,
        explanation = "The function iterates through the list once. Set lookups and insertions are O(1) on average, making the overall complexity O(N)."
    ),
    Problem(
        id = "trace_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Updates",
        summary = "Modifying values in a dictionary during iteration.",
        prompt = "What is the exact value of `scores['B']` after the loop finishes?",
        code = """
            scores = {'A': 10, 'B': 20}
            for k in scores.keys():
                scores[k] += 5
        """.trimIndent(),
        options = listOf(
            "The loop raises a RuntimeError because you are modifying a dictionary's values while iterating over its keys, which is strictly prohibited",
            "25",
            "The value becomes undefined because dictionary iterations in Python do not guarantee any specific ordering",
            "20"
        ),
        answerIndex = 1,
        explanation = "Iterating over keys allows you to modify the corresponding values. `scores['B']` starts at 20 and is incremented by 5."
    ),
    Problem(
        id = "match_medium_junior_48",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Zipping Lists",
        summary = "Combining two lists into pairs.",
        prompt = "Which snippet produces this exact output?\n\n[('a', 1), ('b', 2)]",
        code = "",
        options = listOf(
            "print([(k, v) for k, v in enumerate(['a', 'b'], start=1)])",
            "result = []\nfor i in range(2):\n    result.append((['a', 'b'][i], [1, 2][i]))\nprint(list(result.items()))",
            "print(list(zip(['a', 'b'], [1, 2])))",
            "print(dict(zip(['a', 'b'], [1, 2])).items())"
        ),
        answerIndex = 2,
        explanation = "The `zip()` function pairs up corresponding elements from the two lists, and `list()` converts the zip object to a list of tuples."
    )
)
