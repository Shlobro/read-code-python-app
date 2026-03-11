package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 43.
// One senior-level problem per problem type.
val hardProblems43 = listOf(
    Problem(
        id = "bug_hard_44",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Thread-safe singleton broken",
        summary = "A double-checked locking pattern for a singleton is missing the memory barrier.",
        prompt = "Why is this singleton implementation unsafe even with the lock?",
        code = """
            import threading

            class Singleton:
                _instance = None
                _lock = threading.Lock()

                @classmethod
                def get_instance(cls):
                    if cls._instance is None:
                        with cls._lock:
                            if cls._instance is None:
                                cls._instance = cls()
                    return cls._instance
        """.trimIndent(),
        options = listOf(
            "In CPython the GIL makes this safe, but in Jython or PyPy without a GIL the outer `if` check can read a partially-constructed object due to instruction reordering — the assignment `cls._instance = cls()` is not atomic",
            "The `with` statement cannot be used inside a `@classmethod`; a regular method is required",
            "The inner `if cls._instance is None` check is redundant and causes a deadlock when two threads enter simultaneously",
            "`threading.Lock()` must be created inside `get_instance` to be thread-local; a class-level lock is shared incorrectly"
        ),
        answerIndex = 0,
        explanation = "Double-checked locking is broken in languages without a memory model guarantee because the write `cls._instance = cls()` can be made visible to other threads before the object's `__init__` completes (instruction reordering). CPython's GIL happens to prevent this in the reference implementation, but the pattern is still considered unsafe in production code targeting alternative runtimes or future CPython versions without the GIL (PEP 703). The idiomatic Python singleton uses a module-level object or `threading.local()` as appropriate."
    ),
    Problem(
        id = "output_hard_44",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor vs instance __dict__",
        summary = "A data descriptor shadows an instance attribute; a non-data descriptor does not.",
        prompt = "What does this code print?",
        code = """
            class DataDesc:
                def __get__(self, obj, objtype=None):
                    return "data"
                def __set__(self, obj, value):
                    pass

            class NonDataDesc:
                def __get__(self, obj, objtype=None):
                    return "non-data"

            class MyClass:
                dd = DataDesc()
                nd = NonDataDesc()

            obj = MyClass()
            obj.__dict__["dd"] = "instance_dd"
            obj.__dict__["nd"] = "instance_nd"
            print(obj.dd)
            print(obj.nd)
        """.trimIndent(),
        options = listOf(
            "data\ninstance_nd",
            "instance_dd\ninstance_nd",
            "data\nnon-data",
            "instance_dd\nnon-data"
        ),
        answerIndex = 0,
        explanation = "Python's attribute lookup order is: data descriptors (define both `__get__` and `__set__`) > instance `__dict__` > non-data descriptors (define only `__get__`). `DataDesc` defines `__set__`, so it takes priority over `obj.__dict__['dd']` and returns `'data'`. `NonDataDesc` only defines `__get__`, so the instance `__dict__` entry `'instance_nd'` wins and returns `'instance_nd'`."
    ),
    Problem(
        id = "purpose_hard_44",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Weak-reference finalizer registry",
        summary = "A class uses weakref callbacks to detect when managed objects are garbage-collected.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            import weakref

            class Registry:
                def __init__(self):
                    self._refs = {}

                def register(self, obj):
                    key = id(obj)
                    def _cleanup(ref, k=key):
                        self._refs.pop(k, None)
                    self._refs[key] = weakref.ref(obj, _cleanup)

                def alive_count(self):
                    return len(self._refs)
        """.trimIndent(),
        options = listOf(
            "Track a set of objects without preventing their garbage collection, and automatically remove them from the registry when they are collected",
            "Prevent registered objects from being garbage-collected by holding strong references inside `_refs`",
            "Serialize registered objects to disk when they go out of scope",
            "Provide reference counting on top of CPython's existing reference counter to detect circular reference leaks"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref(obj, _cleanup)` creates a weak reference that does not prevent `obj` from being garbage-collected. When the object's reference count drops to zero, CPython calls the finalizer callback `_cleanup`, which removes the dead entry from `self._refs`. This lets `alive_count()` report only truly live objects. The pattern is common in caches, observer lists, and resource managers where you want to track objects without artificially extending their lifetimes."
    ),
    Problem(
        id = "fill_hard_44",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "contextlib.contextmanager send value",
        summary = "A generator-based context manager receives a value sent into it at the yield point.",
        prompt = "Which expression fills the blank so that `value` inside the `with` block receives the integer `42` that the context manager yields?",
        code = """
            from contextlib import contextmanager

            @contextmanager
            def produce():
                yield 42

            with produce() ___ value:
                print(value)
        """.trimIndent(),
        options = listOf(
            "as",
            "->",
            "yields",
            "="
        ),
        answerIndex = 0,
        explanation = "The `with produce() as value:` syntax binds the object yielded by the context manager's `__enter__` to `value`. For a `@contextmanager`-decorated generator, `__enter__` advances the generator to the first `yield` and returns the yielded value. So `value` receives `42`. The `->` and `=` tokens are not valid in a `with` statement header; `yields` is not a keyword."
    ),
    Problem(
        id = "order_hard_43",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the core loop of Kahn's topological sort in the correct order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "queue = deque(node for node in in_degree if in_degree[node] == 0)",
            "while queue:",
            "    node = queue.popleft()",
            "    result.append(node)",
            "    for neighbor in graph[node]:",
            "        in_degree[neighbor] -= 1",
            "        if in_degree[neighbor] == 0:",
            "            queue.append(neighbor)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "Kahn's algorithm seeds the queue with every node whose in-degree is 0 (no prerequisites). Each iteration removes a node from the front of the queue, appends it to the result, then decrements the in-degree of each of its neighbors. When a neighbor's in-degree reaches 0, all its prerequisites have been processed, so it becomes eligible and is pushed onto the queue. If the result list ends with fewer nodes than the graph, a cycle exists."
    ),
    Problem(
        id = "complexity_hard_43",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Merge sort space complexity",
        summary = "Determine the auxiliary space complexity of a standard recursive merge sort.",
        prompt = "What is the auxiliary space complexity of this merge sort implementation?",
        code = """
            def merge_sort(arr):
                if len(arr) <= 1:
                    return arr
                mid = len(arr) // 2
                left = merge_sort(arr[:mid])
                right = merge_sort(arr[mid:])
                return merge(left, right)

            def merge(left, right):
                result = []
                i = j = 0
                while i < len(left) and j < len(right):
                    if left[i] <= right[j]:
                        result.append(left[i]); i += 1
                    else:
                        result.append(right[j]); j += 1
                return result + left[i:] + right[j:]
        """.trimIndent(),
        options = listOf(
            "O(n log n) — the slicing at each level allocates O(n) total per level and there are O(log n) levels simultaneously on the call stack",
            "O(n) — only a single auxiliary array of size n is ever alive at any moment",
            "O(log n) — only the recursive call stack depth matters; slices are not counted",
            "O(n²) — each recursive call copies the entire array"
        ),
        answerIndex = 0,
        explanation = "Python slices (`arr[:mid]`, `arr[mid:]`) create new list objects. At each recursion level the total size of all live slices is O(n). Because the call stack has O(log n) levels simultaneously alive before unwinding begins, the peak live memory is O(n) × O(log n) = O(n log n). An in-place merge sort can reduce this to O(log n) (just the call stack), but the slice-based version here is O(n log n) auxiliary space."
    ),
    Problem(
        id = "trace_hard_43",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "C3 linearisation and super() dispatch",
        summary = "Trace which method is called at each step through a diamond MRO.",
        prompt = "What does this code print, in order?",
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

            # D.__mro__ == [D, B, C, A, Base, object]
            # A inherits from Base here for illustration; imagine object replaced by Base.
            D().greet()
        """.trimIndent(),
        options = listOf(
            "D\nB\nC\nA\nBase",
            "D\nB\nA\nC\nBase",
            "D\nC\nB\nA\nBase",
            "D\nB\nA"
        ),
        answerIndex = 0,
        explanation = "Python's C3 linearisation for `D(B, C)` where both `B` and `C` inherit from `A` produces MRO `[D, B, C, A, Base, object]`. Each `super().greet()` call dispatches to the *next* class in the MRO of the *original* instance's class (`D`), not the next in the current class's own bases. So the call chain is `D.greet → B.greet → C.greet → A.greet → Base.greet`, printing `D B C A Base`. This cooperative `super()` pattern is why every class in the diamond must call `super()`, or the chain breaks."
    ),
    Problem(
        id = "match_hard_43",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {0: [], 1: [], 2: []}",
        summary = "Pick the snippet that creates independent empty lists for each key.",
        prompt = "Which code produces `{0: [], 1: [], 2: []}`?",
        code = "{0: [], 1: [], 2: []}",
        options = listOf(
            "{k: [] for k in range(3)}",
            "dict.fromkeys(range(3), [])",
            "{k: list() for k in range(3)}",
            "{k: [k] for k in range(3)}"
        ),
        answerIndex = 2,
        explanation = "Options A and C both produce `{0: [], 1: [], 2: []}` with independent list instances per key. Option D produces `{0: [0], 1: [1], 2: [2]}` — not empty lists. Option B (`dict.fromkeys(range(3), [])`) looks correct but is a classic Python gotcha: `fromkeys` reuses the *same* list object for every key, so appending to one key's value mutates all of them. Since option B produces the correct repr but hides a shared-reference bug, the unambiguously correct answer is option C (`{k: list() for k in range(3)}`), which guarantees independent lists."
    )
)
