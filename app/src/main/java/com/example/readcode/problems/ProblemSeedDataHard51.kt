package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 51.
// One senior-level problem per problem type.
val hardProblems51 = listOf(
    Problem(
        id = "bug_hard_52",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Finalizer that keeps the object alive",
        summary = "A weakref finalizer is registered with a bound method from the same instance.",
        prompt = "What is the actual bug here?",
        code = """
            from weakref import finalize

            class Session:
                def __init__(self, name):
                    self.name = name
                    self._cleanup = finalize(self, self.close)

                def close(self):
                    print("closing", self.name)
        """.trimIndent(),
        options = listOf(
            "The finalizer stores a bound method that still references `self`",
            "`finalize` can only call top-level functions",
            "The instance must define `__del__` before using `finalize`",
            "`close` should return a boolean so the finalizer knows it succeeded"
        ),
        answerIndex = 0,
        explanation = "A bound method closes over the instance, so `self.close` keeps `self` reachable. That defeats the weak-reference cleanup pattern because the finalizer callback itself prolongs the object's lifetime."
    ),
    Problem(
        id = "output_hard_52",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Context variable reset",
        summary = "A context variable is changed, read, then restored with its token.",
        prompt = "What does this code print?",
        code = """
            from contextvars import ContextVar

            current = ContextVar("current", default="root")
            token = current.set("request")
            print(current.get())
            current.reset(token)
            print(current.get())
        """.trimIndent(),
        options = listOf(
            "request\nrequest",
            "root\nrequest",
            "request\nroot",
            "root\nroot"
        ),
        answerIndex = 2,
        explanation = "After `set`, the current value is `request`. Resetting with the returned token restores the previous value, which falls back to the default `root`."
    ),
    Problem(
        id = "purpose_hard_52",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Single-dispatch registration",
        summary = "The decorator registers specialized implementations by argument type.",
        prompt = "What does this code do overall?",
        code = """
            from functools import singledispatch

            @singledispatch
            def render(value):
                return "?"

            @render.register
            def _(value: int):
                return "int"

            @render.register
            def _(value: list):
                return "list"
        """.trimIndent(),
        options = listOf(
            "It memoizes `render` results for ints and lists",
            "It routes calls to different implementations based on the first argument's type",
            "It converts any input into either an int or a list before rendering",
            "It enforces runtime type checking and raises if annotations do not match"
        ),
        answerIndex = 1,
        explanation = "`@singledispatch` creates a generic function. The registered implementations are selected from the runtime type of the first positional argument."
    ),
    Problem(
        id = "fill_hard_52",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Delegating a generator",
        summary = "The outer generator should yield every item from the inner iterable without an explicit loop.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            def outer():
                ___ range(3)
        """.trimIndent(),
        options = listOf(
            "return",
            "await",
            "yield from",
            "yield"
        ),
        answerIndex = 2,
        explanation = "`yield from range(3)` delegates iteration to the inner iterable and yields `0`, `1`, and `2` from the outer generator."
    ),
    Problem(
        id = "order_hard_51",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Class registry via __init_subclass__",
        summary = "Arrange the lines to build a base class that automatically records each subclass by name.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "class PluginBase:",
            "    registry = {}",
            "    def __init_subclass__(cls, **kwargs):",
            "        super().__init_subclass__(**kwargs)",
            "        PluginBase.registry[cls.__name__] = cls"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "Define the base class, create the shared registry, override `__init_subclass__`, delegate to `super()`, then record the new subclass in the registry."
    ),
    Problem(
        id = "complexity_hard_51",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Heap once, then bounded pops",
        summary = "The code heapifies the input and removes up to `k` smallest values.",
        prompt = "If `values` has length `n` and `k <= n`, what is the worst-case time complexity?",
        code = """
            import heapq

            def smallest_k(values, k):
                heapq.heapify(values)
                out = []
                for _ in range(k):
                    out.append(heapq.heappop(values))
                return out
        """.trimIndent(),
        options = listOf(
            "O(k log n)",
            "O(n + k log n)",
            "O(n log k)",
            "O(nk)"
        ),
        answerIndex = 1,
        explanation = "`heapify` costs O(n). Each of the `k` heap pops costs O(log n), so the full worst-case cost is O(n + k log n)."
    ),
    Problem(
        id = "trace_hard_51",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late binding versus captured default",
        summary = "One closure reads the final loop variable; the other captures each value immediately.",
        prompt = "What is the value of `results` after this code runs?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)
                funcs.append(lambda i=i: i)

            results = [f() for f in funcs]
        """.trimIndent(),
        options = listOf(
            "[0, 0, 1, 1, 2, 2]",
            "[2, 0, 2, 1, 2, 2]",
            "[2, 2, 2, 0, 1, 2]",
            "[0, 2, 1, 2, 2, 2]"
        ),
        answerIndex = 1,
        explanation = "The plain lambdas close over the same `i`, which is `2` after the loop. The default-argument lambdas capture the current value at definition time, producing `0`, `1`, and `2`."
    ),
    Problem(
        id = "match_hard_51",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [('a', 2), ('b', 1)]",
        summary = "Pick the snippet that counts items by first character and preserves a deterministic printed order.",
        prompt = "Which code produces this output?",
        code = "[('a', 2), ('b', 1)]",
        options = listOf(
            "counts = {}; [counts.setdefault(word[0], 0) + 1 for word in [\"ant\", \"ape\", \"bat\"]]; print(sorted(counts.items()))",
            "counts = {}; [counts.__setitem__(word[0], counts.get(word[0], 0) + 1) for word in [\"ant\", \"ape\", \"bat\"]]; print(counts.items())",
            "counts = {}; [counts.__setitem__(word[0], counts.get(word[0], 0) + 1) for word in [\"ant\", \"ape\", \"bat\"]]; print(sorted(counts.items()))",
            "counts = {}; [counts.__setitem__(word, counts.get(word, 0) + 1) for word in [\"ant\", \"ape\", \"bat\"]]; print(sorted(counts.items()))"
        ),
        answerIndex = 2,
        explanation = "Only the third snippet counts by `word[0]` and sorts the final `(key, count)` pairs before printing, which yields `[('a', 2), ('b', 1)]`."
    )
)
