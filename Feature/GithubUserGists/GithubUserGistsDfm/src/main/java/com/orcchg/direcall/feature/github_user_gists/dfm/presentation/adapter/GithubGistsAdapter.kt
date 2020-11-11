package com.orcchg.direcall.feature.github_user_gists.dfm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.dfm.databinding.RvGithubGistListItemBinding

class GithubGistsAdapter(
    private val models: MutableList<GithubGist> = mutableListOf()
) : RecyclerView.Adapter<GithubGistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubGistViewHolder =
        GithubGistViewHolder(RvGithubGistListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubGistViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubGist>) {
        with(this.models) {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()
    }
}
