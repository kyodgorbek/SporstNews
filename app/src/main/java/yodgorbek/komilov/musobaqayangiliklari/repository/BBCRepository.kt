package yodgorbek.komilov.musobaqayangiliklari.repository


import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface BBCRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getBBCList(): UseCaseResult<List<Article>>
}


@Suppress("UNCHECKED_CAST")
class BBCRepositoryImpl(private val bbcsportNewsApi: SportNewsInterface) : BBCRepository {
    override suspend fun getBBCList(): UseCaseResult<List<Article>> {

        return try {
            val result = bbcsportNewsApi.getBBCSport().body()!!.articles
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}