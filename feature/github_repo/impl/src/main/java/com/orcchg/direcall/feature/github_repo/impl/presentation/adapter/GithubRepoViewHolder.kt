package com.orcchg.direcall.feature.github_repo.impl.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_repo.impl.databinding.RvGithubRepoListItemBinding
import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo

class GithubRepoViewHolder(
    private val binding: RvGithubRepoListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubRepo) {
        binding.tvTitle.text = model.name
    }
}
