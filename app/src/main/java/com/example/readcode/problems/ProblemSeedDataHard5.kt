package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems - batch 5. One problem per category.
// These target senior developers (5+ years) and cover advanced Python internals.
val hardProblems5 = listOf(
    Problem(
        id = "bug_hard_5",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "MRO resolution gone wrong",
        summary = "A multiple-inheritance chain stops early because one override is not cooperative.",
        prompt = "Why does calling `D().greet()` never execute `B.greet()`?",
        code = """
            class A:
                def greet(self):
                    print("A")

            class B(A):
                def greet(self):
                    print("B")
                    super().greet()

            class C(A):
                def greet(self):
                    print("C")

            class D(C, B):
                pass

            D().greet()
        """.trimIndent(),
        options = listOf(
            "`C.greet` never calls `super().greet()`, so the MRO chain stops before `B.greet`",
            "`super()` in `B.greet` always jumps directly to `A.greet`, skipping `C`",
            "`D` must override `greet` or inherited methods cannot be chained",
            "Python skips `B` automatically whenever the MRO contains a diamond"
        ),
        answerIndex = 0,
        explanation = "For `D`, the MRO is `D -> C -> B -> A`. But `C.greet` prints `C` and stops. Because it does not call `super().greet()`, execution never continues to `B.greet` or `A.greet`."
    ),
    Problem(
        id = "output_hard_5",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Decorator order on a classmethod",
        summary = "A decorator wraps a `classmethod` object before descriptor binding can help.",
        prompt = "What happens when this script runs?",
        code = """
            def trace(fn):
                def wrapper(*args, **kwargs):
                    print("wrapper", len(args))
                    return fn(*args, **kwargs)
                return wrapper

            class Example:
                @trace
                @classmethod
                def build(cls):
                    print(cls.__name__)

            Example.build()
        """.trimIndent(),
        options = listOf(
            "It prints `wrapper 0` and then raises `TypeError` because the wrapped `classmethod` object is not directly callable",
            "It prints `wrapper 1` and then `Example` because `classmethod` binds `cls` before `trace` runs",
            "It prints only `Example` because `@classmethod` cancels the outer decorator",
            "It raises `TypeError` before printing anything because decorators are evaluated lazily"
        ),
        answerIndex = 0,
        explanation = "Decorator application is bottom-up, so `@classmethod` runs first and produces a `classmethod` descriptor object. `@trace` then wraps that descriptor object itself, not a normally bound function. Accessing `Example.build` returns the outer `wrapper`, which is called with zero positional arguments and prints `wrapper 0`. The wrapper then tries to call the stored `classmethod` object directly, which raises `TypeError` because the descriptor was never bound."
    ),
    Problem(
        id = "purpose_hard_5",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Custom __getattr__ proxy",
        summary = "An object transparently delegates attribute access to a wrapped target.",
        prompt = "What is the primary role of this class?",
        code = """
            class Proxy:
                def __init__(self, target):
                    object.__setattr__(self, '_target', target)

                def __getattr__(self, name):
                    return getattr(object.__getattribute__(self, '_target'), name)

                def __setattr__(self, name, value):
                    setattr(object.__getattribute__(self, '_target'), name, value)
        """.trimIndent(),
        options = listOf(
            "Transparently forwards attribute reads and writes to a wrapped object",
            "Caches every attribute the wrapped object exposes",
            "Prevents any attribute from being set on the wrapped object",
            "Makes the wrapped object immutable after construction"
        ),
        answerIndex = 0,
        explanation = "`__getattr__` delegates missing attribute reads to `_target`, and `__setattr__` redirects writes there too. The direct `object.__setattr__` and `object.__getattribute__` calls avoid infinite recursion."
    ),
    Problem(
        id = "fill_hard_5",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Metaclass namespace ordering",
        summary = "A metaclass hook selects the mapping used for the class body before `__new__` receives the namespace.",
        prompt = "Fill the blank with the metaclass hook that chooses the class-body namespace mapping before the class body runs.",
        code = """
            class OrderedMeta(type):
                @classmethod
                def ___(mcls, name, bases):
                    return {}

                def __new__(mcls, name, bases, namespace):
                    cls = super().__new__(mcls, name, bases, namespace)
                    cls.fields = [key for key in namespace if not key.startswith("__")]
                    return cls

            class Record(metaclass=OrderedMeta):
                id = 1
                email = 2
                active = 3
        """.trimIndent(),
        options = listOf(
            "__prepare__",
            "__classcell__",
            "__mro_entries__",
            "__instancecheck__"
        ),
        answerIndex = 0,
        explanation = "`__prepare__` is the metaclass hook that chooses the mapping used for the class body before execution. `OrderedMeta.__new__` then receives that namespace and can inspect its keys in whatever order and mapping behavior the hook supplied."
    )
)
