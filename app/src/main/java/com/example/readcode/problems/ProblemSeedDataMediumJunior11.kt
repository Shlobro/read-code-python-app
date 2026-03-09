package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior11 = listOf(
    Problem(
        id = "bug_medium_jr11_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Modification",
        summary = "Changing size during iteration.",
        prompt = "Why does this code throw an error?",
        code = """
            user_roles = {"alice": "admin", "bob": "user"}
            for user, role in user_roles.items():
                if role == "user":
                    del user_roles[user]
        """.trimIndent(),
        options = listOf(
            "Modifying a dictionary's size while iterating over it raises a RuntimeError",
            "The `del` keyword cannot remove keys from a dictionary",
            "`user_roles.items()` only returns keys, not values",
            "The condition `role == \"user\"` is always False"
        ),
        answerIndex = 0,
        explanation = "Python does not allow the size of a dictionary to change while iterating over it. You must iterate over a copy of the keys or items if you want to delete entries."
    ),
    Problem(
        id = "output_medium_jr11_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Tuple Unpacking",
        summary = "Catching remaining elements.",
        prompt = "What does this code print?",
        code = """
            def get_coordinates():
                return 10, 20, 30

            x, *y = get_coordinates()
            print(y)
        """.trimIndent(),
        options = listOf(
            "[20, 30]",
            "(20, 30)",
            "20",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Using the `*` operator during assignment collects the remaining unpacked values into a list. So `y` becomes `[20, 30]`."
    ),
    Problem(
        id = "purpose_medium_jr11_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Conditional Comprehension",
        summary = "Filtering and mapping in one step.",
        prompt = "What does this function do?",
        code = """
            def transform(words):
                return [w.upper() for w in words if len(w) > 3]
        """.trimIndent(),
        options = listOf(
            "Returns uppercase versions of words longer than 3 characters",
            "Returns uppercase versions of the first 3 words",
            "Returns words that contain uppercase letters",
            "Removes words longer than 3 characters and capitalizes the rest"
        ),
        answerIndex = 0,
        explanation = "The list comprehension iterates over `words`, filters for those where `len(w) > 3`, and calls `.upper()` on the matching strings."
    ),
    Problem(
        id = "fill_medium_jr11_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "String Joining",
        summary = "Combining a list of strings.",
        prompt = "Which method fills the blank to produce \"apple, banana, cherry\"?",
        code = """
            items = ["apple", "banana", "cherry"]
            result = ", ".____(items)
            print(result)
        """.trimIndent(),
        options = listOf(
            "join",
            "concat",
            "merge",
            "split"
        ),
        answerIndex = 0,
        explanation = "The `join()` method is called on the separator string and takes an iterable of strings to combine them."
    ),
    Problem(
        id = "order_medium_jr11_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Safe File Reading",
        summary = "Arrange the steps to safely read a file.",
        prompt = "Arrange the lines to read a file and handle a missing file gracefully.",
        code = "",
        options = listOf(
            "try:",
            "    with open('data.txt') as f:",
            "        print(f.read())",
            "except FileNotFoundError:",
            "    print('File missing')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The correct structure puts the file opening inside a `try` block, uses `with` for safe resource management, and catches `FileNotFoundError` in the `except` block."
    ),
    Problem(
        id = "complex_medium_jr11_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Membership Complexity",
        summary = "Checking for duplicates efficiently.",
        prompt = "What is the average time complexity of this function, where N is len(items)?",
        code = """
            def find_duplicates(items):
                seen = set()
                dupes = []
                for item in items:
                    if item in seen:
                        dupes.append(item)
                    seen.add(item)
                return dupes
        """.trimIndent(),
        options = listOf(
            "O(N)",
            "O(N^2)",
            "O(log N)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "Checking membership in a `set` is O(1) on average. Doing this N times for the list results in an overall O(N) time complexity."
    ),
    Problem(
        id = "trace_medium_jr11_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Overwritten Loop Variable",
        summary = "Tracking assignment in a loop.",
        prompt = "What is the final value of `result`?",
        code = """
            data = [1, 2, 3]
            result = 0
            for val in data:
                result = val * 2
        """.trimIndent(),
        options = listOf(
            "6",
            "12",
            "0",
            "3"
        ),
        answerIndex = 0,
        explanation = "The loop overwrites `result` in each iteration rather than accumulating. The final value processed is `3`, so `result` becomes `3 * 2 = 6`."
    ),
    Problem(
        id = "match_medium_jr11_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "F-String Dictionary Access",
        summary = "Formatting strings with dictionary values.",
        prompt = "Which snippet correctly produces \"Name: Alice, Age: 25\" given `info = {'name': 'Alice', 'age': 25}`?",
        code = "",
        options = listOf(
            "print(f\"Name: {info['name']}, Age: {info['age']}\")",
            "print(\"Name: \" + info.name + \", Age: \" + str(info.age))",
            "print(\"Name: %s, Age: %d\" % (info.name, info.age))",
            "print(f\"Name: {info.name}, Age: {info.age}\")"
        ),
        answerIndex = 0,
        explanation = "In Python, dictionaries are accessed using bracket notation `['key']`, not dot notation. F-strings allow evaluating this access directly inside the curly braces."
    )
)
