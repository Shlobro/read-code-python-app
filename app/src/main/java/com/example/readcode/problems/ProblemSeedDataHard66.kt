package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 66.
// One senior-level problem per problem type.
val hardProblems66 = listOf(
    Problem(
        id = "bug_hard_67",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Class variable shared across instances",
        summary = "Mutating a class-level list via an instance modifies it for all instances.",
        prompt = "What is the bug in this code?",
        code = """
            class Counter:
                history = []

                def record(self, value):
                    self.history.append(value)

            a = Counter()
            b = Counter()
            a.record(1)
            print(len(b.history))
        """.trimIndent(),
        options = listOf(
            "`record` should raise `AttributeError` because `self.history` cannot refer to a class variable",
            "`history` is a class-level list shared by all instances; appending via one instance is visible through all others",
            "Python creates a per-instance copy of `history` on first attribute access, so `b.history` is always empty",
            "The bug is that `history` is not declared inside `__init__`, which prevents attribute lookup from working"
        ),
        answerIndex = 1,
        explanation = "Class-level mutable defaults are shared. `self.history.append(value)` mutates the class attribute in-place; it does not create an instance attribute. Both `a.history` and `b.history` point to the same list, so `len(b.history)` is 1."
    ),
    Problem(
        id = "output_hard_67",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in a loop",
        summary = "All lambda functions capture the same loop variable by reference.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(3)]
            print(funcs[0](), funcs[1](), funcs[2]())
        """.trimIndent(),
        options = listOf(
            "0 1 2",
            "2 2 2",
            "0 0 0",
            "TypeError: 'int' object is not callable"
        ),
        answerIndex = 1,
        explanation = "Python closures capture variables by reference, not by value. After the loop, `i` is 2. All three lambdas look up `i` at call time and return 2."
    ),
    Problem(
        id = "purpose_hard_67",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__set_name__ descriptor hook",
        summary = "A descriptor that records its own attribute name when the class is defined.",
        prompt = "What is the primary purpose of this descriptor?",
        code = """
            class Typed:
                def __set_name__(self, owner, name):
                    self.name = name

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError(f"{self.name} must be int")
                    obj.__dict__[self.name] = value

            class Point:
                x = Typed()
                y = Typed()
        """.trimIndent(),
        options = listOf(
            "Enforce that `x` and `y` are integers, using the attribute name in the error message without hard-coding it",
            "Prevent subclasses from overriding `x` and `y` by locking the descriptor at class-creation time",
            "Cache the integer values of `x` and `y` in a shared dict to avoid per-instance storage overhead",
            "Automatically convert any assigned value to int so that `Point.x = '3'` silently stores 3"
        ),
        answerIndex = 0,
        explanation = "`__set_name__` is called by the metaclass when the class body is executed, passing the descriptor the owner class and the attribute name. The descriptor stores that name so `__set__` can produce informative error messages without the name being hard-coded in each descriptor instance."
    ),
    Problem(
        id = "fill_hard_67",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with threading.Lock",
        summary = "Protect a shared counter increment inside a thread-safe context.",
        prompt = "Fill the blank so the increment is protected by the lock.",
        code = """
            import threading

            lock = threading.Lock()
            counter = 0

            def increment():
                global counter
                ___ lock:
                    counter += 1
        """.trimIndent(),
        options = listOf(
            "with",
            "lock.acquire(); try:",
            "synchronized",
            "using"
        ),
        answerIndex = 0,
        explanation = "`with lock:` acquires the lock on entry and releases it on exit, even if an exception is raised. It is the idiomatic way to use a `threading.Lock` as a context manager in Python."
    ),
    Problem(
        id = "order_hard_66",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search implementation",
        summary = "Arrange the iterative binary search function into correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def binary_search(arr, target):",
            "    lo, hi = 0, len(arr) - 1",
            "    while lo <= hi:",
            "        mid = (lo + hi) // 2",
            "        if arr[mid] == target:",
            "            return mid",
            "        elif arr[mid] < target:",
            "            lo = mid + 1",
            "        else:",
            "            hi = mid - 1",
            "    return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        explanation = "Initialise lo and hi, enter the while loop, compute mid, check for an exact match and return, narrow the range left or right based on comparison, and return -1 when the range is exhausted."
    ),
    Problem(
        id = "complexity_hard_66",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Matrix chain — naive recursive",
        summary = "Recursive matrix-chain multiplication with no memoization.",
        prompt = "What is the time complexity of this algorithm?",
        code = """
            def mcm(dims, i, j):
                if i == j:
                    return 0
                best = float('inf')
                for k in range(i, j):
                    cost = (mcm(dims, i, k)
                            + mcm(dims, k + 1, j)
                            + dims[i-1] * dims[k] * dims[j])
                    if cost < best:
                        best = cost
                return best
        """.trimIndent(),
        options = listOf(
            "O(n²)",
            "O(n³)",
            "O(2ⁿ)",
            "O(n log n)"
        ),
        answerIndex = 2,
        explanation = "Without memoization, the recursion tree branches at every split point and re-solves overlapping subproblems. The number of distinct recursive calls grows exponentially with n, giving O(2ⁿ) time in the worst case."
    ),
    Problem(
        id = "trace_hard_66",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "MRO and super() call chain",
        summary = "Trace which greet() methods fire and in what order under Python's C3 MRO.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self):
                    print("A")

            class B(A):
                def greet(self):
                    super().greet()
                    print("B")

            class C(A):
                def greet(self):
                    super().greet()
                    print("C")

            class D(B, C):
                def greet(self):
                    super().greet()
                    print("D")

            D().greet()
        """.trimIndent(),
        options = listOf(
            "A\nB\nC\nD",
            "D\nC\nB\nA",
            "A\nD",
            "A\nC\nB\nD"
        ),
        answerIndex = 3,
        explanation = "D's MRO is D → B → C → A. `super()` in D dispatches to B.greet, which calls super() → C.greet, which calls super() → A.greet. A prints 'A' first. C resumes and prints 'C'. B resumes and prints 'B'. D resumes and prints 'D'. Result: A C B D."
    ),
    Problem(
        id = "match_hard_66",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: weakref callback fires on GC",
        summary = "Pick the snippet that prints 'gone' when the referent is collected.",
        prompt = "Which code prints `gone`?",
        code = "gone",
        options = listOf(
            "import weakref\nclass T: pass\nobj = T()\nref = weakref.ref(obj, lambda r: print('gone'))\ndel obj",
            "import weakref\nclass T: pass\nobj = T()\nref = weakref.ref(obj)\ndel obj\nprint(ref())",
            "import weakref\nclass T: pass\nobj = T()\nref = weakref.ref(obj)\ndel obj\nprint('done')",
            "import weakref\nclass T: pass\nobj = T()\nproxy = weakref.proxy(obj)\nobj = None\nprint(proxy)"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref` accepts an optional callback that is invoked with the dead reference when the referent is garbage-collected. After `del obj` the reference count drops to zero and the callback fires, printing 'gone'. Option B prints `None` (the dead weakref). Option C prints 'done', not 'gone'. Option D raises `ReferenceError` when accessing the dead proxy."
    )
)
