package yodgorbek.komilov.musobaqayangiliklari.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
data class Article(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "author") val author: String,
    val content: String,
    val description: String,
    var publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)