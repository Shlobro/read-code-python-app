package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 27.
// One senior-level problem per problem type.
val hardProblems27 = listOf(
    Problem(
        id = "bug_hard_28",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in loop",
        summary = "A list of lambdas all return the same value.",
        prompt = "Why do all the lambdas print 4 instead of 0, 1, 2, 3, 4?",
        code = """
            funcs = [lambda: i for i in range(5)]
            for f in funcs:
                print(f())
        """.trimIndent(),
        options = listOf(
            "All lambdas capture `i` by reference; by the time they are called, `i` is 4",
            "List comprehensions discard loop variables after the last iteration",
            "`lambda` captures a copy of `i` at definition time but reuses the last copy",
            "The lambdas share one code object that stores the final value of `i`"
        ),
        answerIndex = 0,
        explanation = "Python closures capture the *variable*, not its value. After the comprehension finishes, `i` is 4. Every lambda references the same `i` cell, so they all return 4. Fix: `lambda i=i: i` captures the current value as a default argument."
    ),
    Problem(
        id = "output_hard_28",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__slots__ and __dict__ coexistence",
        summary = "A class mixes __slots__ with a parent that has __dict__.",
        prompt = "What does this code print?",
        code = """
            class Base:
                pass

            class Child(Base):
                __slots__ = ("x",)

            c = Child()
            c.x = 1
            c.y = 2
            print(c.x, c.y)
        """.trimIndent(),
        options = listOf(
            "1 2",
            "AttributeError: 'Child' object has no attribute 'y'",
            "1 None",
            "AttributeError: 'Child' object has no attribute 'x'"
        ),
        answerIndex = 0,
        explanation = "`Child` declares `__slots__`, which prevents a per-instance `__dict__` *for Child-defined attributes*. However, `Base` does not declare `__slots__`, so it still provides a `__dict__`. `Child` instances inherit that `__dict__` from `Base`, meaning arbitrary attributes like `y` can still be set. Both `c.x` (via slot) and `c.y` (via inherited `__dict__`) are accessible."
    ),
    Problem(
        id = "purpose_hard_28",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Double-checked singleton",
        summary = "A metaclass enforces a single instance per class.",
        prompt = "What is the primary design intent of this metaclass?",
        code = """
            import threading

            class SingletonMeta(type):
                _instances = {}
                _lock = threading.Lock()

                def __call__(cls, *args, **kwargs):
                    if cls not in cls._instances:
                        with cls._lock:
                            if cls not in cls._instances:
                                cls._instances[cls] = super().__call__(*args, **kwargs)
                    return cls._instances[cls]
        """.trimIndent(),
        options = listOf(
            "Thread-safe singleton: at most one instance per class is ever created, even under concurrent access",
            "Object pool: instances are reused from a fixed-size pool to limit memory",
            "Flyweight: multiple classes share a single shared-state instance to reduce duplication",
            "Proxy: every call to the class constructor is forwarded to a remote object"
        ),
        answerIndex = 0,
        explanation = "The double-checked locking pattern first checks without acquiring the lock (fast path), then re-checks inside the lock (safe path). This ensures at most one instance per class is created while avoiding the overhead of locking on every `__call__`."
    ),
    Problem(
        id = "fill_hard_28",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.reduce identity",
        summary = "Choosing the correct initial value for a reduce over an empty sequence.",
        prompt = "Which value fills the blank so `safe_product` returns 1 for an empty list without raising an error?",
        code = """
            from functools import reduce
            import operator

            def safe_product(nums):
                return reduce(operator.mul, nums, ___)
        """.trimIndent(),
        options = listOf("1", "0", "None", "[]"),
        answerIndex = 0,
        explanation = "`reduce` raises `TypeError` on an empty sequence unless an initializer is supplied. For multiplication, the identity element is `1` (multiplying by 1 leaves any product unchanged). Using `0` would make every product 0; `None` and `[]` would cause type errors on the first multiplication."
    ),
    Problem(
        id = "order_hard_27",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange a correct two-pointer merge of two sorted lists.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sorted(a, b):",
            "    result = []",
            "    i = j = 0",
            "    while i < len(a) and j < len(b):",
            "        if a[i] <= b[j]:",
            "            result.append(a[i])",
            "            i += 1",
            "        else:",
            "            result.append(b[j])",
            "            j += 1",
            "    result.extend(a[i:])",
            "    result.extend(b[j:])",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
        explanation = "Define the function and output list, initialise two pointers, loop while both lists have remaining elements, append the smaller element and advance that pointer, then drain whichever list has leftover elements with `extend`."
    ),
    Problem(
        id = "complexity_hard_27",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive Fibonacci time complexity",
        summary = "Count how many calls the naive recursive Fibonacci makes.",
        prompt = "What is the time complexity of this naive recursive `fib`?",
        code = """
            def fib(n):
                if n <= 1:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf("O(2^n)", "O(n)", "O(n log n)", "O(n^2)"),
        answerIndex = 0,
        explanation = "Each call spawns two recursive calls, creating a binary call tree of depth n. The total number of nodes is approximately 2^n, giving O(2^n) time. Memoization or iteration reduces this to O(n)."
    ),
    Problem(
        id = "trace_hard_27",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "nonlocal rebind",
        summary = "A nested function rebinds a variable from the enclosing scope.",
        prompt = "What is the value of `counter` after calling `inc()` three times?",
        code = """
            def make_counter():
                counter = 0
                def inc():
                    nonlocal counter
                    counter += 1
                return inc, lambda: counter

            inc, get = make_counter()
            inc()
            inc()
            inc()
            counter = get()
        """.trimIndent(),
        options = listOf("3", "0", "1", "AttributeError"),
        answerIndex = 0,
        explanation = "`nonlocal counter` makes `inc` rebind the `counter` variable in `make_counter`'s frame. Each call increments the shared cell. After three calls, `get()` reads the same cell and returns 3."
    ),
    Problem(
        id = "match_hard_27",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n[1, 4, 9, 16]",
        summary = "Pick the snippet that lazily maps squares over a range and materialises the result.",
        prompt = "Which code produces exactly `[1, 4, 9, 16]`?",
        code = "[1, 4, 9, 16]",
        options = listOf(
            "print(list(map(lambda x: x**2, range(1, 5))))",
            "print([x**2 for x in range(4)])",
            "print(list(map(lambda x: x*2, range(1, 5))))",
            "print([x**2 for x in range(1, 4)])"
        ),
        answerIndex = 0,
        explanation = "`map(lambda x: x**2, range(1, 5))` lazily squares 1, 2, 3, 4 and `list()` materialises the result as [1, 4, 9, 16]. Option B squares 0–3, giving [0, 1, 4, 9]. Option C doubles instead of squaring. Option D only squares 1–3, giving [1, 4, 9]."
    )
)
