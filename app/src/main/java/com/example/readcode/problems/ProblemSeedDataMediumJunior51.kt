package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior51 = listOf(
    Problem(
        id = "bug_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Trimmed Input Check",
        summary = "A cleaned string is computed but never used.",
        prompt = "What is the actual bug in this function?",
        code = """
            def is_admin(name):
                cleaned = name.strip()
                return name == "admin"
        """.trimIndent(),
        options = listOf(
            "`strip()` should be `split()`",
            "It compares `name` instead of `cleaned`",
            "The function must print the result",
            "`return` cannot appear in a function"
        ),
        answerIndex = 1,
        explanation = "The function removes whitespace into `cleaned` but still compares the original `name`, so values like `\" admin \"` return `False`."
    ),
    Problem(
        id = "output_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Continue Skips One Value",
        summary = "One loop iteration is skipped before the total is updated.",
        prompt = "What gets printed?",
        code = """
            total = 0
            for n in range(1, 5):
                if n == 3:
                    continue
                total += n
            print(total)
        """.trimIndent(),
        options = listOf(
            "10",
            "6",
            "9",
            "7"
        ),
        answerIndex = 3,
        explanation = "The loop adds 1, 2, and 4. When `n` is 3, `continue` skips the addition, so the total is 7."
    ),
    Problem(
        id = "purpose_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Latest Value by Key",
        summary = "A dictionary is updated as each row is processed.",
        prompt = "What does this function return?",
        code = """
            def latest_prices(rows):
                prices = {}
                for name, price in rows:
                    prices[name] = price
                return prices
        """.trimIndent(),
        options = listOf(
            "A dictionary of the latest price for each name",
            "A list of prices sorted from lowest to highest",
            "A dictionary counting how many times each price appears",
            "A list of rows with duplicate names removed"
        ),
        answerIndex = 0,
        explanation = "Assigning to the same dictionary key replaces the previous value, so each name keeps only its most recent price."
    ),
    Problem(
        id = "fill_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Accumulator",
        summary = "Increment a counter while providing a default start value.",
        prompt = "Fill in the blank so missing keys start at 0 before adding 1.",
        code = """
            counts = {}
            letter = "a"
            counts[letter] = counts.__(letter, 0) + 1
        """.trimIndent(),
        options = listOf(
            "set",
            "pop",
            "get",
            "keys"
        ),
        answerIndex = 2,
        explanation = "`get(letter, 0)` returns the current count when present, otherwise 0."
    ),
    Problem(
        id = "order_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Positive List",
        summary = "Arrange the lines to collect only positive numbers.",
        prompt = "Arrange the lines so the function returns a list of values greater than 0.",
        code = "",
        options = listOf(
            "def positive_only(values):",
            "    result = []",
            "    for value in values:",
            "        if value > 0:",
            "            result.append(value)",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "Define the function, create the output list, loop through the input, append positive values, and return the result."
    ),
    Problem(
        id = "complexity_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Membership Inside a Loop",
        summary = "Each pass checks whether a value is already in a growing list.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            def unique_count(values):
                seen = []
                for value in values:
                    if value not in seen:
                        seen.append(value)
                return len(seen)
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 1,
        explanation = "List membership is linear, and it runs inside a loop over all values, so the worst-case growth is quadratic."
    ),
    Problem(
        id = "trace_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Aliased Nested List",
        summary = "A nested list is mutated through another variable.",
        prompt = "What is the value of `data[0][1]` after this code runs?",
        code = """
            data = [[1, 2], [3, 4]]
            first_row = data[0]
            first_row[1] = 9
        """.trimIndent(),
        options = listOf(
            "2",
            "1",
            "4",
            "9"
        ),
        answerIndex = 3,
        explanation = "`first_row` refers to the same inner list as `data[0]`, so changing `first_row[1]` also changes `data[0][1]`."
    ),
    Problem(
        id = "match_medium_junior_51",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Pick the snippet that counts letters with repeated keys.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "letters = [\"a\", \"b\", \"a\"]\ncounts = {}\nfor letter in letters:\n    if letter in counts:\n        counts[letter] += 1\n    else:\n        counts[letter] = 0\nprint(counts)",
            "letters = [\"a\", \"b\", \"a\"]\ncounts = {}\nfor letter in letters:\n    counts[letter] = counts.get(letter, 0) + 1\nprint(counts)",
            "letters = [\"a\", \"b\", \"a\"]\nprint(set(letters))",
            "letters = [\"a\", \"b\", \"a\"]\nprint({0: \"a\", 1: \"b\", 2: \"a\"})"
        ),
        answerIndex = 1,
        explanation = "The second snippet increments the count for each letter, producing `{'a': 2, 'b': 1}`."
    )
)
