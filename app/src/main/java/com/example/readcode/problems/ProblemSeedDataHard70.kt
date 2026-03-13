package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 70.
// One senior-level problem per problem type.
val hardProblems70 = listOf(
    Problem(
        id = "bug_hard_71",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in loop",
        summary = "All lambdas in the list reference the same loop variable at its final value.",
        prompt = "What is the bug in this code?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)
            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "Each lambda captures `i` by reference, so all return 2 when called after the loop",
            "`lambda` cannot be used inside a `for` loop body",
            "`range(3)` produces values 1, 2, 3, so the lambdas return 1, 2, 3",
            "The list comprehension that calls the lambdas evaluates them before the loop ends, returning [0, 1, 2]"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variables by reference, not by value. After the loop, `i` is 2, so every lambda in the list returns 2. The output is `[2, 2, 2]`. The fix is `lambda i=i: i` to bind the current value at definition time."
    ),
    Problem(
        id = "output_hard_71",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO and cooperative super()",
        summary = "Trace the method resolution order through a diamond inheritance.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self): print("A")

            class B(A):
                def greet(self):
                    super().greet()
                    print("B")

            class C(A):
                def greet(self):
                    super().greet()
                    print("C")

            class D(B, C):
                def greet(self):
                    super().greet()
                    print("D")

            D().greet()
        """.trimIndent(),
        options = listOf(
            "A\nC\nB\nD",
            "A\nB\nC\nD",
            "A\nB\nD",
            "A\nD"
        ),
        answerIndex = 0,
        explanation = "Python's MRO for D is D → B → C → A. `super()` follows this order. D calls B.greet, which calls C.greet (not A.greet directly), which calls A.greet. A prints first, then C returns and prints 'C', then B returns and prints 'B', then D prints 'D'. Output: A, C, B, D."
    ),
    Problem(
        id = "purpose_hard_71",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__class_getitem__ for generic aliases",
        summary = "Allow a user-defined class to support [] subscript syntax.",
        prompt = "What is the primary purpose of this code?",
        code = """
            class Stack:
                def __class_getitem__(cls, item):
                    return f"Stack[{item.__name__}]"

            hint = Stack[int]
            print(hint)
        """.trimIndent(),
        options = listOf(
            "Restrict `Stack` so it only accepts integers at runtime",
            "Enable `Stack[int]` subscript syntax and return a type-hint string",
            "Register `Stack` as a generic alias in the `typing` module so tools like mypy recognise it",
            "Create a new subclass of `Stack` specialised for the given element type"
        ),
        answerIndex = 1,
        explanation = "`__class_getitem__` is called when a class is subscripted with `[]`. Here it returns a formatted string. This is the hook used by `typing.Generic` and similar classes to support `MyClass[T]` syntax without modifying the metaclass."
    ),
    Problem(
        id = "fill_hard_71",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "itertools.chain.from_iterable",
        summary = "Flatten one level of nesting from an iterable of iterables.",
        prompt = "Fill the blank so `result` is `[1, 2, 3, 4, 5, 6]`.",
        code = """
            import itertools

            nested = [[1, 2], [3, 4], [5, 6]]
            result = list(itertools.chain.___(nested))
        """.trimIndent(),
        options = listOf(
            "from_iterable",
            "flatten",
            "reduce",
            "merge"
        ),
        answerIndex = 0,
        explanation = "`itertools.chain.from_iterable(nested)` lazily yields each element from each sub-iterable in turn, flattening one level. `chain.flatten`, `chain.reduce`, and `chain.merge` do not exist."
    ),
    Problem(
        id = "order_hard_70",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search on a sorted array",
        summary = "Arrange the iterative binary search that returns the target index or -1.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def binary_search(arr, target):",
            "    lo, hi = 0, len(arr) - 1",
            "    while lo <= hi:",
            "        mid = (lo + hi) // 2",
            "        if arr[mid] == target:",
            "            return mid",
            "        elif arr[mid] < target:",
            "            lo = mid + 1",
            "        else:",
            "            hi = mid - 1",
            "    return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Initialise lo and hi to the array bounds. Each iteration computes the midpoint and either returns it (hit), moves lo up (target is in the right half), or moves hi down (target is in the left half). The loop exits when lo > hi, meaning the target is absent."
    ),
    Problem(
        id = "complexity_hard_70",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive subset enumeration",
        summary = "Backtracking that builds every subset of the input list.",
        prompt = "What is the time complexity of this algorithm (n = len(nums))?",
        code = """
            def subsets(nums):
                result = []
                def backtrack(start, path):
                    result.append(list(path))
                    for i in range(start, len(nums)):
                        path.append(nums[i])
                        backtrack(i + 1, path)
                        path.pop()
                backtrack(0, [])
                return result
        """.trimIndent(),
        options = listOf(
            "O(n²)",
            "O(2^n)",
            "O(n * 2^n)",
            "O(n!)"
        ),
        answerIndex = 2,
        explanation = "There are 2^n subsets. Each subset can be up to n elements long, and copying it into `result` costs O(n). Total work is O(n * 2^n). O(2^n) accounts only for the number of recursive calls, not the copy cost. O(n!) would apply to permutations, not subsets."
    ),
    Problem(
        id = "trace_hard_70",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Property setter bypassed by __init__",
        summary = "Trace whether a property setter runs when assigning in __init__.",
        prompt = "What does this code print?",
        code = """
            class Celsius:
                def __init__(self, temp):
                    self.temp = temp

                @property
                def temp(self):
                    return self._temp

                @temp.setter
                def temp(self, value):
                    if value < -273.15:
                        raise ValueError("too cold")
                    self._temp = value

            c = Celsius(25)
            print(c.temp)
        """.trimIndent(),
        options = listOf(
            "25",
            "AttributeError",
            "ValueError",
            "None"
        ),
        answerIndex = 0,
        explanation = "`self.temp = temp` in `__init__` goes through the property setter because `temp` is defined as a property on the class. The setter stores the value in `self._temp`. Reading `c.temp` invokes the getter, which returns `self._temp`, so `25` is printed."
    ),
    Problem(
        id = "match_hard_70",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: Counter({'a': 3})",
        summary = "Identify which snippet produces a Counter with only key 'a' having count 3.",
        prompt = "Which snippet prints `Counter({'a': 3})`?",
        code = "Counter({'a': 3})",
        options = listOf(
            "from collections import Counter\nc = Counter('aab')\nc.subtract({'b': 1})\nprint(c + Counter())",
            "from collections import Counter\nprint(Counter({'a': 3, 'b': 0}))",
            "from collections import Counter\nc = Counter('aaab')\ndel c['b']\nprint(c)",
            "from collections import Counter\nc = Counter('aaa')\nc.update({'a': 1, 'b': 1})\nprint(c)"
        ),
        answerIndex = 2,
        explanation = "Option C: `Counter('aaab')` gives `{'a':3,'b':1}`; `del c['b']` removes the key entirely, so printing yields `Counter({'a': 3})`. Option A: `Counter('aab')` is `{'a':2,'b':1}`; `subtract({'b':1})` drops 'b' to 0; `+ Counter()` strips zero/negative counts, giving `Counter({'a': 2})`. Option B: a Counter built with an explicit zero count prints `Counter({'a': 3, 'b': 0})`. Option D: `Counter('aaa')` is `{'a':3}`; `update({'a':1,'b':1})` adds counts, giving `Counter({'a': 4, 'b': 1})`."
    )
)
