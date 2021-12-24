package com.behzoddev.architecturecomponentsample.presentation.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.behzoddev.architecturecomponentsample.common.loadUrlWithPicasso
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.databinding.ItemPostBinding
import com.behzoddev.architecturecomponentsample.utils.onItemClick


class PostViewHolder (private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post, onItemClick: onItemClick) {
        Log.d("Debug","bind function from PostViewHolder")
        binding.tvPost.text = post.title
        binding.tvAuthorName.text = post.author
        post.image ?.let { binding.ivPost.loadUrlWithPicasso(it) }
    }
}