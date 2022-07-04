package com.huntinggame.activity.Verify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.CodeVerification.CodeVerificationActivity
import com.huntinggame.activity.SignUp.SignUpActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_verify.*

class VerifyActivity : BaseActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)
        init()
        initControl()
        myObserver()
    }

    override fun init() {

    }

    override fun initControl() {
        ivVerify.setOnClickListener(this)
        constraintLayout1.setOnClickListener(this)


    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.ivVerify->{
               startActivity(Intent(this,CodeVerificationActivity::class.java))
           }
           R.id.constraintLayout1->{
               startActivity(Intent(this,SignUpActivity::class.java))
           }
       }
    }
}