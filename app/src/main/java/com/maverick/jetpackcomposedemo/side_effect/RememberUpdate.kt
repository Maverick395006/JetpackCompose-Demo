package com.maverick.jetpackcomposedemo.side_effect

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

/**
 *   rememberUpdatedState()     [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
 *   Uses: -
 */

@Composable
fun RememberUpdatedState() {

    val color = remember {
        mutableStateOf("none")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Button(onClick = {
                Log.d("TAG","RememberUpdatedState: Red")
                color.value = "Red"
            }) {
                Text(text = "Red")
            }
            Button(onClick = {
                Log.d("TAG","RememberUpdatedState: Blue")
                color.value = "Blue"
            }) {
                Text(text = "Blue")
            }
        }
    }

    Timer(color = color.value)

}

@Composable
fun Timer(color: String) {

    val colors = rememberUpdatedState(newValue = color)

    LaunchedEffect(key1 = Unit, block = {
        delay(4000L)
        Log.d("TAG","Timer: ${colors.value}")
    })

}