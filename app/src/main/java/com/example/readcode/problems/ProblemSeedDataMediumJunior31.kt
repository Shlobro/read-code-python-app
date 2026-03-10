package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior31 = listOf(
    Problem(
        id = "bug_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing list update",
        summary = "The loop computes a changed value but never stores it back in the list.",
        prompt = "Why does this code fail to double every score?",
        code = """
            scores = [10, 20, 30]
            for score in scores:
                score *= 2
            print(scores)
        """.trimIndent(),
        options = listOf(
            "The loop variable changes, but the list items are never reassigned",
            "Lists cannot contain integers when using a loop",
            "The code should use `score = score + score` instead of `*= 2`",
            "`print(scores)` must be inside the loop to update the list"
        ),
        answerIndex = 0,
        explanation = "`score` is just a local loop variable. Rebinding it does not change the original list items, so `scores` stays `[10, 20, 30]`."
    ),
    Problem(
        id = "output_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Loop else branch",
        summary = "The loop finishes normally, so the `else` block runs.",
        prompt = "What does this code print?",
        code = """
            for n in [1, 2, 3]:
                if n == 4:
                    break
            else:
                print("done")
        """.trimIndent(),
        options = listOf("done", "1 2 3 done", "Nothing", "Error"),
        answerIndex = 0,
        explanation = "The loop never hits `break`, so the `else` block attached to the loop runs and prints `done`."
    ),
    Problem(
        id = "purpose_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Index by id",
        summary = "The function converts a list of records into a lookup dictionary.",
        prompt = "What does this function return overall?",
        code = """
            def build_index(records):
                result = {}
                for record in records:
                    result[record["id"]] = record
                return result
        """.trimIndent(),
        options = listOf(
            "A dictionary that maps each record id to the full record",
            "A list of record ids in order",
            "A dictionary counting how many times each id appears",
            "A list of records sorted by id"
        ),
        answerIndex = 0,
        explanation = "Each loop iteration stores the whole `record` under its `id`, producing a dictionary for quick lookup by id."
    ),
    Problem(
        id = "fill_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Copy before sorting",
        summary = "The code should sort a new list and leave the original unchanged.",
        prompt = "Which option fills the blank correctly?",
        code = """
            nums = [3, 1, 2]
            ordered = ___(nums)
            print(nums)
            print(ordered)
        """.trimIndent(),
        options = listOf("sorted", "sort", "list.sort", "reverse"),
        answerIndex = 0,
        explanation = "`sorted(nums)` returns a new sorted list. `sort` is a list method, not a standalone function call in this form."
    ),
    Problem(
        id = "order_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count long words",
        summary = "Arrange the lines so the code counts words longer than three letters.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "for word in words:",
            "    if len(word) > 3:",
            "count = 0",
            "words = [\"ant\", \"bear\", \"cat\", \"zebra\"]",
            "        count += 1",
            "print(count)"
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 2, 0, 1, 4, 5),
        explanation = "Define the input and counter first, then loop through the words, check the length, increment when needed, and print after the loop."
    ),
    Problem(
        id = "complexity_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Pair comparison loop",
        summary = "Each item is compared with every later item.",
        prompt = "What is the worst-case time complexity in terms of `n`?",
        code = """
            for i in range(n):
                for j in range(i + 1, n):
                    print(i, j)
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(n^3)"
        ),
        answerIndex = 0,
        explanation = "The inner loop runs roughly `n - i - 1` times for each `i`, which adds up to about `n(n-1)/2`, so the total is O(n^2)."
    ),
    Problem(
        id = "trace_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Track the total",
        summary = "The variable changes inside both an `if` and after the loop.",
        prompt = "What is the value of `total` after the code finishes?",
        code = """
            total = 1
            for n in [2, 3, 4]:
                if n % 2 == 0:
                    total += n
            total *= 2
        """.trimIndent(),
        options = listOf("14", "12", "10", "18"),
        answerIndex = 0,
        explanation = "Start at 1. Add 2 to get 3, skip 3, add 4 to get 7, then multiply by 2 to get 14."
    ),
    Problem(
        id = "match_medium_junior_31",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Which snippet builds a list of doubled values from 1 through 3?",
        prompt = "Which code prints `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n + 2 for n in nums])",
            "nums = [1, 2, 3]\nprint(nums * 2)",
            "nums = [1, 2, 3]\nprint(list(range(2, 6)))"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet doubles each original value individually, producing `[2, 4, 6]`."
    )
)
