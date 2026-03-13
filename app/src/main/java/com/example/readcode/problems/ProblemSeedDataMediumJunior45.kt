package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior45 = listOf(
    Problem(
        id = "bug_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Default Mutable Arguments",
        summary = "Using a dictionary as a default parameter.",
        prompt = "Why might this function cause unexpected behavior across multiple calls?",
        code = """
            def get_user_data(user_id, cache={}):
                if user_id in cache:
                    return cache[user_id]
                cache[user_id] = "data_" + str(user_id)
                return cache[user_id]
        """.trimIndent(),
        options = listOf(
            "The dictionary is shared.",
            "It checks for the key before verifying the data type of the dictionary object.",
            "The database fetch function is missing proper async/await handling in this context.",
            "A KeyError will be raised immediately if the user_id is missing from the dictionary."
        ),
        answerIndex = 0,
        explanation = "Default arguments are evaluated exactly once when the function is defined. Because dictionaries are mutable, the same dictionary instance is shared across all calls that don't provide a `cache`."
    ),
    Problem(
        id = "output_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Shared Default List",
        summary = "Appending to a default list argument.",
        prompt = "What is the output of the two print statements?",
        code = """
            def multiply(a, b=[]):
                b.append(a)
                return b

            print(multiply(1))
            print(multiply(2))
        """.trimIndent(),
        options = listOf(
            "[1] then [1, 2]",
            "[1] followed by [2] because default arguments are re-evaluated on each call",
            "An error is thrown because you cannot append to a default list argument",
            "It prints [1] and then [2] because each function invocation creates a new list"
        ),
        answerIndex = 0,
        explanation = "Since the default list is created only once at definition time, the second call appends to the same list that was modified by the first call."
    ),
    Problem(
        id = "purpose_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Type Filtering",
        summary = "Using a list comprehension with isinstance.",
        prompt = "What does this function do?",
        code = """
            def process(items):
                return [x for x in items if isinstance(x, int)]
        """.trimIndent(),
        options = listOf(
            "Filters out non-integers.",
            "It iterates through every single item and converts them all into integer values.",
            "Returns a boolean array indicating which elements are formatted as integer numbers.",
            "Modifies the original list in-place by removing any elements that do not match the int type."
        ),
        answerIndex = 0,
        explanation = "The list comprehension constructs a new list containing only those elements from `items` that are instances of `int`."
    ),
    Problem(
        id = "fill_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Class Instantiation",
        summary = "Creating an instance of a class.",
        prompt = "Fill in the blank to create a new Node.",
        code = """
            class Node:
                def __init__(self, value):
                    self.value = value
                    self.next = None

            my_node = ________
        """.trimIndent(),
        options = listOf(
            "Node(5)",
            "Node.create_instance(5)",
            "new Node(value=5)",
            "Node.__init__(self, 5)"
        ),
        answerIndex = 0,
        explanation = "In Python, classes are instantiated by calling the class name as if it were a function, passing the arguments required by `__init__`."
    ),
    Problem(
        id = "order_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Basic Decorator",
        summary = "Structuring a simple Python decorator.",
        prompt = "Arrange the lines to correctly define a function decorator.",
        code = "",
        options = listOf(
            "def my_decorator(func):",
            "    def wrapper():",
            "        print(\"Before\")",
            "        func()",
            "    return wrapper"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "A decorator takes a function as an argument, defines a nested wrapper function that adds behavior and calls the original function, and then returns that wrapper."
    ),
    Problem(
        id = "complexity_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Set Conversion Complexity",
        summary = "Time complexity of converting a list to a set.",
        prompt = "What is the average time complexity of this function where N is the length of `arr`?",
        code = """
            def unique_elements(arr):
                return list(set(arr))
        """.trimIndent(),
        options = listOf(
            "O(N)",
            "O(N log N) because sorting is required internally before converting",
            "O(N^2) due to checking for duplicates during every single insertion",
            "O(1) amortized time complexity across all list sizes regardless of elements"
        ),
        answerIndex = 0,
        explanation = "Constructing a set iterates over the list once (O(N)), and hashing each element is O(1) on average. Converting back to a list is also O(N). Total time complexity is O(N)."
    ),
    Problem(
        id = "trace_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Nested Loop Condition",
        summary = "Tracing a counter inside nested loops with a condition.",
        prompt = "What is the value of `total` after the loops complete?",
        code = """
            total = 0
            for i in range(3):
                for j in range(2):
                    if i == j:
                        total += 1
        """.trimIndent(),
        options = listOf(
            "2",
            "3, because the outer loop runs exactly three times overall",
            "4, since the inner loop runs twice for each iteration of the outer loop",
            "An error occurs due to variable scoping issues within the nested blocks"
        ),
        answerIndex = 0,
        explanation = "The loops test pairs (0,0), (0,1), (1,0), (1,1), (2,0), and (2,1). The condition `i == j` is true only for (0,0) and (1,1), so `total` becomes 2."
    ),
    Problem(
        id = "match_medium_junior_45",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Character Counting",
        summary = "Identifying code that produces a specific frequency dictionary.",
        prompt = "Which snippet produces this output?\n\n{'a': 2, 'b': 1}",
        code = "",
        options = listOf(
            "from collections import Counter\nprint(dict(Counter(\"aab\")))",
            "counts = {'a': 0, 'b': 0}\nfor char in \"aab\":\n    counts[char] = counts.get(char, 0) + 1\nprint(counts)",
            "result = {}\nfor letter in [\"a\", \"a\", \"b\"]:\n    if letter not in result:\n        result[letter] = 0\n    result[letter] += 1\nprint(result)",
            "import itertools\ngroups = itertools.groupby(\"aab\")\nprint({k: len(list(v)) for k, v in groups})"
        ),
        answerIndex = 0,
        explanation = "The `Counter` from the `collections` module automatically builds a frequency map, and wrapping it in `dict()` produces a standard dictionary output matching the prompt."
    )
)
