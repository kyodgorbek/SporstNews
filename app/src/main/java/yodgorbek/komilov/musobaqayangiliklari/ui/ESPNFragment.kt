package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Deferred
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.SingleLiveEvent
import yodgorbek.komilov.musobaqayangiliklari.adapter.ESPNAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.utils.UseCaseResult
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.ESPNViewModel


@Suppress("UNREACHABLE_CODE")
class ESPNFragment : Fragment() {
    lateinit var viewModel: ESPNViewModel
    var espnAdapter: ESPNAdapter? = null
    val showError = SingleLiveEvent<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_espn, container, false)

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val pb = view.findViewById(R.id.pb) as ProgressBar
      //  viewModel = ViewModelProviders.of(this).get(ESPNViewModel::class.java)
        espnAdapter = ESPNAdapter(recyclerView.context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = espnAdapter
        return view

//        viewModel.loadNews(viewLifecycleOwner, Observer { result ->
//            when (result) {
//                is UseCaseResult.Success<*> -> {
//                    pb.visibility = View.GONE
//                    result.data as List<Deferred<SportNewsResponse>>
//
//                    espnAdapter?.articleList
//
//                }
//
//                is Error -> {
//                    showError.value = result.message
//                    pb.visibility = View.GONE
//
//
//                }
//
//
//            }
//        })
//    }
//

    }

}
