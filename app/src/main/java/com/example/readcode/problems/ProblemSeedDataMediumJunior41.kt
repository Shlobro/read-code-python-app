package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior41 = listOf(
    Problem(
        id = "bug_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late binding closures",
        summary = "A list of lambda functions returns unexpected values.",
        prompt = "Why does this print `[2, 2, 2]` instead of `[0, 1, 2]`?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)
            
            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "Lambdas capture the variable reference, not the value",
            "The list comprehension evaluates the lambdas incorrectly",
            "A lambda function cannot return loop variables directly",
            "The append method creates a shallow copy of the lambda object instead of executing it"
        ),
        answerIndex = 0,
        explanation = "In Python, closures are late-binding. The lambdas capture the variable `i`, which holds the value `2` by the time they are executed."
    ),
    Problem(
        id = "output_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "In-place modification return",
        summary = "A variable captures the result of an in-place list operation.",
        prompt = "What does this code print?",
        code = """
            data = [1, 2, 3]
            result = data.append(4)
            print(result)
        """.trimIndent(),
        options = listOf(
            "None",
            "[1, 2, 3, 4]",
            "[1, 2, 3]",
            "Error"
        ),
        answerIndex = 0,
        explanation = "List methods like `append()` modify the list in place and return `None`."
    ),
    Problem(
        id = "purpose_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Bitwise magic",
        summary = "A function uses bitwise operators on an integer.",
        prompt = "What does this function do?",
        code = """
            def check(n):
                return (n & (n - 1)) == 0 and n != 0
        """.trimIndent(),
        options = listOf(
            "Checks if a number is a power of two",
            "Finds the lowest set bit in the given positive number",
            "Determines whether the given integer is even",
            "Computes the bitwise inverse of the integer"
        ),
        answerIndex = 0,
        explanation = "Subtracting 1 from a power of two flips all its bits after the highest set bit. Bitwise ANDing it with the original number results in 0."
    ),
    Problem(
        id = "fill_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Initialize node pointer",
        summary = "A node class for a linked list needs an initial pointer value.",
        prompt = "Fill the blank to initialize a singly linked list node where it points to nothing initially.",
        code = """
            class Node:
                def __init__(self, val):
                    self.val = val
                    self.next = ___
        """.trimIndent(),
        options = listOf(
            "None",
            "null",
            "False",
            "Node()"
        ),
        answerIndex = 0,
        explanation = "In Python, `None` is used to represent the absence of a value, commonly used for empty pointers."
    ),
    Problem(
        id = "order_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Parse JSON file",
        summary = "Arrange the lines to correctly open and parse a JSON file.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "import json",
            "with open('config.json') as f:",
            "    config = json.load(f)",
            "print(config['host'])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "First import the module, then open the file using a context manager, parse it using `json.load()`, and finally access the dictionary."
    ),
    Problem(
        id = "complexity_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Merge arrays complexity",
        summary = "Two sorted arrays are merged using a specific approach.",
        prompt = "What is the time complexity of merging two arrays of length N and M using this code?",
        code = """
            def merge(arr1, arr2):
                return sorted(arr1 + arr2)
        """.trimIndent(),
        options = listOf(
            "O((N+M) log(N+M))",
            "O(N + M) because concatenating lists is linear time",
            "O(N * M) due to the combination of the two arrays",
            "O(N log M) since the second list is smaller"
        ),
        answerIndex = 0,
        explanation = "Concatenation takes O(N+M), but `sorted()` takes O(K log K) where K is N+M. It does not take advantage of the arrays already being sorted."
    ),
    Problem(
        id = "trace_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Reference assignment",
        summary = "Two variables initially point to the same list.",
        prompt = "What is the value of `b` at the end of the code?",
        code = """
            a = [1, 2]
            b = a
            b.append(3)
            a = [4, 5]
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3]",
            "[4, 5, 3]",
            "[4, 5]",
            "An error occurs because a is reassigned"
        ),
        answerIndex = 0,
        explanation = "`b` points to the original list `[1, 2]`. Appending modifies it to `[1, 2, 3]`. Reassigning `a` points `a` to a new list, leaving `b` unchanged."
    ),
    Problem(
        id = "match_medium_junior_41",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: 2",
        summary = "Pick the code snippet that prints the number 2.",
        prompt = "Which code correctly prints `2`?",
        code = "",
        options = listOf(
            "print(len({1, 2, 2}))",
            "print([1, 2, 2].count(1))",
            "print(set([1, 2, 2])[1])",
            "print(len([1, 2, 2][:1]))"
        ),
        answerIndex = 0,
        explanation = "The set literal `{1, 2, 2}` removes duplicates, resulting in `{1, 2}`, which has a length of 2."
    )
)
