package com.behzoddev.architecturecomponentsample.repo

import com.behzoddev.architecturecomponentsample.database.dao.PostDao
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.network.PostService
import com.behzoddev.architecturecomponentsample.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor (
    private val dao: PostDao,
    private val postService: PostService
        ): PostRepository {
    override fun getAllPosts(): Flow<Resource<List<Post>>> {
        return object: NetworkBoundRepository<List<Post>,List<Post>>() {
            override suspend fun saveRemoteData(response: List<Post>) {
                return dao.insertPost(response)
            }

            override fun fetchFromLocal(): Flow<List<Post>> {
                return dao.getAllPosts()
            }

            override suspend fun fetchFromRemote(): Response<List<Post>> {
                return postService.getAllPosts()
            }
        }.asFlow()
    }

    override fun getPostById(postId: Int): Flow<Post> {
        return dao.getById(postId).distinctUntilChanged()
    }

}