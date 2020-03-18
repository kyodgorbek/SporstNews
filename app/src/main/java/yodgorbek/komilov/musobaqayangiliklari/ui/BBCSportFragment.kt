package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Deferred
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.SingleLiveEvent
import yodgorbek.komilov.musobaqayangiliklari.adapter.BBCSportAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.viewmodel.BBCSportViewModel


class BBCSportFragment : Fragment() {


    lateinit var viewModel: BBCSportViewModel

    var bbcSportAdapter: BBCSportAdapter? = null
    private val sportList = MutableLiveData<List<Deferred<SportNewsResponse>>>()
    val showError = SingleLiveEvent<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sport_bbc, container, false)
        //    viewModel = ViewModelProviders.of(this).get(BBCSportViewModel::class.java)


        val recyclerView = view.findViewById(R.id.recycler_View) as RecyclerView

        val pb = view.findViewById(R.id.pb) as ProgressBar
        bbcSportAdapter = BBCSportAdapter(recyclerView.context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = bbcSportAdapter
        return view
//        viewModel.loadNews(viewLifecycleOwner, Observer { result ->
//            when (result) {
//                is UseCaseResult.Success<*> -> {
//                    pb.visibility = View.GONE
//                    result.data as List<Deferred<SportNewsResponse>>
//
//                    bbcSportAdapter?.articleList
//
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
    }

}
