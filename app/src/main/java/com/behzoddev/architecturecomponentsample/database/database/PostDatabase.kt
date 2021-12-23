package com.behzoddev.architecturecomponentsample.database.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.behzoddev.architecturecomponentsample.database.dao.PostDao
import com.behzoddev.architecturecomponentsample.utils.Constants.DATABASE_NAME

abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var INSTANCE : PostDatabase? = null

        fun getInstance(context: Context): PostDatabase {
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