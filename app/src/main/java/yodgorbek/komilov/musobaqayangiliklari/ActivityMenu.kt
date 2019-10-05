package yodgorbek.komilov.musobaqayangiliklari


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


import com.google.android.material.bottomnavigation.BottomNavigationView
import yodgorbek.komilov.musobaqayangiliklari.ui.BBCSportFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.ESPNFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.TopHeadlinesFragment



class ActivityMenu : AppCompatActivity(){
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu)

    lateinit var  bottomNavigationView: BottomNavigationView

    bottomNavigationView.inflateMenu(R.menu.bottomnews_nav)


    bottomNavigationView.setOnNavigationItemSelectedListener {

                var selectedFragment = Fragment()
            when (it.itemId) {
                R.id.top_headline -> selectedFragment = TopHeadlinesFragment()
                R.id.espn_news -> selectedFragment = ESPNFragment()
                R.id.bbc_sport -> selectedFragment = BBCSportFragment()
            }
                val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, selectedFragment)
                    transaction.commit()
                return@setOnNavigationItemSelectedListener true

        }
}
}