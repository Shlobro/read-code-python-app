package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior46 = listOf(
    Problem(
        id = "bug_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Early Return Bug",
        summary = "A function that stops checking too soon.",
        prompt = "What is the logic error in this function?",
        code = """
            def contains_even(numbers):
                for n in numbers:
                    if n % 2 == 0:
                        return True
                    else:
                        return False
        """.trimIndent(),
        options = listOf(
            "It returns False on the first odd number instead of checking the rest",
            "It will throw a runtime error if the list is empty because of the missing return outside the loop",
            "The modulo operator condition should be changed to `% 2 != 0` to check for even numbers properly",
            "The function name should be changed to `has_even` to strictly match standard Python conventions"
        ),
        answerIndex = 0,
        explanation = "The `else: return False` block causes the function to exit immediately if the first number is odd, instead of continuing to check the remaining elements in the list."
    ),
    Problem(
        id = "output_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Reference",
        summary = "Assigning a list to another variable.",
        prompt = "What gets printed?",
        code = """
            a = [1, 2, 3]
            b = a
            b[0] = 99
            print(a[0])
        """.trimIndent(),
        options = listOf(
            "99",
            "1",
            "An IndexError is thrown",
            "[99, 2, 3]"
        ),
        answerIndex = 0,
        explanation = "Assigning `b = a` creates a reference to the exact same list in memory. Modifying the list through `b` also modifies `a`."
    ),
    Problem(
        id = "purpose_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Inversion",
        summary = "Using a dictionary comprehension.",
        prompt = "What is the primary outcome of this code?",
        code = """
            d = {'x': 1, 'y': 2}
            result = {v: k for k, v in d.items()}
        """.trimIndent(),
        options = listOf(
            "Swaps keys and values",
            "It iterates over the dictionary and creates a deep copy of the exact same key-value pairs",
            "Creates a new dictionary with uppercase string keys and increments all integer values by one",
            "It returns a list of tuples containing the dictionary items sorted by value in descending order"
        ),
        answerIndex = 0,
        explanation = "The comprehension iterates over the original key-value pairs and assigns the value as the new key, and the key as the new value, effectively inverting the dictionary."
    ),
    Problem(
        id = "fill_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Parallel Iteration",
        summary = "Iterating over two lists at once.",
        prompt = "Which function pairs elements from both lists?",
        code = """
            names = ['Ana', 'Bob']
            ages = [25, 30]
            for name, age in ______(names, ages):
                print(name, age)
        """.trimIndent(),
        options = listOf(
            "zip",
            "enumerate",
            "map",
            "combine_iterables"
        ),
        answerIndex = 0,
        explanation = "The `zip()` function takes multiple iterables and aggregates their elements into tuples, making it perfect for iterating over two lists in parallel."
    ),
    Problem(
        id = "order_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Exception Handling",
        summary = "Structuring a try-except-finally block.",
        prompt = "Arrange the lines to correctly handle a division error.",
        code = "",
        options = listOf(
            "try:",
            "    x = 1 / 0",
            "except ZeroDivisionError:",
            "    print(\"Cannot divide by zero\")",
            "finally:",
            "    print(\"Done\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The `try` block contains the code that might fail, `except` catches the specific error, and `finally` runs cleanup code regardless of whether an exception occurred."
    ),
    Problem(
        id = "complexity_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Membership Check",
        summary = "Time complexity of checking if an item is in a set.",
        prompt = "Assuming `data` has length N, what is the average time complexity of the operation `target in my_set`?",
        code = """
            def check_exists(data, target):
                my_set = set(data)
                return target in my_set
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(N)",
            "O(N log N) because sets internally use a balanced binary search tree to maintain elements",
            "O(N^2) because hashing every element requires iterating over the full length of the string"
        ),
        answerIndex = 0,
        explanation = "Checking for membership using the `in` operator on a set takes O(1) time on average, thanks to the underlying hash table implementation."
    ),
    Problem(
        id = "trace_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "String Reversal",
        summary = "Prepending characters in a loop.",
        prompt = "What is the exact value of `result` after the loop finishes?",
        code = """
            word = "cat"
            result = ""
            for char in word:
                result = char + result
        """.trimIndent(),
        options = listOf(
            "\"tac\"",
            "\"cat\"",
            "\"cccaaattt\"",
            "\"t\""
        ),
        answerIndex = 0,
        explanation = "During each iteration, the current character is prepended to the `result` string, which reverses the original word: 'c', then 'ac', then 'tac'."
    ),
    Problem(
        id = "match_medium_junior_46",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Even Numbers List",
        summary = "Filtering numbers in a list comprehension.",
        prompt = "Which snippet produces this precise output?\n\n[0, 2, 4]",
        code = "",
        options = listOf(
            "print([x for x in range(5) if x % 2 == 0])",
            "my_list = []\nfor x in range(6):\n    if x % 2 != 0:\n        my_list.append(x)\nprint(my_list)",
            "result = list(map(lambda x: x * 2, filter(lambda x: x < 3, range(10))))\nprint(result[:2])",
            "print([x for x in range(4) if x % 2 == 0])"
        ),
        answerIndex = 0,
        explanation = "The range(5) generator yields 0 through 4. Filtering for elements where `x % 2 == 0` leaves only the even numbers: 0, 2, and 4."
    )
)
