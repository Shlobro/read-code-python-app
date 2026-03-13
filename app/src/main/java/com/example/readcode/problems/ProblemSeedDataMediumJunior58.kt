package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior58 = listOf(
    Problem(
        id = "bug_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing Final Field",
        summary = "The parser handles commas, but one value never reaches the result list.",
        prompt = "What is the actual bug?",
        code = """
            def split_names(text):
                names = []
                current = ""
                for ch in text:
                    if ch == ",":
                        names.append(current)
                        current = ""
                    else:
                        current += ch
                return names
        """.trimIndent(),
        options = listOf(
            "The loop should iterate by index instead of character",
            "`current` should start as a list",
            "The final name is never appended after the loop",
            "The function returns too early inside the loop"
        ),
        answerIndex = 2,
        explanation = "Each comma adds the field collected so far, but the last field stays in `current` and is never appended before the function returns."
    ),
    Problem(
        id = "output_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Replacement",
        summary = "A slice assignment replaces two items with one new value.",
        prompt = "What gets printed?",
        code = """
            values = [1, 2, 3, 4]
            values[1:3] = [9]
            print(values)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 9, 4]",
            "[1, 9, 4]",
            "[9, 4]",
            "Error"
        ),
        answerIndex = 1,
        explanation = "The slice `values[1:3]` contains `2` and `3`. Replacing it with `[9]` produces `[1, 9, 4]`."
    ),
    Problem(
        id = "purpose_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Bucket by Length",
        summary = "The function stores each word under a key based on its size.",
        prompt = "What does this function return?",
        code = """
            def by_length(words):
                groups = {}
                for word in words:
                    size = len(word)
                    groups.setdefault(size, []).append(word)
                return groups
        """.trimIndent(),
        options = listOf(
            "Counts the total characters across all words",
            "Builds one list of words ordered from shortest to longest",
            "Keeps only the shortest word for each length",
            "Groups words into lists keyed by their length"
        ),
        answerIndex = 3,
        explanation = "Each word is appended to a list stored under its length, so the result maps lengths to the words that have that size."
    ),
    Problem(
        id = "fill_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy Nested Lists",
        summary = "Each inner list needs its own shallow copy before mutation.",
        prompt = "Which option fills the blank so `rows` stays unchanged?",
        code = """
            rows = [[1], [2]]
            safe_rows = [row.___() for row in rows]
            safe_rows[0].append(9)
            print(rows)
        """.trimIndent(),
        options = listOf(
            "copy",
            "clear",
            "sort",
            "reverse"
        ),
        answerIndex = 0,
        explanation = "`copy()` creates a new list for each row, so appending to `safe_rows[0]` does not mutate the original inner list in `rows`."
    ),
    Problem(
        id = "order_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect Short Words",
        summary = "Arrange the lines to gather lowercase words of length 4 or less.",
        prompt = "Arrange the lines so the function returns the filtered list.",
        code = "",
        options = listOf(
            "def collect_short(words):",
            "    result = []",
            "    for word in words:",
            "        if len(word) <= 4:",
            "            result.append(word.lower())",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, create the result list, loop through the words, append matching lowercase words, then return the list."
    ),
    Problem(
        id = "complexity_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Compare Every Pair",
        summary = "The code checks each value against every other value in the same list.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            pairs = 0
            for left in values:
                for right in values:
                    if left < right:
                        pairs += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(n^3)"
        ),
        answerIndex = 1,
        explanation = "For each of the `n` values chosen as `left`, the inner loop visits all `n` values again, so the work grows as `n * n`."
    ),
    Problem(
        id = "trace_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Alias Then Rebind",
        summary = "One variable shares a list reference before the original name is rebound.",
        prompt = "What is the value of `other` after the code finishes?",
        code = """
            items = ["a", "b"]
            other = items
            other.append("c")
            items = items + ["d"]
        """.trimIndent(),
        options = listOf(
            "[\"a\", \"b\", \"c\", \"d\"]",
            "[\"a\", \"b\"]",
            "[\"a\", \"b\", \"c\"]",
            "[\"d\"]"
        ),
        answerIndex = 2,
        explanation = "`other` and `items` first point to the same list, so `append(\"c\")` changes both. The later `items = items + [\"d\"]` rebinds only `items`, leaving `other` as `[\"a\", \"b\", \"c\"]`."
    ),
    Problem(
        id = "match_medium_junior_58",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['cat', 'dog']",
        summary = "Pick the slice that drops the last item and keeps the first two.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"cat\", \"dog\", \"emu\"]\nprint(words[:1])",
            "words = [\"cat\", \"dog\", \"emu\"]\nprint(words[1:])",
            "words = [\"cat\", \"dog\"]\nprint(words.append(\"emu\"))",
            "words = [\"cat\", \"dog\", \"emu\"]\nprint(words[:-1])"
        ),
        answerIndex = 3,
        explanation = "`words[:-1]` returns every element except the last one, producing exactly `['cat', 'dog']`."
    )
)
