package com.maverick.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            /**
             * 1 Simple Greetings
             */
//            Greetings("Maverick", "Universe")

            /**
             * 2 Image Card
             */
            val painter = painterResource(id = R.drawable.image)
            val contentDescription = "Kermit Enjoying Snow."
            val title = "Kermit Enjoying Snow."
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(painter = painter, contentDescription = contentDescription, title = title)
//            }

            /**
             * 3 Styling Text
             */
            val fontFamily = FontFamily(
                Font(R.font.lexend_thin, FontWeight.Thin),
                Font(R.font.lexend_extralight, FontWeight.ExtraLight),
                Font(R.font.lexend_light, FontWeight.Light),
                Font(R.font.lexend_regular, FontWeight.Normal),
                Font(R.font.lexend_medium, FontWeight.Medium),
                Font(R.font.lexend_semibold, FontWeight.SemiBold),
                Font(R.font.lexend_bold, FontWeight.Bold),
                Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
            )

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ) {
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("J")
//                        }
//                        append("etpack")
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("C")
//                        }
//                        append("ompose")
//                    },
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    fontStyle = FontStyle.Italic,
//                    textAlign = TextAlign.Center,
//                    textDecoration = TextDecoration.Underline
//                )
//            }

            /**
             * 4
             */

            Column(Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()) {
                    color.value = it
                }
                Box(
                    Modifier
                        .background(color.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }


        }
    }
}


/**
 * 4
 */
@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}


/**
 * 2 Image Card
 */
@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }

        }
    }

}

/**
 * 1 Simple Greetings - Intro to Compose
 */
@Composable
fun Greetings(
    name: String,
    extension: String
) {
    Row(
        modifier = Modifier
            .fillMaxHeight(0.1f)
            .fillMaxWidth()
            .background(Color.Green)
            .padding(top = 16.dp)
    ) {
        Text(text = name, fontSize = 24.sp)
        Text(text = extension, fontSize = 24.sp)
    }
}
