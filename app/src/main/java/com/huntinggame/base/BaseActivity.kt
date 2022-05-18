package com.huntinggame.base


import androidx.appcompat.app.AppCompatActivity

import com.huntinggame.utils.SharedPreferenceUtil

abstract class BaseActivity:AppCompatActivity(){
    val prefs: SharedPreferenceUtil by lazy { SharedPreferenceUtil.getInstance(applicationContext)}
    abstract fun init()
    abstract fun initControl()
    abstract fun myObserver()
    }
