package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 76. One senior-level problem per problem type.
// Correct answers are intentionally NOT the longest option to avoid a length-gives-it-away pattern.
val hardProblems76 = listOf(
    // FIND_BUG — correct answer is index 2 (shorter than index 0 and index 3)
    Problem(
        id = "bug_hard_77",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__slots__ blocks instance attributes",
        summary = "Adding __slots__ to a class prevents storing attributes not listed in __slots__.",
        prompt = "What is the bug in this code?",
        code = """
            class Point:
                __slots__ = ("x", "y")

                def __init__(self, x, y, label=None):
                    self.x = x
                    self.y = y
                    self.label = label
        """.trimIndent(),
        options = listOf(
            "`__slots__` requires every slot to have a type annotation; omitting the annotation causes Python to raise a `TypeError` during class creation because the slot descriptor cannot be initialised without type information",
            "Assigning `__slots__` as a tuple instead of a list is a `SyntaxError` in Python 3; `__slots__` must be declared as a `list` for the descriptor protocol to register the slot names correctly",
            "Setting `self.label` raises `AttributeError` at runtime because `label` is not listed in `__slots__`, and the class has no `__dict__` to store it",
            "Using a default argument of `None` for `label` in `__init__` while `__slots__` is active causes the slot descriptor to shadow the default-argument mechanism, so `label` is always `None` even when an explicit value is passed to the constructor"
        ),
        answerIndex = 2,
        explanation = "`__slots__` suppresses the per-instance `__dict__`. Any attribute not listed in `__slots__` cannot be stored on the instance. Here, `label` is not in `__slots__`, so `self.label = label` raises `AttributeError: 'Point' object has no attribute 'label'`. Fix: add `\"label\"` to `__slots__`."
    ),
    // OUTPUT — correct answer is index 0 (shortest option)
    Problem(
        id = "output_hard_77",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "classmethod inheritance — cls identity",
        summary = "Trace what cls refers to when a classmethod is called on a subclass.",
        prompt = "What does this code print?",
        code = """
            class Animal:
                @classmethod
                def species(cls):
                    return cls.__name__

            class Dog(Animal):
                pass

            print(Animal.species())
            print(Dog.species())
        """.trimIndent(),
        options = listOf(
            "Animal\nDog",
            "Animal\nAnimal",
            "Animal\nAnimal.Dog",
            "Animal\n<class '__main__.Dog'>"
        ),
        answerIndex = 0,
        explanation = "`@classmethod` receives the class it is called on as `cls`, not always the class where the method is defined. `Animal.species()` → `cls` is `Animal` → returns `'Animal'`. `Dog.species()` → `cls` is `Dog` → returns `'Dog'`. This is the primary difference between `classmethod` and `staticmethod`."
    ),
    // PURPOSE — correct answer is index 3 (not the longest; index 1 is longer)
    Problem(
        id = "purpose_hard_77",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "functools.partial",
        summary = "functools.partial creates a new callable with some arguments pre-filled.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from functools import partial

            def power(base, exponent):
                return base ** exponent

            square = partial(power, exponent=2)
            cube   = partial(power, exponent=3)

            print(square(5))
            print(cube(3))
        """.trimIndent(),
        options = listOf(
            "Memoize the results of `power` so that repeated calls with the same arguments skip the exponentiation and return a cached value, reducing redundant computation for frequently-used base/exponent combinations",
            "Dynamically generate a subclass of `power`'s enclosing module so that `square` and `cube` each have their own isolated namespace, preventing the `exponent` keyword argument from leaking into other calls to `power` in the same scope",
            "Decorate `power` with a descriptor that intercepts attribute access on `square` and `cube`, enabling them to be used as bound methods on arbitrary objects without modifying the original function signature",
            "Create specialised callables from `power` with `exponent` pre-bound, so `square(n)` and `cube(n)` each need only one argument"
        ),
        answerIndex = 3,
        explanation = "`functools.partial(func, **kwargs)` returns a new callable that, when invoked, calls `func` with the pre-supplied keyword arguments merged with any new ones. Here, `square = partial(power, exponent=2)` means calling `square(5)` is equivalent to `power(5, exponent=2)` → `25`. No caching or subclassing occurs."
    ),
    // FILL_BLANK — correct answer is index 1 (shorter than index 2 and index 3)
    Problem(
        id = "fill_hard_77",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "itertools.islice — lazy truncation",
        summary = "Lazily take the first N items from an infinite generator.",
        prompt = "Fill the blank so that only the first 5 Fibonacci numbers are consumed from the infinite generator.",
        code = """
            import itertools

            def fib():
                a, b = 0, 1
                while True:
                    yield a
                    a, b = b, a + b

            first_five = list(itertools.___(fib(), 5))
        """.trimIndent(),
        options = listOf(
            "takewhile(lambda x: x < 5, ...)",
            "islice",
            "compress(fib(), [1]*5)",
            "chain.from_iterable with a stop sentinel that raises StopIteration after 5 items"
        ),
        answerIndex = 1,
        explanation = "`itertools.islice(iterable, stop)` lazily consumes at most `stop` items from any iterable, including infinite generators, without materialising the rest. `takewhile` stops on a value condition, not a count. `compress` needs a selectors sequence of the right length but doesn't truncate an infinite source safely in a one-liner."
    ),
    // ORDER_STEPS — correct answer fixed at index 0 per convention
    Problem(
        id = "order_hard_76",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the merge step that combines two sorted arrays into one sorted array.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge(a, b):",
            "    result, i, j = [], 0, 0",
            "    while i < len(a) and j < len(b):",
            "        if a[i] <= b[j]:",
            "            result.append(a[i]); i += 1",
            "        else:",
            "            result.append(b[j]); j += 1",
            "    return result + a[i:] + b[j:]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "The function initialises an output list and two indices. The `while` loop advances whichever index points to the smaller element, appending it to `result`. Once one list is exhausted the loop ends, and the slice `a[i:]` or `b[j:]` (whichever is non-empty) is appended in one operation to add the remaining elements."
    ),
    // COMPLEXITY — correct answer is index 3 (not the longest; index 1 is longer)
    Problem(
        id = "complexity_hard_76",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Binary search on sorted array",
        summary = "Determine the time complexity of iterative binary search.",
        prompt = "What is the time complexity of `binary_search`?",
        code = """
            def binary_search(arr, target):
                lo, hi = 0, len(arr) - 1
                while lo <= hi:
                    mid = (lo + hi) // 2
                    if arr[mid] == target:
                        return mid
                    elif arr[mid] < target:
                        lo = mid + 1
                    else:
                        hi = mid - 1
                return -1
        """.trimIndent(),
        options = listOf(
            "O(n) — in the worst case the loop visits every element once before determining the target is absent",
            "O(n log n) — each iteration performs a comparison that takes O(log n) time against a sorted array, repeated up to n times in the worst case",
            "O(1) — the midpoint calculation always resolves in a fixed number of steps because integer division is constant-time",
            "O(log n)"
        ),
        answerIndex = 3,
        explanation = "Each iteration halves the search space. Starting from n elements, after k iterations at most n/2^k elements remain. The loop terminates when n/2^k < 1, i.e. k > log₂n. Therefore the worst-case number of iterations is O(log n), with O(1) work per iteration."
    ),
    // TRACE_VAR — correct answer is index 1 (shorter than index 2 and index 3)
    Problem(
        id = "trace_hard_76",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Nested list comprehension flattening",
        summary = "Trace the value of result after a nested list comprehension executes.",
        prompt = "What is the value of `result` after the last line?",
        code = """
            matrix = [[1, 2], [3, 4], [5, 6]]
            result = [x * 2 for row in matrix for x in row if x % 2 == 0]
        """.trimIndent(),
        options = listOf(
            "[2, 4, 6, 8, 10, 12]",
            "[4, 8, 12]",
            "[2, 6, 10]",
            "[[4, 8], [12]] — the outer loop produces one sub-list per row, preserving the original matrix structure with even elements doubled"
        ),
        answerIndex = 1,
        explanation = "The comprehension iterates every `row` then every `x` in that row, keeping only even `x` values (`x % 2 == 0`). Even elements in order are `2, 4, 6`. Each is doubled: `4, 8, 12`. The result is a flat list `[4, 8, 12]`."
    ),
    // MATCH_OUTPUT — correct answer is index 2 (not the longest; index 3 is longer)
    Problem(
        id = "match_hard_76",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: ('user', '@', 'example.com')",
        summary = "Identify which snippet produces a 3-tuple split on the first '@' sign.",
        prompt = "Which snippet prints `('user', '@', 'example.com')`?",
        code = "",
        options = listOf(
            "s = 'user@example.com'\nprint(tuple(s.split('@')))",
            "s = 'user@example.com'\nparts = s.split('@', 1)\nprint(tuple(parts))",
            "s = 'user@example.com'\nprint(s.partition('@'))",
            "s = 'user@example.com'\nparts = s.split('@')\nprint(tuple(parts[:3]))"
        ),
        answerIndex = 2,
        explanation = "`str.partition(sep)` always returns a 3-tuple `(before, sep, after)` — even if the separator is absent, it returns `(original, '', '')`. Here `'user@example.com'.partition('@')` yields `('user', '@', 'example.com')`. Option A gives `('user', 'example.com')` (2 items). Option B also gives a 2-item tuple. Option D splits on `'@'` and takes the first three elements, which is also `('user', 'example.com')` — still only 2 items since there is only one `'@'`."
    )
)
