package com.huntinggame.activity.LeaderBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.LeaderAdapter
import com.huntinggame.Adapter.LeaderDetailsAdapter
import com.huntinggame.Modal.LeaderDetailsModal
import com.huntinggame.Modal.LeaderModal
import com.huntinggame.R
import com.huntinggame.activity.CurrentLeaderBoardActivity
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.databinding.ActivityLeaderBoardBinding

class LeaderBoardActivity : AppCompatActivity() {
    lateinit var bin: ActivityLeaderBoardBinding
    lateinit var imageView37: ImageView
    private var leaderModal = ArrayList<LeaderModal>()
    private var leaderdetailsModal = ArrayList<LeaderDetailsModal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityLeaderBoardBinding.inflate(layoutInflater)
        setContentView(bin.root)
        initView()
        lstnr()
    }

    private fun initView() {
        imageView37=findViewById(R.id.imageView37)
        bin.leaderToolbar.tvName.text = "LEADERBOARD"
        bin.leaderToolbar.ivBackImg.visibility = View.VISIBLE
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
            bin.rcyLeader.layoutManager =
                LinearLayoutManager(this@LeaderBoardActivity)
            bin.rcyLeader.adapter = this
        }

//        LeaderDetailsAdapter(this, leaderdetailsModal).apply {
//            bin.rcyLeaderDetails.layoutManager =
//                LinearLayoutManager(this@LeaderBoardActivity)
//            bin.rcyLeaderDetails.adapter = this
//        }


        imageView37.setOnClickListener {
            startActivity(Intent(this, CurrentLeaderBoardActivity::class.java))
        }

    }

    private fun lstnr() {
//        bin.cardView.setOnClickListener {
//            if (bin.rcyLeader.visibility == View.VISIBLE) {
//                bin.rcyLeader.visibility = View.INVISIBLE
//                bin.imageView18.visibility = View.INVISIBLE
//                bin.tvHuntingLog.visibility = View.VISIBLE
//                bin.DetailLeaderLay.visibility = View.VISIBLE
//            } else {
//                bin.rcyLeader.visibility = View.VISIBLE
//                bin.imageView18.visibility = View.VISIBLE
//                bin.tvHuntingLog.visibility = View.GONE
//                bin.DetailLeaderLay.visibility = View.GONE
//            }
//        }
        bin.leaderToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
    }
}