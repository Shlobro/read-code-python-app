package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior70 = listOf(
    Problem(
        id = "bug_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong Key Is Checked",
        summary = "The code verifies one dictionary key and reads a different one.",
        prompt = "What is the real bug in this code?",
        code = """
            user = {"name": "Mia", "age": 24}

            if "email" in user:
                print(user["age"])
            else:
                print(user["email"])
        """.trimIndent(),
        options = listOf(
            "The dictionary should be converted to a list first",
            "The `else` branch still reads missing `email`",
            "The code must print `name` before reading `age`",
            "Dictionaries cannot store both strings and integers"
        ),
        answerIndex = 1,
        explanation = "If `email` is missing, the `else` branch still tries to read it, which raises a `KeyError`."
    ),
    Problem(
        id = "output_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Append",
        summary = "A new list is made from part of the original before one more value is added.",
        prompt = "What does this code print?",
        code = """
            values = [4, 1, 3, 2]
            picked = values[1:3]
            picked.append(len(values))
            print(picked)
        """.trimIndent(),
        options = listOf(
            "[1, 3, 4]",
            "[4, 1, 3, 4]",
            "[1, 3, 2]",
            "[1, 3]"
        ),
        answerIndex = 0,
        explanation = "`values[1:3]` is `[1, 3]`, and `len(values)` is `4`, so `picked` becomes `[1, 3, 4]`."
    ),
    Problem(
        id = "purpose_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group Words By First Letter",
        summary = "The loop builds a dictionary whose values are lists.",
        prompt = "What does this code build in `groups`?",
        code = """
            words = ["ant", "apple", "bat"]
            groups = {}

            for word in words:
                first = word[0]
                groups.setdefault(first, []).append(word)
        """.trimIndent(),
        options = listOf(
            "A dictionary from each word to its length",
            "A dictionary that counts vowels in each word",
            "Groups words by first letter",
            "A list of the first letter from every word"
        ),
        answerIndex = 2,
        explanation = "Each word is appended to the list stored under its starting letter, so words with the same first letter end up together."
    ),
    Problem(
        id = "fill_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Skip the First Item",
        summary = "The loop should process every item except the one at index 0.",
        prompt = "Which choice fills the blank so the loop visits `20`, `30`, and `40`?",
        code = """
            numbers = [10, 20, 30, 40]

            for value in numbers[___]:
                print(value)
        """.trimIndent(),
        options = listOf(
            ":-1",
            "::2",
            "1:",
            "0:3"
        ),
        answerIndex = 2,
        explanation = "`numbers[1:]` returns the list from index 1 to the end, which is `[20, 30, 40]`."
    ),
    Problem(
        id = "order_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build an Index Map",
        summary = "Arrange the lines so the function maps each value to its position.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def positions(items):",
            "    result = {}",
            "    for index, item in enumerate(items):",
            "        result[item] = index",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The dictionary must be created before the loop, filled during enumeration, and returned after every item is processed."
    ),
    Problem(
        id = "complexity_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Scan of Pairs",
        summary = "Each value is compared with every later value.",
        prompt = "What is the time complexity in terms of `n = len(values)`?",
        code = """
            for i in range(len(values)):
                for j in range(i + 1, len(values)):
                    if values[i] == values[j]:
                        print("duplicate")
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(log n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 2,
        explanation = "The inner loop runs for many values of `j` for each `i`, producing a quadratic number of comparisons overall."
    ),
    Problem(
        id = "trace_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the Remaining Names",
        summary = "A filtered list is built and then shortened once more.",
        prompt = "What is the value of `kept` after this code runs?",
        code = """
            names = ["Ada", "Bo", "Cy", "Dee"]
            kept = [name for name in names if len(name) > 2]
            kept.remove("Ada")
        """.trimIndent(),
        options = listOf(
            "[\"Ada\", \"Dee\"]",
            "[]",
            "[\"Ada\"]",
            "[\"Dee\"]"
        ),
        answerIndex = 3,
        explanation = "The comprehension creates `[\"Ada\", \"Dee\"]`, and removing `\"Ada\"` leaves only `[\"Dee\"]`."
    ),
    Problem(
        id = "match_medium_junior_70",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'x': 2, 'y': 1}",
        summary = "Pick the snippet that counts how many times each character appears.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "text = \"xyx\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"xyx\"\ncounts = {}\nfor ch in text:\n    counts[ch] = 1\nresult = counts\nprint(\"counts:\", result)",
            "text = \"xyx\"\ncounts = []\nfor ch in text:\n    counts.append(ch)\nprint(counts)",
            "text = \"xyx\"\nprint({\"x\": 1, \"y\": 2})"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet increments a running count for each character, producing two `x` entries and one `y` entry."
    )
)
