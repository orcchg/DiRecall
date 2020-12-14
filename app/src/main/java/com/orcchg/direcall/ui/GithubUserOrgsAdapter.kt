package com.orcchg.direcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserOrgBinding
import com.orcchg.direcall.domain.model.GithubUserOrg

class GithubUserOrgsAdapter : RecyclerView.Adapter<GithubUserOrgsViewHolder>() {

    private var orgsList = listOf<GithubUserOrg>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserOrgsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserOrgBinding.inflate(inflater, parent, false)
        return GithubUserOrgsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserOrgsViewHolder, position: Int) {
        holder.bind(orgsList[position])
    }

    override fun getItemCount(): Int = orgsList.size

    fun update(items: List<GithubUserOrg>) {
        this.orgsList = items
        notifyDataSetChanged()
    }

}