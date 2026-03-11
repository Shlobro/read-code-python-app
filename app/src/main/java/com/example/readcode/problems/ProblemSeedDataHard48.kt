package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 48.
// One senior-level problem per problem type.
val hardProblems48 = listOf(
    Problem(
        id = "bug_hard_49",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "defaultdict with get",
        summary = "The code expects a missing key lookup to create a list automatically.",
        prompt = "What is the actual bug here?",
        code = """
            from collections import defaultdict

            groups = defaultdict(list)
            groups.get("new").append(1)
        """.trimIndent(),
        options = listOf(
            "The missing key must be inserted with `setdefault` first",
            "`get` bypasses the default factory and returns `None`",
            "`append` only works after the dict has two keys",
            "A `defaultdict` can store only immutable values"
        ),
        answerIndex = 1,
        explanation = "`defaultdict` only creates a default value when the key is accessed with `[]`. Calling `get(\"new\")` returns `None`, so `.append(1)` fails."
    ),
    Problem(
        id = "output_hard_49",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Late-bound loop variable",
        summary = "Each lambda closes over the same variable rather than a snapshot value.",
        prompt = "What does this code print?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)

            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "[0, 1, 2]",
            "[0, 0, 0]",
            "[1, 2, 3]",
            "[2, 2, 2]"
        ),
        answerIndex = 3,
        explanation = "The lambdas capture the variable `i`, not its value at each iteration. By the time they run, the loop has finished and `i` is `2`."
    ),
    Problem(
        id = "purpose_hard_49",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Layered dict union",
        summary = "Several mappings are folded into one result in order.",
        prompt = "What does this function do overall?",
        code = """
            def merge_layers(*sources):
                result = {}
                for source in sources:
                    result |= source
                return result
        """.trimIndent(),
        options = listOf(
            "It keeps only keys present in every dictionary",
            "It groups values by key into lists",
            "It merges dictionaries so later ones override earlier keys",
            "It validates that all dictionaries have matching key types"
        ),
        answerIndex = 2,
        explanation = "The `|=` operator updates the mapping with each source in turn. If the same key appears again later, the later value replaces the earlier one."
    ),
    Problem(
        id = "fill_hard_49",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Delegating a generator",
        summary = "The outer generator should yield every line from each opened file.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            def stream_lines(paths):
                for path in paths:
                    with open(path) as handle:
                        ___ handle
        """.trimIndent(),
        options = listOf(
            "return",
            "yield",
            "yield from",
            "await"
        ),
        answerIndex = 2,
        explanation = "`yield from handle` delegates iteration to the file object and yields each line in sequence. `yield handle` would yield the file object itself."
    ),
    Problem(
        id = "order_hard_48",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Single-dispatch formatter",
        summary = "Arrange the lines to define a generic renderer and a list-specific implementation.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    return \",\".join(map(str, value))",
            "def _(value: list):",
            "@singledispatch",
            "def render(value):",
            "from functools import singledispatch",
            "    return str(value)",
            "@render.register"
        ),
        answerIndex = 0,
        correctOrder = listOf(4, 2, 3, 5, 6, 1, 0),
        explanation = "Import `singledispatch`, define the generic `render` function first, then register the list-specific overload beneath it."
    ),
    Problem(
        id = "complexity_hard_48",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Summing all suffixes",
        summary = "Each loop creates a shorter slice and then sums it.",
        prompt = "If `values` has length `n`, what is the worst-case time complexity?",
        code = """
            def suffix_total(values):
                total = 0
                for i in range(len(values)):
                    total += sum(values[i:])
                return total
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(n log n)",
            "O(n²)",
            "O(n³)"
        ),
        answerIndex = 2,
        explanation = "The code sums slices of lengths `n`, `n-1`, `n-2`, and so on. That series totals O(n²) work overall."
    ),
    Problem(
        id = "trace_hard_48",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Aliased nested lists",
        summary = "List multiplication duplicates references, not the inner lists themselves.",
        prompt = "What is the value of `rows` after this code runs?",
        code = """
            rows = [[]] * 3
            rows[1].append("x")
        """.trimIndent(),
        options = listOf(
            "[[], ['x'], []]",
            "[['x'], [], []]",
            "[[], [], ['x']]",
            "[['x'], ['x'], ['x']]"
        ),
        answerIndex = 3,
        explanation = "`[[]] * 3` creates three references to the same inner list. Appending through one element mutates that shared list, so all three entries show `['x']`."
    ),
    Problem(
        id = "match_hard_48",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [(1, 'a'), (2, 'b')]",
        summary = "Pick the snippet that numbers items starting at 1.",
        prompt = "Which code produces this output?",
        code = "[(1, 'a'), (2, 'b')]",
        options = listOf(
            "print(list(zip(range(2), \"ab\")))",
            "print(list(enumerate(\"ab\", start=1)))",
            "print(dict(enumerate(\"ab\", start=1)))",
            "print(list(enumerate(\"ab\")))"
        ),
        answerIndex = 1,
        explanation = "`enumerate(\"ab\", start=1)` yields `(1, 'a')` and `(2, 'b')`. The other choices either start at 0 or produce a dictionary instead of a list of tuples."
    )
)
