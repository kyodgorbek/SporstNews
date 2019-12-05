package yodgorbek.komilov.musobaqayangiliklari.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import yodgorbek.komilov.musobaqayangiliklari.SingleLiveEvent
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult
import kotlin.coroutines.CoroutineContext

class FootballItaliaViewModel(private val sportNewsInterface: SportNewsInterface

) : ViewModel(), CoroutineScope {
    private val job = Job()
    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val showLoading = MutableLiveData<Boolean>()
    private val sportList = MutableLiveData<List<Deferred<SportNewsResponse>>>()
    val showError = SingleLiveEvent<String>()

    fun loadNews() {
        // Show progressBar during the operation on the MAIN (default) thread
        showLoading.value = true
        // launch the Coroutine
        launch {
            // Switching from MAIN to IO thread for API operation
            // Update our data list with the new one from API
            val result = withContext(Dispatchers.IO) {
                sportNewsInterface.getBBCSport()
            }
            // Hide progressBar once the operation is done on the MAIN (default) thread
            showLoading.value = false
            when (result) {

                is UseCaseResult.Success<*> -> {
                    sportList.value = result.data as List<Deferred<SportNewsResponse>>
                }
                is Error -> showError.value = result.message
            }
        }


    }

    override fun onCleared() {
        super.onCleared()
        // Clear our job when the linked activity is destroyed to avoid memory leaks
        job.cancel()
    }
}
