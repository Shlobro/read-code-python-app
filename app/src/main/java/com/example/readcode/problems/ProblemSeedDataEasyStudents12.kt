package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents12 = listOf(
    Problem(
        id = "bug_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "A syntax error in the function definition.",
        prompt = "Why does this code cause a SyntaxError?",
        code = """
            def greet(name)
                print("Hello", name)
        """.trimIndent(),
        options = listOf(
            "Missing colon at the end of the def line",
            "`name` is not a string",
            "Indentation is incorrect",
            "`print` is missing an f-string"
        ),
        answerIndex = 0,
        explanation = "In Python, function definitions, loops, and conditional statements must end with a colon `:`."
    ),
    Problem(
        id = "output_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Integer division",
        summary = "Dividing numbers and dropping the remainder.",
        prompt = "What does this code print?",
        code = """
            result = 10 // 3
            print(result)
        """.trimIndent(),
        options = listOf(
            "3",
            "3.33",
            "1",
            "Error"
        ),
        answerIndex = 0,
        explanation = "The `//` operator performs floor division, which drops the fractional part and returns an integer."
    ),
    Problem(
        id = "purpose_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Absolute value",
        summary = "Changing signs based on condition.",
        prompt = "What does this function compute?",
        code = """
            def make_positive(num):
                if num < 0:
                    return -num
                return num
        """.trimIndent(),
        options = listOf(
            "The absolute value of the number",
            "The negative value of the number",
            "Checks if the number is less than zero",
            "Returns 0 for negative numbers"
        ),
        answerIndex = 0,
        explanation = "If the number is negative, it negates it to become positive. Otherwise, it returns the number as is."
    ),
    Problem(
        id = "fill_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "String length",
        summary = "Finding how many characters are in a string.",
        prompt = "Which function fills the blank to get the string length?",
        code = """
            word = "python"
            size = ___(word)
            print(size)
        """.trimIndent(),
        options = listOf(
            "len",
            "size",
            "count",
            "length"
        ),
        answerIndex = 0,
        explanation = "The `len()` function returns the number of items in an object, including the number of characters in a string."
    ),
    Problem(
        id = "order_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Read file contents",
        summary = "Open, read, and close a file.",
        prompt = "Arrange the code to safely read a file's content and close it.",
        code = "",
        options = listOf(
            "file.close()",
            "file = open(\"data.txt\", \"r\")",
            "content = file.read()"
        ),
        answerIndex = -1,
        correctOrder = listOf(1, 2, 0),
        explanation = "You must first open the file, then read its contents, and finally close it to free resources."
    ),
    Problem(
        id = "complexity_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Dictionary lookup",
        summary = "Accessing a value by its key.",
        prompt = "How long does it typically take to find a value in a dictionary by its key?",
        code = """
            def get_user_age(user_dict, user_id):
                return user_dict[user_id]
        """.trimIndent(),
        options = listOf(
            "Instant / constant time (O(1))",
            "Proportional to the size (O(N))",
            "Requires scanning all keys (O(N^2))",
            "Depends on the value's size"
        ),
        answerIndex = 0,
        explanation = "Dictionaries in Python are implemented as hash tables, allowing near-instant lookups regardless of size."
    ),
    Problem(
        id = "trace_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track list size",
        summary = "Monitoring list length after appends.",
        prompt = "What is the value of `len(items)` on the final line?",
        code = """
            items = []
            items.append(10)
            items.append(20)
            # What is len(items) here?
        """.trimIndent(),
        options = listOf(
            "2",
            "0",
            "1",
            "3"
        ),
        answerIndex = 0,
        explanation = "The list starts empty, and `append()` is called twice, adding two elements."
    ),
    Problem(
        id = "match_easy_student_12",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Print dictionary keys",
        summary = "Choose the code that prints keys from a dictionary.",
        prompt = "Which code produces this output?",
        code = """
            name
            age
        """.trimIndent(),
        options = listOf(
            "for k in {'name': 'Ana', 'age': 20}: print(k)",
            "print({'name': 'Ana', 'age': 20})",
            "for v in {'name': 'Ana', 'age': 20}.values(): print(v)",
            "print('name', 'age')"
        ),
        answerIndex = 0,
        explanation = "Iterating directly over a dictionary yields its keys. `print()` outputs each key on a new line."
    )
)
