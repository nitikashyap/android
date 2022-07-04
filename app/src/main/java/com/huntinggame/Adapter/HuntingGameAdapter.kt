package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.HuntingGameModal
import com.huntinggame.databinding.HuntingGameItemBinding

class HuntingGameAdapter(val con: Context,val huntingGame:ArrayList<HuntingGameModal>) :
    RecyclerView.Adapter<HuntingGameAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: HuntingGameItemBinding) : RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(HuntingGameItemBinding.inflate(LayoutInflater.from(con), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mView.textView.text = huntingGame[position].title
        holder.mView.imageView5.setImageResource(huntingGame[position].img)
        holder.mView.imageView44.setImageResource(huntingGame[position].checkimg)

    }

    override fun getItemCount(): Int {
        return huntingGame.size

    }
}