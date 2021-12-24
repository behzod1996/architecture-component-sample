package com.behzoddev.architecturecomponentsample.utils



sealed class State<T> {
    data class Success<T> (val data : T) : State<T>()
    data class Error<T>(val throwable: String) : State<T>()
    class Loading<T> : State<T>()

    companion object {
        fun <T> isLoading() = Loading<T>()
        fun <T> isSuccess(data: T) = Success(data)
        fun <T> isError(throwable: String) = Error<T>(throwable)

        fun <T> fromResourceToState(resource: Resource<T>) : State<T> = when(resource) {
            is Resource.Success -> isSuccess(resource.data)
            is Resource.Loading -> isLoading()
            is Resource.Error -> isError(resource.exception)
        }
    }
}
