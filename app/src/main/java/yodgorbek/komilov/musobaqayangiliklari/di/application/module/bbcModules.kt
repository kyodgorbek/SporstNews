package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import yodgorbek.komilov.musobaqayangiliklari.repository.BBCRepositoryImpl
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.BBCSportViewModel

val bbcModules = module {
    factory(named("bbcModules")) { (BBCRepositoryImpl(bbcsportNewsApi = get())) }
    // Tells Koin how to create an instance of BBCRepository
    viewModel { BBCSportViewModel(bbcRepository = get(named("bbcModules"))) }
}