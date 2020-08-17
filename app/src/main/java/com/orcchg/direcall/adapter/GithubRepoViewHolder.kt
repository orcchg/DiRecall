package com.orcchg.direcall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvGithubRepoListItemBinding
import com.orcchg.direcall.domain.model.GithubRepo

class GithubRepoViewHolder(
    private val binding: RvGithubRepoListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubRepo) {
        binding.tvTitle.text = model.name
    }
}
