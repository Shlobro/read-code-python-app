package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents52 = listOf(
    Problem(
        id = "bug_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Wrong Starting Total",
        summary = "A counter starts with the wrong value.",
        prompt = "Why does this code print the wrong total?",
        code = """
            total = 1
            for number in [2, 3]:
                total += number
            print(total)
        """.trimIndent(),
        options = listOf(
            "The loop should use parentheses.",
            "The total should start at 0.",
            "The numbers must be strings.",
            "The print line should be first."
        ),
        answerIndex = 1,
        explanation = "Starting at 1 adds an extra value, so the total is too large."
    ),
    Problem(
        id = "output_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "One List Item",
        summary = "The code reads the first value in a list.",
        prompt = "What does this code print?",
        code = """
            colors = ["red", "blue", "green"]
            print(colors[0])
        """.trimIndent(),
        options = listOf(
            "blue",
            "green",
            "0",
            "red"
        ),
        answerIndex = 3,
        explanation = "Index 0 means the first item, so Python prints `red`."
    ),
    Problem(
        id = "purpose_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Double a Number",
        summary = "A function multiplies one value by 2.",
        prompt = "What does this function do?",
        code = """
            def double(value):
                return value * 2
        """.trimIndent(),
        options = listOf(
            "It returns twice the input.",
            "It adds two values together.",
            "It checks whether a number is even.",
            "It prints a value without returning it."
        ),
        answerIndex = 0,
        explanation = "The function multiplies the input by 2 and returns the result."
    ),
    Problem(
        id = "fill_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Print a Name",
        summary = "A function name is missing.",
        prompt = "Fill in the blank so the code shows the value of `name`.",
        code = """
            name = "Mia"
            ___(name)
        """.trimIndent(),
        options = listOf(
            "input",
            "return",
            "print",
            "len"
        ),
        answerIndex = 2,
        explanation = "`print(name)` displays the value stored in `name`."
    ),
    Problem(
        id = "order_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Store and Show a Word",
        summary = "Arrange the lines to save text and print it.",
        prompt = "Arrange these lines into a working program.",
        code = "",
        options = listOf(
            "word = \"hi\"",
            "print(message)",
            "message = word"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 2, 1),
        explanation = "Create `word`, copy it into `message`, and then print `message`."
    ),
    Problem(
        id = "complexity_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Count the Prints",
        summary = "A loop runs once per list item.",
        prompt = "How many times does `print(score)` run?",
        code = """
            scores = [8, 9, 10, 11, 12]
            for score in scores:
                print(score)
        """.trimIndent(),
        options = listOf(
            "4 times",
            "5 times",
            "6 times",
            "12 times"
        ),
        answerIndex = 1,
        explanation = "There are five items in the list, so the loop body runs five times."
    ),
    Problem(
        id = "trace_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Trace `count`",
        summary = "Follow one variable through three updates.",
        prompt = "What is the final value of `count`?",
        code = """
            count = 2
            count = count + 5
            count = count - 1
            count = count + 3
        """.trimIndent(),
        options = listOf(
            "7",
            "8",
            "10",
            "9"
        ),
        answerIndex = 3,
        explanation = "Start at 2, then go to 7, then 6, then 9."
    ),
    Problem(
        id = "match_easy_student_52",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output Is `4`",
        summary = "Choose the code that prints one number.",
        prompt = "Which code produces the output `4`?",
        code = "",
        options = listOf(
            "x = 1\nprint(x + 1)",
            "x = 2\nprint(x + 1)",
            "x = 2\nprint(x * 2)",
            "x = 4\nprint(x - 2)"
        ),
        answerIndex = 2,
        explanation = "When `x` is 2, `x * 2` evaluates to 4."
    )
)
