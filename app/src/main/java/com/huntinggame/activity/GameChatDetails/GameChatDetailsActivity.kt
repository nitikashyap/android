package com.huntinggame.activity.GameChatDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.huntinggame.R
import com.huntinggame.databinding.ActivityGameChatDetailsBinding

class GameChatDetailsActivity : AppCompatActivity() {
    lateinit var bin:ActivityGameChatDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityGameChatDetailsBinding.inflate(layoutInflater)
        setContentView(bin.root)
        initView()
        lstnr()
    }

    private fun initView() {
        bin.gamechatDetailsToolbar.tvName.text = "GAME CHAT"
        bin.gamechatDetailsToolbar.ivBackImg.visibility = View.VISIBLE

    }

    private fun lstnr() {
        bin.gamechatDetailsToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
    }
}