package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 74. One senior-level problem per problem type.
// Correct answers are intentionally NOT the longest option to avoid a length-gives-it-away pattern.
val hardProblems74 = listOf(
    // FIND_BUG — correct answer is index 2 (shorter than index 3)
    Problem(
        id = "bug_hard_75",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Mutable default argument",
        summary = "A function accumulates results across calls because of a shared default list.",
        prompt = "What is the bug in this code?",
        code = """
            def append_item(item, result=[]):
                result.append(item)
                return result

            print(append_item(1))
            print(append_item(2))
        """.trimIndent(),
        options = listOf(
            "`append` is not a valid list method in Python 3 — use `result += [item]` instead",
            "The function must declare `result` as `global` before modifying it",
            "The default value `[]` is created once at function definition time, so all calls without an explicit `result` share the same list object",
            "Python does not allow mutable objects as default arguments; the interpreter raises a `TypeError` at function definition time, before any call is made"
        ),
        answerIndex = 2,
        explanation = "Default argument values are evaluated once when the `def` statement is executed, not on each call. The same list object is reused across all calls that omit `result`, so items accumulate: first call returns `[1]`, second returns `[1, 2]`. The fix is `result=None` with `if result is None: result = []` inside the body."
    ),
    // OUTPUT — correct answer is index 0 (shortest option)
    Problem(
        id = "output_hard_75",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "super() in diamond inheritance",
        summary = "Trace the MRO-driven super() call chain in a diamond hierarchy.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self):
                    print("A")

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
        explanation = "Python's MRO for D is [D, B, C, A]. Each `super().greet()` delegates to the next class in that list. Call chain: D → B → C → A. A prints 'A' first (deepest), then C prints 'C' on return, then B prints 'B', then D prints 'D'. Result: A, C, B, D."
    ),
    // PURPOSE — correct answer is index 1 (not the longest)
    Problem(
        id = "purpose_hard_75",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set_name__",
        summary = "A descriptor that auto-names its storage key from the owning class attribute name.",
        prompt = "What is the primary purpose of this code?",
        code = """
            class Validated:
                def __set_name__(self, owner, name):
                    self.attr = f"_{name}"

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.attr, None)

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError("int required")
                    setattr(obj, self.attr, value)

            class Record:
                score = Validated()
        """.trimIndent(),
        options = listOf(
            "Cache computed property values in a class-level dictionary keyed by instance id to avoid repeated recalculation",
            "Implement a reusable descriptor that enforces integer-only assignment and stores the value under a private attribute named after the descriptor",
            "Override `__getattr__` and `__setattr__` on the metaclass so that all attribute access on Record instances is intercepted at the class level",
            "Create a slot-based storage backend that rejects all non-integer attribute assignments across every class in the inheritance hierarchy by injecting a custom MRO entry at class creation time"
        ),
        answerIndex = 1,
        explanation = "`__set_name__` is called by the metaclass at class creation with the attribute name (`score`), letting the descriptor store values under `_score` without hard-coding the name. `__set__` enforces the int constraint; `__get__` retrieves it. This is a reusable, self-naming, type-validating data descriptor."
    ),
    // FILL_BLANK — correct answer is index 0 (shortest)
    Problem(
        id = "fill_hard_75",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "functools.lru_cache typed parameter",
        summary = "Cache a function but treat int and float arguments as distinct keys.",
        prompt = "Fill the blank so that `f(1)` and `f(1.0)` are cached separately.",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=128, ___=True)
            def f(x):
                return x * 2
        """.trimIndent(),
        options = listOf(
            "typed",
            "strict",
            "type_sensitive",
            "distinguish_types"
        ),
        answerIndex = 0,
        explanation = "`lru_cache` accepts a `typed` boolean (default `False`). When `True`, arguments of different types that compare equal — like `1` (int) and `1.0` (float) — are cached as distinct entries. The other options are not valid `lru_cache` parameters."
    ),
    // ORDER_STEPS — correct answer fixed at index 0 per convention
    Problem(
        id = "order_hard_74",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Kahn's topological sort",
        summary = "Arrange the core steps of Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import deque",
            "def topo_sort(graph, in_degree):",
            "    queue = deque(n for n in graph if in_degree[n] == 0)",
            "    order = []",
            "    while queue:",
            "        node = queue.popleft()",
            "        order.append(node)",
            "        for neighbour in graph[node]:",
            "            in_degree[neighbour] -= 1",
            "            if in_degree[neighbour] == 0:",
            "                queue.append(neighbour)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
        explanation = "Import first. The function initialises a deque with all zero-in-degree nodes and an empty result list. Each iteration pops a node, records it, then decrements each neighbour's in-degree — enqueuing any neighbour that reaches zero. The final list is the topological order (or shorter than the node count if a cycle exists)."
    ),
    // COMPLEXITY — correct answer is index 1 (not the longest)
    Problem(
        id = "complexity_hard_74",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Catastrophic backtracking regex",
        summary = "Estimate the worst-case matching time for a nested-quantifier regex against a non-matching string.",
        prompt = "What is the worst-case time complexity for matching this regex against `'a' * n` (no trailing 'b')?",
        code = """
            import re
            pattern = re.compile(r"(a+)+b")
            text = "a" * n   # n chars, no 'b'
            pattern.match(text)
        """.trimIndent(),
        options = listOf(
            "O(n log n) — the NFA engine partitions the input recursively like merge sort",
            "O(2^n) — each 'a' can be claimed by either the inner or outer group, producing exponential backtracking paths",
            "O(n²) — the engine tries each starting position and scans to the end of the string",
            "O(n) — Python's `re` module compiles patterns to a DFA that always runs in linear time, so grouping structure does not affect worst-case performance"
        ),
        answerIndex = 1,
        explanation = "The nested quantifier `(a+)+` lets n 'a's be partitioned between the inner `+` and the outer `+` in exponentially many ways. When the required `b` is absent the backtracking NFA exhausts every partition before failing — O(2^n). Python's `re` is a backtracking NFA, not a DFA, so it is vulnerable to catastrophic backtracking on such patterns."
    ),
    // TRACE_VAR — correct answer is index 2 (short, not the longest)
    Problem(
        id = "trace_hard_74",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Closure variable capture in loop",
        summary = "Trace the values printed by lambdas captured inside a list comprehension.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(3)]
            print(funcs[0](), funcs[1](), funcs[2]())
        """.trimIndent(),
        options = listOf(
            "0 1 2",
            "0 0 0",
            "2 2 2",
            "NameError because `i` falls out of scope after the comprehension finishes"
        ),
        answerIndex = 2,
        explanation = "Each lambda captures the variable `i` by reference, not by value. After the comprehension finishes, `i` holds its final value: 2. All three lambdas reference the same binding, so each returns 2. The fix is a default-argument capture: `lambda i=i: i`."
    ),
    // MATCH_OUTPUT — correct answer is index 2 (not the longest)
    Problem(
        id = "match_hard_74",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {0: 0, 1: 1, 2: 4}",
        summary = "Identify which snippet produces a dict mapping integers to their squares.",
        prompt = "Which snippet prints `{0: 0, 1: 1, 2: 4}`?",
        code = "",
        options = listOf(
            "print({x: x**2 for x in range(1, 4)})",
            "print(dict(zip(range(3), [x*x for x in range(1, 4)])))",
            "print({x: x*x for x in range(3)})",
            "print({k: v**2 for k, v in enumerate(range(1, 4))})"
        ),
        answerIndex = 2,
        explanation = "Option C iterates `range(3)` (0, 1, 2) and maps each `x` to `x*x`, giving `{0:0, 1:1, 2:4}`. Option A starts from 1 giving `{1:1, 2:4, 3:9}`. Option B zips `range(3)` (keys 0,1,2) with squares of `range(1,4)` (1,4,9), giving `{0:1, 1:4, 2:9}`. Option D enumerates `range(1,4)` so `v` is 1,2,3 and `v**2` is 1,4,9 with keys 0,1,2, giving `{0:1, 1:4, 2:9}`."
    )
)
