package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior12 = listOf(
    Problem(
        id = "bug_medium_jr12_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "In-Place Sorting",
        summary = "Returning the result of a sort operation.",
        prompt = "Why does this function return None instead of a sorted list?",
        code = """
            def get_sorted_names(names):
                return names.sort()
        """.trimIndent(),
        options = listOf(
            "`sort()` modifies the list in place and returns None",
            "`names` is a tuple and cannot be sorted",
            "The list must contain only strings to be sorted",
            "`sort()` requires a lambda function as an argument"
        ),
        answerIndex = 0,
        explanation = "In Python, the `.sort()` method on a list sorts the elements in place and returns `None`. To return a new sorted list, you should use the built-in `sorted()` function instead."
    ),
    Problem(
        id = "output_medium_jr12_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Slicing with Steps",
        summary = "Extracting elements using start, stop, and step.",
        prompt = "What does this code print?",
        code = """
            nums = [10, 20, 30, 40, 50]
            print(nums[1:4:2])
        """.trimIndent(),
        options = listOf(
            "[20, 40]",
            "[20, 30, 40]",
            "[10, 30]",
            "[30, 50]"
        ),
        answerIndex = 0,
        explanation = "The slice `[1:4:2]` starts at index 1 (inclusive), stops before index 4 (exclusive), and takes steps of 2. This grabs the elements at indices 1 and 3, which are 20 and 40."
    ),
    Problem(
        id = "purpose_medium_jr12_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Zipping Lists to Dictionary",
        summary = "Combining parallel lists.",
        prompt = "What does this code produce?",
        code = """
            keys = ["a", "b"]
            values = [1, 2]
            result = dict(zip(keys, values))
        """.trimIndent(),
        options = listOf(
            "A dictionary combining the two lists: {'a': 1, 'b': 2}",
            "A list of tuples: [('a', 1), ('b', 2)]",
            "A combined list: ['a', 'b', 1, 2]",
            "An error because the lists are not sets"
        ),
        answerIndex = 0,
        explanation = "The `zip()` function pairs up elements from both lists into tuples. Passing this to `dict()` constructs a dictionary where the first list provides the keys and the second provides the values."
    ),
    Problem(
        id = "fill_medium_jr12_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Exception Cleanup",
        summary = "Ensuring code runs whether an error occurs or not.",
        prompt = "Which keyword ensures the last block runs even if an exception is caught?",
        code = """
            try:
                x = 1 / 0
            except ZeroDivisionError:
                print("Error")
            ___:
                print("Done")
        """.trimIndent(),
        options = listOf(
            "finally",
            "else",
            "always",
            "catch"
        ),
        answerIndex = 0,
        explanation = "The `finally` block is executed no matter what happens in the `try` or `except` blocks, making it ideal for cleanup actions."
    ),
    Problem(
        id = "order_medium_jr12_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting Dictionaries",
        summary = "Arrange the lines to sort a list of dictionaries.",
        prompt = "Arrange the lines to correctly sort the users by age and print their names.",
        code = "",
        options = listOf(
            "users = [{'name': 'A', 'age': 30}, {'name': 'B', 'age': 20}]",
            "users.sort(key=lambda x: x['age'])",
            "for user in users:",
            "    print(user['name'])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First define the list, then sort it using a lambda that extracts the 'age' key, and finally loop through the sorted list to print the names."
    ),
    Problem(
        id = "complex_medium_jr12_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Loop Search Complexity",
        summary = "Checking membership in a list.",
        prompt = "What is the worst-case time complexity of this function, where N is the length of list_a and list_b?",
        code = """
            def find_common(list_a, list_b):
                common = []
                for item in list_a:
                    if item in list_b:
                        common.append(item)
                return common
        """.trimIndent(),
        options = listOf(
            "O(N^2)",
            "O(N)",
            "O(log N)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs N times. Inside, the `in` operator on a list takes O(N) time in the worst case. This results in an overall time complexity of O(N^2)."
    ),
    Problem(
        id = "trace_medium_jr12_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "String Immutability",
        summary = "Calling string methods without assignment.",
        prompt = "What is the value of `result` at the end of this code?",
        code = """
            text = "hello"
            text.upper()
            result = text + " world"
        """.trimIndent(),
        options = listOf(
            "\"hello world\"",
            "\"HELLO world\"",
            "\"HELLO WORLD\"",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Strings are immutable in Python. The method `.upper()` returns a new uppercase string, but because it isn't assigned to any variable, `text` remains unchanged as `\"hello\"`."
    ),
    Problem(
        id = "match_medium_jr12_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Comprehension Mapping",
        summary = "Transforming elements in a list.",
        prompt = "Which list comprehension correctly produces the output `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "[x * 2 for x in [1, 2, 3]]",
            "[x ** 2 for x in [1, 2, 3]]",
            "[x + 2 for x in [1, 2, 3]]",
            "[x for x in [1, 2, 3] if x % 2 == 0]"
        ),
        answerIndex = 0,
        explanation = "The list comprehension `[x * 2 for x in [1, 2, 3]]` iterates over the list, multiplying each element by 2, resulting in `[2, 4, 6]`."
    )
)
