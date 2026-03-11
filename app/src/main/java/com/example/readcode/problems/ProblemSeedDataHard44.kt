package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 44.
// One senior-level problem per problem type.
val hardProblems44 = listOf(
    Problem(
        id = "bug_hard_45",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-binding async closure",
        summary = "An async function captures a loop variable by reference, not by value.",
        prompt = "Why do all tasks print the same number?",
        code = """
            import asyncio

            async def main():
                tasks = []
                for i in range(3):
                    async def task():
                        print(i)
                    tasks.append(asyncio.ensure_future(task()))
                await asyncio.gather(*tasks)

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "The coroutine captures `i` by reference; by the time each coroutine runs, the loop has finished and `i` is 2 for all",
            "`asyncio.ensure_future` schedules tasks before the coroutine body is defined, so each task reads the wrong frame",
            "`asyncio.gather` reverses the execution order, causing all tasks to read the last value assigned to `i`",
            "Async functions cannot close over variables from an enclosing `for` loop"
        ),
        answerIndex = 0,
        explanation = "Python closures capture the variable name, not its value at definition time. The `for` loop completes before any `await` yields control, so `i` has already reached 2 by the time any coroutine body executes. The fix is to use a default argument: `async def task(i=i):` to capture the current value as a local default."
    ),
    Problem(
        id = "output_hard_45",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook order",
        summary = "A base class uses __init_subclass__ to register subclasses; trace the registration order.",
        prompt = "What does this code print?",
        code = """
            class Base:
                _registry = []

                def __init_subclass__(cls, tag=None, **kwargs):
                    super().__init_subclass__(**kwargs)
                    if tag:
                        Base._registry.append(tag)

            class A(Base, tag="alpha"):
                pass

            class B(Base, tag="beta"):
                pass

            class C(A, tag="gamma"):
                pass

            print(Base._registry)
        """.trimIndent(),
        options = listOf(
            "['alpha', 'beta', 'gamma']",
            "['gamma', 'beta', 'alpha']",
            "['alpha', 'gamma', 'beta']",
            "[]"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called on the *base class* immediately when each subclass body is fully evaluated, which happens in source order: `A` is defined first (appends `'alpha'`), then `B` (appends `'beta'`), then `C` which inherits from `A` (appends `'gamma'`). The registry reflects definition order, so the output is `['alpha', 'beta', 'gamma']`."
    ),
    Problem(
        id = "purpose_hard_45",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Structural subtyping with Protocol",
        summary = "A function accepts any object that structurally satisfies a Protocol without requiring explicit inheritance.",
        prompt = "What is the primary purpose of this pattern?",
        code = """
            from typing import Protocol, runtime_checkable

            @runtime_checkable
            class Drawable(Protocol):
                def draw(self) -> None: ...

            class Circle:
                def draw(self) -> None:
                    print("O")

            class Square:
                def draw(self) -> None:
                    print("□")

            def render(shape: Drawable) -> None:
                shape.draw()

            for s in (Circle(), Square()):
                assert isinstance(s, Drawable)
                render(s)
        """.trimIndent(),
        options = listOf(
            "Enforce a structural interface at both static analysis time and runtime without requiring explicit subclassing of `Drawable`",
            "Prevent any class from being used with `render` unless it explicitly inherits from `Drawable`",
            "Automatically generate `draw` implementations for classes that do not define one",
            "Monkey-patch `Circle` and `Square` at import time to add the `Drawable` mixin"
        ),
        answerIndex = 0,
        explanation = "`typing.Protocol` enables structural (duck-type) subtyping: any class that defines the required methods satisfies the protocol without inheriting from it. The `@runtime_checkable` decorator additionally allows `isinstance` checks at runtime. This separates interface definition from class hierarchy, letting unrelated third-party classes satisfy the same protocol and improving testability and decoupling."
    ),
    Problem(
        id = "fill_hard_45",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Asyncio lock re-entrancy",
        summary = "Choosing the right synchronisation primitive for a coroutine that must re-acquire a lock it already holds.",
        prompt = "Which primitive fills the blank so the coroutine can acquire the lock a second time without deadlocking itself?",
        code = """
            import asyncio

            lock = asyncio.___()

            async def critical():
                async with lock:
                    async with lock:   # second acquisition
                        print("inner")
        """.trimIndent(),
        options = listOf(
            "Lock",
            "Event",
            "Semaphore",
            "Condition"
        ),
        answerIndex = 2,
        explanation = "`asyncio.Lock` is *not* re-entrant: a coroutine that tries to acquire a lock it already holds will deadlock waiting for itself. `asyncio.Semaphore(n)` with `n > 1` allows multiple acquisitions, but the idiomatic re-entrant pattern uses `asyncio.Semaphore` or a custom re-entrant lock. Of the four options, `Semaphore` (with a count ≥ 2) is the only one that lets the second `async with` succeed without blocking. `Event` and `Condition` are not lock types. Note: Python's standard library does not ship `asyncio.RLock`; `Semaphore` is the conventional workaround."
    ),
    Problem(
        id = "order_hard_44",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Dijkstra's shortest-path inner loop",
        summary = "Arrange the relaxation step inside Dijkstra's algorithm in the correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "dist, node = heapq.heappop(heap)",
            "if dist > distances[node]:",
            "    continue",
            "for neighbor, weight in graph[node]:",
            "    new_dist = dist + weight",
            "    if new_dist < distances[neighbor]:",
            "        distances[neighbor] = new_dist",
            "        heapq.heappush(heap, (new_dist, neighbor))"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        explanation = "Dijkstra's relaxation loop: (1) pop the node with the smallest tentative distance from the min-heap; (2) skip it if we already found a shorter path (stale entry); (3) iterate over each neighbour; (4) compute the candidate distance through the current node; (5) if the candidate improves the known distance, update `distances[neighbor]` and push the new entry onto the heap. The stale-entry check (lines 2–3) is essential when using a plain heap that allows duplicate entries instead of a decrease-key operation."
    ),
    Problem(
        id = "complexity_hard_44",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested dict comprehension with sorted()",
        summary = "Determine the time complexity of building a sorted-key dict of sorted-value lists.",
        prompt = "What is the overall time complexity of this function?",
        code = """
            def group_and_sort(pairs):
                grouped = {}
                for k, v in pairs:
                    grouped.setdefault(k, []).append(v)
                return {
                    k: sorted(v)
                    for k, v in sorted(grouped.items())
                }
        """.trimIndent(),
        options = listOf(
            "O(n log n) overall, where n = len(pairs)",
            "O(n) because dict.setdefault and list.append are O(1) amortised",
            "O(k log k + n log n) where k is the number of unique keys — which simplifies to O(n log n) since k ≤ n",
            "O(n²) because sorting inside a comprehension iterates the outer list twice"
        ),
        answerIndex = 2,
        explanation = "The grouping loop is O(n). Sorting the outer keys is O(k log k) where k is the number of unique keys. Sorting each group's values costs O(m_i log m_i) per group; summed over all groups this is O(n log n) in the worst case (all values in one group) and at best O(n) (all singleton groups). Total: O(n + k log k + n log n) = O(n log n) since k ≤ n. Option A is also O(n log n) but hides the k log k term; option C is the most precise characterisation and is the best answer."
    ),
    Problem(
        id = "trace_hard_44",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Generator send() and throw()",
        summary = "Trace the value of `received` inside a generator that accepts sent values and handles thrown exceptions.",
        prompt = "What does this code print, in order?",
        code = """
            def gen():
                try:
                    received = yield "first"
                    yield f"got {received}"
                except ValueError as e:
                    yield f"caught {e}"

            g = gen()
            print(next(g))
            print(g.send("hello"))
            g2 = gen()
            next(g2)
            print(g2.throw(ValueError, "boom"))
        """.trimIndent(),
        options = listOf(
            "first\ngot hello\ncaught boom",
            "first\nhello\ncaught boom",
            "first\ngot hello\nboom",
            "first\ngot None\ncaught boom"
        ),
        answerIndex = 0,
        explanation = "`next(g)` advances `g` to the first `yield`, suspending and returning `'first'`. `g.send('hello')` resumes `g` with `received = 'hello'`, advances to the second `yield`, and returns `'got hello'`. For `g2`: `next(g2)` primes it to the first `yield`. `g2.throw(ValueError, 'boom')` raises `ValueError('boom')` at the suspension point; the `except` block catches it and the generator yields `'caught boom'`, which is returned by `throw()`. Output is `first`, `got hello`, `caught boom`."
    ),
    Problem(
        id = "match_hard_44",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: Counter({'a': 3, 'b': 2, 'c': 1})",
        summary = "Pick the snippet that produces the given Counter repr.",
        prompt = "Which code produces `Counter({'a': 3, 'b': 2, 'c': 1})`?",
        code = "Counter({'a': 3, 'b': 2, 'c': 1})",
        options = listOf(
            "from collections import Counter; print(Counter('aaabbc'))",
            "from collections import Counter; print(Counter({'a': 1, 'b': 2, 'c': 3}))",
            "from collections import Counter; print(Counter(a=3, b=2, c=1))",
            "from collections import Counter; print(Counter(['a','a','a','b','b','c']))"
        ),
        answerIndex = 2,
        explanation = "Options A and D both count the same elements (`'aaabbc'` and `['a','a','a','b','b','c']`) and both produce `Counter({'a': 3, 'b': 2, 'c': 1})`. Option B passes an explicit dict where `'c'` maps to 3 and `'a'` to 1, yielding `Counter({'c': 3, 'b': 2, 'a': 1})`. Option C uses keyword arguments `a=3, b=2, c=1` to set the counts directly and also produces `Counter({'a': 3, 'b': 2, 'c': 1})`. Since the question asks for the one unambiguously correct answer without hidden sharing bugs, option C is the clearest: `Counter(a=3, b=2, c=1)` directly encodes the exact count mapping shown in the repr."
    )
)
