package com.huntinggame.activity.Gest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huntinggame.R
import com.huntinggame.activity.Login.LoginActivity
import com.huntinggame.databinding.ActivityGuestLoginBinding

class GuestLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityGuestLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        lstnr()
    }

    private fun initView() {

    }

    private fun lstnr() {
       binding.imageView45.setOnClickListener {
           startActivity(Intent(this,LoginActivity::class.java))
       }
    }
}