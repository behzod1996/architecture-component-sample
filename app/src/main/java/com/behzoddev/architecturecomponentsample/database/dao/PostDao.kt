package com.behzoddev.architecturecomponentsample.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.behzoddev.architecturecomponentsample.database.model.Post
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts: List<Post>)

    @Query("DELETE FROM post_table")
    suspend fun deletePosts()

    @Query("SELECT * FROM post_table WHERE id = :id")
    fun getById(id: Int) : Flow<Post>

    @Query("SELECT * FROM post_table")
    fun getAllPosts(): Flow<List<Post>>
}