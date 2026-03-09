package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior20 = listOf(
    Problem(
        id = "bug_medium_20",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Missing self in class method",
        summary = "A method tries to update a class attribute but fails.",
        prompt = "What bug will occur when `increment()` is called on an instance?",
        code = """
            class Counter:
                def __init__(self):
                    self.count = 0
                def increment():
                    self.count += 1
        """.trimIndent(),
        options = listOf(
            "`increment` is missing the `self` parameter",
            "`count` must be initialized outside `__init__`",
            "Classes cannot have methods",
            "The `+=` operator doesn't work on `self`"
        ),
        answerIndex = 0,
        explanation = "Instance methods in Python must take `self` as their first parameter to access instance variables."
    ),
    Problem(
        id = "output_medium_20",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Mutable default argument",
        summary = "A list default argument is shared across calls.",
        prompt = "What does this code print on the second call?",
        code = """
            def add_item(val, items=[]):
                items.append(val)
                return items

            add_item(1)
            print(add_item(2))
        """.trimIndent(),
        options = listOf("[1, 2]", "[2]", "[]", "Error"),
        answerIndex = 0,
        explanation = "Default mutable arguments are created once and shared across all calls. After the first call `items` is `[1]`, so the second call appends 2, giving `[1, 2]`."
    ),
    Problem(
        id = "purpose_medium_20",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "setdefault on a dict",
        summary = "Building a grouped dict with setdefault.",
        prompt = "What does this code produce in `groups`?",
        code = """
            words = ["cat", "car", "bar"]
            groups = {}
            for w in words:
                groups.setdefault(w[0], []).append(w)
        """.trimIndent(),
        options = listOf(
            "{'c': ['cat', 'car'], 'b': ['bar']}",
            "{'cat': 'c', 'car': 'c', 'bar': 'b'}",
            "{'c': 'car', 'b': 'bar'}",
            "{'c': 2, 'b': 1}"
        ),
        answerIndex = 0,
        explanation = "`setdefault` inserts an empty list for a key if it is absent and returns it, so each word is appended to the list for its first character."
    ),
    Problem(
        id = "fill_medium_20",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting with a key",
        summary = "Using the key parameter to sort by string length.",
        prompt = "Fill the blank so the list is sorted by word length (shortest first).",
        code = """
            words = ["banana", "fig", "apple"]
            words.sort(key=___)
        """.trimIndent(),
        options = listOf("len", "str", "sorted", "lambda x: x"),
        answerIndex = 0,
        explanation = "`key=len` tells `sort` to order elements by the value returned by `len()`, so shorter words come first."
    ),
    Problem(
        id = "order_medium_20",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Read file line by line",
        summary = "Arrange the lines to safely read a file and print its lines.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "        print(line.strip())",
            "with open('data.txt') as f:",
            "    for line in f:"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0),
        explanation = "First open the file with `with`, then iterate over the file object, then print each line."
    ),
    Problem(
        id = "complexity_medium_20",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "List slicing complexity",
        summary = "What is the cost of copying a list?",
        prompt = "What is the time complexity of slicing a list `a[:]`?",
        code = """
            a = [1, 2, 3, 4, 5]
            b = a[:]
        """.trimIndent(),
        options = listOf("O(n)", "O(1)", "O(log n)", "O(n^2)"),
        answerIndex = 0,
        explanation = "Slicing copies every element in the slice, taking time proportional to the number of elements copied, which is O(n)."
    ),
    Problem(
        id = "trace_medium_20",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "String accumulator",
        summary = "Track the state of a string being built.",
        prompt = "What is the value of `result` after the loop?",
        code = """
            result = ""
            for char in "abc":
                result = char + result
        """.trimIndent(),
        options = listOf("\"cba\"", "\"abc\"", "\"aabbcc\"", "\"\""),
        answerIndex = 0,
        explanation = "Each character is prepended to the string. 'a' -> 'ba' -> 'cba', reversing the string."
    ),
    Problem(
        id = "match_medium_20",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 5",
        summary = "Which code correctly finds the maximum value?",
        prompt = "Which code prints `5`?",
        code = "",
        options = listOf(
            "print(max([2, 5, 1]))",
            "print(min([2, 5, 1]))",
            "print(len([2, 5, 1]))",
            "print(sum([2, 5, 1]))"
        ),
        answerIndex = 0,
        explanation = "`max()` finds the largest element in the list, which is 5."
    )
)
