package com.huntinggame.activity.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.huntinggame.R
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.activity.PlayScreen.PlayScreen
import com.huntinggame.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var bin :ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bin.root)
        Handler().postDelayed(
            {

                startActivity(Intent(this, PlayScreen::class.java))
                finish()

            }, 3000
        )

    }
}