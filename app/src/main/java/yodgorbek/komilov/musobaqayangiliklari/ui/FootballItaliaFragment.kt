package yodgorbek.komilov.musobaqayangiliklari.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.adapter.ESPNAdapter

import yodgorbek.komilov.musobaqayangiliklari.adapter.FootballItaliaAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse

class FootballItaliaFragment : Fragment() {

    private var footballItaliaAdapter : FootballItaliaAdapter? = null



    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =   inflater.inflate(R.layout.fragment_football_italia, container, false)



        val recyclerView = view.findViewById (R.id.recyclerView) as RecyclerView
        val pb = view.findViewById(R.id.pb) as ProgressBar

        GlobalScope.launch(Dispatchers.Main) {
            val request = SportNewsInterface.create().getFootballItalia()
            val response = request.await()

            pb.visibility = View.GONE
            response.body()?.let {
                footballItaliaAdapter = FootballItaliaAdapter(recyclerView.context)

                recyclerView.layoutManager = LinearLayoutManager(context)

                recyclerView.adapter = footballItaliaAdapter

                footballItaliaAdapter?.setMovieListItems(response.body()!!.articles)
            }

        }
        return view
    }

}

