package com.orcchg.direcall.adapter

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
        val binding = RvItemGithubUserBinding.inflate(inflater, parent, false)
        val holder = GithubUserViewHolder(binding)
        binding.root.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick?.invoke(userList[position])
            }
        }
        return holder
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