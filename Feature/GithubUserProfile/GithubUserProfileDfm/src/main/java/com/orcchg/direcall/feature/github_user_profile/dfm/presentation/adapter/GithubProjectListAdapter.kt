package com.orcchg.direcall.feature.github_user_profile.dfm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.dfm.databinding.RvGithubUserProjectListItemBinding

class GithubProjectListAdapter(
    private val models: MutableList<GithubProject> = mutableListOf()
) : RecyclerView.Adapter<GithubProjectViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubProjectViewHolder =
        GithubProjectViewHolder(RvGithubUserProjectListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubProjectViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubProject>) {
        with(this.models) {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()
    }
}
