package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 21.
// One senior-level problem per problem type.
val hardProblems21 = listOf(
    Problem(
        id = "bug_hard_22",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Shared retry state across decorators",
        summary = "Each decorated function unexpectedly burns through the same retry budget.",
        prompt = "What is the real bug in this decorator setup?",
        code = """
            def retry(limit, attempts={"count": 0}):
                def decorate(fn):
                    def wrapper(*args, **kwargs):
                        attempts["count"] += 1
                        if attempts["count"] > limit:
                            raise RuntimeError("too many attempts")
                        return fn(*args, **kwargs)
                    return wrapper
                return decorate
        """.trimIndent(),
        options = listOf(
            "The mutable default dictionary is shared across separate `retry(...)` decorator creations",
            "The wrapper must call `nonlocal attempts` before mutating the dictionary",
            "Decorators cannot accept positional arguments unless `functools.wraps` is used",
            "`attempts[\"count\"] += 1` resets the counter on every call instead of incrementing it"
        ),
        answerIndex = 0,
        explanation = "Default arguments are evaluated once at function definition time, so every call to `retry(limit)` reuses the same `attempts` dictionary and leaks state across decorators."
    ),
    Problem(
        id = "output_hard_22",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Class body name resolution",
        summary = "A comprehension inside the class body does not read the later class attribute.",
        prompt = "What does this code print?",
        code = """
            x = "global"

            class Demo:
                x = "class"
                values = [x for _ in range(2)]

            print(Demo.values)
        """.trimIndent(),
        options = listOf(
            "['class', 'class']",
            "['global', 'global']",
            "['Demo.x', 'Demo.x']",
            "A `NameError` is raised"
        ),
        answerIndex = 1,
        explanation = "In Python 3, the comprehension runs in its own scope and does not capture the surrounding class namespace, so `x` resolves to the module-level name."
    ),
    Problem(
        id = "purpose_hard_22",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Sweep line for concurrent intervals",
        summary = "Starts add one active interval, ends remove one after sorting timestamped events.",
        prompt = "What does this function compute?",
        code = """
            def peak_overlap(intervals):
                events = []
                for start, end in intervals:
                    events.append((start, 1))
                    events.append((end, -1))

                active = best = 0
                for _, delta in sorted(events, key=lambda item: (item[0], item[1])):
                    active += delta
                    if active > best:
                        best = active
                return best
        """.trimIndent(),
        options = listOf(
            "The total covered duration across all intervals",
            "The maximum number of intervals active at the same time",
            "The interval with the earliest finishing time",
            "The list of intervals merged into non-overlapping ranges"
        ),
        answerIndex = 1,
        explanation = "The function converts interval boundaries into +1/-1 events, sorts them, and tracks the maximum active count, which is the peak overlap."
    ),
    Problem(
        id = "fill_hard_22",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Mutating closure state",
        summary = "The inner function needs to update the binding from the enclosing function scope.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            def make_counter():
                count = 0

                def inc():
                    ___ count
                    count += 1
                    return count

                return inc
        """.trimIndent(),
        options = listOf("global", "nonlocal", "static", "self"),
        answerIndex = 1,
        explanation = "`nonlocal` tells Python that `count` lives in the nearest enclosing function scope, so the closure can rebind it instead of creating a new local variable."
    ),
    Problem(
        id = "order_hard_21",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Least-recently-used cache hit path",
        summary = "Arrange the core lines that promote a hit to the end of an `OrderedDict`-backed LRU cache.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import OrderedDict",
            "cache = OrderedDict()",
            "def read(key):",
            "    if key not in cache:",
            "        raise KeyError(key)",
            "    value = cache.pop(key)",
            "    cache[key] = value",
            "    return value"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "An `OrderedDict`-based LRU hit removes the key, reinserts it to mark it as most recently used, and then returns the value."
    ),
    Problem(
        id = "complexity_hard_21",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Heapify then pop k items",
        summary = "The code builds a heap once, then removes the smallest value `k` times.",
        prompt = "If `values` has length `n`, what is the time complexity?",
        code = """
            import heapq

            def smallest_k(values, k):
                heap = list(values)
                heapq.heapify(heap)
                out = []
                for _ in range(k):
                    out.append(heapq.heappop(heap))
                return out
        """.trimIndent(),
        options = listOf("O(n + k log n)", "O(k log k)", "O(n log n + k)", "O(nk)"),
        answerIndex = 0,
        explanation = "`heapify` is `O(n)`, and each of the `k` pops is `O(log n)`, so the overall cost is `O(n + k log n)`."
    ),
    Problem(
        id = "trace_hard_21",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Instance shadowing a non-data descriptor",
        summary = "Track what happens after a descriptor computes once and then stores a same-named attribute on the instance.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            class Lazy:
                def __init__(self, fn):
                    self.fn = fn

                def __get__(self, instance, owner):
                    if instance is None:
                        return self
                    value = self.fn(instance)
                    instance.payload = value
                    return value

            class Box:
                def __init__(self):
                    self.calls = 0

                @Lazy
                def payload(self):
                    self.calls += 1
                    return self.calls * 10

            box = Box()
            first = box.payload
            second = box.payload
            result = (first, second, box.calls)
        """.trimIndent(),
        options = listOf("(10, 10, 1)", "(10, 20, 2)", "(10, 10, 2)", "(1, 1, 10)"),
        answerIndex = 0,
        explanation = "Because `Lazy` defines only `__get__`, it is a non-data descriptor. After the first access stores `payload` on the instance, the instance attribute shadows the descriptor, so the second access reuses `10` and `calls` stays `1`."
    ),
    Problem(
        id = "match_hard_21",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: ['a', 'b', 'c']",
        summary = "Pick the snippet that consumes an iterator once per group instead of leaving grouped values lazily shared.",
        prompt = "Which code produces exactly `['a', 'b', 'c']`?",
        code = "",
        options = listOf(
            "from itertools import groupby\ntext = 'aaabbc'\nprint([key for key, _ in groupby(text)])",
            "from itertools import groupby\ntext = 'aaabbc'\nprint([list(group) for _, group in groupby(text)])",
            "from itertools import groupby\ntext = 'aaabbc'\nprint([next(group) for _, group in groupby(text)])",
            "from itertools import groupby\ntext = 'aaabbc'\nprint([key * len(list(group)) for key, group in groupby(text)])"
        ),
        answerIndex = 0,
        explanation = "Iterating over `groupby(text)` yields one `(key, group)` pair per run of identical characters. Collecting only the keys returns the run labels `['a', 'b', 'c']`."
    )
)
