package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior72 = listOf(
    Problem(
        id = "bug_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing Dictionary Update",
        summary = "The code calculates a new value but never stores it back in the dictionary.",
        prompt = "Why does the count for repeated words stay at 1?",
        code = """
            counts = {}
            words = ["pen", "book", "pen"]

            for word in words:
                if word in counts:
                    counts[word] + 1
                else:
                    counts[word] = 1
        """.trimIndent(),
        options = listOf(
            "The loop should iterate over indexes instead of words",
            "The dictionary must start with all possible keys",
            "The repeated-word branch computes a value but does not assign it",
            "Strings cannot be used as dictionary keys"
        ),
        answerIndex = 2,
        explanation = "Inside the `if` branch, `counts[word] + 1` is evaluated and discarded. The code needs an assignment such as `counts[word] = counts[word] + 1`."
    ),
    Problem(
        id = "output_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Then Append",
        summary = "A list is sliced, extended, and then measured.",
        prompt = "What does this code print?",
        code = """
            values = [1, 2, 3, 4]
            part = values[:2]
            part.append(values[-1])
            print(part)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 4, 4]",
            "[1, 2, 4]",
            "[2, 3, 4]",
            "[1, 2]"
        ),
        answerIndex = 1,
        explanation = "`values[:2]` creates `[1, 2]`. Appending `values[-1]` adds `4`, so `part` becomes `[1, 2, 4]`."
    ),
    Problem(
        id = "purpose_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group Scores by Status",
        summary = "The loop separates values based on whether they pass a threshold.",
        prompt = "What does this code build in `groups`?",
        code = """
            scores = [82, 58, 91, 60]
            groups = {"pass": [], "fail": []}

            for score in scores:
                if score >= 60:
                    groups["pass"].append(score)
                else:
                    groups["fail"].append(score)
        """.trimIndent(),
        options = listOf(
            "A dictionary that stores passing scores and failing scores in separate lists",
            "A single sorted list of scores from lowest to highest",
            "A count of how many scores are above 60",
            "A dictionary where each score points to its index"
        ),
        answerIndex = 0,
        explanation = "Each score is appended either to `groups[\"pass\"]` or `groups[\"fail\"]`, so the dictionary groups scores by the threshold."
    ),
    Problem(
        id = "fill_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Take the Last Two Items",
        summary = "The slice should keep only the final two values.",
        prompt = "Which choice fills the blank so `tail` becomes `[30, 40]`?",
        code = """
            nums = [10, 20, 30, 40]
            tail = nums[___]
            print(tail)
        """.trimIndent(),
        options = listOf(
            "2:",
            "-2:",
            ":2",
            ":-2"
        ),
        answerIndex = 1,
        explanation = "`nums[-2:]` starts two positions from the end and includes the rest of the list, producing `[30, 40]`."
    ),
    Problem(
        id = "order_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Name Map",
        summary = "Arrange the lines so the function maps each word to its length.",
        prompt = "Arrange the lines so the function works correctly.",
        code = "",
        options = listOf(
            "    lengths = {}",
            "    for word in words:",
            "def collect_lengths(words):",
            "        lengths[word] = len(word)",
            "    return lengths"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 1, 3, 4),
        explanation = "The function header comes first, then the dictionary setup, then the loop and assignment, and finally the return."
    ),
    Problem(
        id = "complexity_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Two Independent Passes",
        summary = "The code scans the same list twice without nesting the loops.",
        prompt = "What is the time complexity in terms of `n = len(values)`?",
        code = """
            total = 0
            for value in values:
                total += value

            count = 0
            for value in values:
                if value > 0:
                    count += 1
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(log n)",
            "O(n^2)",
            "O(n)"
        ),
        answerIndex = 3,
        explanation = "There are two separate linear passes over `values`. `n + n` is still O(n), not O(n^2), because the loops are not nested."
    ),
    Problem(
        id = "trace_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track a Reassigned List",
        summary = "A list is concatenated with a new one and then sliced.",
        prompt = "What is the value of `items` after this code runs?",
        code = """
            items = [1, 2]
            items = items + [3, 4]
            items = items[1:3]
        """.trimIndent(),
        options = listOf(
            "[2, 3]",
            "[1, 2, 3]",
            "[1, 2, 3, 4]",
            "[3, 4]"
        ),
        answerIndex = 0,
        explanation = "After concatenation, `items` is `[1, 2, 3, 4]`. Slicing with `[1:3]` keeps the elements at indexes 1 and 2, which are `[2, 3]`."
    ),
    Problem(
        id = "match_medium_junior_72",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 2, 'b': 1}",
        summary = "Pick the snippet that counts repeated letters in the given string.",
        prompt = "Which snippet produces this exact output?",
        code = "",
        options = listOf(
            "text = \"aba\"\ncounts = {}\nfor ch in text:\n    counts[ch] = 1\nprint(counts)",
            "text = \"aab\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"abb\"\ncounts = {}\nfor ch in text:\n    counts[ch] = counts.get(ch, 0) + 1\nprint(counts)",
            "text = \"aab\"\ncounts = {\"a\": 1, \"b\": 1}\nprint(counts)"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet counts two `a` characters and one `b`, producing `{'a': 2, 'b': 1}`."
    )
)
