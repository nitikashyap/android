package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.R
import com.huntinggame.databinding.AddPlayerScreenItemBinding

class AddPlayerScreenAdapter(val con: Context) :
    RecyclerView.Adapter<AddPlayerScreenAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: AddPlayerScreenItemBinding) : RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            AddPlayerScreenItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position == 0 || position == 1) {
            holder.mView.imageView6.setImageResource(R.drawable.unselected)
        }
        if(position == 2 || position==3){
            holder.mView.imageView6.setImageResource(R.drawable.selected)
        }

    }

    override fun getItemCount(): Int {
        return 4
    }
}