package com.orcchg.direcall.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orcchg.direcall.databinding.RvItemGithubUserBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemGithubUserBinding.bind(view)

    fun bind(user: GithubUser) {
        binding.tvLogin.text = user.login
        Glide.with(binding.ivAvatar)
            .load(user.avatarUrl)
            .into(binding.ivAvatar)
    }
}
