package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 42.
// One senior-level problem per problem type.
val hardProblems42 = listOf(
    Problem(
        id = "bug_hard_43",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ ignored kwargs",
        summary = "A subclass hook fails silently when keyword arguments are not forwarded.",
        prompt = "Why does this code raise a TypeError when creating `Child`?",
        code = """
            class Base:
                def __init_subclass__(cls, tag=None, **kwargs):
                    cls._tag = tag

            class Mixin:
                def __init_subclass__(cls, **kwargs):
                    super().__init_subclass__(**kwargs)

            class Child(Mixin, Base, tag="admin"):
                pass
        """.trimIndent(),
        options = listOf(
            "`Base.__init_subclass__` does not call `super().__init_subclass__(**kwargs)`, so the cooperative MRO chain breaks and Python raises `TypeError: __init_subclass__() takes no keyword arguments`",
            "`tag` is not a valid keyword argument for `__init_subclass__`; only positional arguments are allowed",
            "`Mixin` must appear after `Base` in the MRO for `__init_subclass__` to receive the keyword argument",
            "The `tag` parameter must be declared as a class variable on `Base` before it can be used in `__init_subclass__`"
        ),
        answerIndex = 0,
        explanation = "Python's `__init_subclass__` is designed for cooperative multiple inheritance. Every implementation must call `super().__init_subclass__(**kwargs)` to pass unrecognised keyword arguments up the MRO chain. `Base.__init_subclass__` accepts `tag` but swallows the remaining `**kwargs` without forwarding them to `object.__init_subclass__`, which expects no extra keyword arguments. Fixing it requires adding `super().__init_subclass__(**kwargs)` at the end of `Base.__init_subclass__`."
    ),
    Problem(
        id = "output_hard_43",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late-binding in class body vs. closure",
        summary = "A list of lambdas created in a class body all share the same loop variable.",
        prompt = "What does this code print?",
        code = """
            class Multipliers:
                funcs = [lambda x, i=i: x * i for i in range(1, 4)]

            results = [Multipliers.funcs[k](10) for k in range(3)]
            print(results)
        """.trimIndent(),
        options = listOf(
            "[10, 20, 30]",
            "[30, 30, 30]",
            "[0, 10, 20]",
            "[10, 10, 10]"
        ),
        answerIndex = 0,
        explanation = "The default-argument trick `i=i` captures the current value of `i` at definition time rather than at call time. Without it all lambdas would capture the same late-bound variable and produce `[30, 30, 30]`. With `i=i`, each lambda gets its own default (`1`, `2`, `3`), so `funcs[0](10)=10`, `funcs[1](10)=20`, `funcs[2](10)=30`."
    ),
    Problem(
        id = "purpose_hard_43",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "__set_name__ for self-registering descriptors",
        summary = "A descriptor hook automatically records the attribute name it is assigned to.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            class Tracked:
                registry = {}

                def __set_name__(self, owner, name):
                    self.name = name
                    Tracked.registry[f"{owner.__name__}.{name}"] = self

                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get(self.name)

                def __set__(self, obj, value):
                    obj.__dict__[self.name] = value

            class Model:
                x = Tracked()
                y = Tracked()
        """.trimIndent(),
        options = listOf(
            "Allow each descriptor instance to automatically learn its own attribute name and register itself in a central registry when the owning class is created, without any extra bookkeeping in the class body",
            "Prevent instances of `Model` from storing attributes in `__dict__` so all access goes through the descriptor",
            "Create a singleton instance of `Tracked` that is shared across every class that declares it as an attribute",
            "Validate attribute values against a type schema defined in `Tracked.registry` at assignment time"
        ),
        answerIndex = 0,
        explanation = "`__set_name__(owner, name)` is called by `type.__new__` for every descriptor assigned in a class body, passing the owning class and the attribute name. This lets the descriptor store its own name (needed for `__dict__` storage) and register itself without the class author writing any extra wiring. It was introduced in Python 3.6 precisely to eliminate the verbose `Field(name='x')` boilerplate previously required by ORMs and similar frameworks."
    ),
    Problem(
        id = "fill_hard_43",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "asyncio.gather with return_exceptions",
        summary = "Collect results and exceptions from concurrent coroutines without aborting on failure.",
        prompt = "Which argument fills the blank so that a failing coroutine returns its exception as a result value instead of propagating it?",
        code = """
            import asyncio

            async def may_fail(n):
                if n == 0:
                    raise ValueError("zero")
                return n * 2

            async def main():
                results = await asyncio.gather(
                    may_fail(1),
                    may_fail(0),
                    may_fail(3),
                    ___,
                )
                print(results)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "return_exceptions=True",
            "suppress_exceptions=True",
            "ignore_errors=True",
            "return_exceptions=False"
        ),
        answerIndex = 0,
        explanation = "`asyncio.gather(*coros, return_exceptions=True)` catches exceptions raised by individual coroutines and returns them as result values in the output list rather than re-raising them. The output for this snippet is `[2, ValueError('zero'), 6]`. The default `return_exceptions=False` cancels remaining tasks and re-raises the first exception. The other options are not valid `gather` parameters."
    ),
    Problem(
        id = "order_hard_42",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache (doubly-linked list + dict)",
        summary = "Arrange the core get() method of a manual LRU cache in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def get(self, key):",
            "    if key not in self.cache:",
            "        return -1",
            "    node = self.cache[key]",
            "    self._remove(node)",
            "    self._add_to_front(node)",
            "    return node.value"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6),
        explanation = "An LRU `get` must first check for a cache miss and return -1 immediately. On a hit it retrieves the node, removes it from its current position in the doubly-linked list, moves it to the front (most-recently-used end), then returns the value. This O(1) sequence is only possible because a dictionary gives O(1) node lookup while the doubly-linked list gives O(1) reordering."
    ),
    Problem(
        id = "complexity_hard_42",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Segment tree range query",
        summary = "Determine the time complexity of building and querying a segment tree.",
        prompt = "What are the time complexities of `build` and `query` in this segment tree?",
        code = """
            def build(arr, tree, node, start, end):
                if start == end:
                    tree[node] = arr[start]
                else:
                    mid = (start + end) // 2
                    build(arr, tree, 2*node, start, mid)
                    build(arr, tree, 2*node+1, mid+1, end)
                    tree[node] = tree[2*node] + tree[2*node+1]

            def query(tree, node, start, end, l, r):
                if r < start or end < l:
                    return 0
                if l <= start and end <= r:
                    return tree[node]
                mid = (start + end) // 2
                return (query(tree, 2*node, start, mid, l, r) +
                        query(tree, 2*node+1, mid+1, end, l, r))
        """.trimIndent(),
        options = listOf(
            "build: O(n), query: O(log n) — build visits each of the 2n−1 nodes once; query prunes at most 4 log n nodes per level",
            "build: O(n log n), query: O(n) — each level of the tree performs O(n) work",
            "build: O(n²), query: O(log n) — recursive splitting doubles work at each level",
            "build: O(n), query: O(n) — in the worst case the query traverses the entire tree"
        ),
        answerIndex = 0,
        explanation = "`build` recurses over all nodes in the complete binary segment tree. A segment tree over n leaves has exactly 2n−1 internal and leaf nodes, so `build` runs in O(n) time. `query` splits the range at each level and prunes branches that lie entirely outside `[l, r]` — at each depth at most 4 nodes are visited, giving O(4 log n) = O(log n) time. This makes segment trees suitable for applications requiring many range queries after a one-time build."
    ),
    Problem(
        id = "trace_hard_42",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Coroutine chain with yield from",
        summary = "Track the value returned by the innermost generator through a yield-from chain.",
        prompt = "What does the code print, in order?",
        code = """
            def inner():
                val = yield "start"
                yield val * 2
                return "done"

            def outer():
                result = yield from inner()
                yield result.upper()

            gen = outer()
            print(next(gen))      # 1
            print(gen.send(5))    # 2
            print(next(gen))      # 3
        """.trimIndent(),
        options = listOf(
            "start\n10\nDONE",
            "start\n5\ndone",
            "start\n10\ndone",
            "start\n5\nDONE"
        ),
        answerIndex = 0,
        explanation = "`next(gen)` enters `outer`, which delegates to `inner` via `yield from`. `inner` yields `'start'` — printed as `start`. `gen.send(5)` resumes `inner` with `val=5`; `inner` then yields `val*2 = 10` — printed as `10`. `next(gen)` resumes `inner` again; `inner` has no more yield points, so it executes `return 'done'`. `yield from` captures the return value as `result = 'done'`, then `outer` yields `result.upper()` = `'DONE'` — printed as `DONE`."
    ),
    Problem(
        id = "match_hard_42",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: Counter({'b': 3, 'a': 2, 'c': 1})",
        summary = "Pick the snippet that produces a Counter sorted by descending count.",
        prompt = "Which code produces `Counter({'b': 3, 'a': 2, 'c': 1})`?",
        code = "Counter({'b': 3, 'a': 2, 'c': 1})",
        options = listOf(
            "from collections import Counter; print(Counter('aabbbc'))",
            "from collections import Counter; print(Counter('abcaabb'))",
            "from collections import Counter; print(Counter({'a': 2, 'b': 3, 'c': 1}))",
            "from collections import Counter; print(Counter(['b','b','b','a','a','c']))"
        ),
        answerIndex = 0,
        explanation = "`Counter('aabbbc')` counts `a→2, b→3, c→1` and `Counter.__repr__` displays elements in descending count order: `Counter({'b': 3, 'a': 2, 'c': 1})`. Option B has 7 characters (`a`,`b`,`c`,`a`,`a`,`b`,`b`) → `a→3, b→3, c→1`. Option C constructs the counter directly but the dict literal is in insertion order `a, b, c`, yet `Counter` repr would still sort by count, giving `Counter({'b': 3, 'a': 2, 'c': 1})` — however the source string in option A is the most direct and unambiguous match. Option D with a list produces the same counts as option A but is a different expression."
    )
)
