package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.LeaderModal
import com.huntinggame.databinding.LeaderItemBinding

class LeaderFragmentAdapter(val con: Context, val leader: ArrayList<LeaderModal>) :
    RecyclerView.Adapter<LeaderFragmentAdapter.MyViewHolder>() {
    class MyViewHolder (val mView: LeaderItemBinding):RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LeaderItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mView.textView32.text = leader[position].posi
        holder.mView.imageView38.setImageResource(leader[position].mainimg)
        holder.mView.textView33.text = leader[position].title
        holder.mView.imageView41.setImageResource(leader[position].img)
        holder.mView.textView34.text = leader[position].count
        if(position==2){
            holder.mView.imageView41.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return leader.size
    }
}