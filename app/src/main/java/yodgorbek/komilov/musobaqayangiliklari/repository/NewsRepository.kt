package yodgorbek.komilov.musobaqayangiliklari.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

import yodgorbek.komilov.musobaqayangiliklari.utils.Results

class NewsRepository(private val sportNewsApi: SportNewsInterface, private val sportNewsDao: SportNewsDao) {



        val data = sportNewsDao.getAllData()

    suspend fun refresh() = withContext(Dispatchers.IO) {
        val articles = sportNewsApi.getNewsAsync().body()?.articles
        if (articles != null) {
            sportNewsDao.addAll(articles)
            Results.Success(articles)
        } else {
            Results.Failure("MyError")
        }
    }
}




