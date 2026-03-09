package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val newTypeProblems1 = listOf(

    // ── ORDER_STEPS ────────────────────────────────────────────────────────────

    Problem(
        id = "order_easy_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Build a greeting",
        summary = "Arrange the lines in source order so the code prints a greeting.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "print(greeting)",
            "name = \"Alice\"",
            "greeting = \"Hello, \" + name"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 0),
        explanation = "First assign `name`, then build `greeting` from it, then print."
    ),

    Problem(
        id = "order_easy_2",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.EASY,
        title = "Sum two numbers",
        summary = "Arrange the lines in source order to add two numbers and print the result.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "print(total)",
            "a = 3",
            "b = 4",
            "total = a + b"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 2, 3, 0),
        explanation = "Both variables must exist before they can be added, and `total` must exist before it can be printed."
    ),

    Problem(
        id = "order_medium_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count down loop",
        summary = "Arrange the lines in source order so the code counts down from 3 to 1.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    print(n)",
            "n = 3",
            "    n -= 1",
            "while n > 0:"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 3, 0, 2),
        explanation = "In source order: assign `n` first, then the while header, then the indented print, then the decrement."
    ),

    Problem(
        id = "order_medium_2",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Filter positives",
        summary = "Arrange the lines in source order to collect positive numbers from a list.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "positives = []",
            "    if n > 0:",
            "for n in numbers:",
            "        positives.append(n)",
            "numbers = [-1, 2, -3, 4]"
        ),
        answerIndex = 0,
        correctOrder = listOf(4, 0, 2, 1, 3),
        explanation = "Define the source list and the result list first, then loop, check, and append."
    ),

    Problem(
        id = "order_hard_1",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.HARD,
        title = "Factorial function",
        summary = "Arrange the lines in source order to form a recursive factorial function.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    if n == 0:",
            "def factorial(n):",
            "        return 1",
            "    return n * factorial(n - 1)"
        ),
        answerIndex = 0,
        correctOrder = listOf(1, 0, 2, 3),
        explanation = "The `def` comes first, then the base case check, the base case return, and finally the recursive return."
    ),

    // ── COMPLEXITY ────────────────────────────────────────────────────────────

    Problem(
        id = "complexity_easy_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Simple loop count",
        summary = "How many times does `print` execute?",
        prompt = "How many times does `print(i)` run?",
        code = """
            for i in range(5):
                print(i)
        """.trimIndent(),
        options = listOf("5", "4", "6", "It depends on the machine"),
        answerIndex = 0,
        explanation = "`range(5)` produces 0, 1, 2, 3, 4 — exactly 5 values, so print runs 5 times."
    ),

    Problem(
        id = "complexity_easy_2",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.EASY,
        title = "Which is faster?",
        summary = "Two ways to check membership — which one is faster for large data?",
        prompt = "Which lookup is faster for large n?",
        code = """
            # Option A
            if x in my_list:   ...

            # Option B
            if x in my_set:    ...
        """.trimIndent(),
        options = listOf("Option B (set lookup is O(1))", "Option A (list is simpler)", "They are identical", "Option A for short lists, B for long"),
        answerIndex = 0,
        explanation = "A set stores items in a hash table, so membership checks are O(1) on average. List lookup is O(n)."
    ),

    Problem(
        id = "complexity_medium_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Nested loops",
        summary = "How many times does the inner statement run?",
        prompt = "How many times does `total += 1` execute?",
        code = """
            total = 0
            for i in range(4):
                for j in range(4):
                    total += 1
        """.trimIndent(),
        options = listOf("16", "8", "4", "12"),
        answerIndex = 0,
        explanation = "Each of the 4 outer iterations runs the inner loop 4 times: 4 × 4 = 16."
    ),

    Problem(
        id = "complexity_medium_2",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Halving loop",
        summary = "How many times does this loop body run for n = 16?",
        prompt = "How many iterations for n = 16?",
        code = """
            n = 16
            count = 0
            while n > 1:
                n //= 2
                count += 1
        """.trimIndent(),
        options = listOf("4", "8", "16", "15"),
        answerIndex = 0,
        explanation = "16 → 8 → 4 → 2 → 1: four halvings, so count ends at 4. This is O(log n) behaviour."
    ),

    Problem(
        id = "complexity_hard_1",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.HARD,
        title = "Append vs insert",
        summary = "Which list operation is cheaper at scale?",
        prompt = "For a list of n items, which is O(1) on average?",
        code = """
            # Option A — add to the end
            lst.append(value)

            # Option B — add at the front
            lst.insert(0, value)
        """.trimIndent(),
        options = listOf("Option A — append is O(1) amortized", "Option B — prepend is O(1)", "Both are O(1)", "Both are O(n)"),
        answerIndex = 0,
        explanation = "`append` is amortized O(1) because Python lists grow by doubling. `insert(0, value)` shifts every existing element right, which is O(n)."
    ),

    // ── TRACE_VAR ─────────────────────────────────────────────────────────────

    Problem(
        id = "trace_easy_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Track x",
        summary = "What is x after the reassignment on line 3?",
        prompt = "What is the value of `x` after line 3 runs?",
        code = """
            x = 10       # line 1
            x = x + 5   # line 2
            x = x * 2   # line 3
        """.trimIndent(),
        options = listOf("30", "20", "25", "15"),
        answerIndex = 0,
        explanation = "After line 2, x = 15. After line 3, x = 15 × 2 = 30."
    ),

    Problem(
        id = "trace_easy_2",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.EASY,
        title = "Counter mid-loop",
        summary = "What is `count` after the second iteration?",
        prompt = "What is `count` after the loop runs twice?",
        code = """
            count = 0
            for i in range(5):
                count += i
        """.trimIndent(),
        options = listOf("1", "2", "3", "0"),
        answerIndex = 0,
        explanation = "Iteration 1: count = 0 + 0 = 0. Iteration 2: count = 0 + 1 = 1."
    ),

    Problem(
        id = "trace_medium_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "List after pop",
        summary = "What does `items` look like after the pop call?",
        prompt = "What is the value of `items` after line 3?",
        code = """
            items = [10, 20, 30, 40]  # line 1
            items.append(50)           # line 2
            items.pop(1)               # line 3
        """.trimIndent(),
        options = listOf("[10, 30, 40, 50]", "[10, 20, 30, 40]", "[20, 30, 40, 50]", "[10, 30, 40]"),
        answerIndex = 0,
        explanation = "After append: [10,20,30,40,50]. `pop(1)` removes index 1 (value 20), leaving [10,30,40,50]."
    ),

    Problem(
        id = "trace_medium_2",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Flag in a loop",
        summary = "Track when `found` changes.",
        prompt = "What is `found` after the loop finishes?",
        code = """
            values = [3, 7, 2, 9]
            found = False
            for v in values:
                if v > 8:
                    found = True
        """.trimIndent(),
        options = listOf("True", "False", "9", "None"),
        answerIndex = 0,
        explanation = "When v = 9, the condition v > 8 is True, so `found` becomes True and stays True."
    ),

    Problem(
        id = "trace_hard_1",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.HARD,
        title = "Nested scope",
        summary = "A closure captures a variable — trace its value.",
        prompt = "What does `result` equal after calling `make_adder(3)(4)`?",
        code = """
            def make_adder(x):
                def add(y):
                    return x + y
                return add

            result = make_adder(3)(4)
        """.trimIndent(),
        options = listOf("7", "12", "3", "4"),
        answerIndex = 0,
        explanation = "`make_adder(3)` returns a closure where x = 3. Calling it with 4 returns 3 + 4 = 7."
    ),

    // ── MATCH_OUTPUT ──────────────────────────────────────────────────────────

    Problem(
        id = "match_easy_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: 6",
        summary = "Which snippet prints exactly 6?",
        prompt = "Which code produces the output `6`?",
        code = "",
        options = listOf(
            "print(2 * 3)",
            "print(2 + 3)",
            "print(6 - 1)",
            "print(3 ** 2)"
        ),
        answerIndex = 0,
        explanation = "`2 * 3` equals 6. The other options produce 5, 5, and 9."
    ),

    Problem(
        id = "match_easy_2",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Output: [1, 2, 3]",
        summary = "Which snippet produces that exact list output?",
        prompt = "Which code prints `[1, 2, 3]`?",
        code = "",
        options = listOf(
            "print(list(range(1, 4)))",
            "print(list(range(3)))",
            "print([0, 1, 2, 3])",
            "print(list(range(1, 3)))"
        ),
        answerIndex = 0,
        explanation = "`range(1, 4)` generates 1, 2, 3. `range(3)` gives 0–2, and `range(1,3)` gives 1–2."
    ),

    Problem(
        id = "match_medium_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: {'a': 1}",
        summary = "Which snippet builds that exact dictionary?",
        prompt = "Which code results in `{'a': 1}` being printed?",
        code = "",
        options = listOf(
            "d = {}; d['a'] = 1; print(d)",
            "d = {'a': 0}; d['a'] += 2; print(d)",
            "d = {'b': 1}; print(d)",
            "d = {'a': 1, 'b': 2}; print(d)"
        ),
        answerIndex = 0,
        explanation = "Only the first snippet creates a dict with exactly one key `'a'` mapped to `1`."
    ),

    Problem(
        id = "match_medium_2",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: HELLO",
        summary = "Which snippet prints the word in all caps?",
        prompt = "Which code prints `HELLO`?",
        code = "",
        options = listOf(
            "print('hello'.upper())",
            "print('hello'.capitalize())",
            "print('HELLO'.lower())",
            "print(str.upper)"
        ),
        answerIndex = 0,
        explanation = "`.upper()` converts all characters to uppercase. `.capitalize()` only uppercases the first letter."
    ),

    Problem(
        id = "match_hard_1",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Output: [0, 1, 4, 9]",
        summary = "Which expression produces that list of squares?",
        prompt = "Which code produces `[0, 1, 4, 9]`?",
        code = "",
        options = listOf(
            "print([x**2 for x in range(4)])",
            "print([x*2 for x in range(4)])",
            "print([x**2 for x in range(1, 4)])",
            "print(list(map(lambda x: x+x, range(4))))"
        ),
        answerIndex = 0,
        explanation = "`[x**2 for x in range(4)]` squares 0, 1, 2, 3 to get [0, 1, 4, 9]. The others produce different results."
    )
)
