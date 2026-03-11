package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 45.
// One senior-level problem per problem type.
val hardProblems45 = listOf(
    Problem(
        id = "bug_hard_46",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Cached mutable return value",
        summary = "A cached factory returns a mutable object that callers then mutate.",
        prompt = "What is the real bug in this code?",
        code = """
            from functools import lru_cache

            @lru_cache(maxsize=None)
            def build_headers():
                return {}

            first = build_headers()
            first["X-Trace"] = "1"

            second = build_headers()
            print(second)
        """.trimIndent(),
        options = listOf(
            "`lru_cache` cannot decorate a function unless it takes at least one argument",
            "The cache is bypassed because dictionaries are mutable",
            "The cached result is one shared mutable dict",
            "Returning an empty dict from a cached function raises `TypeError`"
        ),
        answerIndex = 2,
        explanation = "`lru_cache` stores and returns the exact same object for identical arguments. Because `build_headers()` takes no arguments, every call returns the same cached dict instance. Mutating `first` mutates the object later returned as `second`, so the function leaks shared state across callers."
    ),
    Problem(
        id = "output_hard_46",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Non-data descriptor precedence",
        summary = "An instance attribute competes with a descriptor defined on the class.",
        prompt = "What does this code print?",
        code = """
            class Token:
                def __get__(self, instance, owner):
                    return "descriptor"

            class Example:
                value = Token()

                def __init__(self):
                    self.value = "instance"

            print(Example().value)
        """.trimIndent(),
        options = listOf(
            "descriptor",
            "instance",
            "<__main__.Token object>",
            "AttributeError"
        ),
        answerIndex = 1,
        explanation = "`Token` defines only `__get__`, so it is a non-data descriptor. Instance attributes take precedence over non-data descriptors, so `self.value = \"instance\"` shadows the class-level descriptor and the code prints `instance`."
    ),
    Problem(
        id = "purpose_hard_46",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Weak-reference object pool",
        summary = "Objects are reused while alive, but the pool does not keep them alive on its own.",
        prompt = "What is this code primarily trying to achieve?",
        code = """
            import weakref

            class Connection:
                def __init__(self, name):
                    self.name = name

            pool = weakref.WeakValueDictionary()

            def get_connection(name):
                conn = pool.get(name)
                if conn is None:
                    conn = Connection(name)
                    pool[name] = conn
                return conn
        """.trimIndent(),
        options = listOf(
            "Reuse live connections without pinning them in memory",
            "Keep one permanent singleton `Connection` for every name ever requested",
            "Force each caller to build a brand-new `Connection`, even when one already exists",
            "Serialize `Connection` objects so different processes can share them"
        ),
        answerIndex = 0,
        explanation = "`WeakValueDictionary` holds weak references to its values. The pool can return an existing `Connection` while some other part of the program still holds it, but once no strong references remain, that entry disappears automatically. This is a memory-friendly reuse pattern rather than a permanent cache."
    ),
    Problem(
        id = "fill_hard_46",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Generator delegation",
        summary = "One keyword delegates iteration to another iterable.",
        prompt = "Which choice fills the blank so `list(stream())` becomes `['start', 'mid1', 'mid2', 'end']`?",
        code = """
            def stream():
                yield "start"
                ___ ["mid1", "mid2"]
                yield "end"
        """.trimIndent(),
        options = listOf(
            "yield",
            "return",
            "yield from",
            "await"
        ),
        answerIndex = 2,
        explanation = "`yield from` delegates to another iterable or generator, yielding each item it produces. A plain `yield` would emit the entire list as one element, `return` would stop the generator, and `await` is only valid in an async function."
    ),
    Problem(
        id = "order_hard_45",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache read path",
        summary = "Arrange the lines for a cache lookup that promotes hits and evicts the least-recently-used entry on overflow.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    value = cache.pop(key)",
            "if len(cache) > capacity:",
            "    cache.popitem(last=False)",
            "    return value",
            "cache[key] = value",
            "return value",
            "if key in cache:",
            "value = loader(key)",
            "    cache[key] = value"
        ),
        answerIndex = 0,
        correctOrder = listOf(6, 0, 8, 3, 7, 4, 1, 2, 5),
        explanation = "On a hit, remove and reinsert the entry so it becomes most recent, then return it immediately. On a miss, load the value, insert it, evict the oldest item if the cache is over capacity, and finally return the loaded value."
    ),
    Problem(
        id = "complexity_hard_45",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loops with moving pointers",
        summary = "The code has a nested loop, but both indices only move forward.",
        prompt = "Assume `values` is sorted. What is the worst-case time complexity?",
        code = """
            def count_groups(values):
                i = 0
                groups = 0
                while i < len(values):
                    j = i + 1
                    while j < len(values) and values[j] == values[i]:
                        j += 1
                    groups += 1
                    i = j
                return groups
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n)",
            "O(n log n)",
            "O(n²)"
        ),
        answerIndex = 1,
        explanation = "Although there is a nested `while`, `j` never moves backward and each element is visited at most a constant number of times across the whole run. After each inner scan, `i` jumps to `j`. That makes the total work linear in the length of `values`."
    ),
    Problem(
        id = "trace_hard_45",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shallow-copy aliasing",
        summary = "Two shallow copies still share the same nested list.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            template = {"ids": []}
            left = template.copy()
            right = dict(template)

            left["ids"].append(1)
            right["ids"].append(2)

            result = template["ids"]
        """.trimIndent(),
        options = listOf(
            "[]",
            "[1]",
            "[2]",
            "[1, 2]"
        ),
        answerIndex = 3,
        explanation = "Both `copy()` and `dict(template)` are shallow copies, so `template`, `left`, and `right` all reference the same inner list stored under `'ids'`. Appending through either copy mutates that shared nested list, leaving `result` as `[1, 2]`."
    ),
    Problem(
        id = "match_hard_45",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [0, 1, 2]",
        summary = "Pick the snippet that captures loop values correctly when building callables.",
        prompt = "Which code produces `[0, 1, 2]`?",
        code = "[0, 1, 2]",
        options = listOf(
            "funcs = [lambda i=i: i for i in range(3)]; print([f() for f in funcs])",
            "funcs = [lambda: i for i in range(3)]; print([fn() for fn in funcs])",
            "funcs = [lambda x: x for i in range(3)]; print([f(0) for f in funcs])",
            "funcs = [lambda: i * i for i in range(3)]; print([fn() for fn in funcs])"
        ),
        answerIndex = 0,
        explanation = "The default argument `i=i` captures the current loop value at each iteration, so the lambdas return 0, 1, and 2. Without that capture, the lambdas close over the same `i` variable and observe its final value after the loop completes."
    )
)
