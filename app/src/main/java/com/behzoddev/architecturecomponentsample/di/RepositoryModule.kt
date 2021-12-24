package com.behzoddev.architecturecomponentsample.di

import com.behzoddev.architecturecomponentsample.repo.PostRepository
import com.behzoddev.architecturecomponentsample.repo.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class PostRepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindPostRepository(repository: PostRepositoryImpl): PostRepository
}