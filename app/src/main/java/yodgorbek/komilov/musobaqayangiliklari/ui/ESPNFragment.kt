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
import yodgorbek.komilov.musobaqayangiliklari.adapter.ESPNAdapter
import yodgorbek.komilov.musobaqayangiliklari.databinding.FragmentEspnBinding
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.ESPNViewModel


class ESPNFragment : Fragment() {

    private lateinit var binding: FragmentEspnBinding
    private val viewModel by viewModel<ESPNViewModel>()
    private lateinit var espnAdapter: ESPNAdapter


    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_espn, container, false)
        binding.lifecycleOwner = this
        espnAdapter = ESPNAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.sportList.observe(this, Observer { newList ->
            espnAdapter.updateData(newList)
            binding.recyclerView.adapter = espnAdapter
            espnAdapter.notifyDataSetChanged()
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