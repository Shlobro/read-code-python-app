package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 61.
// One senior-level problem per problem type.
val hardProblems61 = listOf(
    Problem(
        id = "bug_hard_62",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread race on shared counter",
        summary = "An unguarded read-modify-write on a shared integer is not atomic in CPython.",
        prompt = "What is the bug in this code?",
        code = """
            import threading

            counter = 0

            def increment():
                global counter
                for _ in range(100_000):
                    counter += 1

            threads = [threading.Thread(target=increment) for _ in range(5)]
            for t in threads: t.start()
            for t in threads: t.join()
            print(counter)
        """.trimIndent(),
        options = listOf(
            "The GIL guarantees atomic increments, so the final value is always 500000",
            "`global counter` inside a thread raises `RuntimeError` because globals are read-only in threads",
            "`counter += 1` is not atomic; concurrent threads can read the same value and both write back, losing increments",
            "Joining all threads before starting them causes a deadlock"
        ),
        answerIndex = 2,
        explanation = "Although the GIL prevents true simultaneous bytecode execution, `counter += 1` compiles to LOAD_GLOBAL / BINARY_ADD / STORE_GLOBAL — three steps. A thread switch can occur between them, causing lost updates. Use `threading.Lock` to guard the increment."
    ),
    Problem(
        id = "output_hard_62",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "`__init_subclass__` hook",
        summary = "`__init_subclass__` is called on the base class each time a subclass is defined.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def __init_subclass__(cls, tag="none", **kwargs):
                    super().__init_subclass__(**kwargs)
                    print(tag)

            class Alpha(Base, tag="alpha"):
                pass

            class Beta(Base):
                pass
        """.trimIndent(),
        options = listOf(
            "alpha\nnone",
            "none\nalpha",
            "alpha",
            "none"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is invoked on `Base` once for each subclass definition, in source order. `Alpha` passes `tag='alpha'`, printing `alpha`. `Beta` passes no keyword, so the default `'none'` is used, printing `none`."
    ),
    Problem(
        id = "purpose_hard_62",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Non-reentrant lock guard decorator",
        summary = "A decorator wraps each method call with a per-instance lock acquisition.",
        prompt = "What does this decorator do?",
        code = """
            import threading
            import functools

            def synchronized(method):
                @functools.wraps(method)
                def wrapper(self, *args, **kwargs):
                    with self._lock:
                        return method(self, *args, **kwargs)
                return wrapper
        """.trimIndent(),
        options = listOf(
            "Serialises calls to the decorated method using the instance's `_lock`",
            "Creates a new thread for each method call and waits for it to finish",
            "Retries the method up to three times if it raises an exception",
            "Caches the method result so it only executes once per instance"
        ),
        answerIndex = 0,
        explanation = "The wrapper acquires `self._lock` before calling the original method and releases it on exit. Any concurrent caller trying to enter a `synchronized` method on the same instance will block until the lock is free, serialising access."
    ),
    Problem(
        id = "fill_hard_62",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Sentinel default with `object()`",
        summary = "A unique sentinel distinguishes an explicitly passed `None` from a missing argument.",
        prompt = "Fill the blank so that passing `None` explicitly is detected correctly.",
        code = """
            _MISSING = object()

            def get(mapping, key, default=___):
                value = mapping.get(key, _MISSING)
                if value is _MISSING:
                    return default
                return value
        """.trimIndent(),
        options = listOf(
            "_MISSING",
            "None",
            "False",
            "object()"
        ),
        answerIndex = 0,
        explanation = "Using `_MISSING` as the default lets callers pass `None` explicitly without triggering the fallback. A fresh `object()` in the default position would create a *different* sentinel on each call, so `value is default` would never be true. Sharing the module-level `_MISSING` ensures the identity check works correctly."
    ),
    Problem(
        id = "order_hard_61",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Depth-first search (iterative)",
        summary = "Arrange the lines of an iterative DFS using an explicit stack.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "visited = set()",
            "stack = [start]",
            "while stack:",
            "    node = stack.pop()",
            "    if node in visited: continue",
            "    visited.add(node)",
            "    stack.extend(graph[node])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Initialise the visited set and push the start node. Each iteration pops a node, skips it if already visited, marks it visited, then pushes all its neighbours. The `continue` guard prevents re-processing nodes reached via multiple paths."
    ),
    Problem(
        id = "complexity_hard_61",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Segment tree range-sum query",
        summary = "A segment tree answers range-sum queries by visiting O(log n) nodes.",
        prompt = "What is the time complexity of a single `query` call?",
        code = """
            def query(tree, node, node_l, node_r, q_l, q_r):
                if q_r < node_l or node_r < q_l:
                    return 0
                if q_l <= node_l and node_r <= q_r:
                    return tree[node]
                mid = (node_l + node_r) // 2
                left = query(tree, 2*node,   node_l, mid,    q_l, q_r)
                right = query(tree, 2*node+1, mid+1, node_r, q_l, q_r)
                return left + right
        """.trimIndent(),
        options = listOf(
            "O(log n)",
            "O(n)",
            "O(n log n)",
            "O(sqrt(n))"
        ),
        answerIndex = 0,
        explanation = "A segment tree has O(log n) levels. At each level the query visits at most 4 nodes; ranges outside the query return immediately (O(1)), and ranges fully inside return their stored sum (O(1)). The total work per query is therefore O(log n)."
    ),
    Problem(
        id = "trace_hard_61",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator `send()` value injection",
        summary = "`send()` resumes a generator and delivers a value to the `yield` expression.",
        prompt = "What does this code print?",
        code = """
            def accumulator():
                total = 0
                while True:
                    value = yield total
                    total += value

            g = accumulator()
            next(g)
            print(g.send(10))
            print(g.send(5))
        """.trimIndent(),
        options = listOf(
            "10\n15",
            "0\n10",
            "10\n10",
            "0\n15"
        ),
        answerIndex = 0,
        explanation = "`next(g)` starts the generator and runs to the first `yield total`, yielding 0 (discarded). `g.send(10)` injects 10 as the value of `yield`, so `value = 10`, `total` becomes 10, and the generator yields `total` (10). `g.send(5)` injects 5, `total` becomes 15, yielding 15."
    ),
    Problem(
        id = "match_hard_61",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {1: 'a', 2: 'b'}",
        summary = "Pick the snippet whose print output is exactly `{1: 'a', 2: 'b'}`.",
        prompt = "Which code produces this output?",
        code = "{1: 'a', 2: 'b'}",
        options = listOf(
            "print({k: v for k, v in enumerate('ab', 1)})",
            "print(dict(zip([1,2],['b','a'])))",
            "print({k: v for k, v in enumerate('ab')})",
            "print(dict([(0,'a'),(1,'b')]))"
        ),
        answerIndex = 0,
        explanation = "`enumerate('ab', 1)` yields `(1,'a')` and `(2,'b')`, so the comprehension produces `{1: 'a', 2: 'b'}`. Option B swaps the values, giving `{1: 'b', 2: 'a'}`. Option C uses the default start of 0: `{0: 'a', 1: 'b'}`. Option D uses 0-based indices: `{0: 'a', 1: 'b'}`."
    )
)
