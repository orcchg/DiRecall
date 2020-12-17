package com.orcchg.direcall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserGistBinding
import com.orcchg.direcall.domain.model.GithubUserGist

class GithubUserGistViewHolder(private val binding: RvItemGithubUserGistBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(githubGist: GithubUserGist) {
        binding.tvGistDescription.text =
            githubGist.description?.takeIf { it.isNotEmpty() } ?: "No description"
    }
}