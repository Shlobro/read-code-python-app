package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior47 = listOf(
    Problem(
        id = "bug_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Default Mutable Argument",
        summary = "A list is used as a default parameter.",
        prompt = "What is the issue with this function?",
        code = """
            def append_to(num, target=[]):
                target.append(num)
                return target
        """.trimIndent(),
        options = listOf(
            "It creates a new list every time the function is called, ignoring the previous state",
            "The `target` parameter must be initialized with `None` instead of an empty list, otherwise it raises an error",
            "The default list is shared between calls",
            "The function does not return the updated list properly"
        ),
        answerIndex = 2,
        explanation = "Default arguments are evaluated once at definition time. Mutating the list affects future calls that don't provide their own list."
    ),
    Problem(
        id = "output_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Key Override",
        summary = "Duplicate keys in a dictionary literal.",
        prompt = "What gets printed?",
        code = """
            user = {"name": "Alice", "age": 25, "name": "Bob"}
            print(len(user))
        """.trimIndent(),
        options = listOf(
            "3",
            "A dictionary cannot have duplicate keys, so it throws a SyntaxError during runtime",
            "The dictionary will contain three items, but the length function only counts unique keys",
            "2"
        ),
        answerIndex = 3,
        explanation = "Duplicate keys overwrite previous values. The dictionary ends up with only two keys: 'name' and 'age'."
    ),
    Problem(
        id = "purpose_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Unpacking Tuples",
        summary = "Using the starred expression to unpack values.",
        prompt = "What does this code do?",
        code = """
            data = (1, 2, 3)
            a, *b = data
        """.trimIndent(),
        options = listOf(
            "It raises a ValueError because there are too many values to unpack into just two variables",
            "It assigns the first element to `a` and the last element to `b`, completely ignoring the middle elements",
            "Puts 1 in `a` and the rest in `b`",
            "Creates a generator object in `b` that lazily evaluates the remaining elements of the tuple"
        ),
        answerIndex = 2,
        explanation = "The `*b` syntax captures all remaining elements in a list. `a` gets 1, and `b` gets `[2, 3]`."
    ),
    Problem(
        id = "fill_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Check Substring",
        summary = "Checking if a string contains another string.",
        prompt = "Fill the blank to check if the word exists in the text.",
        code = """
            text = "hello world"
            if "world" ____ text:
                print("Found it!")
        """.trimIndent(),
        options = listOf(
            "is inside of",
            "contains",
            "finds itself within",
            "in"
        ),
        answerIndex = 3,
        explanation = "The `in` operator checks for substring membership in Python."
    ),
    Problem(
        id = "order_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Read a File",
        summary = "Opening and reading a file line by line.",
        prompt = "Arrange the lines to correctly read and print the file.",
        code = "",
        options = listOf(
            "with open(\"data.txt\", \"r\") as f:",
            "    lines = f.readlines()",
            "for line in lines:",
            "    print(line.strip())"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First open the file with a context manager, then read the lines, and finally iterate and print them."
    ),
    Problem(
        id = "complexity_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Lookup",
        summary = "Time complexity of getting a value by key.",
        prompt = "What is the average time complexity of this dictionary lookup?",
        code = """
            cache = {"user_1": "Alice", "user_2": "Bob"}
            name = cache.get("user_1")
        """.trimIndent(),
        options = listOf(
            "O(N) because it must iterate over all the keys in the dictionary to find the matching string",
            "O(log N) since Python dictionaries use a binary search tree under the hood for faster access",
            "O(N^2) in the worst case due to the possibility of multiple hash collisions occurring",
            "O(1)"
        ),
        answerIndex = 3,
        explanation = "Python dictionaries are implemented as hash tables, providing O(1) average time complexity for lookups."
    ),
    Problem(
        id = "trace_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Loop Counter",
        summary = "Adding loop variable to a total.",
        prompt = "What is the exact value of `count` after the loop finishes?",
        code = """
            count = 0
            for i in range(3):
                count += i
        """.trimIndent(),
        options = listOf(
            "3",
            "The loop will result in a final value of exactly 4",
            "It throws an error because `count` is not properly initialized before the loop",
            "The final calculated sum of the elements will be 6"
        ),
        answerIndex = 0,
        explanation = "`range(3)` yields 0, 1, and 2. Their sum is 3."
    ),
    Problem(
        id = "match_medium_junior_47",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Filter Evens",
        summary = "Using a list comprehension with a condition.",
        prompt = "Which snippet produces this exact output?\n\n[2, 4]",
        code = "",
        options = listOf(
            "print(list(filter(lambda x: x % 2 == 0, [x for x in range(10) if x > 0 and x < 6])))",
            "result = []\nfor i in range(5):\n    if i % 2 == 0:\n        result.append(i)\nprint(result)",
            "print([number for number in [1, 2, 3, 4, 5] if number % 2 != 0])",
            "print([x for x in range(1, 6) if x % 2 == 0])"
        ),
        answerIndex = 3,
        explanation = "The range `1` to `6` (exclusive) yields 1, 2, 3, 4, 5. The condition `x % 2 == 0` filters it down to 2 and 4."
    )
)
