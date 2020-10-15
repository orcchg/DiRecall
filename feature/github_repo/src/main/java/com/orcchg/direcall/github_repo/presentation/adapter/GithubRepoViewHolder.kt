package com.orcchg.direcall.github_repo.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.github_repo.databinding.RvGithubRepoListItemBinding
import com.orcchg.direcall.github_repo.domain.model.GithubRepo

class GithubRepoViewHolder(
    private val binding: RvGithubRepoListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubRepo) {
        binding.tvTitle.text = model.name
    }
}
