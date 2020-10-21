package com.orcchg.direcall.feature.github_user_gists.impl.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_gists.impl.databinding.RvGithubGistListItemBinding
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist

class GithubGistViewHolder(
    private val binding: RvGithubGistListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubGist) {
        binding.tvTitle.text = model.description
    }
}
