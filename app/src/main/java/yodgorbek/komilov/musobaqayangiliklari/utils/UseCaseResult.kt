package yodgorbek.komilov.musobaqayangiliklari.utils

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse

sealed class UseCaseResult<out T : Any>(t: Any?) {
    class Success<out T : Any>(val data: T) : UseCaseResult<List<SportNewsResponse>>(T)

    class Error(val exception: Throwable) : UseCaseResult<Nothing>(T)
}