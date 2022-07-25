package com.huntinggame.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.GameChatAdapter
import com.huntinggame.Modal.GameChatModal
import com.huntinggame.R
import com.huntinggame.activity.GameChatDetails.GameChatDetailsActivity
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.databinding.FragmentGameChatBinding


class GameChatFragment : Fragment(), GameChatAdapter.OnClickItem {
    lateinit var bin: FragmentGameChatBinding
    private var gamechatModal = ArrayList<GameChatModal>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        bin = FragmentGameChatBinding.inflate(layoutInflater)
        initView()
        lstnr()
        return bin.root
    }

    private fun initView() {
        bin.gamechatToolbar.tvName.text = "GAME CHAT"
        bin.gamechatToolbar.tvAllFriends.visibility = View.VISIBLE
        bin.gamechatToolbar.ivEdit.visibility = View.VISIBLE


        gamechatModal.add(GameChatModal(R.drawable.group_140, "Shilpy rai", "Thanks!", "Thursday"))
        gamechatModal.add(GameChatModal(R.drawable.group_141, "Lalita pal", "We get the idea...", "Tuesday"))
        gamechatModal.add(GameChatModal(R.drawable.group_140, "Kavita Garg", "We contacted you...", "Saturday"))
        gamechatModal.add(GameChatModal(R.drawable.group_141, "Duck Hunt 2020", "Thank you kindly friends!", "Sunday"))
        gamechatModal.add(GameChatModal(R.drawable.group_141, "deluccio", "Here’s the PSD...", "October 08"))
        gamechatModal.add(GameChatModal(R.drawable.group_140, "blockscrypto", "Sure, let us know...", "October 06"))
        gamechatModal.add(GameChatModal(R.drawable.group_140, "Shivangi rai", "Hii", "Sunday"))
        gamechatModal.add(GameChatModal(R.drawable.group_140, "Himanshu", "Hii", "Sunday"))
//        gamechatModal.add(GameChatModal(R.drawable.group_6, "Himanshu", "Hii", "Sunday"))
//        gamechatModal.add(GameChatModal(R.drawable.group_6, "Himanshu", "Hii", "Sunday"))
//        gamechatModal.add(GameChatModal(R.drawable.group_6, "Himanshu", "Hii", "Sunday"))
//        gamechatModal.add(GameChatModal(R.drawable.group_6, "Himanshu", "Hii", "Sunday"))


        GameChatAdapter(this.requireContext(), gamechatModal,this).apply {
            bin.rcyGameChat.layoutManager = LinearLayoutManager(this@GameChatFragment.requireContext())
            bin.rcyGameChat.adapter = this
        }
    }

    private fun lstnr() {

    }

    override fun clickOn(isClick: Boolean, position: Int) {
        if (isClick) {
            startActivity(Intent(this.requireContext(), GameChatDetailsActivity::class.java))
        }
    }


}