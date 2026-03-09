package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior6 = listOf(
    Problem(
        id = "bug_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shallow copy mutation trap",
        summary = "A list of lists copied with list() shares inner list references.",
        prompt = "Why does modifying `copy[0]` also change `original[0]`?",
        code = """
            original = [[1, 2], [3, 4]]
            copy = list(original)
            copy[0].append(99)
            print(original)
        """.trimIndent(),
        options = listOf(
            "`list()` makes a shallow copy — the inner lists are not duplicated, so both variables point to the same inner list objects.",
            "`list()` does not copy at all; `copy` is just another reference to `original`.",
            "Python lists are always passed by reference, so any assignment copies the reference.",
            "`append` modifies the list in-place, which propagates to all Python objects globally."
        ),
        answerIndex = 0,
        explanation = "`list(original)` creates a new outer list but copies only the references to the inner lists. `copy[0]` and `original[0]` point to the same `[1, 2]` list object. Calling `.append(99)` on that shared object mutates it, so `original[0]` also becomes `[1, 2, 99]`. To avoid this, use `copy.deepcopy(original)`."
    ),
    Problem(
        id = "output_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Exception Flow",
        summary = "Tracing a try-except-else-finally block.",
        prompt = "What does this code print?",
        code = """
            def process(x):
                try:
                    result = 10 / x
                except ZeroDivisionError:
                    print("E", end="")
                else:
                    print("S", end="")
                finally:
                    print("F", end="")

            process(0)
            process(2)
        """.trimIndent(),
        options = listOf(
            "EFSF",
            "EF",
            "ESF",
            "EFEF"
        ),
        answerIndex = 0,
        explanation = "For `process(0)`, a ZeroDivisionError occurs, printing `E`, then `finally` prints `F`. For `process(2)`, division succeeds, `else` prints `S`, and `finally` prints `F`."
    ),
    Problem(
        id = "purpose_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Comprehension",
        summary = "Processing a dictionary to keep certain pairs.",
        prompt = "What does this code do overall?",
        code = """
            scores = {"Alice": 85, "Bob": 92, "Charlie": 78}
            passed = {k: v for k, v in scores.items() if v >= 80}
        """.trimIndent(),
        options = listOf(
            "Creates a new dictionary with only the students who scored 80 or higher.",
            "Updates the original dictionary to remove students who failed.",
            "Creates a list of names of students who passed.",
            "Calculates the average score of passing students."
        ),
        answerIndex = 0,
        explanation = "It iterates through the key-value pairs of `scores` and creates a new dictionary containing only the entries where the value is 80 or more."
    ),
    Problem(
        id = "fill_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Running totals lazily",
        summary = "Choose the statement that preserves streaming output through a for-loop.",
        prompt = "Fill in the blank so `print(list(running_total([2, 3, 5])))` prints `[2, 5, 10]` without building the whole list inside the function.",
        code = """
            def running_total(nums):
                total = 0
                for n in nums:
                    total += n
                    ____ total

            print(list(running_total([2, 3, 5])))
        """.trimIndent(),
        options = listOf(
            "yield",
            "return",
            "print",
            "generate"
        ),
        answerIndex = 0,
        explanation = "`yield total` emits each intermediate sum one at a time, so the caller can iterate and collect `[2, 5, 10]`. `return total` would stop after the first item, `print total` is a `SyntaxError` in Python 3 (`print` is a function, not a statement), and `generate` is not a Python keyword."
    ),
    Problem(
        id = "order_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Class Definition",
        summary = "Arrange the lines to define a class with an init and string representation method.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "class Person:",
            "    def __init__(self, name):",
            "        self.name = name",
            "    def __str__(self):",
            "        return f'Person({self.name})'"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "A class definition starts with the `class` keyword. Inside it, `__init__` is defined to initialize attributes, followed by other methods like `__str__`."
    ),
    Problem(
        id = "complexity_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Sort inside a loop",
        summary = "A list is sorted inside a loop — determine the total complexity.",
        prompt = "What is the overall time complexity of `process` in terms of n = len(records)?",
        code = """
            def process(records):
                results = []
                for i in range(len(records)):
                    window = records[:i + 1]
                    window.sort()
                    results.append(window[-1])
                return results
        """.trimIndent(),
        options = listOf(
            "O(n² log n)",
            "O(n log n)",
            "O(n²)",
            "O(n³)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs n times. On iteration i, `records[:i+1]` creates a slice of length i+1 (O(i)) and sorting it costs O(i log i). Summing over all i from 0 to n-1 gives O(n² log n) overall."
    ),
    Problem(
        id = "trace_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Scope Shadows",
        summary = "Global vs Local variable tracing.",
        prompt = "What is printed at the end of this script?",
        code = """
            x = 10
            def modify():
                x = 5
                return x

            modify()
            print(x)
        """.trimIndent(),
        options = listOf(
            "10",
            "5",
            "Error",
            "None"
        ),
        answerIndex = 0,
        explanation = "The assignment `x = 5` inside `modify` creates a new local variable `x` that shadows the global `x`. The global `x` remains 10."
    ),
    Problem(
        id = "match_medium_junior_6",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 1, 'b': 2}",
        summary = "Which snippet merges two dictionaries?",
        prompt = "Which code produces `{'a': 1, 'b': 2}`?",
        code = "",
        options = listOf(
            "print({'a': 1} | {'b': 2})",
            "print({'a': 1} + {'b': 2})",
            "print({'a': 1}.update({'b': 2}))",
            "print(dict(['a', 1], ['b', 2]))"
        ),
        answerIndex = 0,
        explanation = "In Python 3.9+, the `|` operator merges two dictionaries. The `+` operator is not supported for dicts. `.update()` modifies in place and returns `None`."
    )
)
