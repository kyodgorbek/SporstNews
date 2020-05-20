package yodgorbek.komilov.musobaqayangiliklari.koinTest

import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.KoinContext
import org.koin.core.context.startKoin

import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get

import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.di.application.module.*
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository

class MyTest: KoinTest {



    @Test
    fun `make a test with Koin`() {

        val repositoryModule = module {
            fun provideUserRepository(
                sportsNewsApi: SportNewsInterface,
                sportNewsDao: SportNewsDao
            ): NewsRepository {
                return NewsRepository(sportsNewsApi, sportNewsDao)
            }

            single { provideUserRepository(get(), get()) }
            startKoin { (modules(repositoryModule)) }


            assertEquals(
                "provideUserRepository", provideUserRepository(
                    get(),
                    get()
                )
            )
        }
    }



}

