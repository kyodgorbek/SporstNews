package yodgorbek.komilov.musobaqayangiliklari.repository

import android.util.Log
import com.google.android.datatransport.runtime.logging.Logging.e
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

import yodgorbek.komilov.musobaqayangiliklari.utils.Results

class NewsRepository(
    private val sportNewsApi: SportNewsInterface,
    private val sportNewsDao: SportNewsDao
) {


    companion object{
        const val  TAG=  "Error"
    }

    val data = sportNewsDao.getAllData()

    suspend fun refresh() = withContext(Dispatchers.IO) {
        val articles = sportNewsApi.getNewsAsync().body()?.articles
        if (articles != null) {
            sportNewsDao.addAll(articles)
          Log.e(TAG,"Error")
            Results.Success(articles)
        } else {
            Results.Failure("MyError")
        }
    }
}




