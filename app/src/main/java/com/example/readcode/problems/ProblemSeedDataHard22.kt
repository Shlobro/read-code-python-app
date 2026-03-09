package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 22.
// One senior-level problem per problem type.
val hardProblems22 = listOf(
    Problem(
        id = "bug_hard_23",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Dataclass hash violation",
        summary = "A mutable field participates in hashing after the object is used as a dictionary key.",
        prompt = "What is the real bug in this code?",
        code = """
            class Job:
                def __init__(self, name, priority):
                    self.name = name
                    self.priority = priority

                def __hash__(self):
                    return hash((self.name, self.priority))

                def __eq__(self, other):
                    return (
                        isinstance(other, Job)
                        and (self.name, self.priority) == (other.name, other.priority)
                    )

            job = Job("daily", 1)
            registry = {job: "queued"}
            job.priority = 2
            print(registry[job])
        """.trimIndent(),
        options = listOf(
            "The object is used as a hash key even though a field used by `__hash__` is later mutated",
            "`__eq__` must compare only object identity when `__hash__` is defined manually",
            "Dictionary keys cannot be user-defined class instances unless `__slots__` is set",
            "The bug is only that `print` should be outside the mutation block"
        ),
        answerIndex = 0,
        explanation = "Once the object is stored in the dictionary, changing `priority` changes the key's hash/equality behavior. That breaks dictionary lookup because the key no longer hashes to the original bucket."
    ),
    Problem(
        id = "output_hard_23",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Async generator finalization order",
        summary = "The loop exits early, but the async generator still runs its `finally` block before the coroutine continues.",
        prompt = "What does this code print?",
        code = """
            import asyncio

            async def stream():
                try:
                    yield 1
                    yield 2
                finally:
                    print("cleanup")

            async def main():
                async for value in stream():
                    print(value)
                    break
                print("done")

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "1\ncleanup\ndone",
            "1\ndone\ncleanup",
            "1\n2\ncleanup\ndone",
            "cleanup\n1\ndone"
        ),
        answerIndex = 0,
        explanation = "Breaking out of `async for` closes the async generator, which triggers its `finally` block before control proceeds to the next statement."
    ),
    Problem(
        id = "purpose_hard_23",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Topological ordering with indegrees",
        summary = "The function repeatedly emits nodes whose prerequisites have all been satisfied.",
        prompt = "What does this function compute?",
        code = """
            from collections import deque

            def topo_levels(graph):
                indegree = {node: 0 for node in graph}
                for deps in graph.values():
                    for dep in deps:
                        indegree[dep] += 1

                queue = deque([node for node, degree in indegree.items() if degree == 0])
                order = []
                while queue:
                    node = queue.popleft()
                    order.append(node)
                    for dep in graph[node]:
                        indegree[dep] -= 1
                        if indegree[dep] == 0:
                            queue.append(dep)
                return order
        """.trimIndent(),
        options = listOf(
            "A breadth-first traversal of an undirected graph from an arbitrary root",
            "A valid dependency order for a directed acyclic graph",
            "The strongly connected components of the graph",
            "The shortest path tree from every source node"
        ),
        answerIndex = 1,
        explanation = "This is Kahn's algorithm: it tracks indegrees, repeatedly removes zero-indegree nodes, and returns a topological ordering when the graph is acyclic."
    ),
    Problem(
        id = "fill_hard_23",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Preserve wrapped signature metadata",
        summary = "The decorator should expose the original function metadata instead of the wrapper's metadata.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            import functools

            def logged(fn):
                @___(fn)
                def wrapper(*args, **kwargs):
                    print("calling", fn.__name__)
                    return fn(*args, **kwargs)
                return wrapper
        """.trimIndent(),
        options = listOf("functools.wraps", "functools.cache", "functools.partial", "functools.total_ordering"),
        answerIndex = 0,
        explanation = "`functools.wraps` copies the wrapped function metadata onto the wrapper and keeps introspection tools honest."
    ),
    Problem(
        id = "order_hard_22",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Robust exponential backoff loop",
        summary = "Arrange the core retry loop so failures sleep with increasing delay and the last error is re-raised.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "import time",
            "def fetch_with_retry(call, attempts):",
            "    delay = 0.5",
            "    for attempt in range(attempts):",
            "        try:",
            "            return call()",
            "        except TimeoutError:",
            "            if attempt == attempts - 1:",
            "                raise",
            "            time.sleep(delay)",
            "            delay *= 2"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "The function initializes the delay once, retries in a loop, returns on success, and on timeout either re-raises the last failure or sleeps and doubles the delay."
    ),
    Problem(
        id = "complexity_hard_22",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Trie-backed prefix scan",
        summary = "The lookup walks one edge per character in the query and reads a precomputed counter at the end node.",
        prompt = "If the prefix length is `p`, what is the time complexity of this function?",
        code = """
            def count_prefix(root, prefix):
                node = root
                for ch in prefix:
                    if ch not in node.children:
                        return 0
                    node = node.children[ch]
                return node.word_count
        """.trimIndent(),
        options = listOf("O(p)", "O(m)", "O(p + m)", "O(log p + m)"),
        answerIndex = 0,
        explanation = "The function traverses exactly one trie edge per prefix character and then reads a precomputed counter, so it is linear in the prefix length."
    ),
    Problem(
        id = "trace_hard_22",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "MRO with cooperative super calls",
        summary = "Track the constructor side effects across the full method resolution order.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            class Base:
                def __init__(self):
                    self.steps = ["Base"]

            class Left(Base):
                def __init__(self):
                    super().__init__()
                    self.steps.append("Left")

            class Right(Base):
                def __init__(self):
                    super().__init__()
                    self.steps.append("Right")

            class Child(Left, Right):
                def __init__(self):
                    super().__init__()
                    self.steps.append("Child")

            result = Child().steps
        """.trimIndent(),
        options = listOf(
            "['Base', 'Right', 'Left', 'Child']",
            "['Base', 'Left', 'Right', 'Child']",
            "['Base', 'Child']",
            "['Base', 'Left', 'Child', 'Right']"
        ),
        answerIndex = 0,
        explanation = "The MRO is `Child -> Left -> Right -> Base`, so `super()` chains through `Base` first, then appends in reverse unwinding order: `Right`, `Left`, `Child`."
    ),
    Problem(
        id = "match_hard_22",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\na\nb\nc",
        summary = "Pick the snippet that drains a deque from the left until it is empty.",
        prompt = "Which code produces exactly this output?",
        code = """
            a
            b
            c
        """.trimIndent(),
        options = listOf(
            "from collections import deque\nitems = deque(['a', 'b', 'c'])\nwhile items:\n    print(items.popleft())",
            "from collections import deque\nitems = deque(['a', 'b', 'c'])\nfor item in items:\n    print(items.pop())",
            "items = ['a', 'b', 'c']\nfor item in items:\n    print(items.pop(0))",
            "items = ['a', 'b', 'c']\nwhile items:\n    print(items.pop())"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet removes from the left in FIFO order and prints `a`, then `b`, then `c` without mutating the collection during a `for` loop."
    )
)
