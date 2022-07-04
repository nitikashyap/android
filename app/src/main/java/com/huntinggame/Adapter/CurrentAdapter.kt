package com.huntinggame.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.CurrentModal
import com.huntinggame.activity.CurrentLeaderBoardActivity
import com.huntinggame.activity.HuntingGame.HuntingGameActivity
import com.huntinggame.activity.LeaderBoard.LeaderBoardActivity
import com.huntinggame.databinding.CurrentItemBinding

class CurrentAdapter(val con: Context, val lst: ArrayList<CurrentModal>) :
    RecyclerView.Adapter<CurrentAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: CurrentItemBinding) : RecyclerView.ViewHolder(mView.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CurrentItemBinding.inflate(LayoutInflater.from(con), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mView.imageView35.setImageResource(lst[position].img)
        holder.mView.textView26.text = lst[position].title
        holder.mView.textView27.text = lst[position].qty
        holder.mView.textView28.text = lst[position].date
        holder.mView.imageView35.setOnClickListener {
            con.startActivity(Intent(con,LeaderBoardActivity::class.java))
           // startActivity(Intent(this.requireContext(), LeaderBoardActivity::class.java))
        }

    }

    override fun getItemCount(): Int {
        return lst.size

    }
}