package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 67.
// One senior-level problem per problem type.
val hardProblems67 = listOf(
    Problem(
        id = "bug_hard_68",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__slots__ blocks undeclared attribute",
        summary = "Assigning an attribute not in __slots__ raises AttributeError.",
        prompt = "What is the bug in this code?",
        code = """
            class Point:
                __slots__ = ('x', 'y')

                def __init__(self, x, y):
                    self.x = x
                    self.y = y
                    self.label = 'origin'
        """.trimIndent(),
        options = listOf(
            "`label` is not in `__slots__`, so assigning it raises `AttributeError`",
            "Slot names must be given as a list, not a tuple",
            "`__init__` is incompatible with `__slots__` on plain classes",
            "`__slots__` prevents inheritance, so the class cannot be instantiated"
        ),
        answerIndex = 0,
        explanation = "With `__slots__`, instances have no `__dict__` and only the declared slot names are valid. Assigning `self.label` raises `AttributeError` because `'label'` is not listed in `__slots__`."
    ),
    Problem(
        id = "output_hard_68",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Property setter bypassed via __dict__",
        summary = "Writing directly to __dict__ skips the property setter.",
        prompt = "What does this code print?",
        code = """
            class Temp:
                def __init__(self):
                    self._v = 0

                @property
                def v(self):
                    return self._v

                @v.setter
                def v(self, val):
                    self._v = max(0, val)

            t = Temp()
            t.__dict__['_v'] = -5
            print(t.v)
        """.trimIndent(),
        options = listOf(
            "-5",
            "0",
            "AttributeError",
            "5"
        ),
        answerIndex = 0,
        explanation = "Writing directly to `t.__dict__['_v']` bypasses the property setter entirely. The getter simply returns `self._v`, which is now `-5`, so `-5` is printed."
    ),
    Problem(
        id = "purpose_hard_68",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.suppress",
        summary = "A context manager that silences a named exception type.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from contextlib import suppress

            data = {}

            with suppress(KeyError):
                value = data['missing']
                print(value)

            print("done")
        """.trimIndent(),
        options = listOf(
            "Silently ignore `KeyError` and continue after the block",
            "Retry the block until the key exists in `data`",
            "Log the `KeyError` to stderr, then continue",
            "Re-raise `KeyError` as a `ValueError` with a cleaner message"
        ),
        answerIndex = 0,
        explanation = "`contextlib.suppress` swallows the listed exception types. When `KeyError` is raised, the rest of the `with` block is skipped and execution resumes normally — `\"done\"` is always printed."
    ),
    Problem(
        id = "fill_hard_68",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "itertools.chain for flat iteration",
        summary = "Combine multiple iterables into one flat sequence.",
        prompt = "Fill the blank so `result` is [1, 2, 3, 4, 5, 6].",
        code = """
            from itertools import ___

            a = [1, 2, 3]
            b = [4, 5, 6]
            result = list(___(a, b))
        """.trimIndent(),
        options = listOf(
            "chain",
            "product",
            "zip",
            "flatten"
        ),
        answerIndex = 0,
        explanation = "`itertools.chain(a, b)` yields elements from `a` then `b` in sequence, producing a flat iterator. `product` gives cartesian pairs, `zip` pairs elements by index, and `flatten` does not exist in itertools."
    ),
    Problem(
        id = "order_hard_67",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort — Kahn's algorithm",
        summary = "Arrange the steps of the BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph, in_degree):",
            "    queue = [n for n in graph if in_degree[n] == 0]",
            "    order = []",
            "    while queue:",
            "        node = queue.pop(0)",
            "        order.append(node)",
            "        for nb in graph[node]:",
            "            in_degree[nb] -= 1",
            "            if in_degree[nb] == 0:",
            "                queue.append(nb)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Seed the queue with zero-in-degree nodes, then dequeue a node, record it, decrement each neighbour's in-degree, enqueue any neighbour that reaches zero, and return the accumulated order."
    ),
    Problem(
        id = "complexity_hard_67",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sieve of Eratosthenes",
        summary = "Classic prime sieve with early composite elimination.",
        prompt = "What is the time complexity of this algorithm?",
        code = """
            def sieve(n):
                is_prime = [True] * (n + 1)
                is_prime[0] = is_prime[1] = False
                for i in range(2, int(n**0.5) + 1):
                    if is_prime[i]:
                        for j in range(i*i, n + 1, i):
                            is_prime[j] = False
                return [i for i in range(2, n+1) if is_prime[i]]
        """.trimIndent(),
        options = listOf(
            "O(n log log n)",
            "O(n log n)",
            "O(n√n)",
            "O(n²)"
        ),
        answerIndex = 0,
        explanation = "The sieve marks each composite at most once per prime factor. Total work across all inner loops sums to n * Σ(1/p) for primes p ≤ n, which by Mertens' theorem grows as O(n log log n)."
    ),
    Problem(
        id = "trace_hard_67",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Coroutine send() and yield value",
        summary = "Trace what an accumulator coroutine yields when driven with send().",
        prompt = "What does this code print?",
        code = """
            def accumulator():
                total = 0
                while True:
                    val = yield total
                    if val is None:
                        break
                    total += val

            gen = accumulator()
            next(gen)
            print(gen.send(10))
            print(gen.send(5))
        """.trimIndent(),
        options = listOf(
            "10\n15",
            "0\n10",
            "10\n10",
            "0\n15"
        ),
        answerIndex = 0,
        explanation = "`next(gen)` primes the coroutine to the first `yield`, yielding `0` (discarded). `send(10)` resumes, sets `val=10`, adds to `total` (→10), loops back, yields `10`. `send(5)` sets `val=5`, adds to `total` (→15), yields `15`. Output: `10` then `15`."
    ),
    Problem(
        id = "match_hard_67",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: lru_cache miss count is 2",
        summary = "Identify which call pattern produces exactly 2 cache misses.",
        prompt = "Which snippet prints `2`?",
        code = "2",
        options = listOf(
            "from functools import lru_cache\n@lru_cache(maxsize=4)\ndef f(n): return n*2\nf(1); f(2); f(1); f(2)\nprint(f.cache_info().misses)",
            "from functools import lru_cache\n@lru_cache(maxsize=1)\ndef f(n): return n*2\nf(1); f(2); f(1)\nprint(f.cache_info().misses)",
            "from functools import lru_cache\n@lru_cache(maxsize=None)\ndef f(n): return n*2\nfor _ in range(5): f(1)\nprint(f.cache_info().misses)",
            "from functools import lru_cache\n@lru_cache(maxsize=2)\ndef f(n): return n*2\nf(1); f(2); f(3)\nprint(f.cache_info().misses)"
        ),
        answerIndex = 0,
        explanation = "Option A: `f(1)` misses, `f(2)` misses, then both hit → 2 misses total. Option B: maxsize=1 evicts 1 when 2 is called, so the third call `f(1)` misses again → 3 misses. Option C: all calls are `f(1)`, only 1 miss. Option D: three distinct keys, all miss → 3 misses."
    )
)
