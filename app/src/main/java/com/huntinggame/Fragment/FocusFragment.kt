package com.huntinggame.Fragment

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.huntinggame.databinding.FragmentFocusBinding


class FocusFragment : Fragment() {
    lateinit var bin: FragmentFocusBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        bin = FragmentFocusBinding.inflate(layoutInflater)
        initView()
        lstnr()
        return bin.root
    }

    /* override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE || newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            try {
                val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
                if (Build.VERSION.SDK_INT >= 26) {
                    ft.setReorderingAllowed(false)
                }
                ft.detach(this).attach(this).commit()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
*/


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