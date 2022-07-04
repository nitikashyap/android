package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.LeaderDetailsModal
import com.huntinggame.Modal.LeaderModal
import com.huntinggame.databinding.LeaderDetailsItemBinding

class LeaderDetailsAdapter(val con: Context, val leaderDetails: ArrayList<LeaderDetailsModal>) :
    RecyclerView.Adapter<LeaderDetailsAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: LeaderDetailsItemBinding) : RecyclerView.ViewHolder(mView.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LeaderDetailsItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.mView.textView38.text = leaderDetails[position].target
        holder.mView.textView39.text = leaderDetails[position].point
        holder.mView.textView40.text = leaderDetails[position].time

    }

    override fun getItemCount(): Int {
       return leaderDetails.size
    }
}