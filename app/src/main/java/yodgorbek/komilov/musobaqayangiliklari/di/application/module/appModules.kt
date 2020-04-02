package yodgorbek.komilov.musobaqayangiliklari.di.application.module


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository

//import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepositoryImpl
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel


val appModules = module() {
    factory(named("appModules")) {
        NewsRepository(sportNewsApi = get(), sportNewsDao = get())
    }
    // factory<NewsRepository> { (NewsRepositoryImpl(sportsNewsApi = get())) }
    // Specific viewModel pattern to tell Koin how to build MainViewModel
    viewModel { MainViewModel(newsRepository = get(named("appModules"))) }



}

