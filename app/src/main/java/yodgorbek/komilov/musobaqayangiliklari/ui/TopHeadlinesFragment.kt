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


import yodgorbek.komilov.musobaqayangiliklari.R

import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface


class TopHeadlinesFragment : Fragment() {


    var topHeadlinesAdapter: TopHeadlinesAdapter? = null

    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(
            R.layout.fragment_top_headlines
            , container, false
        )

       val recyclerView = view.findViewById (R.id.recyclerView) as RecyclerView
        val pb = view.findViewById(R.id.pb) as ProgressBar

        GlobalScope.launch(Dispatchers.Main) {
            val request = SportNewsInterface.create().getEspn()
            val response = request.await()

            pb.visibility = View.GONE
            response.body()?.let {
                topHeadlinesAdapter = TopHeadlinesAdapter(recyclerView.context)

                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = topHeadlinesAdapter

                topHeadlinesAdapter!!.setMovieListItems(response.body()!!.articles)
            }

        }
        return view
    }

}






