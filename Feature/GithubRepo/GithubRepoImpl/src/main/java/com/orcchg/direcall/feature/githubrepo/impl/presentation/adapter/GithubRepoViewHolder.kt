package com.orcchg.direcall.feature.githubrepo.impl.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubrepo.impl.databinding.RvGithubRepoListItemBinding

class GithubRepoViewHolder(
    private val binding: RvGithubRepoListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubRepo) {
        binding.tvTitle.text = model.name
    }
}
