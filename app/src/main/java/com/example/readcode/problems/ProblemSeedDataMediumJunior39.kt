package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior39 = listOf(
    Problem(
        id = "bug_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Sorted result becomes null",
        summary = "The code tries to keep a sorted copy of the list, but it stores the return value of an in-place method.",
        prompt = "What is the actual bug in this code?",
        code = """
            scores = [4, 1, 3]
            sorted_scores = scores.sort()
            print(sorted_scores[0])
        """.trimIndent(),
        options = listOf(
            "`sort()` changes the list in place and returns `None`",
            "`scores` must be a tuple before sorting",
            "Lists cannot contain integers when sorting",
            "`print(sorted_scores[0])` should run before the sort"
        ),
        answerIndex = 0,
        explanation = "`list.sort()` mutates `scores` directly and returns `None`, so `sorted_scores` is not a list that can be indexed."
    ),
    Problem(
        id = "output_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Join after filtering",
        summary = "Only names longer than three letters are uppercased and joined into one string.",
        prompt = "What does this code print?",
        code = """
            names = ["Lia", "Omar", "Nina", "Bo"]
            result = "-".join(name.upper() for name in names if len(name) > 3)
            print(result)
        """.trimIndent(),
        options = listOf("OMAR-NINA", "LIA-OMAR-NINA-BO", "OMAR", "NINA-BO"),
        answerIndex = 0,
        explanation = "Only `Omar` and `Nina` pass the length check. They are uppercased and joined with `-`."
    ),
    Problem(
        id = "purpose_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Merge quantities by item",
        summary = "The function walks through purchase records and accumulates totals for each item name.",
        prompt = "What does this function return overall?",
        code = """
            def total_by_item(rows):
                totals = {}
                for row in rows:
                    item = row["item"]
                    totals[item] = totals.get(item, 0) + row["qty"]
                return totals
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each item name to the sum of its quantities",
            "A list of items sorted by quantity",
            "A dictionary containing only the last row for each item",
            "A set of item names that appear more than once"
        ),
        answerIndex = 0,
        explanation = "Each row contributes its `qty` to the running total for that item's key in the dictionary."
    ),
    Problem(
        id = "fill_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy before mutation",
        summary = "The code should make a separate list so later appends do not change the original.",
        prompt = "Which option fills the blank correctly?",
        code = """
            original = ["draft", "review"]
            backup = original.___()
            backup.append("done")
            print(original)
        """.trimIndent(),
        options = listOf("copy", "clear", "sort", "reverse"),
        answerIndex = 0,
        explanation = "`copy()` creates a separate list. Appending to `backup` then leaves `original` unchanged."
    ),
    Problem(
        id = "order_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count expensive products",
        summary = "Arrange the lines so the code counts products with a price above 10 and prints the count.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "products = [{\"name\": \"pen\", \"price\": 3}, {\"name\": \"bag\", \"price\": 25}, {\"name\": \"lamp\", \"price\": 12}]",
            "count = 0",
            "for product in products:",
            "    if product[\"price\"] > 10:",
            "        count += 1",
            "print(count)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the input data and counter first, loop through the products, increment inside the condition, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Membership check inside loop",
        summary = "For each value in one list, the code scans another list to check membership.",
        prompt = "If `len(left) = n` and `len(right) = n`, what is the worst-case time complexity?",
        code = """
            matches = []
            for item in left:
                if item in right:
                    matches.append(item)
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "The outer loop runs `n` times, and each `item in right` list check can take up to `n` comparisons, giving quadratic worst-case time."
    ),
    Problem(
        id = "trace_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace after replace and append",
        summary = "A list element is replaced and then a new uppercase copy of another element is appended.",
        prompt = "What is the value of `tags` after the code finishes?",
        code = """
            tags = ["api", "db", "ui"]
            tags[1] = "cache"
            tags.append(tags[0].upper())
        """.trimIndent(),
        options = listOf(
            "[\"api\", \"cache\", \"ui\", \"API\"]",
            "[\"api\", \"db\", \"ui\", \"API\"]",
            "[\"API\", \"cache\", \"ui\"]",
            "[\"api\", \"cache\", \"API\"]"
        ),
        answerIndex = 0,
        explanation = "Index 1 changes from `db` to `cache`, and then `tags[0].upper()` adds `API` to the end of the list."
    ),
    Problem(
        id = "match_medium_junior_39",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['Ava', 'Mia']",
        summary = "Pick the snippet that keeps names containing the letter `a` or `A`, then prints them in title case.",
        prompt = "Which code prints `['Ava', 'Mia']`?",
        code = "",
        options = listOf(
            "names = [\"ava\", \"li\", \"mia\"]\nresult = []\nfor name in names:\n    if \"a\" in name:\n        result.append(name.title())\nprint(result)",
            "names = [\"ava\", \"li\", \"mia\"]\nresult = []\nfor name in names:\n    if len(name) > 2:\n        result.append(name.upper())\nprint(result)",
            "names = [\"ava\", \"li\", \"mia\"]\nprint([name for name in names if name.startswith(\"a\")])",
            "names = [\"ava\", \"li\", \"mia\"]\nresult = []\nfor name in names:\n    result.append(name.title())\nprint(result[:1])"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet filters names containing `a`, converts them to title case, and prints exactly `['Ava', 'Mia']`."
    )
)
