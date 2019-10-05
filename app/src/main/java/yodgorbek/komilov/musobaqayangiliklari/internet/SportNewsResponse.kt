package yodgorbek.komilov.musobaqayangiliklari.internet

import yodgorbek.komilov.musobaqayangiliklari.model.Article

data class SportNewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)