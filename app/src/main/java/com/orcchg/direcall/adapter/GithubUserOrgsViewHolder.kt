package com.orcchg.direcall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.databinding.RvItemGithubUserOrgBinding
import com.orcchg.direcall.domain.model.GithubUserOrg

class GithubUserOrgsViewHolder(private val binding: RvItemGithubUserOrgBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(org: GithubUserOrg) {
        binding.tvLoginOrg.text = org.login
        Glide.with(binding.ivAvatarOrg)
            .load(org.avatarUrl)
            .into(binding.ivAvatarOrg)
    }
}