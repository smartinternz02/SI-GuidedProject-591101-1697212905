package com.example.spillthetea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spillthetea.R
import com.example.spillthetea.databinding.ItemProfileBinding
import com.example.spillthetea.model.User

class UserAdapter(var context: Context, var userlist: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>()

{
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding : ItemProfileBinding = ItemProfileBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var v = LayoutInflater.from(context).inflate(
            R.layout.item_profile, parent, false
        )
        return UserViewHolder(v)
    }

        override fun onBindViewHolder (holder: UserViewHolder, position: Int) {

            val user = userlist[position]
            holder.binding.username.text = user.name
            Glide.with(context).load(user.profileImage)
                .placeholder(R.drawable.avatar)
                .into(holder.binding.profile)
        }

    override fun getItemCount(): Int = userlist.size


}