package com.orcchg.direcall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserRepoBinding
import com.orcchg.direcall.domain.model.GithubRepo

class GithubUserReposViewHolder(private val binding: RvItemGithubUserRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(githubRepo: GithubRepo) {
        binding.tvRepoName.text = githubRepo.name
    }
}