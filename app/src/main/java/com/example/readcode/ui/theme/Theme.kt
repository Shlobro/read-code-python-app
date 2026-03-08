package com.example.readcode.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = InkBlue,
    secondary = SteelBlue,
    tertiary = MintAccent,
    background = Midnight,
    surface = Slate,
    surfaceVariant = Color(0xFF1A3550),
    primaryContainer = Color(0xFF1E4873),
    secondaryContainer = Color(0xFF243C55),
    onPrimary = Color.White,
    onSecondary = Color(0xFF08111C),
    onTertiary = Color(0xFF041411),
    onBackground = Mist,
    onSurface = Mist,
    onSurfaceVariant = WarmCloud,
    outline = SteelBlue
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF005FB8),
    secondary = Color(0xFF42698B),
    tertiary = Color(0xFF006B5E),
    background = Mist,
    surface = Color.White,
    surfaceVariant = SoftPanel,
    primaryContainer = Color(0xFFD6E9FF),
    secondaryContainer = Color(0xFFD9E6F3),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Midnight,
    onSurface = Midnight,
    onSurfaceVariant = Slate,
    outline = Color(0xFF7294B5)
)

@Composable
fun ReadCodeTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
