package com.maverick.jetpackcomposedemo.side_effect

import android.util.Log
import androidx.compose.runtime.DisposableEffect
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maverick.jetpackcomposedemo.MainActivity

@Composable
fun DisposableExample(activity: MainActivity, backPressedDispatcher: OnBackPressedDispatcher) {

    /**
     * DisposableEffect()  [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
     * Uses: remove Callback, observer, etc...
     */

    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity.finish()
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        Log.d("TAG", "DisposableExample: start")
        backPressedDispatcher.addCallback(callback)

        onDispose {
            Log.d("TAG", "DisposableExample: OnDispose")
            callback.remove()
        }
    }

}


var i: Int = 0

@Composable
fun SideEffects() {

    /**
     * SideEffect()  [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
     * Uses: It will only call on Successful Composition
     */

    SideEffect {
        i++
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Side Effects")
    }

}