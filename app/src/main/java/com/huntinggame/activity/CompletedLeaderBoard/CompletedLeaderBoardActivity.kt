package com.huntinggame.activity.CompletedLeaderBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.LeaderAdapter
import com.huntinggame.Modal.LeaderDetailsModal
import com.huntinggame.Modal.LeaderModal
import com.huntinggame.R
import com.huntinggame.databinding.ActivityCompletedLeaderBoardBinding

class CompletedLeaderBoardActivity : AppCompatActivity() {
    lateinit var binding:ActivityCompletedLeaderBoardBinding
    private var leaderModal = ArrayList<LeaderModal>()
    private var leaderdetailsModal = ArrayList<LeaderDetailsModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompletedLeaderBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        lstnr()
    }

    private fun initView() {
        binding.CompleteleaderToolbar.tvName.text = "LEADERBOARD"
        binding.CompleteleaderToolbar.ivBackImg.visibility = View.VISIBLE
        leaderModal.add(
            LeaderModal(
                "55,987",
                R.drawable.group_7,
                "Alex Ensina",
                R.drawable.group_157,
                "2"
            )
        )
        leaderModal.add(
            LeaderModal(
                "51,987",
                R.drawable.group_8,
                "Joohi Gupta",
                R.drawable.group_158,
                "3"
            )
        )
        leaderModal.add(
            LeaderModal(
                "52,987",
                R.drawable.group_7,
                "Nitish Sharma",
                R.drawable.group_157,
                "4"
            )
        )
        leaderModal.add(
            LeaderModal(
                "66,987",
                R.drawable.group_8,
                "Alex Ensina",
                R.drawable.group_129,
                "5"
            )
        )
//        leaderModal.add(
//            LeaderModal(
//                "78,987",
//                R.drawable.group_7,
//                "Alex Ensina",
//                R.drawable.group_157,
//                "6"
//            )
//        )
        //LeaderDetail
        leaderdetailsModal.add(LeaderDetailsModal("Deer", "12", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Duck", "13", "10:48pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Small Bird", "9", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Rabbit", "10", "11:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Turkey", "9", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Monkey", "8", "1:pm"))


        LeaderAdapter(this, leaderModal).apply {
            binding.rcyLeader.layoutManager =
                LinearLayoutManager(this@CompletedLeaderBoardActivity)
            binding.rcyLeader.adapter = this
        }

    }

    private fun lstnr() {
        binding.CompleteleaderToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
    }
}