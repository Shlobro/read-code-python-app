package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 46.
// One senior-level problem per problem type.
val hardProblems46 = listOf(
    Problem(
        id = "bug_hard_47",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Heap tie with unorderable payloads",
        summary = "Two heap entries share a priority, so Python falls through to comparing payloads.",
        prompt = "What is the real bug in this code?",
        code = """
            import heapq

            jobs = []
            heapq.heappush(jobs, (1, {"task": "email"}))
            heapq.heappush(jobs, (1, {"task": "backup"}))
        """.trimIndent(),
        options = listOf(
            "Tie priorities make `heapq` compare the dict payloads",
            "A heap push must be followed by an immediate pop",
            "Heap priorities must be unique positive integers in Python 3",
            "Tuples passed to `heapq` cannot contain dictionaries"
        ),
        answerIndex = 0,
        explanation = "When priorities tie, `heapq` compares the next tuple element. Here that means comparing two dictionaries, which raises `TypeError` in Python 3 because dicts are not orderable."
    ),
    Problem(
        id = "output_hard_47",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Method resolution with cooperative super",
        summary = "Multiple inheritance and `super()` combine both mixins before reaching the base class.",
        prompt = "What does this code print?",
        code = """
            class Base:
                def label(self):
                    return "Base"

            class Left(Base):
                def label(self):
                    return "Left->" + super().label()

            class Right(Base):
                def label(self):
                    return "Right->" + super().label()

            class Child(Left, Right):
                pass

            print(Child().label())
        """.trimIndent(),
        options = listOf(
            "Left->Base",
            "Right->Base",
            "Left->Right->Base",
            "Left->Base->Right->Base"
        ),
        answerIndex = 2,
        explanation = "The MRO for `Child` is `Child, Left, Right, Base, object`. `Left.label()` calls `super()`, which resolves to `Right.label()`, and that in turn calls `Base.label()`."
    ),
    Problem(
        id = "purpose_hard_47",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Sentinel-driven chunk reader",
        summary = "A callable is repeatedly invoked until it returns an EOF marker.",
        prompt = "What is this function primarily used for?",
        code = """
            def read_chunks(handle, size=8192):
                return iter(lambda: handle.read(size), b"")
        """.trimIndent(),
        options = listOf(
            "Build one bytes object by reading the whole file eagerly",
            "Rewind a binary file back to the beginning after each read",
            "Return a context manager that closes the file automatically",
            "Yield fixed-size byte chunks lazily until EOF is reached"
        ),
        answerIndex = 3,
        explanation = "The two-argument form of `iter` keeps calling the lambda until it returns the sentinel `b\"\"`. That creates a lazy stream of fixed-size reads rather than loading the entire file at once."
    ),
    Problem(
        id = "fill_hard_47",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Pattern-matching guard",
        summary = "The `case` clause should run only when the matched data passes an extra boolean check.",
        prompt = "Which keyword fills the blank to add a guard expression to this `case` pattern?",
        code = """
            match message:
                case {"status": "ok", "payload": payload} ___ payload:
                    print("usable")
        """.trimIndent(),
        options = listOf(
            "if",
            "when",
            "where",
            "guard"
        ),
        answerIndex = 0,
        explanation = "In structural pattern matching, a `case` can add a guard with `if ...` after the pattern. The branch runs only if the pattern matches and the guard expression is truthy."
    ),
    Problem(
        id = "order_hard_46",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Decorator preserving metadata",
        summary = "Arrange the lines to build a wrapper that logs calls and preserves the wrapped function metadata.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "        return fn(*args, **kwargs)",
            "    def wrapper(*args, **kwargs):",
            "from functools import wraps",
            "    return wrapper",
            "def traced(fn):",
            "        print(fn.__name__)",
            "    @wraps(fn)"
        ),
        answerIndex = 0,
        correctOrder = listOf(2, 4, 6, 1, 5, 0, 3),
        explanation = "Import `wraps` first, define the decorator, apply `@wraps(fn)` to the inner wrapper, log the function name, call the wrapped function, and finally return the wrapper."
    ),
    Problem(
        id = "complexity_hard_46",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Two-pointer overlap scan",
        summary = "The code is nested in conditionals, but each index only moves forward.",
        prompt = "If `left` and `right` are sorted lists of lengths `n` and `m`, what is the worst-case time complexity?",
        code = """
            def has_overlap(left, right):
                i = 0
                j = 0
                while i < len(left) and j < len(right):
                    if left[i] == right[j]:
                        return True
                    if left[i] < right[j]:
                        i += 1
                    else:
                        j += 1
                return False
        """.trimIndent(),
        options = listOf(
            "O(log n + log m)",
            "O(n + m)",
            "O(n log m)",
            "O(n * m)"
        ),
        answerIndex = 1,
        explanation = "Each loop iteration advances either `i` or `j`, never moving either index backward. That means the total number of iterations is bounded by `n + m`, not `n * m`."
    ),
    Problem(
        id = "trace_hard_46",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Default captures original list",
        summary = "A default argument keeps a reference to the old object even after the outer name is rebound.",
        prompt = "What is the value of `result` after this code runs?",
        code = """
            def outer():
                state = []

                def add(value, bucket=state):
                    bucket.append(value)
                    return bucket

                add(1)
                state = ["reset"]
                result = add(2)
                return result

            result = outer()
        """.trimIndent(),
        options = listOf(
            "[\"reset\", 2]",
            "[2]",
            "[1, 2]",
            "It raises `UnboundLocalError`"
        ),
        answerIndex = 2,
        explanation = "Default arguments are bound when `add` is defined, so `bucket` keeps pointing at the original empty list. Rebinding `state` later does not change that captured default, and the two calls append into the same original list."
    ),
    Problem(
        id = "match_hard_46",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [[1], [1], [1]]",
        summary = "Choose the snippet that demonstrates list-multiplication aliasing.",
        prompt = "Which code produces this output?",
        code = "[[1], [1], [1]]",
        options = listOf(
            "rows = [[]] * 3; rows[0].append(1); print(rows)",
            "rows = [[] for _ in range(3)]; rows[0].append(1); print(rows)",
            "rows = [[1], [], []]; rows[1].append(1); rows[2].append(1); print(rows)",
            "rows = [[1] for _ in range(3)]; rows[0] = []; print(rows)"
        ),
        answerIndex = 0,
        explanation = "`[[]] * 3` repeats references to the same inner list, so mutating `rows[0]` mutates all three visible entries. The other snippets create distinct inner lists or produce a different final structure."
    )
)
