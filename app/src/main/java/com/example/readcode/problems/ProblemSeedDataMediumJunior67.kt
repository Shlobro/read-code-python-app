package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior67 = listOf(
    Problem(
        id = "bug_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Bucket for Every Team",
        summary = "A dictionary is meant to store a separate list per team, but each key ends up sharing one list.",
        prompt = "What is the real bug in this code?",
        code = """
            teams = ["red", "blue", "red"]
            grouped = {}
            bucket = []
            for team in teams:
                grouped.setdefault(team, bucket).append(team)
        """.trimIndent(),
        options = listOf(
            "The loop should iterate over indexes instead of values",
            "`setdefault()` cannot be used with strings as keys",
            "The same `bucket` list is reused for every team",
            "The dictionary must be sorted before appending values"
        ),
        answerIndex = 2,
        explanation = "Because the same `bucket` object is passed every time, both keys can end up pointing at the same shared list."
    ),
    Problem(
        id = "output_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort Then Reverse",
        summary = "A copied list is sorted and then flipped before printing.",
        prompt = "What does this code print?",
        code = """
            nums = [4, 1, 3]
            ordered = sorted(nums)
            ordered.reverse()
            print(nums)
            print(ordered)
        """.trimIndent(),
        options = listOf(
            "[4, 1, 3]\n[4, 3, 1]",
            "[1, 3, 4]\n[4, 3, 1]",
            "[4, 1, 3]\n[1, 3, 4]",
            "[4, 3, 1]\n[4, 1, 3]"
        ),
        answerIndex = 0,
        explanation = "`sorted(nums)` creates a new list `[1, 3, 4]`, `reverse()` changes that copy to `[4, 3, 1]`, and `nums` stays unchanged."
    ),
    Problem(
        id = "purpose_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep Latest Status Per User",
        summary = "A loop writes each status under the user name, replacing older values when the same name appears again.",
        prompt = "What does this code build in `latest`?",
        code = """
            updates = [("Ana", "new"), ("Bob", "done"), ("Ana", "review")]
            latest = {}
            for name, status in updates:
                latest[name] = status
        """.trimIndent(),
        options = listOf(
            "It groups all statuses for each user into separate lists",
            "It counts how many updates each user has",
            "It keeps only the most recent status seen for each user",
            "It removes repeated users from `updates`"
        ),
        answerIndex = 2,
        explanation = "Assigning to the same dictionary key again replaces the older value, so each user ends with the last status seen."
    ),
    Problem(
        id = "fill_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Append a Computed Value",
        summary = "The loop should store the length of each word in a result list.",
        prompt = "Which choice fills the blank so `lengths` becomes `[2, 3]`?",
        code = """
            words = ["go", "sun"]
            lengths = []
            for word in words:
                lengths.___(len(word))
            print(lengths)
        """.trimIndent(),
        options = listOf(
            "add",
            "append",
            "extend",
            "insert"
        ),
        answerIndex = 1,
        explanation = "`append()` adds one item at a time, so each computed length is added as a single element."
    ),
    Problem(
        id = "order_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Names That Start With A",
        summary = "Arrange the lines so the function counts names whose first letter is uppercase A.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def count_a(names):",
            "    total = 0",
            "    for name in names:",
            "        if name.startswith(\"A\"):",
            "            total += 1",
            "    return total"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function needs the counter before the loop, the conditional increment inside the loop, and the return after all names are checked."
    ),
    Problem(
        id = "complexity_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Linear Search Per Query",
        summary = "Every query scans the full list of values until it finds a match or reaches the end.",
        prompt = "What is the time complexity in terms of `q = len(queries)` and `n = len(values)`?",
        code = """
            matches = 0
            for query in queries:
                if query in values:
                    matches += 1
        """.trimIndent(),
        options = listOf(
            "O(q + n)",
            "O(n)",
            "O(q * n)",
            "O(q)"
        ),
        answerIndex = 2,
        explanation = "The outer loop runs once per query, and each `in values` check can scan the whole list, so the total work is `O(q * n)`."
    ),
    Problem(
        id = "trace_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a Filtered Sum",
        summary = "Only values greater than 2 are added, then one more adjustment happens at the end.",
        prompt = "What is the value of `score` after this code runs?",
        code = """
            score = 1
            for value in [2, 5, 1, 4]:
                if value > 2:
                    score += value
            score *= 2
        """.trimIndent(),
        options = listOf(
            "10",
            "20",
            "24",
            "18"
        ),
        answerIndex = 1,
        explanation = "The loop adds 5 and 4 to the starting value 1, giving 10, and the final multiplication changes it to 20."
    ),
    Problem(
        id = "match_medium_junior_67",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 1, 'b': 1}",
        summary = "Pick the snippet that counts the first letter of each word in the list.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"ant\", \"bat\"]\nprint({word[0]: len(word) for word in words})",
            "words = [\"ant\", \"bat\"]\nprint({word: 1 for word in words})",
            "words = [\"ant\", \"bat\"]\nprint({word[0]: word.count(\"a\") for word in words})",
            "words = [\"ant\", \"bat\"]\nprint({word[0]: 1 for word in words})"
        ),
        answerIndex = 3,
        explanation = "Only the fourth snippet uses each word's first letter as the key and assigns `1` to both entries."
    )
)
