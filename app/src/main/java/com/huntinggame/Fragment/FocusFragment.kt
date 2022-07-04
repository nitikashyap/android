package com.huntinggame.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huntinggame.R
import com.huntinggame.databinding.FragmentFocusBinding


class FocusFragment : Fragment() {
    lateinit var bin: FragmentFocusBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bin = FragmentFocusBinding.inflate(layoutInflater)
        initView()
        lstnr()
        return bin.root
    }

    private fun initView() {

    }
var click:Boolean=true
    private fun lstnr() {
        bin.imageView7.setOnClickListener {
            if (click) {
//                bin.viewFinder.visibility = View.GONE
                bin.bg.visibility = View.VISIBLE
                click = false

            } else {
                click= true
                bin.bg.visibility = View.GONE
            }
        }
//        bin.viewFinder1.setOnClickListener {
//            if (bin.viewFinder1.visibility == View.VISIBLE){
//                bin.viewFinder.visibility = View.VISIBLE
//                bin.viewFinder1.visibility = View.GONE
//
//            }
//        }

    }


}