# ReadCode Problems Package Guide

This package contains seed-data batch files that are imported into `ProblemSeedData.kt` to build `allProblems`.

## Structure
- `ProblemSeedDataLearner1.kt`: Starter-track batches for students and junior developers (`easyProblemsStudents1`, `mediumProblemsJunior1`).
- `ProblemSeedDataEasyStudents.kt`: Additional easy learner/student batch (`easyProblemsStudents`).
- `ProblemSeedDataMediumJunior2.kt`: Additional medium junior-developer batch (`mediumProblemsJunior2`).
- `ProblemSeedDataHard4.kt`, `ProblemSeedDataHard5.kt`, `ProblemSeedDataHard6.kt`: Hard-difficulty senior-level batches.
- `ProblemSeedDataGenerated1.kt`: Mixed-difficulty workflow-generated expansion batch (`generatedProblems1`).

## Development Guidelines
- Keep each file focused on a coherent batch so the aggregator imports remain easy to scan.
- Export top-level lists with clear names and import them into `ProblemSeedData.kt` rather than duplicating aggregation logic here.
- Keep IDs unique across all batch files and preserve exactly 4 answer options per problem.
- Match the difficulty bar used across the app: easy for learners, medium for junior-level reasoning, hard for senior-level runtime and language behavior.
