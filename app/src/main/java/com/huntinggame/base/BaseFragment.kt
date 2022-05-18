package com.huntinggame.base

import androidx.fragment.app.Fragment
import com.huntinggame.utils.SharedPreferenceUtil

abstract class BaseFragment: Fragment() {
    val prefs: SharedPreferenceUtil by lazy { SharedPreferenceUtil.getInstance(requireActivity()) }
    abstract fun init()
    abstract fun initControl()
    abstract fun myObserver()
}