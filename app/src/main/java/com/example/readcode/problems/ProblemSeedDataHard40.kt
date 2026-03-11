package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 40.
// One senior-level problem per problem type.
val hardProblems40 = listOf(
    Problem(
        id = "bug_hard_41",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in loop",
        summary = "Functions created in a loop all capture the same variable.",
        prompt = "Why do all functions in `funcs` print the same value?",
        code = """
            funcs = []
            for i in range(5):
                funcs.append(lambda: i)
            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "All lambdas close over the same `i` variable; by the time they are called, `i` equals 4",
            "Lambdas inside loops always raise a `NameError` for loop variables",
            "`range(5)` returns indices starting at 1, so each lambda captures a different value",
            "`append` copies the lambda by value, so each closure is independent"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variables by reference, not by value. All five lambdas share the same binding to `i`. After the loop finishes, `i` is `4`, so every call returns `4`. The fix is a default-argument capture: `lambda i=i: i`."
    ),
    Problem(
        id = "output_hard_41",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO diamond with super()",
        summary = "Method Resolution Order determines which `greet` runs in a diamond hierarchy.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self):
                    return "A"

            class B(A):
                def greet(self):
                    return "B" + super().greet()

            class C(A):
                def greet(self):
                    return "C" + super().greet()

            class D(B, C):
                pass

            print(D().greet())
        """.trimIndent(),
        options = listOf(
            "BCA",
            "BA",
            "BCA\nCA",
            "Error"
        ),
        answerIndex = 0,
        explanation = "Python's C3 linearisation gives `D` the MRO `D → B → C → A`. `D().greet()` calls `B.greet`, which returns `'B' + super().greet()`. `super()` inside `B` follows the MRO and finds `C.greet` next, returning `'C' + super().greet()`. `super()` inside `C` reaches `A.greet`, returning `'A'`. The concatenation is therefore `'B' + 'C' + 'A'` = `'BCA'`."
    ),
    Problem(
        id = "purpose_hard_41",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook",
        summary = "A base class enforces a contract on every subclass at definition time.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            class Plugin:
                def __init_subclass__(cls, /, required_name: str, **kwargs):
                    super().__init_subclass__(**kwargs)
                    if not hasattr(cls, required_name):
                        raise TypeError(
                            f"{cls.__name__} must define '{required_name}'"
                        )

            class ImagePlugin(Plugin, required_name="process"):
                def process(self, data): ...
        """.trimIndent(),
        options = listOf(
            "Validate that every subclass defines a specific attribute or method at class-definition time, before any instance is created",
            "Prevent subclasses from overriding methods defined on the base class",
            "Automatically register subclasses in a global plugin registry",
            "Forward unknown keyword arguments from subclass definitions to `object.__init__`"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called by Python's metaclass machinery each time a direct or indirect subclass is defined. It receives keyword arguments from the class statement. Here it checks that the required attribute exists on the new subclass immediately at definition time — before any instantiation — raising `TypeError` if the contract is violated. This is a zero-boilerplate alternative to abstract base classes for lightweight interface enforcement."
    ),
    Problem(
        id = "fill_hard_41",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.cache vs lru_cache",
        summary = "Choose the decorator that caches with an unbounded cache on a recursive function.",
        prompt = "Which decorator fills the blank so `fib` is memoised with no size limit?",
        code = """
            from functools import ___

            @___
            def fib(n: int) -> int:
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)

            print(fib(50))
        """.trimIndent(),
        options = listOf(
            "cache",
            "lru_cache(maxsize=None)",
            "cached_property",
            "reduce"
        ),
        answerIndex = 0,
        explanation = "`functools.cache` (added in Python 3.9) is a simple unbounded memoisation decorator equivalent to `lru_cache(maxsize=None)` but with less overhead because it skips the LRU bookkeeping. `cached_property` is for instance attributes, not free functions. `reduce` is unrelated to caching."
    ),
    Problem(
        id = "order_hard_40",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search implementation",
        summary = "Arrange the steps of an iterative binary search in correct source order.",
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
        explanation = "Binary search initialises two pointers at the array bounds. Each iteration computes the midpoint: if it matches the target the index is returned; if the target is larger, the lower bound advances past mid; otherwise the upper bound retreats below mid. When the bounds cross without a match the function returns -1."
    ),
    Problem(
        id = "complexity_hard_40",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Repeated string concatenation in loop",
        summary = "Determine the overall time complexity of building a string by concatenation inside a loop.",
        prompt = "What is the time complexity of this function?",
        code = """
            def build(n: int) -> str:
                result = ""
                for i in range(n):
                    result += str(i)
                return result
        """.trimIndent(),
        options = listOf(
            "O(n²) — each `+=` copies the entire accumulated string, giving a 1 + 2 + … + n pattern",
            "O(n) — CPython optimises in-place string concatenation to amortised O(1) per step",
            "O(n log n) — the string is re-hashed after each concatenation",
            "O(1) — strings are stored as pointers so appending is constant time"
        ),
        answerIndex = 0,
        explanation = "In the general case, string concatenation with `+=` creates a new string object on each iteration, copying all existing characters. For an accumulated string of length L, each copy costs O(L). Over n iterations the lengths are 0, 1, 3, … giving a total cost of O(1 + 2 + … + n) = O(n²). While CPython sometimes applies a refcount optimisation that makes consecutive `+=` amortised O(n), this is an implementation detail that cannot be relied upon and the standard complexity analysis is O(n²). Use `''.join(...)` for a guaranteed O(n) solution."
    ),
    Problem(
        id = "trace_hard_40",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Nonlocal vs global rebind",
        summary = "Track the value of `x` in each scope after the nested function runs.",
        prompt = "What does the final `print(x)` at module level output?",
        code = """
            x = 10

            def outer():
                x = 20
                def inner():
                    nonlocal x
                    x = 30
                inner()
                print(x)   # line A

            outer()
            print(x)       # line B
        """.trimIndent(),
        options = listOf(
            "30\n10",
            "30\n30",
            "20\n10",
            "10\n10"
        ),
        answerIndex = 0,
        explanation = "`nonlocal x` inside `inner` binds to `outer`'s local `x`, not to the global `x`. After `inner()` runs, `outer`'s `x` is `30`, so line A prints `30`. The global `x` is never touched; it remains `10`, so line B prints `10`."
    ),
    Problem(
        id = "match_hard_40",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {1: 'one', 2: 'two', 3: 'three'}",
        summary = "Pick the snippet that builds a dict by zipping two sequences.",
        prompt = "Which code prints `{1: 'one', 2: 'two', 3: 'three'}`?",
        code = "{1: 'one', 2: 'two', 3: 'three'}",
        options = listOf(
            "print(dict(zip([1, 2, 3], ['one', 'two', 'three'])))",
            "print(dict(zip(['one', 'two', 'three'], [1, 2, 3])))",
            "print({v: k for k, v in enumerate(['one', 'two', 'three'], 1)})",
            "print({k: v for k, v in zip(range(1, 4), ['one', 'two', 'four'])})"
        ),
        answerIndex = 0,
        explanation = "Option A zips the integer list as keys and the string list as values, producing `{1: 'one', 2: 'two', 3: 'three'}`. Option B swaps key and value order, giving `{'one': 1, 'two': 2, 'three': 3}`. Option C uses `enumerate` then swaps key and value in the comprehension, also producing reversed mapping. Option D uses `'four'` instead of `'three'`, so the third entry is wrong. Only option A produces the target output exactly."
    )
)
