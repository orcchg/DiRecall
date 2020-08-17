package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvGithubRepoListItemBinding
import com.orcchg.direcall.domain.model.GithubRepo

class GithubRepoListAdapter(
    private val models: MutableList<GithubRepo> = mutableListOf()
) : RecyclerView.Adapter<GithubRepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
        GithubRepoViewHolder(RvGithubRepoListItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubRepo>) {
        with(this.models) {
            clear()
            addAll(models)
        }
    }
}
