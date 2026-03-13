package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior61 = listOf(
    Problem(
        id = "bug_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Reused Dictionary Slot",
        summary = "Each loop pass writes to the same key instead of using the current name.",
        prompt = "What is the actual bug in this function?",
        code = """
            def build_scores(names):
                scores = {}
                for index, name in enumerate(names):
                    scores["name"] = index
                return scores
        """.trimIndent(),
        options = listOf(
            "The loop should start at 1",
            "It writes to `\"name\"` on every loop",
            "`enumerate(names)` must be converted to a list first",
            "The function should return `index` instead of `scores`"
        ),
        answerIndex = 1,
        explanation = "Using the literal key `\"name\"` overwrites the same entry every time, so only the last value remains."
    ),
    Problem(
        id = "output_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Join",
        summary = "A middle slice is turned back into text.",
        prompt = "What does this code print?",
        code = """
            letters = ["a", "b", "c", "d"]
            part = letters[1:3]
            print("-".join(part))
        """.trimIndent(),
        options = listOf(
            "a-b-c",
            "b-c",
            "b-c-d",
            "['b', 'c']"
        ),
        answerIndex = 1,
        explanation = "The slice `letters[1:3]` produces `['b', 'c']`, and `join` combines those items into `b-c`."
    ),
    Problem(
        id = "purpose_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Pick Existing Tags",
        summary = "The comprehension keeps only keys whose values are true.",
        prompt = "What does this expression build?",
        code = """
            tags = {"new": True, "sale": False, "popular": True}
            active = [name for name, enabled in tags.items() if enabled]
        """.trimIndent(),
        options = listOf(
            "A list of tag names whose value is `True`",
            "A dictionary of tags sorted by name",
            "A count of how many tags exist",
            "A list of every boolean value in the dictionary"
        ),
        answerIndex = 0,
        explanation = "The comprehension keeps `name` only for items where `enabled` is true, so it returns the active tag names."
    ),
    Problem(
        id = "fill_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Update by Position",
        summary = "The code should replace only the second item in the list.",
        prompt = "Which choice fills the blank so the list becomes `[10, 99, 30]`?",
        code = """
            values = [10, 20, 30]
            values[___] = 99
            print(values)
        """.trimIndent(),
        options = listOf(
            "2",
            "1",
            "-1",
            "0"
        ),
        answerIndex = 1,
        explanation = "List indexes are zero-based, so index `1` refers to the second element."
    ),
    Problem(
        id = "order_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build Even Squares",
        summary = "Arrange the lines to square only even numbers and return the results.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def even_squares(values):",
            "    result = []",
            "    for value in values:",
            "        if value % 2 == 0:",
            "            result.append(value * value)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function needs the result list first, then the loop, then the even check and append, followed by the return."
    ),
    Problem(
        id = "complexity_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Range Sum",
        summary = "A full inner loop runs for every outer-loop step.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for i in range(n):
                for j in range(n):
                    total += i + j
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(n^3)"
        ),
        answerIndex = 2,
        explanation = "There are `n` outer iterations and `n` inner iterations for each one, giving `n * n` total work."
    ),
    Problem(
        id = "trace_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Insert Then Remove",
        summary = "The list changes shape twice before the final value is checked.",
        prompt = "What is the value of `items` after this code runs?",
        code = """
            items = ["x", "y", "z"]
            items.insert(1, "a")
            items.pop(2)
        """.trimIndent(),
        options = listOf(
            "['x', 'a', 'y', 'z']",
            "['x', 'a', 'z']",
            "['x', 'y', 'z']",
            "['x', 'y', 'a']"
        ),
        answerIndex = 1,
        explanation = "After the insert, the list is `['x', 'a', 'y', 'z']`. Popping index `2` removes `'y'`, leaving `['x', 'a', 'z']`."
    ),
    Problem(
        id = "match_medium_junior_61",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 1, 'b': 1}",
        summary = "Pick the snippet that counts the first letters in the list.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "words = [\"ant\", \"bat\"]\ncounts = {}\nfor word in words:\n    counts[word[0]] = counts.get(word[0], 0) + len(word)\nprint(counts)",
            "words = [\"ant\", \"bat\"]\ncounts = {}\nfor word in words:\n    counts[word] = 1\nprint(counts)",
            "words = [\"ant\", \"bat\"]\ncounts = {}\nfor word in words:\n    counts[word[0]] = counts.get(word[0], 0) + 1\nprint(counts)",
            "words = [\"ant\", \"bat\"]\ncounts = []\nfor word in words:\n    counts.append(word[0])\nprint(counts)"
        ),
        answerIndex = 2,
        explanation = "Only the third snippet counts occurrences by first character, producing `{'a': 1, 'b': 1}`."
    )
)
