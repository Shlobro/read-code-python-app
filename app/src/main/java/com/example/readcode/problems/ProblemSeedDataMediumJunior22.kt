package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior22 = listOf(
    Problem(
        id = "bug_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "String used as a number",
        summary = "A value from input-like data is still text when arithmetic happens.",
        prompt = "Why does this code fail?",
        code = """
            config = {"timeout": "5"}
            timeout = config["timeout"]
            print(timeout + 2)
        """.trimIndent(),
        options = listOf(
            "`timeout` is a string, so adding `2` causes a type error",
            "Dictionary values cannot be assigned to variables",
            "`print` only accepts strings",
            "The key must be written as `timeout:` instead of `\"timeout\"`"
        ),
        answerIndex = 0,
        explanation = "The dictionary stores `\"5\"` as a string. `timeout + 2` tries to combine a string and an integer, which raises a TypeError."
    ),
    Problem(
        id = "output_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Update through an alias",
        summary = "Two variables point to the same list before one append.",
        prompt = "What does this code print?",
        code = """
            scores = [1, 2]
            backup = scores
            backup.append(3)
            print(scores)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]",
            "[1, 2]",
            "[3]",
            "An error"
        ),
        answerIndex = 0,
        explanation = "`backup` and `scores` refer to the same list object, so appending through `backup` also changes `scores`."
    ),
    Problem(
        id = "purpose_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group names by team",
        summary = "A loop builds a dictionary where each key stores a list of names.",
        prompt = "What does this function return?",
        code = """
            def group_by_team(players):
                teams = {}
                for name, team in players:
                    teams.setdefault(team, []).append(name)
                return teams
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each team to the players on that team",
            "A list of team names without duplicates",
            "A dictionary mapping each player to their team number",
            "A sorted list of players by team name"
        ),
        answerIndex = 0,
        explanation = "`setdefault(team, [])` creates a list for each team when needed, and each player's name is appended to that team's list."
    ),
    Problem(
        id = "fill_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Accumulate without aliasing",
        summary = "Two variables must track independent running totals.",
        prompt = "Which blank keeps `a_total` and `b_total` independent so each only sums its own group?",
        code = """
            groups = {"a": [1, 2], "b": [3, 4]}
            a_total = sum(groups["a"])
            b_total = _____
            groups["a"].append(99)
            print(a_total, b_total)
        """.trimIndent(),
        options = listOf(
            "sum(groups[\"b\"])",
            "a_total",
            "sum(groups[\"a\"])",
            "groups[\"b\"]"
        ),
        answerIndex = 0,
        explanation = "`sum(groups[\"b\"])` computes 3 + 4 = 7 at that point in time. `a_total` is an alias for the integer 3, not a reference to the list, so appending 99 later does not change either total. The append only matters if you re-sum after the mutation. Output: `3 7`."
    ),
    Problem(
        id = "order_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build an index map",
        summary = "Arrange the lines to map each word to its position in the list.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    positions[word] = index",
            "for index, word in enumerate(words):",
            "words = [\"red\", \"blue\", \"green\"]",
            "positions = {}"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 1, 0),
        explanation = "The list and result dictionary must exist before the loop, and the assignment inside the loop comes last."
    ),
    Problem(
        id = "complexity_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Double loop over pairs",
        summary = "Every item is compared with every item from another list.",
        prompt = "What is the time complexity in terms of `n` for this code when both lists have length `n`?",
        code = """
            matches = 0
            for left in items_a:
                for right in items_b:
                    if left == right:
                        matches += 1
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs n times and the inner loop also runs n times for each outer pass, so the total work is n * n."
    ),
    Problem(
        id = "trace_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track a running discount",
        summary = "A total is updated in a loop with one discounted item.",
        prompt = "What is the value of `total` after the loop finishes?",
        code = """
            prices = [10, 5, 8]
            total = 0

            for price in prices:
                if price < 8:
                    total += price - 1
                else:
                    total += price
        """.trimIndent(),
        options = listOf(
            "22",
            "23",
            "21",
            "24"
        ),
        answerIndex = 0,
        explanation = "The loop adds 10, then 4 for the discounted 5, then 8, so `total` ends at 22."
    ),
    Problem(
        id = "match_medium_junior_22",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Which snippet counts letters in the string `aba`?",
        prompt = "Which code prints `{'a': 2, 'b': 1}`?",
        code = "",
        options = listOf(
            "counts = {}\nfor ch in \"aba\":\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "counts = {}\nfor ch in \"aba\":\n    counts[ch] = 1\nprint(counts)",
            "counts = []\nfor ch in \"aba\":\n    counts.append(ch)\nprint(counts)",
            "counts = {\"a\": 1, \"b\": 1}\nprint(counts)"
        ),
        answerIndex = 0,
        explanation = "The first snippet increments the count for each character, so `a` is counted twice and `b` once."
    )
)
