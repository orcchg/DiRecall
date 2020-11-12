package com.orcchg.direcall.feature.github_user_profile.ui.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.ui.databinding.RvGithubUserProjectListItemBinding

class GithubProjectViewHolder(
    private val binding: RvGithubUserProjectListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubProject) {
        binding.tvBrief.text = model.brief
        binding.tvName.text = model.name
    }
}
