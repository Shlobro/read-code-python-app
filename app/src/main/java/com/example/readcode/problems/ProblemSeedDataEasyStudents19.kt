package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val easyProblemsStudents19 = listOf(
    Problem(
        id = "bug_easy_student_19_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing Indentation",
        summary = "A basic function definition has an indentation error.",
        prompt = "Why will this code throw an error?",
        code = """
            def greet():
            print("Hello, world!")
        """.trimIndent(),
        options = listOf(
            "The print statement must be indented",
            "The function name is invalid",
            "Strings cannot contain commas",
            "The def keyword is misspelled"
        ),
        answerIndex = 0,
        explanation = "Python relies on indentation to define code blocks. The body of a function must be indented."
    ),
    Problem(
        id = "output_easy_student_19_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Integer Division",
        summary = "Dividing integers using the floor division operator.",
        prompt = "What does this print?",
        code = """
            result = 10 // 3
            print(result)
        """.trimIndent(),
        options = listOf(
            "3",
            "3.333",
            "4",
            "1"
        ),
        answerIndex = 0,
        explanation = "The `//` operator performs floor division, which discards the fractional part and returns the integer part of the quotient."
    ),
    Problem(
        id = "purpose_easy_student_19_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "List Reversal",
        summary = "Reversing the elements of a list in place.",
        prompt = "What does the `reverse` method do here?",
        code = """
            items = [1, 2, 3]
            items.reverse()
        """.trimIndent(),
        options = listOf(
            "Reverses the order of the items in the list",
            "Sorts the list in ascending order",
            "Removes the last item from the list",
            "Returns a new list with the items reversed"
        ),
        answerIndex = 0,
        explanation = "The `reverse()` method modifies the original list by reversing its elements in place. It does not return a new list."
    ),
    Problem(
        id = "fill_easy_student_19_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Type Conversion",
        summary = "Converting a string to an integer.",
        prompt = "Fill in the blank to convert the string to a number.",
        code = """
            age_str = "20"
            age_num = ___(age_str)
        """.trimIndent(),
        options = listOf(
            "int",
            "str",
            "float",
            "num"
        ),
        answerIndex = 0,
        explanation = "The `int()` function converts a string representation of a whole number into an integer object."
    ),
    Problem(
        id = "order_easy_student_19_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "If-Else Block",
        summary = "Arrange the code to create a simple conditional statement.",
        prompt = "Put the lines in the correct order to print 'Adult' if age is 18 or more, else 'Minor'.",
        code = "",
        options = listOf(
            "    print(\"Adult\")",
            "if age >= 18:",
            "else:",
            "age = 20",
            "    print(\"Minor\")"
        ),
        answerIndex = -1,
        correctOrder = listOf(3, 1, 0, 2, 4),
        explanation = "First define the variable, then check the condition with `if`. If true, print 'Adult'. Otherwise, use `else` to print 'Minor'."
    ),
    Problem(
        id = "complexity_easy_student_19_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "String Multiplication",
        summary = "Multiplying a string by an integer repeats it.",
        prompt = "How many characters will be in the final string?",
        code = """
            text = "abc"
            result = text * 3
        """.trimIndent(),
        options = listOf(
            "9",
            "3",
            "6",
            "1"
        ),
        answerIndex = 0,
        explanation = "Multiplying 'abc' (3 characters) by 3 repeats it 3 times: 'abcabcabc'. The total length is 3 * 3 = 9 characters."
    ),
    Problem(
        id = "trace_easy_student_19_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Tracking a String",
        summary = "Tracking a string variable as it is reassigned.",
        prompt = "What is the final value of the `greeting` variable?",
        code = """
            greeting = "Hi"
            greeting = greeting + " there"
            greeting = greeting + "!"
        """.trimIndent(),
        options = listOf(
            "Hi there!",
            "Hi there",
            "Hithere!",
            "Hi"
        ),
        answerIndex = 0,
        explanation = "Initially 'Hi'. Then ' there' is appended: 'Hi there'. Finally, '!' is appended: 'Hi there!'."
    ),
    Problem(
        id = "match_easy_student_19_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Indexing",
        summary = "Accessing the last element of a list.",
        prompt = "Which code snippet correctly prints the last element 'cherry'?",
        code = "",
        options = listOf(
            "fruits = ['apple', 'banana', 'cherry']; print(fruits[-1])",
            "fruits = ['apple', 'banana', 'cherry']; print(fruits[3])",
            "fruits = ['apple', 'banana', 'cherry']; print(fruits[1])",
            "fruits = ['apple', 'banana', 'cherry']; print(fruits[-2])"
        ),
        answerIndex = 0,
        explanation = "In Python, a negative index counts from the end of the list. Index -1 refers to the very last element."
    )
)
