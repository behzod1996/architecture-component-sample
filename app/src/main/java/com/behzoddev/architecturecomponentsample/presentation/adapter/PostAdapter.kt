package com.behzoddev.architecturecomponentsample.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.databinding.ItemPostBinding
import com.behzoddev.architecturecomponentsample.utils.onItemClick

class PostAdapter (
    private val onItemClick: onItemClick
) : RecyclerView.Adapter<PostViewHolder>() {

    companion object {
        private val differCallBack = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                Log.d("Debug","areItemsTheSame")
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                Log.d("Debug","areContentsTheSame")
                return oldItem == newItem
            }

        }
    }

    val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d("Debug","onCreateViewHolder")
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d("Debug","onBindViewHolder")
        val item = differ.currentList[position]
        holder.bind(item,onItemClick)
    }

    override fun getItemCount(): Int {
        Log.d("Debug","getItemCount")
        return differ.currentList.size
    }


}