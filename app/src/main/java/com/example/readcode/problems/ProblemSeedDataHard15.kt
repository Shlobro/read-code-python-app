package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 15.
// One senior-level problem per problem type.
val hardProblems15 = listOf(
    Problem(
        id = "bug_hard_16",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Iterator reused after zip",
        summary = "One iterator is consumed by `zip` before it is converted to a list again.",
        prompt = "What is the real bug in this code?",
        code = """
            def pair_with_previous(values):
                it = iter(values)
                next(it, None)
                pairs = list(zip(values, it))
                leftovers = list(it)
                return pairs, leftovers
        """.trimIndent(),
        options = listOf(
            "`zip(values, it)` consumes `it`, so `leftovers` is unexpectedly empty",
            "`iter(values)` copies the list and doubles the memory usage",
            "`next(it, None)` skips the wrong element because `None` is invalid here",
            "`zip` cannot combine a list and an iterator in Python"
        ),
        answerIndex = 0,
        explanation = "`zip` pulls from `it` until it is exhausted. By the time `leftovers = list(it)` runs, there is nothing left to iterate."
    ),
    Problem(
        id = "output_hard_16",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor precedence",
        summary = "A data descriptor overrides an instance attribute with the same name.",
        prompt = "What does this code print?",
        code = """
            class Descriptor:
                def __get__(self, obj, owner):
                    return "descriptor"

                def __set__(self, obj, value):
                    obj.__dict__["value"] = f"stored:{value}"

            class Example:
                value = Descriptor()

            item = Example()
            item.value = "instance"
            print(item.__dict__["value"])
            print(item.value)
        """.trimIndent(),
        options = listOf(
            "stored:instance\ndescriptor",
            "instance\nstored:instance",
            "descriptor\ndescriptor",
            "stored:instance\nstored:instance"
        ),
        answerIndex = 0,
        explanation = "The descriptor's `__set__` writes into `__dict__`, so the first print shows `stored:instance`. Attribute access still goes through the data descriptor, so the second print is `descriptor`."
    ),
    Problem(
        id = "purpose_hard_16",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Topological batching",
        summary = "The function peels off dependency-free nodes layer by layer.",
        prompt = "What does this function do overall?",
        code = """
            def dependency_layers(graph):
                remaining = {node: set(deps) for node, deps in graph.items()}
                layers = []
                while remaining:
                    ready = sorted(node for node, deps in remaining.items() if not deps)
                    if not ready:
                        raise ValueError("cycle")
                    layers.append(ready)
                    for node in ready:
                        remaining.pop(node)
                    for deps in remaining.values():
                        deps.difference_update(ready)
                return layers
        """.trimIndent(),
        options = listOf(
            "It groups a dependency graph into execution layers and fails on cycles",
            "It computes the shortest path from every node to every other node",
            "It removes duplicate edges from an undirected graph",
            "It builds a depth-first traversal order for a tree"
        ),
        answerIndex = 0,
        explanation = "Each iteration collects nodes whose dependencies are satisfied, removes them, and repeats. If no node is ready while nodes remain, the graph contains a cycle."
    ),
    Problem(
        id = "fill_hard_16",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Least-recently-used cache",
        summary = "The decorator should memoize calls with the standard library.",
        prompt = "Fill the blank so repeated calls with the same arguments are cached.",
        code = """
            from functools import ___

            @___(maxsize=128)
            def parse_token(token):
                return token.strip().lower()
        """.trimIndent(),
        options = listOf("lru_cache", "cache", "cached_property", "wraps"),
        answerIndex = 0,
        explanation = "`functools.lru_cache` is the standard decorator for bounded memoization with a `maxsize` argument."
    ),
    Problem(
        id = "order_hard_15",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Kahn topological sort",
        summary = "Arrange the lines to emit a valid topological ordering for a DAG.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from collections import deque",
            "def topo_sort(graph):",
            "    indegree = {node: 0 for node in graph}",
            "    for deps in graph.values():",
            "        for dep in deps:",
            "            indegree[dep] += 1",
            "    queue = deque(node for node, degree in indegree.items() if degree == 0)",
            "    order = []",
            "    while queue:",
            "        node = queue.popleft()",
            "        order.append(node)",
            "        for dep in graph[node]:",
            "            indegree[dep] -= 1",
            "            if indegree[dep] == 0:",
            "                queue.append(dep)",
            "    return order"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
        explanation = "Kahn's algorithm starts with zero-indegree nodes, removes them one by one, and pushes newly unlocked nodes into the queue until the ordering is complete."
    ),
    Problem(
        id = "complexity_hard_15",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sorted insert in a growing list",
        summary = "Binary search finds the position, but list insertion still shifts elements.",
        prompt = "What is the overall time complexity in terms of n?",
        code = """
            import bisect

            def build_sorted(values):
                result = []
                for value in values:
                    index = bisect.bisect_left(result, value)
                    result.insert(index, value)
                return result
        """.trimIndent(),
        options = listOf("O(n^2)", "O(n log n)", "O(log n)", "O(n)"),
        answerIndex = 0,
        explanation = "Each `bisect_left` is O(log n), but `list.insert` is O(n) because later elements shift. Repeating that across n values yields O(n^2)."
    ),
    Problem(
        id = "trace_hard_15",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Exception path through `finally`",
        summary = "Track the accumulator as control flow passes through `try`, `except`, and `finally`.",
        prompt = "What is the value of `total` after this code runs?",
        code = """
            total = 1

            try:
                total *= 4
                raise ValueError("boom")
            except ValueError:
                total += 3
            finally:
                total -= 2
        """.trimIndent(),
        options = listOf("5", "4", "2", "1"),
        answerIndex = 0,
        explanation = "`total` becomes 4 in the `try`, 7 in the `except`, and 5 after the `finally` block runs."
    ),
    Problem(
        id = "match_hard_15",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {'a': [1, 3], 'b': [2]}",
        summary = "Pick the snippet that groups tuples by key while preserving insertion order within each bucket.",
        prompt = "Which code produces exactly `{'a': [1, 3], 'b': [2]}`?",
        code = "",
        options = listOf(
            "from collections import defaultdict; pairs = [('a', 1), ('b', 2), ('a', 3)]; grouped = defaultdict(list); [grouped[key].append(value) for key, value in pairs]; print(dict(grouped))",
            "pairs = [('a', 1), ('b', 2), ('a', 3)]; grouped = {key: value for key, value in pairs}; print(grouped)",
            "from collections import Counter; pairs = [('a', 1), ('b', 2), ('a', 3)]; print(dict(Counter(dict(pairs))))",
            "pairs = [('a', 1), ('b', 2), ('a', 3)]; grouped = {}; [grouped.setdefault(value, []).append(key) for key, value in pairs]; print(grouped)"
        ),
        answerIndex = 0,
        explanation = "Only the first option accumulates values into a list per key and then converts the `defaultdict` to a normal dictionary with the required shape."
    )
)
