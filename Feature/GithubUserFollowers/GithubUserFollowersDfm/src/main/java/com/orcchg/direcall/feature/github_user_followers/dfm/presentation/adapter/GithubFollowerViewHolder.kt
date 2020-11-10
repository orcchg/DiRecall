package com.orcchg.direcall.feature.github_user_followers.dfm.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.dfm.databinding.RvGithubFollowerListItemBinding

class GithubFollowerViewHolder(
    private val binding: RvGithubFollowerListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubFollower) {
        Glide.with(binding.ivAvatar)
            .load(model.avatarUrl)
            .into(binding.ivAvatar)

        binding.tvTitle.text = model.login
    }
}
