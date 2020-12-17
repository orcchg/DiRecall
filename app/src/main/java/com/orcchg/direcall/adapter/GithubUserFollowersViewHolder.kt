package com.orcchg.direcall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.databinding.RvItemGithubUserFollowerBinding
import com.orcchg.direcall.domain.model.GithubUserFollower

class GithubUserFollowersViewHolder(private val binding: RvItemGithubUserFollowerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(follower: GithubUserFollower) {
        binding.tvLoginFollower.text = follower.login
        Glide.with(binding.ivAvatarFollower)
            .load(follower.avatarUrl)
            .circleCrop()
            .into(binding.ivAvatarFollower)
    }
}