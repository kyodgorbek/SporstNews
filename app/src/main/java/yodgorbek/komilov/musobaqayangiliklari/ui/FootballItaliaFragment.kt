package yodgorbek.komilov.musobaqayangiliklari.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import yodgorbek.komilov.musobaqayangiliklari.R

class FootballItaliaFragment : Fragment() {


    companion object {

        fun newInstance(): FootballItaliaFragment {
            return FootballItaliaFragment()
        }
    }

    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =  return inflater.inflate(R.layout.fragment_football_italia, container, false)

     return view
    }

}