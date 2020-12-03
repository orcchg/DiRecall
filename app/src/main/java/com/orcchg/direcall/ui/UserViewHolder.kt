package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.domain.model.GithubUser

class UserViewHolder (inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.user_item_in_list, parent, false)){

//    private var avatarView: ImageView = itemView.findViewById(R.id.user_avatar_in_list)
    private var loginView: TextView = itemView.findViewById(R.id.user_login_in_list)

    fun bind(user: GithubUser){
        loginView.text = user.login
    }
}