package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 54.
// One senior-level problem per problem type.
val hardProblems54 = listOf(
    Problem(
        id = "bug_hard_55",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Subclass registration with `__init_subclass__`",
        summary = "A class-level hook automatically registers every subclass at definition time.",
        prompt = "What does this code print?",
        code = """
            class Registry:
                _classes = []

                def __init_subclass__(cls, **kwargs):
                    super().__init_subclass__(**kwargs)
                    Registry._classes.append(cls)

            class Alpha(Registry): pass
            class Beta(Registry): pass

            print(len(Registry._classes))
        """.trimIndent(),
        options = listOf(
            "0",
            "1",
            "2",
            "TypeError"
        ),
        answerIndex = 2,
        explanation = "`__init_subclass__` is called once for each direct subclass at class-creation time. Both `Alpha` and `Beta` trigger it, so `_classes` contains both and `len` is `2`."
    ),
    Problem(
        id = "output_hard_55",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Cell variable in a closure loop",
        summary = "A list of lambdas all capture the same loop variable through a shared cell.",
        prompt = "What does this code print?",
        code = """
            fns = [lambda: i for i in range(3)]
            print([f() for f in fns])
        """.trimIndent(),
        options = listOf(
            "[0, 1, 2]",
            "[2, 2, 2]",
            "[0, 0, 0]",
            "NameError: name 'i' is not defined"
        ),
        answerIndex = 1,
        explanation = "Every lambda closes over the same cell variable `i`. By the time the lambdas are called, the loop has finished and `i` is `2`, so all three calls return `2`."
    ),
    Problem(
        id = "purpose_hard_55",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Sentinel-based `__eq__`",
        summary = "A class uses an object-identity sentinel to distinguish 'no value provided' from None.",
        prompt = "What does this class do overall?",
        code = """
            _MISSING = object()

            class Field:
                def __init__(self, default=_MISSING):
                    self.default = default

                def has_default(self):
                    return self.default is not _MISSING
        """.trimIndent(),
        options = listOf(
            "It distinguishes 'no default given' from an explicit None default",
            "It rejects None and raises ValueError when no default is supplied",
            "It caches the default value to avoid repeated sentinel comparisons",
            "It enforces that defaults are hashable before storing them"
        ),
        answerIndex = 0,
        explanation = "Using a private sentinel object means `Field()` and `Field(None)` are distinguishable: the first has no default (`has_default()` returns False), while the second has `None` as an explicit default."
    ),
    Problem(
        id = "fill_hard_55",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Suppress a specific exception",
        summary = "A known benign error should be swallowed without a try/except block.",
        prompt = "Which choice fills the blank so `KeyError` is silently ignored?",
        code = """
            from contextlib import ___

            d = {"x": 1}
            with suppress(KeyError):
                print(d["missing"])
            print("done")
        """.trimIndent(),
        options = listOf(
            "ignore",
            "swallow",
            "suppress",
            "nullcontext"
        ),
        answerIndex = 2,
        explanation = "`contextlib.suppress` is a context manager that swallows any exception whose type matches the argument, letting code continue after the `with` block."
    ),
    Problem(
        id = "order_hard_54",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the core steps of Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "queue = deque(n for n in graph if in_degree[n] == 0)",
            "while queue:",
            "    node = queue.popleft()",
            "    order.append(node)",
            "    for nbr in graph[node]:",
            "        in_degree[nbr] -= 1",
            "        if in_degree[nbr] == 0:",
            "            queue.append(nbr)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "Seed the queue with zero-in-degree nodes, then repeatedly dequeue a node, append it to the result, and decrement each neighbor's in-degree, enqueuing any neighbor that reaches zero."
    ),
    Problem(
        id = "complexity_hard_54",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Union-Find with path compression",
        summary = "A union-find structure uses path compression but not union-by-rank.",
        prompt = "What is the amortized time complexity per operation with path compression alone?",
        code = """
            def find(parent, x):
                if parent[x] != x:
                    parent[x] = find(parent, parent[x])
                return parent[x]
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(1)",
            "O(n)",
            "O(α(n))"
        ),
        answerIndex = 0,
        explanation = "Path compression alone (without union-by-rank or union-by-size) gives O(log n) amortized per operation. The near-constant O(α(n)) bound requires both path compression and union-by-rank together."
    ),
    Problem(
        id = "trace_hard_54",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable shadowed by instance assignment",
        summary = "Assigning to an attribute on an instance creates an instance variable that shadows the class-level one.",
        prompt = "What is `Counter.total` after this code runs?",
        code = """
            class Counter:
                total = 0

                def increment(self):
                    self.total += 1

            a = Counter()
            b = Counter()
            a.increment()
            b.increment()
            b.increment()
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "0",
            "1"
        ),
        answerIndex = 2,
        explanation = "`self.total += 1` reads the class variable (0) and writes the result to a new *instance* variable, leaving `Counter.total` untouched at 0. The class variable is never modified."
    ),
    Problem(
        id = "match_hard_54",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: deque([3, 1, 2], maxlen=3)",
        summary = "Pick the snippet that produces a fixed-length deque with a specific rotation result.",
        prompt = "Which code produces this output?",
        code = "deque([3, 1, 2], maxlen=3)",
        options = listOf(
            "from collections import deque; d = deque([1,2,3], maxlen=3); d.rotate(1); print(d)",
            "from collections import deque; d = deque([1,2,3], maxlen=3); d.rotate(-1); print(d)",
            "from collections import deque; d = deque([1,2,3], maxlen=3); d.appendleft(0); print(d)",
            "from collections import deque; d = deque([1,2,3], maxlen=3); d.append(0); print(d)"
        ),
        answerIndex = 0,
        explanation = "`rotate(1)` shifts all elements one step to the right: the last element `3` wraps to the front, giving `deque([3, 1, 2], maxlen=3)`. `rotate(-1)` shifts left, `appendleft(0)` would drop `3` from the right and add `0` at the front giving `[0, 1, 2]`, and `append(0)` drops `1` from the left giving `[2, 3, 0]`."
    )
)
