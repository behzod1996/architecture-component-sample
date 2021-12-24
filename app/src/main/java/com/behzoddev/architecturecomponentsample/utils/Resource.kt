package com.behzoddev.architecturecomponentsample.utils

import java.lang.Exception

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val exception: String) : Resource<T>()
    class Loading<T> : Resource<T>()

    companion object {
        fun <T> isLoading() = Loading<T>()
        fun <T> isSuccess(data: T)  = Success(data)
        fun <T> isError(throwable: String) = Error<T>(throwable)

    }
}