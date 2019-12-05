package yodgorbek.komilov.musobaqayangiliklari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

import yodgorbek.komilov.musobaqayangiliklari.ui.BBCSportFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.ESPNFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.FootballItaliaFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.TopHeadlinesFragment

class MainActivity : AppCompatActivity() {

    var selectedFragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom)

        selectedFragment = TopHeadlinesFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, selectedFragment)
        transaction.commit()

        selectedFragment = BBCSportFragment()

        val bbcTransaction = supportFragmentManager.beginTransaction()
        bbcTransaction.replace(R.id.frame_layout, selectedFragment)
        bbcTransaction.commit()

        selectedFragment = ESPNFragment()

        val espnTransaction = supportFragmentManager.beginTransaction()
        espnTransaction.replace(R.id.frame_layout, selectedFragment)
        espnTransaction.commit()

        selectedFragment = FootballItaliaFragment()
        val footballItaliaTransaction = supportFragmentManager.beginTransaction()
        footballItaliaTransaction.replace(R.id.frame_layout, selectedFragment)
        footballItaliaTransaction.commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {

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
