package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior15 = listOf(
    Problem(
        id = "bug_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Unreachable Except Block",
        summary = "Exception caught too broadly.",
        prompt = "Why is the ZeroDivisionError block never executed?",
        code = """
            try:
                result = 10 / 0
            except Exception as e:
                print("Error")
            except ZeroDivisionError:
                print("Division by zero")
        """.trimIndent(),
        options = listOf(
            "ZeroDivisionError is never reached because Exception catches it first",
            "You cannot catch Exception in Python",
            "The try block does not raise an exception",
            "Exception variables must be named err"
        ),
        answerIndex = 0,
        explanation = "In Python, except blocks are checked top-to-bottom. Since `Exception` is the base class for most exceptions, it catches the `ZeroDivisionError` first, making the specific block unreachable."
    ),
    Problem(
        id = "output_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Comprehension with If-Else",
        summary = "Applying a conditional transformation to list elements.",
        prompt = "What does this code print?",
        code = """
            nums = [1, 2, 3, 4, 5]
            res = [x if x % 2 == 0 else -x for x in nums]
            print(res)
        """.trimIndent(),
        options = listOf(
            "[-1, 2, -3, 4, -5]",
            "[1, 2, 3, 4, 5]",
            "[-1, -3, -5]",
            "[2, 4]"
        ),
        answerIndex = 0,
        explanation = "The list comprehension applies the `if x % 2 == 0 else -x` expression to each element. Odd numbers become negative, and even numbers stay positive."
    ),
    Problem(
        id = "purpose_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Zip Function",
        summary = "Pairing elements from multiple iterables.",
        prompt = "What does this snippet do?",
        code = """
            keys = ['a', 'b', 'c']
            values = [1, 2, 3]
            result = dict(zip(keys, values))
        """.trimIndent(),
        options = listOf(
            "Combines two lists into a dictionary",
            "Sorts the lists and combines them",
            "Zips the files containing the lists",
            "Creates a tuple of two lists"
        ),
        answerIndex = 0,
        explanation = "The `zip` function pairs corresponding elements from the iterables, and `dict()` converts these pairs into key-value pairs in a dictionary."
    ),
    Problem(
        id = "fill_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Static Method Decorator",
        summary = "Defining a method that doesn't require a class instance.",
        prompt = "Fill in the blank to define a static method.",
        code = """
            class MathUtils:
                ___
                def add(a, b):
                    return a + b
            
            print(MathUtils.add(5, 10))
        """.trimIndent(),
        options = listOf(
            "@staticmethod",
            "@classmethod",
            "@property",
            "@override"
        ),
        answerIndex = 0,
        explanation = "The `@staticmethod` decorator defines a method that can be called on the class directly without creating an instance, and it doesn't receive an implicit `self` or `cls` argument."
    ),
    Problem(
        id = "order_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Read File Safely",
        summary = "Using try-except and with statements together.",
        prompt = "Arrange the lines to read the first line of a file, handling missing files safely.",
        code = "",
        options = listOf(
            "def read_first_line(file_path):",
            "    try:",
            "        with open(file_path, 'r') as file:",
            "            return file.readline()",
            "    except FileNotFoundError:",
            "        return None"
        ),
        answerIndex = 0, // Ignored for ORDER_STEPS
        correctOrder = listOf(0, 1, 2, 3, 4, 5),
        explanation = "We define the function, open a `try` block, use `with open` to handle resource management, read the line, and catch `FileNotFoundError` if the file does not exist."
    ),
    Problem(
        id = "complexity_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Key Lookup",
        summary = "Time complexity of checking for a key in a dictionary.",
        prompt = "What is the average time complexity of checking if a key exists in a dictionary with N items?",
        code = """
            def check_key(my_dict, key):
                return key in my_dict
        """.trimIndent(),
        options = listOf(
            "O(1)",
            "O(N)",
            "O(log N)",
            "O(N^2)"
        ),
        answerIndex = 0,
        explanation = "Dictionaries in Python are implemented as hash tables. Looking up a key takes O(1) average time complexity."
    ),
    Problem(
        id = "trace_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Variable Shadowing",
        summary = "Local scope vs global scope variables.",
        prompt = "What is the value of `x` printed at the end?",
        code = """
            x = 10
            def modify():
                x = 5
                x += 1
                return x
            
            modify()
            print(x)
        """.trimIndent(),
        options = listOf(
            "10",
            "5",
            "6",
            "11"
        ),
        answerIndex = 0,
        explanation = "The `modify()` function defines a local variable `x` that shadows the global `x`. The global `x` is never modified, so it remains 10."
    ),
    Problem(
        id = "match_medium_junior_15",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "String Formatting Zero Padding",
        summary = "Padding a number with leading zeros.",
        prompt = "Which code produces this output: `Score: 095`?",
        code = "",
        options = listOf(
            "print(f'Score: {95:03}')",
            "print(f'Score: {95:3}')",
            "print(f'Score: 0{95}')",
            "print('Score: ' + '95'.pad(3))"
        ),
        answerIndex = 0,
        explanation = "In Python f-strings, `:03` formats the integer to have a minimum width of 3, padding with leading zeros if necessary."
    )
)
