package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior44 = listOf(
    Problem(
        id = "bug_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Iterating and Modifying",
        summary = "Modifying a list during iteration.",
        prompt = "Why does this code fail to remove all odd numbers?",
        code = """
            items = [1, 2, 3, 5, 7]
            for item in items:
                if item % 2 != 0:
                    items.remove(item)
            print(items)
        """.trimIndent(),
        options = listOf(
            "Modifying a list while iterating over it skips elements",
            "The modulo operator does not work correctly with list elements during an active iteration cycle",
            "The remove method only works with indices and cannot be passed the actual item value directly",
            "A TypeError is thrown because the list is evaluated before the conditional block executes"
        ),
        answerIndex = 0,
        explanation = "Removing elements from a list while iterating over it shifts the remaining elements left, causing the iterator to skip the next element."
    ),
    Problem(
        id = "output_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Negative Step Slicing",
        summary = "Slicing a list with a negative step.",
        prompt = "What does this code print?",
        code = """
            letters = ['a', 'b', 'c', 'd', 'e']
            print(letters[::-2])
        """.trimIndent(),
        options = listOf(
            "['e', 'c', 'a']",
            "['a', 'c', 'e']",
            "['e', 'd', 'c', 'b', 'a']",
            "An IndexError is raised because the step value is negative and the list bounds are exceeded"
        ),
        answerIndex = 0,
        explanation = "The slice `[::-2]` starts from the end of the list and steps backwards by 2, picking 'e', then 'c', then 'a.'"
    ),
    Problem(
        id = "purpose_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Order-Preserving Deduplication",
        summary = "List comprehension with a set side-effect.",
        prompt = "What is the primary purpose of this function?",
        code = """
            def process(items):
                seen = set()
                return [x for x in items if not (x in seen or seen.add(x))]
        """.trimIndent(),
        options = listOf(
            "Deduplicates while preserving original order",
            "Converts the list to a set and then maps it back to a list to calculate mathematical union",
            "Iterates through the elements and appends them to a new list only if they evaluate to True",
            "Creates a completely new set object by combining elements that appear multiple times inside the list"
        ),
        answerIndex = 0,
        explanation = "This is a concise (though somewhat tricky) way to remove duplicates while keeping the original order. `seen.add(x)` returns `None` (falsy), so `not (...)` becomes true for new items."
    ),
    Problem(
        id = "fill_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Pairing Elements",
        summary = "Combining two lists into a dictionary.",
        prompt = "Choose the missing piece to properly pair up the keys and values into a dictionary.",
        code = """
            keys = ['name', 'age']
            values = ['Alice', 30]
            user_info = dict(____)
        """.trimIndent(),
        options = listOf(
            "zip(keys, values)",
            "enumerate(keys) + enumerate(values)",
            "map(lambda k, v: (k, v), keys, values)",
            "itertools.chain(keys, values)"
        ),
        answerIndex = 0,
        explanation = "`zip` pairs up elements from multiple iterables. `dict()` can then take these pairs and construct a dictionary."
    ),
    Problem(
        id = "order_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Custom Exception",
        summary = "Defining and raising a custom exception.",
        prompt = "Arrange the lines to define a custom error and raise it conditionally.",
        code = "",
        options = listOf(
            "class CustomError(Exception):",
            "    pass",
            "def check_value(x):",
            "    if x < 0:",
            "        raise CustomError(\"Negative\")"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the custom exception class by inheriting from `Exception`, then define the function, add the condition, and finally raise the custom error."
    ),
    Problem(
        id = "complexity_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Lookup Speed",
        summary = "Time complexity of filtering with a set.",
        prompt = "What is the time complexity of this function where N is len(items) and M is len(targets)?",
        code = """
            def check_items(items, targets):
                item_set = set(items)
                return [t for t in targets if t in item_set]
        """.trimIndent(),
        options = listOf(
            "O(N + M)",
            "O(N * M)",
            "O(N log N + M log M)",
            "The time complexity depends entirely on the hashing function used and is always O(N^2 + M^2)"
        ),
        answerIndex = 0,
        explanation = "Creating the set takes O(N) time. Looking up each of the M items in the set takes O(1) time on average, resulting in O(M) for the list comprehension. Total time is O(N + M)."
    ),
    Problem(
        id = "trace_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Iteration Trace",
        summary = "Tracing values as keys are popped and added.",
        prompt = "What is the value of `counts['bx']` after the loop finishes?",
        code = """
            counts = {'a': 1, 'b': 2}
            for k in list(counts.keys()):
                counts[k + 'x'] = counts.pop(k) + 1
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "It raises a KeyError because the dictionary is modified while iterating",
            "The value is undefined because dictionary keys are always completely unordered"
        ),
        answerIndex = 0,
        explanation = "By using `list(counts.keys())`, we iterate over a static list `['a', 'b']`. For 'a', it pops 1 and sets `counts['ax'] = 2`. For 'b', it pops 2 and sets `counts['bx'] = 3`."
    ),
    Problem(
        id = "match_medium_junior_44",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Pick the snippet that filters out odd numbers.",
        prompt = "Which code produces `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "print([x for x in [1, 2, 3, 4, 5, 6] if x % 2 == 0])",
            "print([x * 2 for x in range(4) if x > 1])",
            "print(list(filter(lambda x: x % 2 == 0, [1, 3, 5, 7, 9]))) ",
            "print(list(map(lambda x: x + 2, filter(lambda x: x % 2 == 0, [0, 1, 2]))))"
        ),
        answerIndex = 0,
        explanation = "The first list comprehension iterates over numbers 1 through 6 and keeps only the even ones (2, 4, 6)."
    )
)
