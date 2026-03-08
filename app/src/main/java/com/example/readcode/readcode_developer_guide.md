# ReadCode Package Developer Guide

This directory contains the main source code for the ReadCode app.

## Structure
- `MainActivity.kt`: Sole activity entry point. Owns top-level screen state, answer state, completion state, and Compose screen flow.
- `ProblemModels.kt`: Declares `ProblemType`, `Difficulty`, `Language`, `Problem`, and `ScreenState`.
- `ProblemSeedData.kt`: Declares `allProblems` as the concatenation of the base inline seed list plus imported batch lists. Keep this file as the aggregator and core seed bank rather than a catch-all for new additions.
- `problems/`: Batch seed-data package for learner, junior, hard, and workflow-generated additions. Its exported lists are imported into `ProblemSeedData.kt`.
- `ui/theme/`: Contains Compose Material theme definitions and typography setup.

## Development Guidelines
- **Modifying Problems**: Keep IDs unique and preserve exactly 4 answer options per problem. Put new batch files under the `problems/` subpackage and import their exported lists into `allProblems`.
- **Batch Layout**: Hard, learner, junior, and mixed workflow-generated additions can live in separate batch files. Prefer file names that broadly match the batch contents so the aggregator remains easy to scan.
- **Difficulty Expectations**: Easy problems should stay learner-friendly, medium problems should demand junior-level code-reading judgment, and hard problems should focus on senior-level language and runtime behavior.
- **Medium Fill-in-the-Blank Bar**: For medium fill-in-the-blank questions, prefer scenarios that require reasoning about scope, state, mutation, or collection behavior instead of pure syntax or API-name recall.
- **Code Size**: Keep each Kotlin code file under 1000 lines. Split by concern before files approach that limit.
- **Problem Model**: Each `Problem` requires an ID, language, type, difficulty, title, summary, prompt, code snippet, a list of 4 string options, an integer answer index, and a string explanation.
- **UI Separation**: Keep UI-only tokens or mappings (for example, difficulty colors) in UI files rather than in `ProblemModels.kt`.
- **No Persistence**: Currently, problem completion is tracked in memory. When a persistence layer is added in the future, it should integrate seamlessly with the existing problem models.
