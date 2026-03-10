package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 35.
// One senior-level problem per problem type.
val hardProblems35 = listOf(
    Problem(
        id = "bug_hard_36",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set__ on class attribute access",
        summary = "A data descriptor's __get__ always intercepts reads, even after a direct __dict__ write.",
        prompt = "Why does `obj.value` print `0` instead of `-5` after writing directly to `obj.__dict__`?",
        code = """
            class Clamped:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return max(0, obj.__dict__.get(self.name, 0))

                def __set__(self, obj, value):
                    obj.__dict__[self.name] = max(0, value)

            class Config:
                value = Clamped()

            obj = Config()
            obj.__dict__['value'] = -5   # write directly, bypassing __set__
            print(obj.value)             # prints: 0
        """.trimIndent(),
        options = listOf(
            "Because `Clamped` defines both `__get__` and `__set__` it is a *data* descriptor and data descriptors take priority over `obj.__dict__`, so `obj.__dict__['value'] = -5` is invisible to attribute lookup — `__get__` is always called and clamps the stored value to 0.",
            "Python caches class attribute lookups so the stored dict value is never re-read after first access",
            "Directly writing to `obj.__dict__` raises a `TypeError` for classes that use descriptors",
            "`__set_name__` is called lazily, so `self.name` is empty during `__get__` and the dict lookup silently fails"
        ),
        answerIndex = 0,
        explanation = "A descriptor that defines both `__get__` and `__set__` is a *data descriptor*. Python's attribute lookup order places data descriptors above the instance `__dict__`, so writing directly to `obj.__dict__['value']` does not bypass the descriptor — `__get__` is still invoked on every read, returning `obj.__dict__.get(self.name, 0)` which now sees the -5 stored by the direct dict write, then `max(0, -5)` clamps it to 0. To store an unclamped value you would need to use a different key or remove the descriptor."
    ),
    Problem(
        id = "output_hard_36",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Metaclass __prepare__ and namespace ordering",
        summary = "A metaclass overrides __prepare__ to use an ordered dict that records definition order.",
        prompt = "What is printed when this module-level code runs?",
        code = """
            class OrderedMeta(type):
                @classmethod
                def __prepare__(mcs, name, bases):
                    return {'_order': []}

                def __new__(mcs, name, bases, namespace):
                    namespace['_order'] = [
                        k for k in namespace if not k.startswith('_')
                    ]
                    return super().__new__(mcs, name, bases, namespace)

            class Point(metaclass=OrderedMeta):
                x = 1
                y = 2
                z = 3

            print(Point._order)
        """.trimIndent(),
        options = listOf(
            "['x', 'y', 'z']",
            "['_order', 'x', 'y', 'z']",
            "[]",
            "AttributeError: type object 'Point' has no attribute '_order'"
        ),
        answerIndex = 0,
        explanation = "`__prepare__` returns the initial namespace dict. As the class body executes, `x`, `y`, and `z` are added to that dict in definition order (Python 3.7+ preserves dict insertion order). In `__new__`, `_order` is overwritten with a list comprehension that skips keys starting with `_`, leaving `['x', 'y', 'z']`. The comprehension iterates the namespace dict which already contains `_order` as the first key, but that key is excluded by the `not k.startswith('_')` filter."
    ),
    Problem(
        id = "purpose_hard_36",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "weakref.finalize for resource cleanup",
        summary = "A finalizer callback fires when an object is garbage-collected.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            import weakref

            class Connection:
                def __init__(self, host):
                    self.host = host
                    self._fd = open('/dev/null')
                    weakref.finalize(self, Connection._cleanup, self._fd)

                @staticmethod
                def _cleanup(fd):
                    fd.close()

            conn = Connection('db')
            del conn   # triggers GC; _cleanup called with the file object
        """.trimIndent(),
        options = listOf(
            "Register a deterministic cleanup callback that is called when the `Connection` object is garbage-collected, ensuring the underlying file descriptor is closed even if the caller forgets to call an explicit `close()` method",
            "Prevent the `Connection` object from ever being garbage-collected by holding a strong reference inside the finalizer registry",
            "Serialize the `Connection` object to disk when it goes out of scope so it can be restored in a later session",
            "Lazily open the file descriptor the first time `_cleanup` is called rather than at construction time"
        ),
        answerIndex = 0,
        explanation = "`weakref.finalize(obj, func, *args)` registers a weak reference to `obj` and schedules `func(*args)` to run when `obj` is about to be collected. Because the callback receives `self._fd` (a strong reference captured at registration time) rather than `self`, the file descriptor stays alive until after the callback closes it. This is the recommended alternative to `__del__` because finalizers are more predictable and do not prevent garbage collection of reference cycles."
    ),
    Problem(
        id = "fill_hard_36",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "contextvars.ContextVar for async isolation",
        summary = "Choose the correct API to give each async task its own copy of a variable.",
        prompt = "Which class from the `contextvars` module fills the blank so that each `asyncio` task sees its own isolated `request_id` without sharing state?",
        code = """
            from contextvars import ___
            import asyncio

            request_id: ___[str] = ___('request_id', default='none')

            async def handle(rid: str):
                token = request_id.set(rid)
                await asyncio.sleep(0)          # yield to event loop
                print(request_id.get())         # must print rid, not another task's value
                request_id.reset(token)

            async def main():
                await asyncio.gather(handle('A'), handle('B'))

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "ContextVar",
            "threading.local",
            "contextvars.copy_context",
            "asyncio.Lock"
        ),
        answerIndex = 0,
        explanation = "`contextvars.ContextVar` is the correct tool for per-task context isolation in async code. Each `asyncio` task runs in its own `Context` copy, so `ContextVar.set()` in one task does not affect another. `threading.local` only isolates by OS thread — all coroutines on the same thread would share the value. `copy_context` creates a snapshot but is not itself a variable type. `asyncio.Lock` serialises access but does not provide isolation."
    ),
    Problem(
        id = "order_hard_35",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Topological sort (Kahn's algorithm)",
        summary = "Arrange the lines of a BFS-based topological sort in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def topo_sort(graph):",
            "    in_degree = {u: 0 for u in graph}",
            "    for u in graph:",
            "        for v in graph[u]:",
            "            in_degree[v] += 1",
            "    queue = [u for u in graph if in_degree[u] == 0]",
            "    order = []",
            "    while queue:",
            "        u = queue.pop(0)",
            "        order.append(u)",
            "        for v in graph[u]:",
            "            in_degree[v] -= 1",
            "            if in_degree[v] == 0:",
            "                queue.append(v)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
        explanation = "Kahn's algorithm initialises in-degrees for all nodes, enqueues zero-in-degree nodes, then repeatedly dequeues a node into `order`, decrements the in-degree of its successors, and enqueues any successor whose in-degree drops to zero. The result is a valid topological ordering if the graph is a DAG."
    ),
    Problem(
        id = "complexity_hard_35",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Dijkstra with a min-heap",
        summary = "Determine the time complexity of heap-based shortest-path on a sparse graph.",
        prompt = "What is the time complexity of `dijkstra(graph, src)` where the graph has V nodes and E edges represented as adjacency lists?",
        code = """
            import heapq

            def dijkstra(graph, src):
                dist = {v: float('inf') for v in graph}
                dist[src] = 0
                heap = [(0, src)]
                while heap:
                    d, u = heapq.heappop(heap)
                    if d > dist[u]:
                        continue
                    for v, w in graph[u]:
                        nd = d + w
                        if nd < dist[v]:
                            dist[v] = nd
                            heapq.heappush(heap, (nd, v))
                return dist
        """.trimIndent(),
        options = listOf(
            "O((V + E) log V)",
            "O(V²)",
            "O(E log E)",
            "O(V log V)"
        ),
        answerIndex = 0,
        explanation = "Each edge is relaxed at most once, producing at most E heap pushes. Each push/pop on the binary min-heap costs O(log V) (heap size is bounded by E but duplicates are skipped with the `d > dist[u]` guard, so effective work per node is O(degree × log V)). Total: O((V + E) log V). For dense graphs where E ≈ V², this reduces to O(V² log V), but on sparse graphs (E ≈ V) it is O(V log V)."
    ),
    Problem(
        id = "trace_hard_35",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and coroutine protocol",
        summary = "Track the value yielded after send() is called on a generator.",
        prompt = "What value does `next_val` hold after the code runs?",
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
            gen.send(10)       # total becomes 10; yields 10
            next_val = gen.send(5)   # total becomes 15; yields 15
        """.trimIndent(),
        options = listOf("15", "10", "5", "0"),
        answerIndex = 0,
        explanation = "Calling `next(gen)` starts execution and pauses at `yield total` with `total = 0` (returns 0, discarded). `gen.send(10)` resumes, assigns `value = 10`, adds it to `total` (now 10), loops back, and pauses again at `yield total` returning 10 (discarded). `gen.send(5)` resumes, assigns `value = 5`, adds it to `total` (now 15), and pauses at `yield total` returning 15. So `next_val` is 15."
    ),
    Problem(
        id = "match_hard_35",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n{'a': [1, 2]}\n{'a': [1, 2]}",
        summary = "Pick the snippet that demonstrates shallow-copy aliasing of nested mutable values.",
        prompt = "Which code prints `{'a': [1, 2]}` on both lines?",
        code = "{'a': [1, 2]}\n{'a': [1, 2]}",
        options = listOf(
            "import copy; x = {'a': [1]}; y = x.copy(); y['a'].append(2); print(x); print(y)",
            "import copy; x = {'a': [1]}; y = copy.deepcopy(x); y['a'].append(2); print(x); print(y)",
            "x = {'a': [1]}; y = {'a': [1]}; y['a'].append(2); print(x); print(y)",
            "x = {'a': [1, 2]}; y = dict(x); y['a'] = [1]; print(x); print(y)"
        ),
        answerIndex = 0,
        explanation = "`dict.copy()` creates a *shallow* copy: the top-level dict is a new object, but the value `[1]` is still the same list object in both `x['a']` and `y['a']`. Appending 2 to `y['a']` mutates the shared list, so both `x` and `y` see `[1, 2]`. Option B uses `deepcopy`, so `y['a']` is independent — `x` would still show `[1]`. Option C uses two completely separate lists. Option D replaces `y['a']` with a new list rather than mutating the shared one."
    )
)
