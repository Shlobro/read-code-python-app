package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 20.
// One senior-level problem per problem type.
val hardProblems20 = listOf(
    Problem(
        id = "bug_hard_21",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Iterator reused in nested loops",
        summary = "A custom iterable returns itself, so nested iteration shares a single cursor.",
        prompt = "What is the real bug in this code?",
        code = """
            class Rows:
                def __init__(self, values):
                    self.values = values
                    self.index = 0

                def __iter__(self):
                    return self

                def __next__(self):
                    if self.index >= len(self.values):
                        raise StopIteration
                    value = self.values[self.index]
                    self.index += 1
                    return value

            rows = Rows([1, 2, 3])
            pairs = []

            for left in rows:
                for right in rows:
                    pairs.append((left, right))

            print(pairs)
        """.trimIndent(),
        options = listOf(
            "The inner loop consumes the same iterator object, so the outer loop loses its remaining items",
            "Python forbids using custom iterators in a nested loop unless `itertools.tee` is imported",
            "The `pairs` list should be a set, otherwise duplicate tuples corrupt the iterator state",
            "`__next__` must return an index and a value tuple instead of only the value"
        ),
        answerIndex = 0,
        explanation = "Because `__iter__` returns `self`, both loops share the same iterator state. The inner loop advances the single cursor to exhaustion, so the outer loop cannot continue as intended."
    ),
    Problem(
        id = "output_hard_21",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Return in `finally`",
        summary = "A `finally` block can replace the value chosen by `except` or `try`.",
        prompt = "What does this code print?",
        code = """
            def run():
                try:
                    raise ValueError("boom")
                except ValueError:
                    return "except"
                finally:
                    return "finally"

            print(run())
        """.trimIndent(),
        options = listOf("finally", "except", "boom", "None"),
        answerIndex = 0,
        explanation = "A `return` in `finally` overrides the earlier `return` from `except`, so the function prints `finally`."
    ),
    Problem(
        id = "purpose_hard_21",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Dependency ordering with indegrees",
        summary = "A queue starts with zero-indegree nodes and unlocks dependents as prerequisites are removed.",
        prompt = "What does this function do overall?",
        code = """
            from collections import defaultdict, deque

            def build_order(edges):
                graph = defaultdict(list)
                indegree = defaultdict(int)

                for src, dst in edges:
                    graph[src].append(dst)
                    indegree[dst] += 1
                    indegree.setdefault(src, 0)

                queue = deque(node for node, count in indegree.items() if count == 0)
                order = []

                while queue:
                    node = queue.popleft()
                    order.append(node)
                    for nxt in graph[node]:
                        indegree[nxt] -= 1
                        if indegree[nxt] == 0:
                            queue.append(nxt)

                return order
        """.trimIndent(),
        options = listOf(
            "It groups nodes by how many outgoing edges they have",
            "It produces a topological ordering of dependency edges when the graph is acyclic",
            "It finds the shortest path between the first and last node in `edges`",
            "It detects strongly connected components using a queue"
        ),
        answerIndex = 1,
        explanation = "This is Kahn's algorithm: start with nodes that have no prerequisites, emit them, then decrement indegrees of dependents until they become ready."
    ),
    Problem(
        id = "fill_hard_21",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Delegate a subgenerator",
        summary = "The outer generator should yield each item from inner iterables without nesting generator objects.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            def flatten(chunks):
                for chunk in chunks:
                    ___ chunk
        """.trimIndent(),
        options = listOf("yield from", "yield", "return", "await"),
        answerIndex = 0,
        explanation = "`yield from chunk` delegates iteration to the sub-iterable and yields each of its items from the outer generator."
    ),
    Problem(
        id = "order_hard_20",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort with a ready queue",
        summary = "Arrange the lines for the core loop that emits ready nodes and unlocks their dependents.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import deque",
            "queue = deque(node for node, count in indegree.items() if count == 0)",
            "order = []",
            "while queue:",
            "    node = queue.popleft()",
            "    order.append(node)",
            "    for nxt in graph[node]:",
            "        indegree[nxt] -= 1",
            "        if indegree[nxt] == 0:",
            "            queue.append(nxt)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        explanation = "Initialize the queue with nodes that have no prerequisites, then repeatedly pop a ready node, emit it, and enqueue dependents when their indegree reaches zero."
    ),
    Problem(
        id = "complexity_hard_20",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "DFS over an adjacency list",
        summary = "Each node is marked once and each outgoing edge is examined once.",
        prompt = "If the graph has `V` vertices and `E` edges, what is the time complexity of this traversal?",
        code = """
            def dfs(graph, node, seen):
                if node in seen:
                    return
                seen.add(node)
                for nxt in graph[node]:
                    dfs(graph, nxt, seen)
        """.trimIndent(),
        options = listOf("O(V + E)", "O(V log E)", "O(VE)", "O(E^2)"),
        answerIndex = 0,
        explanation = "With an adjacency list and a visited set, each vertex is processed once and each edge is explored at most once, giving `O(V + E)`."
    ),
    Problem(
        id = "trace_hard_20",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Cached descriptor side effect",
        summary = "Track how many times a descriptor-backed property computes before it stores into the instance dictionary.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            class cached:
                def __init__(self, func):
                    self.func = func
                    self.name = func.__name__

                def __get__(self, instance, owner):
                    if instance is None:
                        return self
                    value = self.func(instance)
                    instance.__dict__[self.name] = value
                    return value

            class Report:
                def __init__(self):
                    self.calls = 0

                @cached
                def total(self):
                    self.calls += 1
                    return 99

            report = Report()
            first = report.total
            second = report.total
            result = (first, second, report.calls)
        """.trimIndent(),
        options = listOf("(99, 99, 1)", "(99, 99, 2)", "(99, None, 1)", "(198, 198, 2)"),
        answerIndex = 0,
        explanation = "The first access runs the descriptor, increments `calls`, and stores `total` on the instance. The second access reads the cached value directly, so `calls` stays at 1."
    ),
    Problem(
        id = "match_hard_20",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [10, 11, 12]",
        summary = "Pick the snippet that binds the loop value at function-creation time instead of using late binding.",
        prompt = "Which code produces exactly `[10, 11, 12]`?",
        code = "",
        options = listOf(
            "funcs = [lambda x, i=i: x + i for i in range(3)]\nprint([fn(10) for fn in funcs])",
            "funcs = [lambda x: x + i for i in range(3)]\nprint([fn(10) for fn in funcs])",
            "funcs = []\nfor i in range(3):\n    funcs.append(lambda x: x * i)\nprint([fn(10) for fn in funcs])",
            "funcs = [lambda x: x + 1 for i in range(3)]\nprint([fn(10) for fn in funcs])"
        ),
        answerIndex = 0,
        explanation = "Using `i=i` in the lambda default captures the current loop value immediately. Without that, the lambdas read the final loop variable later and all produce the same offset."
    )
)
