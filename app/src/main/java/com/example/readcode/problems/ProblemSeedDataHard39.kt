package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 39.
// One senior-level problem per problem type.
val hardProblems39 = listOf(
    Problem(
        id = "bug_hard_40",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "WeakRef callback fires too early",
        summary = "A weakref callback is triggered before the object should be collected.",
        prompt = "Why does the weakref callback fire immediately on the line after `ref` is created?",
        code = """
            import weakref

            class Node:
                pass

            def on_gone(r):
                print("collected")

            ref = weakref.ref(Node(), on_gone)
            print("still here?")
        """.trimIndent(),
        options = listOf(
            "`Node()` creates a temporary with no other references; it is eligible for collection before `ref` is assigned, so the callback fires immediately",
            "weakref callbacks always fire synchronously during `weakref.ref()` construction",
            "`Node` must define `__weakref__` in `__slots__` before it can be tracked",
            "The callback fires because `on_gone` holds a strong reference to the node"
        ),
        answerIndex = 0,
        explanation = "`Node()` is a temporary expression with no binding. CPython's reference-counted GC may collect it before `weakref.ref` finishes construction, triggering the callback immediately. The fix is to bind the instance to a local variable first: `node = Node(); ref = weakref.ref(node, on_gone)`."
    ),
    Problem(
        id = "output_hard_40",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor __get__ on class vs instance",
        summary = "A data descriptor behaves differently when accessed through the class versus an instance.",
        prompt = "What are the two values printed?",
        code = """
            class Desc:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return 42

            class MyClass:
                value = Desc()

            print(type(MyClass.value).__name__)
            print(MyClass().value)
        """.trimIndent(),
        options = listOf(
            "Desc\n42",
            "42\n42",
            "Desc\nDesc",
            "None\n42"
        ),
        answerIndex = 0,
        explanation = "When a descriptor's `__get__` is called with `obj=None` (class-level access), it returns `self` — the descriptor object itself. `type(MyClass.value).__name__` is therefore `'Desc'`. When called on an instance, `obj` is the instance, so it returns `42`."
    ),
    Problem(
        id = "purpose_hard_40",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Context-variable isolation with contextvars",
        summary = "Each asyncio task gets its own independent copy of a context variable.",
        prompt = "What is the primary purpose of this code pattern?",
        code = """
            import asyncio
            from contextvars import ContextVar

            request_id: ContextVar[str] = ContextVar('request_id', default='none')

            async def handle(rid: str):
                token = request_id.set(rid)
                await asyncio.sleep(0)
                print(request_id.get())
                request_id.reset(token)

            async def main():
                await asyncio.gather(handle('A'), handle('B'))

            asyncio.run(main())
        """.trimIndent(),
        options = listOf(
            "Provide each concurrent coroutine with its own isolated copy of `request_id` without thread locks or global state",
            "Persist `request_id` across multiple event-loop runs so it survives restarts",
            "Prevent `request_id` from being garbage-collected while a coroutine is suspended",
            "Synchronise access to `request_id` so only one coroutine reads it at a time"
        ),
        answerIndex = 0,
        explanation = "`ContextVar` stores per-context values. Each task created by `asyncio.gather` runs in a shallow copy of the current context, so `request_id.set('A')` in one task does not affect the value seen by the other. `reset(token)` restores the variable to its previous state when the handler finishes, making the pattern safe for reuse across many concurrent requests."
    ),
    Problem(
        id = "fill_hard_40",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "dataclasses.field with default_factory",
        summary = "Avoid the mutable-default-argument pitfall inside a dataclass.",
        prompt = "Which expression fills the blank so each instance gets its own empty list rather than sharing one?",
        code = """
            from dataclasses import dataclass, field

            @dataclass
            class Bag:
                items: list = ___(default_factory=list)

            b1 = Bag()
            b2 = Bag()
            b1.items.append(1)
            print(b2.items)  # []
        """.trimIndent(),
        options = listOf(
            "field",
            "default",
            "factory",
            "datafield"
        ),
        answerIndex = 0,
        explanation = "`dataclasses.field(default_factory=list)` tells the dataclass machinery to call `list()` for each new instance, giving every `Bag` its own empty list. Using `items: list = []` directly would raise a `ValueError` at class definition time because mutable defaults are forbidden in dataclasses."
    ),
    Problem(
        id = "order_hard_39",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge sort implementation",
        summary = "Arrange the steps of a recursive merge sort in correct source order.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def merge_sort(arr):",
            "    if len(arr) <= 1:",
            "        return arr",
            "    mid = len(arr) // 2",
            "    left = merge_sort(arr[:mid])",
            "    right = merge_sort(arr[mid:])",
            "    return merge(left, right)",
            "def merge(left, right):",
            "    result = []",
            "    i = j = 0",
            "    while i < len(left) and j < len(right):",
            "        if left[i] <= right[j]:",
            "            result.append(left[i]); i += 1",
            "        else:",
            "            result.append(right[j]); j += 1",
            "    return result + left[i:] + right[j:]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "Merge sort divides the array at the midpoint, recursively sorts each half, then merges the two sorted halves. The `merge` helper walks both halves with two indices, always appending the smaller element, then concatenates any leftover tail."
    ),
    Problem(
        id = "complexity_hard_39",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Nested loop with shrinking inner range",
        summary = "Determine the exact time complexity of a triangular nested loop.",
        prompt = "What is the time complexity of this function?",
        code = """
            def triangular(n):
                count = 0
                for i in range(n):
                    for j in range(i, n):
                        count += 1
                return count
        """.trimIndent(),
        options = listOf(
            "O(n²) — the inner loop runs n, n-1, n-2, … 1 times, summing to n(n+1)/2",
            "O(n log n) — the inner loop halves with each outer iteration",
            "O(n³) — three levels of implicit recursion are hidden in the loop",
            "O(n) — the total iterations equal n because the inner range shrinks"
        ),
        answerIndex = 0,
        explanation = "When `i = 0` the inner loop runs `n` times; when `i = 1` it runs `n-1` times; … when `i = n-1` it runs once. The total is `n + (n-1) + … + 1 = n(n+1)/2`, which is `O(n²)`. The constant factor ½ is dropped in Big-O notation."
    ),
    Problem(
        id = "trace_hard_39",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Class variable shadowed by instance assignment",
        summary = "Track whether `obj.count` reads the class variable or a new instance variable.",
        prompt = "What value does `obj.count` hold after the last line executes?",
        code = """
            class Counter:
                count = 0

            obj = Counter()
            Counter.count += 1   # class var is now 1
            obj.count += 1       # what happens here?
        """.trimIndent(),
        options = listOf("2", "1", "0", "Error"),
        answerIndex = 0,
        explanation = "`obj.count += 1` is equivalent to `obj.count = obj.count + 1`. The right-hand side reads `obj.count` via normal attribute lookup, which finds the class variable `Counter.count` (currently `1`) because `obj` has no instance attribute named `count` yet. Adding 1 gives `2`, and the assignment stores `2` as a new instance attribute on `obj`, shadowing the class variable. `Counter.count` remains `1`."
    ),
    Problem(
        id = "match_hard_39",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [0, 1, 4, 9, 16]",
        summary = "Pick the snippet that produces a list of the first five perfect squares.",
        prompt = "Which code prints `[0, 1, 4, 9, 16]`?",
        code = "[0, 1, 4, 9, 16]",
        options = listOf(
            "print([x**2 for x in range(5)])",
            "print([x*2 for x in range(5)])",
            "print(list(map(lambda x: x+x, range(5))))",
            "print([x**2 for x in range(1, 6)])"
        ),
        answerIndex = 0,
        explanation = "Option A squares each value in `range(5)` (0–4), giving `[0, 1, 4, 9, 16]`. Option B doubles each value, giving `[0, 2, 4, 6, 8]`. Option C also doubles (same as B). Option D squares `range(1, 6)` (1–5), giving `[1, 4, 9, 16, 25]`. Only option A produces the target list."
    )
)
