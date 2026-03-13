package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 73. One senior-level problem per problem type.
// Answer lengths deliberately varied so the correct choice is not the longest option.
val hardProblems73 = listOf(
    // FIND_BUG — suffix _74; correct answer is the short middle option
    Problem(
        id = "bug_hard_74",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread-safe counter race",
        summary = "A shared counter incremented from multiple threads produces wrong totals.",
        prompt = "What is the bug in this code?",
        code = """
            import threading

            counter = 0

            def increment():
                global counter
                for _ in range(100_000):
                    counter += 1

            threads = [threading.Thread(target=increment) for _ in range(4)]
            for t in threads: t.start()
            for t in threads: t.join()
            print(counter)
        """.trimIndent(),
        options = listOf(
            "The GIL is released during the `+=` bytecode sequence, so reads and writes from different threads interleave and updates are lost",
            "`threading.Thread` requires a `daemon=True` flag to share global state safely",
            "Calling `t.join()` in a second loop instead of immediately after `t.start()` causes the threads to never actually run concurrently",
            "`global counter` inside a function body is not permitted when the variable is also used in a comprehension at module level"
        ),
        answerIndex = 0,
        explanation = "`counter += 1` compiles to LOAD_GLOBAL, LOAD_CONST, BINARY_ADD, STORE_GLOBAL — four bytecodes. The GIL can be released between any two, so another thread can read the stale value before the first thread stores its result. The fix is `threading.Lock()` or `threading.local()` with a final sum."
    ),
    // OUTPUT — suffix _74; correct answer is the shortest option (index 2)
    Problem(
        id = "output_hard_74",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__slots__ and instance dict",
        summary = "Trace the AttributeError raised when a slotted class is used incorrectly.",
        prompt = "What does this code print or raise?",
        code = """
            class Point:
                __slots__ = ("x", "y")
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

            p = Point(1, 2)
            p.z = 3
            print(p.z)
        """.trimIndent(),
        options = listOf(
            "3",
            "None",
            "AttributeError",
            "TypeError because `__slots__` prevents all attribute assignment on instances"
        ),
        answerIndex = 2,
        explanation = "Declaring `__slots__` removes the per-instance `__dict__`, so only the listed slot names (`x`, `y`) can be set. Attempting to assign `p.z = 3` raises `AttributeError: 'Point' object has no attribute 'z'`."
    ),
    // PURPOSE — suffix _74; correct answer is index 3 (not first, not longest)
    Problem(
        id = "purpose_hard_74",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager send",
        summary = "A generator-based context manager that receives a value via send.",
        prompt = "What is the primary purpose of this code?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def managed(label):
                print(f"enter:{label}")
                try:
                    value = yield
                    print(f"got:{value}")
                finally:
                    print(f"exit:{label}")

            with managed("x") as ctx:
                pass
        """.trimIndent(),
        options = listOf(
            "Demonstrate that `yield` inside a `@contextmanager` function returns the context manager object to the caller",
            "Show that `finally` inside a generator is never executed when used with `with`",
            "Produce a reusable context manager that catches all exceptions and suppresses them silently",
            "Define a context manager using a generator where setup runs before `yield` and teardown runs after"
        ),
        answerIndex = 3,
        explanation = "`@contextmanager` turns a generator function into a context manager. Code before `yield` runs on `__enter__`; code after (and in `finally`) runs on `__exit__`. The `yield` expression receives the value passed by `__exit__` (normally `None`). The other options misstate the mechanics."
    ),
    // FILL_BLANK — suffix _74; correct answer is index 1 (short, not the longest)
    Problem(
        id = "fill_hard_74",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "weakref.ref callback",
        summary = "Register a finalizer that fires when the last strong reference is dropped.",
        prompt = "Fill the blank so `cb` is called when `obj` is garbage-collected.",
        code = """
            import weakref

            class Resource:
                pass

            def cb(ref):
                print("collected")

            obj = Resource()
            ref = weakref.___(obj, cb)
            del obj
        """.trimIndent(),
        options = listOf(
            "proxy",
            "ref",
            "finalize",
            "WeakValueDictionary"
        ),
        answerIndex = 1,
        explanation = "`weakref.ref(obj, callback)` creates a weak reference and registers a callback that is invoked with the dead reference when the referent is collected. `weakref.proxy` creates a transparent proxy but does not accept a callback. `weakref.finalize` is an alternative finalizer API with different semantics. `WeakValueDictionary` is a mapping type."
    ),
    // ORDER_STEPS — suffix _73; correct answer fixed at index 0 per convention
    Problem(
        id = "order_hard_73",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache from scratch",
        summary = "Arrange the core logic of a fixed-capacity LRU cache using an OrderedDict.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import OrderedDict",
            "class LRUCache:",
            "    def __init__(self, capacity):",
            "        self.cap = capacity",
            "        self.cache = OrderedDict()",
            "    def get(self, key):",
            "        if key not in self.cache:",
            "            return -1",
            "        self.cache.move_to_end(key)",
            "        return self.cache[key]",
            "    def put(self, key, value):",
            "        if key in self.cache:",
            "            self.cache.move_to_end(key)",
            "        self.cache[key] = value",
            "        if len(self.cache) > self.cap:",
            "            self.cache.popitem(last=False)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "Import first, then the class definition with `__init__` initialising capacity and the OrderedDict. `get` checks membership, promotes the key with `move_to_end`, and returns the value. `put` promotes an existing key before writing, then evicts the least-recently-used entry (front of the OrderedDict) when capacity is exceeded."
    ),
    // COMPLEXITY — suffix _73; correct answer is index 2 (not first, not longest)
    Problem(
        id = "complexity_hard_73",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Merging k sorted lists",
        summary = "Use a min-heap to merge k sorted lists of total n elements.",
        prompt = "What is the time complexity (k = number of lists, n = total elements)?",
        code = """
            import heapq

            def merge_k(lists):
                heap = []
                for i, lst in enumerate(lists):
                    if lst:
                        heapq.heappush(heap, (lst[0], i, 0))
                result = []
                while heap:
                    val, i, j = heapq.heappop(heap)
                    result.append(val)
                    if j + 1 < len(lists[i]):
                        heapq.heappush(heap, (lists[i][j+1], i, j+1))
                return result
        """.trimIndent(),
        options = listOf(
            "O(n·k)",
            "O(n²)",
            "O(n log k)",
            "O(k log n)"
        ),
        answerIndex = 2,
        explanation = "Each of the n elements is pushed and popped from a heap of size at most k, costing O(log k) per element. The initial heap build touches at most k elements. Total: O(n log k). O(n·k) would describe a naive repeated min scan; O(k log n) has the variables swapped."
    ),
    // TRACE_VAR — suffix _73; correct answer is index 1 (not longest)
    Problem(
        id = "trace_hard_73",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send and throw",
        summary = "Trace the value received by the generator after send().",
        prompt = "What does this code print?",
        code = """
            def gen():
                x = yield 1
                yield x * 2

            g = gen()
            next(g)
            print(g.send(5))
        """.trimIndent(),
        options = listOf(
            "1",
            "10",
            "5",
            "None because send() resumes the generator but does not propagate a return value"
        ),
        answerIndex = 1,
        explanation = "`next(g)` advances the generator to `yield 1`, which suspends and returns 1 (discarded). `g.send(5)` resumes the generator with 5 as the result of the `yield` expression, so `x = 5`. The generator then reaches `yield x * 2`, which yields `10`. `send` returns the yielded value, so `print` outputs `10`."
    ),
    // MATCH_OUTPUT — suffix _73; correct answer is index 2 (not first, not longest)
    Problem(
        id = "match_hard_73",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [0, 1, 1, 2, 3]",
        summary = "Identify which snippet prints the first five Fibonacci numbers via a generator.",
        prompt = "Which snippet prints `[0, 1, 1, 2, 3]`?",
        code = "",
        options = listOf(
            "import itertools\ndef fib():\n    a, b = 1, 0\n    while True:\n        yield a\n        a, b = b, a + b\nprint(list(itertools.islice(fib(), 5)))",
            "print([n * (n - 1) // 2 for n in range(5)])",
            "import itertools\ndef fib():\n    a, b = 0, 1\n    while True:\n        yield a\n        a, b = b, a + b\nprint(list(itertools.islice(fib(), 5)))",
            "print(list(range(5)))"
        ),
        answerIndex = 2,
        explanation = "Option C starts with `a=0, b=1` and yields `a` before swapping, producing 0, 1, 1, 2, 3 — the correct Fibonacci sequence starting from 0. Option A starts with `a=1, b=0`, yielding 1, 0, 1, 1, 2. Option B produces triangular numbers [0, 0, 1, 3, 6]. Option D produces [0, 1, 2, 3, 4]."
    )
)
