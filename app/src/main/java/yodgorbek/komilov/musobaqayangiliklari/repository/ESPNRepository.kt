package yodgorbek.komilov.musobaqayangiliklari.repository

import kotlinx.coroutines.Deferred
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult

interface ESPNRepository {
    // Suspend is used to await the result from Deferred
    suspend fun getESPNList(): UseCaseResult<Deferred<List<SportNewsResponse>>>
}

class ESPNRepositoryImpl(private val sportNewsInterface: SportNewsInterface) : ESPNRepository {
    override suspend fun getESPNList(): UseCaseResult<Deferred<List<SportNewsResponse>>> {
        /*
         We try to return a list of cats from the API
         Await the result from web service and then return it, catching any error from API
         */
        return try {
            val result = sportNewsInterface.getBBCSport()
            UseCaseResult.Success(result) as UseCaseResult<Deferred<List<SportNewsResponse>>>
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}