package yodgorbek.komilov.musobaqayangiliklari.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import yodgorbek.komilov.musobaqayangiliklari.R

class SliderActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        val imageList = ArrayList<SlideModel>()
        imageList.add(
            SlideModel(R.drawable.news, "Follow live news")
        )
        imageList.add(
            SlideModel(R.drawable.news_slider, "Follow live news")
        )
        imageList.add(
            SlideModel(R.drawable.news, "Follow live news")
        )


        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

    }
}