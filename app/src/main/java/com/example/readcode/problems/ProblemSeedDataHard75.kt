package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 75. One senior-level problem per problem type.
// Correct answers are intentionally NOT the longest option to avoid a length-gives-it-away pattern.
val hardProblems75 = listOf(
    // FIND_BUG — correct answer is index 1 (shorter than index 0 and index 3)
    Problem(
        id = "bug_hard_76",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in class body",
        summary = "Class-level lambdas that reference a loop variable all end up with the same value.",
        prompt = "What is the bug in this code?",
        code = """
            class Dispatcher:
                handlers = {
                    name: lambda self: name
                    for name in ["read", "write", "delete"]
                }
        """.trimIndent(),
        options = listOf(
            "Dictionary comprehensions inside a class body cannot reference `self`, so each lambda will raise a `NameError` at call time because `self` is not in scope during class creation",
            "All three lambdas close over the same `name` variable; after the comprehension finishes, `name` is `\"delete\"`, so every handler returns `\"delete\"` regardless of which key is called",
            "A dictionary comprehension cannot be used directly as a class attribute; Python raises a `SyntaxError` at class definition time",
            "The lambda signature `lambda self:` shadows the instance but does not bind it to the descriptor protocol, so calling `instance.handlers[\"read\"](instance)` silently returns `None` instead of the key string"
        ),
        answerIndex = 1,
        explanation = "Like loop-variable capture in list comprehensions, the lambda bodies reference `name` by name, not by value. After the comprehension finishes, `name` is bound to `\"delete\"` (the last item). All three lambdas return `\"delete\"`. Fix: use a default argument — `lambda self, n=name: n`."
    ),
    // OUTPUT — correct answer is index 3 (short; indices 0 and 2 are longer)
    Problem(
        id = "output_hard_76",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook",
        summary = "Trace what is printed when a subclass is defined using __init_subclass__.",
        prompt = "What does this code print?",
        code = """
            class Plugin:
                def __init_subclass__(cls, tag=None, **kwargs):
                    super().__init_subclass__(**kwargs)
                    if tag:
                        print(tag)

            class Alpha(Plugin, tag="alpha"):
                pass

            class Beta(Plugin):
                pass

            class Gamma(Plugin, tag="gamma"):
                pass
        """.trimIndent(),
        options = listOf(
            "alpha\nbeta\ngamma",
            "Plugin\nalpha\ngamma",
            "alpha\nNone\ngamma",
            "alpha\ngamma"
        ),
        answerIndex = 3,
        explanation = "`__init_subclass__` is called once for each subclass at class-creation time. `Alpha` passes `tag=\"alpha\"` → prints `alpha`. `Beta` omits `tag`, so `tag` defaults to `None`, and the `if tag:` guard skips the print. `Gamma` passes `tag=\"gamma\"` → prints `gamma`. Output: `alpha` then `gamma`."
    ),
    // PURPOSE — correct answer is index 0 (shortest option)
    Problem(
        id = "purpose_hard_76",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "weakref finalizer",
        summary = "A weakref.finalize callback fires when an object is about to be garbage-collected.",
        prompt = "What is the primary purpose of this code?",
        code = """
            import weakref

            class Resource:
                def __init__(self, name):
                    self.name = name

            def cleanup(name):
                print(f"releasing {name}")

            r = Resource("db_conn")
            weakref.finalize(r, cleanup, r.name)
            del r
        """.trimIndent(),
        options = listOf(
            "Register a cleanup callback that runs when the object is garbage-collected, without preventing collection",
            "Create a strong reference to `r` inside the finalizer so the object is kept alive until `cleanup` has been called and returns successfully",
            "Wrap `cleanup` in a context manager so that any exception raised inside it is silently swallowed and does not propagate to the caller that triggered garbage collection",
            "Attach a destructor to the `Resource` class that overrides `__del__` at the instance level, ensuring `cleanup` fires even if `__del__` was already defined on the class and would otherwise run first"
        ),
        answerIndex = 0,
        explanation = "`weakref.finalize` registers a callback tied to the object via a weak reference. When `r` is deleted and GC collects it, `cleanup(r.name)` is called. The weak reference does not keep the object alive — that is the key difference from storing a regular reference in `__del__`."
    ),
    // FILL_BLANK — correct answer is index 2 (not the longest)
    Problem(
        id = "fill_hard_76",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "contextlib.suppress",
        summary = "Silence a specific exception without a try/except block.",
        prompt = "Fill the blank so that a missing key is silently ignored.",
        code = """
            from contextlib import ___

            data = {"a": 1}
            with ___(KeyError):
                value = data["missing"]
        """.trimIndent(),
        options = listOf(
            "ignore",
            "catch",
            "suppress",
            "silence_exceptions"
        ),
        answerIndex = 2,
        explanation = "`contextlib.suppress(*exceptions)` is a context manager that silently swallows any of the listed exception types raised inside the `with` block. It is the idiomatic, concise alternative to an empty `except` clause."
    ),
    // ORDER_STEPS — correct answer fixed at index 0 per convention
    Problem(
        id = "order_hard_75",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Floyd-Warshall all-pairs shortest paths",
        summary = "Arrange the core steps of the Floyd-Warshall algorithm.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def floyd_warshall(n, dist):",
            "    for k in range(n):",
            "        for i in range(n):",
            "            for j in range(n):",
            "                if dist[i][k] + dist[k][j] < dist[i][j]:",
            "                    dist[i][j] = dist[i][k] + dist[k][j]",
            "    return dist"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Floyd-Warshall iterates over every intermediate node `k` in the outermost loop, then checks every pair `(i, j)` to see if routing through `k` gives a shorter path. The innermost update applies the relaxation. The function returns the fully-relaxed distance matrix."
    ),
    // COMPLEXITY — correct answer is index 0 (shorter than index 1 and index 3)
    Problem(
        id = "complexity_hard_75",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive Fibonacci with memoization",
        summary = "Determine the time complexity of memoized Fibonacci.",
        prompt = "What is the time complexity of `fib(n)` with the `@lru_cache` decorator?",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=None)
            def fib(n):
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n log n) — the cache halves repeated work, adding a logarithmic factor for cache lookups in the hash map",
            "O(2^n) — the recursion tree still branches twice at each node regardless of the cache",
            "O(n²) — each unique subproblem triggers a linear scan of the cache before the result is found"
        ),
        answerIndex = 0,
        explanation = "With memoization, each value `fib(0)` through `fib(n)` is computed exactly once. Each computation does O(1) work (a cache lookup plus one addition). The cache is a hash map, so lookups are O(1) amortised. Total work is O(n)."
    ),
    // TRACE_VAR — correct answer is index 2 (not the longest)
    Problem(
        id = "trace_hard_75",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() protocol",
        summary = "Trace the value of x after send() resumes the generator.",
        prompt = "What is the value of `result` after the last line executes?",
        code = """
            def counter():
                x = 0
                while True:
                    increment = yield x
                    if increment is not None:
                        x += increment

            gen = counter()
            next(gen)       # prime
            gen.send(10)    # x becomes 10, yields 10
            result = gen.send(5)
        """.trimIndent(),
        options = listOf(
            "5",
            "10",
            "15",
            "None, because send() does not return the yielded value — it only resumes the generator"
        ),
        answerIndex = 2,
        explanation = "`next(gen)` primes the generator; `x=0`, yields `0`. `gen.send(10)`: `increment=10`, `x` becomes `10`, yields `10`. `gen.send(5)`: `increment=5`, `x` becomes `15`, yields `15`. `send()` returns the value yielded by the `yield` expression, so `result = 15`."
    ),
    // MATCH_OUTPUT — correct answer is index 1 (not the longest)
    Problem(
        id = "match_hard_75",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: deque([3, 4, 5])",
        summary = "Identify which snippet produces a bounded deque containing only the last three items.",
        prompt = "Which snippet prints `deque([3, 4, 5])`?",
        code = "",
        options = listOf(
            "from collections import deque\nd = deque([1,2,3,4,5])\nprint(d)",
            "from collections import deque\nd = deque(maxlen=3)\nfor x in [1,2,3,4,5]: d.append(x)\nprint(d)",
            "from collections import deque\nd = deque([1,2,3,4,5], maxlen=3)\nd.clear()\nd.extend([3,4,5])\nprint(d)",
            "from collections import deque\nd = deque([1,2,3,4,5])\nwhile len(d) > 3: d.popleft()\nprint(d)"
        ),
        answerIndex = 3,
        explanation = "Option D pops from the left until only three elements remain, producing `deque([3, 4, 5])` with no `maxlen` in the repr — exactly matching the prompt. Option A prints all five items. Option B creates a bounded deque whose repr is `deque([3, 4, 5], maxlen=3)`, not `deque([3, 4, 5])`. Option C also uses `maxlen=3` so its repr includes `maxlen=3`."
    )
)
