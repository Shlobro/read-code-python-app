package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior19 = listOf(
    Problem(
        id = "bug_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shadowing a Built-in",
        summary = "Using a built-in function name as a variable.",
        prompt = "What's the issue with this code?",
        code = """
            sum = 0
            for i in range(5):
                sum += i
            print(sum([1, 2, 3]))
        """.trimIndent(),
        options = listOf(
            "The variable 'sum' overrides the built-in function",
            "The loop range is incorrect",
            "You cannot print a list",
            "The '+=' operator is not supported for integers"
        ),
        answerIndex = 0,
        explanation = "Assigning a value to 'sum' shadows the built-in function 'sum()'. Calling 'sum([1, 2, 3])' afterwards will raise a TypeError because 'sum' is now an integer, not a function."
    ),
    Problem(
        id = "output_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary get with Default",
        summary = "Accessing missing keys safely.",
        prompt = "What does this code print?",
        code = """
            config = {"host": "localhost", "port": 8080}
            print(config.get("timeout", 30))
        """.trimIndent(),
        options = listOf(
            "30",
            "None",
            "Error",
            "8080"
        ),
        answerIndex = 0,
        explanation = "The 'get' method returns the value for the key if it exists. If the key is not found, it returns the provided default value, which is 30 here."
    ),
    Problem(
        id = "purpose_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "List Flattening",
        summary = "Using nested list comprehensions.",
        prompt = "What does this list comprehension do?",
        code = """
            matrix = [[1, 2], [3, 4]]
            flat = [num for row in matrix for num in row]
        """.trimIndent(),
        options = listOf(
            "Creates a single flat list [1, 2, 3, 4]",
            "Creates a list of tuples [(1, 2), (3, 4)]",
            "Multiplies the elements of the matrix",
            "Reverses the matrix rows"
        ),
        answerIndex = 0,
        explanation = "The comprehension iterates over each 'row' in 'matrix', and then over each 'num' in 'row', appending 'num' to the new list. This flattens the 2D list."
    ),
    Problem(
        id = "fill_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Catching Specific Exceptions",
        summary = "Handling division by zero.",
        prompt = "Fill in the blank to catch the exact error caused by dividing by zero.",
        code = """
            try:
                result = 10 / 0
            except ________:
                print("Cannot divide by zero")
        """.trimIndent(),
        options = listOf(
            "ZeroDivisionError",
            "ValueError",
            "TypeError",
            "RuntimeError"
        ),
        answerIndex = 0,
        explanation = "Dividing by zero in Python specifically raises a 'ZeroDivisionError'. Catching specific exceptions is better practice than catching all errors."
    ),
    Problem(
        id = "order_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "List Reversal Logic",
        summary = "Reversing a list in place using a while loop.",
        prompt = "Arrange the lines to reverse a list in place using two pointers.",
        code = "",
        options = listOf(
            "def reverse_list(arr):",
            "    left = 0",
            "    right = len(arr) - 1",
            "    while left < right:",
            "        arr[left], arr[right] = arr[right], arr[left]",
            "        left += 1; right -= 1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "First define the function and initialize the 'left' and 'right' pointers. Then start the loop, swap the elements at the pointers, and move the pointers toward the center."
    ),
    Problem(
        id = "complexity_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Key Lookup",
        summary = "Time complexity of dictionary operations.",
        prompt = "What is the average time complexity of checking if a key exists in a Python dictionary?",
        code = """
            data = {"a": 1, "b": 2, "c": 3}
            # "b" in data
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(N)",
            "O(log N)",
            "O(N^2)"
        ),
        answerIndex = 0,
        explanation = "Python dictionaries are implemented as hash tables. Looking up a key takes O(1) time on average."
    ),
    Problem(
        id = "trace_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "List Mutation in Function",
        summary = "Passing a mutable object to a function.",
        prompt = "What is the value of 'nums' after the function call?",
        code = """
            def append_zero(lst):
                lst.append(0)
                
            nums = [1, 2, 3]
            append_zero(nums)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 0]",
            "[1, 2, 3]",
            "[0]",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Lists are mutable and passed by reference. Modifying the list inside the function affects the original list outside the function."
    ),
    Problem(
        id = "match_medium_junior_19",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Formatting Strings",
        summary = "Using f-strings.",
        prompt = "Which code produces this output: `User Alice is 25`?",
        code = "",
        options = listOf(
            "name = \"Alice\"; age = 25; print(f\"User {name} is {age}\")",
            "name = \"Alice\"; age = 25; print(\"User {name} is {age}\")",
            "name = \"Alice\"; age = 25; print(f\"User name is age\")",
            "name = \"Alice\"; age = 25; print(\"User \" + name + \" is age\")"
        ),
        answerIndex = 0,
        explanation = "An f-string allows embedding expressions inside string literals using curly braces {}."
    )
)