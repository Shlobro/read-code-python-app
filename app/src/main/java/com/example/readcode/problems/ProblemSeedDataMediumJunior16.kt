package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior16 = listOf(
    Problem(
        id = "bug_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Removing Items During Iteration",
        summary = "Modifying a list while iterating over it.",
        prompt = "Why does this code fail to remove all even numbers?",
        code = """
            nums = [1, 2, 2, 3, 4]
            for n in nums:
                if n % 2 == 0:
                    nums.remove(n)
            print(nums)
        """.trimIndent(),
        options = listOf(
            "Removing items shifts indices, causing the loop to skip the next item",
            "The remove method only works on strings",
            "You cannot modify a list after it is created",
            "The loop condition is evaluated incorrectly"
        ),
        answerIndex = 0,
        explanation = "When you remove an item from a list while iterating over it, the remaining elements shift left. The internal iterator moves to the next index, skipping the element that immediately followed the removed one."
    ),
    Problem(
        id = "output_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Get Default",
        summary = "Using the .get() method on a dictionary with a default value.",
        prompt = "What does this code print?",
        code = """
            config = {'host': 'localhost', 'port': 8080}
            timeout = config.get('timeout', 30)
            print(timeout)
        """.trimIndent(),
        options = listOf(
            "30",
            "None",
            "KeyError",
            "8080"
        ),
        answerIndex = 0,
        explanation = "The `.get()` method returns the value for the specified key if it exists. If the key is not found, it returns the provided default value (30 in this case)."
    ),
    Problem(
        id = "purpose_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Enumerate Function",
        summary = "Iterating with both index and value.",
        prompt = "What does the enumerate function achieve here?",
        code = """
            names = ["Alice", "Bob", "Charlie"]
            for i, name in enumerate(names):
                print(f"{i}: {name}")
        """.trimIndent(),
        options = listOf(
            "It yields pairs of (index, value) for each item in the iterable",
            "It sorts the list alphabetically before iterating",
            "It converts the list into a dictionary",
            "It counts the total number of items in the list"
        ),
        answerIndex = 0,
        explanation = "The `enumerate()` function adds a counter to an iterable and returns it as an enumerate object. In a loop, it unpacks into the index and the value."
    ),
    Problem(
        id = "fill_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting with Lambda",
        summary = "Providing a custom sorting key using a lambda function.",
        prompt = "Fill in the blank to sort the list of tuples by the second element.",
        code = """
            pairs = [(1, 5), (3, 2), (8, 10)]
            pairs.sort(___)
            print(pairs)
        """.trimIndent(),
        options = listOf(
            "key=lambda x: x[1]",
            "sort_by=1",
            "lambda x: x[1]",
            "key=x[1]"
        ),
        answerIndex = 0,
        explanation = "The `sort()` method accepts a `key` parameter, which expects a function. A lambda function `lambda x: x[1]` correctly extracts the second element of each tuple for sorting."
    ),
    Problem(
        id = "order_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Simple Class Definition",
        summary = "Defining a basic Python class with an initialization method.",
        prompt = "Arrange the lines to correctly define and instantiate a User class.",
        code = "",
        options = listOf(
            "class User:",
            "    def __init__(self, username):",
            "        self.username = username",
            "    def get_name(self):",
            "        return self.username",
            "user1 = User('admin')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "First define the `class`, then the `__init__` method to initialize properties, then any additional methods, and finally instantiate the class outside its definition."
    ),
    Problem(
        id = "complexity_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "List Sorting Time Complexity",
        summary = "Understanding the efficiency of Python's built-in sort.",
        prompt = "What is the worst-case time complexity of Python's built-in `list.sort()` algorithm?",
        code = """
            data = [5, 2, 9, 1, 5, 6]
            data.sort()
        """.trimIndent(),
        options = listOf(
            "O(N log N)",
            "O(N)",
            "O(N^2)",
            "O(log N)"
        ),
        answerIndex = 0,
        explanation = "Python uses Timsort for its built-in `sort()` and `sorted()` functions. Timsort has a worst-case and average time complexity of O(N log N)."
    ),
    Problem(
        id = "trace_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Update in Loop",
        summary = "Tracing the value of a dictionary key through a loop.",
        prompt = "What is the value of `counts['a']` at the end of the script?",
        code = """
            words = ['a', 'b', 'a', 'c', 'a']
            counts = {}
            for w in words:
                if w in counts:
                    counts[w] += 1
                else:
                    counts[w] = 1
        """.trimIndent(),
        options = listOf(
            "3",
            "1",
            "2",
            "KeyError"
        ),
        answerIndex = 0,
        explanation = "The loop counts the occurrences of each word. The letter 'a' appears 3 times in the list, so its final count in the dictionary is 3."
    ),
    Problem(
        id = "match_medium_junior_16",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Unpacking Arguments",
        summary = "Using the asterisk to unpack a list into function arguments.",
        prompt = "Which code produces this output: `1 2 3`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint(*nums)",
            "nums = [1, 2, 3]\nprint(nums)",
            "nums = [1, 2, 3]\nprint(*nums, sep='')",
            "nums = [1, 2, 3]\nprint(nums[0:3])"
        ),
        answerIndex = 0,
        explanation = "The `*` operator unpacks the list `nums` into separate arguments for the `print()` function, which by default separates multiple arguments with a space."
    )
)
