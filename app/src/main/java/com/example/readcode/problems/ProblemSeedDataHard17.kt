package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 17.
// One senior-level problem per problem type.
val hardProblems17 = listOf(
    Problem(
        id = "bug_hard_18",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Shallow-copied request config",
        summary = "Copying the top-level dict does not isolate nested headers.",
        prompt = "What is the real bug in this code?",
        code = """
            defaults = {
                "timeout": 3,
                "headers": {"Accept": "application/json"}
            }

            request_config = defaults.copy()
            request_config["headers"]["Authorization"] = "Bearer token"

            print(defaults["headers"])
        """.trimIndent(),
        options = listOf(
            "The nested `headers` dict is still shared because `.copy()` only makes a shallow copy",
            "String keys cannot be reused across two dictionaries in Python",
            "Adding `Authorization` mutates `request_config` but never mutates `defaults`",
            "The print call fails because nested dictionaries are not printable"
        ),
        answerIndex = 0,
        explanation = "`.copy()` clones only the outer dictionary. The inner `headers` mapping is shared, so mutating it through `request_config` also changes `defaults`."
    ),
    Problem(
        id = "output_hard_18",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Inherited descriptor binding",
        summary = "A base-class function becomes a bound method on the subclass instance.",
        prompt = "What does this code print?",
        code = """
            class Formatter:
                prefix = "base"

                def render(self):
                    return self.prefix.upper()

            class JsonFormatter(Formatter):
                prefix = "json"
                render = Formatter.render

            print(JsonFormatter().render())
        """.trimIndent(),
        options = listOf("JSON", "BASE", "json", "TypeError"),
        answerIndex = 0,
        explanation = "Assigning `Formatter.render` to `JsonFormatter.render` still produces a bound method. Inside the method, `self` is the `JsonFormatter` instance, so it reads the subclass prefix and prints `JSON`."
    ),
    Problem(
        id = "purpose_hard_18",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Single-flight lazy cache",
        summary = "The wrapper computes the value once and reuses it for every later call.",
        prompt = "What does this function return overall?",
        code = """
            def once(factory):
                missing = object()
                value = missing

                def get():
                    nonlocal value
                    if value is missing:
                        value = factory()
                    return value

                return get
        """.trimIndent(),
        options = listOf(
            "A function that lazily computes a value once and then returns the cached result on later calls",
            "A function that rebuilds the value every time but hides exceptions from `factory`",
            "A decorator that runs `factory` asynchronously in a background thread",
            "A context manager that resets `factory` after each use"
        ),
        answerIndex = 0,
        explanation = "The closure stores a sentinel and replaces it with the first computed result. Future calls return the cached value without calling `factory` again."
    ),
    Problem(
        id = "fill_hard_18",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Delegating recursive generator",
        summary = "The recursive branch must yield each nested value without building an intermediate list.",
        prompt = "Which choice fills the blank so `flatten()` yields all nested integers in order?",
        code = """
            def flatten(items):
                for item in items:
                    if isinstance(item, list):
                        ___ flatten(item)
                    else:
                        yield item
        """.trimIndent(),
        options = listOf("yield from", "return from", "await", "break"),
        answerIndex = 0,
        explanation = "`yield from` delegates iteration to the nested generator, preserving order and streaming values without materializing them first."
    ),
    Problem(
        id = "order_hard_17",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort with indegrees",
        summary = "Arrange the lines to process zero-indegree nodes with a queue.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import deque",
            "def topo_order(graph):",
            "    indegree = {node: 0 for node in graph}",
            "    for neighbors in graph.values():",
            "        for neighbor in neighbors:",
            "            indegree[neighbor] += 1",
            "    queue = deque(node for node, degree in indegree.items() if degree == 0)",
            "    order = []",
            "    while queue:",
            "        node = queue.popleft()",
            "        order.append(node)",
            "        for neighbor in graph[node]:",
            "            indegree[neighbor] -= 1",
            "            if indegree[neighbor] == 0:",
            "                queue.append(neighbor)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "Kahn's algorithm first computes indegrees, then repeatedly removes zero-indegree nodes and decreases the indegree of their outgoing neighbors."
    ),
    Problem(
        id = "complexity_hard_17",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Union-find with compression",
        summary = "The structure serves many near-constant-time membership merges and lookups.",
        prompt = "If there are `m` `find`/`union` operations on `n` items, what is the amortized time complexity with union by rank and path compression?",
        code = """
            class DSU:
                def __init__(self, n):
                    self.parent = list(range(n))
                    self.rank = [0] * n

                def find(self, x):
                    if self.parent[x] != x:
                        self.parent[x] = self.find(self.parent[x])
                    return self.parent[x]

                def union(self, a, b):
                    ra = self.find(a)
                    rb = self.find(b)
                    if ra == rb:
                        return
                    if self.rank[ra] < self.rank[rb]:
                        ra, rb = rb, ra
                    self.parent[rb] = ra
                    if self.rank[ra] == self.rank[rb]:
                        self.rank[ra] += 1
        """.trimIndent(),
        options = listOf("O(m alpha(n))", "O(m log n)", "O(n^2)", "O(mn)"),
        answerIndex = 0,
        explanation = "With both optimizations, a sequence of `m` operations is amortized O(m alpha(n)), where `alpha` is the inverse Ackermann function and grows extremely slowly."
    ),
    Problem(
        id = "trace_hard_17",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Exception path through `finally`",
        summary = "Track how the local variable changes across `try`, `except`, and `finally`.",
        prompt = "What is the value of `status` after this code runs?",
        code = """
            def load_flag(raw):
                status = "start"
                try:
                    status = raw.strip()
                    int(status)
                except ValueError:
                    status = "fallback"
                finally:
                    status += ":done"
                return status

            status = load_flag(" x ")
        """.trimIndent(),
        options = listOf("fallback:done", "x:done", "start:done", "ValueError"),
        answerIndex = 0,
        explanation = "After stripping, `status` becomes `\"x\"`. `int(\"x\")` raises `ValueError`, so the `except` block sets `status` to `\"fallback\"`, and `finally` appends `\":done\"` before the return."
    ),
    Problem(
        id = "match_hard_17",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: ['A', 'bb', 'dd']",
        summary = "Pick the snippet that keeps strings of even length plus any single-character strings, preserving the original order.",
        prompt = "Which code produces exactly `['A', 'bb', 'dd']`?",
        code = "",
        options = listOf(
            "items = ['A', 'bb', 'ccc', 'dd']; print([item for item in items if len(item) == 2])",
            "items = ['A', 'bb', 'ccc', 'dd']; print([item for item in items if len(item) % 2 == 0 or len(item) == 1])",
            "items = ['A', 'bb', 'ccc', 'dd']; print(sorted(items, key=len)[:3])",
            "items = ['A', 'bb', 'ccc', 'dd']; print(list(filter(lambda item: len(item) != 3, items[::-1])))"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet keeps strings of even length plus the one-character `'A'`, and it does so without reordering the original list."
    )
)
