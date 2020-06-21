package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_sport_bbc.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.adapter.BBCSportAdapter

import yodgorbek.komilov.musobaqayangiliklari.viewmodel.BBCSportViewModel


class BBCSportFragment : Fragment() {


    private val viewModel by viewModel<BBCSportViewModel>()
    private lateinit var bbcSportAdapter: BBCSportAdapter


    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =inflater.inflate( R.layout.fragment_sport_bbc, container, false)

        bbcSportAdapter = BBCSportAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.sportList.observe(this, Observer { newList ->
            bbcSportAdapter.updateData(newList)
            recyclerView.adapter = bbcSportAdapter
            bbcSportAdapter.notifyDataSetChanged()
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