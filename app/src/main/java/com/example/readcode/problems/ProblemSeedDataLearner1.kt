package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Student and junior-developer starter batches.
val easyProblemsStudents1 = listOf(
    Problem(
        id = "bug_easy_student_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong operator",
        summary = "A function meant to multiply uses the wrong math operator.",
        prompt = "What is the bug in this multiplication function?",
        code = """
            def multiply(a, b):
                return a + b
        """.trimIndent(),
        options = listOf(
            "It adds the numbers instead of multiplying them",
            "It should use a `*` symbol in the parameter list",
            "`multiply` is a reserved word",
            "It does not print the result"
        ),
        answerIndex = 0,
        explanation = "The function uses the addition operator `+` instead of the multiplication operator `*`."
    ),
    Problem(
        id = "output_easy_student_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String repetition",
        summary = "Using the multiplication operator on a string.",
        prompt = "What does this code print?",
        code = """
            message = "Hello"
            print(message * 2)
        """.trimIndent(),
        options = listOf("HelloHello", "Hello2", "Error", "Hello Hello"),
        answerIndex = 0,
        explanation = "Multiplying a string by an integer repeats the string that many times without adding spaces."
    ),
    Problem(
        id = "purpose_easy_student_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Positive check",
        summary = "A function that returns a boolean based on a condition.",
        prompt = "What does this function do?",
        code = """
            def is_positive(number):
                if number > 0:
                    return True
                else:
                    return False
        """.trimIndent(),
        options = listOf(
            "Checks if a number is greater than zero",
            "Makes a negative number positive",
            "Prints True or False to the screen",
            "Counts how many positive numbers there are"
        ),
        answerIndex = 0,
        explanation = "The function returns `True` if the number is strictly greater than 0, otherwise it returns `False`."
    ),
    Problem(
        id = "fill_easy_student_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "For loop keyword",
        summary = "Iterating over a list of items.",
        prompt = "Which keyword fills the blank to loop through the colors?",
        code = """
            colors = ["red", "blue", "green"]
            ___ color in colors:
                print(color)
        """.trimIndent(),
        options = listOf("for", "while", "if", "each"),
        answerIndex = 0,
        explanation = "The `for` keyword is used in Python to iterate over elements in a sequence like a list."
    )
)

val mediumProblemsJunior1 = listOf(
    Problem(
        id = "bug_medium_junior_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Shared default list",
        summary = "A default argument quietly reuses state across calls.",
        prompt = "Why does the second call unexpectedly include the task from the first call?",
        code = """
            def add_task(task, tasks=[]):
                tasks.append(task)
                return tasks

            morning = add_task("email")
            afternoon = add_task("deploy")
            print(afternoon)
        """.trimIndent(),
        options = listOf(
            "The default list is created once, so both calls mutate the same list object",
            "Lists passed into functions are copied before append runs",
            "The second call reassigns `morning` into `afternoon` automatically",
            "Python caches string literals, so the tasks merge by value"
        ),
        answerIndex = 0,
        explanation = "Default argument values are evaluated once when the function is defined, not each time it is called. That means both calls share the same `tasks` list, so `afternoon` becomes `[\"email\", \"deploy\"]`."
    ),
    Problem(
        id = "output_medium_junior_1",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Identity vs Equality",
        summary = "Comparing two identical lists with `==` and `is`.",
        prompt = "What does this code print?",
        code = """
            a = [1, 2, 3]
            b = [1, 2, 3]
            print(a == b, a is b)
        """.trimIndent(),
        options = listOf(
            "True False",
            "True True",
            "False False",
            "False True"
        ),
        answerIndex = 0,
        explanation = "`==` checks if the values are equal, which is True. `is` checks if they are the exact same object in memory, which is False because they are distinct lists."
    ),
    Problem(
        id = "purpose_medium_junior_1",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Adjacent differences",
        summary = "A generator compares each value with the one before it.",
        prompt = "What does this function yield for an input sequence?",
        code = """
            def measure_changes(values):
                previous = None
                for value in values:
                    if previous is not None:
                        yield value - previous
                    previous = value
        """.trimIndent(),
        options = listOf(
            "The change between each value and the one immediately before it",
            "Every value that is larger than the first value",
            "Running totals of all values seen so far",
            "Pairs of consecutive values from the input"
        ),
        answerIndex = 0,
        explanation = "The first item sets `previous` and yields nothing. After that, each new value yields `value - previous`, so the generator produces the difference between consecutive elements."
    ),
    Problem(
        id = "fill_medium_junior_1",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Persistent running total",
        summary = "Keeping updates in the enclosing scope so state survives across calls.",
        prompt = "Fill in the blank so the second call prints `7` instead of raising an error or resetting the total.",
        code = """
            def build_counter():
                total = 0

                def add(amount):
                    ___ total
                    total += amount
                    return total

                return add

            counter = build_counter()
            print(counter(3))
            print(counter(4))
        """.trimIndent(),
        options = listOf("nonlocal", "global", "static", "shared"),
        answerIndex = 0,
        explanation = "`nonlocal` tells Python that `total` belongs to the enclosing `build_counter()` scope. That lets `add()` update the same running total across both calls, so the outputs are 3 and then 7."
    )
)
