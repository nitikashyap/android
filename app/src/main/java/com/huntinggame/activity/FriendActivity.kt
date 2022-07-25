package com.huntinggame.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.FriendAdapter
import com.huntinggame.Modal.FriendsListModal
import com.huntinggame.R
import com.huntinggame.databinding.ActivityFriendBinding

class FriendActivity : AppCompatActivity() {
   lateinit var binding: ActivityFriendBinding
    private var friendlistmodal = ArrayList<FriendsListModal>()
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


        friendlistmodal.add(FriendsListModal(R.drawable.group_140, "Alex Ensina"))
        friendlistmodal.add(FriendsListModal(R.drawable.group_7, "Karl Xie"))
        friendlistmodal.add(FriendsListModal(R.drawable.group_8, "deluccio"))
        friendlistmodal.add(FriendsListModal(R.drawable.group_140, "blockscrypto"))

        FriendAdapter(this,friendlistmodal).apply {
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