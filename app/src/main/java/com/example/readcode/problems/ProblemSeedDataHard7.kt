package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems — batch 7. One problem per type.
// All problems target senior developers with 5+ years of Python experience.
val hardProblems7 = listOf(

    // ── FIND_BUG ──────────────────────────────────────────────────────────────

    Problem(
        id = "bug_hard_11",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Late binding in generated validators",
        summary = "A class decorator attaches validator methods in a loop, but every method validates the same field.",
        prompt = "The developer expects `validate_name` to return `('name', 'Ada')`, but it returns `('age', 'Ada')`. What is the bug?",
        code = """
            def attach_validators(cls):
                for field in ("name", "email", "age"):
                    setattr(
                        cls,
                        f"validate_{field}",
                        lambda self, value: (field, value),
                    )
                return cls

            @attach_validators
            class User:
                pass

            print(User().validate_name("Ada"))
        """.trimIndent(),
        options = listOf(
            "Each lambda closes over the same `field` variable, so all generated methods read its final value after the loop",
            "`setattr` cannot attach callables as bound methods after class creation",
            "The decorator runs before the class body is created, so the methods are discarded",
            "The f-string name `validate_{field}` is evaluated lazily when the method is called"
        ),
        answerIndex = 0,
        explanation = "The decorator creates three lambdas, but each one closes over the same loop variable `field`. By the time any validator is called, the loop has finished and `field` is `'age'`, so every method reports that field. Bind the current field at definition time, for example with `lambda self, value, field=field: (field, value)`."
    ),

    // ── OUTPUT ────────────────────────────────────────────────────────────────

    Problem(
        id = "output_hard_11",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "__init_subclass__ hook",
        summary = "A base class uses __init_subclass__ to register every subclass automatically.",
        prompt = "What is printed or raised when this script runs?",
        code = """
            class Plugin:
                _registry = []

                def __init_subclass__(cls, **kwargs):
                    super().__init_subclass__(**kwargs)
                    Plugin._registry.append(cls.__name__)

            class Alpha(Plugin): pass
            class Beta(Plugin): pass
            class Gamma(Alpha): pass

            print(Plugin._registry)
        """.trimIndent(),
        options = listOf(
            "['Alpha', 'Beta', 'Gamma']",
            "['Alpha', 'Beta']",
            "[]",
            "['Plugin', 'Alpha', 'Beta', 'Gamma']"
        ),
        answerIndex = 0,
        explanation = "`__init_subclass__` is called on the base class whenever any subclass (direct or indirect) is defined. `Alpha` and `Beta` directly subclass `Plugin`, triggering the hook for both. `Gamma` subclasses `Alpha`, which does not override `__init_subclass__`, so Python's MRO finds `Plugin.__init_subclass__` and calls it for `Gamma` as well. The `super().__init_subclass__(**kwargs)` call inside that hook then reaches `object.__init_subclass__`, completing the chain. `Plugin` itself is not a subclass, so it is not registered."
    ),

    // ── PURPOSE ───────────────────────────────────────────────────────────────

    Problem(
        id = "purpose_hard_11",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "WeakValueDictionary registry",
        summary = "A class stores objects using WeakValueDictionary so stale entries are automatically removed on garbage collection.",
        prompt = "What problem does this pattern solve?",
        code = """
            import weakref

            class Registry:
                def __init__(self):
                    self._refs = weakref.WeakValueDictionary()

                def register(self, name, obj):
                    self._refs[name] = obj

                def get(self, name):
                    return self._refs.get(name)
        """.trimIndent(),
        options = listOf(
            "Tracks objects without preventing garbage collection, and automatically removes stale entries when an object is collected",
            "Stores strong references to named objects so they are never garbage-collected",
            "Provides thread-safe access to shared objects via a lock inside the callback",
            "Serialises objects by name to disk when they go out of scope"
        ),
        answerIndex = 0,
        explanation = "`weakref.WeakValueDictionary` maps names to objects without holding a strong reference to the values. When a value is garbage-collected, its entry is automatically removed from the dictionary. This avoids a memory leak where a registry would otherwise keep dead entries indefinitely, preventing collection of objects that have no other references."
    ),

    // ── FILL_BLANK ────────────────────────────────────────────────────────────

    Problem(
        id = "fill_hard_11",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Atomic counter with GIL bypass",
        summary = "Use the correct threading primitive to coordinate a shared counter across threads.",
        prompt = "Fill the blank with the most appropriate threading primitive for protecting a shared counter — the one designed specifically for mutual exclusion in this pattern.",
        code = """
            import threading

            counter = 0
            lock = threading.___()

            def increment():
                global counter
                for _ in range(100):
                    with lock:
                        counter += 1

            threads = [threading.Thread(target=increment) for _ in range(10)]
            for t in threads: t.start()
            for t in threads: t.join()
            print(counter)
        """.trimIndent(),
        options = listOf("Lock", "Condition", "Event", "Barrier"),
        answerIndex = 0,
        explanation = "`threading.Lock()` is the purpose-built primitive for mutual exclusion: it guarantees at most one thread holds it at a time, serialising the read-modify-write and producing exactly 1000. `Condition` wraps a lock internally and also supports `with`, so it technically works here, but its purpose is wait/notify coordination between threads — using it as a plain mutex is semantically wrong and misleads readers of the code. `Event` and `Barrier` do not provide mutual exclusion at all."
    ),

    // ── ORDER_STEPS ───────────────────────────────────────────────────────────

    Problem(
        id = "order_hard_2",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Merge two sorted lists",
        summary = "Arrange the lines in source order to merge two sorted lists into one sorted list.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    while i < len(a) and j < len(b):",
            "def merge(a, b):",
            "        else:",
            "    return result + a[i:] + b[j:]",
            "    i = j = 0",
            "    result = []",
            "        if a[i] <= b[j]:",
            "            result.append(a[i]); i += 1",
            "            result.append(b[j]); j += 1"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 4, 5, 0, 6, 7, 2, 8, 3),
        explanation = "Define the function, initialise indices and result list, loop while both lists have elements, compare and append the smaller element, then append any remaining tail."
    ),

    // ── COMPLEXITY ────────────────────────────────────────────────────────────

    Problem(
        id = "complexity_hard_2",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Amortised dict resize",
        summary = "How does the cost of repeated dict insertions scale with the number of keys n?",
        prompt = "What is the amortised time complexity of inserting n keys into a Python dict, one at a time?",
        code = """
            d = {}
            for key in keys:   # len(keys) == n
                d[key] = 1
        """.trimIndent(),
        options = listOf(
            "O(n) — each insert is O(1) amortised despite occasional O(n) rehashes",
            "O(n²) — every insertion can trigger a full rehash",
            "O(n log n) — the hash table uses a balanced tree for collision chains",
            "O(1) — the dict never resizes"
        ),
        answerIndex = 0,
        explanation = "Python dicts use open addressing and resize by doubling when the load factor is exceeded. A resize copies all current entries (O(k) for k entries), but it happens exponentially less often. When amortised over n insertions, the total rehash cost is O(n), making each insertion O(1) amortised and the full loop O(n)."
    ),

    // ── TRACE_VAR ─────────────────────────────────────────────────────────────

    Problem(
        id = "trace_hard_2",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "nonlocal rebind",
        summary = "A nested function uses `nonlocal` to rebind an enclosing variable.",
        prompt = "What is the value of `total` printed at the end?",
        code = """
            def outer():
                total = 0

                def add(n):
                    nonlocal total
                    total += n

                def reset():
                    nonlocal total
                    total = 0

                add(10)
                add(5)
                reset()
                add(3)
                return total

            print(outer())
        """.trimIndent(),
        options = listOf("3", "18", "0", "15"),
        answerIndex = 0,
        explanation = "`add(10)` → total = 10. `add(5)` → total = 15. `reset()` → total = 0. `add(3)` → total = 3. `outer()` returns `3`."
    ),

    // ── OUTPUT (additional) ───────────────────────────────────────────────────

    Problem(
        id = "match_hard_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "MRO and super() resolution",
        summary = "Predict the output of cooperative multiple inheritance via super().",
        prompt = "Which output does this MRO chain produce?",
        code = """
            class A:
                def greet(self): return "A"
            class B(A):
                def greet(self): return "B" + super().greet()
            class C(A):
                def greet(self): return "C" + super().greet()
            class D(B, C):
                def greet(self): return "D" + super().greet()
            print(D().greet())
        """.trimIndent(),
        options = listOf(
            "DBCA",
            "DBA",
            "DCA",
            "DCBA"
        ),
        answerIndex = 0,
        explanation = "Python MRO for D is [D, B, C, A]. `D.greet` calls `super()` which is B. `B.greet` calls `super()` which is C (not A, because MRO continues from B's position). `C.greet` calls `super()` which is A. So the call chain is D→B→C→A, producing 'D'+'B'+'C'+'A' = 'DBCA'."
    )
)
