package com.orcchg.direcall.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.databinding.RvItemGithubUserBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserViewHolder(private val binding: RvItemGithubUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: GithubUser) {
        binding.tvLogin.text = user.login
        Glide.with(binding.ivAvatar)
            .load(user.avatarUrl)
            .circleCrop()
            .into(binding.ivAvatar)
    }
}
