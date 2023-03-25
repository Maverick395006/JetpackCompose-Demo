package com.maverick.jetpackcomposedemo.side_effect

/**
 *   [url:https://www.youtube.com/watch?v=KRqDT4oQWUU]
 */

sealed class ResultType {
    object Success : ResultType()
    object Loading : ResultType()
    object Idle : ResultType()
}