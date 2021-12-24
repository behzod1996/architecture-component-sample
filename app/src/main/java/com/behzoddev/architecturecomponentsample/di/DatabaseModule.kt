package com.behzoddev.architecturecomponentsample.di

import android.app.Application
import com.behzoddev.architecturecomponentsample.database.database.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomInstance(application: Application)  = PostDatabase.getInstance(application)

    @Provides
    @Singleton
    fun provideDao(database: PostDatabase) = database.postDao()
}