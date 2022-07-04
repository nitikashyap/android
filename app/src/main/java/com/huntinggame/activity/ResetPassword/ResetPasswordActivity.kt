package com.huntinggame.activity.ResetPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.SignUp.SignUpActivity
import com.huntinggame.activity.Verify.VerifyActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity :BaseActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()
        initControl()
        myObserver()
    }
    override fun init() {

    }

    override fun initControl() {
        ivContinueReset.setOnClickListener(this)
        reset_constraint_layout.setOnClickListener(this)

    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.ivContinueReset ->{
                startActivity(Intent(this,VerifyActivity::class.java))
            }
            R.id.reset_constraint_layout->{
                startActivity(Intent(this,SignUpActivity::class.java))
            }
        }
    }
}