package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserGistBinding
import com.orcchg.direcall.domain.model.GithubUserGist

class GithubUserGistAdapter : RecyclerView.Adapter<GithubUserGistViewHolder>() {

    private var gistList = listOf<GithubUserGist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserGistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserGistBinding.inflate(inflater, parent, false)
        return GithubUserGistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserGistViewHolder, position: Int) {
        holder.bind(gistList[position])
    }

    override fun getItemCount(): Int = gistList.size

    fun update(items: List<GithubUserGist>) {
        this.gistList = items
        notifyDataSetChanged()
    }
}