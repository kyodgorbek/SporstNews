package yodgorbek.komilov.musobaqayangiliklari.repository


import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface BBCRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getBBCList(): UseCaseResult<List<Article>>
}

class BBCRepositoryImpl(private val sportNewsInterface: SportNewsInterface) : BBCRepository {
    override suspend fun getBBCList(): UseCaseResult<List<Article>> {
        /*
         We try to return a list of cats from the API
         Await the result from web service and then return it, catching any error from API
         */
        return try {
            val result = sportNewsInterface.getBBCSport()
            UseCaseResult.Success(result) as UseCaseResult<List<Article>>
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}
