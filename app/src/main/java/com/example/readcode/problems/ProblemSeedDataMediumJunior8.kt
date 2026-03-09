package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior8 = listOf(
    Problem(
        id = "bug_medium_jr8_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Late Binding in Closures",
        summary = "A list of lambdas behaves unexpectedly.",
        prompt = "Why do all the generated functions return the same value when called?",
        code = """
            def make_multipliers():
                return [lambda x: i * x for i in range(3)]
                
            funcs = make_multipliers()
            print([f(2) for f in funcs])
        """.trimIndent(),
        options = listOf(
            "The variable 'i' is looked up when the lambda is called, not when it is created",
            "The lambdas share the same 'x' argument across all calls",
            "The list comprehension evaluates to a single lambda function",
            "Range stops at 2, so the functions always multiply by 2"
        ),
        answerIndex = 0,
        explanation = "In Python, closures bind to variables, not their values. By the time the lambdas are called, the loop has finished and 'i' is 2 for all of them."
    ),
    Problem(
        id = "output_medium_jr8_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Slicing with Step",
        summary = "A list is sliced with a start, stop, and step value.",
        prompt = "What does this code print?",
        code = """
            nums = [10, 20, 30, 40, 50]
            print(nums[1:4:2])
        """.trimIndent(),
        options = listOf(
            "[20, 40]",
            "[20, 30]",
            "[10, 30, 50]",
            "[40, 20]"
        ),
        answerIndex = 0,
        explanation = "The slice starts at index 1 (20) and goes up to index 4 (50, exclusive), taking every 2nd element, resulting in [20, 40]."
    ),
    Problem(
        id = "purpose_medium_jr8_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Comprehension",
        summary = "A list comprehension with two 'for' clauses.",
        prompt = "What does this function do?",
        code = """
            def process(matrix):
                return [val for row in matrix for val in row]
        """.trimIndent(),
        options = listOf(
            "Flattens a 2D list into a 1D list",
            "Returns the diagonal elements of a matrix",
            "Transposes the rows and columns of the matrix",
            "Creates a deep copy of the matrix"
        ),
        answerIndex = 0,
        explanation = "The nested loops in the comprehension iterate through each row, and then each value in the row, flattening the 2D matrix into a 1D list."
    ),
    Problem(
        id = "fill_medium_jr8_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Sorting Dictionaries",
        summary = "Sorting a list of dictionaries requires a key function.",
        prompt = "How can you sort these users by their age?",
        code = """
            users = [{"name": "Ana", "age": 25}, {"name": "Bob", "age": 20}]
            users.sort(key=lambda u: ____)
        """.trimIndent(),
        options = listOf(
            "u[\"age\"]",
            "u.age",
            "age",
            "users[\"age\"]"
        ),
        answerIndex = 0,
        explanation = "Dictionaries in Python are accessed using bracket notation with string keys, so `u[\"age\"]` extracts the age for sorting."
    ),
    Problem(
        id = "order_medium_jr8_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Yielding Lines",
        summary = "Arrange the code to create a generator that yields stripped lines from a file.",
        prompt = "Tap the lines in the correct order to define the generator function.",
        code = "",
        options = listOf(
            "        for line in f:",
            "            yield line.strip()",
            "def read_lines(filepath):",
            "    with open(filepath, 'r') as f:"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 3, 0, 1),
        explanation = "First define the function, then open the file using a context manager, iterate over the file object, and yield the stripped lines."
    ),
    Problem(
        id = "complex_medium_jr8_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Lookup in Loop",
        summary = "Converting a list to a set before checking membership.",
        prompt = "If list1 has length N and list2 has length M, what is the time complexity of this function?",
        code = """
            def find_common(list1, list2):
                set2 = set(list2)
                return [x for x in list1 if x in set2]
        """.trimIndent(),
        options = listOf(
            "O(N + M)",
            "O(N * M)",
            "O(N^2)",
            "O(M^2)"
        ),
        answerIndex = 0,
        explanation = "Creating `set2` takes O(M) time. The list comprehension iterates N times, and set lookups take O(1) time on average, resulting in O(N + M)."
    ),
    Problem(
        id = "trace_medium_jr8_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Filtered Dict Comprehension",
        summary = "Building a dictionary with a condition.",
        prompt = "What is the value of `d[\"d\"]` after this code runs?",
        code = """
            words = ["cat", "window", "defenestrate"]
            d = {w[0]: len(w) for w in words if len(w) > 3}
        """.trimIndent(),
        options = listOf(
            "12",
            "3",
            "6",
            "KeyError"
        ),
        answerIndex = 0,
        explanation = "The word 'defenestrate' has length 12 (> 3), so its first letter 'd' becomes a key mapped to its length, 12. 'cat' is ignored."
    ),
    Problem(
        id = "match_medium_jr8_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Stepping Range",
        summary = "Match the code to the output.",
        prompt = "Which code produces the output: `[1, 3, 5]`?",
        code = "",
        options = listOf(
            "print(list(range(1, 6, 2)))",
            "print(list(range(1, 5, 2)))",
            "print(list(range(0, 6, 2)))",
            "print(list(range(2, 6, 2)))"
        ),
        answerIndex = 0,
        explanation = "`range(1, 6, 2)` starts at 1, stops before 6, and steps by 2, yielding 1, 3, and 5."
    )
)
