package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 16.
// One senior-level problem per problem type.
val hardProblems16 = listOf(
    Problem(
        id = "bug_hard_17",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late-bound retry callbacks",
        summary = "Each lambda closes over the same loop variable.",
        prompt = "What is the real bug in this code?",
        code = """
            def build_retry_callbacks(delays):
                callbacks = []
                for delay in delays:
                    callbacks.append(lambda: f"retry in {delay}s")
                return callbacks

            tasks = build_retry_callbacks([1, 2, 5])
            print([task() for task in tasks])
        """.trimIndent(),
        options = listOf(
            "All callbacks use the final `delay` value because the lambda closes over the loop variable",
            "The f-string is evaluated too early, so every callback returns an empty string",
            "Lambdas cannot be appended to lists in Python",
            "The list comprehension exhausts the callbacks after the first call"
        ),
        answerIndex = 0,
        explanation = "The lambda captures the variable, not its value at each iteration. After the loop, every callback reads the final `delay`, so they all report `5`."
    ),
    Problem(
        id = "output_hard_17",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Exception replaced by `finally`",
        summary = "A `return` in `finally` overrides the value from `except`.",
        prompt = "What does this code print?",
        code = """
            def parse_flag(value):
                try:
                    return int(value)
                except ValueError:
                    return -1
                finally:
                    return 99

            print(parse_flag("bad"))
        """.trimIndent(),
        options = listOf("99", "-1", "ValueError", "None"),
        answerIndex = 0,
        explanation = "A `return` in `finally` wins over earlier `return` statements, so the function always returns `99`."
    ),
    Problem(
        id = "purpose_hard_17",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Bounded worker pool",
        summary = "The function limits in-flight tasks and preserves result order.",
        prompt = "What does this function do overall?",
        code = """
            from concurrent.futures import ThreadPoolExecutor

            def run_bounded(items, worker, limit=4):
                with ThreadPoolExecutor(max_workers=limit) as pool:
                    futures = [pool.submit(worker, item) for item in items]
                    return [future.result() for future in futures]
        """.trimIndent(),
        options = listOf(
            "It runs work concurrently with a maximum number of threads and returns results in input order",
            "It retries failed tasks until they succeed and returns only successful results",
            "It executes tasks serially but caches repeated calls to `worker`",
            "It streams results as soon as each thread finishes, regardless of input order"
        ),
        answerIndex = 0,
        explanation = "The thread pool bounds concurrency via `max_workers`, and iterating over the `futures` list preserves the original submission order in the returned results."
    ),
    Problem(
        id = "fill_hard_17",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Closure state mutation",
        summary = "The inner function must update the outer variable rather than shadow it.",
        prompt = "Fill the blank so each call to `next_id()` increments and returns the outer counter.",
        code = """
            def make_counter():
                current = 0

                def next_id():
                    ___ current
                    current += 1
                    return current

                return next_id
        """.trimIndent(),
        options = listOf("nonlocal", "global", "local", "mutable"),
        answerIndex = 0,
        explanation = "`nonlocal` tells Python that `current` comes from the nearest enclosing function scope, allowing the inner function to rebind it."
    ),
    Problem(
        id = "order_hard_16",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Sliding-window maximum",
        summary = "Arrange the lines to maintain a decreasing deque of candidate indices.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import deque",
            "def window_max(nums, k):",
            "    q = deque()",
            "    result = []",
            "    for i, value in enumerate(nums):",
            "        while q and q[0] <= i - k:",
            "            q.popleft()",
            "        while q and nums[q[-1]] <= value:",
            "            q.pop()",
            "        q.append(i)",
            "        if i >= k - 1:",
            "            result.append(nums[q[0]])",
            "    return result"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
        explanation = "The deque keeps indices in decreasing value order while also dropping indices that fall out of the current window."
    ),
    Problem(
        id = "complexity_hard_16",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "k-way heap merge",
        summary = "Each pop/push touches the heap of active iterators rather than the full data set.",
        prompt = "If the total number of values across all lists is n and there are k sorted lists, what is the time complexity?",
        code = """
            import heapq

            def merge_sorted(lists):
                heap = []
                for list_index, values in enumerate(lists):
                    if values:
                        heapq.heappush(heap, (values[0], list_index, 0))

                merged = []
                while heap:
                    value, list_index, item_index = heapq.heappop(heap)
                    merged.append(value)
                    next_index = item_index + 1
                    if next_index < len(lists[list_index]):
                        heapq.heappush(
                            heap,
                            (lists[list_index][next_index], list_index, next_index)
                        )
                return merged
        """.trimIndent(),
        options = listOf("O(n log k)", "O(nk)", "O(k log n)", "O(n log n)"),
        answerIndex = 0,
        explanation = "There are n heap removals and up to n insertions, and each heap operation costs O(log k) because the heap contains at most one active item per list."
    ),
    Problem(
        id = "trace_hard_16",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shared default accumulator",
        summary = "Track the same list across multiple calls that omit the optional argument.",
        prompt = "What is the value of `third` after this code runs?",
        code = """
            def collect(value, bucket=[]):
                bucket.append(value)
                return bucket

            first = collect("a")
            second = collect("b")
            third = collect("c", [])
        """.trimIndent(),
        options = listOf("['c']", "['a', 'b', 'c']", "['a', 'b']", "[]"),
        answerIndex = 0,
        explanation = "The first two calls share the default list, but the third call passes a fresh list explicitly, so `third` is `['c']`."
    ),
    Problem(
        id = "match_hard_16",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 2, 3]",
        summary = "Pick the snippet that deduplicates while preserving first-seen order.",
        prompt = "Which code produces exactly `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "values = [1, 2, 1, 3, 2]; print(list(dict.fromkeys(values)))",
            "values = [1, 2, 1, 3, 2]; print(sorted(set(values), reverse=True))",
            "values = [1, 2, 1, 3, 2]; print(list(set(values)))",
            "values = [1, 2, 1, 3, 2]; print([value for value in values if values.count(value) == 1])"
        ),
        answerIndex = 0,
        explanation = "Only `dict.fromkeys(values)` removes duplicates while keeping the first occurrence order, yielding `[1, 2, 3]`."
    )
)
