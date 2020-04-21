package yodgorbek.komilov.musobaqayangiliklari.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository
import yodgorbek.komilov.musobaqayangiliklari.utils.Results


import kotlin.coroutines.CoroutineContext




@Suppress("UNCHECKED_CAST")
class MainViewModel(val newsRepository: NewsRepository) : ViewModel(), CoroutineScope {
    // Coroutine's background job
    val job = Job()
    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val _showLoading = MutableLiveData<Boolean>()
    private val _sportList = MutableLiveData<Results>()

    val showLoading: LiveData<Boolean>
        get() = _showLoading

    val sportList: LiveData<Results>
        get() = _sportList


    fun loadNews() {
// Show progressBar during the operation on the MAIN (default) thread
        _showLoading.value = true
// launch the Coroutine
        launch {
            // Switching from MAIN to IO thread for API operation
// Update our data list with the new one from API
            val result = withContext(Dispatchers.IO) {
                newsRepository.refresh()
            }
            _sportList.value = result
            _showLoading.value = false
        }
    }

    override fun onCleared() {
        job.cancel()
    }

}
