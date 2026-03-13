package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior71 = listOf(
    Problem(
        id = "bug_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing List for New Team",
        summary = "The code appends into a dictionary entry before creating that entry.",
        prompt = "What is the real bug in this code?",
        code = """
            groups = {}
            names = [("red", "Ana"), ("blue", "Ben")]

            for team, name in names:
                groups[team].append(name)
        """.trimIndent(),
        options = listOf(
            "Tuple unpacking is not allowed in a `for` loop",
            "Each team key is used before it is initialized",
            "The dictionary must be sorted before appending",
            "Lists cannot be stored inside dictionaries"
        ),
        answerIndex = 1,
        explanation = "The dictionary starts empty, so `groups[team]` raises a `KeyError` until a list is created for that key."
    ),
    Problem(
        id = "output_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Copy Stays Separate",
        summary = "A list slice is copied, then only the copy is changed.",
        prompt = "What does this code print?",
        code = """
            values = [2, 4, 6, 8]
            picked = values[1:3]
            picked[0] = 99
            print(values)
            print(picked)
        """.trimIndent(),
        options = listOf(
            "[2, 99, 6, 8]\n[99, 6]",
            "[2, 4, 6, 8]\n[99, 6]",
            "[2, 4, 6, 8]\n[4, 6]",
            "[2, 99, 6, 8]\n[4, 6]"
        ),
        answerIndex = 1,
        explanation = "Slicing creates a new list, so changing `picked` does not change `values`."
    ),
    Problem(
        id = "purpose_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep First Occurrences",
        summary = "The loop tracks what has already been seen before appending.",
        prompt = "What does this code build in `result`?",
        code = """
            items = ["a", "b", "a", "c", "b"]
            seen = set()
            result = []

            for item in items:
                if item not in seen:
                    seen.add(item)
                    result.append(item)
        """.trimIndent(),
        options = listOf(
            "A sorted list of the unique items",
            "A count of how many times each item appears",
            "Only the items that appear more than once",
            "Unique items in their first-seen order"
        ),
        answerIndex = 3,
        explanation = "An item is appended only the first time it appears, so duplicates are skipped while the original encounter order is preserved."
    ),
    Problem(
        id = "fill_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Drop the Final Character",
        summary = "The slice should keep every character except the last one.",
        prompt = "Which choice fills the blank so `start` becomes `\"plat\"`?",
        code = """
            word = "plate"
            start = word[___]
            print(start)
        """.trimIndent(),
        options = listOf(
            ":-1",
            "1:",
            "::2",
            "-1:"
        ),
        answerIndex = 0,
        explanation = "`word[:-1]` returns all characters from the start up to, but not including, the final character."
    ),
    Problem(
        id = "order_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Short Words",
        summary = "Arrange the lines so the function counts words with fewer than four letters.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def count_short(words):",
            "    total = 0",
            "    for word in words:",
            "        if len(word) < 4:",
            "            total += 1",
            "    return total"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The counter is created before the loop, increased inside the conditional, and returned after all words are checked."
    ),
    Problem(
        id = "complexity_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Set Then Check",
        summary = "One pass creates a set, and one more lookup checks whether a value is present.",
        prompt = "What is the time complexity in terms of `n = len(values)`?",
        code = """
            seen = set()
            for value in values:
                seen.add(value)

            print(target in seen)
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 1,
        explanation = "Building the set takes one linear pass through `values`, and the final membership test is O(1) on average, so the total is O(n)."
    ),
    Problem(
        id = "trace_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track a Rebuilt String",
        summary = "A string is sliced, then one more character is appended.",
        prompt = "What is the value of `code` after this code runs?",
        code = """
            code = "ABCD"
            code = code[1:3]
            code += "!"
        """.trimIndent(),
        options = listOf(
            "\"AB!\"",
            "\"BCD!\"",
            "\"ABC!\"",
            "\"BC!\""
        ),
        answerIndex = 3,
        explanation = "`code[1:3]` produces `\"BC\"`, and appending `\"!\"` makes the final value `\"BC!\"`."
    ),
    Problem(
        id = "match_medium_junior_71",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [3, 4, 5]",
        summary = "Pick the snippet that increases each number in the list by 2.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [1, 2, 3]\nprint([n + 2 for n in nums])",
            "nums = [1, 2, 3]\nresult = []\nfor n in nums:\n    result.append(n * 2)\nprint(result)",
            "nums = [1, 2, 3]\nprint(nums + [4, 5])"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet adds 2 to every original value, producing `[3, 4, 5]`."
    )
)
