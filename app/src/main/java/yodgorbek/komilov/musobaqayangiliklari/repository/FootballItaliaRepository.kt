package yodgorbek.komilov.musobaqayangiliklari.repository

import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface FootballItaliaRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getFootballItaliaList(): UseCaseResult<List<Article>>
}


@Suppress("UNCHECKED_CAST")
class FootballItaliaRepositoryImpl(private val getFootballItaliaApi: SportNewsInterface) :
    FootballItaliaRepository {
    override suspend fun getFootballItaliaList(): UseCaseResult<List<Article>> {

        return try {
            val result = getFootballItaliaApi.getFootballItalia().body()!!.articles
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}