package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 58.
// One senior-level problem per problem type.
val hardProblems58 = listOf(
    Problem(
        id = "bug_hard_59",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Weakref callback fires too early",
        summary = "A weak reference to a local object is created, but the object is immediately collected.",
        prompt = "What is the bug in this code?",
        code = """
            import weakref

            def make_ref():
                class Obj: pass
                obj = Obj()
                ref = weakref.ref(obj)
                return ref

            r = make_ref()
            print(r())
        """.trimIndent(),
        options = listOf(
            "`obj` is collected when `make_ref` returns, so `r()` is `None`",
            "`weakref.ref` raises `TypeError` on classes defined inside a function",
            "`weakref.ref` objects cannot be returned across function boundaries",
            "`print(r())` must be called inside `make_ref` before `obj` is freed"
        ),
        answerIndex = 0,
        explanation = "A weak reference does not keep the referent alive. `obj` has no strong references after `make_ref` returns, so the GC collects it and `r()` returns `None`."
    ),
    Problem(
        id = "output_hard_59",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "`__slots__` and `__dict__` absence",
        summary = "A class with `__slots__` has no `__dict__` by default.",
        prompt = "What does this code print?",
        code = """
            class Point:
                __slots__ = ('x', 'y')

            p = Point()
            p.x = 1
            print(hasattr(p, '__dict__'))
            print(p.x)
        """.trimIndent(),
        options = listOf(
            "False\n1",
            "True\n1",
            "False\nAttributeError",
            "True\nAttributeError"
        ),
        answerIndex = 0,
        explanation = "Declaring `__slots__` suppresses the per-instance `__dict__`, so `hasattr(p, '__dict__')` is `False`. Slot attributes (`x`, `y`) are still accessible normally."
    ),
    Problem(
        id = "purpose_hard_59",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Cooperative `super()` in MRO chain",
        summary = "Two sibling mixins both call `super().__init__` and the order is determined by the MRO.",
        prompt = "What does this code do overall?",
        code = """
            class A:
                def __init__(self):
                    print("A")

            class B(A):
                def __init__(self):
                    super().__init__()
                    print("B")

            class C(A):
                def __init__(self):
                    super().__init__()
                    print("C")

            class D(B, C):
                def __init__(self):
                    super().__init__()
                    print("D")
        """.trimIndent(),
        options = listOf(
            "It uses cooperative inheritance so `A.__init__` runs exactly once via the MRO",
            "It raises `TypeError` because `B` and `C` both inherit from `A`, creating ambiguity",
            "It calls `A.__init__` twice — once through `B` and once through `C`",
            "It skips `C.__init__` entirely because `B` is listed first in `D`'s base classes"
        ),
        answerIndex = 0,
        explanation = "Python's MRO for `D` is `D → B → C → A`. `super()` in each class delegates to the next in that chain, so `A.__init__` is called exactly once. This is the standard cooperative-inheritance pattern."
    ),
    Problem(
        id = "fill_hard_59",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Partitioning with `itertools`",
        summary = "Group consecutive elements that share a computed key.",
        prompt = "Fill the blank to group consecutive equal-parity integers.",
        code = """
            from itertools import ___

            data = [2, 4, 1, 3, 6, 8]
            for key, group in ___(data, key=lambda x: x % 2):
                print(key, list(group))
        """.trimIndent(),
        options = listOf(
            "groupby",
            "chain",
            "accumulate",
            "islice"
        ),
        answerIndex = 0,
        explanation = "`itertools.groupby` groups consecutive elements that share the same key value. It does not sort — it only groups runs. Here it separates even and odd runs as the parity changes."
    ),
    Problem(
        id = "order_hard_58",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Binary search (iterative)",
        summary = "Arrange the lines of a standard iterative binary search.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "lo, hi = 0, len(arr) - 1",
            "while lo <= hi:",
            "    mid = (lo + hi) // 2",
            "    if arr[mid] == target: return mid",
            "    elif arr[mid] < target: lo = mid + 1",
            "    else: hi = mid - 1",
            "return -1"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Set the initial bounds, then loop while the search space is non-empty: compute mid, return on an exact match, narrow the bounds based on the comparison, and return -1 when exhausted."
    ),
    Problem(
        id = "complexity_hard_58",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Finding all pairs with target sum",
        summary = "A function uses a set to find all index pairs whose values sum to a target.",
        prompt = "What is the time complexity?",
        code = """
            def pair_sum(nums, target):
                seen = set()
                pairs = []
                for x in nums:
                    if target - x in seen:
                        pairs.append((target - x, x))
                    seen.add(x)
                return pairs
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n^2)",
            "O(n log n)",
            "O(n + k) where k is the number of pairs found"
        ),
        answerIndex = 0,
        explanation = "The loop runs once over n elements. Each `in` check and `add` on a hash set is O(1) average. Appending to `pairs` is O(1) amortized. Overall the function is O(n) regardless of how many pairs are found."
    ),
    Problem(
        id = "trace_hard_58",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class-level vs instance-level attribute mutation",
        summary = "Augmented assignment on an instance attribute shadows the class attribute.",
        prompt = "What does this code print?",
        code = """
            class Counter:
                count = 0

            a = Counter()
            b = Counter()
            a.count += 1
            b.count += 10
            print(Counter.count, a.count, b.count)
        """.trimIndent(),
        options = listOf(
            "0 1 10",
            "11 1 10",
            "0 0 10",
            "1 1 10"
        ),
        answerIndex = 0,
        explanation = "`a.count += 1` reads `Counter.count` (0), adds 1, and assigns the result to the *instance* attribute `a.count`. It does not mutate the class attribute. The same happens for `b`. So `Counter.count` remains `0`, `a.count` is `1`, `b.count` is `10`."
    ),
    Problem(
        id = "match_hard_58",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: deque([3, 1, 2], maxlen=3)",
        summary = "Pick the snippet whose print output matches the given deque repr exactly.",
        prompt = "Which code produces this output?",
        code = "deque([3, 1, 2], maxlen=3)",
        options = listOf(
            "from collections import deque\nd=deque([1,2],maxlen=3)\nd.appendleft(3)\nprint(d)",
            "from collections import deque\nd=deque([3,1,2,4],maxlen=3)\nprint(d)",
            "from collections import deque\nprint(deque([3,1,2]))",
            "from collections import deque\nd=deque(maxlen=3)\nd.extend([1,2,3])\nd.appendleft(0)\nprint(d)"
        ),
        answerIndex = 0,
        explanation = "Option A creates `deque([1,2], maxlen=3)` then prepends `3`, giving `deque([3,1,2], maxlen=3)`. Option B drops the oldest element (3) when 4 is added, printing `deque([1,2,4], maxlen=3)`. Option C has no maxlen. Option D: after extend `[1,2,3]` then appendleft `0`, the deque evicts `3` and holds `[0,1,2]`."
    )
)
