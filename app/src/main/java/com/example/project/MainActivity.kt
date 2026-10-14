package com.example.project

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme
import com.example.project.ui.theme.pixelOperator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Hotbar()

            }
        }
    }
}

@Composable
fun Hotbar() {



    var currentIndex by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()


            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(2.dp, Color.Black)
                        .padding(16.dp)

                ) {
                    if (currentIndex == 0) {
                        Action("ATTACK", true)
                    } else {
                        Action("ATTACK", false)
                    }


                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(2.dp, Color.Black)
                        .padding(16.dp)
                ) {
                    if (currentIndex == 1) {
                        Action("ITEM", true)
                    } else {
                        Action("ITEM", false)
                    }


                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(2.dp, Color.Black)
                        .padding(16.dp)
                ) {
                    if (currentIndex == 2) {
                        Action("CHARM", true)
                    } else {
                        Action("CHARM", false)
                    }


                }


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = currentIndex.toString(), fontFamily = pixelOperator)
            }

            Button(
                onClick = {
                    if (currentIndex < 2) {
                        currentIndex++
                    } else {
                        currentIndex = 0
                    }
                    print("CLicked")


                },
            ) {}
        }
    }










}


@Composable
fun Action(action: String, visible: Boolean) {



    Row() {

        Box(
            modifier = Modifier
                .height(32.dp),
            contentAlignment = Alignment.Center

        ) {
            if (visible) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward"
                )
            }
        }


        Text(
            text = action.uppercase(),
            fontFamily = pixelOperator,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(32.dp)
        )
    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheme {
       Hotbar()
    }
}