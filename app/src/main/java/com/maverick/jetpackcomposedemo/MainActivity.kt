package com.maverick.jetpackcomposedemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.maverick.jetpackcomposedemo.side_effect.DisposableExample
import com.maverick.jetpackcomposedemo.side_effect.FakeViewModel
import com.maverick.jetpackcomposedemo.side_effect.LaunchedEffectExample
import com.maverick.jetpackcomposedemo.side_effect.RememberUpdatedState
import com.maverick.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            /**
             * 10 Effect Handlers
             */

//            var text by remember {
//                mutableStateOf("")
//            }

            JetpackComposeDemoTheme {


                /**
                 * 1 Simple Greetings
                 */
//            Greetings("Maverick", "Universe")

                /**
                 * 4 Image Card
                 */
//            val painter = painterResource(id = R.drawable.image)
//            val contentDescription = "Kermit Enjoying Snow."
//            val title = "Kermit Enjoying Snow."
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(painter = painter, contentDescription = contentDescription, title = title)
//            }

                /**
                 * 5 Styling Text
                 */
//            val fontFamily = FontFamily(
//                Font(R.font.lexend_thin, FontWeight.Thin),
//                Font(R.font.lexend_extralight, FontWeight.ExtraLight),
//                Font(R.font.lexend_light, FontWeight.Light),
//                Font(R.font.lexend_regular, FontWeight.Normal),
//                Font(R.font.lexend_medium, FontWeight.Medium),
//                Font(R.font.lexend_semibold, FontWeight.SemiBold),
//                Font(R.font.lexend_bold, FontWeight.Bold),
//                Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
//            )

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
                 * 6 State
                 */

//            Column(Modifier.fillMaxSize()) {
//                val color = remember {
//                    mutableStateOf(Color.Yellow)
//                }
//                ColorBox(
//                    Modifier
//                        .weight(1f)
//                        .fillMaxSize()) {
//                    color.value = it
//                }
//                Box(
//                    Modifier
//                        .background(color.value)
//                        .weight(1f)
//                        .fillMaxSize()
//                )
//            }

                /**
                 * 7 SnackBar
                 */
//            val scaffoldState = rememberScaffoldState()
//            var textFieldState by remember {
//                mutableStateOf("")
//            }
//            val scope = rememberCoroutineScope()
//
//            Scaffold(
//                modifier = Modifier.fillMaxSize().padding(bottom = 6.dp),
//                scaffoldState = scaffoldState,
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 30.dp)
//                ) {
//                    TextField(
//                        value = textFieldState,
//                        label = {
//                            Text("Enter your name")
//                        },
//                        onValueChange = {
//                            textFieldState = it
//                        },
//                        singleLine = true,
//                        modifier = Modifier.fillMaxWidth(),
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
//                        }
//                    }) {
//                        Text(text = "Please greet me")
//                    }
//                }
//            }

                /**
                 * 8 Lists
                 */
//            LazyColumn {
//                itemsIndexed(
//                    listOf("This","is","Jetpack","Compose","as","everyone","is","moving","towards","modern","Android","Development")
//                ){index,string->
//                    Text(
//                        text = string,
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp),
//                    )
//                }
//            }

                /**
                 * 9 Constraint Layout
                 */
//            val constraintSet = ConstraintSet {
//                val greenBox = createRefFor("greenbox")
//                val redBox = createRefFor("redbox")
//                val guideline = createGuidelineFromTop(0.5f)
//
//                constrain(greenBox) {
//                    top.linkTo(guideline)
//                    start.linkTo(parent.start)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                constrain(redBox) {
//                    top.linkTo(parent.top)
//                    start.linkTo(greenBox.end)
//                    end.linkTo(parent.end)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
//            }
//            ConstraintLayout(constraintSet, Modifier.fillMaxSize()) {
//                Box(
//                    modifier = Modifier
//                        .background(Color.Green)
//                        .layoutId("greenbox")
//                )
//                Box(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .layoutId("redbox")
//                )
//            }

                /**
                 * 10 Effect Handlers
                 */

//                LaunchedEffect(key1 = text) {
//                    delay(3000L)
//                    println("The text is $text")
//                }

                /**
                 * SideEffects in Jetpack Compose    [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
                 */

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    // LaunchEffect() & rememberCoroutineScope()
//                    LaunchedEffectExample(fakeViewModel = FakeViewModel())

                    // rememberUpdatedState()
//                    RememberUpdatedState()

                    // DisposableEffect()
//                    DisposableExample(activity = this, backPressedDispatcher = this.onBackPressedDispatcher)


                }

            }
        }
    }
}


/**
 * Compose Preview
 */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        //TODO
    }
}


/**
 * 6 State
 */
@Composable
fun ColorBox(
    modifier: Modifier = Modifier, updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f
                )
            )
        })
}


/**
 * 4 Image Card
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
                                Color.Transparent, Color.Black
                            ), startY = 300f
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
                    text = title, style = TextStyle(
                        color = Color.White, fontSize = 16.sp
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
    name: String, extension: String
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
