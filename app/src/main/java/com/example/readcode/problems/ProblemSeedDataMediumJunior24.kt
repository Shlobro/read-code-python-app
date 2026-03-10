package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior24 = listOf(
    Problem(
        id = "bug_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared running total",
        summary = "A function should total each row separately, but one variable is reused.",
        prompt = "What is the real bug in this function?",
        code = """
            def row_totals(rows):
                totals = []
                current = 0

                for row in rows:
                    for value in row:
                        current += value
                    totals.append(current)

                return totals
        """.trimIndent(),
        options = listOf(
            "`current` should be reset inside the outer loop before summing each row",
            "`totals` should start as `{}` instead of `[]`",
            "The inner loop must use indexes instead of values",
            "`append` should be outside both loops"
        ),
        answerIndex = 0,
        explanation = "Because `current` is initialized only once, later rows keep adding onto previous totals instead of starting from 0 for each row."
    ),
    Problem(
        id = "output_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice and replace",
        summary = "A list slice is replaced before the final value is printed.",
        prompt = "What does this code print?",
        code = """
            nums = [2, 4, 6, 8]
            nums[1:3] = [10]
            print(nums)
        """.trimIndent(),
        options = listOf(
            "[2, 10, 8]",
            "[2, 10, 6, 8]",
            "[2, 4, 10, 8]",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The slice `nums[1:3]` contains `4` and `6`. Replacing it with `[10]` produces `[2, 10, 8]`."
    ),
    Problem(
        id = "purpose_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Latest status by name",
        summary = "A dictionary is updated while scanning a list of records.",
        prompt = "What does this function return?",
        code = """
            def latest_status(records):
                status_by_name = {}

                for name, status in records:
                    status_by_name[name] = status

                return status_by_name
        """.trimIndent(),
        options = listOf(
            "A dictionary holding the last status seen for each name",
            "A list of names that appear more than once",
            "A dictionary counting how many statuses each name has",
            "A list of all statuses in alphabetical order"
        ),
        answerIndex = 0,
        explanation = "Each assignment stores the current status under that name. If a name appears again later, the newer value overwrites the older one."
    ),
    Problem(
        id = "fill_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Conditional default flow",
        summary = "A mutable default argument is shared across all calls that omit it.",
        prompt = "What does `result` equal on the *second* call to `collect(5)` with this blank filled in as `[]`?",
        code = """
            def collect(x, items=_____):
                items.append(x)
                return items

            collect(1)
            result = collect(5)
        """.trimIndent(),
        options = listOf(
            "[1, 5]",
            "[5]",
            "[1]",
            "[]"
        ),
        answerIndex = 0,
        explanation = "Default argument values are evaluated once when the function is defined, not on each call. The single list `[]` is created at definition time and reused. After `collect(1)`, `items` holds `[1]`. The second call `collect(5)` appends to the same list, giving `[1, 5]`."
    ),
    Problem(
        id = "order_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a lookup table",
        summary = "Arrange the lines to map each word to its length.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "lengths = {}",
            "words = [\"cat\", \"horse\"]",
            "for word in words:",
            "    lengths[word] = len(word)",
            "print(lengths)"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 0, 2, 3, 4),
        explanation = "The source list and result dictionary must exist before the loop, then each word is added to the dictionary, and the result is printed at the end."
    ),
    Problem(
        id = "complexity_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Triangular work",
        summary = "The inner loop grows with the outer loop counter.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            total = 0
            for i in range(n):
                for j in range(i):
                    total += 1
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The inner loop runs 0 + 1 + 2 + ... + (n - 1) times, which grows proportionally to n squared."
    ),
    Problem(
        id = "trace_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the grouped names",
        summary = "A dictionary of lists is built one record at a time.",
        prompt = "What is the value of `groups` after the loop finishes?",
        code = """
            pairs = [("red", "apple"), ("blue", "sky"), ("red", "rose")]
            groups = {}

            for color, item in pairs:
                if color not in groups:
                    groups[color] = []
                groups[color].append(item)
        """.trimIndent(),
        options = listOf(
            "{'red': ['apple', 'rose'], 'blue': ['sky']}",
            "{'red': 'rose', 'blue': 'sky'}",
            "{'apple': 'red', 'sky': 'blue', 'rose': 'red'}",
            "{'red': ['rose'], 'blue': ['sky']}"
        ),
        answerIndex = 0,
        explanation = "The code groups items by color. Both red items are appended to the same list, while blue gets its own one-item list."
    ),
    Problem(
        id = "match_medium_junior_24",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['a', 'b']",
        summary = "Which snippet filters out strings longer than one character?",
        prompt = "Which code prints `['a', 'b']`?",
        code = "",
        options = listOf(
            "words = [\"a\", \"to\", \"b\"]\nresult = [word for word in words if len(word) == 1]\nprint(result)",
            "words = [\"a\", \"to\", \"b\"]\nprint(words[1:])",
            "words = [\"a\", \"to\", \"b\"]\nprint(sorted(words))",
            "words = [\"a\", \"to\", \"b\"]\nprint(words[:2])"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet keeps just the one-character strings, producing `['a', 'b']`."
    )
)
