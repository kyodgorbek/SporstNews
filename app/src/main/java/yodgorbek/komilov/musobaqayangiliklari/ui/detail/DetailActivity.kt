package yodgorbek.komilov.musobaqayangiliklari.ui.detail


import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


import androidx.appcompat.widget.Toolbar
import com.github.florent37.shapeofview.shapes.DiagonalView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

import yodgorbek.komilov.musobaqayangiliklari.R


class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val webView = findViewById<WebView>(R.id.article)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar?.setNavigationIcon(R.drawable.ic_arrow_white)
        val url = intent.extras?.getString("urlKey")


        webView?.webViewClient = WebViewClient()

        webView?.loadUrl(url)


    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    inner class WebViewController : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true


        }
    }
}