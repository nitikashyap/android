package com.huntinggame.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.CurrentModal
import com.huntinggame.activity.HuntingGame.HuntingGameActivity
import com.huntinggame.databinding.CurrentItemBinding
import com.huntinggame.databinding.FutureItemBinding

class FutureAdapter(val con:Context,val future:ArrayList<CurrentModal>):
    RecyclerView.Adapter<FutureAdapter.MyViewHolder>() {
    class MyViewHolder(val mView:FutureItemBinding):RecyclerView.ViewHolder(mView.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        return MyViewHolder(
            FutureItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.mView.imageView35.setImageResource(future[position].img)
//        holder.mView.textView26.text = future[position].title
//        holder.mView.textView27.text = future[position].qty
//        holder.mView.textView28.text = future[position].date
        holder.mView.imageView35.setOnClickListener {
            con.startActivity(Intent(con, HuntingGameActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
       return 1
    }
}