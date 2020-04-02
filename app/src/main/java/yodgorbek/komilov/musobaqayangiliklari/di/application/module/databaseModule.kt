package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDatabase



val databaseModule = module {
    fun provideDatabase(application: Application): SportNewsDatabase {
        return Room.databaseBuilder(application, SportNewsDatabase::class.java, "sportNews.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: SportNewsDatabase): SportNewsDao {
        return database.sportNewsDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }


}