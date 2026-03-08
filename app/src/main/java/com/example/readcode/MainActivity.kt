
package com.example.readcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.readcode.ui.theme.ReadCodeTheme
import kotlin.math.roundToInt
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

private enum class ProblemType(val label: String, val subtitle: String, val icon: String) {
    FIND_BUG("Find the Bug", "Spot the broken line or logic error", "🐛"),
    OUTPUT("What Is the Output?", "Trace the Python code and predict the result", "⚡"),
    PURPOSE("What Does This Code Do?", "Read the code for intent", "🔍"),
    FILL_BLANK("Fill in the Blank", "Choose the missing Python piece", "✏️")
}

private enum class Difficulty(val label: String, val subtitle: String, val color: Color) {
    EASY("Easy", "Short snippets and direct logic", Color(0xFF00E5A0)),
    MEDIUM("Medium", "More branches and data flow", Color(0xFFFFAA00)),
    HARD("Hard", "Edge cases and trickier behavior", Color(0xFFFF4D6D))
}

private enum class Language(val label: String) {
    PYTHON("Python")
}

private data class Problem(
    val id: String,
    val language: Language,
    val type: ProblemType,
    val difficulty: Difficulty,
    val title: String,
    val summary: String,
    val prompt: String,
    val code: String,
    val options: List<String>,
    val answerIndex: Int,
    val explanation: String
)

private sealed interface ScreenState {
    data object TypeMenu : ScreenState
    data class DifficultyMenu(val type: ProblemType) : ScreenState
    data class ProblemMenu(val type: ProblemType, val difficulty: Difficulty) : ScreenState
    data class SolveProblem(val problem: Problem, val type: ProblemType, val difficulty: Difficulty) : ScreenState
}

private val allProblems = listOf(
    Problem(
        id = "bug_easy",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.EASY,
        title = "Counter reset",
        summary = "A running total never grows correctly.",
        prompt = "Which answer describes the real bug?",
        code = """
            total = 0
            for i in range(5):
                total = 1
                total += i
            print(total)
        """.trimIndent(),
        options = listOf(
            "`total = 1` resets the counter every loop",
            "`range(5)` should be `range(1, 5)`",
            "`print(total)` should be inside the loop",
            "There is no bug"
        ),
        answerIndex = 0,
        explanation = "The code overwrites the total on each loop pass instead of keeping the accumulated value."
    ),
    Problem(
        id = "bug_medium",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.MEDIUM,
        title = "Average divisor",
        summary = "The sum is correct, but the average is not.",
        prompt = "What is the actual problem?",
        code = """
            scores = [10, 20, 30]
            total = 0
            for score in scores:
                total += score
            average = total / 2
            print(average)
        """.trimIndent(),
        options = listOf(
            "It divides by 2 instead of the number of scores",
            "`total` should start at 1",
            "The list must be sorted first",
            "The loop should start at index 1"
        ),
        answerIndex = 0,
        explanation = "An average must divide by the number of items, not a fixed value."
    ),
    Problem(
        id = "bug_hard",
        language = Language.PYTHON,
        type = ProblemType.FIND_BUG,
        difficulty = Difficulty.HARD,
        title = "Off-by-one index",
        summary = "The loop can go past the end of the list.",
        prompt = "Why can this code crash?",
        code = """
            names = ["Ana", "Ben", "Cy"]
            for i in range(len(names) + 1):
                print(names[i])
        """.trimIndent(),
        options = listOf(
            "The loop includes one index too many",
            "Lists cannot store strings",
            "`print` must be after the loop",
            "The list must be mutable"
        ),
        answerIndex = 0,
        explanation = "Valid indexes stop at `len(names) - 1`, but this loop also tries `len(names)`."
    ),
    Problem(
        id = "output_easy",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.EASY,
        title = "String builder",
        summary = "The loop appends digits into text.",
        prompt = "What is printed?",
        code = """
            text = ""
            for i in range(1, 4):
                text += str(i)
            print(text)
        """.trimIndent(),
        options = listOf("123", "6", "321", "111"),
        answerIndex = 0,
        explanation = "The loop appends 1, then 2, then 3, so the printed string is `123`."
    ),
    Problem(
        id = "output_medium",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.MEDIUM,
        title = "Nested condition",
        summary = "Both checks in the `if` statement succeed.",
        prompt = "What gets printed?",
        code = """
            x = 4
            y = 7
            if x > 2 and y < 10:
                print("A")
            else:
                print("B")
        """.trimIndent(),
        options = listOf("A", "B", "AB", "Nothing"),
        answerIndex = 0,
        explanation = "Both conditions are true, so Python prints `A`."
    ),
    Problem(
        id = "output_hard",
        language = Language.PYTHON,
        type = ProblemType.OUTPUT,
        difficulty = Difficulty.HARD,
        title = "Reverse slice",
        summary = "The string is sliced using a negative step.",
        prompt = "What does this print?",
        code = """
            word = "python"
            print(word[::-1])
        """.trimIndent(),
        options = listOf("nohtyp", "python", "pyth", "Error"),
        answerIndex = 0,
        explanation = "`[::-1]` creates a reversed copy of the string."
    ),
    Problem(
        id = "purpose_easy",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.EASY,
        title = "Keep the evens",
        summary = "A list comprehension filters values.",
        prompt = "What does this code do overall?",
        code = """
            numbers = [1, 2, 3, 4, 5, 6]
            result = [n for n in numbers if n % 2 == 0]
            print(result)
        """.trimIndent(),
        options = listOf(
            "It keeps only even numbers from the list",
            "It doubles every number",
            "It sorts the list",
            "It removes the largest number"
        ),
        answerIndex = 0,
        explanation = "The list comprehension includes only values divisible by 2."
    ),
    Problem(
        id = "purpose_medium",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.MEDIUM,
        title = "Frequency map",
        summary = "A dictionary tracks how often each letter appears.",
        prompt = "What is this code building?",
        code = """
            text = "banana"
            counts = {}
            for char in text:
                counts[char] = counts.get(char, 0) + 1
        """.trimIndent(),
        options = listOf(
            "A count of how many times each character appears",
            "A reversed version of the text",
            "A sorted list of characters",
            "A list of vowel positions"
        ),
        answerIndex = 0,
        explanation = "Each loop pass increases the count for the current character."
    ),
    Problem(
        id = "purpose_hard",
        language = Language.PYTHON,
        type = ProblemType.PURPOSE,
        difficulty = Difficulty.HARD,
        title = "Early return search",
        summary = "The function stops as soon as a negative value is found.",
        prompt = "What does this function do overall?",
        code = """
            def has_negative(values):
                for value in values:
                    if value < 0:
                        return True
                return False
        """.trimIndent(),
        options = listOf(
            "Checks whether the list contains at least one negative number",
            "Returns the smallest number in the list",
            "Counts negative numbers",
            "Removes negative values"
        ),
        answerIndex = 0,
        explanation = "It returns `True` on the first negative value and `False` only if none are found."
    ),
    Problem(
        id = "fill_easy",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.EASY,
        title = "Missing operator",
        summary = "One operator makes the expression print `True`.",
        prompt = "Which choice fills the blank correctly?",
        code = """
            age = 16
            can_join = age __ 13
            print(can_join)
        """.trimIndent(),
        options = listOf(">=", "<=", "==", "!="),
        answerIndex = 0,
        explanation = "`16 >= 13` evaluates to `True`."
    ),
    Problem(
        id = "fill_medium",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.MEDIUM,
        title = "While condition",
        summary = "The loop should run for 0, 1, 2, and 3.",
        prompt = "Which option fills the blank so this prints 0, 1, 2, 3?",
        code = """
            i = 0
            while i __ 3:
                print(i)
                i += 1
        """.trimIndent(),
        options = listOf("<=", ">=", "==", "!="),
        answerIndex = 0,
        explanation = "`<=` keeps the loop running while `i` is 0 through 3."
    ),
    Problem(
        id = "fill_hard",
        language = Language.PYTHON,
        type = ProblemType.FILL_BLANK,
        difficulty = Difficulty.HARD,
        title = "Missing method",
        summary = "A string method is missing.",
        prompt = "Which method fills the blank so Python prints `HELLO`?",
        code = """
            word = "hello"
            print(word.__())
        """.trimIndent(),
        options = listOf("upper", "strip", "split", "lower"),
        answerIndex = 0,
        explanation = "`upper()` converts the string to uppercase."
    )
)

// Neon color palette
private val NeonCyan = Color(0xFF00F5FF)
private val NeonPurple = Color(0xFFBB00FF)
private val NeonGreen = Color(0xFF00E5A0)
private val NeonPink = Color(0xFFFF2D78)
private val NeonOrange = Color(0xFFFF8C00)
private val DeepBg = Color(0xFF060B14)
private val CardBg = Color(0xFF0D1626)
private val CardBgAlt = Color(0xFF111D30)
private val GlowBlue = Color(0xFF1A3A6E)

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
                            defaultLanguage = defaultLanguage,
                            onBack = { screenState = ScreenState.TypeMenu },
                            onDifficultySelected = { screenState = ScreenState.ProblemMenu(screen.type, it) }
                        )

                        is ScreenState.ProblemMenu -> ProblemMenuScreen(
                            type = screen.type,
                            difficulty = screen.difficulty,
                            defaultLanguage = defaultLanguage,
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
                            onBack = { screenState = ScreenState.ProblemMenu(screen.type, screen.difficulty) },
                            onAnswerSelected = { if (!revealResult) selectedAnswerIndex = it },
                            onSubmit = {
                                val selected = selectedAnswerIndex ?: return@ProblemScreen
                                lastAnswerCorrect = selected == screen.problem.answerIndex
                                revealResult = true
                                if (lastAnswerCorrect) {
                                    completionState[screen.problem.id] = true
                                    showConfetti = true
                                }
                            },
                            onRetry = {
                                selectedAnswerIndex = null
                                revealResult = false
                                lastAnswerCorrect = false
                                showConfetti = false
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
        // Subtle ambient glow top
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
            .background(
                Brush.linearGradient(listOf(CardBg, CardBgAlt))
            )
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
    defaultLanguage: Language,
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
    val diffColor = difficulty.color
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
    defaultLanguage: Language,
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
            ProblemRow(problem = problem, completed = completionState[problem.id] == true, onClick = { onProblemSelected(problem) })
        }
    }
}

@Composable
private fun ProblemScreen(
    problem: Problem,
    selectedAnswerIndex: Int?,
    revealResult: Boolean,
    lastAnswerCorrect: Boolean,
    onBack: () -> Unit,
    onAnswerSelected: (Int) -> Unit,
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
                    Spacer(modifier = Modifier.height(16.dp))
                    // Code block
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFF020810))
                            .border(1.dp, NeonCyan.copy(alpha = 0.2f), RoundedCornerShape(14.dp))
                    ) {
                        Column {
                            // Code title bar
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
                                text = problem.code,
                                color = Color(0xFFE2EDFF),
                                fontFamily = FontFamily.Monospace,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
        items(problem.options.indices.toList()) { index ->
            AnswerChoice(
                text = problem.options[index],
                index = index,
                selected = selectedAnswerIndex == index,
                revealResult = revealResult,
                isCorrect = index == problem.answerIndex,
                isWrongSelection = revealResult && selectedAnswerIndex == index && index != problem.answerIndex,
                onClick = { onAnswerSelected(index) }
            )
        }
        item {
            AnimatedVisibility(
                visible = !revealResult,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                NeonGradientButton(
                    text = "Check Answer",
                    gradient = if (selectedAnswerIndex != null)
                        Brush.horizontalGradient(listOf(NeonCyan, NeonPurple))
                    else
                        Brush.horizontalGradient(listOf(Color(0xFF1A2A3A), Color(0xFF1A2A3A))),
                    onClick = onSubmit,
                    enabled = selectedAnswerIndex != null
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
private fun ResultCard(correct: Boolean, explanation: String, onRetry: () -> Unit, onRandom: () -> Unit, onBack: () -> Unit) {
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
private fun AnswerChoice(
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

    val borderColor by animateColorAsState(
        when {
            revealResult && isCorrect -> NeonGreen
            isWrongSelection -> NeonPink
            selected -> NeonCyan
            else -> Color.White.copy(alpha = 0.1f)
        }, tween(300), label = "border"
    )
    val bgColor by animateColorAsState(
        when {
            revealResult && isCorrect -> Color(0xFF003320)
            isWrongSelection -> Color(0xFF2A0010)
            selected -> Color(0xFF0D2040)
            else -> CardBg
        }, tween(300), label = "bg"
    )
    val textColor by animateColorAsState(
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
private fun GlassCard(content: @Composable () -> Unit) {
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
private fun NeonGradientButton(
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
private fun NeonBackHeader(overline: String, title: String, body: String, onBack: () -> Unit) {
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
private fun NeonBadge(text: String, color: Color) {
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
private fun ProblemRow(problem: Problem, completed: Boolean, onClick: () -> Unit) {
    val accentColor = if (completed) NeonGreen else Color.White.copy(alpha = 0.15f)
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
                    if (completed) {
                        Box(
                            modifier = Modifier
                                .background(NeonGreen.copy(alpha = 0.15f), RoundedCornerShape(50))
                                .border(1.dp, NeonGreen.copy(alpha = 0.5f), RoundedCornerShape(50))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text("✓ Done", style = MaterialTheme.typography.labelSmall, color = NeonGreen, fontWeight = FontWeight.Bold)
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
