# ReadCode Developer Guide

## Project Purpose
ReadCode is an Android app for practicing code-reading skills. Users move through menus of problem types and difficulties, then solve multiple-choice programming questions. The current content is Python-only, but the model layer already includes language as part of each problem.

## Root Structure
- `app/`: Android application module.
- `gradle/`: Gradle wrapper and version catalog files.
- `build.gradle.kts`: Top-level Gradle configuration.
- `settings.gradle.kts`: Module registration and repository setup.
- `gradle.properties`: Shared Gradle properties for the project.
- `AGENTS.md`, `GEMINI.md`, `CLAUDE.md`: Shared agent rule files for different assistants.
- `PRODUCT_DESCRIPTION.md`: Product-level intent and UX goals.
- `TODO.md`: Outstanding product and engineering work.

## App Module
- `app/build.gradle.kts`: Android module configuration and dependencies.
- `app/src/main/java/com/example/readcode/MainActivity.kt`: Activity entry point plus Compose app-state wiring and screen composables.
- `app/src/main/java/com/example/readcode/ProblemModels.kt`: Problem/domain enums and data models used by the UI flow.
- `app/src/main/java/com/example/readcode/ProblemSeedData.kt`: Hard-coded seed problem bank (`allProblems`).
- `app/src/main/java/com/example/readcode/ui/theme/`: Compose theme definitions for color, typography, and Material setup.
- `app/src/main/res/`: Android resources such as strings, launcher assets, and XML config.

## Architecture Notes
- The app currently uses in-memory state with Compose `remember`.
- Problem completion is tracked locally in memory; there is no persistence layer yet.
- Screen flow is menu-based rather than Navigation Compose based.
- Problem definitions are hard-coded seed data in `ProblemSeedData.kt`. A future content system can move these into a local database or remote source.

## Working Guidance
- Keep the user flow simple: problem type, difficulty, problem list, problem detail.
- Preserve the no-typing interaction model. Answers should remain tap-based multiple choice.
- Treat language as part of the problem model so the app can later support defaults and per-problem overrides without a structural rewrite.
- Keep `MainActivity.kt` focused on activity setup and screen-state orchestration; place domain/data concerns in dedicated files.
