package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems - batch 4. One problem per category.
val hardProblems4 = listOf(
    Problem(
        id = "bug_hard_4",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor validation bypass",
        summary = "A direct instance-dictionary write sidesteps the descriptor's validation path.",
        prompt = "Why does `print(a.balance)` output 99 after the direct `a.__dict__` write?",
        code = """
            class Positive:
                def __set_name__(self, owner, name):
                    self.name = name
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__[self.name]
                def __set__(self, obj, value):
                    if value <= 0:
                        raise ValueError("Must be positive")
                    obj.__dict__[self.name] = value

            class Account:
                balance = Positive()

            a = Account()
            a.balance = 100
            a.__dict__["balance"] = 99
            print(a.balance)
        """.trimIndent(),
        options = listOf(
            "The descriptor's `__get__` reads directly from `obj.__dict__`, so bypassing `__set__` via `__dict__` works",
            "Data descriptors always take priority over instance `__dict__`, so 99 is impossible",
            "`__set_name__` is never called for non-class-level assignments",
            "The `Positive` class is missing `__delete__`, making it a non-data descriptor"
        ),
        answerIndex = 0,
        explanation = "The custom `__get__` reads from `obj.__dict__[self.name]` directly, so writing to `a.__dict__['balance']` bypasses the validator. A robust descriptor would store values under a mangled key such as `_balance` instead."
    ),
    Problem(
        id = "output_hard_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late binding with default snapshots",
        summary = "One closure captures a loop variable live while another snapshots it through a default argument.",
        prompt = "What does this code print?",
        code = """
            def build():
                funcs = []
                for i in range(3):
                    funcs.append(lambda step=i: (i, step))
                i = 10
                return [fn() for fn in funcs]

            print(build())
        """.trimIndent(),
        options = listOf(
            "[(10, 0), (10, 1), (10, 2)]",
            "[(0, 0), (1, 1), (2, 2)]",
            "[(2, 0), (2, 1), (2, 2)]",
            "[(10, 10), (10, 10), (10, 10)]"
        ),
        answerIndex = 0,
        explanation = "The lambda body reads `i` by late binding, so all three functions use the final `i`, which is reassigned to 10 before they run. The default argument `step=i` snapshots the loop value at definition time, preserving 0, 1, and 2 separately."
    ),
    Problem(
        id = "purpose_hard_4",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Registry metaclass",
        summary = "Every subclass is automatically recorded.",
        prompt = "What is the primary effect of using this metaclass?",
        code = """
            class PluginMeta(type):
                registry = {}
                def __new__(mcs, name, bases, namespace):
                    cls = super().__new__(mcs, name, bases, namespace)
                    if bases:
                        mcs.registry[name] = cls
                    return cls

            class Plugin(metaclass=PluginMeta):
                pass

            class ImagePlugin(Plugin):
                pass

            class AudioPlugin(Plugin):
                pass

            print(PluginMeta.registry)
        """.trimIndent(),
        options = listOf(
            "It prevents subclasses from being instantiated directly",
            "It automatically registers every subclass of Plugin by name at class-creation time",
            "It replaces `__init__` in every subclass with a no-op",
            "It enforces that subclasses implement an abstract interface"
        ),
        answerIndex = 1,
        explanation = "`PluginMeta.__new__` is called whenever a class using this metaclass is created. The `if bases` guard skips the base `Plugin` class itself, so only concrete subclasses like `ImagePlugin` and `AudioPlugin` end up in `registry`."
    ),
    Problem(
        id = "fill_hard_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Cooperative MRO dispatch",
        summary = "A mixin chain relies on `super()` to keep each override in the method-resolution order.",
        prompt = "Fill the blank so `Service().run()` prints `log`, then `auth`, then `base`.",
        code = """
            class Base:
                def run(self):
                    print("base")

            class LoggingMixin(Base):
                def run(self):
                    print("log")
                    ___().run()

            class AuthMixin(Base):
                def run(self):
                    print("auth")
                    super().run()

            class Service(LoggingMixin, AuthMixin):
                pass

            Service().run()
        """.trimIndent(),
        options = listOf(
            "super",
            "Base",
            "self",
            "LoggingMixin"
        ),
        answerIndex = 0,
        explanation = "Calling `super().run()` continues along the MRO from `LoggingMixin` to `AuthMixin` and then `Base`. Calling `Base.run(self)` would skip the middle mixin, and the other choices do not cooperate with Python's MRO."
    )
)
