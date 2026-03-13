package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 59.
// One senior-level problem per problem type.
val hardProblems59 = listOf(
    Problem(
        id = "bug_hard_60",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Generator exhausted silently",
        summary = "A generator expression is consumed on the first call and returns nothing on subsequent calls.",
        prompt = "What is the bug in this code?",
        code = """
            def make_pipeline(data):
                gen = (x * 2 for x in data)
                total = sum(gen)
                items = list(gen)
                return total, items

            print(make_pipeline([1, 2, 3]))
        """.trimIndent(),
        options = listOf(
            "`gen` is exhausted by `sum`, so `list(gen)` produces `[]`",
            "`sum` raises `TypeError` because generator objects are not summable",
            "Generator expressions cannot be assigned to a variable before use",
            "`list(gen)` creates a copy, so both `total` and `items` operate on the full sequence"
        ),
        answerIndex = 0,
        explanation = "A generator can only be iterated once. After `sum(gen)` consumes all values, the generator is exhausted. `list(gen)` then returns an empty list. The fix is to materialise the data first with `list(data)` or iterate separately."
    ),
    Problem(
        id = "output_hard_60",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor protocol priority",
        summary = "A data descriptor (defines `__set__`) takes priority over an instance `__dict__` entry.",
        prompt = "What does this code print?",
        code = """
            class Const:
                def __get__(self, obj, objtype=None):
                    return 42
                def __set__(self, obj, value):
                    pass

            class Foo:
                x = Const()

            f = Foo()
            f.__dict__['x'] = 99
            print(f.x)
        """.trimIndent(),
        options = listOf(
            "42",
            "99",
            "AttributeError",
            "None"
        ),
        answerIndex = 0,
        explanation = "A data descriptor (one that defines both `__get__` and `__set__`) has higher priority than the instance `__dict__`. Even though `f.__dict__['x'] = 99` writes directly to the instance dictionary, attribute lookup for `f.x` finds the data descriptor on the class first and calls `__get__`, returning 42."
    ),
    Problem(
        id = "purpose_hard_60",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "LRU cache with manual size limit",
        summary = "An `OrderedDict` is used to implement a fixed-capacity LRU cache.",
        prompt = "What does this class do?",
        code = """
            from collections import OrderedDict

            class LRUCache:
                def __init__(self, cap):
                    self.cap = cap
                    self.cache = OrderedDict()

                def get(self, key):
                    if key not in self.cache:
                        return -1
                    self.cache.move_to_end(key)
                    return self.cache[key]

                def put(self, key, value):
                    if key in self.cache:
                        self.cache.move_to_end(key)
                    self.cache[key] = value
                    if len(self.cache) > self.cap:
                        self.cache.popitem(last=False)
        """.trimIndent(),
        options = listOf(
            "It is a fixed-capacity LRU cache that evicts the least recently used entry on overflow",
            "It sorts entries by insertion order and removes the newest entry when the cache becomes full",
            "It raises `KeyError` when a missing key is requested instead of returning -1",
            "It implements a fixed-capacity FIFO queue backed by a dictionary"
        ),
        answerIndex = 0,
        explanation = "`move_to_end` promotes a key to the back (most-recently-used end). When capacity is exceeded, `popitem(last=False)` removes the front entry, which is the least recently used. This is the classic O(1) LRU cache pattern using `OrderedDict`."
    ),
    Problem(
        id = "fill_hard_60",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Thread-safe singleton with a lock",
        summary = "A double-checked locking pattern uses a class-level `Lock` to guard singleton creation.",
        prompt = "Fill the blank so the singleton is only created once even under concurrent access.",
        code = """
            import threading

            class Singleton:
                _instance = None
                _lock = threading.Lock()

                @classmethod
                def get_instance(cls):
                    if cls._instance is None:
                        ___(cls._lock):
                            if cls._instance is None:
                                cls._instance = cls()
                    return cls._instance
        """.trimIndent(),
        options = listOf(
            "with",
            "lock",
            "acquire",
            "synchronized"
        ),
        answerIndex = 0,
        explanation = "The `with` statement acquires the lock on entry and releases it on exit, even if an exception is raised. The outer check avoids the lock overhead once the instance exists; the inner check prevents a race between threads that both passed the outer check."
    ),
    Problem(
        id = "order_hard_59",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the lines of a standard two-pointer merge of two sorted lists.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "result = []",
            "i = j = 0",
            "while i < len(a) and j < len(b):",
            "    if a[i] <= b[j]: result.append(a[i]); i += 1",
            "    else: result.append(b[j]); j += 1",
            "result.extend(a[i:])",
            "result.extend(b[j:])"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Initialise the output list and two indices, then advance through whichever list has the smaller current element. After the loop one list may still have remaining elements; extend with both tails (one will always be empty)."
    ),
    Problem(
        id = "complexity_hard_59",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Topological sort with DFS",
        summary = "A recursive DFS visits each node and edge once to produce a topological order.",
        prompt = "What is the time complexity?",
        code = """
            def topo_sort(graph):
                visited = set()
                order = []

                def dfs(node):
                    visited.add(node)
                    for neighbor in graph[node]:
                        if neighbor not in visited:
                            dfs(neighbor)
                    order.append(node)

                for node in graph:
                    if node not in visited:
                        dfs(node)

                return order[::-1]
        """.trimIndent(),
        options = listOf(
            "O(V + E)",
            "O(V^2)",
            "O(E log V)",
            "O(V * E)"
        ),
        answerIndex = 0,
        explanation = "Each vertex is added to `visited` once (O(V)) and each edge is examined once when iterating neighbors (O(E)). The reversal at the end is O(V). Total: O(V + E), the standard DFS complexity on an adjacency-list graph."
    ),
    Problem(
        id = "trace_hard_59",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Closure captures loop variable by reference",
        summary = "All lambdas in a list share the same `i` variable from the enclosing scope.",
        prompt = "What does this code print?",
        code = """
            fns = [lambda: i for i in range(3)]
            print(fns[0](), fns[1](), fns[2]())
        """.trimIndent(),
        options = listOf(
            "2 2 2",
            "0 1 2",
            "0 0 0",
            "2 1 0"
        ),
        answerIndex = 0,
        explanation = "Each lambda captures the variable `i` by reference, not by value. After the list comprehension finishes, `i` equals 2. All three lambdas therefore return 2 when called. To capture the current value, use a default argument: `lambda i=i: i`."
    ),
    Problem(
        id = "match_hard_59",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: Counter({'a': 3, 'b': 2})",
        summary = "Pick the snippet whose print output matches the given Counter repr exactly.",
        prompt = "Which code produces this output?",
        code = "Counter({'a': 3, 'b': 2})",
        options = listOf(
            "from collections import Counter\nprint(Counter('aaabb'))",
            "from collections import Counter\nc=Counter('aabb')\nc['a']+=1\nc['b']+=1\nprint(c)",
            "from collections import Counter\nprint(Counter({'a':3,'b':2,'c':0}))",
            "from collections import Counter\nc=Counter(['a','a','b','b','b'])\nc['a']+=1\nprint(c)"
        ),
        answerIndex = 0,
        explanation = "`Counter('aaabb')` counts three `'a'`s and two `'b'`s, printing `Counter({'a': 3, 'b': 2})`. Option B starts with `Counter('aabb')` ({a:2,b:2}) then increments both, giving {a:3,b:3}. Option C includes a zero-count key `'c'` which appears in the repr. Option D starts {a:2,b:3} then adds 1 to `'a'`, giving {a:3,b:3}."
    )
)
