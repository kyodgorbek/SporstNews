package yodgorbek.komilov.musobaqayangiliklari.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import yodgorbek.komilov.musobaqayangiliklari.database.SportNewsDao
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

class NewsRepository(private val sportNewsApi: SportNewsInterface, private val sportNewsDao: SportNewsDao) {

        val data = sportNewsDao.getAllData()

        suspend fun refresh() {
            withContext(Dispatchers.IO) {
                val articles = sportNewsApi.getNewsAsync().body()?.articles
                if (articles != null) {
                    sportNewsDao.addAll(articles)
                }
            }
        }
    }

//    @Suppress("UNCHECKED_CAST")
//    class NewsRepositoryImpl(
//        private val sportsNewsApi: SportNewsInterface
//    ) : NewsRepository {
//        override suspend fun getNewsList(): UseCaseResult<List<Article>> {
//
//            return try {
//                val result = sportsNewsApi.getNewsAsync().body()!!.articles
//
//
//                UseCaseResult.Success(result)
//            } catch (ex: Exception) {
//                UseCaseResult.Error(ex)
//            }
//        }
//    }

