package com.example.project

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.project.GameManager
import com.example.project.ui.theme.pixelOperator
import java.io.File
import kotlin.random.Random
import android.content.Context



@Composable
fun dialogue(gameManager: GameManager, text: String, delay_duration: Long){

    var currentString by remember {mutableStateOf("")}
    val verticalPadding = gameManager.screenHeight * 0.3f // have it so that the text prints 30% down from the top

    // This starts a new coroutine that runs in the background
    LaunchedEffect(text) {
        for((index, char) in text.withIndex()) {
            currentString = currentString + char
            delay(delay_duration)
        }
    }

    // Drawing the text to the screen
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = verticalPadding) // this is not included in the border now
                .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                .padding(16.dp)
                .padding(bottom = gameManager.screenHeight * 0.1f)
                .height(25.dp) // makes sure the border does not grow relative to the text growing

        ) {
            Text(
                fontFamily = pixelOperator,
                text=currentString
            )
        }
    }
}

fun read_random(context: Context, filename: String) : String {
    // Function that takes in a file, reads a random line and returns it
    // This is to randomly select enemy in kotlin

    val lines: List<String> = context.assets.open(filename)
        .bufferedReader()
        .use { it.readLines() }

    val random_index = Random.nextInt(lines.size)
    return lines[random_index]

}