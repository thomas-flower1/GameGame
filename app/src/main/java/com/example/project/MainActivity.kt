package com.example.project

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme
import com.example.project.ui.theme.pixelOperator


// GLOBAL SCOPE
enum class GameState {
    PREPARE,
    ATTACK,
    ITEM


}


var index by mutableIntStateOf(0) // this is the hotbar index



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Dpad()
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
        Column()
        {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(2.dp, Color.Black)
                        .padding(16.dp)

                ) {
                    if (index == 0) {
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
                    if (index == 1) {
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
                    if (index == 2) {
                        Action("RUN", true)
                    } else {
                        Action("RUN", false)
                    }


                }


            }





        }
    }
}





@Composable
fun Dpad(){

    // Defining the full screen
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        // Box for the whole dpad - used to positon it on the screen
        Box(
            modifier = Modifier
                .offset(28.dp, 550.dp)

        ) {

            Column(

            ) {
                // First row
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                ) {
                    Button(
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {


                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowUp,
                            contentDescription = "Move up",

                            )

                    }
                }


                // The middle row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                ) {
                    Button(
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {
                            left(GameState.PREPARE)

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Move up",

                            )

                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {
                            right(GameState.PREPARE)

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Move up",

                            )

                    }




                }

                // The last row
                Row(

                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)


                ) {

                    Button(
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {


                        }
                    ) {
                        Icon(
                            imageVector =  Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Move up",

                        )

                    }
                }



            }
        }
        Row(
            modifier = Modifier
                .offset(100.dp, 100.dp),
        ) {
            Text(text = index.toString())
        }


    }



}

fun left(state: GameState){
    if(state == GameState.PREPARE) {
        if (index > 0){
            index--
        } else {
            index = 2
        }


    }
}

fun right(state: GameState){
    if(state == GameState.PREPARE) {
        if (index < 2){
            index++
        } else {
            index = 0
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
     Dpad()
    }
}