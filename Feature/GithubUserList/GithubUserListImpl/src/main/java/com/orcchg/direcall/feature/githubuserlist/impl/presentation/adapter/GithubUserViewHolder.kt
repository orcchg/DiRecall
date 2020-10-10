package com.orcchg.direcall.feature.githubuserlist.impl.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.orcchg.direcall.feature.githubuserlist.impl.databinding.RvGithubUserListItemBinding

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
