package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 65.
// One senior-level problem per problem type.
val hardProblems65 = listOf(
    Problem(
        id = "bug_hard_66",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Generator exhausted silently",
        summary = "Consuming a generator twice silently yields nothing on the second pass.",
        prompt = "What is the bug in this code?",
        code = """
            def evens(n):
                return (x for x in range(n) if x % 2 == 0)

            gen = evens(10)
            first = list(gen)
            second = list(gen)
            print(first, second)
        """.trimIndent(),
        options = listOf(
            "Generators are single-use; `second` will be an empty list because `gen` is exhausted after `first`",
            "`evens` must use `yield` instead of a generator expression to be iterable more than once",
            "Calling `list()` on a generator raises `StopIteration` and crashes the program before `second` is assigned",
            "The filter `x % 2 == 0` is incorrect for even numbers and should be `x % 2 != 0`"
        ),
        answerIndex = 0,
        explanation = "A generator object keeps its position. After `list(gen)` drains it, the iterator is at the end. A second `list(gen)` call returns `[]` immediately. To iterate twice, call `evens(10)` again or convert to a list first."
    ),
    Problem(
        id = "output_hard_66",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__new__ controls instance count",
        summary = "A singleton implemented via __new__ returns the same object on every instantiation.",
        prompt = "What does this code print?",
        code = """
            class Singleton:
                _instance = None
                def __new__(cls):
                    if cls._instance is None:
                        cls._instance = super().__new__(cls)
                    return cls._instance

            a = Singleton()
            b = Singleton()
            print(a is b, id(a) == id(b))
        """.trimIndent(),
        options = listOf(
            "False False",
            "True False",
            "True True",
            "False True"
        ),
        answerIndex = 2,
        explanation = "`__new__` returns the same object every time, so `a` and `b` are literally the same object. `a is b` is `True` and their `id`s are identical, so both expressions print `True`."
    ),
    Problem(
        id = "purpose_hard_66",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager",
        summary = "A generator-based context manager that measures elapsed wall time.",
        prompt = "What does this context manager do?",
        code = """
            import time
            from contextlib import contextmanager

            @contextmanager
            def timer():
                start = time.perf_counter()
                yield
                elapsed = time.perf_counter() - start
                print(f"elapsed: {elapsed:.4f}s")
        """.trimIndent(),
        options = listOf(
            "Measures and prints how long the `with` block takes to execute",
            "Retries the `with` block up to three times if it raises an exception, then prints total time",
            "Suspends execution for a fixed duration before and after the wrapped block",
            "Benchmarks a function over many iterations and prints mean and standard deviation"
        ),
        answerIndex = 0,
        explanation = "Code before `yield` runs on `__enter__`; code after runs on `__exit__`. The timer records `perf_counter` before yielding and computes the difference after, printing the wall-clock duration of the `with` block."
    ),
    Problem(
        id = "fill_hard_66",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "dataclass field with default_factory",
        summary = "Give a dataclass field a mutable default using field(default_factory=...).",
        prompt = "Fill the blank so each instance gets its own empty list instead of sharing one.",
        code = """
            from dataclasses import dataclass, field

            @dataclass
            class Bag:
                items: list = ___

            b1, b2 = Bag(), Bag()
            b1.items.append(1)
            print(b2.items)   # []
        """.trimIndent(),
        options = listOf(
            "[]",
            "field(default_factory=list)",
            "field(default=[], repr=False, compare=True)",
            "list()"
        ),
        answerIndex = 1,
        explanation = "`field(default_factory=list)` calls `list()` for each new instance. Using `[]` directly as a default raises `ValueError` in dataclasses because mutable defaults are shared. `list()` as a bare default has the same problem."
    ),
    Problem(
        id = "order_hard_65",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Quicksort partition step",
        summary = "Arrange the in-place Lomuto partition function into the correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def partition(arr, lo, hi):",
            "    pivot = arr[hi]",
            "    i = lo - 1",
            "    for j in range(lo, hi):",
            "        if arr[j] <= pivot:",
            "            i += 1",
            "            arr[i], arr[j] = arr[j], arr[i]",
            "    arr[i + 1], arr[hi] = arr[hi], arr[i + 1]",
            "    return i + 1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        explanation = "Define the function, choose the pivot as the last element, initialise i below lo, scan j from lo to hi-1 swapping elements ≤ pivot, place the pivot at i+1, and return its final index."
    ),
    Problem(
        id = "complexity_hard_65",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "BFS-based topological sort over a directed acyclic graph with V vertices and E edges.",
        prompt = "What is the time and space complexity of this algorithm?",
        code = """
            from collections import deque

            def topo_sort(graph, in_degree):
                q = deque(v for v in graph if in_degree[v] == 0)
                order = []
                while q:
                    v = q.popleft()
                    order.append(v)
                    for u in graph[v]:
                        in_degree[u] -= 1
                        if in_degree[u] == 0:
                            q.append(u)
                return order
        """.trimIndent(),
        options = listOf(
            "O(V + E) time, O(V) space",
            "O(V²) time, O(V + E) space",
            "O(E log V) time, O(V) space",
            "O(V + E) time, O(V + E) space"
        ),
        answerIndex = 0,
        explanation = "Each vertex is enqueued and dequeued once (O(V)) and each edge is relaxed once (O(E)), giving O(V + E) time. The queue and output list hold at most V entries each; no edge list is copied, so extra space is O(V)."
    ),
    Problem(
        id = "trace_hard_65",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Mutable default argument accumulates",
        summary = "A function with a mutable default list retains state across calls.",
        prompt = "What does this code print?",
        code = """
            def push(val, cache=[]):
                cache.append(val)
                return cache

            push(1)
            push(2)
            result = push(3)
            print(result)
        """.trimIndent(),
        options = listOf(
            "[3]",
            "[1, 2, 3]",
            "[1, 2, 3]\n[1, 2, 3]\n[1, 2, 3]",
            "TypeError: unhashable type: 'list'"
        ),
        answerIndex = 1,
        explanation = "The default list `[]` is created once when the function is defined and reused on every call. Each `push` appends to the same list, so after three calls `cache` is `[1, 2, 3]`."
    ),
    Problem(
        id = "match_hard_65",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: __init_subclass__ hook",
        summary = "Pick the snippet where defining a subclass triggers a registration side-effect.",
        prompt = "Which code prints `registered: Dog`?",
        code = "registered: Dog",
        options = listOf(
            "class Animal:\n    def __init_subclass__(cls, **kw):\n        super().__init_subclass__(**kw)\n        print(f'registered: {cls.__name__}')\nclass Dog(Animal): pass",
            "class Animal:\n    def __subclasshook__(cls, sub):\n        print(f'registered: {sub.__name__}')\n        return NotImplemented\nclass Dog(Animal): pass",
            "import abc\nclass Animal(abc.ABC):\n    @abc.abstractmethod\n    def speak(self): pass\nclass Dog(Animal):\n    def speak(self): print('registered: Dog')\nDog().speak()",
            "class Animal:\n    subclasses = []\n    @classmethod\n    def register(cls, sub):\n        cls.subclasses.append(sub)\n        print(f'registered: {sub.__name__}')\nclass Dog(Animal): Animal.register(Dog)"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called automatically on the base class whenever a new subclass is defined. Option A prints `registered: Dog` the moment `class Dog(Animal): pass` is parsed. `__subclasshook__` is for `isinstance` checks, not subclass creation. Option C requires an explicit method call. Option D requires an explicit `register` call."
    )
)
