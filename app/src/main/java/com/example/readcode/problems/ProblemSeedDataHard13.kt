package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 13.
// One senior-level problem per problem type.
val hardProblems13 = listOf(
    Problem(
        id = "bug_hard_14",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Weak-reference cache with no strong owner",
        summary = "A `WeakValueDictionary` entry disappears before the next lookup.",
        prompt = "Why can the final line raise `KeyError` even though the object was just inserted?",
        code = """
            from weakref import WeakValueDictionary

            class Session:
                pass

            cache = WeakValueDictionary()
            cache["active"] = Session()
            print(cache["active"])
        """.trimIndent(),
        options = listOf(
            "The cached object has no strong reference, so it can be garbage-collected immediately",
            "`WeakValueDictionary` only accepts strings as values, not class instances",
            "Reading from a `WeakValueDictionary` requires calling `.get()` instead of `[]`",
            "The key must be weak-referenceable, but strings are not"
        ),
        answerIndex = 0,
        explanation = "A `WeakValueDictionary` holds only weak references to its values. Because the `Session()` instance is not stored anywhere else, it may be collected as soon as the assignment finishes, leaving the dictionary entry gone by lookup time."
    ),
    Problem(
        id = "output_hard_14",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Exception flow through `finally`",
        summary = "An exception is re-raised after the `finally` block runs.",
        prompt = "What does this script print?",
        code = """
            def run():
                try:
                    1 / 0
                except ZeroDivisionError:
                    print("inner-except")
                    raise
                finally:
                    print("inner-finally")

            try:
                run()
            except ZeroDivisionError:
                print("outer-except")
        """.trimIndent(),
        options = listOf(
            "inner-except\ninner-finally\nouter-except",
            "inner-finally\nouter-except",
            "inner-except\nouter-except",
            "inner-except\ninner-finally"
        ),
        answerIndex = 0,
        explanation = "The inner `except` runs first and re-raises the exception. The `finally` block always runs before the exception leaves `run()`, and then the outer handler prints the last line."
    ),
    Problem(
        id = "purpose_hard_14",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Chunked reads with a sentinel iterator",
        summary = "`iter(callable, sentinel)` is used around `stream.read`.",
        prompt = "What is this function doing overall?",
        code = """
            def read_chunks(stream, size=4096):
                for chunk in iter(lambda: stream.read(size), b""):
                    yield chunk
        """.trimIndent(),
        options = listOf(
            "It lazily yields fixed-size byte chunks until the stream reaches EOF",
            "It rewinds the stream after every read so callers can retry failed chunks",
            "It buffers the full stream into memory before yielding any data",
            "It converts the stream into lines and strips trailing newlines from each one"
        ),
        answerIndex = 0,
        explanation = "`iter(callable, sentinel)` keeps calling the lambda until it returns the sentinel value `b\"\"`, which is what binary reads return at EOF. The function therefore streams the input in chunks without loading everything at once."
    ),
    Problem(
        id = "fill_hard_14",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Preserving metadata in a decorator",
        summary = "The wrapper should keep the original function name and docstring.",
        prompt = "Fill the blank so the wrapper copies metadata from `func` correctly.",
        code = """
            from functools import wraps

            def logged(func):
                @___
                def wrapper(*args, **kwargs):
                    print(func.__name__)
                    return func(*args, **kwargs)
                return wrapper
        """.trimIndent(),
        options = listOf(
            "wraps(func)",
            "wraps",
            "func",
            "wrapper"
        ),
        answerIndex = 0,
        explanation = "`@wraps(func)` applies `functools.update_wrapper` to `wrapper`, preserving metadata such as `__name__`, `__doc__`, and `__wrapped__`."
    ),
    Problem(
        id = "order_hard_13",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted streams",
        summary = "Arrange the lines to implement the merge step from merge sort.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge(left, right):",
            "    merged = []",
            "    i = 0",
            "    j = 0",
            "    while i < len(left) and j < len(right):",
            "        if left[i] <= right[j]:",
            "            merged.append(left[i])",
            "            i += 1",
            "        else:",
            "            merged.append(right[j])",
            "            j += 1",
            "    return merged + left[i:] + right[j:]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
        explanation = "The function initializes result storage and two pointers, repeatedly appends the smaller front element, advances the corresponding pointer, and finally appends the remaining tail from either input."
    ),
    Problem(
        id = "complexity_hard_13",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loop with a monotonic pointer",
        summary = "The inner pointer never resets across outer iterations.",
        prompt = "What is the overall time complexity in terms of n?",
        code = """
            def walk(values):
                j = 0
                for i in range(len(values)):
                    while j < len(values) and values[j] <= values[i]:
                        j += 1
                return j
        """.trimIndent(),
        options = listOf("O(n)", "O(n log n)", "O(n^2)", "O(log n)"),
        answerIndex = 0,
        explanation = "Although the `while` loop is nested inside the `for` loop, `j` only increases and never resets. Across the whole function, `j` advances at most `n` times, and the `for` loop also runs `n` times, so the total work is linear."
    ),
    Problem(
        id = "trace_hard_13",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shallow copy of nested state",
        summary = "Only the outer dictionary is copied before a nested list is mutated.",
        prompt = "What is the value of `value` after this code runs?",
        code = """
            original = {"jobs": ["api", "worker"]}
            copied = original.copy()
            copied["jobs"].append("cron")
            value = original["jobs"]
        """.trimIndent(),
        options = listOf(
            "['api', 'worker', 'cron']",
            "['api', 'worker']",
            "['cron']",
            "It raises `KeyError`"
        ),
        answerIndex = 0,
        explanation = "`.copy()` makes a shallow copy of the dictionary, so both dictionaries still reference the same inner list. Appending through `copied` mutates the list seen from `original` as well."
    ),
    Problem(
        id = "match_hard_13",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [3, 2, 1]",
        summary = "Pick the snippet that drains a deque from the right-hand side.",
        prompt = "Which code produces exactly `[3, 2, 1]`?",
        code = "",
        options = listOf(
            "from collections import deque; d = deque([1, 2, 3]); print([d.pop() for _ in range(len(d))])",
            "from collections import deque; d = deque([1, 2, 3]); print([d.popleft() for _ in range(len(d))])",
            "from collections import deque; d = deque([1, 2, 3]); d.reverse(); print(d.pop())",
            "from collections import deque; d = deque([1, 2, 3]); print(sorted(d))"
        ),
        answerIndex = 0,
        explanation = "Repeated `pop()` calls remove items from the right side of the deque, producing 3, then 2, then 1. The other snippets either remove from the left, print only one value, or sort without demonstrating deque-draining behavior."
    )
)
