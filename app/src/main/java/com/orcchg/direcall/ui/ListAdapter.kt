package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.domain.model.GithubUser

class ListAdapter (private val list: List<GithubUser>):
        RecyclerView.Adapter<UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user : GithubUser = list[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = list.size

}