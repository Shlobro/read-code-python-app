package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems - batch 6. One problem per category.
// These target senior developers (5+ years) and cover advanced Python internals.
val hardProblems6 = listOf(
    Problem(
        id = "bug_hard_6",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor read-back surprise",
        summary = "A data descriptor on a class unintentionally intercepts instance attribute reads.",
        prompt = "The developer expects `obj.value` to return `42` after assignment. Why does it return `0` instead?",
        code = """
            class Clamped:
                def __set_name__(self, owner, name):
                    self.storage_name = f"_{name}"

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.storage_name, 0)

                def __set__(self, obj, val):
                    obj.__dict__[self.storage_name] = max(0, min(val, 100))

            class Config:
                value = Clamped()

            obj = Config()
            obj.__dict__["value"] = 42   # direct dict write, bypassing __set__
            print(obj.value)             # expects 42, prints 0
        """.trimIndent(),
        options = listOf(
            "The direct `__dict__` write bypasses `__set__`, but `__get__` reads from the backing key `'_value'` rather than `'value'`",
            "Writing directly to `obj.__dict__` is forbidden when a descriptor is present and silently fails",
            "`__set_name__` is called after `__get__`, so the storage key does not exist yet",
            "The bug is in the `max(0, min(val, 100))` clamp; `42` is within range so it should pass through"
        ),
        answerIndex = 0,
        explanation = "The descriptor stores validated values under a private backing key like `'_value'`. Writing directly to `obj.__dict__[\"value\"]` bypasses `__set__`, so the backing key never changes. When `obj.value` is read, `__get__` looks for `'_value'`, does not find it, and returns `0`."
    ),
    Problem(
        id = "output_hard_6",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Generator send() and throw()",
        summary = "A generator that receives values via send() and handles an injected exception.",
        prompt = "What is printed when this script runs?",
        code = """
            def accumulator():
                total = 0
                while True:
                    try:
                        value = yield total
                        if value is None:
                            break
                        total += value
                    except ValueError as e:
                        yield f"reset:{e}"
                        total = 0

            gen = accumulator()
            print(next(gen))          # prime the generator
            print(gen.send(10))
            print(gen.send(5))
            print(gen.throw(ValueError, "oops"))
            print(gen.send(1))
        """.trimIndent(),
        options = listOf(
            "0\n10\n15\nreset:oops\n1",
            "0\n10\n15\nreset:oops\n0",
            "0\n10\n15\nValueError: oops\n1",
            "None\n10\n15\nreset:oops\n1"
        ),
        answerIndex = 1,
        explanation = "`next(gen)` yields `0`, then `send(10)` and `send(5)` yield `10` and `15`. `throw(ValueError, \"oops\")` is caught and yields `reset:oops`. The following `send(1)` resumes after that yield inside the `except` block, so the sent `1` is discarded, `total` is reset to `0`, and the next loop iteration yields `0`."
    ),
    Problem(
        id = "purpose_hard_6",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Reentrant context manager",
        summary = "A class that tracks nested `with` block depth and only releases a resource at the outermost exit.",
        prompt = "What problem does this class solve?",
        code = """
            import threading

            class ReentrantResource:
                def __init__(self):
                    self._lock = threading.Lock()
                    self._local = threading.local()

                def __enter__(self):
                    depth = getattr(self._local, 'depth', 0)
                    if depth == 0:
                        self._lock.acquire()
                    self._local.depth = depth + 1
                    return self

                def __exit__(self, *args):
                    self._local.depth -= 1
                    if self._local.depth == 0:
                        self._lock.release()
        """.trimIndent(),
        options = listOf(
            "Allows the same thread to enter a `with` block multiple times without deadlocking, acquiring the underlying lock only once per thread",
            "Shares one lock instance across all threads so that only one thread may hold any `with` block at a time",
            "Prevents any nested `with` blocks from running until the outer block finishes",
            "Wraps a non-thread-safe resource so that concurrent threads take turns on each method call"
        ),
        answerIndex = 0,
        explanation = "`threading.local()` gives each thread its own `depth` counter. The first entry acquires the lock, later entries on the same thread only increment `depth`, and the final exit releases the lock."
    ),
    Problem(
        id = "fill_hard_6",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Generator state after throw",
        summary = "A caught exception yields once, then execution resumes from the suspended `except` block before the next loop iteration.",
        prompt = "Fill the blank so the final `print` outputs `0` instead of consuming the sent value.",
        code = """
            def worker():
                total = 0
                while True:
                    try:
                        item = yield total
                        total += item
                    except ValueError:
                        yield "reset"
                        total = ___

            gen = worker()
            print(next(gen))
            print(gen.send(5))
            print(gen.throw(ValueError()))
            print(gen.send(9))
        """.trimIndent(),
        options = listOf(
            "0",
            "9",
            "None",
            "total"
        ),
        answerIndex = 0,
        explanation = "After `throw(ValueError())`, the generator yields once from the `except` block. The following `send(9)` resumes after that yield, executes `total = 0`, and only then reaches the next `yield total`, so the sent `9` is discarded and `0` is printed."
    )
)
