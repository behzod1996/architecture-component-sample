package com.behzoddev.architecturecomponentsample.database.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.behzoddev.architecturecomponentsample.database.dao.PostDao
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.utils.Constants.DATABASE_NAME

@Database(
    entities = [Post::class],
    version = 1,
    exportSchema = false
)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var INSTANCE : PostDatabase? = null

        fun getInstance(context: Context): PostDatabase {
            Log.d("Debug","getInstance function from database")
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}