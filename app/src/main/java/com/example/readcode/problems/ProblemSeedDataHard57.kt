package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 57.
// One senior-level problem per problem type.
val hardProblems57 = listOf(
    Problem(
        id = "bug_hard_58",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread-unsafe lazy singleton",
        summary = "A singleton uses a double-checked pattern but has a race condition without a lock.",
        prompt = "What is the bug in this thread-safety approach?",
        code = """
            class Config:
                _instance = None

                @classmethod
                def get(cls):
                    if cls._instance is None:
                        cls._instance = cls()
                    return cls._instance
        """.trimIndent(),
        options = listOf(
            "Two threads can both pass the `None` check simultaneously",
            "`cls()` cannot be called inside a classmethod because `cls` is not yet bound",
            "`_instance` must be declared inside `__init__` to be accessible",
            "Classmethods cannot return `self`"
        ),
        answerIndex = 0,
        explanation = "Without a lock, two threads can both observe `cls._instance is None` simultaneously and each create a new instance, breaking the singleton guarantee. The fix is to use a `threading.Lock` around the check-and-set."
    ),
    Problem(
        id = "output_hard_58",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor `__get__` on class vs instance",
        summary = "A descriptor returns different values depending on whether it is accessed via the class or an instance.",
        prompt = "What does this code print?",
        code = """
            class Desc:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return 42

            class MyClass:
                value = Desc()

            print(type(MyClass.value).__name__)
            print(MyClass().value)
        """.trimIndent(),
        options = listOf(
            "Desc\n42",
            "42\n42",
            "int\n42",
            "Desc\nNone"
        ),
        answerIndex = 0,
        explanation = "When accessed on the class (`obj is None`), `__get__` returns `self` — the descriptor object itself — so its type is `Desc`. When accessed on an instance, `__get__` returns `42`."
    ),
    Problem(
        id = "purpose_hard_58",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "LRU cache via `OrderedDict`",
        summary = "A fixed-capacity mapping evicts the least-recently-used entry on overflow.",
        prompt = "What does this class do overall?",
        code = """
            from collections import OrderedDict

            class LRUCache:
                def __init__(self, capacity):
                    self.cap = capacity
                    self.cache = OrderedDict()

                def get(self, key):
                    if key not in self.cache:
                        return -1
                    self.cache.move_to_end(key)
                    return self.cache[key]

                def put(self, key, value):
                    if key in self.cache:
                        self.cache.move_to_end(key)
                    self.cache[key] = value
                    if len(self.cache) > self.cap:
                        self.cache.popitem(last=False)
        """.trimIndent(),
        options = listOf(
            "It compresses and serializes key-value pairs into a thread-safe shared memory buffer",
            "It implements an LRU cache, evicting the least-recently-used item when full",
            "It sorts keys on every access to maintain alphabetical order",
            "It stores key-value pairs in insertion order with no eviction policy"
        ),
        answerIndex = 1,
        explanation = "`move_to_end` marks a key as recently used. On overflow, `popitem(last=False)` removes the oldest (least-recently-used) entry. This is the classic O(1) LRU cache implementation using `OrderedDict`."
    ),
    Problem(
        id = "fill_hard_58",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Context manager `__exit__` suppressing exceptions",
        summary = "A context manager must signal that a raised exception should be suppressed.",
        prompt = "Which return value from `__exit__` suppresses the exception?",
        code = """
            class Suppress:
                def __init__(self, exc_type):
                    self.exc_type = exc_type

                def __enter__(self):
                    return self

                def __exit__(self, exc_type, exc_val, tb):
                    if exc_type is not None and issubclass(exc_type, self.exc_type):
                        return ___
                    return False
        """.trimIndent(),
        options = listOf(
            "True",
            "None",
            "raise",
            "False"
        ),
        answerIndex = 0,
        explanation = "When `__exit__` returns a truthy value, Python suppresses the exception and resumes normal execution after the `with` block. Returning `False` or `None` lets the exception propagate."
    ),
    Problem(
        id = "order_hard_57",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the core steps of Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "in_degree = {v: 0 for v in graph}",
            "for v in graph:\n    for nbr in graph[v]: in_degree[nbr] += 1",
            "queue = deque(v for v in graph if in_degree[v] == 0)",
            "while queue:",
            "    node = queue.popleft(); order.append(node)",
            "    for nbr in graph[node]:\n        in_degree[nbr] -= 1",
            "        if in_degree[nbr] == 0: queue.append(nbr)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "First build in-degree counts, then seed the queue with zero-in-degree nodes, then repeatedly dequeue a node, record it, decrement neighbor in-degrees, and enqueue any that reach zero."
    ),
    Problem(
        id = "complexity_hard_57",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Building a heap from an unsorted list",
        summary = "Python's `heapq.heapify` transforms an unsorted list in-place into a min-heap.",
        prompt = "What is the time complexity of `heapq.heapify(lst)` on a list of n elements?",
        code = """
            import heapq

            def make_heap(lst):
                heapq.heapify(lst)
                return lst
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(n)",
            "O(log n)",
            "O(n^2)"
        ),
        answerIndex = 1,
        explanation = "`heapify` uses a bottom-up sift-down approach. Even though there are n nodes, nodes near the bottom of the heap do very little work. The total work sums to O(n) — not O(n log n) as with repeated insertion."
    ),
    Problem(
        id = "trace_hard_57",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late binding in closures",
        summary = "A list of lambdas all capture the same loop variable by reference, not by value.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(4)]
            print(funcs[0](), funcs[2]())
        """.trimIndent(),
        options = listOf(
            "3 3",
            "0 2",
            "0 3",
            "1 3"
        ),
        answerIndex = 0,
        explanation = "All lambdas close over the same `i` variable. By the time they are called, the loop has finished and `i` is `3`. Every lambda returns `3` regardless of when it was created."
    ),
    Problem(
        id = "match_hard_57",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: Counter({'a': 2, 'b': 1})",
        summary = "Pick the snippet whose output is a Counter with exactly those counts.",
        prompt = "Which code produces this output?",
        code = "Counter({'a': 2, 'b': 1})",
        options = listOf(
            "from collections import Counter\nprint(Counter('aab'))",
            "print({'a': 2, 'b': 1})",
            "from collections import Counter\nprint(Counter(['a', 'b', 'b']))",
            "from collections import Counter\nprint(Counter(a=1, b=2))"
        ),
        answerIndex = 0,
        explanation = "`Counter('aab')` counts characters: 'a' appears twice, 'b' once, printing `Counter({'a': 2, 'b': 1})`. Option B prints a plain dict. Option C gives `Counter({'b': 2, 'a': 1})`. Option D gives `Counter({'b': 2, 'a': 1})`."
    )
)
