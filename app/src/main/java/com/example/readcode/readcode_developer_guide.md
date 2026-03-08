# ReadCode Package Developer Guide

This directory contains the main source code for the ReadCode app.

## Structure
- `MainActivity.kt`: Sole activity entry point. Owns top-level screen state, answer state, completion state, and Compose screen flow.
- `ProblemModels.kt`: Declares `ProblemType`, `Difficulty`, `Language`, `Problem`, and `ScreenState`.
- `ProblemSeedData.kt`: Declares `allProblems`, the hard-coded problem bank consumed by the UI.
- `ui/theme/`: Contains Compose Material theme definitions and typography setup.

## Development Guidelines
- **Modifying Problems**: Update `allProblems` in `ProblemSeedData.kt`. Keep IDs unique and preserve exactly 4 answer options per problem.
- **Code Size**: Keep each Kotlin code file under 1000 lines. Split by concern before files approach that limit.
- **Problem Model**: Each `Problem` requires an ID, language, type, difficulty, title, summary, prompt, code snippet, a list of 4 string options, an integer answer index, and a string explanation.
- **UI Separation**: Keep UI-only tokens or mappings (for example, difficulty colors) in UI files rather than in `ProblemModels.kt`.
- **No Persistence**: Currently, problem completion is tracked in memory. When a persistence layer is added in the future, it should integrate seamlessly with the existing problem models.
