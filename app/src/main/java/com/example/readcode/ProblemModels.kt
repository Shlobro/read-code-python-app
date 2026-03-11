package com.example.readcode

enum class ProblemType(val label: String, val subtitle: String, val icon: String) {
    FIND_BUG("Find the Bug", "Spot the broken line or logic error", "\uD83D\uDC1B"),
    OUTPUT("What Is the Output?", "Trace the Python code and predict the result", "\u26A1"),
    PURPOSE("What Does This Code Do?", "Read the code for intent", "\uD83D\uDD0D"),
    FILL_BLANK("Fill in the Blank", "Choose the missing Python piece", "\u270F\uFE0F"),
    ORDER_STEPS("Arrange the Code", "Tap lines of code to arrange them in the correct source order", "\uD83D\uDCCB"),
    COMPLEXITY("Complexity Check", "Estimate how many times the code runs or which is faster", "\uD83D\uDCC8"),
    TRACE_VAR("Variable Trace", "Track the value of a variable at a specific point", "\uD83D\uDD0E"),
    MATCH_OUTPUT("Match the Output", "Given the output, pick the code that produces it", "\uD83C\uDFAF")
}

enum class Difficulty(val label: String, val subtitle: String) {
    EASY("Easy", "Short snippets and direct logic"),
    MEDIUM("Medium", "More branches and data flow"),
    HARD("Hard", "Edge cases and trickier behavior")
}

enum class Language(val label: String) {
    PYTHON("Python")
}

data class Problem(
    val id: String,
    // Global sequential number assigned at aggregation time. Stable within allProblems ordering.
    val number: Int = 0,
    val language: Language,
    val type: ProblemType,
    val difficulty: Difficulty,
    val title: String,
    val summary: String,
    val prompt: String,
    val code: String,
    val options: List<String>,
    // Ignored for ORDER_STEPS; use correctOrder instead. Required and range-validated for all other types.
    val answerIndex: Int,
    val explanation: String,
    // ORDER_STEPS only: correct indices into `options` in source order. Null for all other types.
    val correctOrder: List<Int>? = null
) {
    init {
        if (type == ProblemType.ORDER_STEPS) {
            require(correctOrder != null) {
                "Problem '$id': ORDER_STEPS requires correctOrder to be non-null"
            }
            require(correctOrder.sorted() == options.indices.toList()) {
                "Problem '$id': correctOrder must be a full permutation of options indices"
            }
        } else {
            require(correctOrder == null) {
                "Problem '$id': correctOrder must be null for type $type"
            }
            require(answerIndex in options.indices) {
                "Problem '$id': answerIndex $answerIndex is out of range for ${options.size} options"
            }
        }
    }
}

sealed interface ScreenState {
    data object TypeMenu : ScreenState
    data class DifficultyMenu(val type: ProblemType) : ScreenState
    data class ProblemMenu(val type: ProblemType, val difficulty: Difficulty) : ScreenState
    data class SolveProblem(val problem: Problem, val type: ProblemType, val difficulty: Difficulty) : ScreenState
}
