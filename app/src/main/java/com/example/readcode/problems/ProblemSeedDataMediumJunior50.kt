package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior50 = listOf(
    Problem(
        id = "bug_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Early Return in a Counter",
        summary = "A function exits too soon while scanning a list.",
        prompt = "What is the actual bug in this function?",
        code = """
            def count_long_words(words):
                total = 0
                for word in words:
                    if len(word) > 3:
                        total += 1
                        return total
                return total
        """.trimIndent(),
        options = listOf(
            "Using `> 3` misses words with exactly three letters",
            "`total` should be reset to 0 inside the loop before counting each word",
            "It returns inside the loop and stops after the first match",
            "`len(word)` is invalid because `word` is a string"
        ),
        answerIndex = 2,
        explanation = "The `return` inside the loop exits the function after the first long word instead of counting all matching words."
    ),
    Problem(
        id = "output_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Aliased List",
        summary = "Two variables refer to the same list object.",
        prompt = "What gets printed?",
        code = """
            data = [1, 2, 3]
            copy = data
            copy.pop()
            print(data)
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "[1, 2, 3]",
            "[3]",
            "An error is raised"
        ),
        answerIndex = 0,
        explanation = "`copy` and `data` point to the same list, so `pop()` removes the last element from `data` too."
    ),
    Problem(
        id = "purpose_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "First-Seen Unique Values",
        summary = "A set and a result list work together.",
        prompt = "What does this function return?",
        code = """
            def unique_items(values):
                seen = set()
                result = []
                for value in values:
                    if value not in seen:
                        seen.add(value)
                        result.append(value)
                return result
        """.trimIndent(),
        options = listOf(
            "A sorted list of the distinct values",
            "A list with duplicates removed while keeping first-seen order",
            "A list containing only values that appeared exactly twice in the input",
            "A dictionary that maps each value to the index of its last appearance"
        ),
        answerIndex = 1,
        explanation = "The function appends each value only the first time it appears, so the output keeps the original first-seen order."
    ),
    Problem(
        id = "fill_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Copy",
        summary = "Make a new list before mutating it.",
        prompt = "Fill in the blank so `original` stays unchanged after `copy.append(4)`.",
        code = """
            original = [1, 2, 3]
            copy = original[__]
            copy.append(4)
        """.trimIndent(),
        options = listOf(
            ":",
            "0",
            "-1",
            "::2"
        ),
        answerIndex = 0,
        explanation = "`[:]` makes a shallow copy of the whole list, so appending to `copy` does not change `original`."
    ),
    Problem(
        id = "order_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Sum the Even Values",
        summary = "Arrange the lines to total only the even numbers.",
        prompt = "Arrange the lines so the function returns the sum of the even numbers in `nums`.",
        code = "",
        options = listOf(
            "def sum_even(nums):",
            "    total = 0",
            "    for num in nums:",
            "        if num % 2 == 0:",
            "            total += num",
            "    return total"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, create the accumulator, loop over the input, add only even values, and return the total at the end."
    ),
    Problem(
        id = "complexity_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Growing Inner Loop",
        summary = "The inner loop depends on the outer index.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            def count_pairs(items):
                total = 0
                for i in range(len(items)):
                    for j in range(i):
                        total += 1
                return total
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 2,
        explanation = "The inner loop runs 0 + 1 + 2 + ... + (n - 1) times, which grows quadratically overall."
    ),
    Problem(
        id = "trace_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Rebinding vs Mutation",
        summary = "A list is first aliased, then one name is rebound.",
        prompt = "What is the value of `record[\"scores\"]` after this code runs?",
        code = """
            record = {"scores": [10, 20]}
            scores = record["scores"]
            scores = scores + [30]
        """.trimIndent(),
        options = listOf(
            "[30]",
            "[10, 20, 30]",
            "[10, 20]",
            "An error is raised"
        ),
        answerIndex = 2,
        explanation = "`scores + [30]` creates a new list and rebinds `scores`, so the original list inside `record` stays unchanged."
    ),
    Problem(
        id = "match_medium_junior_50",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 0, 1, 4",
        summary = "Pick the snippet that prints the squares of 0 through 2 on separate lines.",
        prompt = "Which snippet produces this exact output?",
        code = """
            0
            1
            4
        """.trimIndent(),
        options = listOf(
            "for n in range(3):\n    print(n)",
            "for n in range(3):\n    print(n * n)",
            "print([n * n for n in range(3)])",
            "for n in [1, 2, 3]:\n    print(n * n)"
        ),
        answerIndex = 1,
        explanation = "Squaring each value from `range(3)` prints 0, 1, and 4 on separate lines."
    )
)
