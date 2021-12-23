package com.behzoddev.architecturecomponentsample.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.behzoddev.architecturecomponentsample.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Post(
    @PrimaryKey
    val id: Int? = 0,
    val title: String? = null,
    val author: String? = null,
    val image: String? = null,
    val body: String? = null
)