# ReadCode Package Developer Guide

This directory contains the main source code for the ReadCode app.

## Structure
- `MainActivity.kt`: Sole activity entry point. Owns top-level screen state (including ordering state for `ORDER_STEPS`), completion state, and Compose screen flow. UI helper composables (`GlassCard`, `NeonGradientButton`, `NeonBackHeader`, `NeonBadge`) are `internal` so they can be used from sibling files.
- `ProblemScreenComposables.kt`: All composables for the problem-solving screen — `ProblemScreen`, `CodeBlock`, `OrderStepsInteraction`, `ResultCard`, `AnswerChoice`, `CodeAnswerChoice`. Extracted to keep `MainActivity.kt` under 1000 lines.
- `AppColors.kt`: Shared `internal` color constants (`NeonCyan`, `NeonPurple`, etc.) used across `MainActivity.kt` and `ProblemScreenComposables.kt`.
- `ProblemModels.kt`: Declares `ProblemType`, `Difficulty`, `Language`, `Problem`, and `ScreenState`. `Problem` includes an optional `correctOrder: List<Int>?` field used by `ORDER_STEPS` problems.
- `ProblemSeedData.kt`: Declares `allProblems` as the concatenation of the base inline seed list plus imported batch lists. Keep this file as the aggregator and core seed bank rather than a catch-all for new additions.
- `problems/`: Batch seed-data package for learner, junior, hard, and workflow-generated additions. Its exported lists are imported into `ProblemSeedData.kt`, including the senior-level hard batches through `ProblemSeedDataHard14.kt`.
- `ui/theme/`: Contains Compose Material theme definitions and typography setup.

## Problem Types
There are 8 problem types in `ProblemType`:
- `FIND_BUG`, `OUTPUT`, `PURPOSE`, `FILL_BLANK` — classic multiple-choice types.
- `ORDER_STEPS` — tap-to-order UI. The `options` list holds the lines in author-defined order; the UI randomizes display order at runtime. `correctOrder` holds the correct source sequence as indices into `options`. The `code` field should be blank for this type.
- `COMPLEXITY` — multiple-choice: how many times does this run, or which is faster?
- `TRACE_VAR` — multiple-choice: what is the value of a variable at a specific point?
- `MATCH_OUTPUT` — multiple-choice: given the output, pick the code that produces it. The `code` field should be blank for this type.

## Development Guidelines
- **Modifying Problems**: Keep IDs unique. Multiple-choice types (`FIND_BUG`, `OUTPUT`, `PURPOSE`, `FILL_BLANK`, `COMPLEXITY`, `TRACE_VAR`, `MATCH_OUTPUT`) use exactly 4 options. `ORDER_STEPS` may use any number of lines. Put new batch files under the `problems/` subpackage and import their exported lists into `allProblems`.
- **ORDER_STEPS problems**: Set `code = ""`. Populate `options` with the lines in any order you like (the UI randomizes display order at runtime anyway). Set `correctOrder` to the list of indices into `options` that form the correct source sequence. For example, if the correct order is options[2], options[0], options[1], write `correctOrder = listOf(2, 0, 1)`. `correctOrder` must be a full permutation of `options.indices` — the model validates this at construction time.
- **MATCH_OUTPUT problems**: Set `code = ""`, and put code snippets as the options.
- **Difficulty Expectations**: Easy problems should stay learner-friendly, medium problems should demand junior-level code-reading judgment, and hard problems should be unlikely to be answered correctly by a junior developer. Hard questions may cover senior-level runtime and language behavior, algorithm-ordering drills, complexity analysis, and standard-library API knowledge.
- **Code Size**: Keep each Kotlin code file under 1000 lines. Split by concern before files approach that limit.
- **UI Separation**: Keep UI-only tokens or mappings (for example, difficulty colors) in UI files rather than in `ProblemModels.kt`.
- **No Persistence**: Currently, problem completion is tracked in memory.
