package com.example.readcode

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
internal fun ProblemScreen(
    problem: Problem,
    selectedAnswerIndex: Int?,
    revealResult: Boolean,
    lastAnswerCorrect: Boolean,
    orderedIndices: List<Int>,
    poolIndices: List<Int>,
    shuffledOptionIndices: List<Int> = emptyList(),
    onBack: () -> Unit,
    onAnswerSelected: (Int) -> Unit,
    onTapFromPool: (Int) -> Unit,
    onTapFromOrdered: (Int) -> Unit,
    onSubmit: () -> Unit,
    onRetry: () -> Unit,
    onRandom: () -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp), contentPadding = PaddingValues(bottom = 32.dp)) {
        item {
            NeonBackHeader(
                overline = "${problem.language.label}  ·  ${problem.type.label}  ·  ${problem.difficulty.label}",
                title = problem.title,
                body = problem.summary,
                onBack = onBack
            )
        }
        item {
            GlassCard {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).background(NeonCyan, CircleShape))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("PROMPT", style = MaterialTheme.typography.labelSmall, color = NeonCyan, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(problem.prompt, style = MaterialTheme.typography.bodyLarge, color = Color.White.copy(alpha = 0.9f))
                    if (problem.code.isNotBlank()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        CodeBlock(code = problem.code)
                    }
                }
            }
        }
        if (problem.type == ProblemType.ORDER_STEPS) {
            item {
                OrderStepsInteraction(
                    options = problem.options,
                    orderedIndices = orderedIndices,
                    poolIndices = poolIndices,
                    revealResult = revealResult,
                    correctOrder = problem.correctOrder ?: emptyList(),
                    onTapFromPool = onTapFromPool,
                    onTapFromOrdered = onTapFromOrdered
                )
            }
        } else if (problem.type == ProblemType.MATCH_OUTPUT) {
            val displayCorrectIndex = shuffledOptionIndices.indexOf(problem.answerIndex).takeIf { it >= 0 } ?: problem.answerIndex
            items(problem.options.indices.toList()) { index ->
                val originalIndex = shuffledOptionIndices.getOrElse(index) { index }
                CodeAnswerChoice(
                    code = problem.options[originalIndex],
                    index = index,
                    selected = selectedAnswerIndex == index,
                    revealResult = revealResult,
                    isCorrect = index == displayCorrectIndex,
                    isWrongSelection = revealResult && selectedAnswerIndex == index && index != displayCorrectIndex,
                    onClick = { onAnswerSelected(index) }
                )
            }
        } else {
            val displayCorrectIndex = shuffledOptionIndices.indexOf(problem.answerIndex).takeIf { it >= 0 } ?: problem.answerIndex
            items(problem.options.indices.toList()) { index ->
                val originalIndex = shuffledOptionIndices.getOrElse(index) { index }
                AnswerChoice(
                    text = problem.options[originalIndex],
                    index = index,
                    selected = selectedAnswerIndex == index,
                    revealResult = revealResult,
                    isCorrect = index == displayCorrectIndex,
                    isWrongSelection = revealResult && selectedAnswerIndex == index && index != displayCorrectIndex,
                    onClick = { onAnswerSelected(index) }
                )
            }
        }
        item {
            val submitEnabled = if (problem.type == ProblemType.ORDER_STEPS)
                poolIndices.isEmpty()
            else
                selectedAnswerIndex != null

            AnimatedVisibility(
                visible = !revealResult,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                NeonGradientButton(
                    text = "Check Answer",
                    gradient = if (submitEnabled)
                        Brush.horizontalGradient(listOf(NeonCyan, NeonPurple))
                    else
                        Brush.horizontalGradient(listOf(Color(0xFF1A2A3A), Color(0xFF1A2A3A))),
                    onClick = onSubmit,
                    enabled = submitEnabled
                )
            }

            AnimatedVisibility(
                visible = revealResult,
                enter = fadeIn(tween(400)) + slideInVertically { it / 3 },
                exit = fadeOut()
            ) {
                ResultCard(
                    correct = lastAnswerCorrect,
                    explanation = problem.explanation,
                    onRetry = onRetry,
                    onRandom = onRandom,
                    onBack = onBack
                )
            }
        }
    }
}

@Composable
internal fun CodeBlock(code: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF020810))
            .border(1.dp, NeonCyan.copy(alpha = 0.2f), RoundedCornerShape(14.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0A1628))
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(10.dp).background(Color(0xFFFF5F57), CircleShape))
                Spacer(modifier = Modifier.width(6.dp))
                Box(modifier = Modifier.size(10.dp).background(Color(0xFFFFBD2E), CircleShape))
                Spacer(modifier = Modifier.width(6.dp))
                Box(modifier = Modifier.size(10.dp).background(Color(0xFF28C840), CircleShape))
                Spacer(modifier = Modifier.width(12.dp))
                Text("python", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(alpha = 0.35f))
            }
            Text(
                text = code,
                color = Color(0xFFE2EDFF),
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
internal fun OrderStepsInteraction(
    options: List<String>,
    orderedIndices: List<Int>,
    poolIndices: List<Int>,
    revealResult: Boolean,
    correctOrder: List<Int>,
    onTapFromPool: (Int) -> Unit,
    onTapFromOrdered: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        GlassCard {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(6.dp).background(NeonPurple, CircleShape))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "YOUR ORDER",
                        style = MaterialTheme.typography.labelSmall,
                        color = NeonPurple,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                }
                if (orderedIndices.isEmpty()) {
                    Text(
                        "Tap lines below to place them here",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.3f)
                    )
                } else {
                    orderedIndices.forEachIndexed { position, optionIdx ->
                        val isCorrectPos = revealResult && correctOrder.getOrNull(position) == optionIdx
                        val isWrongPos = revealResult && correctOrder.getOrNull(position) != optionIdx
                        val borderColor = when {
                            isCorrectPos -> NeonGreen
                            isWrongPos -> NeonPink
                            else -> NeonPurple.copy(alpha = 0.5f)
                        }
                        val bgColor = when {
                            isCorrectPos -> Color(0xFF003320)
                            isWrongPos -> Color(0xFF2A0010)
                            else -> Color(0xFF1A0D30)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(bgColor)
                                .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                                .clickable { if (!revealResult) onTapFromOrdered(optionIdx) }
                                .padding(horizontal = 12.dp, vertical = 10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "${position + 1}",
                                    color = borderColor,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 13.sp,
                                    modifier = Modifier.width(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    options.getOrElse(optionIdx) { "" },
                                    color = if (revealResult && isCorrectPos) NeonGreen
                                            else if (revealResult && isWrongPos) NeonPink
                                            else Color.White,
                                    fontFamily = FontFamily.Monospace,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.weight(1f)
                                )
                                if (!revealResult) {
                                    Text("✕", color = NeonPurple.copy(alpha = 0.5f), fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }
                if (revealResult && orderedIndices.toList() != correctOrder) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).background(NeonGreen, CircleShape))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "CORRECT ORDER",
                            style = MaterialTheme.typography.labelSmall,
                            color = NeonGreen,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    correctOrder.forEachIndexed { position, optionIdx ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF003320))
                                .border(1.dp, NeonGreen.copy(alpha = 0.5f), RoundedCornerShape(10.dp))
                                .padding(horizontal = 12.dp, vertical = 10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "${position + 1}",
                                    color = NeonGreen,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 13.sp,
                                    modifier = Modifier.width(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    options.getOrElse(optionIdx) { "" },
                                    color = NeonGreen,
                                    fontFamily = FontFamily.Monospace,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }

        if (poolIndices.isNotEmpty()) {
            GlassCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).background(NeonOrange, CircleShape))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "AVAILABLE LINES",
                            style = MaterialTheme.typography.labelSmall,
                            color = NeonOrange,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                    }
                    poolIndices.forEach { optionIdx ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF1A1A0A))
                                .border(1.dp, NeonOrange.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                                .clickable { onTapFromPool(optionIdx) }
                                .padding(horizontal = 12.dp, vertical = 10.dp)
                        ) {
                            Text(
                                options.getOrElse(optionIdx) { "" },
                                color = Color.White.copy(alpha = 0.85f),
                                fontFamily = FontFamily.Monospace,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
internal fun ResultCard(
    correct: Boolean,
    explanation: String,
    onRetry: () -> Unit,
    onRandom: () -> Unit,
    onBack: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val borderAlpha by infiniteTransition.animateFloat(
        initialValue = 0.5f, targetValue = 1f, label = "pulse",
        animationSpec = infiniteRepeatable(tween(1000, easing = FastOutSlowInEasing), RepeatMode.Reverse)
    )
    val accentColor = if (correct) NeonGreen else NeonPink

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(
                    if (correct) listOf(Color(0xFF002218), Color(0xFF001A12))
                    else listOf(Color(0xFF1E0010), Color(0xFF160008))
                )
            )
            .border(1.5.dp, accentColor.copy(alpha = borderAlpha), RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(if (correct) "✓" else "✗", fontSize = 28.sp, color = accentColor)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    if (correct) "Correct!" else "Not quite",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Black,
                    color = accentColor
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                explanation,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFF1A2A40))
                        .border(1.dp, NeonCyan.copy(alpha = 0.3f), RoundedCornerShape(14.dp))
                        .clickable(onClick = onRetry)
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Retry", fontWeight = FontWeight.Bold, color = NeonCyan)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Brush.horizontalGradient(listOf(NeonPurple.copy(alpha = 0.7f), NeonCyan.copy(alpha = 0.7f))))
                        .clickable(onClick = onRandom)
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Random", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                "← Back to list",
                color = Color.White.copy(alpha = 0.4f),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .clickable(onClick = onBack)
                    .padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
internal fun AnswerChoice(
    text: String,
    index: Int,
    selected: Boolean,
    revealResult: Boolean,
    isCorrect: Boolean,
    isWrongSelection: Boolean,
    onClick: () -> Unit
) {
    val shakeAnim = remember { Animatable(0f) }
    LaunchedEffect(isWrongSelection) {
        if (isWrongSelection) {
            repeat(4) {
                shakeAnim.animateTo(if (it % 2 == 0) 12f else -12f, tween(60))
            }
            shakeAnim.animateTo(0f, tween(60))
        }
    }

    val borderColor by androidx.compose.animation.animateColorAsState(
        when {
            revealResult && isCorrect -> NeonGreen
            isWrongSelection -> NeonPink
            selected -> NeonCyan
            else -> Color.White.copy(alpha = 0.1f)
        }, tween(300), label = "border"
    )
    val bgColor by androidx.compose.animation.animateColorAsState(
        when {
            revealResult && isCorrect -> Color(0xFF003320)
            isWrongSelection -> Color(0xFF2A0010)
            selected -> Color(0xFF0D2040)
            else -> CardBg
        }, tween(300), label = "bg"
    )
    val textColor by androidx.compose.animation.animateColorAsState(
        when {
            revealResult && isCorrect -> NeonGreen
            isWrongSelection -> NeonPink
            selected -> Color.White
            else -> Color.White.copy(alpha = 0.7f)
        }, tween(300), label = "text"
    )

    val labels = listOf("A", "B", "C", "D")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset { IntOffset(shakeAnim.value.roundToInt(), 0) }
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
            .clickable { if (!revealResult) onClick() }
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(borderColor.copy(alpha = 0.2f), CircleShape)
                    .border(1.dp, borderColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when {
                        revealResult && isCorrect -> "✓"
                        isWrongSelection -> "✗"
                        else -> labels.getOrElse(index) { "" }
                    },
                    color = borderColor,
                    fontWeight = FontWeight.Black,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Text(text, style = MaterialTheme.typography.bodyMedium, color = textColor, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
internal fun CodeAnswerChoice(
    code: String,
    index: Int,
    selected: Boolean,
    revealResult: Boolean,
    isCorrect: Boolean,
    isWrongSelection: Boolean,
    onClick: () -> Unit
) {
    val shakeAnim = remember { Animatable(0f) }
    LaunchedEffect(isWrongSelection) {
        if (isWrongSelection) {
            repeat(4) {
                shakeAnim.animateTo(if (it % 2 == 0) 12f else -12f, tween(60))
            }
            shakeAnim.animateTo(0f, tween(60))
        }
    }

    val borderColor by androidx.compose.animation.animateColorAsState(
        when {
            revealResult && isCorrect -> NeonGreen
            isWrongSelection -> NeonPink
            selected -> NeonCyan
            else -> Color.White.copy(alpha = 0.1f)
        }, tween(300), label = "border"
    )
    val bgColor by androidx.compose.animation.animateColorAsState(
        when {
            revealResult && isCorrect -> Color(0xFF003320)
            isWrongSelection -> Color(0xFF2A0010)
            selected -> Color(0xFF0D2040)
            else -> Color(0xFF020810)
        }, tween(300), label = "bg"
    )

    val labels = listOf("A", "B", "C", "D")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset { IntOffset(shakeAnim.value.roundToInt(), 0) }
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
            .clickable { if (!revealResult) onClick() }
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(28.dp)
                    .background(borderColor.copy(alpha = 0.2f), CircleShape)
                    .border(1.dp, borderColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when {
                        revealResult && isCorrect -> "✓"
                        isWrongSelection -> "✗"
                        else -> labels.getOrElse(index) { "" }
                    },
                    color = borderColor,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp
                )
            }
            Text(
                text = code,
                color = when {
                    revealResult && isCorrect -> NeonGreen
                    isWrongSelection -> NeonPink
                    selected -> Color(0xFFE2EDFF)
                    else -> Color(0xFFE2EDFF).copy(alpha = 0.7f)
                },
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 14.dp, end = 12.dp, bottom = 14.dp)
            )
        }
    }
}
