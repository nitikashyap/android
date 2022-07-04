package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.databinding.NumberAddPlayerItemBinding

class NumberAddPlayerAdapter(val con: Context) :
    RecyclerView.Adapter<NumberAddPlayerAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: NumberAddPlayerItemBinding) : RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            NumberAddPlayerItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 2
    }
}