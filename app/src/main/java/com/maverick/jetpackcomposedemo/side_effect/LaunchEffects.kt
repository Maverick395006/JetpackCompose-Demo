package com.maverick.jetpackcomposedemo.side_effect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FakeViewModel : ViewModel() {

    val state: MutableState<ResultType> = mutableStateOf(ResultType.Idle)

    fun getData() = viewModelScope.launch {
        state.value = ResultType.Loading
        delay(3000L)
        state.value = ResultType.Success
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showUi() {
    LaunchedEffectExample(fakeViewModel = FakeViewModel())
}

@Composable
fun LaunchedEffectExample(fakeViewModel: FakeViewModel) {

    val state = fakeViewModel.state.value

    /**
     * rememberCoroutineScope()  [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
     * Uses: To call function from nonComposable
     */
    val scope = rememberCoroutineScope()

    /**
     * LaunchedEffect()  [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
     * Uses: To execute your Composable One Time [Avoid Re-Composition]
     */
    LaunchedEffect(key1 = Unit, block = {
        fakeViewModel.getData()
    })

    when (state) {
        is ResultType.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ResultType.Success -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column() {
                    Text(text = "Success")
                    Button(onClick = {
                        scope.launch {
                            fakeViewModel.getData()
                        }
                    }) {

                    }
                }
            }
        }
        is ResultType.Idle -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Idle")
            }
        }
    }

}