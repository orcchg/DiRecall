package com.orcchg.direcall.feature.github_user_organizations.impl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.impl.databinding.RvGithubUserOrganizationListItemBinding

class GithubOrganizationsAdapter(
    private val models: MutableList<GithubOrganization> = mutableListOf()
) : RecyclerView.Adapter<GithubOrganizationViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubOrganizationViewHolder =
        GithubOrganizationViewHolder(RvGithubUserOrganizationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GithubOrganizationViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubOrganization>) {
        with(this.models) {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()
    }
}
