package yodgorbek.komilov.musobaqayangiliklari.internet

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SportNewsInterface {

    @GET("v2/top-headlines?country=us&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getNews() : Call <List<Article>>

    companion object {

        var BASE_URL = "https://newsapi.org/"

        fun create() : SportNewsInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(SportNewsInterface::class.java)

        }
    }
}