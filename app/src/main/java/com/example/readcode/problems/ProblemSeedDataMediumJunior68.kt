package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior68 = listOf(
    Problem(
        id = "bug_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Rows Mirror Each Other",
        summary = "A grid should have separate rows, but changing one row also changes the others.",
        prompt = "What is the real bug in this code?",
        code = """
            grid = [[0] * 3] * 2
            grid[0][1] = 9
            print(grid)
        """.trimIndent(),
        options = listOf(
            "The assignment should use `=` only inside a loop",
            "Each row refers to the same inner list",
            "The index `[0][1]` is out of range for this grid",
            "List multiplication cannot be used with numbers"
        ),
        answerIndex = 1,
        explanation = "List multiplication copied the reference to one inner list, so both rows point at the same object."
    ),
    Problem(
        id = "output_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Rebind Then Mutate",
        summary = "One variable is rebound to a new list while another still points at the old list.",
        prompt = "What does this code print?",
        code = """
            values = [1, 2]
            alias = values
            values = values + [3]
            alias.append(4)
            print(values)
            print(alias)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 4]\n[1, 2, 3, 4]",
            "[1, 2, 4]\n[1, 2, 3]",
            "[1, 2, 3]\n[1, 2, 4]",
            "[1, 2]\n[1, 2, 3, 4]"
        ),
        answerIndex = 2,
        explanation = "`values + [3]` creates a new list, so `values` becomes `[1, 2, 3]` while `alias` still points at the old list, which becomes `[1, 2, 4]` after `append(4)`."
    ),
    Problem(
        id = "purpose_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Count Words by Length",
        summary = "A loop updates a dictionary using each word length as the key.",
        prompt = "What does this code store in `counts`?",
        code = """
            words = ["hi", "sun", "to", "cat"]
            counts = {}
            for word in words:
                size = len(word)
                counts[size] = counts.get(size, 0) + 1
        """.trimIndent(),
        options = listOf(
            "It groups the words into lists by their first letter",
            "It counts how many words have each length",
            "It keeps only the longest word for each length",
            "It removes duplicate words before counting"
        ),
        answerIndex = 1,
        explanation = "The dictionary key is the length, and each time that length appears the stored count is increased by one."
    ),
    Problem(
        id = "fill_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Take the First Job",
        summary = "The code should remove and return the first item from a queue list.",
        prompt = "Which choice fills the blank so `job` becomes `\"build\"` and `queue` becomes `[\"test\"]`?",
        code = """
            queue = ["build", "test"]
            job = queue.___(0)
            print(job)
            print(queue)
        """.trimIndent(),
        options = listOf(
            "remove",
            "pop",
            "clear",
            "append"
        ),
        answerIndex = 1,
        explanation = "`pop(0)` removes the item at index 0 and returns it."
    ),
    Problem(
        id = "order_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build Initial Letters",
        summary = "Arrange the lines so the function returns the first letter of each name in order.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def initials(names):",
            "    letters = []",
            "    for name in names:",
            "        letters.append(name[0])",
            "    return letters"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The result list must be created before the loop, updated inside the loop, and returned after all names are processed."
    ),
    Problem(
        id = "complexity_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Visit Every Cell",
        summary = "Two nested loops walk through every value in a rectangular grid.",
        prompt = "What is the time complexity in terms of `r = len(grid)` and `c = len(grid[0])`?",
        code = """
            total = 0
            for row in grid:
                for value in row:
                    total += value
        """.trimIndent(),
        options = listOf(
            "O(r)",
            "O(c)",
            "O(r * c)",
            "O(r + c)"
        ),
        answerIndex = 2,
        explanation = "The outer loop visits each row and the inner loop visits each value in that row, so every cell is processed once."
    ),
    Problem(
        id = "trace_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a Running Difference",
        summary = "A variable is increased and decreased as the loop processes signed values.",
        prompt = "What is the value of `balance` after this code runs?",
        code = """
            balance = 10
            for change in [3, -4, 2]:
                balance += change
            balance -= 1
        """.trimIndent(),
        options = listOf(
            "10",
            "9",
            "11",
            "8"
        ),
        answerIndex = 0,
        explanation = "The loop changes `balance` from 10 to 13, then 9, then 11, and the final subtraction makes it 10."
    ),
    Problem(
        id = "match_medium_junior_68",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Pick the snippet that counts how many words start with each first letter.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"ant\", \"apple\", \"bat\"]\ncounts = {}\nfor word in words:\n    first = word[0]\n    counts[first] = counts.get(first, 0) + 1\nprint(counts)",
            "words = [\"ant\", \"apple\", \"bat\"]\ncounts = {}\nfor word in words:\n    counts[word[0]] = len(word)\nprint(counts)",
            "words = [\"ant\", \"apple\", \"bat\"]\npairs = {}\nfor word in words:\n    pairs[word] = word[0]\nprint(pairs)",
            "words = [\"ant\", \"apple\", \"bat\"]\ncounts = {}\nfor word in words:\n    counts[word[0]] = 1\nprint(counts)"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet increments the count for repeated first letters, producing `'a': 2` and `'b': 1`."
    )
)
