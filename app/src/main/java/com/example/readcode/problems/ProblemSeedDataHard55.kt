package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 55.
// One senior-level problem per problem type.
val hardProblems55 = listOf(
    Problem(
        id = "bug_hard_56",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "`__del__` called on live object",
        summary = "A finalizer is triggered unexpectedly because a temporary reference is collected mid-expression.",
        prompt = "What is the actual bug here?",
        code = """
            import ctypes

            class Resource:
                def __del__(self):
                    print("freed")

            def get_id():
                return id(Resource())

            ptr = get_id()
            obj = ctypes.cast(ptr, ctypes.py_object).value
        """.trimIndent(),
        options = listOf(
            "`id()` returns a string, not an integer pointer",
            "The `Resource()` instance is collected after `id()` returns, so `ptr` may be dangling",
            "`ctypes.py_object` only works with C extensions",
            "`__del__` is never called on objects created inside a function"
        ),
        answerIndex = 1,
        explanation = "`Resource()` is a temporary with no binding. CPython is free to collect it as soon as `id()` returns, reusing the address. Casting the now-invalid integer back to a Python object via `ctypes` is undefined behaviour — a classic dangling-pointer bug disguised as Python."
    ),
    Problem(
        id = "output_hard_56",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "`__new__` singleton enforcement",
        summary = "A class overrides `__new__` to return the same instance every time.",
        prompt = "What does this code print?",
        code = """
            class Singleton:
                _inst = None
                def __new__(cls):
                    if cls._inst is None:
                        cls._inst = super().__new__(cls)
                    return cls._inst

            a = Singleton()
            b = Singleton()
            a.x = 1
            b.x = 2
            print(a.x, a is b)
        """.trimIndent(),
        options = listOf(
            "1 False",
            "2 True",
            "1 True",
            "2 False"
        ),
        answerIndex = 1,
        explanation = "`__new__` returns the same object for every call, so `a` and `b` are identical references. Setting `b.x = 2` overwrites `a.x` on the single shared instance, and `a is b` is `True`."
    ),
    Problem(
        id = "purpose_hard_56",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Reentrant lock guard",
        summary = "A context manager wraps an RLock to allow nested acquisition from the same thread.",
        prompt = "What does this class do overall?",
        code = """
            import threading

            class ReentrantSection:
                def __init__(self):
                    self._lock = threading.RLock()

                def __enter__(self):
                    self._lock.acquire()
                    return self

                def __exit__(self, *args):
                    self._lock.release()
        """.trimIndent(),
        options = listOf(
            "It prevents any thread from acquiring the lock more than once, including the owner thread",
            "It lets the same thread enter the section multiple times without deadlocking",
            "It wraps a regular Lock and exposes it as a counting semaphore for thread pools",
            "It tracks every acquire and release event to a structured log for debugging purposes"
        ),
        answerIndex = 1,
        explanation = "`threading.RLock` (reentrant lock) can be acquired multiple times by the same thread. Each `acquire` increments an internal counter; each `release` decrements it. The lock is only truly released when the count reaches zero, so nested `with` blocks on the same thread work without deadlocking."
    ),
    Problem(
        id = "fill_hard_56",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Weak reference to a single object",
        summary = "Create a weak reference that lets the object be garbage-collected when no strong reference remains.",
        prompt = "Which choice fills the blank so `r` is a weak reference to `obj`?",
        code = """
            import weakref

            class Node:
                pass

            obj = Node()
            r = weakref.___(obj)
        """.trimIndent(),
        options = listOf(
            "ref",
            "WeakValueDictionary",
            "WeakKeyDictionary",
            "finalize"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref(obj)` creates a callable weak reference. Calling `r()` returns `obj` if it is still alive, or `None` if it has been garbage-collected. `WeakValueDictionary` and `WeakKeyDictionary` are mapping containers, not single-object references."
    ),
    Problem(
        id = "order_hard_55",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search (iterative)",
        summary = "Arrange the core body of a standard iterative binary search.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "lo, hi = 0, len(nums) - 1",
            "while lo <= hi:",
            "    mid = (lo + hi) // 2",
            "    if nums[mid] == target: return mid",
            "    elif nums[mid] < target: lo = mid + 1",
            "    else: hi = mid - 1",
            "return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Set the initial bounds, loop while the window is non-empty, compute the midpoint, return on a hit, narrow the window left or right on a miss, and return -1 if the target was not found."
    ),
    Problem(
        id = "complexity_hard_55",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Recursive fibonacci with memoization",
        summary = "A naive recursive Fibonacci is wrapped with `@functools.lru_cache`.",
        prompt = "What is the time complexity after memoization is applied?",
        code = """
            import functools

            @functools.lru_cache(maxsize=None)
            def fib(n):
                if n < 2:
                    return n
                return fib(n - 1) + fib(n - 2)
        """.trimIndent(),
        options = listOf(
            "O(2^n)",
            "O(n log n)",
            "O(n)",
            "O(log n)"
        ),
        answerIndex = 2,
        explanation = "With memoization each unique value of `n` from 0 to `n` is computed exactly once, reducing the exponential tree to a linear chain of unique calls — O(n) time and O(n) space."
    ),
    Problem(
        id = "trace_hard_55",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Mutable default argument accumulation",
        summary = "A list default argument is shared across all calls that omit the parameter.",
        prompt = "What is the value of `result` after these three calls?",
        code = """
            def add(val, acc=[]):
                acc.append(val)
                return acc

            add(1)
            add(2)
            result = add(3)
        """.trimIndent(),
        options = listOf(
            "[3]",
            "[1, 2, 3]",
            "[1], [1, 2], [1, 2, 3]",
            "[2, 3]"
        ),
        answerIndex = 1,
        explanation = "The default list `[]` is created once at function definition time and reused on every call that omits `acc`. Each call appends to the same object, so after three calls `acc` is `[1, 2, 3]`."
    ),
    Problem(
        id = "match_hard_55",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {1: 'a', 2: 'b'}",
        summary = "Pick the snippet that builds a dict by zipping two sequences.",
        prompt = "Which code produces this output?",
        code = "{1: 'a', 2: 'b'}",
        options = listOf(
            "print(dict(zip([1, 2], ['b', 'a'])))",
            "print({k: v for k, v in [(1, 'a'), (2, 'b')]})",
            "print(dict([(1, 'b'), (2, 'a')]))",
            "print({1: 'b', 2: 'a'})"
        ),
        answerIndex = 1,
        explanation = "The dict comprehension iterates over `[(1, 'a'), (2, 'b')]` and maps each key to its value, producing `{1: 'a', 2: 'b'}`. The other options swap `'a'` and `'b'` or reverse the mapping."
    )
)
