package com.behzoddev.architecturecomponentsample.network

import com.behzoddev.architecturecomponentsample.database.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("/DummyFoodiumApi/api/posts/")
    suspend fun getAllPosts() : Response<List<Post>>
}