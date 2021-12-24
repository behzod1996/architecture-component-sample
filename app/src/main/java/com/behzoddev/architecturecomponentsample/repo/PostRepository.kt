package com.behzoddev.architecturecomponentsample.repo

import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getAllPosts(): Flow<Resource<List<Post>>>
    fun getPostById(postId: Int) : Flow<Post>
}