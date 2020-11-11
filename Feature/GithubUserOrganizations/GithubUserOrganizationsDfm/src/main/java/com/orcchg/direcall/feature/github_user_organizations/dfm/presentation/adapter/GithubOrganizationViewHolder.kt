package com.orcchg.direcall.feature.github_user_organizations.dfm.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.dfm.databinding.RvGithubUserOrganizationListItemBinding

class GithubOrganizationViewHolder(
    private val binding: RvGithubUserOrganizationListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubOrganization) {
        Glide.with(binding.ivAvatar)
            .load(model.avatarUrl)
            .into(binding.ivAvatar)

        binding.tvTitle.text = model.description
    }
}
