package yodgorbek.komilov.musobaqayangiliklari.viewmodel

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.verify
import kotlinx.android.synthetic.main.fragment_top_headlines.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

import org.mockito.Mock
import org.mockito.MockitoAnnotations
import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter


import yodgorbek.komilov.musobaqayangiliklari.databinding.FragmentTopHeadlinesBinding
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository

import yodgorbek.komilov.musobaqayangiliklari.utils.Results

import yodgorbek.komilov.musobaqayangiliklari.utils.TestCoroutineRule
import kotlin.coroutines.CoroutineContext


class MainViewModelTest{

    private  var binding: FragmentTopHeadlinesBinding? = null
    private lateinit var topHeadlinesAdapter: TopHeadlinesAdapter
    private  var newsRepository: NewsRepository? = null
    private lateinit var  pb:ProgressBar
    private lateinit var lifecycleOwner:LifecycleOwner
    private lateinit var article: Article


    private val _showLoading = MutableLiveData<Boolean>()
    private val _sportList = MutableLiveData<Results>()
    val job = Job()

    // Define default thread for Coroutine as Main and add job
     val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val showLoading: LiveData<Boolean>
        get() = _showLoading

    val sportList: LiveData<Results>
        get() = _sportList
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private var sportNewsApi:SportNewsInterface? = null

    @Mock
    private lateinit var apiUsersObserver: Observer <Article>

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }




    @ExperimentalCoroutinesApi
    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess_invokeSuspend() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<Article>())
                .`when`(sportNewsApi)
                ?.getNewsAsync()
            val viewModel = newsRepository?.let { MainViewModel(it) }
            binding?.lifecycleOwner = lifecycleOwner
            topHeadlinesAdapter = TopHeadlinesAdapter()

            viewModel?.sportList?.observe(lifecycleOwner, Observer { result ->

                when (result) {
                    is Results.Success -> {
                        val newList = result.data
                        if (newList != null) {
                            topHeadlinesAdapter.updateData(newList)
                        }
                        binding?.recyclerView?.adapter = topHeadlinesAdapter
                        topHeadlinesAdapter.notifyDataSetChanged()

                        viewModel.showLoading.observe(lifecycleOwner, Observer { showLoading ->
                            pb.visibility = if (showLoading) View.VISIBLE else View.GONE
                            verify(sportNewsApi)
                            verify(apiUsersObserver).onChanged(article)

                            //verify(apiUsersObserver)


                        })
                    }


                }


            })
        }
    }



    @After
    fun tearDown() {
        // do something if required
    }
}















