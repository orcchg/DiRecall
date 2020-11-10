package com.orcchg.direcall.feature.github_user_followers.dfm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.dfm.databinding.RvGithubFollowerListItemBinding

class GithubFollowersAdapter(
    private val models: MutableList<GithubFollower> = mutableListOf()
) : RecyclerView.Adapter<GithubFollowerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubFollowerViewHolder =
        GithubFollowerViewHolder(RvGithubFollowerListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubFollowerViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubFollower>) {
        with(this.models) {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()
    }
}
