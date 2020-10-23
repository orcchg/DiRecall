package com.orcchg.direcall.feature.github_user_list.impl.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.feature.github_user_list.impl.databinding.RvGithubUserListItemBinding
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser

class GithubUserListAdapter(
    private val models: MutableList<GithubUser> = mutableListOf()
) : RecyclerView.Adapter<GithubUserViewHolder>() {

    internal var itemClickListener: ((model: GithubUser) -> Unit)? = null

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder =
        GithubUserViewHolder(RvGithubUserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            .apply {
                itemView.clicks().clickDebounce().subscribe {
                    adapterPosition
                        .takeIf { it != RecyclerView.NO_POSITION }
                        ?.let { itemClickListener?.invoke(models[it]) }
                }
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
        notifyDataSetChanged()
    }
}
