package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior63 = listOf(
    Problem(
        id = "bug_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Return Too Early",
        summary = "The function should scan every word, but one line stops it after the first item.",
        prompt = "What is the real bug in this function?",
        code = """
            def collect_long(words):
                result = []
                for word in words:
                    if len(word) > 4:
                        result.append(word)
                    return result
        """.trimIndent(),
        options = listOf(
            "`append` should be `extend`",
            "The `return` is inside the loop",
            "`result` should start as a set",
            "The comparison must use `>= 4`"
        ),
        answerIndex = 1,
        explanation = "Because `return result` is indented under the loop, the function exits after the first iteration instead of checking every word."
    ),
    Problem(
        id = "output_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Copy Then Change",
        summary = "A shallow copy is changed before both lists are printed.",
        prompt = "What does this code print?",
        code = """
            nums = [2, 4, 6]
            other = nums[:]
            other[1] = other[0] + other[2]
            print(nums, other)
        """.trimIndent(),
        options = listOf(
            "[2, 8, 6] [2, 8, 6]",
            "[2, 4, 6] [2, 4, 6]",
            "[2, 4, 6] [2, 6]",
            "[2, 4, 6] [2, 8, 6]"
        ),
        answerIndex = 3,
        explanation = "The slice creates a separate list, so changing `other` does not change `nums`. `other[1]` becomes `2 + 6`, so it prints `[2, 4, 6] [2, 8, 6]`."
    ),
    Problem(
        id = "purpose_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Names by First Letter",
        summary = "The loop groups words under a dictionary key based on the first character.",
        prompt = "What does this code build in `groups`?",
        code = """
            names = ["amy", "adam", "bella"]
            groups = {}
            for name in names:
                first = name[0]
                groups.setdefault(first, []).append(name)
        """.trimIndent(),
        options = listOf(
            "A count of vowels in each name",
            "Names grouped by first letter",
            "The names sorted by length",
            "A map from each name to its index"
        ),
        answerIndex = 1,
        explanation = "For each name, `setdefault` creates or reuses a list for that starting letter, then appends the name to that list."
    ),
    Problem(
        id = "fill_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Unique Values",
        summary = "The code should add unseen items while keeping insertion order.",
        prompt = "Which choice fills the blank so duplicates are skipped?",
        code = """
            result = []
            for value in [3, 1, 3, 2]:
                if value not in result:
                    result.___(value)
            print(result)
        """.trimIndent(),
        options = listOf(
            "remove",
            "extend",
            "append",
            "sort"
        ),
        answerIndex = 2,
        explanation = "Once the duplicate check passes, `append(value)` adds that single unseen value to the end of `result`."
    ),
    Problem(
        id = "order_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build Index Labels",
        summary = "Arrange the lines to collect `index:value` strings from a list.",
        prompt = "Arrange the lines so the function returns the right labels.",
        code = "",
        options = listOf(
            "def label_items(items):",
            "    labels = []",
            "    for index, item in enumerate(items):",
            "        labels.append(f\"{index}:{item}\")",
            "    return labels"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The function needs its definition first, then the accumulator, then the loop body that appends labels, and finally the return."
    ),
    Problem(
        id = "complexity_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Sort Before Print",
        summary = "Most of the work comes from ordering the list once before a linear pass.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            values.sort()
            for value in values:
                print(value)
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(log n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "Sorting is `O(n log n)` and the loop is `O(n)`, so the overall runtime is dominated by `O(n log n)`."
    ),
    Problem(
        id = "trace_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Append",
        summary = "Track a list after taking a slice and then adding one more value.",
        prompt = "What is the value of `part` after this code runs?",
        code = """
            values = [10, 20, 30, 40]
            part = values[1:3]
            part.append(values[-1] - values[0])
        """.trimIndent(),
        options = listOf(
            "[20, 30]",
            "[10, 20, 30]",
            "[20, 30, 30, 40]",
            "[20, 30, 30]"
        ),
        answerIndex = 3,
        explanation = "The slice `values[1:3]` gives `[20, 30]`. Then `values[-1] - values[0]` is `40 - 10`, so `part` becomes `[20, 30, 30]`."
    ),
    Problem(
        id = "match_medium_junior_63",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['aa', 'bb']",
        summary = "Pick the snippet that repeats each string exactly twice.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "items = [\"a\", \"b\"]\nresult = []\nfor item in items:\n    result.append(item + \"b\")\nprint(result)",
            "items = [\"a\", \"b\"]\nresult = []\nfor item in items:\n    result.append(item * 2)\nprint(result)",
            "items = [\"aa\", \"bb\"]\nprint(items[1:])",
            "items = [\"a\", \"b\"]\nprint(items * 2)"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet duplicates each string element and collects `['aa', 'bb']`."
    )
)
