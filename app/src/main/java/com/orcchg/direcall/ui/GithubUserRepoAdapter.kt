package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserRepoBinding
import com.orcchg.direcall.domain.model.GithubRepo

class GithubUserRepoAdapter : RecyclerView.Adapter<GithubUserRepoViewHolder>() {
    private var userRepoList = listOf<GithubRepo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserRepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserRepoBinding.inflate(inflater, parent, false)
        return (GithubUserRepoViewHolder(binding))
    }

    override fun onBindViewHolder(holder: GithubUserRepoViewHolder, position: Int) {
        holder.bind(userRepoList[position])
    }

    override fun getItemCount(): Int = userRepoList.size

    fun update(items: List<GithubRepo>) {
        this.userRepoList = items
        notifyDataSetChanged()
    }
}