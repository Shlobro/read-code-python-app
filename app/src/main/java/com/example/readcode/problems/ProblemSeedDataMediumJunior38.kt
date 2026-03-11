package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior38 = listOf(
    Problem(
        id = "bug_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Replacing a missing key",
        summary = "The code tries to update totals for each department, but one dictionary key does not exist yet.",
        prompt = "What is the real bug in this code?",
        code = """
            totals = {"sales": 5}
            department = "support"
            totals[department] += 1
            print(totals)
        """.trimIndent(),
        options = listOf(
            "It increments a dictionary key before that key has been added",
            "The variable `department` should be uppercase",
            "The dictionary must be a list of tuples",
            "`print(totals)` needs to be inside a loop"
        ),
        answerIndex = 0,
        explanation = "Only `sales` exists in the dictionary. Accessing `totals[\"support\"]` before creating it raises a `KeyError`."
    ),
    Problem(
        id = "output_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Sort then slice",
        summary = "The list is sorted in place before the first three items are printed.",
        prompt = "What does this code print?",
        code = """
            scores = [8, 3, 5, 1]
            scores.sort()
            print(scores[:3])
        """.trimIndent(),
        options = listOf("[1, 3, 5]", "[8, 5, 3]", "[1, 3, 5, 8]", "[3, 5, 8]"),
        answerIndex = 0,
        explanation = "After `sort()`, the list becomes `[1, 3, 5, 8]`. Slicing with `[:3]` returns the first three items."
    ),
    Problem(
        id = "purpose_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group names by first letter",
        summary = "The function collects names under a key based on their starting character.",
        prompt = "What does this function build and return?",
        code = """
            def group_by_first_letter(names):
                groups = {}
                for name in names:
                    first = name[0]
                    groups.setdefault(first, []).append(name)
                return groups
        """.trimIndent(),
        options = listOf(
            "A dictionary that maps each first letter to the names that start with it",
            "A list of names sorted alphabetically",
            "A dictionary that stores the length of each name",
            "A set containing the unique first letters only"
        ),
        answerIndex = 0,
        explanation = "`setdefault(first, [])` creates a list for a new first letter, and each matching name is appended to that list."
    ),
    Problem(
        id = "fill_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Remove surrounding spaces",
        summary = "The code should clean extra spaces before checking the command value.",
        prompt = "Which option fills the blank correctly?",
        code = """
            command = "  save  "
            cleaned = command.___()
            print(cleaned == "save")
        """.trimIndent(),
        options = listOf("strip", "split", "replace", "join"),
        answerIndex = 0,
        explanation = "`strip()` removes whitespace from both ends of the string, leaving `save`."
    ),
    Problem(
        id = "order_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a status lookup",
        summary = "Arrange the lines so the code creates a dictionary from task names to their done state and prints it.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "tasks = [{\"name\": \"setup\", \"done\": True}, {\"name\": \"test\", \"done\": False}]",
            "status_by_name = {}",
            "for task in tasks:",
            "    status_by_name[task[\"name\"]] = task[\"done\"]",
            "print(status_by_name)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Create the source data first, initialize the result dictionary, populate it inside the loop, and print the result after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Single pass accumulator",
        summary = "The loop updates a running total while visiting each element once.",
        prompt = "If `len(numbers) = n`, what is the worst-case time complexity?",
        code = """
            total = 0
            for number in numbers:
                if number > 0:
                    total += number
        """.trimIndent(),
        options = listOf("O(n)", "O(n^2)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "The loop makes one pass through the list. Each iteration does constant-time work, so total time grows linearly with `n`."
    ),
    Problem(
        id = "trace_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace a copied list",
        summary = "One list is copied before a new value is appended to the copy.",
        prompt = "What is the value of `backup` after the code finishes?",
        code = """
            items = ["a", "b"]
            backup = items.copy()
            backup.append("c")
            items.append("d")
        """.trimIndent(),
        options = listOf(
            "[\"a\", \"b\", \"c\"]",
            "[\"a\", \"b\", \"d\"]",
            "[\"a\", \"b\", \"c\", \"d\"]",
            "[\"a\", \"b\"]"
        ),
        answerIndex = 0,
        explanation = "`backup` starts as a separate copy of `items`. Appending `c` changes only `backup`, and the later append to `items` does not affect it."
    ),
    Problem(
        id = "match_medium_junior_38",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'red': 2, 'blue': 1}",
        summary = "Pick the snippet that counts repeated color names in a list.",
        prompt = "Which code prints `{'red': 2, 'blue': 1}`?",
        code = "",
        options = listOf(
            "colors = [\"red\", \"blue\", \"red\"]\ncounts = {}\nfor color in colors:\n    counts[color] = counts.get(color, 0) + 1\nprint(counts)",
            "colors = [\"red\", \"blue\", \"red\"]\ncounts = []\nfor color in colors:\n    counts.append(color)\nprint(counts)",
            "colors = [\"red\", \"blue\", \"red\"]\ncounts = {\"red\": 1, \"blue\": 1}\nprint(counts)",
            "colors = [\"red\", \"blue\", \"red\"]\nprint(set(colors))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet counts each color occurrence and produces the exact dictionary with `red` counted twice and `blue` once."
    )
)
