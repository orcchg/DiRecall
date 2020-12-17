package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserRepoBinding
import com.orcchg.direcall.domain.model.GithubRepo

class GithubUserReposAdapter : RecyclerView.Adapter<GithubUserReposViewHolder>() {
    private var items = listOf<GithubRepo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserReposViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserRepoBinding.inflate(inflater, parent, false)
        return GithubUserReposViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserReposViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun update(items: List<GithubRepo>) {
        this.items = items
        notifyDataSetChanged()
    }
}