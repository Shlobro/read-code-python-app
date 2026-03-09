package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior18 = listOf(
    Problem(
        id = "bug_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "In-Place Sort Returns None",
        summary = "Assigning the result of a list's sort() method.",
        prompt = "Why does this code throw a TypeError?",
        code = """
            numbers = [3, 1, 4, 1, 5]
            sorted_numbers = numbers.sort()
            print(sorted_numbers[0])
        """.trimIndent(),
        options = listOf(
            ".sort() modifies the list in-place and returns None",
            "The list contains duplicate numbers",
            "You cannot index into a sorted list",
            ".sort() only works on strings"
        ),
        answerIndex = 0,
        explanation = "The list method `.sort()` sorts the list in-place and returns `None`. Trying to access index 0 of `None` raises a `TypeError`. Use `sorted(numbers)` if you want a new sorted list."
    ),
    Problem(
        id = "output_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Simultaneous Assignment",
        summary = "Updating multiple variables on the same line.",
        prompt = "What does this code print?",
        code = """
            x, y = 10, 20
            x, y = y, x + y
            print(x, y)
        """.trimIndent(),
        options = listOf(
            "20 30",
            "20 40",
            "30 20",
            "10 30"
        ),
        answerIndex = 0,
        explanation = "In Python, the right side of the assignment is fully evaluated before any assignments are made. `y` is 20, and `x + y` is 30, so `x` becomes 20 and `y` becomes 30."
    ),
    Problem(
        id = "purpose_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Comprehension with Zip",
        summary = "Combining lists and filtering simultaneously.",
        prompt = "What does this code create?",
        code = """
            keys = ['a', 'b', 'c']
            values = [1, 2, 3]
            result = {k: v for k, v in zip(keys, values) if v % 2 != 0}
        """.trimIndent(),
        options = listOf(
            "A dictionary of pairs where the value is an odd number",
            "A list of tuples with matching keys and values",
            "A dictionary containing all key-value pairs",
            "A set of keys that have odd values"
        ),
        answerIndex = 0,
        explanation = "The code pairs up items from both lists using `zip`, then uses a dictionary comprehension to build a dictionary containing only the pairs where the value is not divisible by 2 (odd)."
    ),
    Problem(
        id = "fill_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Keyword Arguments",
        summary = "Passing arbitrary keyword arguments to a dictionary.",
        prompt = "Fill in the blank to add all extra keyword arguments to the profile dictionary.",
        code = """
            def make_profile(name, **kwargs):
                profile = {"name": name}
                profile.update(_____)
                return profile
        """.trimIndent(),
        options = listOf(
            "kwargs",
            "**kwargs",
            "args",
            "*args"
        ),
        answerIndex = 0,
        explanation = "Inside the function, `kwargs` is a regular dictionary containing the extra keyword arguments. The `update()` method takes a dictionary, so passing `kwargs` directly is correct."
    ),
    Problem(
        id = "order_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "File Parsing with Try-Except",
        summary = "Safely opening a file and handling a missing file error.",
        prompt = "Arrange the lines to attempt to load JSON and handle a missing file.",
        code = "",
        options = listOf(
            "import json",
            "try:",
            "    with open('data.json', 'r') as file:",
            "        data = json.load(file)",
            "except FileNotFoundError:",
            "    print('File not found')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "First import the `json` module, then open the `try` block, use the `with` statement to manage the file resource, perform the operation that might fail, catch the specific exception, and handle it."
    ),
    Problem(
        id = "complexity_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set vs List Membership",
        summary = "Comparing time complexity of the 'in' operator.",
        prompt = "What is the average time complexity of the 'in' operator for a Python set compared to a list?",
        code = """
            items_list = [1, 2, 3, 4, 5]
            items_set = {1, 2, 3, 4, 5}
            
            # 3 in items_set
            # 3 in items_list
        """.trimIndent(),
        options = listOf(
            "O(1) for set, O(N) for list",
            "O(N) for set, O(1) for list",
            "O(log N) for both",
            "O(1) for both"
        ),
        answerIndex = 0,
        explanation = "Python sets are implemented as hash tables, making average membership testing O(1). Lists are arrays, so checking membership requires scanning the elements, making it O(N)."
    ),
    Problem(
        id = "trace_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Global Variable Modification",
        summary = "Using the global keyword to modify a variable inside a function.",
        prompt = "What is the value of `count` after both function calls?",
        code = """
            count = 5
            
            def increment():
                global count
                count += 1
                
            increment()
            increment()
        """.trimIndent(),
        options = listOf(
            "7",
            "5",
            "6",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `global` keyword allows the function to modify the `count` variable defined outside its local scope. It starts at 5 and is incremented twice, ending at 7."
    ),
    Problem(
        id = "match_medium_junior_18",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Joining a List of Strings",
        summary = "Combining string elements with a delimiter.",
        prompt = "Which code produces this output: `A-B-C`?",
        code = "",
        options = listOf(
            "\"-\".join([\"A\", \"B\", \"C\"])",
            "[\"A\", \"B\", \"C\"].join(\"-\")",
            "\"-\".split([\"A\", \"B\", \"C\"])",
            "[\"A\", \"B\", \"C\"] + \"-\""
        ),
        answerIndex = 0,
        explanation = "In Python, `join` is a string method that takes an iterable of strings. You call it on the delimiter string, passing the list of strings to be joined."
    )
)