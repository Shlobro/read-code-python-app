# ReadCode Agent Rules

- Always start by reading `readcode_developer_guide.md`, `TODO.md`, and `PRODUCT_DESCRIPTION.md`, then look for any other relevant `.md` files for the task.
- Always read the `.md` file in every folder you work in. If a folder does not have one, create a single developer-facing guide for that folder. Use a folder-specific name such as `app_developer_guide.md` or `theme_developer_guide.md`. These files must stay under 500 lines.
- When changing files, update the guide for that folder and any ancestor-folder guides if a new developer would need that information to work effectively. These guides explain the current structure and behavior; they do not document change history.
- No generated or edited code file may exceed 1000 lines. If a file would go over 1000 lines, split it into multiple files.
- When creating a new file, choose its folder deliberately. Create a new folder when it improves separation of concerns.
- Each non-root folder should contain at most one `.md` file. The root may contain multiple `.md` files. Do not create summary-only or visualization-only markdown files.
- Do not mention legacy behavior or recent changes in developer guide files. They should describe how the project works now.
- Keep system temp directories such as `%TEMP%/` ignored in `.gitignore`.
- Always ask whether the commit message is acceptable before creating a commit.
- Ignore `.md` files when counting how many files are in a folder. Keep each folder under 10 code files when practical; split folders before they become crowded.
- For Android verification, prefer static checks and user-requested validation. Do not rely on full project builds as a default workflow unless the user explicitly wants build verification.
