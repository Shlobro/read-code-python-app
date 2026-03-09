package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior17 = listOf(
    Problem(
        id = "bug_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Incorrect Default Value in Dictionary",
        summary = "Trying to append to a missing list in a dictionary.",
        prompt = "Why does this code fail to store the user in the dictionary?",
        code = """
            groups = {}
            user = "Alice"
            role = "Admin"
            
            groups.get(role, []).append(user)
            print(groups)
        """.trimIndent(),
        options = listOf(
            ".get() returns a new list but does not store it in the dictionary",
            "The dictionary is immutable",
            "You cannot append to a list in a dictionary",
            "The key 'Admin' is an invalid string"
        ),
        answerIndex = 0,
        explanation = "Using `.get(role, [])` creates a temporary list if the key doesn't exist, but it doesn't add that list back into the dictionary. The user is appended to the temporary list which is then immediately discarded. `setdefault()` or `collections.defaultdict` should be used instead."
    ),
    Problem(
        id = "output_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "String Splitting Edge Case",
        summary = "Splitting a string with consecutive delimiters.",
        prompt = "What does this code print?",
        code = """
            data = "apple,,banana"
            parts = data.split(",")
            print(len(parts))
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "1",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `split(\",\")` method treats consecutive commas as having an empty string between them. It returns `['apple', '', 'banana']`, which has a length of 3."
    ),
    Problem(
        id = "purpose_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Any Function Usage",
        summary = "Checking conditions across a list.",
        prompt = "What does this code evaluate?",
        code = """
            scores = [45, 80, 65, 92]
            result = any(score > 90 for score in scores)
        """.trimIndent(),
        options = listOf(
            "It checks if at least one score is greater than 90",
            "It checks if all scores are greater than 90",
            "It returns the first score greater than 90",
            "It filters the list to only include scores greater than 90"
        ),
        answerIndex = 0,
        explanation = "The `any()` function returns `True` if at least one element in the iterable is true. The generator expression checks each score against the condition."
    ),
    Problem(
        id = "fill_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Zip Function",
        summary = "Combining two lists element by element.",
        prompt = "Fill in the blank to pair names with their ages.",
        code = """
            names = ["Alice", "Bob"]
            ages = [25, 30]
            pairs = list(___(names, ages))
        """.trimIndent(),
        options = listOf(
            "zip",
            "map",
            "join",
            "combine"
        ),
        answerIndex = 0,
        explanation = "The `zip()` function takes iterables and aggregates them in a tuple, returning an iterator of tuples where the i-th tuple contains the i-th element from each of the argument sequences."
    ),
    Problem(
        id = "order_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Try-Except Block",
        summary = "Handling an exception when parsing an integer.",
        prompt = "Arrange the lines to correctly handle a potential ValueError.",
        code = "",
        options = listOf(
            "user_input = '10a'",
            "try:",
            "    number = int(user_input)",
            "except ValueError:",
            "    print('Invalid number')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the input, then open the `try` block, attempt the potentially failing conversion inside it, catch the specific exception with `except ValueError:`, and finally handle it."
    ),
    Problem(
        id = "complexity_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Lookup Complexity",
        summary = "Time complexity of checking if a key exists.",
        prompt = "What is the average time complexity of checking if a key exists in a Python dictionary?",
        code = """
            user_data = {'id': 101, 'name': 'Alice'}
            has_id = 'id' in user_data
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(N)",
            "O(log N)",
            "O(N^2)"
        ),
        answerIndex = 0,
        explanation = "Python dictionaries are implemented as hash tables. The average time complexity for checking membership (key existence) is O(1)."
    ),
    Problem(
        id = "trace_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Variable Scope in Comprehension",
        summary = "Tracing a variable after a list comprehension.",
        prompt = "What is the value of `i` after the list comprehension executes?",
        code = """
            i = 10
            squares = [i * i for i in range(3)]
        """.trimIndent(),
        options = listOf(
            "10",
            "2",
            "9",
            "3"
        ),
        answerIndex = 0,
        explanation = "In Python 3, the loop variable in a list comprehension is local to the comprehension itself and does not overwrite variables with the same name in the enclosing scope."
    ),
    Problem(
        id = "match_medium_junior_17",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "String Formatting",
        summary = "Using f-strings for number formatting.",
        prompt = "Which code produces this output: `Price: 10.50`?",
        code = "",
        options = listOf(
            "price = 10.5\nprint(f\"Price: {price:.2f}\")",
            "price = 10.5\nprint(f\"Price: {price}\")",
            "price = 10.5\nprint(\"Price: \" + price)",
            "price = 10.5\nprint(f\"Price: {price:2}\")"
        ),
        answerIndex = 0,
        explanation = "The f-string format specifier `:.2f` ensures the floating-point number is formatted with exactly two decimal places."
    )
)