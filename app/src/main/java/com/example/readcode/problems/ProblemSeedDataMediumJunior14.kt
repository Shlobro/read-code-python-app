package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior14 = listOf(
    Problem(
        id = "bug_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late Binding Closures",
        summary = "A list of lambdas captures a loop variable by reference.",
        prompt = "Why does `multipliers[0](2)` return 4 instead of 0?",
        code = """
            def make_multipliers():
                return [lambda x: i * x for i in range(3)]
            
            multipliers = make_multipliers()
            print(multipliers[0](2))
        """.trimIndent(),
        options = listOf(
            "The lambdas capture the loop variable `i` by reference, resolving to its final value of 2",
            "The `range(3)` function generates numbers in reverse order",
            "The loop does not execute fully because `i` is overwritten",
            "Lambdas cannot be created inside a list comprehension"
        ),
        answerIndex = 0,
        explanation = "In Python, closures are late-binding. The lambdas look up the value of `i` in the surrounding scope at the time they are called, when the loop has already finished and `i` is 2."
    ),
    Problem(
        id = "output_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Dictionary Key Hashing",
        summary = "Using equivalent values as dictionary keys.",
        prompt = "What does this code print?",
        code = """
            data = {1: 'a', True: 'b', 1.0: 'c'}
            print(len(data), data[1])
        """.trimIndent(),
        options = listOf(
            "1 c",
            "3 a",
            "3 c",
            "2 b"
        ),
        answerIndex = 0,
        explanation = "In Python, `1`, `True`, and `1.0` evaluate as equal and share the same hash value. They map to the exact same dictionary key, overwriting the value each time."
    ),
    Problem(
        id = "purpose_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Any and All",
        summary = "Combining `any` and `all` with generator expressions.",
        prompt = "What does this function check?",
        code = """
            def check(matrix):
                return all(any(val > 0 for val in row) for row in matrix)
        """.trimIndent(),
        options = listOf(
            "Checks if every row contains at least one positive number",
            "Checks if all numbers in the matrix are positive",
            "Checks if at least one row contains only positive numbers",
            "Checks if any number in the matrix is positive"
        ),
        answerIndex = 0,
        explanation = "The inner `any` checks if a specific row has a positive number. The outer `all` ensures this condition is true for every single row in the matrix."
    ),
    Problem(
        id = "fill_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Unpacking",
        summary = "Passing a dictionary as keyword arguments.",
        prompt = "Fill in the blank to pass the dictionary as keyword arguments.",
        code = """
            def process(a, b, c):
                print(a, b, c)
            
            args = {'a': 1, 'b': 2, 'c': 3}
            process(___)
        """.trimIndent(),
        options = listOf(
            "**args",
            "*args",
            "args",
            "a=args['a'], b=args['b']"
        ),
        answerIndex = 0,
        explanation = "The double asterisk `**` unpacks a dictionary into keyword arguments, mapping dictionary keys to the function's parameter names."
    ),
    Problem(
        id = "order_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Remove Duplicates Preserve Order",
        summary = "Filter a list while keeping the original order of items.",
        prompt = "Arrange the lines to write a function that removes duplicates but preserves order.",
        code = "",
        options = listOf(
            "def unique_elements(items):",
            "    seen = set()",
            "    result = []",
            "    for item in items:",
            "        if item not in seen:",
            "            seen.add(item)",
            "            result.append(item)",
            "    return result"
        ),
        answerIndex = 0, // Ignored for ORDER_STEPS
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "We use a set to track elements we have already encountered in O(1) time, and a list to build the result while keeping the original order."
    ),
    Problem(
        id = "complexity_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Lookup Complexity",
        summary = "Checking the time complexity of looking up items in a set.",
        prompt = "If `queries` has length N and `data_list` has length M, what is the time complexity?",
        code = """
            def find_items(queries, data_list):
                data_set = set(data_list)
                return [q for q in queries if q in data_set]
        """.trimIndent(),
        options = listOf(
            "O(N + M)",
            "O(N * M)",
            "O(N log M)",
            "O(M)"
        ),
        answerIndex = 0,
        explanation = "Converting the list to a set takes O(M) time. Checking for existence in a set takes O(1) time on average, done N times, resulting in O(N + M) total time."
    ),
    Problem(
        id = "trace_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Loop Control Flow",
        summary = "Tracing a variable through `continue` and `break` statements.",
        prompt = "What is the value of `total` after the loop finishes?",
        code = """
            total = 0
            for i in range(5):
                if i % 2 == 0:
                    continue
                total += i
                if total > 2:
                    break
        """.trimIndent(),
        options = listOf(
            "4",
            "3",
            "9",
            "1"
        ),
        answerIndex = 0,
        explanation = "For `i=1`, `total` becomes 1. For `i=2`, the loop continues. For `i=3`, `total` becomes 4, which triggers the `break`, ending the loop. The final value is 4."
    ),
    Problem(
        id = "match_medium_junior_14",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "String to List",
        summary = "Converting a string into a list of characters.",
        prompt = "Which code produces this output: `['a', 'b', 'c']`?",
        code = "",
        options = listOf(
            "print(list(\"abc\"))",
            "print(\"abc\".split())",
            "print(['a', 'b'] + 'c')",
            "print(list('a', 'b', 'c'))"
        ),
        answerIndex = 0,
        explanation = "Calling `list()` on an iterable like a string converts it into a list of its individual elements (characters)."
    )
)
