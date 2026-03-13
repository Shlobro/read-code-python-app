package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior64 = listOf(
    Problem(
        id = "bug_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing Dictionary Setup",
        summary = "A counting loop updates a dictionary before the key exists.",
        prompt = "What is the real bug in this code?",
        code = """
            votes = ["red", "blue", "red"]
            counts = {}
            for color in votes:
                counts[color] += 1
        """.trimIndent(),
        options = listOf(
            "The loop should use indexes",
            "`votes` should be a tuple",
            "Each key needs an initial count",
            "The code should store colors in a list before counting"
        ),
        answerIndex = 2,
        explanation = "The first time a color appears, `counts[color]` does not exist yet, so the code needs an initial value such as 0."
    ),
    Problem(
        id = "output_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice and Extend",
        summary = "A slice is copied, then one value is appended before printing.",
        prompt = "What does this code print?",
        code = """
            data = [5, 10, 15, 20]
            part = data[1:]
            part.append(data[0])
            print(part)
        """.trimIndent(),
        options = listOf(
            "[10, 15, 20]",
            "[5, 10, 15, 20, 5]",
            "[10, 15, 20, 5]",
            "[5, 10, 15, 20]"
        ),
        answerIndex = 2,
        explanation = "`data[1:]` creates `[10, 15, 20]`, then `append(data[0])` adds `5` to the end."
    ),
    Problem(
        id = "purpose_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Collect Non-empty Names",
        summary = "The loop normalizes text and skips blank entries.",
        prompt = "What does this code put into `cleaned`?",
        code = """
            names = ["  Ana ", " ", "Bob"]
            cleaned = []
            for name in names:
                value = name.strip()
                if value:
                    cleaned.append(value.lower())
        """.trimIndent(),
        options = listOf(
            "A count of spaces in each name",
            "The names in reverse order",
            "Names converted to lowercase, with blank entries removed",
            "Only the original names longer than three letters"
        ),
        answerIndex = 2,
        explanation = "Each name is stripped, empty strings are skipped, and the remaining names are added in lowercase."
    ),
    Problem(
        id = "fill_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent Copy",
        summary = "The second list should change without modifying the first one.",
        prompt = "Which choice fills the blank so `backup` becomes a separate list copy?",
        code = """
            values = [1, 2, 3]
            backup = values.___()
            backup.append(4)
        """.trimIndent(),
        options = listOf(
            "clear",
            "copy",
            "sort",
            "reverse"
        ),
        answerIndex = 1,
        explanation = "`copy()` creates a new list with the same items, so appending to `backup` does not change `values`."
    ),
    Problem(
        id = "order_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Price Map",
        summary = "Arrange the lines so the function returns a dictionary from item pairs.",
        prompt = "Arrange the lines so the function builds the dictionary correctly.",
        code = "",
        options = listOf(
            "def to_price_map(rows):",
            "    prices = {}",
            "    for name, price in rows:",
            "        prices[name] = price",
            "    return prices"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The function header comes first, then the result dictionary, then the loop that fills it, and finally the return."
    ),
    Problem(
        id = "complexity_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Full Passes",
        summary = "The code walks the same list once to total it and again to print it.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for value in values:
                total += value

            for value in values:
                print(value / total)
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n^2)",
            "O(1)",
            "O(n)"
        ),
        answerIndex = 3,
        explanation = "There are two separate linear passes over `values`, which is still `O(n)` overall."
    ),
    Problem(
        id = "trace_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Update the Last Score",
        summary = "Track a list after one element is changed using a negative index.",
        prompt = "What is the value of `scores` after this code runs?",
        code = """
            scores = [3, 6, 8]
            scores[-1] = scores[0] + scores[1]
            scores.append(len(scores))
        """.trimIndent(),
        options = listOf(
            "[9, 6, 9, 4]",
            "[3, 6, 9, 3]",
            "[3, 6, 9, 4]",
            "[3, 6, 9, 9]"
        ),
        answerIndex = 1,
        explanation = "The last value changes from `8` to `3 + 6`, so the list becomes `[3, 6, 9]`. Then `len(scores)` is 3, and appending it gives `[3, 6, 9, 3]`."
    ),
    Problem(
        id = "match_medium_junior_64",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': ['ant', 'apple'], 'b': ['bee']}",
        summary = "Pick the snippet that groups words by their first letter.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"ant\", \"apple\", \"bee\"]\nresult = {}\nfor word in words:\n    result[word[0]] = word\nprint(result)",
            "words = [\"ant\", \"apple\", \"bee\"]\nresult = {}\nfor word in words:\n    result.setdefault(word[0], []).append(word)\nprint(result)",
            "words = [\"ant\", \"apple\", \"bee\"]\nresult = {word: word[0] for word in words}\nprint(result)",
            "words = [\"ant\", \"apple\", \"bee\"]\nresult = {}\nfor word in words:\n    result.setdefault(word, []).append(word[0])\nprint(result)"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet stores a list for each starting letter and appends each matching word to it."
    )
)
