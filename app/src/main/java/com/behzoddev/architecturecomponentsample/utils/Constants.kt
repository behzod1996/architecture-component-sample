package com.behzoddev.architecturecomponentsample.utils

import android.widget.ImageView
import com.behzoddev.architecturecomponentsample.database.model.Post

object Constants {
    const val TABLE_NAME = "post_table"
    const val DATABASE_NAME = "post_database"
    const val BASE_URL = "https://patilshreyas.github.io/"
}
typealias onItemClick = (Post, ImageView) -> Unit
