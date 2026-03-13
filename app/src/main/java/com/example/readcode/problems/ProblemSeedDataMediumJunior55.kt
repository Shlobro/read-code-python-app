package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior55 = listOf(
    Problem(
        id = "bug_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Resetting the Running Maximum",
        summary = "The loop forgets the best value seen so far.",
        prompt = "What is the actual bug in this function?",
        code = """
            def max_score(scores):
                best = scores[0]
                for score in scores[1:]:
                    best = score
                    if score > best:
                        best = score
                return best
        """.trimIndent(),
        options = listOf(
            "The function should sort the list before scanning for a maximum",
            "It compares strings instead of numbers",
            "`best` is overwritten before the comparison",
            "The loop should include `scores[0]` again"
        ),
        answerIndex = 2,
        explanation = "Assigning `best = score` before the comparison makes `score > best` false on every iteration, so earlier larger values are lost."
    ),
    Problem(
        id = "output_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort Then Slice",
        summary = "The list is reordered before one item is printed.",
        prompt = "What gets printed?",
        code = """
            nums = [4, 1, 3, 2]
            nums.sort(reverse=True)
            print(nums[1])
        """.trimIndent(),
        options = listOf(
            "1",
            "2",
            "4",
            "3"
        ),
        answerIndex = 3,
        explanation = "After sorting in descending order, `nums` becomes `[4, 3, 2, 1]`, so index 1 holds `3`."
    ),
    Problem(
        id = "purpose_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group Names by First Letter",
        summary = "A dictionary of lists is built one name at a time.",
        prompt = "What does this function return?",
        code = """
            def group_by_first(names):
                grouped = {}
                for name in names:
                    key = name[0]
                    grouped.setdefault(key, []).append(name)
                return grouped
        """.trimIndent(),
        options = listOf(
            "Names grouped by first character in a dictionary",
            "A sorted list of the unique first characters",
            "A count of how many letters each name contains",
            "The longest name found for each starting character"
        ),
        answerIndex = 0,
        explanation = "For each name, the code uses the first character as the key and appends the full name into that key's list."
    ),
    Problem(
        id = "fill_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy Before Sorting",
        summary = "The code needs a separate sorted list without changing the original.",
        prompt = "Which option fills the blank correctly?",
        code = """
            scores = [30, 10, 20]
            ordered = ___(scores)
            print(scores)
            print(ordered)
        """.trimIndent(),
        options = listOf(
            "list.sort",
            "reversed",
            "sorted",
            "append"
        ),
        answerIndex = 2,
        explanation = "`sorted(scores)` returns a new sorted list and leaves `scores` unchanged."
    ),
    Problem(
        id = "order_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Collect Long Words",
        summary = "Arrange the lines to return words with length at least 5.",
        prompt = "Arrange the lines so the function returns only the long words.",
        code = "",
        options = listOf(
            "def long_words(words):",
            "    result = []",
            "    for word in words:",
            "        if len(word) >= 5:",
            "            result.append(word)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, create the result list, loop through the words, filter by length, append matches, and return the list."
    ),
    Problem(
        id = "complexity_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Separate Passes",
        summary = "The code walks the same list twice in sequence.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            total = 0
            for value in values:
                total += value

            count = 0
            for value in values:
                if value > 0:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "Each loop is linear, and running two linear passes still gives O(n) overall."
    ),
    Problem(
        id = "trace_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Update Through an Alias",
        summary = "Two variables refer to the same dictionary.",
        prompt = "What is the value of `profile[\"visits\"]` after this code runs?",
        code = """
            profile = {"name": "Mia", "visits": 1}
            current = profile
            current["visits"] += 2
        """.trimIndent(),
        options = listOf(
            "1",
            "2",
            "4",
            "3"
        ),
        answerIndex = 3,
        explanation = "`current` and `profile` reference the same dictionary, so incrementing through `current` changes `profile` to `3` visits."
    ),
    Problem(
        id = "match_medium_junior_55",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 0 1 2",
        summary = "Pick the snippet that prints the numbers on one line with spaces.",
        prompt = "Which snippet produces this exact output?",
        code = """
            0 1 2
        """.trimIndent(),
        options = listOf(
            "for i in range(3): print(i)",
            "print(*range(3))",
            "print(list(range(3)))",
            "print(\"0,1,2\")"
        ),
        answerIndex = 1,
        explanation = "Unpacking `range(3)` passes `0`, `1`, and `2` as separate `print` arguments, so they appear on one line separated by spaces."
    )
)
