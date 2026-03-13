package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior62 = listOf(
    Problem(
        id = "bug_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Bucket List",
        summary = "Each key should get its own list, but one line reuses the same list every time.",
        prompt = "What is the real bug in this function?",
        code = """
            def group_scores(names):
                buckets = {}
                current = []
                for name in names:
                    current.append(len(name))
                    buckets[name] = current
                return buckets
        """.trimIndent(),
        options = listOf(
            "The loop should use `enumerate(names)`",
            "`len(name)` must be converted to a string first",
            "Every key points to the same `current` list",
            "Dictionaries cannot store lists as values"
        ),
        answerIndex = 2,
        explanation = "The code appends to one shared list and stores that same list under every key, so all dictionary values end up linked."
    ),
    Problem(
        id = "output_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort Then Slice",
        summary = "The list is sorted in place before taking the middle items.",
        prompt = "What does this code print?",
        code = """
            values = [4, 1, 3, 2]
            values.sort()
            print(values[1:3])
        """.trimIndent(),
        options = listOf(
            "[2, 3]",
            "[1, 2]",
            "[4, 1]",
            "[1, 2, 3]"
        ),
        answerIndex = 0,
        explanation = "After sorting, the list becomes `[1, 2, 3, 4]`, and the slice `values[1:3]` returns `[2, 3]`."
    ),
    Problem(
        id = "purpose_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Row Totals",
        summary = "The loop reduces each inner list to one number.",
        prompt = "What does this code build in `totals`?",
        code = """
            rows = [[2, 3], [1, 4, 5], [7]]
            totals = []
            for row in rows:
                totals.append(sum(row))
        """.trimIndent(),
        options = listOf(
            "A flattened list of every value",
            "The largest number from each row",
            "A count of items in each row",
            "The sum of each inner list"
        ),
        answerIndex = 3,
        explanation = "Each pass computes `sum(row)` and appends that total, so `totals` holds one sum per inner list."
    ),
    Problem(
        id = "fill_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Snapshot Before Reset",
        summary = "The code should save the current row before clearing it for reuse.",
        prompt = "Which choice fills the blank so `rows` keeps separate copies?",
        code = """
            rows = []
            current = [1, 2]
            rows.append(current.___())
            current.clear()
            print(rows)
        """.trimIndent(),
        options = listOf(
            "clear",
            "copy",
            "sort",
            "reverse"
        ),
        answerIndex = 1,
        explanation = "Using `copy()` stores a separate list in `rows`, so clearing `current` does not erase the saved values."
    ),
    Problem(
        id = "order_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Long Words",
        summary = "Arrange the lines to count words longer than three letters.",
        prompt = "Arrange the lines so the function returns the correct count.",
        code = "",
        options = listOf(
            "def count_long(words):",
            "    count = 0",
            "    for word in words:",
            "        if len(word) > 3:",
            "            count += 1",
            "    return count"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function needs initialization before the loop, then the length check, increment, and final return."
    ),
    Problem(
        id = "complexity_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Growing Prefixes",
        summary = "The inner loop runs one more time on each outer iteration.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for i in range(n):
                for j in range(i + 1):
                    total += 1
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(n^3)"
        ),
        answerIndex = 2,
        explanation = "The work is `1 + 2 + ... + n`, which grows proportionally to `n^2`."
    ),
    Problem(
        id = "trace_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Update Then Pop",
        summary = "The list changes twice before its final state is checked.",
        prompt = "What is the value of `nums` after this code runs?",
        code = """
            nums = [5, 10, 15]
            nums[1] = nums[0] + nums[2]
            nums.pop(0)
        """.trimIndent(),
        options = listOf(
            "[5, 20, 15]",
            "[20, 15]",
            "[10, 15]",
            "[15, 20]"
        ),
        answerIndex = 1,
        explanation = "After the assignment the list is `[5, 20, 15]`. Popping index `0` removes `5`, leaving `[20, 15]`."
    ),
    Problem(
        id = "match_medium_junior_62",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each number in the list.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nresult = []\nfor num in nums:\n    result.append(num + 1)\nprint(result)",
            "nums = [1, 2, 3]\nresult = []\nfor num in nums:\n    result.append(num * num)\nprint(result)",
            "nums = [2, 4, 6]\nprint(nums[1:])",
            "nums = [1, 2, 3]\nresult = []\nfor num in nums:\n    result.append(num * 2)\nprint(result)"
        ),
        answerIndex = 3,
        explanation = "Only the fourth snippet multiplies each input value by 2 and prints `[2, 4, 6]`."
    )
)
