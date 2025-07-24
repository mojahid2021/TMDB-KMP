package org.mojahid.tmdb

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Copy
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.HospitalUser
import compose.icons.fontawesomeicons.solid.HouseUser
import compose.icons.fontawesomeicons.solid.Search
import compose.icons.fontawesomeicons.solid.User
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tmdb.composeapp.generated.resources.Home
import tmdb.composeapp.generated.resources.Profile
import tmdb.composeapp.generated.resources.Res
import tmdb.composeapp.generated.resources.Search

enum class Screen { Home, Search, Profile }

@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.Home) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            when (currentScreen) {
                Screen.Home -> HomeScreen()
                Screen.Search -> SearchScreen()
                Screen.Profile -> ProfileScreen()
            }
        }
        ModernBottomNavBar(currentScreen) { selected ->
            currentScreen = selected
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Search Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Profile Screen", style = MaterialTheme.typography.headlineMedium)
    }
}


@Composable
fun ModernBottomNavBar(selected: Screen, onSelect: (Screen) -> Unit) {
    Surface(
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(MaterialTheme.colorScheme.surface),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ModernNavItem(
                painter = painterResource(Res.drawable.Home),
                label = "Home",
                selected = selected == Screen.Home,
                onClick = { onSelect(Screen.Home) }
            )
            ModernNavItem(
                painter = painterResource(Res.drawable.Search),
                label = "Search",
                selected = selected == Screen.Search,
                onClick = { onSelect(Screen.Search) }
            )
            ModernNavItem(
                painter = painterResource(Res.drawable.Profile),
                label = "Profile",
                selected = selected == Screen.Profile,
                onClick = { onSelect(Screen.Profile) }
            )
        }
    }
}

@Composable
fun ModernNavItem(
    painter: Painter,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painter,
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = label,
            color = color,
            style = MaterialTheme.typography.labelSmall
        )
        if (selected) {
            Box(
                Modifier
                    .padding(top = 4.dp)
                    .height(3.dp)
                    .width(24.dp)
                    .background(MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
            )
        }
    }
}