package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior34 = listOf(
    Problem(
        id = "bug_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Removed items still counted",
        summary = "The code removes inactive users but reports the old count.",
        prompt = "What is the actual bug in this code?",
        code = """
            users = ["ana", "bo", "cy", "di"]
            active_count = len(users)

            for name in ["bo", "di"]:
                users.remove(name)

            print(active_count)
        """.trimIndent(),
        options = listOf(
            "`active_count` is calculated before removing users, so it is stale",
            "The `remove` calls should be inside one loop over `users`",
            "`len(users)` should be replaced with `users.count()`",
            "The list cannot contain strings if `len()` is used"
        ),
        answerIndex = 0,
        explanation = "The removals work, but `active_count` was captured before the list changed, so the printed count is no longer correct."
    ),
    Problem(
        id = "output_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Strip then split",
        summary = "The string is trimmed before being split on commas.",
        prompt = "What does this code print?",
        code = """
            text = " red,blue,green "
            parts = text.strip().split(",")
            print(parts[1])
        """.trimIndent(),
        options = listOf("blue", " red", "green", "blue,green"),
        answerIndex = 0,
        explanation = "`strip()` removes the outer spaces, `split(\",\")` creates `['red', 'blue', 'green']`, and index 1 is `blue`."
    ),
    Problem(
        id = "purpose_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep the latest value",
        summary = "A dictionary is updated while looping through pairs.",
        prompt = "What does this function return overall?",
        code = """
            def build_lookup(pairs):
                lookup = {}
                for key, value in pairs:
                    lookup[key] = value
                return lookup
        """.trimIndent(),
        options = listOf(
            "A dictionary mapping each key to its last seen value",
            "A list of keys that appeared more than once",
            "A dictionary counting how many times each key appeared",
            "A list of `(key, value)` pairs in sorted order"
        ),
        answerIndex = 0,
        explanation = "Each assignment stores the current value for the key, replacing any earlier value for that same key."
    ),
    Problem(
        id = "fill_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Update a running total",
        summary = "The code should add the current value into the running total each loop.",
        prompt = "Which option fills the blank correctly?",
        code = """
            values = [3, 5, 7]
            total = 0

            for value in values:
                total ___ value

            print(total)
        """.trimIndent(),
        options = listOf("+=", "=+", "-=", "*="),
        answerIndex = 0,
        explanation = "`+=` adds each `value` into `total`, producing the running sum."
    ),
    Problem(
        id = "order_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a name lookup",
        summary = "Arrange the lines so the code maps each name to its length and prints the dictionary.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "names = [\"Ana\", \"Bo\"]",
            "lengths = {}",
            "for name in names:",
            "    lengths[name] = len(name)",
            "print(lengths)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Create the input list and result dictionary first, then loop, assign each length, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Loop over every pair",
        summary = "The inner loop runs once for each item in the list for every outer iteration.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            for left in items:
                for right in items:
                    print(left, right)
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n)", "O(log n)", "O(1)"),
        answerIndex = 0,
        explanation = "For each of the `n` outer iterations, the inner loop also runs `n` times, giving `n * n` total work."
    ),
    Problem(
        id = "trace_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Trace after overwrite",
        summary = "A dictionary key is replaced after being incremented.",
        prompt = "What is the value of `stock[\"pens\"]` after the code finishes?",
        code = """
            stock = {"pens": 4}
            stock["pens"] += 3
            stock["pens"] = stock["pens"] - 2
        """.trimIndent(),
        options = listOf("5", "7", "2", "4"),
        answerIndex = 0,
        explanation = "The value starts at 4, becomes 7 after `+= 3`, then becomes 5 after subtracting 2."
    ),
    Problem(
        id = "match_medium_junior_34",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Which snippet counts letters in the string `aba`?",
        prompt = "Which code prints `{'a': 2, 'b': 1}`?",
        code = "",
        options = listOf(
            "text = \"aba\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"aba\"\ncounts = {\"a\": 1, \"b\": 1}\nprint(counts)",
            "text = \"aba\"\nprint(set(text))",
            "text = \"aba\"\nprint({0: \"a\", 1: \"b\", 2: \"a\"})"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet counts repeated characters and produces a dictionary where `a` has count 2 and `b` has count 1."
    )
)
