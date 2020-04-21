package yodgorbek.komilov.musobaqayangiliklari.di.application.module


import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.factory
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDatabase
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository


import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel


val appModules = module() {


    // Specific viewModel pattern to tell Koin how to build MainViewModel

        // factory<NewsRepository> { (NewsRepositoryImpl(sportsNewsApi = get())) }
        // Specific viewModel pattern to tell Koin how to build MainViewModel
        viewModel { MainViewModel(newsRepository = get()) }

    single { NewsRepository(get(), get())
    }

    }









