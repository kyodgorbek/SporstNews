package yodgorbek.komilov.musobaqayangiliklari.repository


import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

import yodgorbek.komilov.musobaqayangiliklari.model.Article


import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface NewsRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getNewsList(): UseCaseResult<List<Article>>
}

class NewsRepositoryImpl(private val sportNewsInterface: SportNewsInterface) : NewsRepository {
    override suspend fun getNewsList(): UseCaseResult<List<Article>> {

        return try {
            val result = sportNewsInterface.getNews()
            UseCaseResult.Success(result) as UseCaseResult<List<Article>>
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}
