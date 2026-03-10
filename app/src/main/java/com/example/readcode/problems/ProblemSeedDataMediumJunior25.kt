package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior25 = listOf(
    Problem(
        id = "bug_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Skipped first order",
        summary = "A loop starts at the wrong index while totaling order amounts.",
        prompt = "What is the real bug in this function?",
        code = """
            def total_amounts(amounts):
                total = 0

                for i in range(1, len(amounts)):
                    total += amounts[i]

                return total
        """.trimIndent(),
        options = listOf(
            "The loop skips the first amount because it starts at index 1",
            "`total` should start as an empty list",
            "`len(amounts)` should be `len(amounts) - 1`",
            "The function must sort `amounts` before summing"
        ),
        answerIndex = 0,
        explanation = "Because the loop starts at 1, the value at index 0 is never added to `total`."
    ),
    Problem(
        id = "output_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Update then extend",
        summary = "A list is changed in place before it is printed.",
        prompt = "What does this code print?",
        code = """
            values = [1, 2]
            values += [3]
            values[0] = values[-1]
            print(values)
        """.trimIndent(),
        options = listOf(
            "[3, 2, 3]",
            "[1, 2, 3]",
            "[3, 2]",
            "Error"
        ),
        answerIndex = 0,
        explanation = "`values += [3]` makes the list `[1, 2, 3]`. Then `values[0] = values[-1]` replaces the first item with 3."
    ),
    Problem(
        id = "purpose_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "First match lookup",
        summary = "The function scans records until it finds a matching user id.",
        prompt = "What does this function do overall?",
        code = """
            def find_name(records, target_id):
                for record_id, name in records:
                    if record_id == target_id:
                        return name
                return None
        """.trimIndent(),
        options = listOf(
            "Returns the name for the first record with the target id, or `None` if no match exists",
            "Returns a list of every name in the records",
            "Counts how many times the target id appears",
            "Sorts the records by id and returns the whole list"
        ),
        answerIndex = 0,
        explanation = "The loop returns the matching `name` immediately when `record_id == target_id`; otherwise it returns `None` after checking every record."
    ),
    Problem(
        id = "fill_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Scope of loop variable after loop",
        summary = "A loop variable persists in the enclosing scope after the loop ends.",
        prompt = "Which blank makes the final `print` output `3`?",
        code = """
            def count_up():
                for n in range(1, 4):
                    pass
                return _____

            print(count_up())
        """.trimIndent(),
        options = listOf(
            "n",
            "range(1, 4)",
            "n + 1",
            "4"
        ),
        answerIndex = 0,
        explanation = "After a `for` loop completes normally, the loop variable retains its last assigned value. `range(1, 4)` iterates 1, 2, 3, so `n` is `3` when the loop ends. Returning `n` gives `3`. `n + 1` would give `4`. `range(1, 4)` itself is a range object, not an integer. `4` is one past the final value."
    ),
    Problem(
        id = "order_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Filter expensive items",
        summary = "Arrange the lines to collect prices above a threshold.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "prices = [12, 25, 8]",
            "    if price > 10:",
            "for price in prices:",
            "expensive = []",
            "        expensive.append(price)",
            "print(expensive)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 3, 2, 1, 4, 5),
        explanation = "The input list and result list must be defined before the loop. Inside the loop, the condition comes before the append, and the print comes last."
    ),
    Problem(
        id = "complexity_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two separate passes",
        summary = "One loop counts items and another loop prints them.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            count = 0
            for item in items:
                count += 1

            for item in items:
                print(item)
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The code makes two linear passes over `items`. `n + n` still simplifies to O(n)."
    ),
    Problem(
        id = "trace_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the chosen names",
        summary = "A list is built only when names are long enough.",
        prompt = "What is the value of `selected` after the loop finishes?",
        code = """
            names = ["Al", "Mina", "Jo", "Ravi"]
            selected = []

            for name in names:
                if len(name) >= 4:
                    selected.append(name.upper())
        """.trimIndent(),
        options = listOf(
            "['MINA', 'RAVI']",
            "['Al', 'Mina', 'Jo', 'Ravi']",
            "['Mina', 'Ravi']",
            "['AL', 'JO']"
        ),
        answerIndex = 0,
        explanation = "Only `Mina` and `Ravi` meet the length check, and both are appended in uppercase."
    ),
    Problem(
        id = "match_medium_junior_25",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 3",
        summary = "Which snippet counts the number of unique tags?",
        prompt = "Which code prints `3`?",
        code = "",
        options = listOf(
            "tags = [\"api\", \"db\", \"api\", \"ui\"]\nprint(len(set(tags)))",
            "tags = [\"api\", \"db\", \"api\", \"ui\"]\nprint(len(tags))",
            "tags = [\"api\", \"db\", \"api\", \"ui\"]\nprint(tags.count(\"api\"))",
            "tags = [\"api\", \"db\", \"api\", \"ui\"]\nprint(len(tags[1:]))"
        ),
        answerIndex = 0,
        explanation = "Converting the list to a set removes duplicates, leaving `api`, `db`, and `ui`, so the length is 3."
    )
)
