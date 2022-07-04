package com.huntinggame.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.CurrentAdapter
import com.huntinggame.Adapter.LeaderAdapter
import com.huntinggame.Adapter.LeaderDetailsAdapter
import com.huntinggame.Adapter.LeaderFragmentAdapter
import com.huntinggame.Modal.LeaderDetailsModal
import com.huntinggame.Modal.LeaderModal
import com.huntinggame.R
import com.huntinggame.activity.CurrentLeaderBoardActivity
import com.huntinggame.databinding.FragmentLeaderBinding


class LeaderFragment : Fragment() {
    lateinit var bin: FragmentLeaderBinding
    private var leaderModal = ArrayList<LeaderModal>()
    private var leaderdetailsModal = ArrayList<LeaderDetailsModal>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bin = FragmentLeaderBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        initView()
        lstnr()
        return bin.root
    }

    private fun initView() {
        bin.leaderToolbar.tvName.text = "LEADERBOARD"
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
//        leaderModal.add(
//            LeaderModal(
//                "66,987",
//                R.drawable.group_8,
//                "Alex Ensina",
//                R.drawable.group_158,
//                "5"
//            )
//        )
        leaderModal.add(
            LeaderModal(
                "78,987",
                R.drawable.group_7,
                "Alex Ensina",
                R.drawable.group_129,
                "5"
            )
        )
        //LeaderDetail
        leaderdetailsModal.add(LeaderDetailsModal("Deer", "12", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Duck", "13", "10:48pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Small Bird", "9", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Rabbit", "10", "11:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Turkey", "9", "12:45pm"))
        leaderdetailsModal.add(LeaderDetailsModal("Monkey", "8", "1:pm"))


        LeaderFragmentAdapter(this.requireContext(), leaderModal).apply {
            bin.rcyLeader.layoutManager =
                LinearLayoutManager(this@LeaderFragment.requireContext())
            bin.rcyLeader.adapter = this
        }

//        LeaderDetailsAdapter(this.requireContext(), leaderdetailsModal).apply {
//            bin.rcyLeaderDetails.layoutManager =
//                LinearLayoutManager(this@LeaderFragment.requireContext())
//            bin.rcyLeaderDetails.adapter = this
//        }

    }

    private fun lstnr() {
        bin.cardView.setOnClickListener {
//            if (bin.rcyLeader.visibility == View.VISIBLE) {
//                bin.rcyLeader.visibility = View.INVISIBLE
//                bin.tvHuntingLog.visibility = View.VISIBLE
//                bin.DetailLeaderLay.visibility = View.VISIBLE
//            } else {
//                bin.rcyLeader.visibility = View.VISIBLE
//                bin.tvHuntingLog.visibility = View.GONE
//                bin.DetailLeaderLay.visibility = View.GONE
//            }
            startActivity(Intent(this.requireContext(),CurrentLeaderBoardActivity::class.java))
        }


    }



}


