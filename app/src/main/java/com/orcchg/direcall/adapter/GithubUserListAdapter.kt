package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvGithubUserListItemBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserListAdapter(
    private val models: List<GithubUser>
) : RecyclerView.Adapter<GithubUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder =
        GithubUserViewHolder(RvGithubUserListItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size
}
