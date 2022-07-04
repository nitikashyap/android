package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.GameChatModal
import com.huntinggame.databinding.GameChatItemBinding

class GameChatAdapter(
    val con: Context,
    val gamechat: ArrayList<GameChatModal>,
    val onPress: OnClickItem
) :
    RecyclerView.Adapter<GameChatAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: GameChatItemBinding) : RecyclerView.ViewHolder(mView.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(GameChatItemBinding.inflate(LayoutInflater.from(con), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mView.textView41.text = gamechat[position].title
        holder.mView.textView42.text = gamechat[position].day
        holder.mView.textView43.text = gamechat[position].des
        holder.mView.imageView43.setImageResource(gamechat[position].img)
        holder.mView.mainChat.setOnClickListener {
            onPress.clickOn(isClick = true, position)
        }


    }

    override fun getItemCount(): Int {
        return gamechat.size
    }

    interface OnClickItem {
        fun clickOn(isClick: Boolean, position: Int)
    }
}

