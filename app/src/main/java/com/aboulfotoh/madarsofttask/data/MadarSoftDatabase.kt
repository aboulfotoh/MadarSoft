package com.aboulfotoh.madarsofttask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aboulfotoh.madarsofttask.data.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
public abstract class MadarSoftDatabase : RoomDatabase() {
    abstract fun userDao(): UserDataSource

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MadarSoftDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): MadarSoftDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MadarSoftDatabase::class.java,
                    "madar_database"
                ).addCallback(MadarDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class MadarDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    //populateDatabase(database.userDao())
                }
            }
        }

        suspend fun populateDatabase(userDao: UserDataSource) {
            // Delete all content here.
            //userDao.deleteAll()
            // Add sample words.
            /*val user = User(0,"Test","18","Test","Test")
            userDao.insert(user)*/
        }
    }

}