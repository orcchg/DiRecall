package com.orcchg.direcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.databinding.RvItemGithubUserBinding
import com.orcchg.direcall.domain.model.GithubUser

class GithubUserListAdapter : RecyclerView.Adapter<GithubUserViewHolder>() {

    private var items = listOf<GithubUser>()
    var onItemClick: ((GithubUser) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemGithubUserBinding.inflate(inflater, parent, false)
        val holder = GithubUserViewHolder(binding)
        binding.root.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick?.invoke(items[position])
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun update(items: List<GithubUser>) {
        this.items = items
        notifyDataSetChanged()
    }
}