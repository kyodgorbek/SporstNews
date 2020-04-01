package yodgorbek.komilov.musobaqayangiliklari.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import yodgorbek.komilov.musobaqayangiliklari.SingleLiveEvent
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository
import yodgorbek.komilov.musobaqayangiliklari.utils.LoadingState
import kotlin.coroutines.CoroutineContext


@Suppress("UNCHECKED_CAST")
class MainViewModel(val newsRepository: NewsRepository) : ViewModel(), CoroutineScope {
    // Coroutine's background job
    val job = Job()
    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val showLoading = MutableLiveData<Boolean>()
    val sportList = MutableLiveData<List<Article>>()
    val showError = SingleLiveEvent<String>()

    fun loadNews() {
        // Show progressBar during the operation on the MAIN (default) thread
        showLoading.value = true
        // launch the Coroutine
        launch {
            // Switching from MAIN to IO thread for API operation
            // Update our data list with the new one from API
            val result = withContext(Dispatchers.IO) {
                newsRepository?.data
                newsRepository.refresh()
            }
        }
    }
}
            // Hide progressBar once the operation is done on the MAIN (default) thread
//            showLoading.value = false
//            when (result) {
//
//                is LoadingState.Status {
//                    sportList.value = result.as List < Article >
//                }
//                is Error -> showError.value = result.message
//            }
//        }
//    }

//    override fun onCleared() {
//        super.onCleared()
//        // Clear our job when the linked activity is destroyed to avoid memory leaks
//        job.cancel()
//    }
//}

