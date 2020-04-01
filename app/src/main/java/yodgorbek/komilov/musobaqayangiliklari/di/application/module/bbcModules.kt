package yodgorbek.komilov.musobaqayangiliklari.di.application.module

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.repository.BBCRepository
import yodgorbek.komilov.musobaqayangiliklari.repository.BBCRepositoryImpl
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository

import yodgorbek.komilov.musobaqayangiliklari.viewmodel.BBCSportViewModel
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel
import java.util.concurrent.TimeUnit

val bbcModules = module() {
    factory(named("bbcModules")) { (BBCRepositoryImpl(bbcsportNewsApi = get())) }
    // Tells Koin how to create an instance of BBCRepository
    viewModel { BBCSportViewModel(bbcRepository = get(named("bbcModules"))) }
}