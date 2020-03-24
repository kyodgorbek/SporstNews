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
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepositoryImpl
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.BBCSportViewModel
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel
import java.util.concurrent.TimeUnit

const val base_url = "https://newsapi.org/"

val bbcModules = module {
    // The Retrofit service using our custom HTTP client instance as a singleton
    single(named("bbcModules")) {
        createBBCWebService<SportNewsInterface>(
            okHttpClient = createBBCHttpClient(),
            factory = RxJava2CallAdapterFactory.create(),
            baseUrl = base_url
        )
    }

    factory<BBCRepository> { (BBCRepositoryImpl(bbcsportNewsApi = get(named("bbcModules")))) }
    // Tells Koin how to create an instance of BBCRepository
    viewModel { BBCSportViewModel(bbcRepository = get(named("bbcModules"))) }
}

/* Returns a custom OkHttpClient instance with interceptor. Used for building Retrofit service */
fun createBBCHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.readTimeout(5 * 60, TimeUnit.SECONDS)
    return client.addInterceptor {
        val original = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.header("Content-Type", "application/json")
        val request = requestBuilder.method(original.method, original.body).build()
        return@addInterceptor it.proceed(request)
    }.build()
}

/* function to build our Retrofit service */
inline fun <reified T> createBBCWebService(
    okHttpClient: OkHttpClient,
    factory: CallAdapter.Factory, baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}