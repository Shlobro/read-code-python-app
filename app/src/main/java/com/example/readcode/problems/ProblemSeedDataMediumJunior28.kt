package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior28 = listOf(
    Problem(
        id = "bug_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared running total",
        summary = "A helper should reset its total on each call, but one line keeps old state around.",
        prompt = "What is the real bug in this code?",
        code = """
            totals = []

            def add_prices(prices):
                for price in prices:
                    totals.append(price)
                return sum(totals)
        """.trimIndent(),
        options = listOf(
            "The function writes into a list outside the function, so later calls reuse old values",
            "`sum()` cannot be used on a list of numbers",
            "The loop should use indexes instead of values",
            "`return` must be inside the loop"
        ),
        answerIndex = 0,
        explanation = "Because `totals` lives outside the function, every call keeps appending to the same list instead of starting fresh for the current `prices`."
    ),
    Problem(
        id = "output_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sorted copy plus append",
        summary = "One list is sorted into a new list, then only that new list is changed.",
        prompt = "What does this code print?",
        code = """
            scores = [4, 1, 3]
            ordered = sorted(scores)
            ordered.append(2)
            print(scores)
            print(ordered)
        """.trimIndent(),
        options = listOf(
            "[4, 1, 3]\n[1, 3, 4, 2]",
            "[1, 3, 4]\n[1, 3, 4, 2]",
            "[4, 1, 3, 2]\n[1, 3, 4]",
            "[1, 3, 4, 2]\n[1, 3, 4, 2]"
        ),
        answerIndex = 0,
        explanation = "`sorted(scores)` creates a new list, so `scores` stays unchanged. The append affects only `ordered`."
    ),
    Problem(
        id = "purpose_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group names by first letter",
        summary = "The function builds dictionary lists keyed by each name's first character.",
        prompt = "What does this function return overall?",
        code = """
            def group_names(names):
                groups = {}
                for name in names:
                    first = name[0]
                    groups.setdefault(first, []).append(name)
                return groups
        """.trimIndent(),
        options = listOf(
            "A dictionary that groups names by their starting letter",
            "A list of names sorted alphabetically",
            "A dictionary counting the length of each name",
            "A list containing only unique first letters"
        ),
        answerIndex = 0,
        explanation = "`setdefault(first, [])` ensures each starting letter has a list, then the current name is appended to that group's list."
    ),
    Problem(
        id = "fill_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Update only known items",
        summary = "The code should increase an existing dictionary value without creating a new key.",
        prompt = "Which option fills the blank correctly?",
        code = """
            stock = {"pen": 3, "book": 5}

            if "pen" in stock:
                stock["pen"] __ 2
        """.trimIndent(),
        options = listOf(
            "+=",
            "=",
            "==",
            "-="
        ),
        answerIndex = 0,
        explanation = "`+= 2` adds 2 to the current value, changing `stock[\"pen\"]` from 3 to 5."
    ),
    Problem(
        id = "order_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect long names",
        summary = "Arrange the lines so names longer than three characters are collected and printed.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "names = [\"Ada\", \"Mina\", \"Jo\", \"Luca\"]",
            "for name in names:",
            "    if len(name) > 3:",
            "result = []",
            "        result.append(name)",
            "print(result)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 3, 1, 2, 4, 5),
        explanation = "The source list and result list must be defined before the loop. Inside the loop, the length check comes before appending, and printing happens last."
    ),
    Problem(
        id = "complexity_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Loop plus membership check",
        summary = "Each iteration performs a membership test against a list that can be as large as the input.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            def unique_count(values):
                seen = []
                for value in values:
                    if value not in seen:
                        seen.append(value)
                return len(seen)
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs up to `n` times, and each `value not in seen` check can scan up to `n` items in the worst case."
    ),
    Problem(
        id = "trace_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the cart",
        summary = "The list is updated with both replacement and removal before its final state is checked.",
        prompt = "What is the value of `cart` after the code finishes?",
        code = """
            cart = ["pen", "book", "lamp"]
            cart[1] = cart[1].upper()
            cart.pop()
            cart.insert(0, "bag")
        """.trimIndent(),
        options = listOf(
            "['bag', 'pen', 'BOOK']",
            "['pen', 'BOOK', 'lamp']",
            "['bag', 'pen', 'book']",
            "['bag', 'BOOK', 'lamp']"
        ),
        answerIndex = 0,
        explanation = "After uppercasing index 1, the list is `['pen', 'BOOK', 'lamp']`. `pop()` removes `'lamp'`, then `insert(0, 'bag')` adds `'bag'` at the front."
    ),
    Problem(
        id = "match_medium_junior_28",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['Ann', 'Bo']",
        summary = "Which snippet keeps only names with length 3 or less?",
        prompt = "Which code prints `['Ann', 'Bo']`?",
        code = "",
        options = listOf(
            "names = [\"Ann\", \"Chris\", \"Bo\"]\nshort_names = []\nfor name in names:\n    if len(name) <= 3:\n        short_names.append(name)\nprint(short_names)",
            "names = [\"Ann\", \"Chris\", \"Bo\"]\nshort_names = []\nfor name in names:\n    if len(name) >= 3:\n        short_names.append(name)\nprint(short_names)",
            "names = [\"Ann\", \"Chris\", \"Bo\"]\nprint(names[:2])",
            "names = [\"Ann\", \"Chris\", \"Bo\"]\nprint(sorted(names))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet filters by `len(name) <= 3`, which keeps `Ann` and `Bo` but not `Chris`."
    )
)
