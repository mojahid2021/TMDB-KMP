package org.mojahid.tmdb

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.mojahid.tmdb.Theme.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var selectedItemId by remember { mutableStateOf("home") }
    // Status bar color state
    var statusBarBg by remember { mutableStateOf(Color.Black) }
    var statusBarContent by remember { mutableStateOf(Color.White) }

    val navItems = listOf(
        NavItem("home", Icons.Rounded.Home, "Home"),
        NavItem("search", Icons.Rounded.Search, "Search"),
        NavItem("profile", Icons.Rounded.Person, "Profile")
        // Custom status bar
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // No custom status bar Box, use only the system status bar
        // Content area shows the selected page
        Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
            when (selectedItemId) {
                "home" -> HomeScreen { bg, content ->
                    statusBarBg = bg
                    statusBarContent = content
                }
                "search" -> SearchScreen { bg, content ->
                    statusBarBg = bg
                    statusBarContent = content
                }
                "profile" -> ProfileScreen { bg, content ->
                    statusBarBg = bg
                    statusBarContent = content
                }
                else -> HomeScreen { bg, content ->
                    statusBarBg = bg
                    statusBarContent = content
                }
            }
        }
        // Bottom navigation bar
        CustomNavBar(
            items = navItems,
            selectedItemId = selectedItemId,
            onItemSelected = { selectedItemId = it }
        )
    }
}

data class NavItem(
    val id: String,              // unique id to identify item
    val icon: ImageVector,       // icon to display
    val label: String            // text label
)

@Composable
fun CustomNavBar(
    items: List<NavItem>,             // list of nav items
    selectedItemId: String,           // id of currently selected item
    onItemSelected: (String) -> Unit  // callback when user clicks
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                Color.White,
                RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,  // space items evenly
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            val isSelected = item.id == selectedItemId

            Column(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { onItemSelected(item.id) }
                    )
                    .padding(vertical = 6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = if (isSelected) Color.Accent else Color.Black
                )
                Text(
                    text = item.label,
                    color = if (isSelected) Color.Accent else Color.Black,
                    fontSize = 12.sp
                )
            }
        }
    }
}
