package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior5 = listOf(
    Problem(
        id = "bug_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Unbound Local Error",
        summary = "Modifying a variable from an outer scope.",
        prompt = "Why does this code throw an UnboundLocalError?",
        code = """
            count = 0
            def increment():
                count += 1
            increment()
        """.trimIndent(),
        options = listOf(
            "The variable `count` is assigned locally but not declared global.",
            "`count` must be passed as an argument.",
            "Functions cannot access global variables at all.",
            "The `+=` operator is not supported for integers."
        ),
        answerIndex = 0,
        explanation = "In Python, assigning to a variable inside a function makes it local to that function unless explicitly declared as `global`."
    ),
    Problem(
        id = "output_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "enumerate with custom start",
        summary = "Using enumerate's start parameter shifts the counter.",
        prompt = "What is the output of this code?",
        code = """
            items = ["a", "b", "c"]
            for i, val in enumerate(items, start=1):
                print(i, val)
        """.trimIndent(),
        options = listOf(
            "1 a\n2 b\n3 c",
            "0 a\n1 b\n2 c",
            "a 1\nb 2\nc 3",
            "1\n2\n3"
        ),
        answerIndex = 0,
        explanation = "`enumerate(iterable, start=1)` produces `(1, item0), (2, item1), …` instead of starting at 0. The `start` parameter shifts every counter value by that offset."
    ),
    Problem(
        id = "purpose_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Checking conditions",
        summary = "Using the `all()` built-in function.",
        prompt = "What does this snippet evaluate?",
        code = """
            data = [10, 20, 30]
            result = all(x > 0 for x in data)
        """.trimIndent(),
        options = listOf(
            "Checks if every number in the list is strictly positive.",
            "Checks if at least one number in the list is positive.",
            "Filters the list to keep only positive numbers.",
            "Returns the maximum value if it is positive."
        ),
        answerIndex = 0,
        explanation = "The `all()` function returns `True` only if all elements in the provided iterable are true."
    ),
    Problem(
        id = "fill_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Keyword-only settings flow",
        summary = "A helper forwards a settings dictionary into keyword-only parameters.",
        prompt = "Fill in the blank so this call keeps the shown behavior and prints `deploy True 2`.",
        code = """
            def schedule(task, *, urgent=False, retries=0):
                print(task, urgent, retries)

            settings = {"urgent": True, "retries": 2}
            schedule("deploy", ____)
        """.trimIndent(),
        options = listOf(
            "**settings",
            "*settings",
            "settings",
            "options=settings"
        ),
        answerIndex = 0,
        explanation = "`schedule` accepts one positional argument and then keyword-only settings. `**settings` expands the dictionary into named arguments (`urgent=True`, `retries=2`). `*settings` would pass only the keys positionally, `settings` passes one dict object, and `options=settings` names a parameter that the function does not accept."
    ),
    Problem(
        id = "order_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Creating a Closure",
        summary = "Arrange the lines to define a function returning another function.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "def make_multiplier(n):",
            "    def multiplier(x):",
            "        return x * n",
            "    return multiplier",
            "times_two = make_multiplier(2)"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2, 3, 4),
        explanation = "The outer function is defined first, followed by the inner function and its body. The inner function is returned, and finally, the outer function is called."
    ),
    Problem(
        id = "complexity_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "List vs Set Membership",
        summary = "Compare the membership check in both versions and determine how each scales with n.",
        prompt = "Both snippets check whether `target` is present. How does each version scale with n = len(items)?",
        code = """
            # Version A
            def check_list(items, target):
                return target in items          # items is a list

            # Version B
            def check_set(items, target):
                item_set = set(items)
                return target in item_set       # item_set is a set
        """.trimIndent(),
        options = listOf(
            "Version A: O(n), Version B: O(n) overall (set construction dominates)",
            "Version A: O(1), Version B: O(1)",
            "Version A: O(n), Version B: O(1)",
            "Version A: O(log n), Version B: O(1)"
        ),
        answerIndex = 0,
        explanation = "The `in` operator on a list scans elements one by one — O(n). Building the set from the list is also O(n), and the subsequent `in` on the set is O(1). The overall cost of Version B is therefore O(n) due to construction, not O(1). If the set were pre-built and reused, repeated lookups would each be O(1)."
    ),
    Problem(
        id = "trace_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "For-Else Loop",
        summary = "Tracing a loop with a `break` and an `else` clause.",
        prompt = "What is printed at the end?",
        code = """
            status = "Not Found"
            for i in range(3):
                if i == 5:
                    break
            else:
                status = "Finished"
            print(status)
        """.trimIndent(),
        options = listOf(
            "Finished",
            "Not Found",
            "Error",
            "None"
        ),
        answerIndex = 0,
        explanation = "The `else` block of a loop executes only if the loop completes normally without encountering a `break` statement."
    ),
    Problem(
        id = "match_medium_junior_5",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [3, 2, 1]",
        summary = "Which snippet reverses a list?",
        prompt = "Which code produces `[3, 2, 1]`?",
        code = "",
        options = listOf(
            "print([1, 2, 3][::-1])",
            "print(reversed([1, 2, 3]))",
            "print([1, 2, 3].reverse())",
            "print([1, 2, 3][:-1])"
        ),
        answerIndex = 0,
        explanation = "Using `[::-1]` slices the list from start to end with a step of -1, returning a reversed copy. `.reverse()` modifies in-place and returns `None`, while `reversed()` returns an iterator object."
    )
)
