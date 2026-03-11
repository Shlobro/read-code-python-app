package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior40 = listOf(
    Problem(
        id = "bug_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Modify set during iteration",
        summary = "Removing elements from a collection while looping over it.",
        prompt = "What goes wrong when this code runs?",
        code = """
            names = {"Alice", "Bob", "Charlie"}
            for name in names:
                if name.startswith("A"):
                    names.remove(name)
        """.trimIndent(),
        options = listOf(
            "It raises a RuntimeError because the set size changes during iteration",
            "It creates an infinite loop because the items are shifted automatically to the front",
            "The `remove` method is not available on Python sets",
            "It skips checking the next element in the set"
        ),
        answerIndex = 0,
        explanation = "Python does not allow changing the size of a set or dictionary while iterating over it."
    ),
    Problem(
        id = "output_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List comprehension scope",
        summary = "A variable is used both outside and inside a list comprehension.",
        prompt = "What does this code print in Python 3?",
        code = """
            x = 10
            nums = [x for x in range(3)]
            print(x)
        """.trimIndent(),
        options = listOf(
            "10",
            "2",
            "3",
            "[0, 1, 2]"
        ),
        answerIndex = 0,
        explanation = "In Python 3, list comprehensions have their own local scope, so the loop variable `x` does not overwrite the outer `x`."
    ),
    Problem(
        id = "purpose_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Invert dictionary",
        summary = "A dictionary comprehension creates a new dictionary from an existing one.",
        prompt = "What is the result of this operation?",
        code = """
            data = {"a": 1, "b": 2}
            result = {v: k for k, v in data.items()}
        """.trimIndent(),
        options = listOf(
            "Swaps keys and values",
            "Iterates through the dictionary and creates a new one by combining both keys and values into a single item",
            "Creates a list of tuples from the dictionary items",
            "Sorts the dictionary by values instead of keys"
        ),
        answerIndex = 0,
        explanation = "The comprehension assigns the old value (`v`) as the new key, and the old key (`k`) as the new value."
    ),
    Problem(
        id = "fill_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Argument unpacking",
        summary = "A list containing two elements needs to be passed to a function expecting two arguments.",
        prompt = "Fill the blank to correctly pass the list elements to the function.",
        code = """
            def multiply(a, b):
                return a * b
                
            nums = [3, 4]
            print(multiply(___))
        """.trimIndent(),
        options = listOf(
            "*nums",
            "nums[0], nums",
            "**nums",
            "nums"
        ),
        answerIndex = 0,
        explanation = "The `*` operator unpacks the list elements so they are passed as separate positional arguments to the function."
    ),
    Problem(
        id = "order_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Safe file reading",
        summary = "Arrange the lines to read a file safely and handle the case where it might be missing.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "try:",
            "    with open(\"data.txt\") as f:",
            "        print(f.read())",
            "except FileNotFoundError:",
            "    print(\"Missing\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The `try` block must contain the `with` statement and file reading, followed by the `except` block to catch the error."
    ),
    Problem(
        id = "complexity_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set lookup performance",
        summary = "A set is used to store valid IDs for checking.",
        prompt = "What is the average time complexity of checking `user_id in valid_ids`?",
        code = """
            valid_ids = set([101, 102, 103])
            def is_valid(user_id):
                return user_id in valid_ids
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(n) where n is the number of valid IDs",
            "O(log n)",
            "O(n^2) because sets use quadratic probing in Python"
        ),
        answerIndex = 0,
        explanation = "Sets in Python are implemented as hash tables, making membership testing O(1) on average."
    ),
    Problem(
        id = "trace_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "String immutability",
        summary = "A substring is extracted and modified.",
        prompt = "What is the value of `text` at the end of the code?",
        code = """
            text = "hello world"
            part = text[0:5]
            part = part.upper()
        """.trimIndent(),
        options = listOf(
            "\"hello world\"",
            "\"HELLO world\"",
            "\"HELLO WORLD\"",
            "\"HELLO\""
        ),
        answerIndex = 0,
        explanation = "Strings are immutable. Operations like slicing and `upper()` create new strings without changing the original `text` variable."
    ),
    Problem(
        id = "match_medium_junior_40",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['Bob', 'Alice']",
        summary = "Pick the code snippet that sorts dictionary keys based on their corresponding values in ascending order.",
        prompt = "Which code correctly prints `['Bob', 'Alice']`?",
        code = "",
        options = listOf(
            "scores = {\"Alice\": 95, \"Bob\": 80}\nprint(sorted(scores, key=scores.get))",
            "scores = {\"Alice\": 95, \"Bob\": 80}\nprint(sorted(scores))",
            "scores = {\"Alice\": 95, \"Bob\": 80}\nresult = []\nfor k, v in scores.items():\n    result.append(v)\nprint(sorted(result))",
            "scores = {\"Alice\": 95, \"Bob\": 80}\nprint(scores.keys().sort())"
        ),
        answerIndex = 0,
        explanation = "Using `sorted()` on a dictionary iterates over its keys. Passing `key=scores.get` sorts those keys based on their values."
    )
)
