package yodgorbek.komilov.musobaqayangiliklari.internet


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface SportNewsInterface {

    @GET("v2/top-headlines?country=us&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getNews(): Call<SportNewsResponse>

    @GET("/v2/top-headlines?sources=espn&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getEspn(): Call<SportNewsResponse>

    @GET("/v2/top-headlines?sources=football-italia&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getFootballItalia(): Call<SportNewsResponse>

    @GET("/v2/top-headlines?sources=bbc-sport&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getBBCSport(): Call<SportNewsResponse>

    companion object {

        var BASE_URL = "https://newsapi.org/"

        fun create(): SportNewsInterface {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(SportNewsInterface::class.java)

        }
    }
}