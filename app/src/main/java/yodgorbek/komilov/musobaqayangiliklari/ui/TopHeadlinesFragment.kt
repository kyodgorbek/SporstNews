package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse

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
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = topHeadlinesAdapter


        val apiInterface = SportNewsInterface.create().getNews()


        apiInterface.enqueue(object : Callback<SportNewsResponse> {
            override fun onResponse(
                call: Call<SportNewsResponse>?,
                response: Response<SportNewsResponse>?
            ) {

                if (response!!.body() != null) topHeadlinesAdapter!!.setMovieListItems(response.body()!!.articles)
            }

            override fun onFailure(call: Call<SportNewsResponse>?, t: Throwable?) {

            }
        })
        return view

    }



}





