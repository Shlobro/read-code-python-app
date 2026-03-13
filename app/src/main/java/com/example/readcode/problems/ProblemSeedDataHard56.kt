package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 56.
// One senior-level problem per problem type.
val hardProblems56 = listOf(
    Problem(
        id = "bug_hard_57",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Generator exhaustion in loop",
        summary = "A generator is consumed in a nested context and silently yields nothing on the second pass.",
        prompt = "What is the actual bug here?",
        code = """
            def evens(n):
                return (x for x in range(n) if x % 2 == 0)

            gen = evens(10)
            total1 = sum(gen)
            total2 = sum(gen)
            print(total1, total2)
        """.trimIndent(),
        options = listOf(
            "Generator is re-evaluated each call to `sum`",
            "Generator is exhausted after `total1`, so `total2` is 0",
            "`range` does not support even filtering with modulo",
            "`sum` raises `TypeError` on a generator expression"
        ),
        answerIndex = 1,
        explanation = "A generator is a one-shot iterator. After `sum(gen)` consumes all values, the generator is exhausted and `sum(gen)` on the same object yields `0`. The fix is to call `evens(10)` twice or convert to a list."
    ),
    Problem(
        id = "output_hard_57",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "`__init_subclass__` with keyword arguments",
        summary = "A base class hook receives keyword arguments forwarded from subclass definitions.",
        prompt = "What does this code print?",
        code = """
            class Plugin:
                def __init_subclass__(cls, name="unnamed", **kwargs):
                    super().__init_subclass__(**kwargs)
                    cls.plugin_name = name

            class Auth(Plugin, name="auth"): pass
            class Cache(Plugin): pass

            print(Auth.plugin_name, Cache.plugin_name)
        """.trimIndent(),
        options = listOf(
            "auth unnamed",
            "Auth Cache",
            "unnamed unnamed",
            "auth auth"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` receives the keyword argument `name=\"auth\"` from `Auth`'s class definition and defaults to `\"unnamed\"` for `Cache`. Each subclass gets its own `plugin_name` class attribute."
    ),
    Problem(
        id = "purpose_hard_57",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Decorator that preserves signature",
        summary = "A wrapper function copies metadata from the wrapped function to avoid losing introspection data.",
        prompt = "What does this decorator do overall?",
        code = """
            import functools

            def logged(fn):
                @functools.wraps(fn)
                def wrapper(*args, **kwargs):
                    print(f"calling {fn.__name__}")
                    return fn(*args, **kwargs)
                return wrapper
        """.trimIndent(),
        options = listOf(
            "It times each function call and raises on slow calls",
            "It logs the call and preserves the original function's metadata",
            "It prevents any decorated function from being called more than once",
            "It replaces the function with a lambda that ignores all arguments"
        ),
        answerIndex = 1,
        explanation = "`functools.wraps` copies `__name__`, `__doc__`, `__annotations__`, and other metadata from `fn` onto `wrapper`. Without it, introspection tools would see the wrapper's identity instead of the original function's."
    ),
    Problem(
        id = "fill_hard_57",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Abstract method enforcement",
        summary = "A base class must prevent instantiation unless subclasses implement a required method.",
        prompt = "Which choice fills the blank so `process` must be overridden in every subclass?",
        code = """
            from abc import ABC, ___

            class Handler(ABC):
                @abstractmethod
                def process(self, data): ...
        """.trimIndent(),
        options = listOf(
            "abstractmethod",
            "override",
            "abstractproperty",
            "virtual"
        ),
        answerIndex = 0,
        explanation = "`abc.abstractmethod` marks a method so that any class that inherits `Handler` without overriding `process` cannot be instantiated. `ABC` pairs with `abstractmethod` — the other options do not exist in `abc`."
    ),
    Problem(
        id = "order_hard_56",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the core body of an iterative merge of two sorted lists into one.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "result = []",
            "i = j = 0",
            "while i < len(a) and j < len(b):",
            "    if a[i] <= b[j]: result.append(a[i]); i += 1",
            "    else: result.append(b[j]); j += 1",
            "result.extend(a[i:])",
            "result.extend(b[j:])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Initialize the output and two pointers, advance through both lists comparing elements, then append any remaining tail from whichever list is not yet exhausted."
    ),
    Problem(
        id = "complexity_hard_56",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Iterative DFS with explicit stack",
        summary = "A depth-first search over a graph with V vertices and E edges uses an explicit stack.",
        prompt = "What is the time complexity?",
        code = """
            def dfs(graph, start):
                visited = set()
                stack = [start]
                while stack:
                    node = stack.pop()
                    if node not in visited:
                        visited.add(node)
                        for nbr in graph[node]:
                            stack.append(nbr)
                return visited
        """.trimIndent(),
        options = listOf(
            "O(V + E)",
            "O(V^2)",
            "O(E log V)",
            "O(V log E)"
        ),
        answerIndex = 0,
        explanation = "Each vertex is processed once (O(V)) and each edge is examined once when exploring neighbors (O(E)), giving O(V + E) overall — the standard DFS bound for an adjacency-list graph."
    ),
    Problem(
        id = "trace_hard_56",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Chained exception context",
        summary = "An exception raised inside an `except` block is implicitly chained to the original.",
        prompt = "What is printed when this code runs?",
        code = """
            try:
                try:
                    1 / 0
                except ZeroDivisionError:
                    raise ValueError("bad input")
            except ValueError as e:
                print(type(e.__context__).__name__)
        """.trimIndent(),
        options = listOf(
            "ZeroDivisionError",
            "ValueError",
            "None",
            "ExceptionGroup"
        ),
        answerIndex = 0,
        explanation = "When an exception is raised inside an `except` block, Python sets `__context__` on the new exception to the exception currently being handled. Here `e.__context__` is the `ZeroDivisionError`, so its type name is printed."
    ),
    Problem(
        id = "match_hard_56",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [0, 1, 1, 2, 3]",
        summary = "Pick the snippet that produces the first five Fibonacci numbers as a list.",
        prompt = "Which code produces this output?",
        code = "[0, 1, 1, 2, 3]",
        options = listOf(
            "a,b=0,1\nprint([a:=a+b for _ in range(5)])",
            "a,b=0,1\nres=[]\nfor _ in range(5):\n    res.append(a)\n    a,b=b,a+b\nprint(res)",
            "print(list(range(5)))",
            "print([n*(n-1)//2 for n in range(5)])"
        ),
        answerIndex = 1,
        explanation = "The loop appends `a` before advancing: `0, 1, 1, 2, 3`. The walrus-operator snippet starts from the wrong state and computes wrong values. `range(5)` gives `[0,1,2,3,4]` and the triangular formula gives `[0,0,1,3,6]`."
    )
)
