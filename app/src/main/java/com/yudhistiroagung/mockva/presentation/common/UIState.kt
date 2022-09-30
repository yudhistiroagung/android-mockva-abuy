package com.yudhistiroagung.mockva.presentation.common

sealed class UIState<out T> {
    /**
     * the screen is currently loading it's data. "loading state"
     */
    class Loading<out T> : UIState<T>()

    /**
     * data was successfully loaded for the screen.  "happy path"
     */
    data class Success<out T>(val data: T) : UIState<T>()

    /**
     * empty data was successfully loaded for the screen. "happy path"
     * */
    class Empty<out T> : UIState<T>()

    /**
     * empty data based on request/search query was successfully loaded for the screen. "happy path"
     * */
    class NoResults<out T> : UIState<T>()

    /**
     * some type of error occurred.  "error state"
     */
    data class Failure<out T>(val throwable: Throwable) : UIState<T>()
}