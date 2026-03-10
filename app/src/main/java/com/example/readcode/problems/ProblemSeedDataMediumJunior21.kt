package com.example.readcode.problems

import com.example.readcode.Difficulty
import com.example.readcode.Language
import com.example.readcode.Problem
import com.example.readcode.ProblemType

val mediumProblemsJunior21 = listOf(
    Problem(
        id = "bug_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Wrong dictionary access",
        summary = "A loop reads the wrong key from each record.",
        prompt = "Why does this code fail for the given data?",
        code = """
            users = [
                {"name": "Ava", "score": 7},
                {"name": "Ben", "score": 9}
            ]

            for user in users:
                print(user["points"])
        """.trimIndent(),
        options = listOf(
            "Each dictionary has `score`, not `points`",
            "Dictionaries cannot be stored in a list",
            "The loop must use indexes instead of `for user in users`",
            "The `print` call should be outside the loop"
        ),
        answerIndex = 0,
        explanation = "Each dictionary uses the key `score`. Accessing `user[\"points\"]` raises a KeyError because that key is not present."
    ),
    Problem(
        id = "output_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Join after filtering",
        summary = "A loop collects only long words before joining them.",
        prompt = "What does this code print?",
        code = """
            words = ["go", "team", "up", "play"]
            kept = []

            for word in words:
                if len(word) > 2:
                    kept.append(word.upper())

            print("-".join(kept))
        """.trimIndent(),
        options = listOf(
            "TEAM-PLAY",
            "GO-UP",
            "team-play",
            "TEAMPLAY"
        ),
        answerIndex = 0,
        explanation = "Only `team` and `play` have length greater than 2. They are uppercased and joined with `-`, producing `TEAM-PLAY`."
    ),
    Problem(
        id = "purpose_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Track the best score",
        summary = "A loop keeps the current maximum value seen so far.",
        prompt = "What does this function do overall?",
        code = """
            def best_score(scores):
                best = scores[0]
                for score in scores[1:]:
                    if score > best:
                        best = score
                return best
        """.trimIndent(),
        options = listOf(
            "Returns the largest score in the list",
            "Returns the average score",
            "Sorts the list from lowest to highest",
            "Counts how many scores are above zero"
        ),
        answerIndex = 0,
        explanation = "The function starts with the first value and replaces `best` whenever it finds a larger score, so it returns the maximum."
    ),
    Problem(
        id = "fill_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "Alias vs copy mutation",
        summary = "Choosing assignment vs copying decides whether the original changes.",
        prompt = "Which choice fills the blank so that `original` is NOT modified after `backup.append(4)`?",
        code = """
            original = [1, 2, 3]
            backup = _____(original)
            backup.append(4)
            print(original)
        """.trimIndent(),
        options = listOf(
            "list",
            "original =",
            "id",
            "str"
        ),
        answerIndex = 0,
        explanation = "`list(original)` creates a shallow copy, so `backup` is a distinct object. Appending to `backup` leaves `original` unchanged, printing `[1, 2, 3]`. Any option that simply aliases the same list would let the append mutate `original` too."
    ),
    Problem(
        id = "order_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.ORDER_STEPS,
        difficulty = Difficulty.MEDIUM,
        title = "Count names by first letter",
        summary = "Arrange the lines to build a dictionary of name counts by starting letter.",
        prompt = "Tap the lines to arrange them in the correct source order.",
        code = "",
        options = listOf(
            "    first = name[0]",
            "counts = {}",
            "    counts[first] = counts.get(first, 0) + 1",
            "for name in names:",
            "names = [\"Ana\", \"Ari\", \"Bo\"]"
        ),
        answerIndex = 0,
        correctOrder = listOf(4, 1, 3, 0, 2),
        explanation = "The source list and result dictionary come first, then the loop, then computing `first`, then updating the count for that letter."
    ),
    Problem(
        id = "complexity_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.COMPLEXITY,
        difficulty = Difficulty.MEDIUM,
        title = "Linear search through a list",
        summary = "A loop may inspect each item once before stopping.",
        prompt = "What is the worst-case time complexity of this function?",
        code = """
            def contains_target(items, target):
                for item in items:
                    if item == target:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "O(n)",
            "O(1)",
            "O(log n)",
            "O(n^2)"
        ),
        answerIndex = 0,
        explanation = "In the worst case, the target is absent or at the end, so the loop checks every item once. That is linear time, O(n)."
    ),
    Problem(
        id = "trace_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.TRACE_VAR,
        difficulty = Difficulty.MEDIUM,
        title = "Dictionary value update",
        summary = "Track a value as the same key is updated inside a loop.",
        prompt = "What is the value of `counts[\"a\"]` after the loop finishes?",
        code = """
            counts = {"a": 1}
            for ch in "aba":
                counts[ch] = counts.get(ch, 0) + 1
        """.trimIndent(),
        options = listOf(
            "3",
            "2",
            "1",
            "4"
        ),
        answerIndex = 0,
        explanation = "Starting from `{\"a\": 1}`, the loop sees `a`, `b`, `a`. The `a` count becomes 2, then stays 2 during `b`, then becomes 3 on the final `a`."
    ),
    Problem(
        id = "match_medium_junior_21",
        language = Language.PYTHON,
        type = ProblemType.MATCH_OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Output: [2, 4, 6]",
        summary = "Which snippet doubles each number in a list?",
        prompt = "Which code prints `[2, 4, 6]`?",
        code = "",
        options = listOf(
            "nums = [1, 2, 3]\nprint([n * 2 for n in nums])",
            "nums = [1, 2, 3]\nprint([n + 1 for n in nums])",
            "nums = [1, 2, 3]\nprint(nums * 2)",
            "nums = [1, 2, 3]\nprint([n for n in nums if n % 2 == 0])"
        ),
        answerIndex = 0,
        explanation = "The first snippet multiplies each element by 2, producing `[2, 4, 6]`. The others produce different lists."
    )
)
