package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 32.
// One senior-level problem per problem type.
val hardProblems32 = listOf(
    Problem(
        id = "bug_hard_33",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure captures loop variable",
        summary = "A list of lambdas all return the same value.",
        prompt = "Why do all lambdas in `funcs` return 4 instead of 0, 1, 2, 3, 4?",
        code = """
            funcs = []
            for i in range(5):
                funcs.append(lambda: i)

            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "Each lambda closes over the variable `i`, not its value at the time of creation; when called, all see the final value of `i` which is 4",
            "Lambdas cannot reference variables from an enclosing for-loop scope",
            "The list comprehension re-executes the loop, resetting `i` to 4",
            "`range(5)` produces values 1–5, so the last value is 5, not 4"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variables by reference, not by value. All five lambdas share the same `i` variable, which is 4 after the loop completes. Fix: use a default argument `lambda i=i: i` to capture the current value at definition time."
    ),
    Problem(
        id = "output_hard_33",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO and cooperative super()",
        summary = "Multiple inheritance calls through the MRO chain.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self):
                    print("A")
                    super().greet()

            class B(A):
                def greet(self):
                    print("B")
                    super().greet()

            class C(A):
                def greet(self):
                    print("C")
                    super().greet()

            class D(B, C):
                def greet(self):
                    print("D")
                    super().greet()

            class Base:
                def greet(self):
                    print("Base")

            # Patch A's base so the chain terminates
            A.__bases__ = (Base,)

            D().greet()
        """.trimIndent(),
        options = listOf(
            "D\nB\nC\nA\nBase",
            "D\nB\nA\nBase",
            "D\nC\nA\nBase",
            "D\nB\nC\nBase"
        ),
        answerIndex = 0,
        explanation = "Python's MRO for D is [D, B, C, A, Base]. Each `super().greet()` call follows this chain. D → B → C → A → Base. Every class in the MRO participates because all use cooperative `super()` calls."
    ),
    Problem(
        id = "purpose_hard_33",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Custom __getattr__ as a lazy proxy",
        summary = "A class that forwards unknown attributes to a wrapped object on demand.",
        prompt = "What is the primary purpose of this class?",
        code = """
            class LazyProxy:
                def __init__(self, factory):
                    object.__setattr__(self, '_factory', factory)
                    object.__setattr__(self, '_obj', None)

                def _load(self):
                    if object.__getattribute__(self, '_obj') is None:
                        obj = object.__getattribute__(self, '_factory')()
                        object.__setattr__(self, '_obj', obj)
                    return object.__getattribute__(self, '_obj')

                def __getattr__(self, name):
                    return getattr(self._load(), name)

                def __setattr__(self, name, value):
                    setattr(self._load(), name, value)
        """.trimIndent(),
        options = listOf(
            "Delay construction of an expensive object until one of its attributes is first accessed",
            "Cache every attribute lookup in a dictionary to speed up repeated accesses",
            "Prevent any attribute from being set on the wrapped object after creation",
            "Forward all method calls to a remote object over a network connection"
        ),
        answerIndex = 0,
        explanation = "`LazyProxy` stores a factory callable instead of immediately constructing the underlying object. The first attribute access triggers `_load()`, which calls the factory and caches the result. Subsequent accesses go straight to the cached `_obj`. `object.__getattribute__` and `object.__setattr__` are used deliberately to bypass the proxy's own `__getattr__`/`__setattr__` while managing internal state."
    ),
    Problem(
        id = "fill_hard_33",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with threading.Lock",
        summary = "Choose the correct primitive to make a counter thread-safe.",
        prompt = "Which stdlib type fills the blank so that `increment` is safe to call from multiple threads simultaneously?",
        code = """
            import threading

            class AtomicCounter:
                def __init__(self):
                    self._value = 0
                    self._lock = ___()

                def increment(self):
                    with self._lock:
                        self._value += 1

                def value(self):
                    return self._value
        """.trimIndent(),
        options = listOf(
            "threading.Lock",
            "threading.Event",
            "threading.Semaphore",
            "threading.Condition"
        ),
        answerIndex = 0,
        explanation = "`threading.Lock` is the simplest mutual-exclusion primitive. Using it as a context manager (`with self._lock`) ensures only one thread can execute the increment at a time, preventing lost updates. `Event` is for signalling between threads, `Semaphore` allows N concurrent holders, and `Condition` is for more complex wait/notify patterns — all heavier than needed here."
    ),
    Problem(
        id = "order_hard_32",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge sort implementation",
        summary = "Arrange a recursive merge sort in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sort(arr):",
            "    if len(arr) <= 1:",
            "        return arr",
            "    mid = len(arr) // 2",
            "    left = merge_sort(arr[:mid])",
            "    right = merge_sort(arr[mid:])",
            "    return merge(left, right)",
            "def merge(left, right):",
            "    result = []",
            "    i = j = 0",
            "    while i < len(left) and j < len(right):",
            "        if left[i] <= right[j]:",
            "            result.append(left[i]); i += 1",
            "        else:",
            "            result.append(right[j]); j += 1",
            "    return result + left[i:] + right[j:]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "Merge sort first handles the base case (length ≤ 1), then splits the array at the midpoint, recursively sorts each half, and merges the sorted halves. The `merge` helper walks both halves with two pointers, appending the smaller element each step, then appends any remainder from either half."
    ),
    Problem(
        id = "complexity_hard_32",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loop with shrinking inner range",
        summary = "Determine the exact time complexity of this triangular loop.",
        prompt = "What is the time complexity of this function?",
        code = """
            def triangular(n):
                count = 0
                for i in range(n):
                    for j in range(i, n):
                        count += 1
                return count
        """.trimIndent(),
        options = listOf("O(n²)", "O(n log n)", "O(n)", "O(2^n)"),
        answerIndex = 0,
        explanation = "The inner loop runs `n - i` times for each value of `i`. Total iterations = (n) + (n-1) + … + 1 = n(n+1)/2, which is Θ(n²). Although the inner range shrinks, it is still a triangular sum — the same asymptotic class as a full nested double loop."
    ),
    Problem(
        id = "trace_hard_32",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and yield expression",
        summary = "Track the value yielded after a send() call into a generator.",
        prompt = "What value is assigned to `result` after this code runs?",
        code = """
            def accumulator():
                total = 0
                while True:
                    value = yield total
                    if value is None:
                        break
                    total += value

            gen = accumulator()
            next(gen)          # prime the generator
            gen.send(10)
            gen.send(20)
            result = gen.send(5)
        """.trimIndent(),
        options = listOf("35", "5", "30", "0"),
        answerIndex = 0,
        explanation = "`next(gen)` primes the generator, pausing at `yield total` with total=0 (yielded value 0). `gen.send(10)` resumes with value=10, so total becomes 10, then yields 10. `gen.send(20)` adds 20, total becomes 30, yields 30. `gen.send(5)` adds 5, total becomes 35, yields 35. So `result = 35`."
    ),
    Problem(
        id = "match_hard_32",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\nCounter({'a': 2, 'b': 1})",
        summary = "Pick the snippet that prints a Counter object (not a plain dict).",
        prompt = "Which code prints exactly `Counter({'a': 2, 'b': 1})`?",
        code = "Counter({'a': 2, 'b': 1})",
        options = listOf(
            "from collections import Counter; print(Counter('aab'))",
            "from collections import Counter; print(dict(Counter('aab')))",
            "from collections import Counter; print(Counter({'a': 2, 'b': 1}) == {'a': 2, 'b': 1})",
            "from collections import Counter; print(sorted(Counter('aab').items()))"
        ),
        answerIndex = 0,
        explanation = "`Counter('aab')` counts characters: a→2, b→1. `print` on a `Counter` object uses its `__repr__`, which renders as `Counter({'a': 2, 'b': 1})` — distinct from a plain dict's repr. Option B wraps with `dict()`, printing `{'a': 2, 'b': 1}` without the `Counter(` prefix. Option C prints `True` (Counter equality with dict). Option D prints a list of tuples."
    )
)
