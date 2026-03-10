package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior33 = listOf(
    Problem(
        id = "bug_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Reset inside the loop",
        summary = "A running total is supposed to add the large values in the list.",
        prompt = "What is the actual bug in this code?",
        code = """
            values = [4, 7, 9]
            total = 0

            for value in values:
                if value > 5:
                    total = 0
                    total += value

            print(total)
        """.trimIndent(),
        options = listOf(
            "`total` is reset inside the loop, so earlier qualifying values are lost",
            "The `if` condition should be `value >= 5`",
            "`print(total)` must be inside the loop",
            "The list must be sorted before the loop runs"
        ),
        answerIndex = 0,
        explanation = "Resetting `total` inside the `if` block discards any previous sum. The code keeps only the last matching value instead of accumulating them."
    ),
    Problem(
        id = "output_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Mutate then slice",
        summary = "The list is changed before a slice is printed.",
        prompt = "What does this code print?",
        code = """
            scores = [10, 20, 30, 40]
            scores.pop(1)
            print(scores[1:])
        """.trimIndent(),
        options = listOf("[30, 40]", "[20, 30, 40]", "[10, 30, 40]", "[20, 40]"),
        answerIndex = 0,
        explanation = "`pop(1)` removes `20`, leaving `[10, 30, 40]`. Slicing from index 1 prints `[30, 40]`."
    ),
    Problem(
        id = "purpose_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group words by first letter",
        summary = "A dictionary of lists is built while looping through the words.",
        prompt = "What does this function return overall?",
        code = """
            def group_words(words):
                groups = {}
                for word in words:
                    first = word[0]
                    groups.setdefault(first, []).append(word)
                return groups
        """.trimIndent(),
        options = listOf(
            "A dictionary that groups words by their starting letter",
            "A list of the first letters from each word",
            "A dictionary that stores the length of each word",
            "A sorted copy of the words list"
        ),
        answerIndex = 0,
        explanation = "`setdefault` creates a list for each first letter, and each word is appended to the matching list."
    ),
    Problem(
        id = "fill_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy before changing",
        summary = "The code should make an independent copy of the list before appending a new value.",
        prompt = "Which option fills the blank correctly?",
        code = """
            original = [1, 2, 3]
            updated = original.___()
            updated.append(4)
            print(original, updated)
        """.trimIndent(),
        options = listOf("copy", "clear", "sort", "reverse"),
        answerIndex = 0,
        explanation = "`copy()` creates a shallow copy of the list, so appending to `updated` does not change `original`."
    ),
    Problem(
        id = "order_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect uppercase names",
        summary = "Arrange the lines so the code builds a new list of uppercase names and prints it.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "names = [\"ana\", \"bo\"]",
            "upper_names = []",
            "for name in names:",
            "    upper_names.append(name.upper())",
            "print(upper_names)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the source list and result list first, then loop through the names, append each uppercase version, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Search each row",
        summary = "The code checks every value in a square grid in the worst case.",
        prompt = "What is the worst-case time complexity in terms of `n` for an `n x n` grid?",
        code = """
            found = False
            for row in grid:
                for value in row:
                    if value == target:
                        found = True
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "In the worst case, both loops examine all `n * n` values in the grid, which is O(n^2)."
    ),
    Problem(
        id = "trace_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a dictionary value",
        summary = "The same key is updated multiple times in a loop.",
        prompt = "What is the value of `counts[\"ok\"]` after the code finishes?",
        code = """
            counts = {"ok": 1}
            for step in [2, 3]:
                counts["ok"] += step
        """.trimIndent(),
        options = listOf("6", "5", "3", "1"),
        answerIndex = 0,
        explanation = "The value starts at 1, then becomes 3 after adding 2, then 6 after adding 3."
    ),
    Problem(
        id = "match_medium_junior_33",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['A', 'B', 'C']",
        summary = "Which snippet converts each lowercase letter to uppercase before printing the list?",
        prompt = "Which code prints `['A', 'B', 'C']`?",
        code = "",
        options = listOf(
            "letters = ['a', 'b', 'c']\nprint([letter.upper() for letter in letters])",
            "letters = ['a', 'b', 'c']\nprint('ABC')",
            "letters = ['a', 'b', 'c']\nprint([letters.upper()])",
            "letters = ['a', 'b', 'c']\nprint(list('abc'))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet applies `.upper()` to each item and prints the resulting list of uppercase strings."
    )
)
