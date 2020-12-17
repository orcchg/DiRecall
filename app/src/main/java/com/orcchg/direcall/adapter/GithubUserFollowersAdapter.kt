package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserFollowerBinding
import com.orcchg.direcall.domain.model.GithubUserFollower

class GithubUserFollowersAdapter : RecyclerView.Adapter<GithubUserFollowersViewHolder>() {

    private var items = listOf<GithubUserFollower>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubUserFollowersViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserFollowerBinding.inflate(inflater, parent, false)
        return GithubUserFollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserFollowersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun update(items: List<GithubUserFollower>) {
        this.items = items
        notifyDataSetChanged()
    }
}