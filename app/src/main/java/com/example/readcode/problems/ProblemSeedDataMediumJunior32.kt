package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior32 = listOf(
    Problem(
        id = "bug_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared row lists",
        summary = "A grid is created in a way that links every row to the same list.",
        prompt = "What is the actual bug in this code?",
        code = """
            grid = [[0] * 3] * 2
            grid[0][1] = 9
            print(grid)
        """.trimIndent(),
        options = listOf(
            "Both rows refer to the same inner list, so one update changes both rows",
            "The code should use tuples instead of lists for a grid",
            "`grid[0][1] = 9` is invalid because nested indexes cannot be assigned",
            "`print(grid)` should be inside a loop to show the full grid"
        ),
        answerIndex = 0,
        explanation = "The `* 2` duplicates the reference to the same inner list. Updating one row updates the other because they are aliases."
    ),
    Problem(
        id = "output_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort then reverse",
        summary = "The list is sorted in place and then printed in reverse order.",
        prompt = "What does this code print?",
        code = """
            values = [3, 1, 2]
            values.sort()
            print(values[::-1])
        """.trimIndent(),
        options = listOf("[3, 2, 1]", "[1, 2, 3]", "[2, 1, 3]", "Error"),
        answerIndex = 0,
        explanation = "After `sort()`, the list becomes `[1, 2, 3]`. The slice `[::-1]` prints a reversed copy: `[3, 2, 1]`."
    ),
    Problem(
        id = "purpose_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Latest score per user",
        summary = "The function loops through updates and stores the newest value for each name.",
        prompt = "What does this function return overall?",
        code = """
            def latest_scores(updates):
                scores = {}
                for name, score in updates:
                    scores[name] = score
                return scores
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each name to its most recent score",
            "A list of scores sorted from low to high",
            "A count of how many updates each user has",
            "A list of only the duplicate names"
        ),
        answerIndex = 0,
        explanation = "Each assignment overwrites any previous score for the same name, so the result keeps the latest score seen for each user."
    ),
    Problem(
        id = "fill_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Join pieces",
        summary = "The code should combine a list of words into one hyphen-separated string.",
        prompt = "Which option fills the blank correctly?",
        code = """
            parts = ["read", "code", "daily"]
            text = "-".___(parts)
            print(text)
        """.trimIndent(),
        options = listOf("join", "split", "append", "replace"),
        answerIndex = 0,
        explanation = "`'-'.join(parts)` combines the strings using `-` between each item, producing `read-code-daily`."
    ),
    Problem(
        id = "order_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build indexed labels",
        summary = "Arrange the lines so the code creates labels like `item-0`, `item-1`, and `item-2`.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "labels = []",
            "for i in range(3):",
            "    labels.append(f\"item-{i}\")",
            "print(labels)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "Create the result list first, then loop through the indexes, append each formatted label, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two separate passes",
        summary = "The list is traversed once to sum values and once to count even values.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            total = 0
            for value in values:
                total += value

            even_count = 0
            for value in values:
                if value % 2 == 0:
                    even_count += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(2^n)"
        ),
        answerIndex = 0,
        explanation = "Two separate linear passes are still linear overall. The work is about `2n`, which simplifies to O(n)."
    ),
    Problem(
        id = "trace_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a copied list",
        summary = "The variable is copied, mutated, and then extended.",
        prompt = "What is the value of `items` after the code finishes?",
        code = """
            items = [1, 2]
            other = items.copy()
            other.append(3)
            items = other + [4]
        """.trimIndent(),
        options = listOf("[1, 2, 3, 4]", "[1, 2, 4]", "[1, 2, 3]", "[1, 2]"),
        answerIndex = 0,
        explanation = "The copy becomes `[1, 2, 3]`, then `items` is reassigned to that list plus `[4]`, giving `[1, 2, 3, 4]`."
    ),
    Problem(
        id = "match_medium_junior_32",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'x': 2, 'y': 4}",
        summary = "Which snippet builds a dictionary by doubling each value from the source map?",
        prompt = "Which code prints `{'x': 2, 'y': 4}`?",
        code = "",
        options = listOf(
            "data = {'x': 1, 'y': 2}\nprint({key: value * 2 for key, value in data.items()})",
            "data = {'x': 1, 'y': 2}\nprint({key * 2: value for key, value in data.items()})",
            "data = {'x': 1, 'y': 2}\nprint(list(data.values()) * 2)",
            "data = {'x': 1, 'y': 2}\nprint({'x': 1, 'y': 2})"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet keeps the original keys and doubles each value, producing `{'x': 2, 'y': 4}`."
    )
)
