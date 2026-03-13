# ReadCode Problems Package Guide

This package contains seed-data batch files that are imported into `ProblemSeedData.kt` to build `allProblems`.

## Structure
- `ProblemSeedDataLearner1.kt`: Starter-track batches for students and junior developers (`easyProblemsStudents1`, `mediumProblemsJunior1`).
- `ProblemSeedDataEasyStudents.kt`, `ProblemSeedDataEasyStudents2.kt` through `ProblemSeedDataEasyStudents64.kt`: Additional easy learner/student batches (`easyProblemsStudents`, `easyProblemsStudents2` through `easyProblemsStudents64`).
- `ProblemSeedDataMediumJunior2.kt` through `ProblemSeedDataMediumJunior63.kt`: Additional medium junior-developer batches (`mediumProblemsJunior2` through `mediumProblemsJunior63`). Note: some individual problems within these batches are marked `Difficulty.HARD` when the question relies on language-internal gotchas (e.g., mutable default arguments, late-binding closures, hash equality) rather than ordinary junior-level reasoning.
- `ProblemSeedDataHard4.kt` through `ProblemSeedDataHard67.kt`: Hard-difficulty senior-level batches.
- `ProblemSeedDataGenerated1.kt`: Mixed-difficulty workflow-generated expansion batch (`generatedProblems1`).
- `ProblemSeedDataNewTypes1.kt`: First batch for the four new problem types — `ORDER_STEPS`, `COMPLEXITY`, `TRACE_VAR`, `MATCH_OUTPUT` — covering easy, medium, and hard difficulties.

## Development Guidelines
- Keep each file focused on a coherent batch so the aggregator imports remain easy to scan.
- Export top-level lists with clear names and import them into `ProblemSeedData.kt` rather than duplicating aggregation logic here.
- Keep IDs unique across all batch files by checking the full package rather than assuming the file name guarantees an unused suffix. Multiple-choice types require exactly 4 options. `ORDER_STEPS` may use any number of lines; the count is not fixed.
- Hard batch ID convention: within `ProblemSeedDataHardN.kt`, `FIND_BUG`, `OUTPUT`, `PURPOSE`, and `FILL_BLANK` problems carry the suffix `_N+1` while `ORDER_STEPS`, `COMPLEXITY`, `TRACE_VAR`, and `MATCH_OUTPUT` problems carry the suffix `_N`. This matches the convention established in batches 4 and above.
- Match the difficulty bar used across the app: easy for learners, medium for junior-level reasoning, hard for senior developers. Hard problems include senior-level runtime and language behavior (descriptor binding, MRO, generator protocol, weak references, etc.) as well as algorithm-ordering drills (`ORDER_STEPS`), complexity analysis (`COMPLEXITY`), and standard library API knowledge (`FILL_BLANK`). Not every hard problem needs to test runtime internals; the hard label means the question is unlikely to be answered correctly by a junior developer.
- Easy learner batches should feel appropriate for students early in a degree program: predictable runtime behavior, direct prompts, and answer sets whose correct choice is not signaled by being consistently longer than the distractors.
- Medium junior batches should feel appropriate for a junior developer with a degree: routine collection handling, slicing, dictionary/list operations, loop reasoning, and standard complexity judgment without leaning on obscure Python internals.
- Across multiple-choice categories, vary both answer length and correct-option position so the correct answer is not guessable from wording size alone.
- For `MATCH_OUTPUT` problems: use `code = ""` when the expected output is short enough to embed in the prompt/title (e.g., `` `6` `` or `` `[1, 2, 3]` ``). Use `code = "<expected output>"` when the expected output is multi-line or needs a formatted code block to be readable (e.g., multiple lines of printed output). The UI renders any non-blank `code` as a code block above the answer choices.
