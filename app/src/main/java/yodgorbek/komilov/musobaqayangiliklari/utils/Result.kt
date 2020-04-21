package yodgorbek.komilov.musobaqayangiliklari.utils

import yodgorbek.komilov.musobaqayangiliklari.model.Article

sealed class Results {
    data class Success(val data: List<Article>?) : Results()
    data class Failure(val exception: String) : Results()
}