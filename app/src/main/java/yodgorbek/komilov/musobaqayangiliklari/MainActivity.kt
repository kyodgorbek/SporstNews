package yodgorbek.komilov.musobaqayangiliklari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsInterface
import yodgorbek.komilov.musobaqayangiliklari.internet.SportNewsResponse
import yodgorbek.komilov.musobaqayangiliklari.ui.BBCSportFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.ESPNFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.FootballItaliaFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.TopHeadlinesFragment

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val  bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom)



        bottomNavigationView.setOnNavigationItemSelectedListener {

            var selectedFragment = Fragment()
            when (it.itemId) {
                R.id.top_headline -> selectedFragment = TopHeadlinesFragment()

                R.id.espn_news -> selectedFragment = ESPNFragment()
                R.id.bbc_sport -> selectedFragment = BBCSportFragment()
                R.id.football_italia -> selectedFragment = FootballItaliaFragment()
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, selectedFragment)
            transaction.commit()
            return@setOnNavigationItemSelectedListener true

        }
    }
}
