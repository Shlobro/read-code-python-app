package com.example.readcode

import com.example.readcode.problems.easyProblemsStudents
import com.example.readcode.problems.easyProblemsStudents1
import com.example.readcode.problems.easyProblemsStudents2
import com.example.readcode.problems.easyProblemsStudents3
import com.example.readcode.problems.easyProblemsStudents4
import com.example.readcode.problems.easyProblemsStudents5
import com.example.readcode.problems.easyProblemsStudents6
import com.example.readcode.problems.easyProblemsStudents7
import com.example.readcode.problems.easyProblemsStudents8
import com.example.readcode.problems.easyProblemsStudents9
import com.example.readcode.problems.easyProblemsStudents10
import com.example.readcode.problems.easyProblemsStudents11
import com.example.readcode.problems.easyProblemsStudents12
import com.example.readcode.problems.easyProblemsStudents13
import com.example.readcode.problems.generatedProblems1
import com.example.readcode.problems.hardProblems4
import com.example.readcode.problems.hardProblems5
import com.example.readcode.problems.hardProblems6
import com.example.readcode.problems.hardProblems7
import com.example.readcode.problems.hardProblems8
import com.example.readcode.problems.hardProblems9
import com.example.readcode.problems.hardProblems10
import com.example.readcode.problems.hardProblems11
import com.example.readcode.problems.hardProblems12
import com.example.readcode.problems.hardProblems13
import com.example.readcode.problems.hardProblems14
import com.example.readcode.problems.hardProblems15
import com.example.readcode.problems.hardProblems16
import com.example.readcode.problems.hardProblems17
import com.example.readcode.problems.hardProblems18
import com.example.readcode.problems.mediumProblemsJunior1
import com.example.readcode.problems.mediumProblemsJunior2
import com.example.readcode.problems.mediumProblemsJunior3
import com.example.readcode.problems.mediumProblemsJunior4
import com.example.readcode.problems.mediumProblemsJunior5
import com.example.readcode.problems.mediumProblemsJunior6
import com.example.readcode.problems.mediumProblemsJunior7
import com.example.readcode.problems.mediumProblemsJunior8
import com.example.readcode.problems.mediumProblemsJunior9
import com.example.readcode.problems.mediumProblemsJunior10
import com.example.readcode.problems.mediumProblemsJunior11
import com.example.readcode.problems.mediumProblemsJunior12
import com.example.readcode.problems.mediumProblemsJunior13
import com.example.readcode.problems.mediumProblemsJunior14
import com.example.readcode.problems.newTypeProblems1

val allProblems = listOf(
    Problem(
        id = "bug_easy",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Counter reset",
        summary = "A running total never grows correctly.",
        prompt = "Which answer describes the real bug?",
        code = """
            total = 0
            for i in range(5):
                total = 1
                total += i
            print(total)
        """.trimIndent(),
        options = listOf(
            "`total = 1` resets the counter every loop",
            "`range(5)` should be `range(1, 5)`",
            "`print(total)` should be inside the loop",
            "There is no bug"
        ),
        answerIndex = 0,
        explanation = "The code overwrites the total on each loop pass instead of keeping the accumulated value."
    ),
    Problem(
        id = "bug_medium",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Average divisor",
        summary = "The sum is correct, but the average is not.",
        prompt = "What is the actual problem?",
        code = """
            scores = [10, 20, 30]
            total = 0
            for score in scores:
                total += score
            average = total / 2
            print(average)
        """.trimIndent(),
        options = listOf(
            "It divides by 2 instead of the number of scores",
            "`total` should start at 1",
            "The list must be sorted first",
            "The loop should start at index 1"
        ),
        answerIndex = 0,
        explanation = "An average must divide by the number of items, not a fixed value."
    ),
    Problem(
        id = "bug_hard",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Off-by-one index",
        summary = "The loop can go past the end of the list.",
        prompt = "Why can this code crash?",
        code = """
            names = ["Ana", "Ben", "Cy"]
            for i in range(len(names) + 1):
                print(names[i])
        """.trimIndent(),
        options = listOf(
            "The loop includes one index too many",
            "Lists cannot store strings",
            "`print` must be after the loop",
            "The list must be mutable"
        ),
        answerIndex = 0,
        explanation = "Valid indexes stop at `len(names) - 1`, but this loop also tries `len(names)`."
    ),
    Problem(
        id = "output_easy",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String builder",
        summary = "The loop appends digits into text.",
        prompt = "What is printed?",
        code = """
            text = ""
            for i in range(1, 4):
                text += str(i)
            print(text)
        """.trimIndent(),
        options = listOf("123", "6", "321", "111"),
        answerIndex = 0,
        explanation = "The loop appends 1, then 2, then 3, so the printed string is `123`."
    ),
    Problem(
        id = "output_medium",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "Nested condition",
        summary = "Both checks in the `if` statement succeed.",
        prompt = "What gets printed?",
        code = """
            x = 4
            y = 7
            if x > 2 and y < 10:
                print("A")
            else:
                print("B")
        """.trimIndent(),
        options = listOf("A", "B", "AB", "Nothing"),
        answerIndex = 0,
        explanation = "Both conditions are true, so Python prints `A`."
    ),
    Problem(
        id = "output_hard",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Reverse slice",
        summary = "The string is sliced using a negative step.",
        prompt = "What does this print?",
        code = """
            word = "python"
            print(word[::-1])
        """.trimIndent(),
        options = listOf("nohtyp", "python", "pyth", "Error"),
        answerIndex = 0,
        explanation = "`[::-1]` creates a reversed copy of the string."
    ),
    Problem(
        id = "purpose_easy",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Keep the evens",
        summary = "A list comprehension filters values.",
        prompt = "What does this code do overall?",
        code = """
            numbers = [1, 2, 3, 4, 5, 6]
            result = [n for n in numbers if n % 2 == 0]
            print(result)
        """.trimIndent(),
        options = listOf(
            "It keeps only even numbers from the list",
            "It doubles every number",
            "It sorts the list",
            "It removes the largest number"
        ),
        answerIndex = 0,
        explanation = "The list comprehension includes only values divisible by 2."
    ),
    Problem(
        id = "purpose_medium",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Frequency map",
        summary = "A dictionary tracks how often each letter appears.",
        prompt = "What is this code building?",
        code = """
            text = "banana"
            counts = {}
            for char in text:
                counts[char] = counts.get(char, 0) + 1
        """.trimIndent(),
        options = listOf(
            "A count of how many times each character appears",
            "A reversed version of the text",
            "A sorted list of characters",
            "A list of vowel positions"
        ),
        answerIndex = 0,
        explanation = "Each loop pass increases the count for the current character."
    ),
    Problem(
        id = "purpose_hard",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Early return search",
        summary = "The function stops as soon as a negative value is found.",
        prompt = "What does this function do overall?",
        code = """
            def has_negative(values):
                for value in values:
                    if value < 0:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "Checks whether the list contains at least one negative number",
            "Returns the smallest number in the list",
            "Counts negative numbers",
            "Removes negative values"
        ),
        answerIndex = 0,
        explanation = "It returns `True` on the first negative value and `False` only if none are found."
    ),
    Problem(
        id = "fill_easy",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Missing operator",
        summary = "One operator makes the expression print `True`.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            age = 16
            can_join = age __ 13
            print(can_join)
        """.trimIndent(),
        options = listOf(">=", "<", "==", "<="),
        answerIndex = 0,
        explanation = "`16 >= 13` evaluates to `True`."
    ),
    Problem(
        id = "fill_medium",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "While condition",
        summary = "The loop should run for 0, 1, 2, and 3.",
        prompt = "Which option fills the blank so this prints 0, 1, 2, 3?",
        code = """
            i = 0
            while i __ 3:
                print(i)
                i += 1
        """.trimIndent(),
        options = listOf("<=", ">=", "==", "!="),
        answerIndex = 0,
        explanation = "`<=` keeps the loop running while `i` is 0 through 3."
    ),
    Problem(
        id = "fill_hard",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Missing method",
        summary = "A string method is missing.",
        prompt = "Which method fills the blank so Python prints `HELLO`?",
        code = """
            word = "hello"
            print(word.__())
        """.trimIndent(),
        options = listOf("upper", "strip", "split", "lower"),
        answerIndex = 0,
        explanation = "`upper()` converts the string to uppercase."
    ),
    Problem(
        id = "bug_medium_2",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Mutable Default Argument",
        summary = "Appending to a list as a default argument.",
        prompt = "What's the bug in this function?",
        code = """
            def add_item(item, items=[]):
                items.append(item)
                return items
        """.trimIndent(),
        options = listOf(
            "The default list is shared across all calls without an explicit items argument",
            "`append()` doesn't return anything",
            "You cannot use lists as arguments",
            "The function name is invalid"
        ),
        answerIndex = 0,
        explanation = "Default arguments are evaluated once when the function is defined, causing all calls without `items` to share the same list."
    ),
    Problem(
        id = "output_medium_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary key override",
        summary = "Assigning values to identical keys.",
        prompt = "What does this code print?",
        code = """
            data = {"a": 1, "b": 2, "a": 3}
            print(data["a"])
        """.trimIndent(),
        options = listOf("3", "1", "Error", "[1, 3]"),
        answerIndex = 0,
        explanation = "Dictionaries cannot have duplicate keys. The second assignment to `\"a\"` overwrites the first."
    ),
    Problem(
        id = "purpose_medium_2",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Set intersection",
        summary = "Comparing two lists using set operations.",
        prompt = "What does this snippet produce?",
        code = """
            list1 = [1, 2, 3]
            list2 = [2, 3, 4]
            result = list(set(list1) & set(list2))
        """.trimIndent(),
        options = listOf(
            "A list of items found in both lists",
            "A combined list of all unique items",
            "A list of items found only in the first list",
            "It will throw an error"
        ),
        answerIndex = 0,
        explanation = "The `&` operator performs a set intersection, returning elements that exist in both sets."
    ),
    Problem(
        id = "fill_medium_2",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary get",
        summary = "Fetching a value safely.",
        prompt = "Fill the blank to safely get a value or return 0 if missing.",
        code = """
            scores = {"Alice": 10}
            bob_score = scores.__( "Bob", 0 )
            print(bob_score)
        """.trimIndent(),
        options = listOf("get", "fetch", "find", "pop"),
        answerIndex = 0,
        explanation = "The `get()` method returns the value for a key if it exists, otherwise it returns the provided default value."
    ),
    Problem(
        id = "bug_hard_2",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "List modification during iteration",
        summary = "Removing elements while looping.",
        prompt = "Why does this code fail to remove all even numbers?",
        code = """
            nums = [1, 2, 4, 5, 6]
            for num in nums:
                if num % 2 == 0:
                    nums.remove(num)
            print(nums)
        """.trimIndent(),
        options = listOf(
            "It skips elements when the list shrinks",
            "`.remove()` only removes the first occurrence",
            "`nums` is an immutable tuple",
            "The loop condition is incorrect"
        ),
        answerIndex = 0,
        explanation = "Modifying a list while iterating over it changes its size, causing the iterator to skip elements."
    ),
    Problem(
        id = "output_hard_2",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Generator expression",
        summary = "Evaluating a generator.",
        prompt = "What is the output of this code?",
        code = """
            gen = (x * 2 for x in range(3))
            print(list(gen))
            print(list(gen))
        """.trimIndent(),
        options = listOf(
            "[0, 2, 4]\n[0, 2, 4]",
            "[0, 2, 4]\n[]",
            "[]\n[0, 2, 4]",
            "An error occurs"
        ),
        answerIndex = 1,
        explanation = "A generator expression is exhausted after the first iteration, so the second call to `list()` returns an empty list."
    ),
    Problem(
        id = "purpose_hard_2",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Memoization decorator",
        summary = "Caching function results.",
        prompt = "What does this decorator do?",
        code = """
            def cache(func):
                memo = {}
                def wrapper(*args):
                    if args not in memo:
                        memo[args] = func(*args)
                    return memo[args]
                return wrapper
        """.trimIndent(),
        options = listOf(
            "It delays the execution of the function",
            "It stores return values to avoid redundant calls",
            "It converts the function into an asynchronous task",
            "It validates the arguments passed to the function"
        ),
        answerIndex = 1,
        explanation = "The decorator creates a closure that stores previous function calls in a dictionary, returning cached results for identical arguments."
    ),
    Problem(
        id = "fill_hard_2",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Context manager",
        summary = "Handling resources gracefully.",
        prompt = "Fill the blank to ensure the file is closed automatically.",
        code = """
            ___ open('data.txt', 'r') as file:
                content = file.read()
            print("Done")
        """.trimIndent(),
        options = listOf("using", "with", "open", "try"),
        answerIndex = 1,
        explanation = "The `with` statement in Python creates a context manager that ensures resources like files are properly cleaned up after use."
    ),
    Problem(
        id = "bug_easy_3",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Infinite Loop",
        summary = "The loop never ends.",
        prompt = "Why does this loop run forever?",
        code = """
            n = 5
            while n > 0:
                print(n)
        """.trimIndent(),
        options = listOf("n is not updated", "n starts too high", "while loops always run forever", "print is indented"),
        answerIndex = 0,
        explanation = "`n` is never changed inside the loop, so the condition `n > 0` remains true forever."
    ),
    Problem(
        id = "output_easy_3",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "List Length",
        summary = "Finding the length of a list.",
        prompt = "What does this code print?",
        code = """
            fruits = ["apple", "banana", "cherry"]
            print(len(fruits))
        """.trimIndent(),
        options = listOf("3", "2", "4", "apple"),
        answerIndex = 0,
        explanation = "`len()` returns the number of items in the list, which is 3."
    ),
    Problem(
        id = "purpose_easy_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Sum Function",
        summary = "Adding two parameters.",
        prompt = "What does this function do?",
        code = """
            def calc(a, b):
                return a + b
        """.trimIndent(),
        options = listOf("Returns `a + b`", "Subtracts two numbers", "Multiplies two numbers", "Returns the largest number"),
        answerIndex = 0,
        explanation = "The function returns the result of `a + b`. The `+` meaning depends on the argument types."
    ),
    Problem(
        id = "fill_easy_3",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Append to List",
        summary = "Adding an item to the end of a list.",
        prompt = "Which method adds an item to the list?",
        code = """
            items = [1, 2]
            items.___(3)
            print(items)
        """.trimIndent(),
        options = listOf("add", "insert", "append", "push"),
        answerIndex = 2,
        explanation = "The `append()` method adds a single item to the end of a list in Python."
    ),
    Problem(
        id = "bug_medium_3",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Modifying String",
        summary = "Trying to change a character in a string.",
        prompt = "Why does this code crash?",
        code = """
            text = "hello"
            text[0] = "H"
            print(text)
        """.trimIndent(),
        options = listOf("Strings are immutable in Python", "The index should be 1", "H must be lowercase", "text is a reserved keyword"),
        answerIndex = 0,
        explanation = "In Python, strings cannot be changed after they are created. You must create a new string instead."
    ),
    Problem(
        id = "output_medium_3",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "List multiplication",
        summary = "Multiplying a list by an integer.",
        prompt = "What does this code print?",
        code = """
            nums = [1, 2]
            print(nums * 3)
        """.trimIndent(),
        options = listOf("[1, 2, 1, 2, 1, 2]", "[3, 6]", "[[1, 2], [1, 2], [1, 2]]", "Error"),
        answerIndex = 0,
        explanation = "Multiplying a list by an integer repeats the elements of the list that many times."
    ),
    Problem(
        id = "purpose_medium_3",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary comprehension",
        summary = "Creating a dictionary from a list.",
        prompt = "What does this code do?",
        code = """
            words = ["apple", "bat", "car"]
            lengths = {w: len(w) for w in words}
        """.trimIndent(),
        options = listOf("Creates a dictionary mapping each word to its length", "Creates a list of word lengths", "Sorts the words by length", "Finds the longest word"),
        answerIndex = 0,
        explanation = "A dictionary comprehension iterates over the list, using the word as the key and its length as the value."
    ),
    Problem(
        id = "fill_medium_3",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Check if key exists",
        summary = "Checking for a key in a dictionary.",
        prompt = "Fill in the blank to check if 'age' is a key in the dictionary.",
        code = """
            user = {"name": "Alice", "age": 30}
            if "age" ___ user:
                print("Age is present")
        """.trimIndent(),
        options = listOf("in", "has", "exists", "=="),
        answerIndex = 0,
        explanation = "The `in` operator is used to check if a key exists within a dictionary."
    ),
) + hardProblems4 + hardProblems5 + hardProblems6 + hardProblems7 + hardProblems8 + hardProblems9 + hardProblems10 + hardProblems11 + hardProblems12 + hardProblems13 + hardProblems14 + hardProblems15 + hardProblems16 + hardProblems17 + hardProblems18 + easyProblemsStudents1 + easyProblemsStudents + easyProblemsStudents2 + easyProblemsStudents3 + easyProblemsStudents4 + easyProblemsStudents5 + easyProblemsStudents6 + easyProblemsStudents7 + easyProblemsStudents8 + easyProblemsStudents9 + mediumProblemsJunior1 + mediumProblemsJunior2 + mediumProblemsJunior3 + mediumProblemsJunior4 + mediumProblemsJunior5 + mediumProblemsJunior6 + mediumProblemsJunior7 + mediumProblemsJunior8 + mediumProblemsJunior9 + mediumProblemsJunior10 + mediumProblemsJunior11 + mediumProblemsJunior12 + mediumProblemsJunior13 + mediumProblemsJunior14 + generatedProblems1 + newTypeProblems1 + easyProblemsStudents10 + easyProblemsStudents11 + easyProblemsStudents12 + easyProblemsStudents13

