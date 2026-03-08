# App Module Developer Guide

This module contains the primary Android application code for ReadCode.

## Structure
- `src/main/java/com/example/readcode/MainActivity.kt`: Activity entry point, Compose navigation state, and screen rendering logic.
- `src/main/java/com/example/readcode/ProblemModels.kt`: Shared enums and data models (`ProblemType`, `Difficulty`, `Language`, `Problem`, `ScreenState`).
- `src/main/java/com/example/readcode/ProblemSeedData.kt`: Seed problem list (`allProblems`) used by the app.
- `src/main/java/com/example/readcode/ui/theme/`: Contains Compose Material theme definitions and typography setup.
- `src/main/res/`: Standard Android resources (icons, strings).

## Development Guidelines
- **Problem Data**: Problems are stored in `ProblemSeedData.kt` as a hardcoded `List<Problem>`. Ensure each entry matches a `ProblemType`, `Difficulty`, and `Language`.
- **UI Architecture**: Uses in-memory state and Compose for rendering. Keep domain/data definitions out of `MainActivity.kt` and use dedicated files in `com.example.readcode`.
- **Difficulty Styling**: Difficulty-to-color mapping is a UI concern handled in `MainActivity.kt` via a local `Difficulty.accentColor` mapping.
- **Validation**: Prefer static checks over full Gradle builds during rapid iterations, as full builds are not the default workflow for verification.
