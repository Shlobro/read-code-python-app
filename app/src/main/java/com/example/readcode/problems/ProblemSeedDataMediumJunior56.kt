package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior56 = listOf(
    Problem(
        id = "bug_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting Before Returning",
        summary = "The function tries to return a sorted copy of a list.",
        prompt = "What is the real bug in this function?",
        code = """
            def sorted_names(names):
                ordered = names.sort()
                return ordered
        """.trimIndent(),
        options = listOf(
            "The return statement should be inside a loop",
            "`sort()` returns `None` instead of a new list",
            "Lists cannot contain strings when sorted",
            "The function must call `append()` after sorting"
        ),
        answerIndex = 1,
        explanation = "`list.sort()` changes the original list in place and returns `None`, so `ordered` does not hold the sorted names."
    ),
    Problem(
        id = "output_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Inner Lists",
        summary = "List multiplication reuses the same nested list.",
        prompt = "What gets printed?",
        code = """
            rows = [[0]] * 2
            rows[0].append(1)
            print(rows)
        """.trimIndent(),
        options = listOf(
            "[[0, 1], [0]]",
            "[[0], [0, 1]]",
            "[[0, 1], [0, 1]]",
            "Error"
        ),
        answerIndex = 2,
        explanation = "Both elements in `rows` refer to the same inner list, so appending through `rows[0]` updates both entries."
    ),
    Problem(
        id = "purpose_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Keep First Occurrences",
        summary = "A function removes duplicates while preserving order.",
        prompt = "What does this function return?",
        code = """
            def unique_in_order(items):
                seen = set()
                result = []
                for item in items:
                    if item not in seen:
                        seen.add(item)
                        result.append(item)
                return result
        """.trimIndent(),
        options = listOf(
            "Only the duplicated values",
            "Items sorted from smallest to largest",
            "The first appearance of each distinct item",
            "A count of how many times each item appears"
        ),
        answerIndex = 2,
        explanation = "The set tracks what has already appeared, and `result` keeps the first time each distinct item is seen."
    ),
    Problem(
        id = "fill_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Merge Without Crashing",
        summary = "The code needs a safe default list before appending.",
        prompt = "Which option fills the blank correctly?",
        code = """
            grouped = {}
            key = "fruit"
            grouped.___(key, []).append("apple")
            print(grouped)
        """.trimIndent(),
        options = listOf(
            "get",
            "update",
            "setdefault",
            "values"
        ),
        answerIndex = 2,
        explanation = "`setdefault(key, [])` inserts an empty list when the key is missing, then returns that list for `append()`."
    ),
    Problem(
        id = "order_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build an Index Map",
        summary = "Arrange the lines to map each name to its position.",
        prompt = "Arrange the lines so the function returns a dictionary from name to index.",
        code = "",
        options = listOf(
            "def build_index(names):",
            "    positions = {}",
            "    for index, name in enumerate(names):",
            "        positions[name] = index",
            "    return positions"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Create the dictionary, loop with `enumerate`, store each name's index, and return the filled map."
    ),
    Problem(
        id = "complexity_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Small Fixed Inner Loop",
        summary = "The outer loop depends on `n`, but the inner loop always runs three times.",
        prompt = "What is the time complexity in terms of `n`?",
        code = """
            for value in values:
                for _ in range(3):
                    print(value)
        """.trimIndent(),
        options = listOf(
            "O(n^2)",
            "O(n)",
            "O(log n)",
            "O(1)"
        ),
        answerIndex = 1,
        explanation = "The inner loop is constant work, so the total grows linearly with the number of items in `values`."
    ),
    Problem(
        id = "trace_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Copy Then Mutate",
        summary = "A sliced list is changed independently from the original.",
        prompt = "What is the value of `backup[1]` after this code runs?",
        code = """
            numbers = [4, 5, 6]
            backup = numbers[:]
            numbers[1] = 9
            backup.append(7)
        """.trimIndent(),
        options = listOf(
            "9",
            "6",
            "7",
            "5"
        ),
        answerIndex = 3,
        explanation = "`numbers[:]` makes a separate list, so changing `numbers[1]` does not affect `backup`, whose second element stays `5`."
    ),
    Problem(
        id = "match_medium_junior_56",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: hi hi hi",
        summary = "Pick the snippet that prints the word three times on separate lines.",
        prompt = "Which snippet produces this exact output?",
        code = """
            hi
            hi
            hi
        """.trimIndent(),
        options = listOf(
            "print(\"hi\\nhi\\nhi\")",
            "print([\"hi\"] * 3)",
            "for _ in range(3): print(\"hi\", end=\" \")",
            "print(\"hi\" * 3)"
        ),
        answerIndex = 0,
        explanation = "The newline characters in the string make `print` emit `hi` on three separate lines."
    )
)
