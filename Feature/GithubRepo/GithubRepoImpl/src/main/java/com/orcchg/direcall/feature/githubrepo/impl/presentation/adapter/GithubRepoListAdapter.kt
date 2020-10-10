package com.orcchg.direcall.feature.githubrepo.impl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubrepo.impl.databinding.RvGithubRepoListItemBinding

class GithubRepoListAdapter(
    private val models: MutableList<GithubRepo> = mutableListOf()
) : RecyclerView.Adapter<GithubRepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
        GithubRepoViewHolder(RvGithubRepoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubRepo>) {
        with(this.models) {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()
    }
}
