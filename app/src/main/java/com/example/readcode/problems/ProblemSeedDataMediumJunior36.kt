package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior36 = listOf(
    Problem(
        id = "bug_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong dictionary lookup",
        summary = "The loop has the right keys, but it reads from the wrong dictionary key each time.",
        prompt = "What is the actual bug in this code?",
        code = """
            prices = {"apple": 2, "banana": 3, "pear": 4}
            total = 0

            for item in prices:
                total += prices["item"]

            print(total)
        """.trimIndent(),
        options = listOf(
            "It uses the string \"item\" instead of the loop variable `item` as the key",
            "The loop should be `for item in prices.values()`",
            "`total` should start as an empty dictionary",
            "The `print` call must be inside the loop"
        ),
        answerIndex = 0,
        explanation = "The loop variable is named `item`, but `prices[\"item\"]` looks for a literal key named `item`, which is not in the dictionary."
    ),
    Problem(
        id = "output_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort then slice",
        summary = "The list is sorted in place before taking the last two values.",
        prompt = "What does this code print?",
        code = """
            numbers = [7, 2, 5, 1]
            numbers.sort()
            print(numbers[-2:])
        """.trimIndent(),
        options = listOf("[5, 7]", "[1, 2]", "[2, 5]", "[7, 5]"),
        answerIndex = 0,
        explanation = "After sorting, the list becomes `[1, 2, 5, 7]`. The slice `[-2:]` returns the last two items: `[5, 7]`."
    ),
    Problem(
        id = "purpose_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep latest status",
        summary = "The function builds a dictionary from a list of updates.",
        prompt = "What does this function return overall?",
        code = """
            def build_status_map(updates):
                result = {}
                for name, status in updates:
                    result[name] = status
                return result
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each name to its most recent status",
            "A list of names that appear more than once",
            "A count of how many updates each name has",
            "A list of status values in alphabetical order"
        ),
        answerIndex = 0,
        explanation = "Each `(name, status)` pair is written into the dictionary. If a name appears again, its value is replaced with the newer status."
    ),
    Problem(
        id = "fill_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy before changing",
        summary = "The code should make a shallow copy of the list before appending.",
        prompt = "Which option fills the blank correctly?",
        code = """
            original = [1, 2, 3]
            copy_list = original.___()
            copy_list.append(4)
            print(original, copy_list)
        """.trimIndent(),
        options = listOf("copy", "clone", "duplicate", "slice"),
        answerIndex = 0,
        explanation = "`.copy()` creates a shallow copy of the list, so appending to `copy_list` does not change `original`."
    ),
    Problem(
        id = "order_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a name lookup",
        summary = "Arrange the lines so the code creates a dictionary from user records and prints one score.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "records = [(\"Ana\", 5), (\"Ben\", 8)]",
            "scores = {}",
            "for name, score in records:",
            "    scores[name] = score",
            "print(scores[\"Ben\"])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the source data and destination dictionary first, fill the dictionary inside the loop, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Double scan",
        summary = "Two separate loops each walk through the whole list once.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            total = 0
            for value in items:
                total += value

            count = 0
            for value in items:
                if value > 10:
                    count += 1
        """.trimIndent(),
        options = listOf("O(n)", "O(n^2)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "The code makes two linear passes over the same list. `n + n` is still linear, so the overall complexity is O(n)."
    ),
    Problem(
        id = "trace_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace after insert",
        summary = "A list is modified at a specific index and then trimmed.",
        prompt = "What is the value of `letters` after the code finishes?",
        code = """
            letters = ["a", "c", "d"]
            letters.insert(1, "b")
            letters = letters[:-1]
        """.trimIndent(),
        options = listOf("[\"a\", \"b\", \"c\"]", "[\"a\", \"c\", \"d\"]", "[\"a\", \"b\", \"c\", \"d\"]", "[\"b\", \"c\", \"d\"]"),
        answerIndex = 0,
        explanation = "After `insert(1, \"b\")`, the list becomes `[\"a\", \"b\", \"c\", \"d\"]`. The slice `[:-1]` removes the last item, leaving `[\"a\", \"b\", \"c\"]`."
    ),
    Problem(
        id = "match_medium_junior_36",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'x': 2, 'y': 4}",
        summary = "Which snippet builds a dictionary of doubled values from the input pairs?",
        prompt = "Which code prints `{'x': 2, 'y': 4}`?",
        code = "",
        options = listOf(
            "pairs = [(\"x\", 1), (\"y\", 2)]\nresult = {}\nfor key, value in pairs:\n    result[key] = value * 2\nprint(result)",
            "pairs = [(\"x\", 1), (\"y\", 2)]\nresult = {}\nfor key, value in pairs:\n    result[value] = key * 2\nprint(result)",
            "pairs = [(\"x\", 1), (\"y\", 2)]\nresult = []\nfor key, value in pairs:\n    result.append((key, value * 2))\nprint(result)",
            "pairs = [(\"x\", 1), (\"y\", 2)]\nprint({\"x\": 1, \"y\": 2})"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet creates a dictionary whose values are doubled, producing `{'x': 2, 'y': 4}`."
    )
)
