package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior30 = listOf(
    Problem(
        id = "bug_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared rows in a grid",
        summary = "A 2D list looks correct at first, but one update changes multiple rows.",
        prompt = "What is the real bug in this code?",
        code = """
            grid = [[0] * 3] * 2
            grid[0][1] = 9
            print(grid)
        """.trimIndent(),
        options = listOf(
            "Both rows reference the same inner list, so changing one row changes the other",
            "The code should use tuples because lists cannot hold lists",
            "Index 1 is out of range for a row of length 3",
            "`print(grid)` should be inside a loop to show both rows"
        ),
        answerIndex = 0,
        explanation = "Using `* 2` duplicates the same inner list reference. Updating `grid[0][1]` also changes `grid[1][1]`."
    ),
    Problem(
        id = "output_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sorted copy vs original",
        summary = "One list is sorted into a new list while the original stays the same.",
        prompt = "What does this code print?",
        code = """
            nums = [3, 1, 2]
            ordered = sorted(nums)
            nums.append(0)
            print(ordered)
            print(nums)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]\n[3, 1, 2, 0]",
            "[3, 1, 2, 0]\n[1, 2, 3]",
            "[1, 2, 3, 0]\n[1, 2, 3]",
            "[3, 1, 2]\n[0, 1, 2, 3]"
        ),
        answerIndex = 0,
        explanation = "`sorted(nums)` returns a new sorted list. Appending `0` later changes only the original `nums` list."
    ),
    Problem(
        id = "purpose_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group names by first letter",
        summary = "The function builds a dictionary of lists based on the first character of each name.",
        prompt = "What does this function return overall?",
        code = """
            def group_by_first_letter(names):
                groups = {}
                for name in names:
                    letter = name[0]
                    groups.setdefault(letter, []).append(name)
                return groups
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each starting letter to the names that begin with it",
            "A list of names sorted alphabetically",
            "A dictionary counting how many letters are in each name",
            "A list containing only names with unique first letters"
        ),
        answerIndex = 0,
        explanation = "`setdefault(letter, [])` ensures a list exists for each first letter, and each matching name is appended to that list."
    ),
    Problem(
        id = "fill_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent row lists",
        summary = "The code should create a fresh inner list for each row.",
        prompt = "Which option fills the blank correctly?",
        code = """
            rows = []
            for _ in range(3):
                rows.append(__)
        """.trimIndent(),
        options = listOf(
            "[]",
            "[0] * 3",
            "rows",
            "None"
        ),
        answerIndex = 0,
        explanation = "Appending `[]` each time creates a new empty list on every loop iteration, so the rows stay independent."
    ),
    Problem(
        id = "order_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a frequency map",
        summary = "Arrange the lines so the code counts how often each word appears.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "counts = {}",
            "for word in words:",
            "words = [\"red\", \"blue\", \"red\"]",
            "    counts[word] = counts.get(word, 0) + 1",
            "print(counts)"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1, 3, 4),
        explanation = "Define the input list and result dictionary first, then loop through the words, update each count, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Prefix sums with nested work",
        summary = "The inner loop runs more times as the outer index grows.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            total = 0
            for i in range(n):
                for j in range(i + 1):
                    total += j
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(n^3)"
        ),
        answerIndex = 0,
        explanation = "The inner loop runs 1 + 2 + ... + n times overall, which grows on the order of `n^2`."
    ),
    Problem(
        id = "trace_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Follow the queue",
        summary = "Elements are appended and removed from the front in sequence.",
        prompt = "What is the value of `queue` after the code finishes?",
        code = """
            queue = ["a", "b"]
            queue.append("c")
            first = queue.pop(0)
            queue.append(first.upper())
        """.trimIndent(),
        options = listOf(
            "['b', 'c', 'A']",
            "['a', 'b', 'c']",
            "['b', 'A']",
            "['c', 'A', 'b']"
        ),
        answerIndex = 0,
        explanation = "After appending `c`, the list is `['a', 'b', 'c']`. Popping index 0 removes `'a'`, then `'A'` is appended."
    ),
    Problem(
        id = "match_medium_junior_30",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'x': 2, 'y': 1}",
        summary = "Which snippet counts repeated letters from the string `\"xyx\"`?",
        prompt = "Which code prints `{'x': 2, 'y': 1}`?",
        code = "",
        options = listOf(
            "text = \"xyx\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"xyx\"\ncounts = {}\nfor ch in text:\n    counts[ch] = 1\nprint(counts)",
            "text = \"xyx\"\ncounts = []\nfor ch in text:\n    counts.append(ch)\nprint(counts)",
            "text = \"xyx\"\nprint({\"x\": 1, \"y\": 2})"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet increments a running count for each character, producing two `x` entries and one `y`."
    )
)
