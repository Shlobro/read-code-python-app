package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior7 = listOf(
    Problem(
        id = "bug_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Modifying Global Variable",
        summary = "A function tries to update a counter defined outside its scope.",
        prompt = "Why does this code crash when `increment()` is called?",
        code = """
            count = 0
            
            def increment():
                count += 1
                return count
                
            print(increment())
        """.trimIndent(),
        options = listOf(
            "It raises an UnboundLocalError because `count` is treated as a local variable but accessed before assignment.",
            "`count += 1` is not valid Python syntax; it should be `count = count + 1`.",
            "The `return` statement must be outside the function.",
            "It works perfectly and prints 1."
        ),
        answerIndex = 0,
        explanation = "In Python, assigning to a variable inside a function makes it local by default. Since `count += 1` reads `count` before assigning to it, it crashes. To fix it, add `global count` inside the function."
    ),
    Problem(
        id = "output_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List Slicing with Steps",
        summary = "Extracting elements from a list using start, stop, and step parameters.",
        prompt = "What does this code print?",
        code = """
            nums = [10, 20, 30, 40, 50]
            print(nums[1:4:2])
        """.trimIndent(),
        options = listOf(
            "[20, 40]",
            "[10, 30, 50]",
            "[20, 30, 40]",
            "[40, 20]"
        ),
        answerIndex = 0,
        explanation = "The slice `[1:4:2]` starts at index 1 (value 20), stops before index 4 (value 50), and takes every 2nd element, resulting in `[20, 40]`."
    ),
    Problem(
        id = "purpose_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Manual Maximum Search",
        summary = "Iterating through a list to keep track of a specific value.",
        prompt = "What does this function compute?",
        code = """
            def process(data):
                if not data:
                    return None
                m = data[0]
                for v in data:
                    if v > m:
                        m = v
                return m
        """.trimIndent(),
        options = listOf(
            "It finds the maximum value in the list.",
            "It sorts the list in descending order.",
            "It calculates the average of the list.",
            "It finds the minimum value in the list."
        ),
        answerIndex = 0,
        explanation = "The variable `m` is initialized to the first element and updated whenever a larger element is found, meaning it ultimately holds the maximum value."
    ),
    Problem(
        id = "fill_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Iterate with Index",
        summary = "Looping over a list while keeping track of the current index.",
        prompt = "Fill in the blank to print each index and its corresponding letter.",
        code = """
            letters = ['a', 'b', 'c']
            for i, char in ______(letters):
                print(i, char)
        """.trimIndent(),
        options = listOf(
            "enumerate",
            "range",
            "zip",
            "list"
        ),
        answerIndex = 0,
        explanation = "`enumerate()` is a built-in function that yields pairs containing a count (from zero) and a value yielded by the iterable argument."
    ),
    Problem(
        id = "order_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Safe File Reading",
        summary = "Arrange the lines to safely open a file and print its contents line by line.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "with open('data.txt') as f:",
            "    for line in f:",
            "        print(line.strip())"
        ),
        answerIndex = 0,
        correctOrder = listOf(0, 1, 2),
        explanation = "First, use the `with` statement to safely open the file. Then, iterate over the file object `f`. Finally, print each stripped line."
    ),
    Problem(
        id = "complexity_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Lookup Loop",
        summary = "Analyze the time complexity of checking dictionary membership inside a loop.",
        prompt = "What is the overall time complexity of this function, where N is the length of `items`?",
        code = """
            def process(items, cache):
                for item in items:
                    if item in cache:
                        print(cache[item])
        """.trimIndent(),
        options = listOf(
            "O(N)",
            "O(N²)",
            "O(1)",
            "O(log N)"
        ),
        answerIndex = 0,
        explanation = "The loop runs N times. Inside the loop, checking if `item in cache` (a dictionary) and looking it up takes O(1) time on average. So the total complexity is O(N)."
    ),
    Problem(
        id = "trace_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary Frequency Count",
        summary = "Trace the state of a dictionary as it counts character frequencies.",
        prompt = "What is the value of `counts` after the loop completes?",
        code = """
            counts = {'a': 1}
            for char in 'ab':
                counts[char] = counts.get(char, 0) + 1
        """.trimIndent(),
        options = listOf(
            "{'a': 2, 'b': 1}",
            "{'a': 1, 'b': 1}",
            "{'a': 2, 'b': 2}",
            "{'a': 1, 'b': 0}"
        ),
        answerIndex = 0,
        explanation = "Initially `counts` is `{'a': 1}`. When `char` is 'a', it gets `1`, adds `1`, and updates 'a' to `2`. When `char` is 'b', it defaults to `0`, adds `1`, setting 'b' to `1`. The final dict is `{'a': 2, 'b': 1}`."
    ),
    Problem(
        id = "match_medium_junior_7",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Identify the list comprehension that generates a specific list of even numbers.",
        prompt = "Which code produces `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "print([x * 2 for x in [1, 2, 3]])",
            "print([x + 2 for x in [0, 1, 2]])",
            "print([x for x in range(6) if x % 2 == 0])",
            "print([x * 2 for x in range(1, 3)])"
        ),
        answerIndex = 0,
        explanation = "The list comprehension `[x * 2 for x in [1, 2, 3]]` iterates over 1, 2, and 3, multiplying each by 2 to produce `[2, 4, 6]`. The others produce `[2, 3, 4]`, `[0, 2, 4]`, and `[2, 4]` respectively."
    )
)
