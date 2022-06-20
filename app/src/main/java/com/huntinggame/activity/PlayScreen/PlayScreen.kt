package com.huntinggame.activity.PlayScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.Login.LoginActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_play_screen.*

class PlayScreen : BaseActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_screen)
        init()
        initControl()
        myObserver()
    }
    override fun init() {

    }

    override fun initControl() {
        ivPlay.setOnClickListener(this)

    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.ivPlay ->{
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}