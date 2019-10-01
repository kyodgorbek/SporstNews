package yodgorbek.komilov.musobaqayangiliklari.internet

data class SportNewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)