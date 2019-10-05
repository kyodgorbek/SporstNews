package yodgorbek.komilov.musobaqayangiliklari.adapter


import androidx.fragment.app.FragmentManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import yodgorbek.komilov.musobaqayangiliklari.ui.ESPNFragment
import yodgorbek.komilov.musobaqayangiliklari.ui.TopHeadlinesFragment

class NewsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {



    override fun getItem(position: Int): Fragment {

        return when (position) {

            0 -> {

                TopHeadlinesFragment()

            }

            else -> {

                return  ESPNFragment()

            }

        }

    }



    override fun getCount(): Int {

        return 2

    }



    override fun getPageTitle(position: Int): CharSequence {

        return when (position) {

            0 -> "TopHeadlines"

            else -> {

                return ""

            }

        }

    }

}