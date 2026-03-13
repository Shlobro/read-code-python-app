package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior57 = listOf(
    Problem(
        id = "bug_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing Accumulator Update",
        summary = "The loop checks every price, but the total never changes.",
        prompt = "What is the actual bug?",
        code = """
            def total_cost(prices):
                total = 0
                for price in prices:
                    price + total
                return total
        """.trimIndent(),
        options = listOf(
            "The function should print instead of return",
            "`price + total` does not store the new total",
            "The loop must start from index 1",
            "`total` should begin as an empty list"
        ),
        answerIndex = 1,
        explanation = "The expression computes a sum but throws it away. The code needs an assignment such as `total += price`."
    ),
    Problem(
        id = "output_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Append Returns Nothing",
        summary = "A list method changes the list in place.",
        prompt = "What gets printed?",
        code = """
            values = [1, 2]
            result = values.append(3)
            print(result)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]",
            "3",
            "None",
            "Error"
        ),
        answerIndex = 2,
        explanation = "`append()` mutates `values` and returns `None`, so `result` is `None`."
    ),
    Problem(
        id = "purpose_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group by First Letter",
        summary = "The function collects words under their starting character.",
        prompt = "What does this function return?",
        code = """
            def group_words(words):
                grouped = {}
                for word in words:
                    first = word[0]
                    grouped.setdefault(first, []).append(word)
                return grouped
        """.trimIndent(),
        options = listOf(
            "A dictionary grouping words by first letter",
            "A list of the unique first letters",
            "The words sorted alphabetically",
            "A count of letters in each word"
        ),
        answerIndex = 0,
        explanation = "Each word is appended to a list stored under its first character, so the result maps each first letter to matching words."
    ),
    Problem(
        id = "fill_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent Copy",
        summary = "The code needs a shallow copy before changing the list.",
        prompt = "Which option fills the blank correctly?",
        code = """
            original = [1, 2, 3]
            copied = original.___()
            copied.append(4)
            print(original)
        """.trimIndent(),
        options = listOf(
            "copy",
            "clear",
            "sort",
            "remove"
        ),
        answerIndex = 0,
        explanation = "`copy()` creates a separate list, so appending to `copied` does not change `original`."
    ),
    Problem(
        id = "order_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Passing Scores",
        summary = "Arrange the lines to count scores that are at least 60.",
        prompt = "Arrange the lines so the function returns how many scores are passing.",
        code = "",
        options = listOf(
            "def count_passing(scores):",
            "    passed = 0",
            "    for score in scores:",
            "        if score >= 60:",
            "            passed += 1",
            "    return passed"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, initialize the counter, loop through scores, increment on passing values, then return the count."
    ),
    Problem(
        id = "complexity_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Separate Passes",
        summary = "The list is scanned twice, one pass after the other.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for value in values:
                total += value

            count = 0
            for value in values:
                if value > 0:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(log n)",
            "O(n)",
            "O(n^2)"
        ),
        answerIndex = 2,
        explanation = "Two linear passes still add up to linear time, so the overall complexity is `O(n)`."
    ),
    Problem(
        id = "trace_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Reassigned Reference",
        summary = "The name `current` is moved to a new string during the loop.",
        prompt = "What is the value of `current` after the code finishes?",
        code = """
            current = "A"
            pieces = ["B", "C"]
            for piece in pieces:
                current = current + piece
        """.trimIndent(),
        options = listOf(
            "ABC",
            "BC",
            "C",
            "A"
        ),
        answerIndex = 0,
        explanation = "The loop builds the string step by step: first `AB`, then `ABC`."
    ),
    Problem(
        id = "match_medium_junior_57",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each item in the list.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "print([1, 2, 3] * 2)",
            "print([n * 2 for n in [1, 2, 3]])",
            "print(list(range(2, 7, 2)) + [6])",
            "print([2, 4] + [6, 8])"
        ),
        answerIndex = 1,
        explanation = "The list comprehension multiplies each original value by 2, producing exactly `[2, 4, 6]`."
    )
)
