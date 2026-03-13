package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior53 = listOf(
    Problem(
        id = "bug_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Return Too Early",
        summary = "The function should collect every non-empty word, but it stops after the first match.",
        prompt = "What is the real bug in this function?",
        code = """
            def remove_blanks(words):
                cleaned = []
                for word in words:
                    if word != "":
                        cleaned.append(word)
                        return cleaned
        """.trimIndent(),
        options = listOf(
            "The loop should skip empty strings",
            "The return runs inside the loop",
            "`cleaned` should start as a set",
            "`append` should be `extend`"
        ),
        answerIndex = 1,
        explanation = "Because `return cleaned` is inside the loop, the function exits after appending the first non-empty word."
    ),
    Problem(
        id = "output_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Alias With In-Place Add",
        summary = "Two variables point at the same list before one of them grows in place.",
        prompt = "What gets printed?",
        code = """
            nums = [1, 2]
            alias = nums
            nums += [3]
            print(alias)
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "[1, 2, 3]",
            "[1, 2, 3, 3]",
            "Error"
        ),
        answerIndex = 1,
        explanation = "`alias` and `nums` refer to the same list, and `+=` mutates that list in place here."
    ),
    Problem(
        id = "purpose_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep First Tag Variant",
        summary = "The function treats uppercase and lowercase versions of a tag as the same value.",
        prompt = "What does this function return?",
        code = """
            def unique_tags(tags):
                seen = set()
                result = []
                for tag in tags:
                    key = tag.lower()
                    if key not in seen:
                        seen.add(key)
                        result.append(tag)
                return result
        """.trimIndent(),
        options = listOf(
            "Keeps the first spelling of each tag, ignoring case",
            "Sorts the tags and removes duplicates",
            "Counts how many times each lowercase tag appears in the input",
            "Returns only tags that were already lowercase"
        ),
        answerIndex = 0,
        explanation = "The function tracks lowercase keys in `seen`, but appends the original tag the first time each lowercase form appears."
    ),
    Problem(
        id = "fill_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent Backup List",
        summary = "The backup should stay unchanged after the original list is modified.",
        prompt = "Which option fills the blank so `backup` remains `[1, 2, 3]`?",
        code = """
            numbers = [1, 2, 3]
            backup = numbers.__()
            numbers.append(4)
            print(backup)
        """.trimIndent(),
        options = listOf(
            "clear",
            "sort",
            "reverse",
            "copy"
        ),
        answerIndex = 3,
        explanation = "`copy()` creates a new list object, so later changes to `numbers` do not affect `backup`."
    ),
    Problem(
        id = "order_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count Words by Length",
        summary = "Arrange the lines to build a dictionary keyed by each word length.",
        prompt = "Arrange the lines so the function groups words by their length.",
        code = "",
        options = listOf(
            "def words_by_length(words):",
            "    grouped = {}",
            "    for word in words:",
            "        grouped.setdefault(len(word), []).append(word)",
            "    return grouped"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the function, create the dictionary, loop through the words, append each word under its length, and return the result."
    ),
    Problem(
        id = "complexity_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Passes, Same List",
        summary = "The function loops over the same input twice, one pass after the other.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            def summarize(values):
                total = 0
                for value in values:
                    total += value

                count = 0
                for value in values:
                    if value > 0:
                        count += 1

                return total, count
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n log n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The function makes two separate linear passes, which is still linear overall: O(n)."
    ),
    Problem(
        id = "trace_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Rebind One Name",
        summary = "One variable is rebound to a new list while the alias still points to the original list.",
        prompt = "What is the value of `values` after this code runs?",
        code = """
            values = [1, 2]
            other = values
            values = values + [3]
            other.append(4)
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "[1, 2, 4]",
            "[1, 2, 3, 4]",
            "[1, 2, 3]"
        ),
        answerIndex = 3,
        explanation = "`values = values + [3]` creates a new list, so later appending through `other` changes only the old list."
    ),
    Problem(
        id = "match_medium_junior_53",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 1, 3, 5",
        summary = "Pick the snippet that prints only the odd numbers from 1 through 5 on separate lines.",
        prompt = "Which snippet produces this exact output?",
        code = """
            1
            3
            5
        """.trimIndent(),
        options = listOf(
            "for n in range(1, 5):\n    print(n)",
            "for n in range(1, 6, 2):\n    print(n)",
            "for n in [1, 3, 5]:\n    print(n, end=\" \")",
            "print([n for n in range(1, 6) if n % 2 == 1])"
        ),
        answerIndex = 1,
        explanation = "`range(1, 6, 2)` yields 1, 3, and 5, and each `print` call writes one value per line."
    )
)
