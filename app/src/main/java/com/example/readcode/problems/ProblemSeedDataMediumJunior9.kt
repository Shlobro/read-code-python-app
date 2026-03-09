package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior9 = listOf(
    Problem(
        id = "bug_medium_jr9_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Iteration Removal",
        summary = "Modifying a dictionary while iterating over its keys.",
        prompt = "Why does this code crash with a RuntimeError?",
        code = """
            scores = {"Alice": 90, "Bob": 40, "Charlie": 85}
            for name in scores:
                if scores[name] < 50:
                    del scores[name]
        """.trimIndent(),
        options = listOf(
            "You cannot change the size of a dictionary while iterating over it",
            "`del` is not valid for dictionary keys",
            "The loop variable `name` becomes undefined",
            "`scores[name]` is not the correct way to access values"
        ),
        answerIndex = 0,
        explanation = "In Python, modifying the size of a dictionary while iterating over it raises a `RuntimeError`. You should iterate over a copy of the keys, like `list(scores.keys())`."
    ),
    Problem(
        id = "output_medium_jr9_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Default Mutable Arguments",
        summary = "A function appends to a list passed as a default argument.",
        prompt = "What does this code print?",
        code = """
            def add_user(name, users=[]):
                users.append(name)
                return users

            add_user("Alice")
            print(add_user("Bob"))
        """.trimIndent(),
        options = listOf(
            "['Alice', 'Bob']",
            "['Bob']",
            "['Alice']",
            "[]"
        ),
        answerIndex = 0,
        explanation = "Default arguments are evaluated only once when the function is defined. Subsequent calls without the argument share the same mutable list."
    ),
    Problem(
        id = "purpose_medium_jr9_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Zip and Dict Comprehension",
        summary = "Combining two lists into a dictionary.",
        prompt = "What does this snippet do?",
        code = """
            keys = ['a', 'b', 'c']
            values = [1, 2, 3]
            result = {k: v for k, v in zip(keys, values)}
        """.trimIndent(),
        options = listOf(
            "Pairs elements from both lists to create a dictionary",
            "Creates a nested list of pairs",
            "Adds the elements of both lists together",
            "Sorts the keys based on the values"
        ),
        answerIndex = 0,
        explanation = "`zip()` pairs the elements of the two lists, and the dictionary comprehension constructs a dictionary from those pairs."
    ),
    Problem(
        id = "fill_medium_jr9_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "String Formatting",
        summary = "Using f-strings to format output.",
        prompt = "Fill in the blank to print 'Score: 95.50'.",
        code = """
            score = 95.5
            print(f"Score: {score:____}")
        """.trimIndent(),
        options = listOf(
            ".2f",
            "2f",
            "f2",
            ".50"
        ),
        answerIndex = 0,
        explanation = "In Python f-strings, `:.2f` is the format specifier to display a float with exactly 2 decimal places."
    ),
    Problem(
        id = "order_medium_jr9_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Reading CSV Lines",
        summary = "Arrange the lines to correctly process a CSV file skipping the header.",
        prompt = "Tap the lines to arrange the function correctly.",
        code = "",
        options = listOf(
            "def process_csv(filepath):",
            "    with open(filepath, 'r') as f:",
            "        next(f)  # Skip header",
            "        return [line.strip() for line in f]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First define the function, then open the file, call `next()` to consume the header, and finally use a comprehension to read the remaining lines."
    ),
    Problem(
        id = "complex_medium_jr9_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "String Concatenation in Loop",
        summary = "Building a string by concatenating in a loop.",
        prompt = "What is the worst-case time complexity of building this string of length N?",
        code = """
            def build_string(chars):
                result = ""
                for c in chars:
                    result += c
                return result
        """.trimIndent(),
        options = listOf(
            "O(N^2)",
            "O(N)",
            "O(1)",
            "O(log N)"
        ),
        answerIndex = 0,
        explanation = "Because strings are immutable, `result += c` creates a new string every time, copying all previous characters. This results in an O(N^2) time complexity. Using `\"\".join(chars)` is O(N)."
    ),
    Problem(
        id = "trace_medium_jr9_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Variable Scope in Comprehension",
        summary = "Tracing a variable after a list comprehension.",
        prompt = "What is the value of `i` printed at the end?",
        code = """
            i = 10
            squares = [i * i for i in range(3)]
            print(i)
        """.trimIndent(),
        options = listOf(
            "10",
            "2",
            "9",
            "None"
        ),
        answerIndex = 0,
        explanation = "In Python 3, list comprehensions have their own scope. The loop variable `i` inside the comprehension does not leak out and overwrite the outer `i`."
    ),
    Problem(
        id = "match_medium_jr9_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Enumerate with Start",
        summary = "Match the code to the output using enumerate.",
        prompt = "Which code produces this exact output?",
        code = "",
        options = listOf(
            "for i, char in enumerate(['A', 'B'], start=1):\n    print(f'{i}: {char}')",
            "for i, char in enumerate(['A', 'B']):\n    print(f'{i}: {char}')",
            "for i, char in enumerate(['A', 'B'], start=2):\n    print(f'{i}: {char}')",
            "for char in ['A', 'B']:\n    print(f'1: {char}')"
        ),
        answerIndex = 0,
        explanation = "`enumerate(..., start=1)` begins the index counting at 1, which matches the output perfectly."
    )
)