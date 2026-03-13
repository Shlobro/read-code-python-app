package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior59 = listOf(
    Problem(
        id = "bug_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong Name Updated",
        summary = "The code means to count uppercase letters, but the counter never changes.",
        prompt = "What is the actual bug?",
        code = """
            def count_upper(text):
                upper_count = 0
                for ch in text:
                    if ch.isupper():
                        count += 1
                return upper_count
        """.trimIndent(),
        options = listOf(
            "The loop should stop after the first uppercase letter",
            "The function updates `count`, but the real variable is `upper_count`",
            "`isupper()` only works on full strings, not characters",
            "The return statement must be inside the loop"
        ),
        answerIndex = 1,
        explanation = "The counter variable is named `upper_count`, but the loop increments `count`, which is undefined."
    ),
    Problem(
        id = "output_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Join Inside a Loop",
        summary = "The list is turned into a string one separator at a time.",
        prompt = "What gets printed?",
        code = """
            pieces = ["A", "B", "C"]
            text = "-".join(pieces[1:])
            print(text)
        """.trimIndent(),
        options = listOf(
            "A-B-C",
            "BC",
            "B-C",
            "['B', 'C']"
        ),
        answerIndex = 2,
        explanation = "`pieces[1:]` is `[\"B\", \"C\"]`, and joining those values with `-` produces `B-C`."
    ),
    Problem(
        id = "purpose_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Drop Blank Lines",
        summary = "The function keeps only lines that still contain text after trimming spaces.",
        prompt = "What does this function return?",
        code = """
            def cleaned_lines(lines):
                result = []
                for line in lines:
                    stripped = line.strip()
                    if stripped:
                        result.append(stripped)
                return result
        """.trimIndent(),
        options = listOf(
            "A list of non-empty lines with surrounding spaces removed",
            "The total number of blank lines in the input",
            "All lines combined into one trimmed string",
            "A dictionary counting spaces in each line"
        ),
        answerIndex = 0,
        explanation = "Each line is trimmed with `strip()`, and only non-empty trimmed values are appended to the result."
    ),
    Problem(
        id = "fill_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Remove a Missing Key Safely",
        summary = "The dictionary should return a default value instead of failing if the key is absent.",
        prompt = "Which option fills the blank so this prints `0` without raising an error?",
        code = """
            stock = {"pens": 4}
            removed = stock.___("markers", 0)
            print(removed)
        """.trimIndent(),
        options = listOf(
            "get",
            "remove",
            "pop",
            "clear"
        ),
        answerIndex = 2,
        explanation = "`pop(\"markers\", 0)` returns the default value `0` when the key is missing, without raising `KeyError`."
    ),
    Problem(
        id = "order_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Index Positive Scores",
        summary = "Arrange the lines to return the positions of scores above zero.",
        prompt = "Arrange the lines so the function returns a list of matching indexes.",
        code = "",
        options = listOf(
            "def positive_indexes(scores):",
            "    indexes = []",
            "    for i, score in enumerate(scores):",
            "        if score > 0:",
            "            indexes.append(i)",
            "    return indexes"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, create the result list, loop with both index and value, append matching indexes, then return the list."
    ),
    Problem(
        id = "complexity_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Halving Until Small",
        summary = "The value is cut in half on each loop iteration.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            steps = 0
            while n > 1:
                n = n // 2
                steps += 1
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n)",
            "O(1)",
            "O(n^2)"
        ),
        answerIndex = 0,
        explanation = "Each iteration halves `n`, so the number of iterations grows with the number of times `n` can be divided by 2."
    ),
    Problem(
        id = "trace_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Insert Then Slice",
        summary = "A list is changed in place, then a later assignment replaces the whole variable.",
        prompt = "What is the value of `values` after the code finishes?",
        code = """
            values = [3, 4]
            values.insert(0, 2)
            values = values[1:] + [5]
        """.trimIndent(),
        options = listOf(
            "[2, 3, 4, 5]",
            "[3, 4, 5]",
            "[2, 3, 4]",
            "[4, 5]"
        ),
        answerIndex = 1,
        explanation = "After `insert`, the list is `[2, 3, 4]`. Slicing from index 1 gives `[3, 4]`, and adding `[5]` produces `[3, 4, 5]`."
    ),
    Problem(
        id = "match_medium_junior_59",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Pick the snippet that counts letters by updating a dictionary.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "text = \"aba\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"aba\"\ncounts = {}\nfor ch in set(text):\n    counts[ch] = 1\nprint(counts)",
            "text = \"aba\"\ncounts = {}\nfor i, ch in enumerate(text):\n    counts[ch] = i\nprint(counts)",
            "text = \"aba\"\ncounts = []\nfor ch in text:\n    counts.append(ch)\nprint(counts)"
        ),
        answerIndex = 0,
        explanation = "The first snippet increments a per-character count on each pass, so `a` reaches 2 and `b` reaches 1."
    )
)
