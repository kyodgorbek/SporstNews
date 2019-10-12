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
import yodgorbek.komilov.musobaqayangiliklari.adapter.BBCSportAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse

class BBCSportFragment : Fragment() {

    private val listViewType: List<Int> = listOf()

    var bbcSportAdapter : BBCSportAdapter? = null




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sport_bbc, container, false)



        val recyclerView = view.findViewById (R.id.recyclerView) as RecyclerView
        bbcSportAdapter = BBCSportAdapter(recyclerView.context, listViewType)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = bbcSportAdapter


        val apiInterface = SportNewsInterface.create().getBBCSport()

// Getting interface
        apiInterface.enqueue(object : Callback<SportNewsResponse> {
            override fun onResponse(
                call: Call<SportNewsResponse>?,
                response: Response<SportNewsResponse>?
            ) {

                if (response!!.body() != null) {
                    bbcSportAdapter!!.setMovieListItems(response.body()!!.articles)
                }
            }

            override fun onFailure(call: Call<SportNewsResponse>?, t: Throwable?) {

            }
        })


        return view
    }

}