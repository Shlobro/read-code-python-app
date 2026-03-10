package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 26.
// One senior-level problem per problem type.
val hardProblems26 = listOf(
    Problem(
        id = "bug_hard_27",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor shadowed by instance dict",
        summary = "A data descriptor is being silently overridden.",
        prompt = "What is the real bug in this code?",
        code = """
            class Validated:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.name)

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError("int required")
                    obj.__dict__[self.name] = value

            class Record:
                x = Validated()

            r = Record()
            r.__dict__["x"] = "oops"
            print(r.x)
        """.trimIndent(),
        options = listOf(
            "`__get__` delegates directly to `obj.__dict__`, so a direct `__dict__` write bypasses `__set__` and returns the raw string",
            "`__set_name__` is only called when the class body is executed; assigning to `r.__dict__` re-triggers it",
            "Data descriptors always take priority over `obj.__dict__`, so the assignment is silently ignored",
            "`__dict__` is read-only on instances that define a descriptor; the assignment raises `AttributeError`"
        ),
        answerIndex = 0,
        explanation = "A data descriptor controls access *through the normal attribute lookup path*. Here `__get__` is implemented by reading `obj.__dict__` directly, so a direct `obj.__dict__['x'] = 'oops'` write short-circuits the descriptor entirely. The fix is to use a private storage key (e.g. `_x`) in `__dict__` so the descriptor's `__get__` is the only path to the public name."
    ),
    Problem(
        id = "output_hard_27",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook order",
        summary = "A base-class hook fires for every subclass, including indirect ones.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def __init_subclass__(cls, tag="?", **kw):
                    super().__init_subclass__(**kw)
                    print(f"{cls.__name__}:{tag}")

            class A(Base, tag="a"):
                pass

            class B(A, tag="b"):
                pass

            class C(Base):
                pass
        """.trimIndent(),
        options = listOf(
            "A:a\nB:b\nC:?",
            "A:a\nC:?",
            "B:b\nC:?",
            "A:a\nB:b"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called on the *immediate* base class whenever a subclass is created. When `A` is defined, `Base.__init_subclass__` fires with `tag='a'`. When `B` is defined, the MRO calls `Base.__init_subclass__` (via `A`) with `tag='b'`. When `C` is defined, it uses the default `tag='?'`. The output is A:a, B:b, C:?."
    ),
    Problem(
        id = "purpose_hard_27",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Copy-on-write proxy",
        summary = "A class transparently wraps a mapping and defers mutations.",
        prompt = "What is the primary design pattern implemented here?",
        code = """
            class COWDict:
                def __init__(self, base):
                    self._base = base
                    self._overlay = None

                def _ensure_overlay(self):
                    if self._overlay is None:
                        self._overlay = {}

                def __getitem__(self, key):
                    if self._overlay and key in self._overlay:
                        return self._overlay[key]
                    return self._base[key]

                def __setitem__(self, key, value):
                    self._ensure_overlay()
                    self._overlay[key] = value

                def __delitem__(self, key):
                    self._ensure_overlay()
                    self._overlay[key] = None  # tombstone
        """.trimIndent(),
        options = listOf(
            "Copy-on-write: reads fall through to the base mapping; writes go to a lazy overlay so the original is never modified",
            "Proxy pattern: every read and write is forwarded unchanged to the base mapping",
            "Flyweight pattern: multiple COWDict instances share a single base to reduce memory",
            "Observer pattern: mutations are logged in the overlay so subscribers can replay them"
        ),
        answerIndex = 0,
        explanation = "`__getitem__` checks the overlay first and falls back to the base, while `__setitem__` only ever touches the lazily-created overlay. The base mapping is never mutated, which is the defining property of copy-on-write."
    ),
    Problem(
        id = "fill_hard_27",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Weakref callback cleanup",
        summary = "A registry should not prevent garbage collection of its values.",
        prompt = "Which choice fills the blank so the registry holds weak references to its values?",
        code = """
            import weakref

            class Registry:
                def __init__(self):
                    self._store = weakref.___()

                def register(self, key, obj):
                    self._store[key] = obj

                def get(self, key):
                    return self._store.get(key)
        """.trimIndent(),
        options = listOf(
            "WeakValueDictionary",
            "WeakKeyDictionary",
            "ref",
            "finalize"
        ),
        answerIndex = 0,
        explanation = "`weakref.WeakValueDictionary` stores weak references to its *values*. When no other strong reference keeps an object alive the entry is automatically removed. `WeakKeyDictionary` holds weak references to keys instead, which is wrong here. `ref` and `finalize` are not dict-like containers."
    ),
    Problem(
        id = "order_hard_26",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange a correct BFS-based topological sort using an in-degree table.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph):",
            "    in_degree = {u: 0 for u in graph}",
            "    for u in graph:",
            "        for v in graph[u]:",
            "            in_degree[v] += 1",
            "    queue = [u for u in in_degree if in_degree[u] == 0]",
            "    order = []",
            "    while queue:",
            "        u = queue.pop(0)",
            "        order.append(u)",
            "        for v in graph[u]:",
            "            in_degree[v] -= 1",
            "            if in_degree[v] == 0:",
            "                queue.append(v)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
        explanation = "Kahn's algorithm: build an in-degree table, seed the queue with zero-in-degree nodes, then repeatedly dequeue a node, append it to the result, and decrement the in-degree of its neighbours—adding any that reach zero to the queue."
    ),
    Problem(
        id = "complexity_hard_26",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Interleaved nested loops with early exit",
        summary = "An inner loop bound depends on the outer variable, but a break limits its depth.",
        prompt = "What is the worst-case time complexity of `find_pair`?",
        code = """
            def find_pair(nums, target):
                n = len(nums)
                for i in range(n):
                    for j in range(i + 1, n):
                        if nums[i] + nums[j] == target:
                            return (i, j)
                return None
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n log n)", "O(n)", "O(n^3)"),
        answerIndex = 0,
        explanation = "In the worst case the target is absent or appears at the last pair. The inner loop runs n-1, n-2, … 1 times, giving n*(n-1)/2 iterations — O(n²). The early return doesn't change the worst-case bound."
    ),
    Problem(
        id = "trace_hard_26",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() protocol",
        summary = "Values injected via send() replace the yield expression inside the generator.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def accumulator():
                total = 0
                while True:
                    value = yield total
                    if value is None:
                        break
                    total += value

            gen = accumulator()
            next(gen)          # prime
            gen.send(10)
            gen.send(5)
            result = gen.send(20)
        """.trimIndent(),
        options = listOf(
            "35",
            "20",
            "15",
            "0"
        ),
        answerIndex = 0,
        explanation = "`next(gen)` primes the generator; total=0, yielded value is 0. `send(10)` resumes with value=10, total becomes 10, yields 10. `send(5)` resumes with value=5, total becomes 15, yields 15. `send(20)` resumes with value=20, total becomes 35, yields 35. So `result` is 35."
    ),
    Problem(
        id = "match_hard_26",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n{'a': [1, 3], 'b': [2]}",
        summary = "Pick the snippet that groups a list of pairs into a dict of lists.",
        prompt = "Which code produces exactly this output?",
        code = "{'a': [1, 3], 'b': [2]}",
        options = listOf(
            "from collections import defaultdict\npairs = [('a',1),('b',2),('a',3)]\nd = defaultdict(list)\nfor k,v in pairs:\n    d[k].append(v)\nprint(dict(d))",
            "pairs = [('a',1),('b',2),('a',3)]\nprint({k: v for k, v in pairs})",
            "pairs = [('a',1),('b',2),('a',3)]\nd = {}\nfor k,v in pairs:\n    d[k] = v\nprint(d)",
            "print(dict(a=[1],b=[2],a=[3]))"
        ),
        answerIndex = 0,
        explanation = "`defaultdict(list)` creates a list on first access for each key, so both `('a',1)` and `('a',3)` are appended to `d['a']`, yielding `{'a': [1, 3], 'b': [2]}`. Option B and C overwrite the key on the second 'a' pair. Option D is a syntax error (duplicate keyword argument)."
    )
)
