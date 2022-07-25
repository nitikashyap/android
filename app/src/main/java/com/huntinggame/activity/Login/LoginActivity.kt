package com.huntinggame.activity.Login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.huntinggame.Modal.Login
import com.huntinggame.R
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.activity.ResetPassword.ResetPasswordActivity
import com.huntinggame.activity.SignUp.SignUpActivity
import com.huntinggame.base.BaseActivity
import com.huntinggame.utils.api.ApiInterface
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity(), View.OnClickListener {
    var call: Call<Login>? = null
    var mProgressDialog:ProgressBar?=null

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
        tvGuest.setOnClickListener(this)


    }

    override fun myObserver() {

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.ivLogin -> {
                startActivity(Intent(this, MainActivity::class.java))

            }
            R.id.tvForgetPassword -> {
                startActivity(Intent(this, ResetPasswordActivity::class.java))
            }
            R.id.constraintLayout1 -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            R.id.tvGuest -> {
                //startActivity(Intent(this, GuestLoginActivity::class.java))
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("himanshu",true)
                startActivity(intent)

            }
        }
    }

  /*  private fun loginApi() {
        val email=edEmail.text.toString()
        val password=edPassword.text.toString()
        showLoading("Progressing....")


        call= getClient().create(ApiInterface::class.java).login(email,password)
        call!!.enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if (response.isSuccessful()) {
                    hideLoading()
                    try {
                        if (response.body()!!.getResponseCode() === SharedPrefsKey.SUCCESS_CODE) {
                            SharedPreferenceWriter.getInstance(applicationContext).clearAllData()
                          *//*  SharedPreferenceWriter.getInstance(applicationContext)
                                .saveLoginUserDetails(response.body().getData(), true)*//*
                           // openHomeScreen()
                            finish()
                        } else {
                           *//* showToast(
                                applicationContext,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT
                            )*//*
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
               // showToast(applicationContext, t.message, Toast.LENGTH_SHORT)
                hideLoading()
            }
        })

    }*/


    fun showLoading(message: String) {
      /*  mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage(message)
        mProgressDialog.setIndeterminate(true)
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        mProgressDialog.setCancelable(false)
        mProgressDialog.show()*/
    }

    fun hideLoading() {
       /* if (mProgressDialog != null) {
            mProgressDialog.dismiss()
        }*/
    }
}