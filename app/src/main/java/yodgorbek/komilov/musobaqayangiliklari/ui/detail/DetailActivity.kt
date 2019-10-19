package yodgorbek.komilov.musobaqayangiliklari.ui.detail


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import androidx.appcompat.widget.Toolbar
import yodgorbek.komilov.musobaqayangiliklari.R


class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


    }

}