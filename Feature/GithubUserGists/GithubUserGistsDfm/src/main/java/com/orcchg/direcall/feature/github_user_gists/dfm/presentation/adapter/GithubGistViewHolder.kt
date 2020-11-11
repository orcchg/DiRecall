package com.orcchg.direcall.feature.github_user_gists.dfm.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.dfm.databinding.RvGithubGistListItemBinding

class GithubGistViewHolder(
    private val binding: RvGithubGistListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: GithubGist) {
        binding.tvTitle.text = model.description
    }
}
