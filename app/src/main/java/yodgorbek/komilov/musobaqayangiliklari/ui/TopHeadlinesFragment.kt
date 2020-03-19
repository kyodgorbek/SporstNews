package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_top_headlines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import yodgorbek.komilov.musobaqayangiliklari.databinding.FragmentTopHeadlinesBinding
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.MainViewModel


class TopHeadlinesFragment : Fragment() {

    private lateinit var binding: FragmentTopHeadlinesBinding
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var topHeadlinesAdapter: TopHeadlinesAdapter
    // private val newsRepository: NewsRepository by inject()



    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_headlines,container,false)
        binding.lifecycleOwner = this
        topHeadlinesAdapter = TopHeadlinesAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.sportList.observe(this, Observer { newList ->
            topHeadlinesAdapter.updateData(newList)
            binding.recyclerView.adapter = topHeadlinesAdapter
            topHeadlinesAdapter.notifyDataSetChanged()
        })

        viewModel.showLoading.observe(this, Observer { showLoading ->
            pb.visibility = if (showLoading) View.VISIBLE else View.GONE
        })

        viewModel.showError.observe(this, Observer { showError ->
            (showError)
        })

        viewModel.loadNews()
    }
}