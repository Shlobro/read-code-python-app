package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior49 = listOf(
    Problem(
        id = "bug_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting in Place",
        summary = "A function returns the result of a mutating list method.",
        prompt = "What is the actual bug in this function?",
        code = """
            def sorted_names(names):
                return names.sort()
        """.trimIndent(),
        options = listOf(
            "It returns `None` because `sort()` modifies the list in place",
            "It sorts the original list directly, which can surprise callers that expected the input to stay unchanged",
            "It should call `sorted_names.sort(names)` to access the list method correctly from the function",
            "Lists cannot be sorted inside a function unless the function also prints the result"
        ),
        answerIndex = 0,
        explanation = "`list.sort()` changes the existing list and returns `None`, so the function does not return the sorted list."
    ),
    Problem(
        id = "output_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Break in a Loop",
        summary = "The loop stops as soon as one condition is met.",
        prompt = "What gets printed?",
        code = """
            total = 0
            for n in [2, 4, 5, 6]:
                if n % 2 == 1:
                    break
                total += n
            print(total)
        """.trimIndent(),
        options = listOf(
            "17",
            "6",
            "11",
            "12"
        ),
        answerIndex = 1,
        explanation = "The loop adds 2 and 4, then stops when it reaches 5 because `break` exits the loop before adding it."
    ),
    Problem(
        id = "purpose_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Grouped Counts",
        summary = "A dictionary collects items by their first letter.",
        prompt = "What does this function build?",
        code = """
            def group_words(words):
                groups = {}
                for word in words:
                    first = word[0]
                    groups.setdefault(first, []).append(word)
                return groups
        """.trimIndent(),
        options = listOf(
            "A dictionary that maps each starting letter to the words that begin with it",
            "A list of the shortest word found for each starting letter after comparing all matches in the input",
            "A single string containing all words in alphabetical order with duplicates removed before returning",
            "A dictionary that maps each word to the number of times it appears across the whole input list"
        ),
        answerIndex = 0,
        explanation = "`setdefault(first, [])` creates a list for each first letter, and each matching word is appended to that list."
    ),
    Problem(
        id = "fill_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent Copy",
        summary = "Create a new list before mutating it.",
        prompt = "Fill in the blank so `backup` stays unchanged after `working` is updated.",
        code = """
            backup = [1, 2, 3]
            working = backup.____()
            working.append(4)
        """.trimIndent(),
        options = listOf(
            "clone",
            "copy",
            "slice",
            "duplicate"
        ),
        answerIndex = 1,
        explanation = "`copy()` returns a new list with the same elements, so changing `working` does not change `backup`."
    ),
    Problem(
        id = "order_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Build a Name Map",
        summary = "Arrange the lines to build a dictionary from user records.",
        prompt = "Arrange the lines so the function returns a dictionary from each `id` to each `name`.",
        code = "",
        options = listOf(
            "def build_lookup(records):",
            "    lookup = {}",
            "    for record in records:",
            "        lookup[record['id']] = record['name']",
            "    return lookup"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the function, create the result dictionary, loop through the records, assign each entry, then return the dictionary."
    ),
    Problem(
        id = "complexity_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Double Traversal",
        summary = "Two separate loops walk the same list.",
        prompt = "What is the overall time complexity in terms of `n`?",
        code = """
            def analyze(values):
                total = 0
                for value in values:
                    total += value

                count = 0
                for value in values:
                    if value > total / len(values):
                        count += 1

                return count
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(n)",
            "O(n^2)",
            "O(1)"
        ),
        answerIndex = 1,
        explanation = "The function makes two full passes over the list. `n + n` is still linear, so the overall time complexity is O(n)."
    ),
    Problem(
        id = "trace_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Dictionary State",
        summary = "Track a value that is updated through a nested dictionary.",
        prompt = "What is the value of `profile['stats']['wins']` after this code runs?",
        code = """
            profile = {"stats": {"wins": 2, "losses": 1}}
            stats = profile["stats"]
            stats["wins"] += 3
        """.trimIndent(),
        options = listOf(
            "2",
            "3",
            "5",
            "An error is raised"
        ),
        answerIndex = 2,
        explanation = "`stats` refers to the same inner dictionary as `profile['stats']`, so increasing `stats['wins']` also updates `profile['stats']['wins']` to 5."
    ),
    Problem(
        id = "match_medium_junior_49",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that doubles each item in the list.",
        prompt = "Which snippet produces the exact output `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n + 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [2, 4, 6]\nprint(nums[1:])",
            "nums = [1, 2, 3]\nprint(list(range(2, 6, 2)))"
        ),
        answerIndex = 1,
        explanation = "The list comprehension `[n * 2 for n in nums]` turns `[1, 2, 3]` into `[2, 4, 6]`."
    )
)
