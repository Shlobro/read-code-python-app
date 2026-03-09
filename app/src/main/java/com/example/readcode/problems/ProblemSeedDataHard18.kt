package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 18.
// One senior-level problem per problem type.
val hardProblems18 = listOf(
    Problem(
        id = "bug_hard_19",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Shared retry history",
        summary = "A copied request envelope still shares its nested attempt log.",
        prompt = "What is the real bug in this code?",
        code = """
            template = {
                "payload": {"id": 7},
                "meta": {"attempts": []}
            }

            current = dict(template)
            current["meta"]["attempts"].append("retry-1")

            print(template["meta"]["attempts"])
        """.trimIndent(),
        options = listOf(
            "The nested `attempts` list is still shared because `dict(template)` makes only a shallow copy",
            "Appending to a list inside a dictionary always raises `RuntimeError`",
            "The `payload` entry becomes invalid because dictionaries cannot contain other dictionaries",
            "The print call shows `[]` because `current` is fully isolated from `template`"
        ),
        answerIndex = 0,
        explanation = "The outer mapping is copied, but nested objects are reused. Mutating `current[\"meta\"][\"attempts\"]` also mutates the list stored in `template`."
    ),
    Problem(
        id = "output_hard_19",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO-driven `super()` chain",
        summary = "Track cooperative multiple inheritance across the method resolution order.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def run(self):
                    return ["Base"]

            class Left(Base):
                def run(self):
                    return ["Left"] + super().run()

            class Right(Base):
                def run(self):
                    return ["Right"] + super().run()

            class Child(Left, Right):
                def run(self):
                    return ["Child"] + super().run()

            print(" -> ".join(Child().run()))
        """.trimIndent(),
        options = listOf(
            "Child -> Left -> Right -> Base",
            "Child -> Left -> Base -> Right",
            "Child -> Right -> Left -> Base",
            "Child -> Left -> Right"
        ),
        answerIndex = 0,
        explanation = "The MRO for `Child(Left, Right)` is `Child, Left, Right, Base`. Each cooperative `super()` call advances through that order once."
    ),
    Problem(
        id = "purpose_hard_19",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Descriptor-backed cached property",
        summary = "The descriptor computes once, stores on the instance, and then bypasses itself.",
        prompt = "What does this descriptor do overall?",
        code = """
            class cached:
                def __init__(self, func):
                    self.func = func
                    self.name = func.__name__

                def __get__(self, instance, owner):
                    if instance is None:
                        return self
                    value = self.func(instance)
                    instance.__dict__[self.name] = value
                    return value
        """.trimIndent(),
        options = listOf(
            "It implements a lazy instance attribute that computes once and then stores the result on the object",
            "It prevents the method from being called on instances and allows only class-level access",
            "It validates that the wrapped function returns a hashable value before assignment",
            "It turns the wrapped function into a classmethod for every subclass"
        ),
        answerIndex = 0,
        explanation = "On first attribute access, `__get__` computes the value and writes it into `instance.__dict__`. Later lookups hit the stored attribute directly instead of recomputing."
    ),
    Problem(
        id = "fill_hard_19",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Preserve metadata in a decorator",
        summary = "The wrapper should keep the original function name and docstring.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            from functools import ___

            def logged(func):
                @___(func)
                def wrapper(*args, **kwargs):
                    print(func.__name__)
                    return func(*args, **kwargs)
                return wrapper
        """.trimIndent(),
        options = listOf("wraps", "partial", "lru_cache", "reduce"),
        answerIndex = 0,
        explanation = "`functools.wraps` copies metadata such as `__name__`, `__doc__`, and `__module__` from the wrapped function onto `wrapper`."
    ),
    Problem(
        id = "order_hard_18",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache with `OrderedDict`",
        summary = "Arrange the lines for an `LRUCache.get()` implementation that promotes hits.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import OrderedDict",
            "class LRUCache:",
            "    def __init__(self):",
            "        self.data = OrderedDict()",
            "    def get(self, key):",
            "        if key not in self.data:",
            "            return None",
            "        value = self.data.pop(key)",
            "        self.data[key] = value",
            "        return value"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        explanation = "An LRU cache lookup checks for a miss, removes the existing key on a hit, then reinserts it so the entry becomes the most recently used."
    ),
    Problem(
        id = "complexity_hard_18",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Heap-backed top-k stream",
        summary = "The heap size is capped while processing each incoming value once.",
        prompt = "If `n` values are processed and the heap is kept at size at most `k`, what is the time complexity?",
        code = """
            import heapq

            def top_k(values, k):
                heap = []
                for value in values:
                    if len(heap) < k:
                        heapq.heappush(heap, value)
                    elif value > heap[0]:
                        heapq.heapreplace(heap, value)
                return heap
        """.trimIndent(),
        options = listOf("O(n log k)", "O(nk)", "O(k log n)", "O(n log n)"),
        answerIndex = 0,
        explanation = "Each of the `n` elements is inspected once, and each heap update costs `O(log k)` because the heap never grows beyond size `k`."
    ),
    Problem(
        id = "trace_hard_18",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Closure state across calls",
        summary = "Track a `nonlocal` counter that is updated before and after the returned value is captured.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def make_counter():
                total = 0

                def step(delta):
                    nonlocal total
                    total += delta
                    snapshot = total
                    total *= 2
                    return snapshot

                return step

            counter = make_counter()
            counter(3)
            result = counter(4)
        """.trimIndent(),
        options = listOf("10", "7", "14", "20"),
        answerIndex = 0,
        explanation = "First call: `total` becomes 3, snapshot is 3, then `total` becomes 6. Second call: `total` becomes 10, snapshot is 10, then `total` becomes 20. `result` stores the snapshot."
    ),
    Problem(
        id = "match_hard_18",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: ['b', 'c', 'a']",
        summary = "Pick the snippet that rotates a deque left by one position.",
        prompt = "Which code produces exactly `['b', 'c', 'a']`?",
        code = "",
        options = listOf(
            "from collections import deque\nqueue = deque(['a', 'b', 'c'])\nqueue.append(queue.popleft())\nprint(list(queue))",
            "from collections import deque\nqueue = deque(['a', 'b', 'c'])\nqueue.appendleft(queue.pop())\nprint(list(queue))",
            "from collections import deque\nqueue = deque(['a', 'b', 'c'])\nqueue.rotate(1)\nprint(list(queue))",
            "from collections import deque\nqueue = deque(['a', 'b', 'c'])\nqueue.popleft()\nprint(list(queue))"
        ),
        answerIndex = 0,
        explanation = "Popping from the left and appending that value to the right rotates the deque left by one position, producing `['b', 'c', 'a']`."
    )
)
