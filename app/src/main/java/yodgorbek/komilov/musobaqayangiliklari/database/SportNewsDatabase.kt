package yodgorbek.komilov.musobaqayangiliklari.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import yodgorbek.komilov.musobaqayangiliklari.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class SportNewsDatabase : RoomDatabase() {

    abstract fun sportNewsDao(): SportNewsDao

    companion object {
        private var instance: SportNewsDatabase? = null
        fun getInstance( context: Context): SportNewsDatabase? {
            if (instance == null) {
                synchronized(SportNewsDatabase::class.java) {
                    instance = Room.databaseBuilder(context.applicationContext, SportNewsDatabase::class.java, "article_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }


}