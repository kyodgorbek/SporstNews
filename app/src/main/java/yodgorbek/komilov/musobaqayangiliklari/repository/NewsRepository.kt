package yodgorbek.komilov.musobaqayangiliklari.repository



import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.model.Article


import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface NewsRepository {
    // Suspend is used to await the result from Deferred
   suspend fun getNewsList(): UseCaseResult<List<Article>>
}


@Suppress("UNCHECKED_CAST")
class NewsRepositoryImpl(private val sportsNewsApi: SportNewsInterface) : NewsRepository {
    override suspend fun getNewsList(): UseCaseResult<List<Article>> {

        return try {
            val result = sportsNewsApi.getNewsAsync().body()!!.articles
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}