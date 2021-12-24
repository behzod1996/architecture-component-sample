package com.behzoddev.architecturecomponentsample.repo

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.behzoddev.architecturecomponentsample.utils.Resource
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.io.IOException

abstract class NetworkBoundRepository<RESULT,REQUEST> {

    fun asFlow() = flow<Resource<RESULT>> {

        emit(Resource.isLoading())
        emit(Resource.Success(fetchFromLocal().first()))

        val apiResponse = fetchFromRemote()
        val remotePosts = apiResponse.body()

        if (apiResponse.isSuccessful && remotePosts != null) {
            Log.d("Debug","Api Response is successful")
            saveRemoteData(remotePosts)
        } else {
            emit(Resource.Error(apiResponse.message()))
        }
        emitAll(
            fetchFromLocal().map {
                Resource.Success(it)
            }
        )

    }.catch { error ->
        error.printStackTrace()
        emit(Resource.isError(error.message.toString()))
    }
    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)
    @MainThread
    protected abstract fun fetchFromLocal(): Flow<RESULT>
    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

}