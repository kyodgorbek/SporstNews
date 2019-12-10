package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_top_headlines.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

import yodgorbek.komilov.musobaqayangiliklari.R

import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import yodgorbek.komilov.musobaqayangiliklari.repository.NewsRepository



import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel



class TopHeadlinesFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var topHeadlinesAdapter: TopHeadlinesAdapter
   // private   val newsRepository: NewsRepository by inject()



    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_top_headlines
            , container, false
        )


        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val pb = view.findViewById(R.id.pb) as ProgressBar
        topHeadlinesAdapter = TopHeadlinesAdapter(recyclerView.context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = topHeadlinesAdapter
        initViewModel()

        return view
    }

    private fun initViewModel() {
        viewModel?.sportList?.observe(this, Observer { newList ->
            topHeadlinesAdapter.updateData(newList)
        })

        viewModel?.showLoading?.observe(this, Observer { showLoading ->
            pb.visibility = if (showLoading) View.VISIBLE else View.GONE
        })

        viewModel?.showError?.observe(this, Observer { showError ->
            (showError)
        })

        viewModel?.loadNews()
    }
}


