package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.CurrentModal
import com.huntinggame.databinding.CompletedItemBinding
import com.huntinggame.databinding.CurrentItemBinding

class CompletedAdapter(
    val con: Context,
    val completed: ArrayList<CurrentModal>,
    val onPress: OnClickItem
) :
    RecyclerView.Adapter<CompletedAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: CompletedItemBinding) : RecyclerView.ViewHolder(mView.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            CompletedItemBinding.inflate(
                LayoutInflater.from(con),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.mView.imageView35.setImageResource(completed[position].img)
//        holder.mView.textView26.text = completed[position].title
//        holder.mView.textView27.text = completed[position].qty
//        holder.mView.textView28.text = completed[position].date
        holder.mView.imageView35.setOnClickListener {
            onPress.clickOn(isClick = true, position)
        }

    }

    override fun getItemCount(): Int {
        return 1
    }

    interface OnClickItem {
        fun clickOn(isClick: Boolean, position: Int)
    }
}