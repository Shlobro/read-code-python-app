# ReadCode Developer Guide

## Project Purpose
ReadCode is an Android app for practicing code-reading skills. Users move through menus of problem types and difficulties, then solve tap-based programming challenges. Most types are multiple choice; the Arrange the Code type uses a tap-to-order interaction. The current content is Python-only, but the model layer already includes language as part of each problem.

## Root Structure
- `app/`: Android application module.
- `add-new-problems-auto-workflow.json`: Workflow that adds problems, runs review/fix passes, and uses repo-wide staging before explicit manual commit review.
- `gradle/`: Gradle wrapper and version catalog files.
- `build.gradle.kts`: Top-level Gradle configuration.
- `settings.gradle.kts`: Module registration and repository setup.
- `gradle.properties`: Shared Gradle properties for the project.
- `AGENTS.md`, `GEMINI.md`, `CLAUDE.md`: Shared agent rule files for different assistants.
- `PRODUCT_DESCRIPTION.md`: Product-level intent and UX goals.
- `TODO.md`: Outstanding product and engineering work.

## App Module
- `app/build.gradle.kts`: Android module configuration and dependencies.
- `app/src/main/java/com/example/readcode/MainActivity.kt`: Activity entry point, Compose app-state wiring, menu screens, and shared UI helper composables.
- `app/src/main/java/com/example/readcode/ProblemScreenComposables.kt`: Problem-solving screen composables (ProblemScreen, CodeBlock, OrderStepsInteraction, ResultCard, AnswerChoice, CodeAnswerChoice).
- `app/src/main/java/com/example/readcode/AppColors.kt`: Shared internal color constants for the neon dark theme.
- `app/src/main/java/com/example/readcode/ProblemModels.kt`: Problem/domain enums and data models used by the UI flow. Includes 8 ProblemTypes and optional `correctOrder` field for ORDER_STEPS.
- `app/src/main/java/com/example/readcode/ProgressRepository.kt`: SharedPreferences-backed persistence for problem completion state. Tracks completed and attempted-but-failed IDs separately under prefs file `readcode_progress`.
- `app/src/main/java/com/example/readcode/ProblemSeedData.kt`: Aggregates the base inline seed list with imported batch lists into `allProblems`.
- `app/src/main/java/com/example/readcode/problems/`: Seed-data batch package for learner, junior, hard, and workflow-generated problem lists, including easy student batches through `ProblemSeedDataEasyStudents54.kt`, medium junior batches through `ProblemSeedDataMediumJunior53.kt`, and senior-level hard batches through `ProblemSeedDataHard57.kt`.
- `app/src/main/java/com/example/readcode/ui/theme/`: Compose theme definitions for color, typography, and Material setup.
- `app/src/main/res/`: Android resources such as strings, launcher assets, and XML config.

## Architecture Notes
- The app uses in-memory Compose state backed by `ProgressRepository` for persistence across restarts.
- Problem completion is stored in SharedPreferences (prefs file `readcode_progress`) via `ProgressRepository`, which tracks completed and attempted-but-failed problem IDs separately.
- Screen flow is menu-based rather than Navigation Compose based.
- Problem definitions are hard-coded seed data split across `ProblemSeedData*.kt` files and aggregated into `allProblems`. A future content system can move these into a local database or remote source.
- Each `Problem` has a `number` field (1-based integer) assigned at aggregation time in `ProblemSeedData.kt` via `mapIndexed`. Seed files leave `number` at its default of 0; only `allProblems` carries the real numbers. Numbers are global and stable within the `allProblems` ordering — adding new batches at the end preserves existing numbers. Users see the number as `#N` in the problem list and screen header; developers can use it to reference specific problems in bug reports.

## Working Guidance
- Keep the user flow simple: problem type, difficulty, problem list, problem detail.
- Preserve the no-typing interaction model. All answers are tap-based; most types are multiple choice, and new interaction styles (like tap-to-order) are acceptable when they suit the problem type.
- Treat language as part of the problem model so the app can later support defaults and per-problem overrides without a structural rewrite.
- Keep `MainActivity.kt` focused on activity setup and screen-state orchestration; place domain/data concerns in dedicated files.
- Keep `app/src/main/java/com/example/readcode/ProblemSeedData.kt` as the aggregator, and place batch-file expansion under the `com.example.readcode.problems` subpackage rather than crowding the package root.
- Keep automated content workflows from committing on their own. Repo-wide staging is currently the available workflow behavior, so commit creation should wait for explicit commit-message approval, and generation should begin only from a clean or otherwise isolated worktree.
- The automated content workflow now performs a preflight worktree check before generation starts. It should stop and leave `workflow-preflight.txt` with a blocking message if any tracked or untracked paths already exist, including leftover scratch artifacts such as `review.txt` or `fixes-made.txt`.
- The workflow's difficulty-placement validator runs before the first repo-wide `git add`, so it should inspect `git diff` plus directly inspected untracked files instead of relying on `git diff --cached`.
- The automated content workflow stages the repo before the first review pass and stages it again after the success-path scratch-file cleanup so the index matches the final accepted worktree. Automated reviewers and fixers should still inspect `git diff --cached` first, then `git diff` for follow-up edits inside the re-review loop, and inspect untracked files directly when `git status --short` reports them, excluding active workflow scratch artifacts such as `review.txt` and `fixes-made.txt`.
- The re-review loop clears `review.txt` before the post-fix review pass, and the success path deletes `review.txt` and `fixes-made.txt` before the final restage used for manual commit review.
