package com.huntinggame.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huntinggame.Modal.FriendsListModal
import com.huntinggame.Modal.GameChatModal
import com.huntinggame.activity.FriendActivity
import com.huntinggame.databinding.FriendItemBinding
import com.huntinggame.databinding.GameChatItemBinding
class FriendAdapter(
    val con: FriendActivity,
    val friendlistmodal: ArrayList<FriendsListModal>
) :
    RecyclerView.Adapter<FriendAdapter.MyViewHolder>() {
    class MyViewHolder(val mView: FriendItemBinding) : RecyclerView.ViewHolder(mView.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(FriendItemBinding.inflate(LayoutInflater.from(con), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mView.textView.text = friendlistmodal[position].title
        holder.mView.imageView5.setImageResource(friendlistmodal[position].img)



    }

    override fun getItemCount(): Int {
        return friendlistmodal.size
    }


}
