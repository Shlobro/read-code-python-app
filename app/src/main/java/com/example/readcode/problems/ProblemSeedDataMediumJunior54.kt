package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior54 = listOf(
    Problem(
        id = "bug_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Skipped First Item",
        summary = "The loop starts one index too late and misses data.",
        prompt = "What is the actual bug?",
        code = """
            def total_prices(prices):
                total = 0
                for i in range(1, len(prices)):
                    total += prices[i]
                return total
        """.trimIndent(),
        options = listOf(
            "It should return inside the loop",
            "It skips the first price",
            "`total` should start as `None`",
            "The list must be sorted before summing"
        ),
        answerIndex = 1,
        explanation = "Starting at index 1 ignores `prices[0]`, so the function omits the first item from the total."
    ),
    Problem(
        id = "output_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Join After Sort",
        summary = "The list is sorted in place before building a string.",
        prompt = "What gets printed?",
        code = """
            words = ["pear", "apple", "fig"]
            words.sort()
            print("-".join(words[:2]))
        """.trimIndent(),
        options = listOf(
            "pear-apple",
            "apple-fig",
            "fig-pear",
            "apple-pear"
        ),
        answerIndex = 1,
        explanation = "After sorting, the list becomes `['apple', 'fig', 'pear']`, and the first two items join into `apple-fig`."
    ),
    Problem(
        id = "purpose_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Latest Score Per Name",
        summary = "A dictionary is updated once per record.",
        prompt = "What does this function return?",
        code = """
            def latest_scores(records):
                scores = {}
                for name, score in records:
                    scores[name] = score
                return scores
        """.trimIndent(),
        options = listOf(
            "The latest score for each name",
            "A list of scores sorted by player name",
            "A dictionary that counts how many score updates each player has",
            "Only the highest score seen in the input"
        ),
        answerIndex = 0,
        explanation = "Each assignment overwrites any previous score for that name, so the final dictionary keeps the most recent score per name."
    ),
    Problem(
        id = "fill_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Loop Over Index and Value",
        summary = "The loop needs both the position and the item.",
        prompt = "Which option fills the blank so this prints each index with its word?",
        code = """
            words = ["red", "blue", "green"]
            for index, word in zip(___, words):
                print(index, word)
        """.trimIndent(),
        options = listOf(
            "words",
            "range(len(words))",
            "range(1, len(words) + 1)",
            "reversed(words)"
        ),
        answerIndex = 1,
        explanation = "`zip(range(len(words)), words)` pairs each index with the word at that position."
    ),
    Problem(
        id = "order_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Count Map",
        summary = "Arrange the lines to count how many times each number appears.",
        prompt = "Arrange the lines so the function returns a frequency dictionary.",
        code = "",
        options = listOf(
            "def count_values(values):",
            "    counts = {}",
            "    for value in values:",
            "        counts[value] = counts.get(value, 0) + 1",
            "    return counts"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the function, create the dictionary, loop through the values, update each count, and return the result."
    ),
    Problem(
        id = "complexity_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Triangle Loop",
        summary = "The inner loop gets longer as `i` grows.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            total = 0
            for i in range(n):
                for j in range(i):
                    total += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 2,
        explanation = "The total number of inner-loop iterations is 0 + 1 + 2 + ... + (n - 1), which grows quadratically."
    ),
    Problem(
        id = "trace_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Nested List",
        summary = "A copied outer list still contains the same inner list object.",
        prompt = "What is the value of `data[0]` after this code runs?",
        code = """
            data = [[1], [2]]
            copy_data = data[:]
            copy_data[0].append(3)
        """.trimIndent(),
        options = listOf(
            "[1]",
            "[1, 3]",
            "[2, 3]",
            "[[1, 3], [2]]"
        ),
        answerIndex = 1,
        explanation = "Slicing copies only the outer list, so both lists still reference the same inner list at index 0."
    ),
    Problem(
        id = "match_medium_junior_54",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: cat 3",
        summary = "Pick the snippet that prints the word and number separated by one space.",
        prompt = "Which snippet produces this exact output?",
        code = """
            cat 3
        """.trimIndent(),
        options = listOf(
            "print(\"cat\", 3)",
            "print(\"cat\" + 3)",
            "print(\"cat-3\")",
            "print([\"cat\", 3])"
        ),
        answerIndex = 0,
        explanation = "Passing two arguments to `print` outputs them with a space between them by default."
    )
)
