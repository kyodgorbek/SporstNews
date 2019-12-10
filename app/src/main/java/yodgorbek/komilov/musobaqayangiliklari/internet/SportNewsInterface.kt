package yodgorbek.komilov.musobaqayangiliklari.internet


import kotlinx.coroutines.Deferred

import retrofit2.http.GET


interface SportNewsInterface {

    @GET("v2/top-headlines?country=us&apiKey=da331087e3f3462bb534b3b0917cbee9")
     fun getNewsAsync(): Deferred<SportNewsResponse>

    @GET("/v2/top-headlines?sources=espn&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getEspn(): Deferred<List<SportNewsResponse>>

    @GET("/v2/top-headlines?sources=football-italia&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getFootballItalia(): Deferred<List<SportNewsResponse>>

    @GET("/v2/top-headlines?sources=bbc-sport&apiKey=da331087e3f3462bb534b3b0917cbee9")
    fun getBBCSport(): Deferred<List<SportNewsResponse>>


}

