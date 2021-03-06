package yodgorbek.komilov.musobaqayangiliklari.internet


import retrofit2.Response
import retrofit2.http.GET


interface SportNewsInterface {

    @GET("v2/top-headlines?country=us&apiKey=da331087e3f3462bb534b3b0917cbee9")
    suspend fun getNewsAsync(): Response<SportNewsResponse>

    @GET("/v2/top-headlines?sources=espn&apiKey=da331087e3f3462bb534b3b0917cbee9")
    suspend fun getEspn(): Response<SportNewsResponse>

    @GET("/v2/top-headlines?sources=football-italia&apiKey=da331087e3f3462bb534b3b0917cbee9")
    suspend fun getFootballItalia(): Response<SportNewsResponse>

    @GET("/v2/top-headlines?sources=bbc-sport&apiKey=da331087e3f3462bb534b3b0917cbee9")
    suspend fun getBBCSport(): Response<SportNewsResponse>


}

