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

import yodgorbek.komilov.musobaqayangiliklari.adapter.ESPNAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse

@Suppress("UNREACHABLE_CODE")
class ESPNFragment : Fragment() {

    var espnAdapter : ESPNAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =  inflater.inflate(R.layout.fragment_espn, container, false)

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        espnAdapter = ESPNAdapter(recyclerView.context)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = espnAdapter


        val apiInterface = SportNewsInterface.create().getEspn()


        apiInterface.enqueue(object : Callback<SportNewsResponse> {
            override fun onResponse(
                call: Call<SportNewsResponse>?,
                response: Response<SportNewsResponse>?
            ) {

                if (response!!.body() != null) {
                    espnAdapter!!.setMovieListItems(response.body()!!.articles)
                }
            }

            override fun onFailure(call: Call<SportNewsResponse>?, t: Throwable?) {

            }
        })


        return view

    }

}