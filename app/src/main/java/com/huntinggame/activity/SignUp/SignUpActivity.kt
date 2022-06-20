package com.huntinggame.activity.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.activity.Login.LoginActivity
import com.huntinggame.activity.ResetPassword.ResetPasswordActivity
import com.huntinggame.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
        initControl()
        myObserver()
    }

    override fun init() {

    }

    override fun initControl() {
        ivSignUp.setOnClickListener(this)
        tvForgetPassword.setOnClickListener(this)
        constraintLayout1.setOnClickListener(this)
    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.ivSignUp -> {
                // startActivity(Intent(this,ResetPasswordActivity::class.java))
            }
            R.id.tvForgetPassword -> {
                startActivity(Intent(this, ResetPasswordActivity::class.java))
            }
            R.id.constraintLayout1 ->{
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

}