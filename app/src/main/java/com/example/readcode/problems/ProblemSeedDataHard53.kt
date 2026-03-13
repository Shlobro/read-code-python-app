package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Hard-difficulty problems batch 53.
// One senior-level problem per problem type.
val hardProblems53 = listOf(
    Problem(
        id = "bug_hard_54",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Slot inheritance collision",
        summary = "A subclass that defines `__slots__` still gains a `__dict__` through its parent.",
        prompt = "What is the actual bug here?",
        code = """
            class Base:
                pass

            class Node(Base):
                __slots__ = ("value",)

            n = Node()
            n.value = 10
            n.extra = "leak"
            print(n.__dict__)
        """.trimIndent(),
        options = listOf(
            "Slots cannot hold integers",
            "`__slots__` prevents all attribute assignment",
            "Base lacks `__slots__`, so Node still has `__dict__`",
            "Inheriting from object always raises an error with slots"
        ),
        answerIndex = 2,
        explanation = "Every class in the MRO that does not define `__slots__` contributes a `__dict__`. Because `Base` omits `__slots__`, `Node` instances still carry a full `__dict__`, silently defeating the memory-savings intent."
    ),
    Problem(
        id = "output_hard_54",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Descriptor `__set_name__` timing",
        summary = "A descriptor uses the owner attribute name injected at class-creation time.",
        prompt = "What does this code print?",
        code = """
            class Tracked:
                def __set_name__(self, owner, name):
                    self.name = name

                def __get__(self, obj, objtype=None):
                    return self.name

            class Config:
                host = Tracked()
                port = Tracked()

            c = Config()
            print(c.host, c.port)
        """.trimIndent(),
        options = listOf(
            "host port",
            "Tracked Tracked",
            "None None",
            "host host"
        ),
        answerIndex = 0,
        explanation = "Python calls `__set_name__` once per descriptor at class-body evaluation time, passing the attribute name as a string. `c.host` returns `\"host\"` and `c.port` returns `\"port\"`."
    ),
    Problem(
        id = "purpose_hard_54",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Transparent attribute proxy",
        summary = "A wrapper object forwards attribute reads to a wrapped instance without subclassing.",
        prompt = "What does this class do overall?",
        code = """
            class Proxy:
                def __init__(self, target):
                    object.__setattr__(self, "_target", target)

                def __getattr__(self, name):
                    return getattr(object.__getattribute__(self, "_target"), name)

                def __setattr__(self, name, value):
                    setattr(object.__getattribute__(self, "_target"), name, value)
        """.trimIndent(),
        options = listOf(
            "It freezes the target so no attributes can change",
            "It forwards attribute reads and writes to the wrapped object",
            "It copies all attributes from the target into itself at construction",
            "It provides read-only views of the wrapped object's attributes while blocking writes"
        ),
        answerIndex = 1,
        explanation = "`__getattr__` delegates reads that are not found on the proxy itself. `__setattr__` always routes writes to the wrapped target. `object.__setattr__` and `object.__getattribute__` bypass these hooks internally so `_target` does not recurse."
    ),
    Problem(
        id = "fill_hard_54",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Thread-safe counter init",
        summary = "A class-level counter must be protected across threads.",
        prompt = "Which choice fills the blank so the counter is incremented without a race condition?",
        code = """
            import threading

            _lock = threading.Lock()
            _count = 0

            def increment():
                global _count
                ___ _lock:
                    _count += 1
        """.trimIndent(),
        options = listOf(
            "with",
            "acquire",
            "synchronized",
            "using"
        ),
        answerIndex = 0,
        explanation = "The `with` statement on a `Lock` acquires it on entry and releases it on exit, ensuring the read-modify-write sequence is atomic."
    ),
    Problem(
        id = "order_hard_53",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "LRU cache with OrderedDict",
        summary = "Arrange the lines of a minimal LRU cache `get` method that moves a hit to the end.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def get(self, key):",
            "    if key not in self.cache:",
            "        return -1",
            "    self.cache.move_to_end(key)",
            "    return self.cache[key]"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "First define the method, guard against a missing key, move the hit to the most-recently-used end, then return its value."
    ),
    Problem(
        id = "complexity_hard_53",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Sliding window deque",
        summary = "A monotonic deque tracks the minimum over a sliding window of fixed width.",
        prompt = "If the input list has length `n` and the window width is `k`, what is the time complexity?",
        code = """
            from collections import deque

            def sliding_min(nums, k):
                dq = deque()
                out = []
                for i, val in enumerate(nums):
                    while dq and nums[dq[-1]] >= val:
                        dq.pop()
                    dq.append(i)
                    if dq[0] <= i - k:
                        dq.popleft()
                    if i >= k - 1:
                        out.append(nums[dq[0]])
                return out
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(nk)",
            "O(n log k)",
            "O(n log n)"
        ),
        answerIndex = 0,
        explanation = "Every element is pushed onto the deque exactly once and popped at most once, so the total work is O(n) regardless of window width."
    ),
    Problem(
        id = "trace_hard_53",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "MRO diamond with cooperative super",
        summary = "Two mixin classes both call `super().__init__` in a diamond inheritance layout.",
        prompt = "What is the value of `obj.log` after this code runs?",
        code = """
            class Base:
                def __init__(self):
                    self.log = []

            class A(Base):
                def __init__(self):
                    super().__init__()
                    self.log.append("A")

            class B(Base):
                def __init__(self):
                    super().__init__()
                    self.log.append("B")

            class C(A, B):
                def __init__(self):
                    super().__init__()
                    self.log.append("C")

            obj = C()
        """.trimIndent(),
        options = listOf(
            "['A', 'B', 'C']",
            "['C', 'A', 'B']",
            "['B', 'A', 'C']",
            "['C']"
        ),
        answerIndex = 2,
        explanation = "The MRO is C → A → B → Base. `super().__init__()` chains through the full MRO before any `append` runs. Base sets `log = []`, then B appends `\"B\"`, then A appends `\"A\"`, then C appends `\"C\"`, yielding `['B', 'A', 'C']`."
    ),
    Problem(
        id = "match_hard_53",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [1, 3]",
        summary = "Pick the snippet that filters a list to only odd numbers using a generator.",
        prompt = "Which code produces this output?",
        code = "[1, 3]",
        options = listOf(
            "print(list(filter(lambda x: x % 2 == 0, [1, 2, 3])))",
            "print(list(x for x in [1, 2, 3] if x % 2 != 0))",
            "print([x for x in [1, 2, 3] if x % 2 == 0])",
            "print(list(map(lambda x: x % 2, [1, 2, 3])))"
        ),
        answerIndex = 1,
        explanation = "The generator expression keeps only elements where `x % 2 != 0`, which are the odd numbers `1` and `3`."
    )
)
