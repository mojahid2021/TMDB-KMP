package org.mojahid.tmdb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(onStatusBarColorChange: (bg: androidx.compose.ui.graphics.Color, content: androidx.compose.ui.graphics.Color) -> Unit) {
    LaunchedEffect(onStatusBarColorChange) {
        onStatusBarColorChange(org.mojahid.tmdb.Theme.Color.White, org.mojahid.tmdb.Theme.Color.Black)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Screen", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
    }
}