package yodgorbek.komilov.musobaqayangiliklari.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "news_table")
data class Article(@ColumnInfo(name = "author")val author: String,
                   val content: String,
                   val description: String,
                   val publishedAt: String,
                   val source: Source,
                   val title: String,
                   val url: String,
                   val urlToImage: String
)