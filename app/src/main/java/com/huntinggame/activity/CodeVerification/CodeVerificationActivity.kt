package com.huntinggame.activity.CodeVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_code_verification.*

class CodeVerificationActivity : BaseActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_verification)
        init()
        initControl()
        myObserver()
    }
    override fun init() {

    }

    override fun initControl() {
        ivContinueCode.setOnClickListener(this)

    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.ivContinueCode->{
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}