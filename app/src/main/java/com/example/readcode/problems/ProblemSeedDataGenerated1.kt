package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

// Mixed-difficulty expansion batch generated from the add-new-problems workflow.
val generatedProblems1 = listOf(
    Problem(
        id = "bug_easy_4",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Missing colon",
        summary = "A syntax error prevents execution.",
        prompt = "Why won't this code run?",
        code = """
            if True
                print("Yes")
        """.trimIndent(),
        options = listOf("Missing colon after True", "True must be lowercase", "print must be on the same line", "Indentation is wrong"),
        answerIndex = 0,
        explanation = "Python requires a colon `:` at the end of an `if` statement."
    ),
    Problem(
        id = "output_easy_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Math operations",
        summary = "Basic arithmetic in Python.",
        prompt = "What does this print?",
        code = """
            print(10 // 3)
        """.trimIndent(),
        options = listOf("3", "3.33", "1", "0"),
        answerIndex = 0,
        explanation = "`//` performs integer division, discarding the remainder."
    ),
    Problem(
        id = "purpose_easy_4",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Greeting function",
        summary = "A simple string formatting function.",
        prompt = "What does this function do?",
        code = """
            def greet(name):
                return f"Hello, {name}!"
        """.trimIndent(),
        options = listOf("Returns a personalized greeting", "Prints a name to the screen", "Changes the name variable", "Checks if name is a string"),
        answerIndex = 0,
        explanation = "The function uses an f-string to return a greeting containing the provided name."
    ),
    Problem(
        id = "fill_easy_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Import module",
        summary = "Bringing in code from the standard library.",
        prompt = "Fill the blank to make the math module available.",
        code = """
            ___ math
            print(math.pi)
        """.trimIndent(),
        options = listOf("import", "include", "require", "use"),
        answerIndex = 0,
        explanation = "The `import` keyword is used in Python to load external modules."
    ),
    Problem(
        id = "bug_medium_4",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "List pop in loop",
        summary = "Removing elements while using a fixed range.",
        prompt = "Why does this code throw an IndexError?",
        code = """
            items = [1, 2, 3]
            for i in range(len(items)):
                if items[i] % 2 != 0:
                    items.pop(i)
        """.trimIndent(),
        options = listOf(
            "The list shrinks, making the original range indices invalid",
            "`.pop()` cannot take an index argument",
            "The loop should use `while` instead",
            "The `range` function does not work with `len()`"
        ),
        answerIndex = 0,
        explanation = "Modifying the length of a list while iterating over a predefined range of indices causes an IndexError when trying to access elements that have shifted or no longer exist."
    ),
    Problem(
        id = "output_medium_4",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Default dict value",
        summary = "Using setdefault on a dictionary.",
        prompt = "What does this code print?",
        code = """
            data = {"x": 10}
            data.setdefault("y", 20)
            data.setdefault("x", 30)
            print(data["x"], data["y"])
        """.trimIndent(),
        options = listOf("10 20", "30 20", "10 30", "Error"),
        answerIndex = 0,
        explanation = "`setdefault()` adds the key with the default value only if the key is not already present. Since 'x' exists, it remains 10."
    ),
    Problem(
        id = "purpose_medium_4",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Group names by team",
        summary = "Building a dictionary of lists from row data.",
        prompt = "What does this code build in `grouped`?",
        code = """
            rows = [("Ana", "api"), ("Ben", "web"), ("Cara", "api")]
            grouped = {}
            for name, team in rows:
                grouped.setdefault(team, []).append(name)
        """.trimIndent(),
        options = listOf(
            "A mapping from each team to the list of names assigned to it",
            "A list of `(team, name)` tuples sorted alphabetically",
            "A mapping from each name to a count of matching teams",
            "A flat list containing alternating team and name values"
        ),
        answerIndex = 0,
        explanation = "`setdefault(team, [])` ensures each team has a list, and `.append(name)` groups every name under its matching team key."
    ),
    Problem(
        id = "fill_medium_4",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Independent row copies",
        summary = "Building a grid without accidentally aliasing every row to the same list.",
        prompt = "Fill in the blank so each update touches only one row in `grid`.",
        code = """
            row = [0, 0]
            grid = [___ for _ in range(3)]
            grid[0][1] = 9
            print(grid)
        """.trimIndent(),
        options = listOf("row.copy()", "row", "row + [0]", "row.extend([0])"),
        answerIndex = 0,
        explanation = "`row.copy()` creates a fresh list for each iteration, so mutating `grid[0]` does not affect the other rows. Reusing `row` would alias all three entries to the same list object, while `row + [0]` creates the wrong row shape."
    ),
    Problem(
        id = "bug_medium_6",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Closure variable capture",
        summary = "A loop creates functions that all share the same variable.",
        prompt = "Why do all functions print 2 instead of 0, 1, 2?",
        code = """
            funcs = []
            for i in range(3):
                funcs.append(lambda: i)
            print([f() for f in funcs])
        """.trimIndent(),
        options = listOf(
            "All lambdas capture the same `i` variable by reference",
            "Lambdas cannot be stored in lists",
            "`range(3)` starts at 1, not 0",
            "List comprehensions evaluate lazily"
        ),
        answerIndex = 0,
        explanation = "Python lambdas capture variables by reference, not by value. By the time the lambdas are called, the loop has finished and `i` is 2 for all of them."
    ),
    Problem(
        id = "output_medium_6",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Class variable vs instance variable",
        summary = "A shared class attribute is modified on one instance.",
        prompt = "What does this code print?",
        code = """
            class Dog:
                tricks = []
                def add(self, trick):
                    self.tricks.append(trick)

            a = Dog()
            b = Dog()
            a.add("sit")
            print(b.tricks)
        """.trimIndent(),
        options = listOf("[]", "['sit']", "Error", "None"),
        answerIndex = 1,
        explanation = "`tricks` is a class variable shared by all instances. Appending to it via `a` mutates the same list that `b` sees."
    ),
    Problem(
        id = "purpose_medium_6",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Recursive flatten",
        summary = "A function that handles arbitrarily nested lists.",
        prompt = "What does this function produce?",
        code = """
            def flatten(lst):
                result = []
                for item in lst:
                    if isinstance(item, list):
                        result.extend(flatten(item))
                    else:
                        result.append(item)
                return result
        """.trimIndent(),
        options = listOf(
            "A single flat list with all nested elements in order",
            "A list of lists with one level of nesting removed",
            "The deepest nested element only",
            "A sorted version of all the elements"
        ),
        answerIndex = 0,
        explanation = "The function recurses into any nested list and extends the result, producing one flat list of all leaf elements regardless of nesting depth."
    ),
    Problem(
        id = "fill_medium_6",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Second pass over data",
        summary = "An iterator is consumed after one full pass.",
        prompt = "Fill in the blank so `second` still sums all original values after `stream` has already been consumed once.",
        code = """
            values = [4, 5, 6]
            stream = iter(values)
            first = sum(stream)
            second = sum(___)
            print(first, second)
        """.trimIndent(),
        options = listOf("values", "stream", "iter(stream)", "next(stream)"),
        answerIndex = 0,
        explanation = "Iterators are exhausted after they are consumed. `sum(stream)` drains `stream`, so the second sum must iterate over `values`, which can provide a fresh iterator, rather than over the already-consumed iterator."
    ),
    Problem(
        id = "bug_easy_5",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "List index out of range",
        summary = "Accessing an element past the end of the list.",
        prompt = "Why does this code crash?",
        code = """
            colors = ["red", "blue", "green"]
            print(colors[3])
        """.trimIndent(),
        options = listOf(
            "The valid indexes are 0, 1, and 2",
            "Colors must be printed inside a loop",
            "Lists use parentheses instead of brackets",
            "The color green is not a valid string"
        ),
        answerIndex = 0,
        explanation = "Lists are zero-indexed, so a list with 3 items has valid indexes 0, 1, and 2. Index 3 is out of range."
    ),
    Problem(
        id = "output_easy_5",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String concatenation",
        summary = "Adding two strings together.",
        prompt = "What does this code print?",
        code = """
            first = "Hello"
            second = "World"
            print(first + second)
        """.trimIndent(),
        options = listOf("HelloWorld", "Hello World", "Hello+World", "Error"),
        answerIndex = 0,
        explanation = "The `+` operator joins two strings directly without adding a space, producing `HelloWorld`."
    ),
    Problem(
        id = "purpose_easy_5",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Type conversion",
        summary = "Converting a string to an integer.",
        prompt = "What is this code doing?",
        code = """
            user_input = "42"
            number = int(user_input)
            print(number + 10)
        """.trimIndent(),
        options = listOf(
            "Converts a string to a number so it can be used in math",
            "Changes the number 42 into a string",
            "Rounds the number up to 52",
            "Checks if 42 is an integer"
        ),
        answerIndex = 0,
        explanation = "The `int()` function converts the text `\"42\"` into the integer `42` so we can perform math on it."
    ),
    Problem(
        id = "fill_easy_5",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Condition check",
        summary = "Checking if a number is even.",
        prompt = "Fill in the blank to check if the number is even.",
        code = """
            num = 8
            if num % 2 ___ 0:
                print("Even")
        """.trimIndent(),
        options = listOf("==", "=", "is", "==="),
        answerIndex = 0,
        explanation = "The `==` operator is used to check for equality in Python. `=` is used for assignment."
    ),
    Problem(
        id = "bug_medium_5",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Deleting keys during iteration",
        summary = "Removing items from a dictionary inside a loop.",
        prompt = "Why does this code throw a RuntimeError?",
        code = """
            users = {"alice": "active", "bob": "inactive", "charlie": "active"}
            for name, status in users.items():
                if status == "inactive":
                    del users[name]
        """.trimIndent(),
        options = listOf(
            "Dictionary size changed during iteration",
            "`del` is not the correct way to remove a key",
            "`users.items()` returns a tuple, which is immutable",
            "The loop unpacks two variables but items() yields one"
        ),
        answerIndex = 0,
        explanation = "Modifying the size of a dictionary while iterating over its views (like `.items()`) raises a RuntimeError."
    ),
    Problem(
        id = "output_medium_5",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Shallow copy modification",
        summary = "Appending to a nested list after copying.",
        prompt = "What does this code print?",
        code = """
            matrix = [[1, 2], [3, 4]]
            new_matrix = list(matrix)
            new_matrix[0].append(9)
            print(matrix[0])
        """.trimIndent(),
        options = listOf(
            "[1, 2, 9]",
            "[1, 2]",
            "[[1, 2, 9], [3, 4]]",
            "Error"
        ),
        answerIndex = 0,
        explanation = "`list()` creates a shallow copy. The outer list is new, but the inner lists are the same objects in memory."
    ),
    Problem(
        id = "purpose_medium_5",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Collapse consecutive duplicates",
        summary = "Building a new list while comparing against the last accepted item.",
        prompt = "What does this function return?",
        code = """
            def compress(values):
                result = []
                for value in values:
                    if not result or result[-1] != value:
                        result.append(value)
                return result
        """.trimIndent(),
        options = listOf(
            "A list with consecutive duplicate values removed while preserving order",
            "A sorted list containing each value only once",
            "Only the values that appear more than once anywhere in the list",
            "The longest run of repeated values from the input"
        ),
        answerIndex = 0,
        explanation = "The function appends the first value, then only appends later values when they differ from the last item already stored in `result`. That removes repeated runs like `1, 1, 1` but keeps later reappearances after a change."
    ),
    Problem(
        id = "fill_medium_5",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Snapshot before deletion",
        summary = "Avoiding runtime errors when removing dictionary entries during iteration.",
        prompt = "Which wrapper fills the blank so the loop iterates over a stable snapshot of the items?",
        code = """
            users = {"ana": "active", "bob": "inactive"}
            for name, status in ___(users.items()):
                if status == "inactive":
                    del users[name]
        """.trimIndent(),
        options = listOf("list", "dict", "enumerate", "iter"),
        answerIndex = 0,
        explanation = "`list(users.items())` materializes the key-value pairs before the loop starts, so deleting from `users` no longer mutates the collection being iterated."
    ),
    Problem(
        id = "bug_hard_7",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Descriptor shadowed by assignment",
        summary = "A non-data descriptor stops controlling reads after an instance write.",
        prompt = "Why does this print `alice` instead of `ALICE`?",
        code = """
            class UpperName:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return obj.__dict__.get("name", "").upper()

            class User:
                name = UpperName()

            u = User()
            u.name = "alice"
            print(u.name)
        """.trimIndent(),
        options = listOf(
            "Assigning `u.name` creates an instance attribute that shadows a non-data descriptor",
            "Descriptors only run for class access, not instance access",
            "`__get__` must return bytes rather than strings",
            "The bug is that `objtype` should be `type(obj)`"
        ),
        answerIndex = 0,
        explanation = "Because `UpperName` only defines `__get__`, it is a non-data descriptor. The assignment `u.name = \"alice\"` writes directly into the instance dictionary, and instance attributes take precedence over non-data descriptors on reads."
    ),
    Problem(
        id = "output_hard_7",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Cooperative MRO chain",
        summary = "Multiple inheritance plus `super()` follows the method-resolution order, not the class text order of each method.",
        prompt = "What does this code print?",
        code = """
            class Root:
                def chain(self):
                    return ["Root"]

            class Left(Root):
                def chain(self):
                    return ["Left"] + super().chain()

            class Right(Root):
                def chain(self):
                    return ["Right"] + super().chain()

            class Leaf(Left, Right):
                def chain(self):
                    return ["Leaf"] + super().chain()

            print(Leaf().chain())
        """.trimIndent(),
        options = listOf(
            "['Leaf', 'Left', 'Right', 'Root']",
            "['Leaf', 'Left', 'Root', 'Right']",
            "['Leaf', 'Right', 'Left', 'Root']",
            "['Leaf', 'Root']"
        ),
        answerIndex = 0,
        explanation = "For `Leaf(Left, Right)`, Python's MRO is `Leaf -> Left -> Right -> Root`. Each `super().chain()` call advances to the next class in that linearized order."
    ),
    Problem(
        id = "purpose_hard_7",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Weak-reference cache",
        summary = "Reuse live objects without preventing them from being garbage-collected.",
        prompt = "What is the purpose of this class design?",
        code = """
            import weakref

            class Loader:
                _cache = weakref.WeakValueDictionary()

                @classmethod
                def get(cls, key):
                    obj = cls._cache.get(key)
                    if obj is None:
                        obj = cls(key)
                        cls._cache[key] = obj
                    return obj

                def __init__(self, key):
                    self.key = key
        """.trimIndent(),
        options = listOf(
            "Reuse objects by key while still allowing unused cached instances to be garbage-collected",
            "Guarantee that only one `Loader` instance can ever exist in the process",
            "Serialize access to `Loader.get()` so different threads do not race",
            "Store objects in a cache that survives interpreter restarts"
        ),
        answerIndex = 0,
        explanation = "`WeakValueDictionary` keeps weak references to cached values. Callers can reuse an existing live object for the same key, but once nothing else strongly references that object, it can disappear from the cache automatically."
    ),
    Problem(
        id = "fill_hard_7",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Descriptor precedence trap",
        summary = "One missing descriptor method changes whether instance state can silently override class-managed access.",
        prompt = "Fill in the blank so the descriptor keeps precedence over `obj.__dict__` and `print(obj.token)` still outputs `descriptor`.",
        code = """
            class Token:
                def __get__(self, obj, objtype=None):
                    if obj is None:
                        return self
                    return "descriptor"

                def ___(self, obj, value):
                    pass

            class Session:
                token = Token()

            obj = Session()
            obj.token = "cached"
            print(obj.token)
        """.trimIndent(),
        options = listOf("__delete__", "__set__", "__set_name__", "__init__"),
        answerIndex = 1,
        explanation = "A descriptor becomes a data descriptor when it defines `__set__` or `__delete__`. Adding `__set__` means `obj.token = \"cached\"` is intercepted by the descriptor, and later reads still go through `__get__`, so the instance dictionary never takes precedence."
    )
)
