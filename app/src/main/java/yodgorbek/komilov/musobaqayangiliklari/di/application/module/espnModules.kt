package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.repository.ESPNRepositoryImpl
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.ESPNViewModel

val espnModules = module {
    factory(named("espnModules")) { ESPNRepositoryImpl(espnNewsApi = get()) }

    // Specific viewModel pattern to tell Koin how to build ESPNViewModel
    viewModel { ESPNViewModel(espnRepository = get(named("espnModules"))) }
}