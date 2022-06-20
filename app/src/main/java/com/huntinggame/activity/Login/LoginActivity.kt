package com.huntinggame.activity.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.ResetPassword.ResetPasswordActivity
import com.huntinggame.activity.SignUp.SignUpActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        initControl()
        myObserver()
    }
    override fun init() {

    }

    override fun initControl() {
        ivLogin.setOnClickListener(this)
        tvForgetPassword.setOnClickListener(this)
        constraintLayout1.setOnClickListener(this)


    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.ivLogin ->{
                startActivity(Intent(this,SignUpActivity::class.java))
            }
            R.id.tvForgetPassword ->{
                startActivity(Intent(this,ResetPasswordActivity::class.java))
            }
            R.id.constraintLayout1 ->{
                startActivity(Intent(this,SignUpActivity::class.java))
            }
        }
    }
}