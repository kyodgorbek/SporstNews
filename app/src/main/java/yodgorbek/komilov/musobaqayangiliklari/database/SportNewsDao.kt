package yodgorbek.komilov.musobaqayangiliklari.database

import androidx.lifecycle.LiveData
import androidx.room.*

import yodgorbek.komilov.musobaqayangiliklari.model.Article

@Dao
interface SportNewsDao {

    @Query("SELECT * FROM  Article")
    fun getAllData(): LiveData<List<Article>>

    @Insert
    suspend fun addAll(article: List<Article>)


    @Update
    suspend fun updateArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

}
