package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior65 = listOf(
    Problem(
        id = "bug_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong Key Update",
        summary = "A loop tries to total hours by name, but it writes every value under the same key.",
        prompt = "What is the real bug in this code?",
        code = """
            logs = [("Ana", 2), ("Bob", 3)]
            totals = {}
            for name, hours in logs:
                totals["name"] = totals.get("name", 0) + hours
        """.trimIndent(),
        options = listOf(
            "The loop should unpack three values",
            "It uses `\"name\"` instead of `name` as the key",
            "`hours` must be converted to text first",
            "The code should sort `logs` before the loop starts"
        ),
        answerIndex = 1,
        explanation = "Using the string literal `\"name\"` stores every total under one fixed key instead of using each employee name."
    ),
    Problem(
        id = "output_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Insert",
        summary = "A copy of part of the list is modified before printing.",
        prompt = "What does this code print?",
        code = """
            nums = [2, 4, 6, 8]
            part = nums[:3]
            part.insert(1, len(nums))
            print(part)
        """.trimIndent(),
        options = listOf(
            "[2, 4, 6, 8]",
            "[2, 6, 4, 6]",
            "[2, 4, 4, 6]",
            "[2, 4, 6, 4]"
        ),
        answerIndex = 2,
        explanation = "`nums[:3]` creates `[2, 4, 6]`, `len(nums)` is 4, and inserting at index 1 produces `[2, 4, 4, 6]`."
    ),
    Problem(
        id = "purpose_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep Highest Score Per Player",
        summary = "The loop updates a dictionary only when it finds a larger value.",
        prompt = "What does this code build in `best`?",
        code = """
            results = [("Ana", 8), ("Bob", 5), ("Ana", 10)]
            best = {}
            for name, score in results:
                if name not in best or score > best[name]:
                    best[name] = score
        """.trimIndent(),
        options = listOf(
            "It counts how many scores each player has",
            "It keeps each player's highest score",
            "It removes players whose score is below 10",
            "It sorts the results by player name"
        ),
        answerIndex = 1,
        explanation = "Each player keeps the first score seen, then later scores replace it only if they are larger."
    ),
    Problem(
        id = "fill_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Step Through Every Other Item",
        summary = "The slice should select indexes 0, 2, and 4.",
        prompt = "Which choice fills the blank so `picked` becomes `[10, 30, 50]`?",
        code = """
            values = [10, 20, 30, 40, 50]
            picked = values[::__]
            print(picked)
        """.trimIndent(),
        options = listOf(
            "1",
            "0",
            "-1",
            "2"
        ),
        answerIndex = 3,
        explanation = "A slice step of `2` takes every other item starting from index 0."
    ),
    Problem(
        id = "order_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Return Names Longer Than Three Letters",
        summary = "Arrange the lines so the function collects matching names in order.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "def long_names(names):",
            "    result = []",
            "    for name in names:",
            "        if len(name) > 3:",
            "            result.append(name)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "The function needs its header, result list, loop, condition, append, and final return in that order."
    ),
    Problem(
        id = "complexity_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Membership Inside a Loop",
        summary = "Each pass checks whether the current value appears in a list of blocked items.",
        prompt = "What is the time complexity in terms of `n` items in `values` and `m` items in `blocked`?",
        code = """
            count = 0
            for value in values:
                if value in blocked:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "O(n + m)",
            "O(n * m)",
            "O(n)",
            "O(m)"
        ),
        answerIndex = 1,
        explanation = "The outer loop runs `n` times, and list membership in `blocked` is `O(m)`, so the combined cost is `O(n * m)`."
    ),
    Problem(
        id = "trace_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track a Growing String",
        summary = "A loop builds a label from selected numbers.",
        prompt = "What is the value of `label` after this code runs?",
        code = """
            label = ""
            for n in [1, 2, 3, 4]:
                if n % 2 == 0:
                    label += str(n)
            label = label + "!"
        """.trimIndent(),
        options = listOf(
            "\"24!\"",
            "\"1234!\"",
            "\"46!\"",
            "\"24\""
        ),
        answerIndex = 0,
        explanation = "Only the even values 2 and 4 are added, giving `\"24\"`, and then `!` is appended."
    ),
    Problem(
        id = "match_medium_junior_65",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [1, 4, 9]",
        summary = "Pick the snippet that prints the squares of 1 through 3.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [1, 2, 3]\nprint([n * n for n in nums])",
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint(list(range(1, 4)))"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet squares each number, producing `[1, 4, 9]`."
    )
)
