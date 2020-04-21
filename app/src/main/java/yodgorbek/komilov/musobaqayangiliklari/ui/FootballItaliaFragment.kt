package yodgorbek.komilov.musobaqayangiliklari.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import kotlinx.android.synthetic.main.fragment_sport_bbc.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import yodgorbek.komilov.musobaqayangiliklari.R

import yodgorbek.komilov.musobaqayangiliklari.adapter.FootballItaliaAdapter

import yodgorbek.komilov.musobaqayangiliklari.databinding.FragmentFootballItaliaBinding

import yodgorbek.komilov.musobaqayangiliklari.viewmodel.FootballItaliaViewModel

class FootballItaliaFragment : Fragment() {

    private lateinit var binding: FragmentFootballItaliaBinding
    private val viewModel by viewModel<FootballItaliaViewModel>()
    private lateinit var footballItaliaAdapter: FootballItaliaAdapter


    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_football_italia, container, false)
        binding.lifecycleOwner = this
        footballItaliaAdapter = FootballItaliaAdapter()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.sportList.observe(this, Observer { newList ->
            footballItaliaAdapter.updateData(newList)
            binding.recyclerView.adapter = footballItaliaAdapter

            footballItaliaAdapter.notifyDataSetChanged()
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