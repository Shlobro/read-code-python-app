package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 29.
// One senior-level problem per problem type.
val hardProblems29 = listOf(
    Problem(
        id = "bug_hard_30",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Mutable class attribute shared across instances",
        summary = "Assigning to a class attribute mutates it for every instance.",
        prompt = "What bug causes both `a.items` and `b.items` to contain `[1, 2]`?",
        code = """
            class Bag:
                items = []

                def add(self, x):
                    self.items.append(x)

            a = Bag()
            b = Bag()
            a.add(1)
            b.add(2)
            print(a.items, b.items)
        """.trimIndent(),
        options = listOf(
            "`items` is a class attribute shared by all instances; appending mutates the shared list",
            "`append` creates a new list each time it is called, discarding the old one",
            "Class attributes are read-only; `self.items.append` raises `AttributeError`",
            "`a` and `b` are the same object because Python caches class instantiations"
        ),
        answerIndex = 0,
        explanation = "`items = []` at class scope creates one list shared by every instance. `self.items.append(x)` looks up `items` through the instance's class and mutates that shared list in-place. To give each instance its own list, initialize `self.items = []` inside `__init__`."
    ),
    Problem(
        id = "output_hard_30",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__new__ vs __init__ return",
        summary = "Returning a different type from __new__ skips __init__.",
        prompt = "What does this code print?",
        code = """
            class Singleton:
                _instance = None

                def __new__(cls, value):
                    if cls._instance is None:
                        cls._instance = super().__new__(cls)
                    return cls._instance

                def __init__(self, value):
                    self.value = value

            a = Singleton(10)
            b = Singleton(20)
            print(a.value, b.value, a is b)
        """.trimIndent(),
        options = listOf(
            "20 20 True",
            "10 20 False",
            "10 10 True",
            "10 20 True"
        ),
        answerIndex = 0,
        explanation = "`__new__` returns the same instance both times, so `a is b` is `True`. Because `__init__` is called on the returned object each time, the second call `Singleton(20)` overwrites `self.value` with 20 on the shared instance. Both `a.value` and `b.value` are therefore 20."
    ),
    Problem(
        id = "purpose_hard_30",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Context manager via __enter__/__exit__",
        summary = "A class that suppresses a specific exception type.",
        prompt = "What is the primary purpose of this class?",
        code = """
            class suppress:
                def __init__(self, *exc_types):
                    self.exc_types = exc_types

                def __enter__(self):
                    return self

                def __exit__(self, exc_type, exc_val, exc_tb):
                    return exc_type is not None and issubclass(exc_type, self.exc_types)
        """.trimIndent(),
        options = listOf(
            "Silently ignore exceptions whose type matches one of the provided exception classes",
            "Re-raise exceptions as a different exception type for cleaner stack traces",
            "Log exceptions and then propagate them to the caller",
            "Retry the body of the `with` block whenever a matching exception is raised"
        ),
        answerIndex = 0,
        explanation = "`__exit__` returning a truthy value tells Python to suppress the exception. This class returns `True` only when an exception occurred (`exc_type is not None`) and is a subclass of one of the provided types, silently swallowing matching exceptions. This is equivalent to `contextlib.suppress`."
    ),
    Problem(
        id = "fill_hard_30",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "weakref.ref to avoid reference cycle",
        summary = "Storing a back-reference without preventing garbage collection.",
        prompt = "Which module function fills the blank to store a weak reference to `parent`?",
        code = """
            import weakref

            class Child:
                def __init__(self, parent):
                    self.parent = weakref.___(parent)

            class Parent:
                def __init__(self):
                    self.child = Child(self)

            p = Parent()
            print(p.child.parent() is p)
        """.trimIndent(),
        options = listOf("ref", "proxy", "finalize", "WeakValueDictionary"),
        answerIndex = 0,
        explanation = "`weakref.ref(obj)` creates a callable weak reference. Calling it returns the referent if it is still alive, or `None` if it has been collected. Using a weak reference for the back-pointer breaks the reference cycle between parent and child, allowing the garbage collector to reclaim both objects when no strong references remain."
    ),
    Problem(
        id = "order_hard_29",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest path",
        summary = "Arrange a correct Dijkstra implementation using a min-heap.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "import heapq",
            "def dijkstra(graph, start):",
            "    dist = {node: float('inf') for node in graph}",
            "    dist[start] = 0",
            "    heap = [(0, start)]",
            "    while heap:",
            "        cost, u = heapq.heappop(heap)",
            "        if cost > dist[u]:",
            "            continue",
            "        for v, w in graph[u]:",
            "            if dist[u] + w < dist[v]:",
            "                dist[v] = dist[u] + w",
            "                heapq.heappush(heap, (dist[v], v))",
            "    return dist"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
        explanation = "Dijkstra initializes all distances to infinity except the start (0). The min-heap drives greedy expansion: pop the cheapest unvisited node, skip it if we already found a shorter path (stale entry check), then relax each neighbor and push updated distances onto the heap."
    ),
    Problem(
        id = "complexity_hard_29",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive tree traversal with memoization",
        summary = "Each unique subproblem is solved once; total subproblems determine complexity.",
        prompt = "What is the time complexity of `count_paths`?",
        code = """
            from functools import lru_cache

            def count_paths(m, n):
                @lru_cache(maxsize=None)
                def dp(r, c):
                    if r == 0 or c == 0:
                        return 1
                    return dp(r - 1, c) + dp(r, c - 1)
                return dp(m - 1, n - 1)
        """.trimIndent(),
        options = listOf("O(m * n)", "O(2^(m+n))", "O(m + n)", "O(m * n * log(m * n))"),
        answerIndex = 0,
        explanation = "Without memoization, the naive recursion is O(2^(m+n)). With `lru_cache`, each unique `(r, c)` pair is computed exactly once. There are m * n distinct pairs, so the total time is O(m * n). Space is also O(m * n) for the cache."
    ),
    Problem(
        id = "trace_hard_29",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ binding",
        summary = "Accessing a descriptor through a class vs an instance returns different objects.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            class Validator:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.name, 0)

                def __set__(self, obj, value):
                    obj.__dict__[self.name] = max(0, value)

            class Account:
                balance = Validator()

            acc = Account()
            acc.balance = -50
            result = acc.balance
        """.trimIndent(),
        options = listOf("0", "-50", "50", "None"),
        answerIndex = 0,
        explanation = "`__set__` clamps the stored value to `max(0, value)`, so `acc.balance = -50` stores `0` in `acc.__dict__['balance']`. When `acc.balance` is read, `__get__` retrieves that stored value, returning `0`."
    ),
    Problem(
        id = "match_hard_29",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\nTrue\nFalse",
        summary = "Pick the snippet that prints True then False using __contains__.",
        prompt = "Which code prints exactly `True` then `False`?",
        code = "True\nFalse",
        options = listOf(
            "class Range:\n    def __init__(self, n): self.n = n\n    def __contains__(self, x): return 0 <= x < self.n\nr = Range(5)\nprint(3 in r)\nprint(5 in r)",
            "r = range(5)\nprint(5 in r)\nprint(3 in r)",
            "print(bool(1))\nprint(bool(1))",
            "class R:\n    def __contains__(self, x): return x > 0\nr = R()\nprint(-1 in r)\nprint(1 in r)"
        ),
        answerIndex = 0,
        explanation = "Option A defines a custom `__contains__` that returns `True` for 0 ≤ x < 5. `3 in r` is `True`, `5 in r` is `False`. Option B has the checks reversed (5 is not in range(5), 3 is). Option C prints `True` twice. Option D: `-1 in r` calls `__contains__(-1)` which returns `-1 > 0 = False`, and `1 in r` returns `True` — the opposite order."
    )
)
