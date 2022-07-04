package com.huntinggame.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.CompletedAdapter
import com.huntinggame.Adapter.CurrentAdapter
import com.huntinggame.Adapter.FutureAdapter
import com.huntinggame.Modal.CurrentModal
import com.huntinggame.R
import com.huntinggame.activity.CompletedLeaderBoard.CompletedLeaderBoardActivity
import com.huntinggame.activity.CreateGame.CreateGameActivity
import com.huntinggame.activity.LeaderBoard.LeaderBoardActivity
import com.huntinggame.databinding.FragmentHuntingBinding


class HuntingFragment : Fragment(), CompletedAdapter.OnClickItem {
    lateinit var bin: FragmentHuntingBinding
    private var currentModal = ArrayList<CurrentModal>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bin = FragmentHuntingBinding.inflate(layoutInflater)
        init()
        initControl()   
        myObserver()

        // Inflate the layout for this fragment
        return bin.root
    }

    private fun init() {
        bin.HuntingToolbar.tvName.text = "HUNTING GAMES"
        bin.HuntingToolbar.imageView34.visibility = View.VISIBLE

        currentModal.add(
            CurrentModal(
                R.drawable.group_17,
                "Turkey Hunt 2021",
                "Oct 14th - 17th , 2021",
                "11"
            )
        )
//        currentModal.add(
//            CurrentModal(
//                R.drawable.group_17,
//                "Duck Hunt 2021",
//                "Nov 18th - 20th , 2021",
//                "7"
//            )
//        )
        //future
//        currentModal.add(
//            CurrentModal(
//                R.drawable.group_19,
//                "Opening Weekend Throwdown",
//                "Dec 19th - 21th , 2021",
//                "10"
//            )
//        )
//completed
//        currentModal.add(
//            CurrentModal(
//                R.drawable.group_19,
//                "Rut Week",
//                "Aug 23th - 25th , 2020",
//                "11"
//            )
//        )

        CurrentAdapter(this.requireContext(), currentModal).apply {
            bin.rcyCurrent.layoutManager =
                LinearLayoutManager(this@HuntingFragment.requireContext())
            bin.rcyCurrent.adapter = this
        }
        FutureAdapter(this.requireContext(), currentModal).apply {
            bin.rcuFuture.layoutManager = LinearLayoutManager(this@HuntingFragment.requireContext())
            bin.rcuFuture.adapter = this
        }
        CompletedAdapter(this.requireContext(), currentModal, this).apply {
            bin.rcyCompleted.layoutManager =
                LinearLayoutManager(this@HuntingFragment.requireContext())
            bin.rcyCompleted.adapter = this
        }

    }

    private fun myObserver() {

    }

    private fun initControl() {
        bin.HuntingToolbar.imageView34.setOnClickListener {
            startActivity(Intent(this.requireContext(), CreateGameActivity::class.java))
        }
        bin.tvHide.setOnClickListener {
            if (bin.rcyCompleted.visibility == View.VISIBLE){
                bin.rcyCompleted.visibility = View.INVISIBLE
                bin.tvHide.text = "Unhide"
            }else{
                bin.rcyCompleted.visibility = View.VISIBLE
                bin.tvHide.text = "Hide"
            }
        }


    }

    override fun clickOn(isClick: Boolean, position: Int) {
        if (isClick) {
            startActivity(Intent(this.requireContext(), CompletedLeaderBoardActivity::class.java))
        }
    }


}


