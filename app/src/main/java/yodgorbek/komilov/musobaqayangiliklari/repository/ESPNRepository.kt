package yodgorbek.komilov.musobaqayangiliklari.repository

import kotlinx.coroutines.Deferred
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface ESPNRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getESPNList(): UseCaseResult<List<Article>>
}


@Suppress("UNCHECKED_CAST")
class ESPNRepositoryImpl(private val espnNewsApi: SportNewsInterface) : ESPNRepository {
    override suspend fun getESPNList(): UseCaseResult<List<Article>> {

        return try {
            val result = espnNewsApi.getEspn().body()!!.articles
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}