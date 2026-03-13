# App Module Developer Guide

This module contains the primary Android application code for ReadCode.

## Structure
- `src/main/java/com/example/readcode/MainActivity.kt`: Activity entry point, Compose navigation state, and screen rendering logic.
- `src/main/java/com/example/readcode/ProblemModels.kt`: Shared enums and data models (`ProblemType`, `Difficulty`, `Language`, `Problem`, `ScreenState`).
- `src/main/java/com/example/readcode/ProblemSeedData.kt`: Aggregates the core inline seed list with batch lists imported from `com.example.readcode.problems`.
- `src/main/java/com/example/readcode/problems/`: Seed-data batch files grouped by learner, junior, hard, and workflow-generated content, including easy student expansion batches through `ProblemSeedDataEasyStudents59.kt`, medium junior expansion batches through `ProblemSeedDataMediumJunior58.kt`, and senior-level hard expansion batches through `ProblemSeedDataHard62.kt`.
- `src/main/java/com/example/readcode/ui/theme/`: Contains Compose Material theme definitions and typography setup.
- `src/main/res/`: Standard Android resources (icons, strings).

## Development Guidelines
- **Problem Data**: Keep the core seed list in `ProblemSeedData.kt`. Put batch expansions in `com.example.readcode.problems` with clearly named exported lists that are concatenated into `allProblems`.
- **Difficulty Bar**: Easy problems should fit learners, medium problems should require junior-developer-level code reading, and hard problems should be unlikely to be answered correctly by a junior developer. Hard questions may cover senior-level runtime and language behavior, algorithm-ordering drills, complexity analysis, and standard-library API knowledge.
- **Medium Fill-in-the-Blank Problems**: Keep medium fill-in-the-blank questions focused on code-reading judgment such as state changes, scope, mutation, or data-flow effects rather than single-keyword recall.
- **UI Architecture**: Uses in-memory state and Compose for rendering. Keep domain/data definitions out of `MainActivity.kt` and use dedicated files in `com.example.readcode`.
- **Difficulty Styling**: Difficulty-to-color mapping is a UI concern handled in `MainActivity.kt` via a local `Difficulty.accentColor` mapping.
- **Validation**: Prefer static checks over full Gradle builds during rapid iterations, as full builds are not the default workflow for verification.
