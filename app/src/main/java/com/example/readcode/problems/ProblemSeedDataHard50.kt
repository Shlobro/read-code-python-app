package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 50.
// One senior-level problem per problem type.
val hardProblems50 = listOf(
    Problem(
        id = "bug_hard_51",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "cached_property on a slotted class",
        summary = "The code combines a descriptor-backed cache with a class that has no instance dictionary.",
        prompt = "What is the actual bug here?",
        code = """
            from functools import cached_property

            class Payload:
                __slots__ = ("text",)

                def __init__(self, text):
                    self.text = text

                @cached_property
                def parts(self):
                    return self.text.split(",")

            print(Payload("a,b").parts)
        """.trimIndent(),
        options = listOf(
            "`split` must run inside `__init__`",
            "`__slots__` forbids string attributes",
            "The instance has no `__dict__` for the cache",
            "`cached_property` only works on classmethods"
        ),
        answerIndex = 2,
        explanation = "`cached_property` stores the computed value on the instance. With `__slots__ = (\"text\",)` there is no instance `__dict__`, so the descriptor cannot cache the result."
    ),
    Problem(
        id = "output_hard_51",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor access path",
        summary = "The same descriptor is read once through the class and once through an instance.",
        prompt = "What does this code print?",
        code = """
            class NameAware:
                def __get__(self, obj, owner):
                    if obj is None:
                        return owner.__name__
                    return type(obj).__name__

            class Base:
                label = NameAware()

            class Child(Base):
                pass

            print(Base.label)
            print(Child().label)
        """.trimIndent(),
        options = listOf(
            "Base\nBase",
            "Child\nChild",
            "NameAware\nChild",
            "Base\nChild"
        ),
        answerIndex = 3,
        explanation = "When accessed on the class, `obj` is `None`, so the descriptor returns `Base`. When accessed on an instance, it returns that instance's class name, `Child`."
    ),
    Problem(
        id = "purpose_hard_51",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Sentinel-driven reader",
        summary = "A callable is turned into an iterator that stops on an empty chunk.",
        prompt = "What does this function do overall?",
        code = """
            def blocks(stream, size):
                return iter(lambda: stream.read(size), "")
        """.trimIndent(),
        options = listOf(
            "It rewinds the stream after each read",
            "It reads fixed-size chunks lazily until EOF",
            "It joins adjacent chunks into one string",
            "It converts the stream into numbered fixed-size records"
        ),
        answerIndex = 1,
        explanation = "`iter(callable, sentinel)` keeps calling `stream.read(size)` and yields each result until the callable returns the sentinel value `\"\"`, which signals end-of-file for text reads."
    ),
    Problem(
        id = "fill_hard_51",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Selective exception suppression",
        summary = "The context manager should ignore a missing dictionary key and keep running.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            from contextlib import suppress

            data = {"x": 1}
            with suppress(___):
                print(data["missing"])
            print("done")
        """.trimIndent(),
        options = listOf(
            "KeyError",
            "ValueError",
            "AttributeError",
            "IndexError"
        ),
        answerIndex = 0,
        explanation = "A missing dictionary key raises `KeyError`, and `suppress(KeyError)` absorbs that exception so execution continues to the final print."
    ),
    Problem(
        id = "order_hard_50",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Temporary attribute patch",
        summary = "Arrange the lines to build a context manager that restores an attribute after use.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "from contextlib import contextmanager",
            "@contextmanager",
            "def patched(obj, name, value):",
            "    old = getattr(obj, name)",
            "    setattr(obj, name, value)",
            "    try:",
            "        yield",
            "    finally:",
            "        setattr(obj, name, old)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        explanation = "Import and apply `@contextmanager`, capture the old attribute value, set the temporary value, then wrap `yield` in `try/finally` so the original attribute is always restored."
    ),
    Problem(
        id = "complexity_hard_50",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sorting every suffix",
        summary = "Each loop iteration sorts a shorter suffix and takes its first item.",
        prompt = "If `values` has length `n`, what is the worst-case time complexity?",
        code = """
            def total(values):
                acc = 0
                for i in range(len(values)):
                    acc += sorted(values[i:])[0]
                return acc
        """.trimIndent(),
        options = listOf(
            "O(n log n)",
            "O(n²)",
            "O(n² log n)",
            "O(n² log² n)"
        ),
        answerIndex = 2,
        explanation = "The code sorts suffixes of lengths `n`, `n-1`, `n-2`, and so on. Summing `k log k` over all suffix lengths gives O(n² log n)."
    ),
    Problem(
        id = "trace_hard_50",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Shallow copy with mutate then rebind",
        summary = "Two dictionaries share one inner list until one side is rebound to a new list object.",
        prompt = "What is the value of `left[\"nums\"]` after this code runs?",
        code = """
            left = {"nums": [1]}
            right = left.copy()

            right["nums"] += [2]
            right["nums"] = right["nums"] + [3]
        """.trimIndent(),
        options = listOf(
            "[1]",
            "[1, 2]",
            "[1, 2, 3]",
            "KeyError"
        ),
        answerIndex = 1,
        explanation = "`.copy()` is shallow, so both dictionaries initially share the same list. `+= [2]` mutates that shared list. The later `+ [3]` creates a new list and rebinds only `right`."
    ),
    Problem(
        id = "match_hard_50",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: {'a': ['ant', 'ape'], 'b': ['bat']}",
        summary = "Pick the snippet that groups words by first letter without losing earlier entries.",
        prompt = "Which code produces this output?",
        code = "{'a': ['ant', 'ape'], 'b': ['bat']}",
        options = listOf(
            "groups = {}; [groups.setdefault(w, []).append(w[0]) for w in [\"ant\", \"ape\", \"bat\"]]; print(groups)",
            "groups = {}; [groups.setdefault(w[0], []).append(w) for w in [\"ant\", \"ape\", \"bat\"]]; print(groups)",
            "groups = {}; [groups.__setitem__(w[0], [w]) for w in [\"ant\", \"ape\", \"bat\"]]; print(groups)",
            "groups = {}; [groups.setdefault(w[0], []).append(len(w)) for w in [\"ant\", \"ape\", \"bat\"]]; print(groups)"
        ),
        answerIndex = 1,
        explanation = "Only the second snippet uses the first letter as the key and appends each full word to that key's list, preserving both `ant` and `ape` under `a`."
    )
)
