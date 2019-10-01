 package yodgorbek.komilov.musobaqayangiliklari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yodgorbek.komilov.musobaqayangiliklari.adapter.SportNewsAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.Article
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface

 class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var sportNewsAdapter: SportNewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        sportNewsAdapter = SportNewsAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = sportNewsAdapter


        val apiInterface = SportNewsInterface.create().getNews()


        apiInterface.enqueue( object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>?, response: Response<List<Article>>?) {
                Log.d("onSuccess", response.toString())
                if(response?.body() != null)
                    sportNewsAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Article>>?, t: Throwable?) {
                Log.d("onFailure", t!!.message)
            }
        })
    }
    }

