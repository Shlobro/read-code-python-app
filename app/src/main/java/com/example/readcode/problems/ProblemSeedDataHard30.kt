package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 30.
// One senior-level problem per problem type.
val hardProblems30 = listOf(
    Problem(
        id = "bug_hard_31",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding closure captures loop variable",
        summary = "Functions created in a loop all share the same variable reference.",
        prompt = "Why do all functions in `funcs` print `4` instead of 0, 1, 2, 3, 4?",
        code = """
            funcs = []
            for i in range(5):
                funcs.append(lambda: i)
            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "All lambdas close over the same `i` variable, which holds 4 after the loop ends",
            "list comprehensions evaluate lambdas eagerly, freezing `i` at the final value",
            "`lambda: i` is equivalent to `lambda i=0: i` and always returns 0",
            "`range(5)` produces 1–5, so `i` ends at 5 rather than 4"
        ),
        answerIndex = 0,
        explanation = "Python closures capture variable bindings, not values. Every lambda holds a reference to the same `i` in the enclosing scope. By the time any lambda is called, the loop has finished and `i` is 4. Fix: `lambda i=i: i` creates a default-argument copy at definition time."
    ),
    Problem(
        id = "output_hard_31",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO and super() chain",
        summary = "Cooperative multiple inheritance calls each __init__ exactly once.",
        prompt = "What does this code print?",
        code = """
            class A:
                def __init__(self):
                    print("A")
                    super().__init__()

            class B(A):
                def __init__(self):
                    print("B")
                    super().__init__()

            class C(A):
                def __init__(self):
                    print("C")
                    super().__init__()

            class D(B, C):
                def __init__(self):
                    print("D")
                    super().__init__()

            D()
        """.trimIndent(),
        options = listOf(
            "D\nB\nC\nA",
            "D\nB\nA\nC\nA",
            "D\nC\nB\nA",
            "D\nB\nA"
        ),
        answerIndex = 0,
        explanation = "Python's C3 linearization gives D an MRO of [D, B, C, A, object]. Each `super().__init__()` delegates to the next class in this MRO, so the calls proceed D → B → C → A in order and `A.__init__` is invoked only once."
    ),
    Problem(
        id = "purpose_hard_31",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Thread-safe lazy initializer",
        summary = "A descriptor that computes a value once and caches it per instance.",
        prompt = "What is the primary purpose of this descriptor?",
        code = """
            import threading

            class cached_property:
                def __init__(self, func):
                    self.func = func
                    self.lock = threading.Lock()
                    self.attrname = None

                def __set_name__(self, owner, name):
                    self.attrname = name

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    with self.lock:
                        if self.attrname not in obj.__dict__:
                            obj.__dict__[self.attrname] = self.func(obj)
                    return obj.__dict__[self.attrname]
        """.trimIndent(),
        options = listOf(
            "Compute an expensive attribute value once and cache it on the instance, thread-safely",
            "Prevent subclasses from overriding the decorated method",
            "Automatically invalidate the cache whenever the instance's other attributes change",
            "Make the decorated method callable as both a classmethod and an instancemethod"
        ),
        answerIndex = 0,
        explanation = "The descriptor computes `func(obj)` on first access and stores the result directly in `obj.__dict__`, so subsequent reads bypass `__get__` entirely. The lock ensures that two threads racing on the first access do not call the function twice."
    ),
    Problem(
        id = "fill_hard_31",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "itertools.groupby key reset",
        summary = "groupby only groups consecutive equal keys.",
        prompt = "Which built-in or stdlib call fills the blank so consecutive equal values are grouped?",
        code = """
            from itertools import groupby

            data = [1, 1, 2, 2, 1, 1]
            groups = [(k, list(v)) for k, v in ___(data)]
            print(groups)
            # [(1, [1, 1]), (2, [2, 2]), (1, [1, 1])]
        """.trimIndent(),
        options = listOf("groupby", "sorted", "enumerate", "zip"),
        answerIndex = 0,
        explanation = "`itertools.groupby(iterable)` groups consecutive elements that share the same key. Because it only groups runs of equal values, the two separate runs of `1` produce two distinct groups. Passing `sorted(data)` first would merge all `1`s into one group — but that would change the output to two groups, not three."
    ),
    Problem(
        id = "order_hard_30",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache implementation",
        summary = "Arrange a minimal LRU cache using OrderedDict.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import OrderedDict",
            "class LRUCache:",
            "    def __init__(self, capacity):",
            "        self.capacity = capacity",
            "        self.cache = OrderedDict()",
            "    def get(self, key):",
            "        if key not in self.cache:",
            "            return -1",
            "        self.cache.move_to_end(key)",
            "        return self.cache[key]",
            "    def put(self, key, value):",
            "        if key in self.cache:",
            "            self.cache.move_to_end(key)",
            "        self.cache[key] = value",
            "        if len(self.cache) > self.capacity:",
            "            self.cache.popitem(last=False)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "The class stores items in an `OrderedDict` where the most-recently-used key is moved to the end on each access or update. On overflow, `popitem(last=False)` evicts the least-recently-used entry at the front."
    ),
    Problem(
        id = "complexity_hard_30",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Two-pointer with sorted input",
        summary = "Identify the tightest complexity bound when sorting dominates.",
        prompt = "What is the time complexity of `two_sum_sorted`?",
        code = """
            def two_sum_sorted(nums, target):
                nums.sort()
                lo, hi = 0, len(nums) - 1
                while lo < hi:
                    s = nums[lo] + nums[hi]
                    if s == target:
                        return (lo, hi)
                    elif s < target:
                        lo += 1
                    else:
                        hi -= 1
                return None
        """.trimIndent(),
        options = listOf("O(n log n)", "O(n)", "O(n²)", "O(log n)"),
        answerIndex = 0,
        explanation = "The two-pointer scan itself is O(n) because each pointer moves at most n times. However, `nums.sort()` runs in O(n log n), which dominates. The overall complexity is therefore O(n log n)."
    ),
    Problem(
        id = "trace_hard_30",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() protocol",
        summary = "Values sent into a generator become the result of the yield expression.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def accumulator():
                total = 0
                while True:
                    value = yield total
                    if value is None:
                        break
                    total += value

            gen = accumulator()
            next(gen)        # prime the generator
            gen.send(10)
            gen.send(20)
            result = gen.send(5)
        """.trimIndent(),
        options = listOf("35", "5", "30", "0"),
        answerIndex = 0,
        explanation = "`next(gen)` starts the generator and pauses at `yield total` (total=0). Each `send(v)` resumes the generator, assigning `v` to `value`, updating `total`, then pausing again at `yield total`. After sends of 10, 20, and 5, total = 35, so the last `send` returns 35."
    ),
    Problem(
        id = "match_hard_30",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\n{'a': 2, 'b': 3}",
        summary = "Pick the snippet that merges two dicts, with the second taking precedence.",
        prompt = "Which code produces exactly `{'a': 2, 'b': 3}`?",
        code = "{'a': 2, 'b': 3}",
        options = listOf(
            "d = {'a': 1, 'b': 3} | {'a': 2}\nprint(d)",
            "d = {**{'a': 2, 'b': 3}, **{'a': 1}}\nprint(d)",
            "d = {'a': 2} | {'a': 1, 'b': 3}\nprint(d)",
            "d = dict({'a': 1, 'b': 3}, a=1)\nprint(d)"
        ),
        answerIndex = 0,
        explanation = "The `|` merge operator (Python 3.9+) produces a new dict where keys from the right operand override the left. `{'a': 1, 'b': 3} | {'a': 2}` gives `{'a': 2, 'b': 3}`. Option B uses `**` unpacking where the right side wins, so `{**{'a': 2, 'b': 3}, **{'a': 1}}` gives `{'a': 1, 'b': 3}`. Option C has `'a': 1` on the right, overriding to `{'a': 1, 'b': 3}`. Option D also gives `{'a': 1, 'b': 3}`."
    )
)
