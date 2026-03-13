package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 62.
// One senior-level problem per problem type.
val hardProblems62 = listOf(
    Problem(
        id = "bug_hard_63",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure captures loop variable",
        summary = "Lambda bodies in a list comprehension capture the variable by reference, not by value.",
        prompt = "What is the bug in this code?",
        code = """
            funcs = [lambda x: x + i for i in range(3)]
            print([f(0) for f in funcs])
        """.trimIndent(),
        options = listOf(
            "Lambdas in a comprehension cannot reference outer variables at all",
            "All lambdas close over the same `i`; after the loop `i` is 2, so the output is `[2, 2, 2]`",
            "The list comprehension raises `NameError` because `i` is not in scope when the lambdas are called",
            "Each lambda captures a copy of `i` at creation time and works correctly"
        ),
        answerIndex = 1,
        explanation = "Python closures capture variables by reference, not by value. After the loop, `i` holds 2. Every lambda then evaluates `0 + 2`. Fix with a default argument: `lambda x, i=i: x + i`."
    ),
    Problem(
        id = "output_hard_63",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO with diamond inheritance",
        summary = "Python's C3 linearisation determines which `greet` is called in a diamond hierarchy.",
        prompt = "What does this code print?",
        code = """
            class A:
                def greet(self): return "A"

            class B(A):
                def greet(self): return "B"

            class C(A):
                def greet(self): return "C"

            class D(B, C):
                pass

            print(D().greet())
        """.trimIndent(),
        options = listOf(
            "A",
            "C",
            "B",
            "B\nC"
        ),
        answerIndex = 2,
        explanation = "Python's MRO for `D` is `[D, B, C, A]`. `D.greet` is not defined, so the lookup moves to `B`, which defines `greet`. `B.greet` returns `'B'`, and the search stops there — `C.greet` is never reached."
    ),
    Problem(
        id = "purpose_hard_63",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ for lazy computation",
        summary = "A descriptor computes an expensive value once and caches it on the instance.",
        prompt = "What does this descriptor do?",
        code = """
            class cached_property:
                def __init__(self, func):
                    self.func = func
                    self.attr = func.__name__

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    value = self.func(obj)
                    setattr(obj, self.attr, value)
                    return value
        """.trimIndent(),
        options = listOf(
            "Prevents attribute access from subclasses by raising AttributeError when obj is None",
            "Calls the wrapped function every time the attribute is accessed to keep it fresh",
            "Computes the value once on first access, then stores it on the instance to skip future calls",
            "Validates that the computed value is not None before storing it"
        ),
        answerIndex = 2,
        explanation = "On first access `__get__` calls `self.func(obj)`, then uses `setattr` to write the result directly onto the instance under the same name. Future accesses find the plain instance attribute in `obj.__dict__` before the descriptor is consulted, so the function is never called again."
    ),
    Problem(
        id = "fill_hard_63",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "weakref to avoid reference cycles",
        summary = "A weak reference does not prevent garbage collection of the referent.",
        prompt = "Fill the blank so that the cache holds a weak reference to each value.",
        code = """
            import weakref

            cache = {}

            def store(key, obj):
                cache[key] = ___(obj)

            def retrieve(key):
                ref = cache.get(key)
                return ref() if ref is not None else None
        """.trimIndent(),
        options = listOf(
            "ref",
            "weakref.ref",
            "weakref.proxy",
            "weakref.WeakValueDictionary"
        ),
        answerIndex = 1,
        explanation = "`weakref.ref(obj)` creates a callable weak reference. Calling `ref()` returns the object if it is still alive, or `None` if it has been collected. `weakref.proxy` creates a transparent proxy but cannot be stored as a plain dict value without issues. `WeakValueDictionary` is an alternative pattern but is not a drop-in for `___` here."
    ),
    Problem(
        id = "order_hard_62",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the lines of an in-place merge of two sorted lists into one sorted list.",
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
        explanation = "Initialise the output list and two pointers. Advance whichever pointer points to the smaller element. After the main loop, append any remaining elements from both tails (at most one tail will be non-empty)."
    ),
    Problem(
        id = "complexity_hard_62",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "LRU cache with OrderedDict",
        summary = "Each get/put moves one entry in an OrderedDict; the capacity eviction is O(1).",
        prompt = "What is the time complexity of a single `get` or `put` call?",
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
            "O(n) — OrderedDict operations scan the list",
            "O(log n) — the dict is kept in sorted order",
            "O(1)",
            "O(n log n) — each insertion may re-sort"
        ),
        answerIndex = 2,
        explanation = "CPython's `OrderedDict` is backed by a hash map and a doubly linked list. `move_to_end`, `__setitem__`, `__getitem__`, and `popitem` are all O(1) pointer operations. Each `get` or `put` performs a constant number of these, giving O(1) overall."
    ),
    Problem(
        id = "trace_hard_62",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Metaclass `__call__` singleton enforcement",
        summary = "A metaclass overrides `__call__` to return the same instance on every construction.",
        prompt = "What does this code print?",
        code = """
            class SingletonMeta(type):
                _instances = {}
                def __call__(cls, *args, **kwargs):
                    if cls not in cls._instances:
                        cls._instances[cls] = super().__call__(*args, **kwargs)
                    return cls._instances[cls]

            class Config(metaclass=SingletonMeta):
                def __init__(self, val):
                    self.val = val

            a = Config(1)
            b = Config(2)
            print(a is b, b.val)
        """.trimIndent(),
        options = listOf(
            "False 2",
            "True 2",
            "False 1",
            "True 1"
        ),
        answerIndex = 3,
        explanation = "`SingletonMeta.__call__` creates the instance only on the first call and stores it. The second `Config(2)` call finds `Config` already in `_instances` and returns the original object without calling `__init__` again. So `a is b` is `True` and `b.val` is still `1`."
    ),
    Problem(
        id = "match_hard_62",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 2] [3]",
        summary = "Pick the snippet whose output is exactly two lines: `[1, 2]` then `[3]`.",
        prompt = "Which code produces this output?",
        code = "[1, 2]\n[3]",
        options = listOf(
            "it = iter([1,2,3])\nprint(list(it))\nprint(list(it))",
            "it = iter([1,2,3])\nprint([next(it), next(it)])\nprint([next(it)])",
            "it = iter([1,2,3])\nprint(list(itertools.islice(it, 2)))\nprint(list(it))",
            "it = iter([1,2,3])\nprint([x for x in it if x < 3])\nprint(list(it))"
        ),
        answerIndex = 1,
        explanation = "Option B manually advances the iterator twice with `next`, then once more. Options A exhausts the iterator on the first `list()` call, leaving an empty second list. Option C needs `import itertools`. Option D's comprehension consumes all three elements (it sees 3 but the condition is false, not a break), leaving nothing for the second list."
    )
)
