package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserListAdapter(private val list: List<GithubUser>) :
    RecyclerView.Adapter<GithubUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_item_github_user, parent, false)

        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}