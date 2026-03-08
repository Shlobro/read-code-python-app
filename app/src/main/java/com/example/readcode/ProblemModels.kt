package com.example.readcode

enum class ProblemType(val label: String, val subtitle: String, val icon: String) {
    FIND_BUG("Find the Bug", "Spot the broken line or logic error", "\uD83D\uDC1B"),
    OUTPUT("What Is the Output?", "Trace the Python code and predict the result", "\u26A1"),
    PURPOSE("What Does This Code Do?", "Read the code for intent", "\uD83D\uDD0D"),
    FILL_BLANK("Fill in the Blank", "Choose the missing Python piece", "\u270F\uFE0F")
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
    val language: Language,
    val type: ProblemType,
    val difficulty: Difficulty,
    val title: String,
    val summary: String,
    val prompt: String,
    val code: String,
    val options: List<String>,
    val answerIndex: Int,
    val explanation: String
)

sealed interface ScreenState {
    data object TypeMenu : ScreenState
    data class DifficultyMenu(val type: ProblemType) : ScreenState
    data class ProblemMenu(val type: ProblemType, val difficulty: Difficulty) : ScreenState
    data class SolveProblem(val problem: Problem, val type: ProblemType, val difficulty: Difficulty) : ScreenState
}
