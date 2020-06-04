package yodgorbek.komilov.musobaqayangiliklari.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

import yodgorbek.komilov.musobaqayangiliklari.MainActivity
import yodgorbek.komilov.musobaqayangiliklari.R


class WelcomeActivity : AppIntro() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showIntroSlides()
    }

    // Call addSlide passing your Fragments.

    // You can use AppIntroFragment to use a pre-built fragment

    private fun showIntroSlides() {

        addSlide(
            AppIntroFragment.newInstance(
                title = "Welcome to the Sport News",
                description = "Sport News give  news information about around the world",
                imageDrawable = R.drawable.news_slider,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.BLUE,
                titleTypefaceFontRes = R.font.opensans_light,
                descriptionTypefaceFontRes = R.font.opensans_regular
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                title = "Sport News",
                description = "Sport News give live updated news and you will never miss your favorite news ",
                imageDrawable = R.drawable.news_sliders,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.GREEN,
                titleTypefaceFontRes = R.font.opensans_light,
                descriptionTypefaceFontRes = R.font.opensans_regular
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = "Sport News",
                description = "Live Updates Sport and Opinion",
                imageDrawable = R.drawable.sports_news,
                titleColor = Color.WHITE,
                descriptionColor = Color.RED,
                backgroundColor = Color.YELLOW,
                titleTypefaceFontRes = R.font.opensans_light,
                descriptionTypefaceFontRes = R.font.opensans_regular
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                title = "Sport News",
                description = "The News That Matters from Trusted Sources",
                imageDrawable = R.drawable.news,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.RED,
                titleTypefaceFontRes = R.font.opensans_light,
                descriptionTypefaceFontRes = R.font.opensans_regular
            )
        )

    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        goToMain()


    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        goToMain()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        Log.d("Hello", "Changed")
    }
}