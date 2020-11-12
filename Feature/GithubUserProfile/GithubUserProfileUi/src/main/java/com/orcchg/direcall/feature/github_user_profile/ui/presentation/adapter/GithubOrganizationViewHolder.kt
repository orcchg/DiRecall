package com.orcchg.direcall.feature.github_user_profile.ui.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_profile.ui.databinding.RvGithubUserOrganizationListItemInProfileBinding

class GithubOrganizationViewHolder(
    private val binding: RvGithubUserOrganizationListItemInProfileBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubOrganization) {
        Glide.with(binding.ivAvatar)
            .load(model.avatarUrl)
            .into(binding.ivAvatar)

        binding.tvTitle.text = model.description
    }
}
