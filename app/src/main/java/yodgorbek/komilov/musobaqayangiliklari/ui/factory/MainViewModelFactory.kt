package yodgorbek.komilov.musobaqayangiliklari.ui.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel


class MainViewModelFactory(
    private val someParameter: NewsRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(someParameter) as T
    }
}