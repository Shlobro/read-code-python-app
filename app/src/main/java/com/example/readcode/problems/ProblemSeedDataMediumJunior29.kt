package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior29 = listOf(
    Problem(
        id = "bug_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Average from an empty list",
        summary = "The helper works for normal input but crashes for one common edge case.",
        prompt = "What is the real bug in this function?",
        code = """
            def average(values):
                total = 0
                for value in values:
                    total += value
                return total / len(values)
        """.trimIndent(),
        options = listOf(
            "It divides by `len(values)` even when the list may be empty",
            "The loop should start at index 1 instead of using values directly",
            "`total` should start as `None` so Python knows it is empty",
            "The function must sort the list before adding the numbers"
        ),
        answerIndex = 0,
        explanation = "If `values` is empty, `len(values)` is 0 and the final division raises a division-by-zero error."
    ),
    Problem(
        id = "output_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Copy then mutate",
        summary = "A copied list is changed after it is created.",
        prompt = "What does this code print?",
        code = """
            numbers = [1, 2, 3]
            copy = numbers[:]
            numbers.append(4)
            copy.remove(2)
            print(numbers)
            print(copy)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 4]\n[1, 3]",
            "[1, 2, 3]\n[1, 3, 4]",
            "[1, 2, 3, 4]\n[1, 2, 3, 4]",
            "[1, 3, 4]\n[1, 3]"
        ),
        answerIndex = 0,
        explanation = "`numbers[:]` creates a separate list. Appending to `numbers` does not change `copy`, and removing `2` from `copy` leaves `[1, 3]`."
    ),
    Problem(
        id = "purpose_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep the latest score",
        summary = "The loop stores one value for each student's name.",
        prompt = "What does this function return overall?",
        code = """
            def latest_scores(rows):
                result = {}
                for name, score in rows:
                    result[name] = score
                return result
        """.trimIndent(),
        options = listOf(
            "A dictionary that maps each name to its most recent score in the input",
            "A list of student names sorted by score",
            "A dictionary that counts how many scores each student has",
            "A list of only the highest scores from the input"
        ),
        answerIndex = 0,
        explanation = "Assigning `result[name] = score` overwrites any earlier value for the same name, so the dictionary keeps the latest score seen for each student."
    ),
    Problem(
        id = "fill_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Skip blank names",
        summary = "The code should continue only when the string is not empty.",
        prompt = "Which option fills the blank correctly?",
        code = """
            name = ""

            if name __ "":
                print("Missing")
        """.trimIndent(),
        options = listOf(
            "==",
            "in",
            ">",
            "+="
        ),
        answerIndex = 0,
        explanation = "The condition should check whether `name` is exactly the empty string, so `==` is the correct operator."
    ),
    Problem(
        id = "order_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count matching names",
        summary = "Arrange the lines so the code counts names that start with the target letter.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "count = 0",
            "for name in names:",
            "print(count)",
            "target = \"A\"",
            "    if name.startswith(target):",
            "        count += 1",
            "names = [\"Amy\", \"Ben\", \"Ava\"]"
        ),
        answerIndex = 0,
        correctOrder = listOf(6, 3, 0, 1, 4, 5, 2),
        explanation = "Define the list, target, and counter first. Then loop through the names, check the prefix, increment when it matches, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Short-circuit search",
        summary = "The function scans until it finds a matching value.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            def contains_zero(values):
                for value in values:
                    if value == 0:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(1)",
            "O(log n)",
            "O(n^2)"
        ),
        answerIndex = 0,
        explanation = "In the worst case, the function checks every item once before returning, so the runtime grows linearly with the input size."
    ),
    Problem(
        id = "trace_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the status list",
        summary = "The list is updated in place inside the loop based on each score.",
        prompt = "What is the value of `statuses` after the code finishes?",
        code = """
            scores = [55, 80, 40]
            statuses = []

            for score in scores:
                if score >= 60:
                    statuses.append("pass")
                else:
                    statuses.append("retry")
        """.trimIndent(),
        options = listOf(
            "['retry', 'pass', 'retry']",
            "['pass', 'pass', 'retry']",
            "['retry', 'retry', 'pass']",
            "['pass', 'retry', 'retry']"
        ),
        answerIndex = 0,
        explanation = "55 adds `retry`, 80 adds `pass`, and 40 adds `retry`, so the final list is `['retry', 'pass', 'retry']`."
    ),
    Problem(
        id = "match_medium_junior_29",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Which snippet doubles each number from 1 through 3 before printing?",
        prompt = "Which code prints `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nresult = []\nfor n in nums:\n    result.append(n * 2)\nprint(result)",
            "nums = [1, 2, 3]\nresult = []\nfor n in nums:\n    result.append(n + 2)\nprint(result)",
            "nums = [1, 2, 3]\nprint(nums * 2)",
            "nums = [1, 2, 3]\nprint([2, 4])"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet multiplies each item by 2 and collects the results into `[2, 4, 6]`."
    )
)
