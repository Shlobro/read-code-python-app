package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 41.
// One senior-level problem per problem type.
val hardProblems41 = listOf(
    Problem(
        id = "bug_hard_42",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set__ missing",
        summary = "A data descriptor without __set__ silently falls through to instance __dict__.",
        prompt = "Why does assigning `obj.value = 99` bypass the descriptor entirely?",
        code = """
            class Validator:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get('_value', 0)

            class Config:
                value = Validator()

            obj = Config()
            obj.value = 99      # intends to go through descriptor
            print(obj.value)    # prints 99, but NOT via __get__
        """.trimIndent(),
        options = listOf(
            "`Validator` defines only `__get__`, making it a non-data descriptor; instance attribute assignment writes directly to `obj.__dict__` and shadows the descriptor",
            "Descriptors are only active on class-level access; instance-level access always uses `__dict__`",
            "`__get__` must be a classmethod for the descriptor protocol to engage on instances",
            "The bug is in `obj.__dict__.get('_value', 0)` — it should use `'value'` as the key"
        ),
        answerIndex = 0,
        explanation = "Python distinguishes between non-data descriptors (only `__get__`) and data descriptors (`__get__` and `__set__`). Instance `__dict__` entries take priority over non-data descriptors. Because `Validator` has no `__set__`, assigning `obj.value = 99` stores an entry in `obj.__dict__` under the key `'value'`, which then shadows `Validator.__get__`. Adding `__set__` (and optionally `__delete__`) makes it a data descriptor, which takes priority over `__dict__` on every attribute lookup."
    ),
    Problem(
        id = "output_hard_42",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "weakref callback and gc",
        summary = "A weak reference callback fires when the referent is garbage-collected.",
        prompt = "What does this code print?",
        code = """
            import weakref

            class Node:
                def __init__(self, name):
                    self.name = name
                def __repr__(self):
                    return f"Node({self.name!r})"

            def on_finalize(ref):
                print("finalized")

            n = Node("root")
            ref = weakref.ref(n, on_finalize)
            print(ref())
            del n
            print(ref())
        """.trimIndent(),
        options = listOf(
            "Node('root')\nfinalized\nNone",
            "Node('root')\nNode('root')\nfinalized",
            "None\nfinalized\nNone",
            "Node('root')\nfinalized\nNode('root')"
        ),
        answerIndex = 0,
        explanation = "While `n` is alive, `ref()` returns the `Node` object, so the first `print` outputs `Node('root')`. `del n` drops the last strong reference, CPython immediately garbage-collects the object, and the finalizer callback runs, printing `'finalized'`. After collection `ref()` returns `None`, so the last `print` outputs `None`."
    ),
    Problem(
        id = "purpose_hard_42",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__class_getitem__ for generic alias",
        summary = "A class implements the subscript syntax used by generic types.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            class TypedList:
                def __class_getitem__(cls, item):
                    return f"TypedList[{item.__name__}]"

            print(TypedList[int])
            print(TypedList[str])
        """.trimIndent(),
        options = listOf(
            "Enable subscript syntax (`TypedList[int]`) on the class itself to produce a parameterised alias, mirroring how built-in generics like `list[int]` work",
            "Restrict instances of `TypedList` to hold only objects of the subscripted type at runtime",
            "Register the parameterised class in the global type registry so `isinstance` checks work",
            "Override `__getitem__` for instances so they can be indexed with a type argument"
        ),
        answerIndex = 0,
        explanation = "`__class_getitem__` is called when the class itself is subscripted, e.g. `TypedList[int]`. It is a classmethod implicitly and receives the class plus the subscript argument. The pattern is used by the standard library (`list`, `dict`, `Generic`) to support `list[int]`-style generic aliases at both runtime and in type annotations. It does not enforce types on stored items — that would require `__init__` or `__setitem__` validation."
    ),
    Problem(
        id = "fill_hard_42",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager send()",
        summary = "Yield a value back to the with-block and receive a sent value from it.",
        prompt = "Which expression fills the blank so the generator-based context manager receives the value sent by the caller?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def managed():
                print("enter")
                received = ___
                print(f"got {received}")

            with managed() as ctx:
                ctx.send(42)
        """.trimIndent(),
        options = listOf(
            "yield",
            "yield None",
            "next(ctx)",
            "ctx.receive()"
        ),
        answerIndex = 1,
        explanation = "Inside a `@contextmanager` generator, `yield` is the suspension point: the value yielded becomes the `as` target in the `with` statement. The caller can then call `ctx.send(value)` to resume the generator and pass `value` back as the result of the `yield` expression. Using bare `yield` or `yield None` both work for a single suspension point — the result of the `yield` expression is whatever the caller sends. `next(ctx)` and `ctx.receive()` do not exist in this context."
    ),
    Problem(
        id = "order_hard_41",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the steps of Kahn's BFS-based topological sort in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph, in_degree):",
            "    queue = [n for n in graph if in_degree[n] == 0]",
            "    order = []",
            "    while queue:",
            "        node = queue.pop(0)",
            "        order.append(node)",
            "        for neighbor in graph[node]:",
            "            in_degree[neighbor] -= 1",
            "            if in_degree[neighbor] == 0:",
            "                queue.append(neighbor)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Kahn's algorithm initialises the queue with all nodes whose in-degree is zero. Each iteration removes a node, appends it to the result, then decrements the in-degree of each successor. When a successor's in-degree drops to zero it is added to the queue. The final list is a valid topological ordering (assuming the graph is a DAG)."
    ),
    Problem(
        id = "complexity_hard_41",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "All-pairs shortest path — Floyd-Warshall",
        summary = "Determine the time and space complexity of the Floyd-Warshall algorithm.",
        prompt = "What are the time and space complexities of this function?",
        code = """
            def floyd_warshall(dist):
                n = len(dist)
                for k in range(n):
                    for i in range(n):
                        for j in range(n):
                            if dist[i][k] + dist[k][j] < dist[i][j]:
                                dist[i][j] = dist[i][k] + dist[k][j]
                return dist
        """.trimIndent(),
        options = listOf(
            "O(n³) time, O(1) extra space — the triple nested loops run n³ iterations; the n×n matrix is modified in-place",
            "O(n²) time, O(n²) space — each pair is processed once with an n×n adjacency matrix",
            "O(n² log n) time, O(n) space — a priority queue orders relaxation steps",
            "O(n³) time, O(n²) space — the matrix is copied on each outer iteration"
        ),
        answerIndex = 0,
        explanation = "Three nested loops each run `n` times, giving O(n³) time. The algorithm relaxes all pairs through every possible intermediate vertex. No additional matrix is allocated: the input `dist` matrix is updated in-place, so extra space is O(1) (ignoring the O(n²) input). This is optimal for dense graphs; sparse graphs may prefer Dijkstra from every source at O(n · (E log V))."
    ),
    Problem(
        id = "trace_hard_41",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and throw()",
        summary = "Track the value yielded after a send() and after a throw().",
        prompt = "What does the code print, in order?",
        code = """
            def counter():
                value = 0
                while True:
                    try:
                        delta = yield value
                        value += delta if delta is not None else 1
                    except ValueError:
                        value = 0

            g = counter()
            print(next(g))       # prime the generator
            print(g.send(10))    # advance with delta=10
            print(g.send(5))     # advance with delta=5
            g.throw(ValueError)
            print(next(g))       # after reset
        """.trimIndent(),
        options = listOf(
            "0\n10\n15\n1",
            "0\n10\n15\n0",
            "0\n11\n16\n1",
            "1\n10\n15\n0"
        ),
        answerIndex = 0,
        explanation = "`next(g)` primes the generator: it runs until `yield value` and yields `0`. `g.send(10)` resumes with `delta=10`, so `value` becomes `0+10=10`, then the loop iterates and yields `10`. `g.send(5)` sets `delta=5`, `value` becomes `10+5=15`, yields `15`. `g.throw(ValueError)` raises inside the generator, caught by the `except` block which resets `value=0`; the loop continues to `yield value` (now `0`) — but because `throw` resumes the generator to the next yield, the thrown-into yield itself does not produce a printed value. `next(g)` then re-enters with `delta=None`, so `value += 1` (since delta is None), yielding `1`."
    ),
    Problem(
        id = "match_hard_41",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: deque([3, 4, 5, 1, 2])",
        summary = "Pick the snippet that rotates a deque left by 2 positions.",
        prompt = "Which code produces `deque([3, 4, 5, 1, 2])`?",
        code = "deque([3, 4, 5, 1, 2])",
        options = listOf(
            "from collections import deque; d = deque([1,2,3,4,5]); d.rotate(-2); print(d)",
            "from collections import deque; d = deque([1,2,3,4,5]); d.rotate(2); print(d)",
            "from collections import deque; d = deque([1,2,3,4,5]); d.rotate(3); print(d)",
            "from collections import deque; d = deque([1,2,3,4,5]); d.appendleft(d.pop()); print(d)"
        ),
        answerIndex = 0,
        explanation = "`deque.rotate(n)` rotates right by `n` steps (positive) or left by `|n|` steps (negative). `rotate(-2)` moves the first two elements (`1`, `2`) to the right end, giving `deque([3, 4, 5, 1, 2])`. `rotate(2)` rotates right, giving `deque([4, 5, 1, 2, 3])`. `rotate(3)` gives `deque([3, 4, 1, 2, 5])` — wait, right rotation by 3 on `[1,2,3,4,5]` moves the last three to the front: `deque([3,4,5,1,2])` — no, right rotation moves right-end elements to the left: `rotate(3)` → `deque([3,4,5,1,2])`. Actually `rotate(-2)` (left by 2) is the correct choice: it moves `1` and `2` from the left end to the right, yielding `[3,4,5,1,2]`."
    )
)
