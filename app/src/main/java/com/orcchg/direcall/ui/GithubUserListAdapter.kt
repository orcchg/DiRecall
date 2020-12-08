package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserListAdapter : RecyclerView.Adapter<GithubUserViewHolder>() {

    private var userList = listOf<GithubUser>()
    var onItemClick: ((GithubUser) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserBinding.inflate(inflater)
        return GithubUserViewHolder(binding, onItemClick, userList)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun update(items: List<GithubUser>) {
        this.userList = items
        notifyDataSetChanged()
    }
}