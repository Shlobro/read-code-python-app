package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 64.
// One senior-level problem per problem type.
val hardProblems64 = listOf(
    Problem(
        id = "bug_hard_65",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "asyncio.run inside running loop",
        summary = "Calling asyncio.run() from within an already-running event loop raises RuntimeError.",
        prompt = "What is the bug in this code?",
        code = """
            import asyncio

            async def fetch():
                return 42

            async def main():
                result = asyncio.run(fetch())
                print(result)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "`asyncio.run` cannot be called inside a coroutine that is already running on a loop",
            "`fetch` must use `yield` instead of `return` to work with async",
            "`asyncio.run(main())` requires Python 3.11 or later",
            "The outer `asyncio.run` call must be wrapped in `if __name__ == '__main__'`"
        ),
        answerIndex = 0,
        explanation = "`asyncio.run` creates a new event loop and blocks; calling it from inside a coroutine that is already executing on a loop raises `RuntimeError: This event loop is already running`. The correct fix is to use `await fetch()` inside the coroutine."
    ),
    Problem(
        id = "output_hard_65",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "super() in diamond inheritance",
        summary = "MRO determines which __init__ super() calls in a diamond hierarchy.",
        prompt = "What does this code print?",
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

            D()
        """.trimIndent(),
        options = listOf(
            "A\nB\nD",
            "A\nC\nB\nD",
            "A\nB\nC\nD",
            "B\nA\nD"
        ),
        answerIndex = 1,
        explanation = "Python's MRO for D is [D, B, C, A]. `super()` in D calls B.__init__, which calls C.__init__ (next in MRO), which calls A.__init__. Print order follows the call return sequence: A prints first, then C, then B, then D."
    ),
    Problem(
        id = "purpose_hard_65",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Descriptor __set_name__",
        summary = "A descriptor uses __set_name__ to record its attribute name on the owner class.",
        prompt = "What does this class do?",
        code = """
            class Typed:
                def __set_name__(self, owner, name):
                    self.attr = f"_{name}"

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return getattr(obj, self.attr, None)

                def __set__(self, obj, value):
                    if not isinstance(value, int):
                        raise TypeError("int required")
                    setattr(obj, self.attr, value)
        """.trimIndent(),
        options = listOf(
            "Stores any attribute type, converting it to int before saving",
            "Enforces that assigned values are ints, storing them under a private name",
            "Prevents any attribute from being set more than once on the owning class",
            "Proxies attribute access to a hidden dict and logs every read and write to stderr"
        ),
        answerIndex = 1,
        explanation = "`__set_name__` captures the attribute name at class-creation time. `__set__` rejects non-int values with `TypeError`. `__get__` reads from the private storage attribute. Together this is a type-enforcing descriptor."
    ),
    Problem(
        id = "fill_hard_65",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "itertools.chain.from_iterable",
        summary = "Flatten a list of lists with a single itertools call.",
        prompt = "Fill the blank so `flat` is `[1, 2, 3, 4, 5]`.",
        code = """
            import itertools

            nested = [[1, 2], [3], [4, 5]]
            flat = list(itertools._____(nested))
            print(flat)
        """.trimIndent(),
        options = listOf(
            "chain.from_iterable",
            "flatten",
            "chain(*nested)",
            "reduce(list.__add__, nested)"
        ),
        answerIndex = 0,
        explanation = "`itertools.chain.from_iterable(nested)` lazily chains the sub-iterables without unpacking. `chain(*nested)` also works but requires unpacking; `flatten` and `reduce` are not single-call itertools forms filling the blank shown."
    ),
    Problem(
        id = "order_hard_64",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge sort split and merge",
        summary = "Arrange the core steps of a recursive merge sort into the correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sort(arr):",
            "    if len(arr) <= 1:",
            "        return arr",
            "    mid = len(arr) // 2",
            "    left = merge_sort(arr[:mid])",
            "    right = merge_sort(arr[mid:])",
            "    return merge(left, right)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "Define the function, handle the base case (length ≤ 1), compute the midpoint, recursively sort each half, then merge the two sorted halves."
    ),
    Problem(
        id = "complexity_hard_64",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "All-pairs shortest path (Floyd-Warshall)",
        summary = "Triple nested loop over N vertices computing shortest paths.",
        prompt = "What is the time complexity and additional space complexity of this algorithm?",
        code = """
            def floyd_warshall(dist):
                n = len(dist)
                for k in range(n):
                    for i in range(n):
                        for j in range(n):
                            if dist[i][k] + dist[k][j] < dist[i][j]:
                                dist[i][j] = dist[i][k] + dist[k][j]
                return dist
        """.trimIndent(),
        options = listOf(
            "O(n²) time, O(n²) space",
            "O(n³) time, O(1) space",
            "O(n³) time, O(n²) space",
            "O(n² log n) time, O(n²) space"
        ),
        answerIndex = 1,
        explanation = "Three nested loops each of size n give O(n³) time. The algorithm mutates the input matrix in-place, using only loop index variables as extra state — O(1) additional space. The n×n matrix is input, not auxiliary."
    ),
    Problem(
        id = "trace_hard_64",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Late-binding in list comprehension",
        summary = "Closures in a list comprehension capture the loop variable by reference.",
        prompt = "What does this code print?",
        code = """
            funcs = [lambda: i for i in range(4)]
            print(funcs[0](), funcs[2]())
        """.trimIndent(),
        options = listOf(
            "0 2",
            "3 3",
            "0 0",
            "0 3"
        ),
        answerIndex = 1,
        explanation = "Each lambda closes over the same variable `i`. After the comprehension, `i` is 3 (the last value). All lambdas therefore return 3, so both `funcs[0]()` and `funcs[2]()` print 3."
    ),
    Problem(
        id = "match_hard_64",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: weakref callback fires",
        summary = "Pick the snippet that prints 'gone' when the referent is deleted.",
        prompt = "Which code produces that output?",
        code = "gone",
        options = listOf(
            "import weakref\nclass T: pass\ndef cb(r): print('gone')\nt = T()\nwr = weakref.ref(t, cb)\ndel t",
            "import weakref\nclass T: pass\nt = T()\nwr = weakref.ref(t)\ndel t\nprint(wr())",
            "import weakref\nclass T: pass\nt = T()\nwr = weakref.proxy(t)\ndel t\nprint(wr)",
            "import weakref\nclass T: pass\nt = T()\nref = weakref.ref(t)\nprint(ref())"
        ),
        answerIndex = 0,
        explanation = "`weakref.ref(t, cb)` registers `cb` as a finalisation callback. When `del t` drops the last strong reference, the garbage collector calls `cb(wr)` which prints 'gone'. Option B prints `None` (dead weakref). Option C raises `ReferenceError` when accessing a dead proxy. Option D prints the live object repr, not 'gone'."
    )
)
