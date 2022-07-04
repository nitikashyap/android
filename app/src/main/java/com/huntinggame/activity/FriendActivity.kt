package com.huntinggame.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.FriendAdapter
import com.huntinggame.R
import com.huntinggame.databinding.ActivityFriendBinding

class FriendActivity : AppCompatActivity() {
   lateinit var binding: ActivityFriendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        lstnr()
    }

    private fun initView() {
        binding.friendToolbar.tvName.text ="FRIENDS"
        binding.friendToolbar.ivBackImg.visibility = View.VISIBLE
        binding.friendToolbar.ivdownload.visibility = View.VISIBLE

        FriendAdapter(this).apply {
            binding.rcyFriend.layoutManager = LinearLayoutManager(this@FriendActivity)
            binding.rcyFriend.adapter = this
        }

    }

    private fun lstnr() {
        binding.friendToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }

    }
}