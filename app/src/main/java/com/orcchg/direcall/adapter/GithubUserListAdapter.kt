package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvGithubUserListItemBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserListAdapter(
    private val models: MutableList<GithubUser> = mutableListOf()
) : RecyclerView.Adapter<GithubUserViewHolder>() {

    internal var itemClickListener: ((model: GithubUser) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder =
        GithubUserViewHolder(RvGithubUserListItemBinding.inflate(LayoutInflater.from(parent.context)))
            .apply {
                adapterPosition
                    .takeIf { it != RecyclerView.NO_POSITION }
                    ?.let { itemClickListener?.invoke(models[it]) }
            }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    fun update(models: List<GithubUser>) {
        with(this.models) {
            clear()
            addAll(models)
        }
    }
}
