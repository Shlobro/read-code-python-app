package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 36.
// One senior-level problem per problem type.
val hardProblems36 = listOf(
    Problem(
        id = "bug_hard_37",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook silently ignored",
        summary = "A subclass kwarg is passed but the hook never fires because super() is missing.",
        prompt = "Why does `MyPlugin` never appear in `registry` even though `Plugin` defines `__init_subclass__`?",
        code = """
            registry = []

            class Plugin:
                def __init_subclass__(cls, register=False, **kwargs):
                    if register:
                        registry.append(cls)

            class Base(Plugin):
                def __init_subclass__(cls, **kwargs):
                    pass  # forgot super().__init_subclass__(**kwargs)

            class MyPlugin(Base, register=True):
                pass

            print(registry)  # expected: [<class 'MyPlugin'>], actual: []
        """.trimIndent(),
        options = listOf(
            "`Base.__init_subclass__` overrides the hook without calling `super().__init_subclass__(**kwargs)`, so `Plugin.__init_subclass__` is never invoked and `MyPlugin` is never registered",
            "`register=True` is not a valid keyword argument for class definitions in Python 3",
            "`__init_subclass__` only fires for direct subclasses of `Plugin`, not for subclasses of subclasses",
            "The `registry` list must be defined inside `Plugin` to be accessible from `__init_subclass__`"
        ),
        answerIndex = 0,
        explanation = "When `Base` defines `__init_subclass__` without calling `super().__init_subclass__(**kwargs)`, it breaks the MRO chain. Any keyword arguments (including `register=True`) passed by sub-subclasses travel up the MRO, but since `Base` absorbs the call and discards `**kwargs`, `Plugin.__init_subclass__` is never reached. The fix is to always forward `**kwargs` via `super().__init_subclass__(**kwargs)` in every intermediate `__init_subclass__`."
    ),
    Problem(
        id = "output_hard_37",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure in a class body loop",
        summary = "Methods created in a loop all capture the same loop variable.",
        prompt = "What is printed when this module-level code runs?",
        code = """
            class Dispatcher:
                handlers = {}
                for _event in ('click', 'hover'):
                    def _handler(self, e=_event):
                        return e
                    handlers[_event] = _handler
                del _event

            d = Dispatcher()
            print(d.handlers['click'](d))
            print(d.handlers['hover'](d))
        """.trimIndent(),
        options = listOf(
            "click\nhover",
            "hover\nhover",
            "click\nclick",
            "NameError: name '_event' is not defined"
        ),
        answerIndex = 0,
        explanation = "Each `_handler` definition uses `e=_event` as a default argument. Default argument values are evaluated at function-definition time, so `e` is bound to the value of `_event` at that iteration — `'click'` for the first and `'hover'` for the second. Unlike a plain closure over `_event`, the default-argument trick captures the *current* value, not a reference to the loop variable. Therefore `handlers['click'](d)` returns `'click'` and `handlers['hover'](d)` returns `'hover'`."
    ),
    Problem(
        id = "purpose_hard_37",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Slots with multiple inheritance",
        summary = "Combining __slots__ from two base classes.",
        prompt = "What is the primary purpose of this class design?",
        code = """
            class Timestamped:
                __slots__ = ('created_at',)

            class Tagged:
                __slots__ = ('tags',)

            class Record(Timestamped, Tagged):
                __slots__ = ('name',)

            r = Record()
            r.name = 'doc'
            r.created_at = 1_700_000_000
            r.tags = ['a', 'b']
            # r.__dict__ raises AttributeError — no instance dict
        """.trimIndent(),
        options = listOf(
            "Eliminate per-instance `__dict__` across the entire hierarchy so that `Record` objects use only fixed-slot storage, reducing memory overhead compared with a normal multi-inherited class",
            "Prevent subclassing of `Record` by sealing the class with `__slots__`",
            "Force `created_at`, `tags`, and `name` to be class-level constants rather than per-instance attributes",
            "Enable pickling of `Record` instances without a custom `__reduce__` method"
        ),
        answerIndex = 0,
        explanation = "When every class in the MRO declares `__slots__` and none include `'__dict__'` in those slots, Python suppresses the per-instance dictionary entirely. Each slot becomes a fixed C-level member descriptor, so instances consume only the memory for the declared attributes rather than a full dict. This pattern is used in performance-critical or high-cardinality scenarios (e.g., millions of small objects) to cut memory usage significantly."
    ),
    Problem(
        id = "fill_hard_37",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with threading",
        summary = "Choose the correct primitive to make an in-memory counter thread-safe.",
        prompt = "Which standard-library primitive fills the blank so that concurrent increments from many threads produce a correct final count without data races?",
        code = """
            import threading

            _lock = ___()
            _count = 0

            def increment():
                global _count
                with _lock:
                    _count += 1

            threads = [threading.Thread(target=increment) for _ in range(1000)]
            for t in threads: t.start()
            for t in threads: t.join()
            print(_count)  # must print 1000
        """.trimIndent(),
        options = listOf(
            "threading.Lock",
            "threading.Event",
            "threading.Semaphore",
            "threading.Barrier"
        ),
        answerIndex = 0,
        explanation = "`threading.Lock()` creates a mutual-exclusion lock. The `with _lock:` block acquires the lock before entering the critical section and releases it on exit, ensuring that only one thread reads, increments, and writes `_count` at a time. `threading.Event` is for signalling between threads. `threading.Semaphore` allows N concurrent holders (the default of 1 would technically work, but `Lock` is the idiomatic choice for mutual exclusion). `threading.Barrier` synchronises a fixed number of threads at a checkpoint."
    ),
    Problem(
        id = "order_hard_36",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache with OrderedDict",
        summary = "Arrange the lines of a minimal LRU cache get() method in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def get(self, key):",
            "    if key not in self.cache:",
            "        return -1",
            "    self.cache.move_to_end(key)",
            "    return self.cache[key]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "An LRU cache `get` first checks whether the key exists; if not, it returns the sentinel -1. If the key is present it must be promoted to the MRU end of the OrderedDict via `move_to_end` before returning the value so that subsequent evictions correctly target the least-recently-used entry."
    ),
    Problem(
        id = "complexity_hard_36",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Bidirectional BFS on an unweighted graph",
        summary = "Compare bidirectional BFS complexity against standard BFS.",
        prompt = "Compared with standard BFS, what is the asymptotic time complexity advantage of bidirectional BFS when the shortest-path length is d and the branching factor is b?",
        code = """
            from collections import deque

            def bidi_bfs(graph, src, dst):
                if src == dst:
                    return 0
                front, back = {src}, {dst}
                dist = 0
                while front and back:
                    dist += 1
                    front = {nbr for node in front for nbr in graph[node]} - front
                    if front & back:
                        return dist
                    dist += 1
                    back = {nbr for node in back for nbr in graph[node]} - back
                    if front & back:
                        return dist
                return -1
        """.trimIndent(),
        options = listOf(
            "Standard BFS is O(b^d); bidirectional BFS is O(b^(d/2)), an exponential improvement",
            "Both are O(b^d); bidirectional BFS only reduces constant factors",
            "Standard BFS is O(V + E); bidirectional BFS is O(V + E / 2)",
            "Bidirectional BFS is always O(d) regardless of branching factor"
        ),
        answerIndex = 0,
        explanation = "Standard BFS from a single source expands a frontier that can reach up to b^d nodes at depth d. Bidirectional BFS expands two frontiers — one from the source and one from the destination — each of depth roughly d/2, so each frontier reaches at most b^(d/2) nodes. The total work is O(2 × b^(d/2)) = O(b^(d/2)), which is exponentially better than O(b^d) for large d. This makes bidirectional BFS a critical optimisation in route-planning and social-graph queries."
    ),
    Problem(
        id = "trace_hard_36",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable vs instance variable in __new__",
        summary = "Track result after __new__ and __init__ interact with class state.",
        prompt = "What value does `result` hold after the code runs?",
        code = """
            class Counter:
                _count = 0

                def __new__(cls, *args, **kwargs):
                    cls._count += 1
                    instance = super().__new__(cls)
                    return instance

                def __init__(self, value):
                    self.value = value

            a = Counter(10)
            b = Counter(20)
            c = Counter(30)
            result = Counter._count
        """.trimIndent(),
        options = listOf("3", "0", "1", "30"),
        answerIndex = 0,
        explanation = "`__new__` is called once per instantiation, before `__init__`. Each call increments the class variable `_count` by 1. After constructing `a`, `b`, and `c`, `_count` equals 3. The `value` attribute is set per instance by `__init__` and does not affect `_count`. `Counter._count` therefore holds 3 at the end."
    ),
    Problem(
        id = "match_hard_36",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: deque([3, 4, 5, 1])",
        summary = "Pick the snippet that produces a specific deque rotation result.",
        prompt = "Which code prints `deque([3, 4, 5, 1])`?",
        code = "deque([3, 4, 5, 1])",
        options = listOf(
            "from collections import deque; d = deque([1, 2, 3, 4, 5]); d.rotate(2); print(d)",
            "from collections import deque; d = deque([1, 2, 3, 4, 5]); d.rotate(-2); print(d)",
            "from collections import deque; d = deque([1, 2, 3, 4, 5]); d.rotate(-2); d.popleft(); print(d)",
            "from collections import deque; d = deque([3, 4, 5, 1, 2]); d.pop(); print(d)"
        ),
        answerIndex = 3,
        explanation = "`deque.pop()` removes from the right end. Starting with `deque([3, 4, 5, 1, 2])`, `pop()` removes `2`, leaving `deque([3, 4, 5, 1])`. Option A: `rotate(2)` shifts right by 2, giving `deque([4, 5, 1, 2, 3])`. Option B: `rotate(-2)` shifts left by 2, giving `deque([3, 4, 5, 1, 2])` — close but has the extra `2`. Option C: `rotate(-2)` gives `deque([3, 4, 5, 1, 2])`, then `popleft()` removes `3`, yielding `deque([4, 5, 1, 2])`. Only option D produces `deque([3, 4, 5, 1])`."
    )
)
