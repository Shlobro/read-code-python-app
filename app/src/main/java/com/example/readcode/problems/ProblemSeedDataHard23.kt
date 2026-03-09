package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 23.
// One senior-level problem per problem type.
val hardProblems23 = listOf(
    Problem(
        id = "bug_hard_24",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Heap tie-breaker crash",
        summary = "A priority queue works until two items share the same priority.",
        prompt = "What is the real bug in this code?",
        code = """
            import heapq

            heap = []

            def push_task(priority, task):
                heapq.heappush(heap, (priority, task))

            push_task(1, {"name": "backup"})
            push_task(1, {"name": "cleanup"})
            print(heapq.heappop(heap))
        """.trimIndent(),
        options = listOf(
            "Equal priorities force `heapq` to compare the dictionaries, which raises `TypeError` in Python 3",
            "A heap cannot store tuples whose second element is mutable",
            "`heappop` must be called before inserting a second item with the same priority",
            "The bug is only that the dictionary keys should be sorted before insertion"
        ),
        answerIndex = 0,
        explanation = "When priorities tie, tuple comparison falls through to the second element. Python 3 cannot order dictionaries, so the second `heappush` fails unless a comparable tie-breaker is included."
    ),
    Problem(
        id = "output_hard_24",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor precedence",
        summary = "An instance attribute tries to shadow a property without a setter.",
        prompt = "What does this code print?",
        code = """
            class Config:
                @property
                def mode(self):
                    return "class"

            cfg = Config()
            cfg.__dict__["mode"] = "instance"
            print(cfg.mode)
        """.trimIndent(),
        options = listOf("class", "instance", "{'mode': 'instance'}", "AttributeError"),
        answerIndex = 0,
        explanation = "A `property` is a data descriptor, so it takes precedence over the instance dictionary on attribute lookup. Reading `cfg.mode` still calls the property's getter."
    ),
    Problem(
        id = "purpose_hard_24",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Stable top-k stream",
        summary = "The function keeps only the best `k` scored items while preserving their original arrival order in the result.",
        prompt = "What does this function compute?",
        code = """
            import heapq

            def top_k_stable(items, k):
                heap = []
                for index, (score, value) in enumerate(items):
                    entry = (score, index, value)
                    if len(heap) < k:
                        heapq.heappush(heap, entry)
                    elif entry > heap[0]:
                        heapq.heapreplace(heap, entry)
                return [value for _, _, value in sorted(heap, key=lambda row: row[1])]
        """.trimIndent(),
        options = listOf(
            "The first `k` items from the stream, unchanged",
            "The `k` highest-scoring items, returned in original input order",
            "All items sorted by score descending",
            "A deduplicated list of values with the highest score per index"
        ),
        answerIndex = 1,
        explanation = "The min-heap keeps the best `k` `(score, index, value)` tuples seen so far, and the final sort by index restores original arrival order among the retained items."
    ),
    Problem(
        id = "fill_hard_24",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Weak-reference instance cache",
        summary = "The cache should avoid preventing garbage collection of values that are no longer referenced elsewhere.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            import weakref

            class Loader:
                def __init__(self):
                    self.cache = ___()
        """.trimIndent(),
        options = listOf(
            "weakref.WeakValueDictionary",
            "weakref.WeakSet",
            "weakref.finalize",
            "weakref.proxy"
        ),
        answerIndex = 0,
        explanation = "`WeakValueDictionary` stores values by weak reference, so cached objects disappear automatically once no strong references remain elsewhere."
    ),
    Problem(
        id = "order_hard_23",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Context-managed timing wrapper",
        summary = "Arrange a reusable context manager that records elapsed time even when the body raises.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from contextlib import contextmanager",
            "import time",
            "@contextmanager",
            "def record_duration(store, label):",
            "    start = time.perf_counter()",
            "    try:",
            "        yield",
            "    finally:",
            "        store[label] = time.perf_counter() - start"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        explanation = "The imports come first, then the decorator and function definition. The context manager records the start time, yields to the wrapped block, and stores elapsed time in `finally` so cleanup runs even on failure."
    ),
    Problem(
        id = "complexity_hard_23",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Union-find with path compression",
        summary = "The recursion flattens parent pointers as it walks toward the root.",
        prompt = "What is the amortized time complexity of `find(x)` over a long sequence of operations?",
        code = """
            def find(parent, x):
                if parent[x] != x:
                    parent[x] = find(parent, parent[x])
                return parent[x]
        """.trimIndent(),
        options = listOf("Near O(1), more precisely O(alpha(n)) amortized", "O(log n) amortized", "O(sqrt(n)) amortized", "O(n) amortized"),
        answerIndex = 0,
        explanation = "With path compression in a disjoint-set structure, `find` is amortized inverse-Ackermann time, which is effectively constant for practical input sizes."
    ),
    Problem(
        id = "trace_hard_23",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Closure cell reuse in a loop",
        summary = "Track what the captured loop variable actually becomes by the time the lambdas execute.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)

            result = [fn() for fn in funcs]
        """.trimIndent(),
        options = listOf(
            "[2, 2, 2]",
            "[0, 1, 2]",
            "[0, 0, 0]",
            "It raises `NameError` because `i` is out of scope"
        ),
        answerIndex = 0,
        explanation = "Each lambda closes over the same cell for `i`, and the loop leaves that cell at `2`. All three calls read the final value."
    ),
    Problem(
        id = "match_hard_23",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\nstart\ncleanup\nouter",
        summary = "Pick the snippet where a generator's `finally` block runs when iteration stops early.",
        prompt = "Which code produces exactly this output?",
        code = """
            start
            cleanup
            outer
        """.trimIndent(),
        options = listOf(
            "def stream():\n    try:\n        yield 'start'\n        yield 'middle'\n    finally:\n        print('cleanup')\n\nfor value in stream():\n    print(value)\n    break\nprint('outer')",
            "def stream():\n    yield 'start'\n    print('cleanup')\n\ngen = stream()\nprint(next(gen))\nprint('outer')",
            "try:\n    print('start')\nfinally:\n    print('cleanup')\nprint('outer')",
            "def stream():\n    try:\n        yield 'start'\n    finally:\n        print('cleanup')\n\ngen = stream()\nprint('outer')"
        ),
        answerIndex = 0,
        explanation = "Breaking out of the `for` loop closes the generator, which runs its `finally` block before the code after the loop prints `outer`."
    )
)
