package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents13 = listOf(
    Problem(
        id = "bug_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Index out of bounds",
        summary = "Trying to access an item that doesn't exist.",
        prompt = "Why does this code cause an IndexError?",
        code = """
            colors = ["red", "blue", "green"]
            print(colors[3])
        """.trimIndent(),
        options = listOf(
            "The valid indexes are 0, 1, and 2",
            "Lists cannot store strings",
            "`print` needs an f-string",
            "The list is missing a fourth color"
        ),
        answerIndex = 0,
        explanation = "Python uses zero-based indexing. The third item is at index 2, so index 3 is out of bounds."
    ),
    Problem(
        id = "output_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String repetition",
        summary = "Multiplying a string by a number.",
        prompt = "What does this code print?",
        code = """
            word = "Go"
            print(word * 3)
        """.trimIndent(),
        options = listOf(
            "GoGoGo",
            "Go3",
            "Go Go Go",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Using the `*` operator on a string and an integer repeats the string that many times without adding spaces."
    ),
    Problem(
        id = "purpose_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Find the largest",
        summary = "Comparing elements to keep track of a specific value.",
        prompt = "What does this function do?",
        code = """
            def process(items):
                best = items[0]
                for x in items:
                    if x > best:
                        best = x
                return best
        """.trimIndent(),
        options = listOf(
            "Finds the largest number in the list",
            "Sorts the list from largest to smallest",
            "Finds the smallest number in the list",
            "Counts how many items are in the list"
        ),
        answerIndex = 0,
        explanation = "The loop checks each item and updates `best` whenever it finds a larger value, ultimately returning the maximum."
    ),
    Problem(
        id = "fill_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Generate a sequence",
        summary = "Looping a specific number of times.",
        prompt = "Which function fills the blank to loop 5 times?",
        code = """
            for i in ___(5):
                print(i)
        """.trimIndent(),
        options = listOf(
            "range",
            "list",
            "loop",
            "count"
        ),
        answerIndex = 0,
        explanation = "The `range()` function generates a sequence of numbers, which is commonly used in `for` loops to repeat actions."
    ),
    Problem(
        id = "order_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Swap variables",
        summary = "Exchanging the values of two variables using a temporary variable.",
        prompt = "Arrange the code to correctly swap the values of `a` and `b`.",
        code = "",
        options = listOf(
            "b = temp",
            "a = b",
            "temp = a"
        ),
        answerIndex = -1,
        correctOrder = listOf(2, 1, 0),
        explanation = "First save `a` in `temp`, then assign `b`'s value to `a`, and finally assign the saved `temp` value to `b`."
    ),
    Problem(
        id = "complexity_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Print all items",
        summary = "Iterating over every element in a list.",
        prompt = "How does the execution time grow as the list of names gets longer?",
        code = """
            def print_all(names):
                for name in names:
                    print(name)
        """.trimIndent(),
        options = listOf(
            "Proportional to the number of names (O(N))",
            "It stays the same regardless of size (O(1))",
            "It grows exponentially (O(2^N))",
            "It requires quadratic time (O(N^2))"
        ),
        answerIndex = 0,
        explanation = "A single `for` loop that goes through every item takes linear time (O(N)), meaning the time increases directly with the number of items."
    ),
    Problem(
        id = "trace_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Simple counter",
        summary = "Tracking a variable as a loop runs.",
        prompt = "What is the value of `count` on the last line?",
        code = """
            count = 0
            for i in range(3):
                count += 1
            # What is count here?
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "0",
            "1"
        ),
        answerIndex = 0,
        explanation = "The loop runs 3 times (for i = 0, 1, 2), adding 1 to `count` each time, so `count` becomes 3."
    ),
    Problem(
        id = "match_easy_student_13",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List slicing",
        summary = "Extracting a part of a list.",
        prompt = "Which code produces this output?",
        code = """
            [20, 30]
        """.trimIndent(),
        options = listOf(
            "nums = [10, 20, 30, 40]\nprint(nums[1:3])",
            "nums = [10, 20, 30, 40]\nprint(nums[2:3])",
            "nums = [10, 20, 30, 40]\nprint(nums[1:2])",
            "nums = [10, 20, 30, 40]\nprint(nums[0:2])"
        ),
        answerIndex = 0,
        explanation = "Slicing `[1:3]` extracts elements from index 1 up to (but not including) index 3, which gives `[20, 30]`."
    )
)
