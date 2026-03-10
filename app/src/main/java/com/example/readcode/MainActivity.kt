
package com.example.readcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readcode.ui.theme.ReadCodeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReadCodeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent) {
                    ReadCodeApp()
                }
            }
        }
    }
}

private val GlowBlue = Color(0xFF1A3A6E)

private val Difficulty.accentColor: Color
    get() = when (this) {
        Difficulty.EASY -> NeonGreen
        Difficulty.MEDIUM -> NeonOrange
        Difficulty.HARD -> NeonPink
    }

data class Particle(val x: Float, val y: Float, val color: Color, val size: Float, val angle: Float, val speed: Float)

@Composable
private fun ConfettiOverlay(visible: Boolean) {
    val particles = remember {
        List(40) {
            Particle(
                x = Random.nextFloat(),
                y = Random.nextFloat() * 0.4f,
                color = listOf(NeonCyan, NeonPurple, NeonGreen, NeonPink, NeonOrange, Color(0xFFFFFF00))[it % 6],
                size = Random.nextFloat() * 10f + 6f,
                angle = Random.nextFloat() * 360f,
                speed = Random.nextFloat() * 0.6f + 0.3f
            )
        }
    }
    val progress = remember { Animatable(0f) }
    LaunchedEffect(visible) {
        if (visible) {
            progress.snapTo(0f)
            progress.animateTo(1f, animationSpec = tween(1800, easing = LinearEasing))
        }
    }
    if (visible && progress.value < 1f) {
        Box(modifier = Modifier.fillMaxSize()) {
            particles.forEach { p ->
                val yOff = (p.y + progress.value * p.speed * 1.5f).coerceAtMost(1.2f)
                val alpha = (1f - progress.value * 1.2f).coerceIn(0f, 1f)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            translationX = p.x * size.width
                            translationY = yOff * size.height
                            rotationZ = p.angle + progress.value * 360f
                        }
                        .alpha(alpha)
                ) {
                    Box(
                        modifier = Modifier
                            .size(p.size.dp)
                            .background(p.color, RoundedCornerShape(2.dp))
                    )
                }
            }
        }
    }
}

@Composable
private fun ReadCodeApp() {
    val defaultLanguage = Language.PYTHON
    val completionState = remember { mutableStateMapOf<String, Boolean>() }
    var screenState by remember { mutableStateOf<ScreenState>(ScreenState.TypeMenu) }
    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }
    var revealResult by remember { mutableStateOf(false) }
    var lastAnswerCorrect by remember { mutableStateOf(false) }
    var showConfetti by remember { mutableStateOf(false) }
    var orderedIndices by remember { mutableStateOf<List<Int>>(emptyList()) }
    var poolIndices by remember { mutableStateOf<List<Int>>(emptyList()) }
    var shuffledOptionIndices by remember { mutableStateOf<List<Int>>(emptyList()) }

    fun problemsFor(type: ProblemType, difficulty: Difficulty): List<Problem> {
        return allProblems.filter {
            it.type == type && it.difficulty == difficulty && it.language == defaultLanguage
        }
    }

    fun openProblem(problem: Problem, type: ProblemType, difficulty: Difficulty) {
        selectedAnswerIndex = null
        revealResult = false
        lastAnswerCorrect = false
        showConfetti = false
        orderedIndices = emptyList()
        poolIndices = if (problem.type == ProblemType.ORDER_STEPS) {
            problem.options.indices.toList().shuffled()
        } else {
            emptyList()
        }
        shuffledOptionIndices = if (problem.type != ProblemType.ORDER_STEPS) {
            problem.options.indices.toList().shuffled()
        } else {
            emptyList()
        }
        screenState = ScreenState.SolveProblem(problem, type, difficulty)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Transparent) { innerPadding ->
            AppBackdrop(modifier = Modifier.padding(innerPadding)) {
                AnimatedContent(
                    targetState = screenState,
                    label = "screen",
                    transitionSpec = {
                        (fadeIn(tween(300)) + slideInVertically { it / 12 }) togetherWith
                                (fadeOut(tween(200)) + slideOutVertically { -it / 12 })
                    }
                ) { screen ->
                    when (screen) {
                        ScreenState.TypeMenu -> TypeMenuScreen(
                            defaultLanguage = defaultLanguage,
                            onTypeSelected = { screenState = ScreenState.DifficultyMenu(it) }
                        )

                        is ScreenState.DifficultyMenu -> DifficultyMenuScreen(
                            type = screen.type,
                            onBack = { screenState = ScreenState.TypeMenu },
                            onDifficultySelected = { screenState = ScreenState.ProblemMenu(screen.type, it) }
                        )

                        is ScreenState.ProblemMenu -> ProblemMenuScreen(
                            type = screen.type,
                            difficulty = screen.difficulty,
                            problems = problemsFor(screen.type, screen.difficulty),
                            completionState = completionState,
                            onBack = { screenState = ScreenState.DifficultyMenu(screen.type) },
                            onProblemSelected = { openProblem(it, screen.type, screen.difficulty) },
                            onRandomSelected = {
                                problemsFor(screen.type, screen.difficulty).randomOrNull(Random.Default)?.let {
                                    openProblem(it, screen.type, screen.difficulty)
                                }
                            }
                        )

                        is ScreenState.SolveProblem -> ProblemScreen(
                            problem = screen.problem,
                            selectedAnswerIndex = selectedAnswerIndex,
                            revealResult = revealResult,
                            lastAnswerCorrect = lastAnswerCorrect,
                            orderedIndices = orderedIndices,
                            poolIndices = poolIndices,
                            shuffledOptionIndices = shuffledOptionIndices,
                            onBack = { screenState = ScreenState.ProblemMenu(screen.type, screen.difficulty) },
                            onAnswerSelected = { if (!revealResult) selectedAnswerIndex = it },
                            onTapFromPool = { idx ->
                                if (!revealResult) {
                                    poolIndices = poolIndices - idx
                                    orderedIndices = orderedIndices + idx
                                }
                            },
                            onTapFromOrdered = { idx ->
                                if (!revealResult) {
                                    orderedIndices = orderedIndices - idx
                                    poolIndices = poolIndices + idx
                                }
                            },
                            onSubmit = {
                                if (screen.problem.type == ProblemType.ORDER_STEPS) {
                                    val correct = screen.problem.correctOrder
                                    lastAnswerCorrect = correct != null && orderedIndices == correct
                                } else {
                                    val selected = selectedAnswerIndex ?: return@ProblemScreen
                                    val originalIndex = shuffledOptionIndices.getOrElse(selected) { selected }
                                    lastAnswerCorrect = originalIndex == screen.problem.answerIndex
                                }
                                revealResult = true
                                if (lastAnswerCorrect) {
                                    completionState[screen.problem.id] = true
                                    showConfetti = true
                                } else {
                                    if (completionState[screen.problem.id] != true) {
                                        completionState[screen.problem.id] = false
                                    }
                                }
                            },
                            onRandom = {
                                val pool = problemsFor(screen.type, screen.difficulty)
                                val candidates = pool.filter { it.id != screen.problem.id }
                                val next = (if (candidates.isNotEmpty()) candidates else pool).randomOrNull(Random.Default)
                                if (next != null) openProblem(next, screen.type, screen.difficulty)
                            }
                        )
                    }
                }
            }
        }
        ConfettiOverlay(visible = showConfetti)
    }
}

@Composable
private fun AppBackdrop(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF060B14), Color(0xFF090F1E), Color(0xFF060B14))
                )
            )
            .statusBarsPadding()
            .padding(horizontal = 18.dp, vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(NeonCyan.copy(alpha = 0.06f), Color.Transparent)
                    )
                )
        )
        content()
    }
}

@Composable
private fun TypeMenuScreen(defaultLanguage: Language, onTypeSelected: (ProblemType) -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "glow")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.5f, targetValue = 1f, label = "glow",
        animationSpec = infiniteRepeatable(tween(2000, easing = FastOutSlowInEasing), RepeatMode.Reverse)
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp), contentPadding = PaddingValues(bottom = 32.dp)) {
        item {
            Column(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(
                    "READ",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    fontSize = 48.sp,
                    color = NeonCyan,
                    modifier = Modifier.graphicsLayer { alpha = glowAlpha }
                )
                Text(
                    "CODE",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    fontSize = 48.sp,
                    color = Color.White,
                    modifier = Modifier.offset(y = (-12).dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                NeonBadge(defaultLanguage.label, NeonPurple)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Level up your code reading skills. Choose a challenge type below.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.55f)
                )
            }
        }
        items(ProblemType.entries) { type ->
            TypeCard(type = type, onClick = { onTypeSelected(type) })
        }
    }
}

@Composable
private fun TypeCard(type: ProblemType, onClick: () -> Unit) {
    var pressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (pressed) 0.97f else 1f, spring(stiffness = Spring.StiffnessMediumLow), label = "scale")
    val borderAlpha by animateFloatAsState(if (pressed) 1f else 0.3f, tween(150), label = "border")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(CardBg, CardBgAlt)))
            .border(1.dp, NeonCyan.copy(alpha = borderAlpha), RoundedCornerShape(20.dp))
            .clickable {
                pressed = true
                onClick()
            }
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(type.icon, fontSize = 32.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(type.label, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(type.subtitle, style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.5f))
            }
            Text("›", fontSize = 24.sp, color = NeonCyan.copy(alpha = 0.7f))
        }
    }
}

@Composable
private fun DifficultyMenuScreen(
    type: ProblemType,
    onBack: () -> Unit,
    onDifficultySelected: (Difficulty) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp), contentPadding = PaddingValues(bottom = 32.dp)) {
        item {
            NeonBackHeader(
                overline = "${type.icon}  ${type.label}",
                title = "Choose Difficulty",
                body = "How hard do you want it?",
                onBack = onBack
            )
        }
        items(Difficulty.entries) { difficulty ->
            DifficultyCard(difficulty = difficulty, onClick = { onDifficultySelected(difficulty) })
        }
    }
}

@Composable
private fun DifficultyCard(difficulty: Difficulty, onClick: () -> Unit) {
    val diffColor = difficulty.accentColor
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(CardBg, CardBgAlt)))
            .border(1.dp, diffColor.copy(alpha = 0.4f), RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(diffColor.copy(alpha = 0.15f), CircleShape)
                    .border(1.5.dp, diffColor.copy(alpha = 0.6f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    when (difficulty) { Difficulty.EASY -> "1"; Difficulty.MEDIUM -> "2"; Difficulty.HARD -> "3" },
                    fontWeight = FontWeight.Black, fontSize = 18.sp, color = diffColor
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(difficulty.label, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = diffColor)
                Spacer(modifier = Modifier.height(4.dp))
                Text(difficulty.subtitle, style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.5f))
            }
            Text("›", fontSize = 24.sp, color = diffColor.copy(alpha = 0.7f))
        }
    }
}

@Composable
private fun ProblemMenuScreen(
    type: ProblemType,
    difficulty: Difficulty,
    problems: List<Problem>,
    completionState: Map<String, Boolean>,
    onBack: () -> Unit,
    onProblemSelected: (Problem) -> Unit,
    onRandomSelected: () -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp), contentPadding = PaddingValues(bottom = 32.dp)) {
        item {
            NeonBackHeader(
                overline = "${type.icon}  ${type.label}  ·  ${difficulty.label}",
                title = "Choose a Problem",
                body = "Pick a challenge or go random.",
                onBack = onBack
            )
        }
        item {
            NeonGradientButton(
                text = "⚡  Random Challenge",
                gradient = Brush.horizontalGradient(listOf(NeonPurple, NeonCyan)),
                onClick = onRandomSelected
            )
        }
        items(problems) { problem ->
            ProblemRow(problem = problem, completionStatus = completionState[problem.id], onClick = { onProblemSelected(problem) })
        }
    }
}

@Composable
internal fun GlassCard(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(CardBg, CardBgAlt)))
            .border(1.dp, NeonCyan.copy(alpha = 0.18f), RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        content()
    }
}

@Composable
internal fun NeonGradientButton(
    text: String,
    gradient: Brush,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    val scale by animateFloatAsState(if (enabled) 1f else 0.97f, spring(), label = "btnscale")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .height(54.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(if (enabled) gradient else Brush.horizontalGradient(listOf(Color(0xFF111D30), Color(0xFF111D30))))
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            fontWeight = FontWeight.Bold,
            color = if (enabled) Color.White else Color.White.copy(alpha = 0.3f),
            fontSize = 16.sp
        )
    }
}

@Composable
internal fun NeonBackHeader(overline: String, title: String, body: String, onBack: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .clickable(onClick = onBack)
                .padding(vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("‹", fontSize = 20.sp, color = NeonCyan)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Back", color = NeonCyan, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
        }
        Text(overline, color = Color.White.copy(alpha = 0.38f), style = MaterialTheme.typography.labelMedium, letterSpacing = 1.sp)
        Text(title, style = MaterialTheme.typography.headlineSmall, color = Color.White, fontWeight = FontWeight.Black)
        Text(body, style = MaterialTheme.typography.bodyMedium, color = Color.White.copy(alpha = 0.55f))
    }
}

@Composable
internal fun NeonBadge(text: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color.copy(alpha = 0.15f), RoundedCornerShape(50))
            .border(1.dp, color.copy(alpha = 0.5f), RoundedCornerShape(50))
            .padding(horizontal = 14.dp, vertical = 6.dp)
    ) {
        Text(text, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = color)
    }
}

@Composable
private fun ProblemRow(problem: Problem, completionStatus: Boolean?, onClick: () -> Unit) {
    val accentColor = when (completionStatus) {
        true -> NeonGreen
        false -> NeonPink
        null -> Color.White.copy(alpha = 0.15f)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Brush.linearGradient(listOf(CardBg, CardBgAlt)))
            .border(1.dp, accentColor.copy(alpha = 0.4f), RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .padding(18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    NeonBadge(problem.language.label, NeonCyan)
                    if (completionStatus == true) {
                        Box(
                            modifier = Modifier
                                .background(NeonGreen.copy(alpha = 0.15f), RoundedCornerShape(50))
                                .border(1.dp, NeonGreen.copy(alpha = 0.5f), RoundedCornerShape(50))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text("✓ Done", style = MaterialTheme.typography.labelSmall, color = NeonGreen, fontWeight = FontWeight.Bold)
                        }
                    } else if (completionStatus == false) {
                        Box(
                            modifier = Modifier
                                .background(NeonPink.copy(alpha = 0.15f), RoundedCornerShape(50))
                                .border(1.dp, NeonPink.copy(alpha = 0.5f), RoundedCornerShape(50))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text("✗ Failed", style = MaterialTheme.typography.labelSmall, color = NeonPink, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(problem.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(problem.summary, style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.5f))
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text("›", fontSize = 22.sp, color = Color.White.copy(alpha = 0.3f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReadCodePreview() {
    ReadCodeTheme {
        ReadCodeApp()
    }
}
