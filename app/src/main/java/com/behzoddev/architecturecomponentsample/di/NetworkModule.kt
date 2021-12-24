package com.behzoddev.architecturecomponentsample.di

import android.util.Log
import com.behzoddev.architecturecomponentsample.network.PostService
import com.behzoddev.architecturecomponentsample.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        moshiConvertor: MoshiConverterFactory
    ): PostService {
        return Retrofit.Builder().run {
            Log.d("Debug","provideRetrofitInstance")
            baseUrl(BASE_URL)
            addConverterFactory(moshiConvertor)
            build()
        }.run {
            create(PostService::class.java)
        }
    }



    @Provides
    @Singleton
    fun provideMoshiInstance(): MoshiConverterFactory {
        Log.d("Debug","provideMoshiInstance")
        return MoshiConverterFactory.create()
    }

}