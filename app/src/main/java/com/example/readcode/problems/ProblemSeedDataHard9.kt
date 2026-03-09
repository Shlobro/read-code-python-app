package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems — batch 9. One problem per type.
// All problems target senior developers with 5+ years of Python experience.
val hardProblems9 = listOf(

    // ── FIND_BUG ──────────────────────────────────────────────────────────────

    Problem(
        id = "bug_hard_9",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread-safety race on class variable",
        summary = "Two threads increment a shared class-level counter without synchronisation.",
        prompt = "The developer expects `Counter.count` to be exactly 200 000 after both threads finish, but occasionally gets a lower value. What is the bug?",
        code = """
            import threading

            class Counter:
                count = 0

            def increment():
                for _ in range(100_000):
                    Counter.count += 1

            t1 = threading.Thread(target=increment)
            t2 = threading.Thread(target=increment)
            t1.start(); t2.start()
            t1.join();  t2.join()
            print(Counter.count)
        """.trimIndent(),
        options = listOf(
            "`+=` is not atomic: read-modify-write can interleave between threads, losing updates",
            "Class variables cannot be mutated from inside a function; use an instance variable instead",
            "Python threads run sequentially due to the GIL, so the result is always correct",
            "The bug is joining `t2` before `t1`; the join order must match the start order"
        ),
        answerIndex = 0,
        explanation = "`Counter.count += 1` compiles to three bytecode ops: LOAD, BINARY_ADD, STORE. The GIL can be released between any two ops, so one thread can read a stale value before the other thread's write lands. Fix: protect with a `threading.Lock` around the increment, or use `threading.local` if per-thread counts are acceptable."
    ),

    // ── OUTPUT ────────────────────────────────────────────────────────────────

    Problem(
        id = "output_hard_9",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__set_name__ descriptor hook",
        summary = "A descriptor uses `__set_name__` to record the attribute name it is assigned to.",
        prompt = "What does this script print?",
        code = """
            class Tracked:
                def __set_name__(self, owner, name):
                    self.public = name
                    self.private = "_" + name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.private, None)

                def __set__(self, obj, value):
                    setattr(obj, self.private, value)

            class Person:
                name = Tracked()
                age  = Tracked()

            p = Person()
            p.name = "Alice"
            p.age  = 30
            print(Person.name.public, Person.age.public)
            print(p.name, p.age)
        """.trimIndent(),
        options = listOf(
            "name age\nAlice 30",
            "name age\nNone None",
            "Alice 30\nAlice 30",
            "AttributeError"
        ),
        answerIndex = 0,
        explanation = "`__set_name__` is called by Python immediately after the class body is executed, passing the class and the attribute name. So `Person.name.public` is `'name'` and `Person.age.public` is `'age'`. The `__set__`/`__get__` pair stores and retrieves values on the instance under the private name (`_name`, `_age`), so `p.name` is `'Alice'` and `p.age` is `30`."
    ),

    // ── PURPOSE ───────────────────────────────────────────────────────────────

    Problem(
        id = "purpose_hard_9",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "asyncio.gather with exception handling",
        summary = "Multiple coroutines are awaited concurrently; one raises an exception.",
        prompt = "What problem does `return_exceptions=True` solve in this pattern?",
        code = """
            import asyncio

            async def fetch(url):
                if "bad" in url:
                    raise ValueError(f"bad url: {url}")
                return f"ok:{url}"

            async def main():
                results = await asyncio.gather(
                    fetch("good.com"),
                    fetch("bad.com"),
                    fetch("good2.com"),
                    return_exceptions=True,
                )
                for r in results:
                    if isinstance(r, Exception):
                        print("error:", r)
                    else:
                        print(r)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "Lets the caller collect successful results and exceptions in one list instead of having the first exception propagate immediately",
            "Retries each failed coroutine up to three times before giving up",
            "Runs the coroutines sequentially so an early failure can be handled before the next one starts",
            "Suppresses all exceptions silently so the caller never sees errors"
        ),
        answerIndex = 0,
        explanation = "With the default `return_exceptions=False`, `asyncio.gather` propagates the first raised exception to the awaiter instead of returning a normal results list. With `return_exceptions=True`, each coroutine's success value or exception object is placed at the corresponding index in the results list, so the caller can inspect every outcome in one pass."
    ),

    // ── FILL_BLANK ────────────────────────────────────────────────────────────

    Problem(
        id = "fill_hard_9",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "dataclass field with default_factory",
        summary = "A dataclass field needs a mutable default that is not shared across instances.",
        prompt = "Fill the blank so that each `Task` instance gets its own independent empty list for `tags`.",
        code = """
            from dataclasses import dataclass, ___

            @dataclass
            class Task:
                title: str
                tags: list = ___(default_factory=list)

            t1 = Task("deploy")
            t1.tags.append("urgent")
            t2 = Task("review")
            print(t2.tags)  # should print []
        """.trimIndent(),
        options = listOf("field", "Field", "default", "attribute"),
        answerIndex = 0,
        explanation = "`dataclasses.field(default_factory=list)` tells the dataclass machinery to call `list()` for each new instance, producing an independent empty list. Using `tags: list = []` directly would raise a `ValueError` because dataclasses forbid mutable defaults to prevent the shared-state bug."
    ),

    // ── ORDER_STEPS ───────────────────────────────────────────────────────────

    Problem(
        id = "order_hard_4",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the lines to implement Kahn's BFS-based topological sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph):",
            "    in_degree = {u: 0 for u in graph}",
            "    for u in graph:",
            "        for v in graph[u]:",
            "            in_degree[v] += 1",
            "    queue = [u for u in graph if in_degree[u] == 0]",
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
        explanation = "Kahn's algorithm: initialise in-degrees to zero, then count each edge; seed the queue with zero-in-degree nodes; repeatedly dequeue a node, append to order, decrement each neighbour's in-degree, and enqueue any neighbour whose in-degree drops to zero."
    ),

    // ── COMPLEXITY ────────────────────────────────────────────────────────────

    Problem(
        id = "complexity_hard_4",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive subset enumeration",
        summary = "A recursive function enumerates all subsets of a list.",
        prompt = "What is the time complexity of `subsets(lst)` with respect to n = len(lst)?",
        code = """
            def subsets(lst):
                if not lst:
                    return [[]]
                rest = subsets(lst[1:])
                return rest + [[lst[0]] + s for s in rest]
        """.trimIndent(),
        options = listOf(
            "O(2ⁿ) — each element independently doubles the number of subsets",
            "O(n²) — the list comprehension runs once per recursive level",
            "O(n log n) — the recursion halves the problem at each step",
            "O(n · 2ⁿ) — total work including copying each subset"
        ),
        answerIndex = 3,
        explanation = "There are 2ⁿ subsets. Building each subset requires copying it via `[lst[0]] + s`, which takes O(k) time for a subset of size k. Summing over all subsets gives Σ k·C(n,k) = n·2^(n-1), which is Θ(n·2ⁿ). Generating the full output is therefore O(n·2ⁿ), not merely O(2ⁿ)."
    ),

    // ── TRACE_VAR ─────────────────────────────────────────────────────────────

    Problem(
        id = "trace_hard_4",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Metaclass __call__ singleton",
        summary = "A metaclass overrides `__call__` to intercept instantiation and enforce a singleton pattern.",
        prompt = "What is the value of `a is b` after these lines execute?",
        code = """
            class SingletonMeta(type):
                _instances = {}

                def __call__(cls, *args, **kwargs):
                    if cls not in cls._instances:
                        cls._instances[cls] = super().__call__(*args, **kwargs)
                    return cls._instances[cls]

            class Config(metaclass=SingletonMeta):
                def __init__(self, value):
                    self.value = value

            a = Config(1)
            b = Config(2)
        """.trimIndent(),
        options = listOf("True", "False", "TypeError", "None"),
        answerIndex = 0,
        explanation = "`SingletonMeta.__call__` intercepts every instantiation of `Config`. On the first call, it creates the instance and stores it in `_instances`. On the second call, `cls` is already in `_instances`, so the stored object is returned without calling `__init__` again. Both `a` and `b` point to the same object, so `a is b` is `True`."
    ),

    // ── OUTPUT (additional) ───────────────────────────────────────────────────

    Problem(
        id = "match_hard_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__slots__ inheritance without redeclaration",
        summary = "Predict the output when a slotted base class is subclassed without redefining __slots__.",
        prompt = "What does this code print?",
        code = """
            class Base:
                __slots__ = ('x',)
                def __init__(self): self.x = 1

            class Child(Base):
                def __init__(self):
                    super().__init__()
                    self.y = 2

            c = Child()
            print(c.x, c.y)
        """.trimIndent(),
        options = listOf(
            "1 2",
            "AttributeError: 'Child' object has no attribute 'y'",
            "AttributeError: 'Child' object has no attribute 'x'",
            "1 2\nTypeError: __slots__ conflict"
        ),
        answerIndex = 0,
        explanation = "`Child` does not define `__slots__`, so it automatically gets a `__dict__`. This means `self.y = 2` is stored in `Child`'s `__dict__` without error. `self.x` is stored in `Base`'s slot. Both attributes are accessible, so the output is `1 2`. `__slots__` only prevents `__dict__` on the class that declares it; subclasses without their own `__slots__` still get `__dict__`."
    )
)
