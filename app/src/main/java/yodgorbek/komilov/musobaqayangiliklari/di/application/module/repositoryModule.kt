package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository


val repositoryModule = module {
    fun provideUserRepository(
        sportsNewsApi: SportNewsInterface,
        sportNewsDao: SportNewsDao
    ): NewsRepository {
        return NewsRepository(sportsNewsApi, sportNewsDao)
    }

    single { provideUserRepository(get(), get()) }
}