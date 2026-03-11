package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior43 = listOf(
    Problem(
        id = "bug_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late Binding Closure",
        summary = "A list of lambdas inside a loop.",
        prompt = "Why does `[m(2) for m in multipliers]` return `[4, 4, 4]` instead of `[0, 2, 4]`?",
        code = """
            def make_multipliers():
                return [lambda x: i * x for i in range(3)]

            multipliers = make_multipliers()
            print([m(2) for m in multipliers])
        """.trimIndent(),
        options = listOf(
            "Late binding of the loop variable",
            "The return statement is missing inside the lambda definition",
            "List comprehensions cannot return lambda functions",
            "The lambda expects two arguments but only receives one"
        ),
        answerIndex = 0,
        explanation = "In Python, closures created in a loop capture the variable itself, not its value. When called, they all see the final value of i, which is 2."
    ),
    Problem(
        id = "output_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Mutable Default Arg",
        summary = "Class initialized with a default list.",
        prompt = "What does this code print?",
        code = """
            class Node:
                def __init__(self, val, children=[]):
                    self.val = val
                    self.children = children

            node1 = Node(1)
            node2 = Node(2)
            node1.children.append(3)
            print(node2.children)
        """.trimIndent(),
        options = listOf(
            "[]",
            "[1, 2, 3]",
            "[3]",
            "A runtime error occurs because children is uninitialized"
        ),
        answerIndex = 2,
        explanation = "The default argument `children=[]` is evaluated only once when the function is defined. Both `node1` and `node2` share the same default list object."
    ),
    Problem(
        id = "purpose_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Deduplicate List",
        summary = "Using a set within a list comprehension.",
        prompt = "What is the primary purpose of this code?",
        code = """
            def process(items):
                seen = set()
                return [x for x in items if not (x in seen or seen.add(x))]
        """.trimIndent(),
        options = listOf(
            "It raises a TypeError on execution",
            "It removes duplicates and then sorts the final list based on seen items",
            "It returns unique items in order",
            "It calculates the intersection of the items and seen set"
        ),
        answerIndex = 2,
        explanation = "This is a common Python idiom to deduplicate an iterable while preserving its original order. `seen.add(x)` returns `None`, which is falsy."
    ),
    Problem(
        id = "fill_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Callable Instance",
        summary = "Making an object callable like a function.",
        prompt = "Which method allows the instance `c` to be called as `c()`?",
        code = """
            class Counter:
                def __init__(self):
                    self.count = 0
                def ___(self):
                    self.count += 1
                    return self.count

            c = Counter()
            print(c())
        """.trimIndent(),
        options = listOf(
            "call",
            "invoke",
            "__call__",
            "This cannot be achieved without inheriting from a callable base class"
        ),
        answerIndex = 2,
        explanation = "Implementing the `__call__` dunder method allows instances of a class to be invoked as if they were functions."
    ),
    Problem(
        id = "order_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Class Method",
        summary = "Define a class with a class method.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "        return cls(cls.default_val)",
            "    @classmethod",
            "    def create_default(cls):",
            "class Factory:"
        ),
        answerIndex = 0,
        correctOrder = listOf(3, 1, 2, 0),
        explanation = "A class definition comes first. A class method requires the `@classmethod` decorator directly above the method definition, and the method must take `cls` as its first parameter."
    ),
    Problem(
        id = "complexity_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Unique Elements Complexity",
        summary = "Converting list to set and back.",
        prompt = "What is the average time complexity of this function for a list of size N?",
        code = """
            def get_unique(data):
                return list(set(data))
        """.trimIndent(),
        options = listOf(
            "O(N log N) because sets maintain a sorted order internally",
            "O(N^2)",
            "O(N)",
            "O(1)"
        ),
        answerIndex = 2,
        explanation = "Creating a set from a list iterates through the list once, taking O(N) time on average since set insertions are O(1). Converting back to a list also takes O(N) time."
    ),
    Problem(
        id = "trace_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "List Rebinding",
        summary = "Adding lists creates a new object.",
        prompt = "What is the value of `my_list` after the function call?",
        code = """
            def update_val(v):
                v = v + [4]
                return v

            my_list = [1, 2, 3]
            update_val(my_list)
        """.trimIndent(),
        options = listOf(
            "[1, 2, 3, 4]",
            "[1, 2, 3]",
            "A TypeError occurs because lists cannot be added together",
            "None"
        ),
        answerIndex = 1,
        explanation = "The expression `v + [4]` creates a new list object and binds it to the local name `v`. It does not modify the original list passed in as an argument."
    ),
    Problem(
        id = "match_medium_junior_43",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: ['a', 'b', 'c']",
        summary = "Converting a string to a list of characters.",
        prompt = "Which code produces `['a', 'b', 'c']`?",
        code = "",
        options = listOf(
            "print(list('abc'.keys()))",
            "print([k for k, v in enumerate('abc')])",
            "print(list('abc'))",
            "This output is impossible to generate without an explicit loop definition"
        ),
        answerIndex = 2,
        explanation = "The `list()` constructor iterates over the string 'abc', producing a list of its individual characters."
    )
)
