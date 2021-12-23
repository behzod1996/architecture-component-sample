package com.behzoddev.architecturecomponentsample.utils

import java.lang.Exception

sealed class Resource<out T: Any> {
    data class Success<out T: Any>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}