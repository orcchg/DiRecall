package com.orcchg.direcall.feature.github_user_list.impl.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.feature.github_user_list.impl.databinding.RvGithubUserListItemBinding
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser

class GithubUserViewHolder(
    private val binding: RvGithubUserListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubUser) {
        Glide.with(binding.ivAvatar)
            .load(model.avatarUrl)
            .into(binding.ivAvatar)

        binding.tvTitle.text = model.login
    }
}
