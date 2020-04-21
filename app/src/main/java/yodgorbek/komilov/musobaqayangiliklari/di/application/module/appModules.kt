package yodgorbek.komilov.musobaqayangiliklari.di.application.module


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel


val appModules = module {


    // Specific viewModel pattern to tell Koin how to build MainViewModel

    // factory<NewsRepository> { (NewsRepositoryImpl(sportsNewsApi = get())) }
    // Specific viewModel pattern to tell Koin how to build MainViewModel
    viewModel { MainViewModel(newsRepository = get()) }
}









