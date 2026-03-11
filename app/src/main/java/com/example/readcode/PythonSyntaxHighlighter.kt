package com.example.readcode

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

// Python syntax highlight colors (dark IDE theme)
private val SynKeyword  = Color(0xFFCC99FF)  // purple  – def, if, for, return …
private val SynBuiltin  = Color(0xFF80DFFF)  // cyan    – print, len, range …
private val SynString   = Color(0xFFFFD580)  // yellow  – "…" / '…' / """…"""
private val SynComment  = Color(0xFF6A9F6A)  // muted green – # …
private val SynNumber   = Color(0xFFFF9E64)  // orange  – 42, 3.14
private val SynOperator = Color(0xFFFF79C6)  // pink    – + - * / = == …
private val SynDefault  = Color(0xFFE2EDFF)  // plain text

private val KEYWORDS = setOf(
    "False", "None", "True", "and", "as", "assert", "async", "await",
    "break", "class", "continue", "def", "del", "elif", "else", "except",
    "finally", "for", "from", "global", "if", "import", "in", "is",
    "lambda", "nonlocal", "not", "or", "pass", "raise", "return",
    "try", "while", "with", "yield"
)

private val BUILTINS = setOf(
    "abs", "all", "any", "bin", "bool", "breakpoint", "bytearray", "bytes",
    "callable", "chr", "compile", "complex", "delattr", "dict", "dir",
    "divmod", "enumerate", "eval", "exec", "filter", "float", "format",
    "frozenset", "getattr", "globals", "hasattr", "hash", "help", "hex",
    "id", "input", "int", "isinstance", "issubclass", "iter", "len",
    "list", "locals", "map", "max", "memoryview", "min", "next",
    "object", "oct", "open", "ord", "pow", "print", "property",
    "range", "repr", "reversed", "round", "set", "setattr", "slice",
    "sorted", "staticmethod", "str", "sum", "super", "tuple", "type",
    "vars", "zip"
)

private val OPERATOR_CHARS = setOf(
    '+', '-', '*', '/', '%', '=', '<', '>', '!', '&', '|', '^', '~', '@', ':'
)

/**
 * Tokenises [code] and returns an [AnnotatedString] with Python-IDE-style
 * syntax colouring.  Works purely on text; no real parser needed for the
 * token categories used here.
 */
internal fun highlightPython(code: String): AnnotatedString = buildAnnotatedString {
    var i = 0
    val len = code.length

    fun appendStyled(text: String, color: Color) {
        pushStyle(SpanStyle(color = color))
        append(text)
        pop()
    }

    fun appendDefaultChar(ch: Char) {
        pushStyle(SpanStyle(color = SynDefault))
        append(ch)
        pop()
    }

    while (i < len) {
        val ch = code[i]

        // ── Triple-quoted string ──────────────────────────────────────────
        if ((ch == '"' || ch == '\'') &&
            code.startsWith(ch.toString().repeat(3), i)
        ) {
            val q = ch.toString().repeat(3)
            val end = code.indexOf(q, i + 3)
            val close = if (end == -1) len else end + 3
            appendStyled(code.substring(i, close), SynString)
            i = close
            continue
        }

        // ── Single-quoted string (stops at un-escaped quote or newline) ──
        if (ch == '"' || ch == '\'') {
            val j = consumeShortString(code, i)
            appendStyled(code.substring(i, j), SynString)
            i = j
            continue
        }

        // ── Comment ──────────────────────────────────────────────────────
        if (ch == '#') {
            val eol = code.indexOf('\n', i).let { if (it == -1) len else it }
            appendStyled(code.substring(i, eol), SynComment)
            i = eol
            continue
        }

        // ── Number ───────────────────────────────────────────────────────
        if (ch.isDigit() || (ch == '.' && i + 1 < len && code[i + 1].isDigit())) {
            var j = i
            while (j < len && (code[j].isDigit() || code[j] == '.' || code[j] == '_' ||
                        code[j] == 'x' || code[j] == 'o' || code[j] == 'b' ||
                        code[j] in 'a'..'f' || code[j] in 'A'..'F' ||
                        code[j] == 'e' || code[j] == 'E' || code[j] == '+' || code[j] == '-' && j > i)
            ) j++
            appendStyled(code.substring(i, j), SynNumber)
            i = j
            continue
        }

        // ── Identifier / keyword / builtin ───────────────────────────────
        if (ch.isLetter() || ch == '_') {
            var j = i
            while (j < len && (code[j].isLetterOrDigit() || code[j] == '_')) j++
            val word = code.substring(i, j)
            val color = when (word) {
                in KEYWORDS -> SynKeyword
                in BUILTINS -> SynBuiltin
                else        -> SynDefault
            }
            appendStyled(word, color)
            i = j
            continue
        }

        // ── Operator characters ──────────────────────────────────────────
        if (ch in OPERATOR_CHARS) {
            appendStyled(ch.toString(), SynOperator)
            i++
            continue
        }

        // ── Anything else (parens, commas, spaces, newlines …) ──────────
        appendDefaultChar(ch)
        i++
    }
}

/** Consumes a single- or double-quoted string starting at [start], returns the index after closing quote. */
private fun consumeShortString(code: String, start: Int): Int {
    val q = code[start]
    var i = start + 1
    while (i < code.length) {
        val c = code[i]
        if (c == '\\') { i += 2; continue }
        if (c == '\n') break
        if (c == q) { i++; break }
        i++
    }
    return i
}
