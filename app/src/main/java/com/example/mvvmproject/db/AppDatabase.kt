package com.example.mvvmproject.db

import android.content.*
import androidx.room.*

@Database(entities = [UserEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao() : UserDao

    companion object {

        private var dbInstance: AppDatabase? = null

        fun getDatabaseInstance(context: Context): AppDatabase {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "MY_DB"
                ).allowMainThreadQueries().build()
            }
            return dbInstance!!
        }
    }
}