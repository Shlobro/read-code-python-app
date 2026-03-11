package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior37 = listOf(
    Problem(
        id = "bug_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Counter reset inside loop",
        summary = "The code tries to count long names, but the counter is re-created every iteration.",
        prompt = "What is the actual bug in this code?",
        code = """
            names = ["Lia", "Noah", "Amir", "Jo"]

            for name in names:
                count = 0
                if len(name) > 3:
                    count += 1

            print(count)
        """.trimIndent(),
        options = listOf(
            "`count` is initialized inside the loop, so previous increments are lost",
            "The condition should be `len(name) >= 3`",
            "The loop should iterate over indexes instead of names",
            "`print(count)` must be inside the `if` block"
        ),
        answerIndex = 0,
        explanation = "Because `count` is set to 0 on every iteration, the program only keeps the result from the last loop pass instead of a running total."
    ),
    Problem(
        id = "output_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Split, strip, upper",
        summary = "Each comma-separated value is trimmed before converting to uppercase.",
        prompt = "What does this code print?",
        code = """
            text = "red, blue ,green"
            parts = [part.strip().upper() for part in text.split(",")]
            print(parts[1:])
        """.trimIndent(),
        options = listOf("[\"BLUE\", \"GREEN\"]", "[\" blue \", \"green\"]", "[\"RED\", \"BLUE\"]", "[\"BLUE\"]"),
        answerIndex = 0,
        explanation = "Splitting gives three pieces, `strip()` removes surrounding spaces, and `upper()` capitalizes each one. Slicing from index 1 returns `[\"BLUE\", \"GREEN\"]`."
    ),
    Problem(
        id = "purpose_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Collect unique tags",
        summary = "The function walks through article records and gathers tags without duplicates.",
        prompt = "What does this function return overall?",
        code = """
            def collect_tags(records):
                seen = set()
                for record in records:
                    for tag in record["tags"]:
                        seen.add(tag)
                return sorted(seen)
        """.trimIndent(),
        options = listOf(
            "A sorted list of all distinct tags found in the records",
            "A dictionary counting how many times each tag appears",
            "A list of records that have more than one tag",
            "A set containing only the tags from the last record"
        ),
        answerIndex = 0,
        explanation = "The set removes duplicates as tags are added, and `sorted(seen)` returns those unique tags as an alphabetically ordered list."
    ),
    Problem(
        id = "fill_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Increment with a default",
        summary = "The dictionary should safely increase a counter even when the key is new.",
        prompt = "Which option fills the blank correctly?",
        code = """
            counts = {}
            word = "error"
            counts[word] = counts.___(word, 0) + 1
            print(counts[word])
        """.trimIndent(),
        options = listOf("get", "find", "set", "index"),
        answerIndex = 0,
        explanation = "`.get(word, 0)` returns the existing count when present, or 0 for a new key, which makes the increment safe."
    ),
    Problem(
        id = "order_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Filter active usernames",
        summary = "Arrange the lines so the code collects usernames for active accounts and prints the result.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "users = [{\"name\": \"Ana\", \"active\": True}, {\"name\": \"Bo\", \"active\": False}]",
            "active_names = []",
            "for user in users:",
            "    if user[\"active\"]:",
            "        active_names.append(user[\"name\"])",
            "print(active_names)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Create the input list and destination list first, loop over users, append only active names inside the condition, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Nested comparison table",
        summary = "Every item is compared with every other item in a nested loop.",
        prompt = "If `len(items) = n`, what is the worst-case time complexity?",
        code = """
            matches = 0
            for left in items:
                for right in items:
                    if left == right:
                        matches += 1
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "The outer loop runs `n` times and the inner loop also runs `n` times for each outer iteration, giving `n * n` total comparisons."
    ),
    Problem(
        id = "trace_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace after update and pop",
        summary = "A dictionary value is increased and then a key is removed.",
        prompt = "What is the value of `stats` after the code finishes?",
        code = """
            stats = {"open": 2, "closed": 1}
            stats["open"] += 3
            stats.pop("closed")
        """.trimIndent(),
        options = listOf(
            "{\"open\": 5}",
            "{\"open\": 2}",
            "{\"open\": 5, \"closed\": 1}",
            "{\"closed\": 1}"
        ),
        answerIndex = 0,
        explanation = "The `open` count increases from 2 to 5, and `pop(\"closed\")` removes the `closed` entry entirely, leaving only `{\"open\": 5}`."
    ),
    Problem(
        id = "match_medium_junior_37",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each number before printing the new list.",
        prompt = "Which code prints `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "numbers = [1, 2, 3]\nresult = []\nfor number in numbers:\n    result.append(number * 2)\nprint(result)",
            "numbers = [1, 2, 3]\nfor number in numbers:\n    number *= 2\nprint(numbers)",
            "numbers = [1, 2, 3]\nresult = {}\nfor number in numbers:\n    result[number] = number * 2\nprint(result)",
            "numbers = [1, 2, 3]\nprint(numbers * 2)"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet builds a new list containing the doubled values in order, so it prints `[2, 4, 6]`."
    )
)
