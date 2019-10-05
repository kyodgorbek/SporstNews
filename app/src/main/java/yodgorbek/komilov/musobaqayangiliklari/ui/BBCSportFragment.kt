package yodgorbek.komilov.musobaqayangiliklari.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import yodgorbek.komilov.musobaqayangiliklari.R

class BBCSportFragment : Fragment() {


    companion object {

        fun newInstance(): BBCSportFragment {
            return BBCSportFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sport_bbc, container, false)
    }

}