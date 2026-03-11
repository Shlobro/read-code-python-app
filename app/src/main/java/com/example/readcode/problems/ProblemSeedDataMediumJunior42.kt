package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior42 = listOf(
    Problem(
        id = "bug_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "2D Matrix Initialization",
        summary = "Creating a grid using list multiplication.",
        prompt = "Why doesn't this code update just the first element of the first row?",
        code = """
            grid = [[0] * 3] * 3
            grid[0][0] = 1
            print(grid)
        """.trimIndent(),
        options = listOf(
            "All rows reference the same inner list",
            "The list is converted into a tuple and cannot be modified after creation",
            "It raises an IndexError because the index is out of bounds for the matrix",
            "Python matrices require the numpy library to assign values to specific cells"
        ),
        answerIndex = 0,
        explanation = "Using the multiplication operator on a list containing a mutable object (like another list) creates multiple references to that same object, not independent copies."
    ),
    Problem(
        id = "output_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Iterating and Updating",
        summary = "Updating a dictionary based on its current keys.",
        prompt = "What is the output of this code?",
        code = """
            counts = {'a': 1, 'b': 2}
            for k in list(counts.keys()):
                counts[k.upper()] = counts.pop(k)
            print(sorted(counts.keys()))
        """.trimIndent(),
        options = listOf(
            "['a', 'b', 'A', 'B']",
            "['A', 'B']",
            "A RuntimeError is raised because the dictionary size changed",
            "['a', 'b']"
        ),
        answerIndex = 1,
        explanation = "We iterate over a static list of the original keys. Using pop(k) removes the lowercase keys, and assigning them to k.upper() adds the new uppercase keys."
    ),
    Problem(
        id = "purpose_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Zipping Sequences",
        summary = "Combining two lists.",
        prompt = "What is the primary purpose of this function?",
        code = """
            def build_mapping(keys, values):
                return dict(zip(keys, values))
        """.trimIndent(),
        options = listOf(
            "It sorts the keys and pairs them with the largest values",
            "It merges two lists into a single flat list containing all elements",
            "It creates a dictionary by pairing items from two lists",
            "It filters out duplicate elements from both sequences before combining them"
        ),
        answerIndex = 2,
        explanation = "The zip function pairs elements from the two iterables, and dict() converts those pairs into key-value pairs in a dictionary."
    ),
    Problem(
        id = "fill_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Resource Cleanup",
        summary = "Ensuring a cleanup block runs even on error.",
        prompt = "Fill in the blank to guarantee the print statement runs whether an exception occurs or not.",
        code = """
            try:
                x = 1 / 0
            except ZeroDivisionError:
                pass
            ___:
                print("Cleanup")
        """.trimIndent(),
        options = listOf(
            "else",
            "finally",
            "always",
            "except"
        ),
        answerIndex = 1,
        explanation = "The finally block is always executed after the try and except blocks finish, regardless of whether an exception was raised."
    ),
    Problem(
        id = "order_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Yielding Values",
        summary = "Arrange the lines to create and use a generator.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    for i in range(1, max + 1):",
            "print(list(count_up_to(3)))",
            "def count_up_to(max):",
            "        yield i"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 0, 3, 1),
        explanation = "First define the function, then loop through the range, yield the value inside the loop, and finally call the function outside."
    ),
    Problem(
        id = "complexity_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Lookup",
        summary = "Searching for a key in a dictionary.",
        prompt = "What is the average time complexity of checking if a key exists in a Python dictionary of size N?",
        code = """
            def has_key(data, target):
                return target in data
        """.trimIndent(),
        options = listOf(
            "O(N) because it iterates over the keys",
            "O(log N) because dictionaries are implemented as balanced trees",
            "O(N^2) due to potential hash collisions requiring deep inspection",
            "O(1) average time"
        ),
        answerIndex = 3,
        explanation = "Dictionaries in Python are implemented as hash tables, which provide an average O(1) time complexity for key lookups."
    ),
    Problem(
        id = "trace_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Global Variable",
        summary = "A function modifies a global variable.",
        prompt = "What is the value of `x` after `func()` is called?",
        code = """
            x = 10
            def func():
                global x
                x = 20
                y = x + 5
            
            func()
        """.trimIndent(),
        options = listOf(
            "10",
            "20",
            "25",
            "An error occurs"
        ),
        answerIndex = 1,
        explanation = "The global keyword allows the function to modify the x variable defined outside its scope. It changes x from 10 to 20."
    ),
    Problem(
        id = "match_medium_junior_42",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [5, 3]",
        summary = "Pick the code snippet that prints the reversed odd numbers.",
        prompt = "Which code correctly prints `[5, 3]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3, 4, 5][-1:-4:-2])",
            "print([1, 2, 3, 4, 5][::-2])",
            "print([1, 2, 3, 4, 5][4:1:-1])",
            "print([1, 2, 3, 4, 5][-1:-3:-1])"
        ),
        answerIndex = 0,
        explanation = "The slice [-1:-4:-2] starts at the last element (5), goes backwards by 2 steps (-2), and stops before the element at index -4, outputting [5, 3]."
    )
)
