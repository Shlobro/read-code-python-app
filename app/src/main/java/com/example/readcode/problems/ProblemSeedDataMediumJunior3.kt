package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior3 = listOf(
    Problem(
        id = "bug_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Late-binding closures",
        summary = "A list of lambdas captures a loop variable incorrectly.",
        prompt = "What is the bug in this lambda factory?",
        code = """
            def make_multipliers():
                return [lambda x: i * x for i in range(3)]

            multipliers = make_multipliers()
            print(multipliers[0](2))
        """.trimIndent(),
        options = listOf(
            "All lambdas capture the same final value of `i`, so it prints 4",
            "It correctly captures `i=0`, so it prints 0",
            "`i` is undefined inside the lambda",
            "The list comprehension cannot contain lambda functions"
        ),
        answerIndex = 0,
        explanation = "In Python, closures are late-binding. All lambdas refer to the same variable `i`, which is 2 after the loop finishes. Calling any of them with 2 results in 2 * 2 = 4."
    ),
    Problem(
        id = "output_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary unpacking",
        summary = "Merging dictionaries with overlapping keys.",
        prompt = "What does this code print?",
        code = """
            defaults = {"theme": "light", "port": 8080}
            config = {"port": 9000, "debug": True}
            final_config = {**defaults, **config}
            print(final_config["port"])
        """.trimIndent(),
        options = listOf(
            "9000",
            "8080",
            "Error: duplicate key 'port'",
            "None"
        ),
        answerIndex = 0,
        explanation = "When unpacking dictionaries using `**`, later dictionaries overwrite earlier ones for overlapping keys, so `config`'s port 9000 overrides 8080."
    ),
    Problem(
        id = "purpose_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary setdefault",
        summary = "Grouping items dynamically.",
        prompt = "What does this loop do?",
        code = """
            words = ["apple", "bat", "art", "box"]
            grouped = {}
            for word in words:
                grouped.setdefault(word[0], []).append(word)
        """.trimIndent(),
        options = listOf(
            "It groups words by their first letter into a dictionary of lists",
            "It creates a list of all first letters",
            "It maps each first letter to the last word that starts with it",
            "It removes duplicate words that start with the same letter"
        ),
        answerIndex = 0,
        explanation = "`setdefault` returns the list for the given letter, creating an empty one first if it doesn't exist, which allows grouping directly."
    ),
    Problem(
        id = "fill_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting by key",
        summary = "Sorting a list of dictionaries.",
        prompt = "Fill in the blank to sort the list by age.",
        code = """
            users = [{"name": "Alice", "age": 30}, {"name": "Bob", "age": 25}]
            users.sort(key=lambda u: ____)
        """.trimIndent(),
        options = listOf(
            "u[\"age\"]",
            "u.age",
            "age",
            "u(age)"
        ),
        answerIndex = 0,
        explanation = "Because the items are dictionaries, we must use dictionary indexing `u[\"age\"]` to access the value, not dot notation."
    ),
    Problem(
        id = "order_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Safe File Reading",
        summary = "Arrange the lines to read a file safely and filter out empty lines.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def read_non_empty(path):",
            "    with open(path, 'r') as f:",
            "        lines = f.readlines()",
            "    return [l for l in lines if l.strip()]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "Define the function, open the file using a context manager, read the lines inside the block, and finally return the filtered list outside the block."
    ),
    Problem(
        id = "complexity_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "List membership testing",
        summary = "Evaluating the performance of the `in` operator.",
        prompt = "What is the time complexity of `is_present` with respect to `n = len(items)`?",
        code = """
            def is_present(items, target):
                return target in items
        """.trimIndent(),
        options = listOf(
            "O(N) because searching a list requires checking each element one by one",
            "O(1) because Python lists are implemented as hash tables",
            "O(log N) because the list is sorted",
            "O(N^2) because of the `in` operator"
        ),
        answerIndex = 0,
        explanation = "Checking membership in a Python list requires scanning the elements linearly, making it O(N) where N = len(items). A `set` would offer O(1) average-case lookups."
    ),
    Problem(
        id = "trace_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Variable shadowing in scope",
        summary = "Tracking nonlocal variable changes.",
        prompt = "What is the value of `x` returned by `outer()`?",
        code = """
            x = 10
            def outer():
                x = 20
                def inner():
                    nonlocal x
                    x += 5
                inner()
                return x
        """.trimIndent(),
        options = listOf(
            "25",
            "10",
            "15",
            "20"
        ),
        answerIndex = 0,
        explanation = "The `nonlocal` keyword allows `inner()` to modify the `x` in `outer()`'s scope (which is 20). 20 + 5 becomes 25, which is then returned."
    ),
    Problem(
        id = "match_medium_junior_3",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Zipping lists of unequal length",
        summary = "Which code handles lists of different sizes correctly?",
        prompt = "Which code produces `[('A', 1), ('B', 2)]`?",
        code = "",
        options = listOf(
            "print(list(zip(['A', 'B', 'C'], [1, 2])))",
            "print(list(zip([1, 2, 3], ['A', 'B'])))",
            "print(list(itertools.product(['A', 'B', 'C'], [1, 2])))",
            "print(list(['A', 'B'] + [1, 2]))"
        ),
        answerIndex = 0,
        explanation = "`zip` stops at the shortest iterable. So zipping a list of 3 with a list of 2 results in exactly 2 pairs, matching the elements in order."
    )
)
