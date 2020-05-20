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
import yodgorbek.komilov.musobaqayangiliklari.utils.PreferencesManager


class WelcomeActivity : AppIntro() {



    var manager: PreferencesManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        manager = PreferencesManager(applicationContext)

        if (manager?.isFirstRun()!!) {
            showIntroSlides()
        } else {
            goToMain()
        }
    }

        // Call addSlide passing your Fragments.

        // You can use AppIntroFragment to use a pre-built fragment

       private fun showIntroSlides() {
           manager?.setFirstRun()

            addSlide(
                AppIntroFragment.newInstance(
                        title = "Welcome to the NewsApp",
                description = "NewsApp give your information about life news around the world",
                imageDrawable = R.drawable.news,
                backgroundDrawable = R.drawable.news_slider,
                titleColor = Color.YELLOW,
                descriptionColor = Color.RED,
                backgroundColor = Color.BLUE,
                titleTypefaceFontRes = R.font.opensans_light,
                descriptionTypefaceFontRes = R.font.opensans_regular
            )
            )

           addSlide(
               AppIntroFragment.newInstance(
                   title = "Welcome to the NewsApp",
                   description = "NewsApp give your information about life news around the world",
                   imageDrawable = R.drawable.news,
                   backgroundDrawable = R.drawable.news_slider,
                   titleColor = Color.YELLOW,
                   descriptionColor = Color.RED,
                   backgroundColor = Color.BLUE,
                   titleTypefaceFontRes = R.font.opensans_light,
                   descriptionTypefaceFontRes = R.font.opensans_regular
               )
           )
           addSlide(
               AppIntroFragment.newInstance(
                   title = "Welcome to the NewsApp",
                   description = "NewsApp give your information about life news around the world",
                   imageDrawable = R.drawable.news,
                   backgroundDrawable = R.drawable.news_slider,
                   titleColor = Color.YELLOW,
                   descriptionColor = Color.RED,
                   backgroundColor = Color.BLUE,
                   titleTypefaceFontRes = R.font.opensans_light,
                   descriptionTypefaceFontRes = R.font.opensans_regular
               )
           )

           addSlide(
               AppIntroFragment.newInstance(
                   title = "Welcome to the NewsApp",
                   description = "NewsApp give your information about life news around the world",
                   imageDrawable = R.drawable.news,
                   backgroundDrawable = R.drawable.news_slider,
                   titleColor = Color.YELLOW,
                   descriptionColor = Color.RED,
                   backgroundColor = Color.BLUE,
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