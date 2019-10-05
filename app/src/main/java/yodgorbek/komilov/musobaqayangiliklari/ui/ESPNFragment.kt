package yodgorbek.komilov.musobaqayangiliklari.ui

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import yodgorbek.komilov.musobaqayangiliklari.R

class ESPNFragment : Fragment() {

    //2
    companion object {

        fun newInstance(): ESPNFragment {
            return ESPNFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_espn, container, false)
    }

}