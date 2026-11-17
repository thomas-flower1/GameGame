package com.example.project

import android.content.res.Configuration
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class GameManager(var state: GameState, var configuration: Configuration) {
    // instance variables
    val screenHeight: Dp
    val screenWidth: Dp


    init {
        // Get the width and the height
        screenHeight = configuration.screenHeightDp.dp
        screenWidth = configuration.screenWidthDp.dp

    }
}