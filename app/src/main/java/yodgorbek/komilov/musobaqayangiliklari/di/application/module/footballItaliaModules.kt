package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.repository.FootballItaliaRepositoryImpl

import yodgorbek.komilov.musobaqayangiliklari.viewmodel.FootballItaliaViewModel

val footballItaliaModules = module() {
    factory(named("footballItaliaModules")) { (FootballItaliaRepositoryImpl(getFootballItaliaApi = get())) }
    // Tells Koin how to create an instance of FootballItaliaRepository
    viewModel { FootballItaliaViewModel(footballItaliaRepository = get(named("footballItaliaModules"))) }
}