package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 71.
// One senior-level problem per problem type.
val hardProblems71 = listOf(
    Problem(
        id = "bug_hard_72",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "weakref callback on object death",
        summary = "Trace what a weak reference callback prints when the referent is collected.",
        prompt = "What does this code print?",
        code = """
            import weakref

            class Node:
                pass

            def on_death(ref):
                print("dead")

            n = Node()
            r = weakref.ref(n, on_death)
            n = None
            print(r())
        """.trimIndent(),
        options = listOf(
            "dead\nNone",
            "None\ndead",
            "dead\n<Node object>",
            "TypeError"
        ),
        answerIndex = 0,
        explanation = "Assigning `n = None` drops the last strong reference. CPython's reference counting collects the object immediately, which fires `on_death` and prints `'dead'`. After that, `r()` returns `None` because the referent is gone, so `print(r())` prints `None`."
    ),
    Problem(
        id = "output_hard_72",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ on class vs instance",
        summary = "A non-data descriptor behaves differently when accessed on the class versus an instance.",
        prompt = "What does this code print?",
        code = """
            class Desc:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return 42

            class MyClass:
                val = Desc()

            print(type(MyClass.val).__name__)
            print(MyClass().val)
        """.trimIndent(),
        options = listOf(
            "int\n42",
            "Desc\n42",
            "Desc\nDesc",
            "int\nDesc"
        ),
        answerIndex = 1,
        explanation = "When `MyClass.val` is accessed on the class (not an instance), `obj` is `None` inside `__get__`, so `self` (the descriptor instance) is returned. `type(MyClass.val).__name__` is therefore `'Desc'`. When accessed on an instance, `obj` is not `None`, so `42` is returned."
    ),
    Problem(
        id = "purpose_hard_72",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager",
        summary = "Turn a generator function into a reusable context manager.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def managed_resource(name):
                print(f"acquiring {name}")
                try:
                    yield name
                finally:
                    print(f"releasing {name}")

            with managed_resource("db") as r:
                print(f"using {r}")
        """.trimIndent(),
        options = listOf(
            "Retry the body of the `with` block if an exception is raised inside it",
            "Turn a generator function into a `with`-statement context manager without writing a class",
            "Catch and suppress any exception raised inside the `with` block",
            "Profile the time spent inside the `with` block and log it on exit"
        ),
        answerIndex = 1,
        explanation = "`@contextmanager` converts a generator function into a context manager. Code before `yield` runs on `__enter__`; code in `finally` after `yield` runs on `__exit__`. This avoids writing a full class with `__enter__` and `__exit__` methods."
    ),
    Problem(
        id = "fill_hard_72",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "heapq.nlargest",
        summary = "Return the k largest items from an iterable efficiently.",
        prompt = "Fill the blank so `top3` is `[9, 7, 6]`.",
        code = """
            import heapq

            data = [3, 1, 9, 7, 2, 6]
            top3 = heapq.___(3, data)
        """.trimIndent(),
        options = listOf(
            "nlargest",
            "max_k",
            "topk",
            "largest"
        ),
        answerIndex = 0,
        explanation = "`heapq.nlargest(k, iterable)` returns a list of the `k` largest elements in descending order. `heapq.max_k`, `heapq.topk`, and `heapq.largest` do not exist."
    ),
    Problem(
        id = "order_hard_71",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the in-place merge that produces a single sorted list.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sorted(a, b):",
            "    result = []",
            "    i = j = 0",
            "    while i < len(a) and j < len(b):",
            "        if a[i] <= b[j]:",
            "            result.append(a[i]); i += 1",
            "        else:",
            "            result.append(b[j]); j += 1",
            "    result.extend(a[i:])",
            "    result.extend(b[j:])",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Initialise two pointers at the start of each list. Each step appends the smaller head element and advances that pointer. After one list is exhausted, the remaining tail of the other is appended wholesale with `extend`."
    ),
    Problem(
        id = "complexity_hard_71",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "All permutations via backtracking",
        summary = "Backtracking that builds every permutation of the input list.",
        prompt = "What is the time complexity (n = len(nums))?",
        code = """
            def permutations(nums):
                result = []
                def bt(path, remaining):
                    if not remaining:
                        result.append(list(path))
                        return
                    for i, v in enumerate(remaining):
                        bt(path + [v], remaining[:i] + remaining[i+1:])
                bt([], nums)
                return result
        """.trimIndent(),
        options = listOf(
            "O(n²)",
            "O(n * 2^n)",
            "O(n! * n)",
            "O(2^n)"
        ),
        answerIndex = 2,
        explanation = "There are n! permutations. Each leaf-level call copies a path of length n into `result`, costing O(n). Total work is O(n! * n). O(2^n) applies to subsets, not permutations."
    ),
    Problem(
        id = "trace_hard_71",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "__slots__ and instance dict",
        summary = "Trace whether an attribute assignment succeeds on a slotted class.",
        prompt = "What does this code print?",
        code = """
            class Point:
                __slots__ = ('x', 'y')

                def __init__(self, x, y):
                    self.x = x
                    self.y = y

            p = Point(1, 2)
            try:
                p.z = 3
            except AttributeError:
                print("no z")
            print(p.x)
        """.trimIndent(),
        options = listOf(
            "no z\n1",
            "1\nno z",
            "no z\nAttributeError",
            "1"
        ),
        answerIndex = 0,
        explanation = "`__slots__` removes the per-instance `__dict__`, so assigning any attribute not in `__slots__` raises `AttributeError`. The `try/except` catches it and prints 'no z'. `p.x` was set in `__init__` (which is in slots) and prints `1`."
    ),
    Problem(
        id = "match_hard_71",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 4, 9]",
        summary = "Identify which snippet produces a list of squared values.",
        prompt = "Which snippet prints `[1, 4, 9]`?",
        code = "[1, 4, 9]",
        options = listOf(
            "print(list(map(lambda x: x**2, range(1, 4))))",
            "print([x*2 for x in range(1, 4)])",
            "print(list(map(lambda x: x+x, [1, 2, 3])))",
            "print([x**2 for x in range(4)])"
        ),
        answerIndex = 0,
        explanation = "Option A: `map(lambda x: x**2, range(1, 4))` squares 1, 2, 3 → `[1, 4, 9]`. Option B: `x*2` doubles each value → `[2, 4, 6]`. Option C: `x+x` is also doubling → `[2, 4, 6]`. Option D: `range(4)` starts at 0 → `[0, 1, 4, 9]`."
    )
)
