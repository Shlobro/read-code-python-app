package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior10 = listOf(
    Problem(
        id = "bug_medium_jr10_1",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Class Variable Mutation",
        summary = "All instances share the same list.",
        prompt = "What is the logical bug in this class definition?",
        code = """
            class User:
                roles = []
                
                def add_role(self, role):
                    self.roles.append(role)
                    
            u1 = User()
            u1.add_role("Admin")
            u2 = User()
            print(u2.roles)
        """.trimIndent(),
        options = listOf(
            "`roles` is a class attribute, so all instances share the same list",
            "`add_role` is missing the `@classmethod` decorator",
            "`self.roles` cannot be modified after initialization",
            "`u2` will throw an AttributeError"
        ),
        answerIndex = 0,
        explanation = "In Python, lists defined at the class level are shared among all instances. To give each instance its own list, it should be defined inside `__init__`."
    ),
    Problem(
        id = "output_medium_jr10_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Late Binding in Closures",
        summary = "Lambda functions inside a loop.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(3)]
            print(funcs[0]())
        """.trimIndent(),
        options = listOf(
            "2",
            "0",
            "1",
            "[0, 1, 2]"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variables by reference, not by value. By the time the lambda is called, the loop has finished and `i` is 2."
    ),
    Problem(
        id = "purpose_medium_jr10_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "The any() Function",
        summary = "Using a generator expression with any().",
        prompt = "What is the purpose of this function?",
        code = """
            def check(data):
                return any(x % 2 == 0 for x in data)
        """.trimIndent(),
        options = listOf(
            "Returns True if there is at least one even number in the iterable",
            "Returns True if all numbers in the iterable are even",
            "Returns a list of all even numbers in the iterable",
            "Returns True if the length of the iterable is even"
        ),
        answerIndex = 0,
        explanation = "The `any()` function returns `True` if any element of the iterable is true. Here, it checks if any element is even."
    ),
    Problem(
        id = "fill_medium_jr10_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Calling Parent Init",
        summary = "Initializing a subclass properly.",
        prompt = "Fill in the blank to call the parent class constructor.",
        code = """
            class Child(Parent):
                def __init__(self, value):
                    ____.__init__(value)
                    self.child_value = 10
        """.trimIndent(),
        options = listOf(
            "super()",
            "Parent()",
            "self",
            "base()"
        ),
        answerIndex = 0,
        explanation = "In Python, `super()` is used to call methods from the parent class, most commonly used in `__init__`."
    ),
    Problem(
        id = "order_medium_jr10_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Exception Handling Flow",
        summary = "Arrange the blocks in the correct order for a complete try-except structure.",
        prompt = "Arrange the lines of code to form a valid try-except-else-finally block.",
        code = "",
        options = listOf(
            "try:\n    result = 10 / 2",
            "except ZeroDivisionError:\n    print('Error')",
            "else:\n    print(result)",
            "finally:\n    print('Done')"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3),
        explanation = "The correct order in Python is `try`, followed by one or more `except` blocks, an optional `else` block (executed if no exception occurs), and an optional `finally` block (always executed)."
    ),
    Problem(
        id = "complex_medium_jr10_6",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "List vs Set Membership",
        summary = "Checking membership inside a loop.",
        prompt = "What is the worst-case time complexity of this function, where N is len(list1) and M is len(list2)?",
        code = """
            def find_common(list1, list2):
                common = []
                for item in list1:
                    if item in list2:
                        common.append(item)
                return common
        """.trimIndent(),
        options = listOf(
            "O(N * M)",
            "O(N + M)",
            "O(N log M)",
            "O(1)"
        ),
        answerIndex = 0,
        explanation = "The outer loop runs N times. The `in` operator on a list takes O(M) time in the worst case. Therefore, the total time complexity is O(N * M). Converting `list2` to a set first would reduce this to O(N + M)."
    ),
    Problem(
        id = "trace_medium_jr10_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Slice Assignment",
        summary = "Replacing a slice of a list.",
        prompt = "What is the value of `nums[2]` at the end?",
        code = """
            nums = [1, 2, 3, 4]
            nums[1:3] = [8, 9]
            print(nums[2])
        """.trimIndent(),
        options = listOf(
            "9",
            "3",
            "8",
            "4"
        ),
        answerIndex = 0,
        explanation = "The slice assignment replaces `[2, 3]` with `[8, 9]`. The new list is `[1, 8, 9, 4]`. The element at index 2 is `9`."
    ),
    Problem(
        id = "match_medium_jr10_8",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Collections Counter",
        summary = "Match the code to the dictionary output.",
        prompt = "Which snippet produces `{'a': 2, 'b': 1}`?",
        code = "",
        options = listOf(
            "from collections import Counter\nprint(dict(Counter('aab')))",
            "print({x: 'aab'.count(x) for x in 'aabb'})",
            "print(dict(a=1, b=2))",
            "print({'a': 1, 'b': 2})"
        ),
        answerIndex = 0,
        explanation = "`Counter('aab')` counts the occurrences of each character, resulting in `Counter({'a': 2, 'b': 1})`. Calling `dict()` converts it exactly to the requested output."
    )
)