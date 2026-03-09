package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 24.
// One senior-level problem per problem type.
val hardProblems24 = listOf(
    Problem(
        id = "bug_hard_25",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Stale cached instance method",
        summary = "A cached method depends on mutable instance state that changes after the first call.",
        prompt = "What is the real bug in this code?",
        code = """
            import functools

            class Converter:
                def __init__(self, rate):
                    self.rate = rate

                @functools.lru_cache(maxsize=None)
                def convert(self, amount):
                    return amount * self.rate

            conv = Converter(2)
            print(conv.convert(10))
            conv.rate = 5
            print(conv.convert(10))
        """.trimIndent(),
        options = listOf(
            "The cache key uses `self` identity and `amount`, so changing `rate` leaves a stale cached result",
            "`lru_cache` cannot be applied to instance methods in Python",
            "The second call raises because `amount` is no longer hashable",
            "`maxsize=None` disables caching, so the method always recomputes"
        ),
        answerIndex = 0,
        explanation = "The cached key is based on the bound arguments, not on every field read inside the method body. After `rate` changes, `convert(10)` still returns the earlier cached value."
    ),
    Problem(
        id = "output_hard_25",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Yield-from return value",
        summary = "A parent generator captures the child generator's final return value.",
        prompt = "What does this code print?",
        code = """
            def child():
                yield 1
                return 99

            def parent():
                result = yield from child()
                print(result)

            for value in parent():
                print(value)
        """.trimIndent(),
        options = listOf(
            "1\n99",
            "1",
            "99\n1",
            "1\nNone"
        ),
        answerIndex = 0,
        explanation = "The loop prints the yielded `1`. When `child` finishes, `yield from` receives the child's return value `99`, assigns it to `result`, and `parent` prints `99`."
    ),
    Problem(
        id = "purpose_hard_25",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Interval coalescing",
        summary = "The function sorts ranges, then merges any overlaps into a compact result.",
        prompt = "What does this function compute?",
        code = """
            def coalesce(intervals):
                merged = []
                for start, end in sorted(intervals):
                    if not merged or start > merged[-1][1]:
                        merged.append([start, end])
                    else:
                        merged[-1][1] = max(merged[-1][1], end)
                return merged
        """.trimIndent(),
        options = listOf(
            "The gaps between consecutive intervals",
            "The intervals sorted by length descending",
            "A sorted list of non-overlapping intervals formed by merging overlaps",
            "The longest interval and the number of times it appears"
        ),
        answerIndex = 2,
        explanation = "After sorting by start time, the function either starts a new output interval or extends the previous one when the current interval overlaps it."
    ),
    Problem(
        id = "fill_hard_25",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Dynamic context management",
        summary = "The code needs one context manager that can safely own a runtime-sized set of open files.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            from contextlib import ___

            def read_all(paths):
                with ___() as stack:
                    files = [stack.enter_context(open(path)) for path in paths]
                    return [f.read() for f in files]
        """.trimIndent(),
        options = listOf(
            "ExitStack",
            "closing",
            "suppress",
            "redirect_stdout"
        ),
        answerIndex = 0,
        explanation = "`ExitStack` manages a dynamic number of entered contexts and guarantees they are all cleaned up when the `with` block exits."
    ),
    Problem(
        id = "order_hard_24",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Transactional context manager",
        summary = "Arrange a context manager that commits on success and rolls back on failure.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from contextlib import contextmanager",
            "@contextmanager",
            "def transaction(conn):",
            "    try:",
            "        yield conn",
            "    except Exception:",
            "        conn.rollback()",
            "        raise",
            "    else:",
            "        conn.commit()"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        explanation = "The import comes first, then the decorator and function definition. The `try` yields control to the caller, rolls back on failure, and commits only on the success path."
    ),
    Problem(
        id = "complexity_hard_24",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Monotonic deque window scan",
        summary = "Each array element is appended once and can be removed from the deque at most once.",
        prompt = "If `nums` has length `n`, what is the total time complexity?",
        code = """
            from collections import deque

            def scan(nums):
                dq = deque()
                for i, value in enumerate(nums):
                    while dq and dq[-1][1] <= value:
                        dq.pop()
                    dq.append((i, value))
                return dq
        """.trimIndent(),
        options = listOf("O(n)", "O(n log n)", "O(n sqrt(n))", "O(n^2)"),
        answerIndex = 0,
        explanation = "Even though the inner `while` can pop multiple items in one iteration, each element is inserted once and popped once overall, so the total work is linear."
    ),
    Problem(
        id = "trace_hard_24",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Return through finally mutation",
        summary = "A mutable object is chosen as the return value before `finally` runs, then the same object is modified.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def build():
                items = [1]
                try:
                    return items
                finally:
                    items.append(2)

            result = build()
        """.trimIndent(),
        options = listOf(
            "[1, 2]",
            "[1]",
            "None",
            "It raises because `finally` cannot run after `return`"
        ),
        answerIndex = 0,
        explanation = "Python decides which object to return before entering `finally`, but the list object itself is still mutable. The `append(2)` mutates that same returned list."
    ),
    Problem(
        id = "match_hard_24",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output:\nbody\nsecond\nfirst",
        summary = "Pick the snippet where deferred cleanup callbacks run in LIFO order after the body finishes.",
        prompt = "Which code produces exactly this output?",
        code = """
            body
            second
            first
        """.trimIndent(),
        options = listOf(
            "from contextlib import ExitStack\nwith ExitStack() as stack:\n    stack.callback(print, 'first')\n    stack.callback(print, 'second')\n    print('body')",
            "from contextlib import ExitStack\nwith ExitStack() as stack:\n    print('body')\n    stack.callback(print, 'first')\n    print('second')",
            "try:\n    print('body')\nfinally:\n    print('first')\n    print('second')",
            "with open('tmp.txt', 'w') as f:\n    print('body')\n    print('second')\n    print('first')"
        ),
        answerIndex = 0,
        explanation = "ExitStack executes registered callbacks when the block exits, and it unwinds them in reverse registration order, so `second` prints before `first`."
    )
)
