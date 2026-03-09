package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 19.
// One senior-level problem per problem type.
val hardProblems19 = listOf(
    Problem(
        id = "bug_hard_20",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Hash key drift after mutation",
        summary = "An object used as a dictionary key changes the state that defines its hash and equality.",
        prompt = "What is the real bug in this code?",
        code = """
            class CacheKey:
                def __init__(self, name):
                    self.name = name

                def __hash__(self):
                    return hash(self.name)

                def __eq__(self, other):
                    return isinstance(other, CacheKey) and self.name == other.name

            cache = {}
            key = CacheKey("alpha")
            cache[key] = "ready"
            key.name = "beta"

            print(cache[key])
        """.trimIndent(),
        options = listOf(
            "The key's hash can change after mutation, so looking it up in the dictionary is unsafe",
            "Objects with a custom `__eq__` automatically become immutable after insertion into a dictionary",
            "Assigning a new string to `name` copies the dictionary entry to a new bucket automatically",
            "The dictionary stores only weak references, so `key` disappears after mutation"
        ),
        answerIndex = 0,
        explanation = "Dictionary keys must keep a stable hash and equality relationship while stored in the table. Mutating `name` changes the result of `__hash__` and `__eq__`, so the key can no longer be found reliably."
    ),
    Problem(
        id = "output_hard_20",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Generator `return` value",
        summary = "A `for` loop consumes yielded values but hides the generator's final return payload.",
        prompt = "What does this code print?",
        code = """
            def stream():
                yield "A"
                yield "B"
                return "done"

            gen = stream()
            for item in gen:
                print(item)

            try:
                next(gen)
            except StopIteration as exc:
                print(exc.value)
        """.trimIndent(),
        options = listOf(
            "A\nB\nNone",
            "A\nB\ndone",
            "A\nB\nStopIteration",
            "A\nB\nA"
        ),
        answerIndex = 0,
        explanation = "The `for` loop already exhausted the generator and consumed its terminating `StopIteration`. A later `next(gen)` raises a fresh `StopIteration` whose `value` is `None`."
    ),
    Problem(
        id = "purpose_hard_20",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Bounded in-flight concurrency",
        summary = "A semaphore gates task execution while still scheduling all coroutines.",
        prompt = "What does this function do overall?",
        code = """
            import asyncio

            async def gather_limited(limit, coroutines):
                semaphore = asyncio.Semaphore(limit)

                async def run(coro):
                    async with semaphore:
                        return await coro

                return await asyncio.gather(*(run(coro) for coro in coroutines))
        """.trimIndent(),
        options = listOf(
            "It runs all coroutines strictly one at a time in submission order",
            "It limits how many coroutines can be actively awaited at once, then gathers all results",
            "It retries failed coroutines until the semaphore count reaches zero",
            "It converts blocking functions into non-blocking coroutines"
        ),
        answerIndex = 1,
        explanation = "Each wrapper acquires the semaphore before awaiting its coroutine, so at most `limit` coroutines are in their active section concurrently while `gather` still collects every result."
    ),
    Problem(
        id = "fill_hard_20",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Sentinel for optional arguments",
        summary = "The function must distinguish 'argument omitted' from an explicit `None`.",
        prompt = "Which choice fills both blanks correctly?",
        code = """
            _MISSING = object()

            def read_timeout(value=___):
                if value is ___:
                    return 30
                return value
        """.trimIndent(),
        options = listOf("_MISSING", "None", "False", "Ellipsis"),
        answerIndex = 0,
        explanation = "A unique sentinel object lets the function detect omission separately from an explicit `None`, `False`, or other valid argument values."
    ),
    Problem(
        id = "order_hard_19",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Context manager that times a block",
        summary = "Arrange the lines for a generator-based context manager that reports elapsed time.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from contextlib import contextmanager",
            "import time",
            "@contextmanager",
            "def timed(label):",
            "    start = time.perf_counter()",
            "    try:",
            "        yield",
            "    finally:",
            "        print(label, round(time.perf_counter() - start, 3))"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        explanation = "A generator-based context manager imports its helpers first, decorates the function, records start time before `yield`, and reports duration in `finally` so it runs even on failure."
    ),
    Problem(
        id = "complexity_hard_19",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Union-find with path compression",
        summary = "The representative is searched recursively and parent pointers are flattened.",
        prompt = "Ignoring inverse-Ackermann details, which high-level complexity best describes `m` calls to `find` across `n` nodes with path compression?",
        code = """
            def find(parent, x):
                if parent[x] != x:
                    parent[x] = find(parent, parent[x])
                return parent[x]
        """.trimIndent(),
        options = listOf("Approximately O(m)", "O(m log n)", "O(mn)", "O(n^2)"),
        answerIndex = 0,
        explanation = "With path compression, repeated `find` operations are amortized almost constant time, commonly summarized at a high level as approximately linear in the number of operations."
    ),
    Problem(
        id = "trace_hard_19",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late-bound loop variable",
        summary = "Closures created in a loop all read the same outer variable at call time.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            funcs = []

            for i in range(3):
                funcs.append(lambda x: x + i)

            result = [fn(10) for fn in funcs]
        """.trimIndent(),
        options = listOf("[10, 11, 12]", "[12, 12, 12]", "[13, 13, 13]", "[10, 10, 10]"),
        answerIndex = 2,
        explanation = "The lambdas capture the variable `i`, not its value per iteration. After the loop, `i` is 2, so each call returns `10 + 2`."
    ),
    Problem(
        id = "match_hard_19",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\na=[]\nb=[0]",
        summary = "Pick the snippet that mutates only one alias after tuple unpacking copies references.",
        prompt = "Which code produces exactly this output?",
        code = """
            a=[]
            b=[0]
        """.trimIndent(),
        options = listOf(
            "pair = ([0], [0])\na, b = pair\na.pop()\nprint(f\"a={a}\")\nprint(f\"b={b}\")",
            "shared = []\na = b = shared\na.append(0)\nb.pop()\nprint(f\"a={a}\")\nprint(f\"b={b}\")",
            "a = [0]\nb = a\na.pop()\nprint(f\"a={a}\")\nprint(f\"b={b}\")",
            "a = [0]\nb = []\na.append(1)\na.pop(0)\nprint(f\"a={a}\")\nprint(f\"b={b}\")"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet binds `a` and `b` to two different lists that both initially contain `0`. Popping from `a` leaves `a` empty while `b` still contains `[0]`."
    )
)
