package com.android.nestedrecyclerview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.nestedrecyclerview.R
import com.android.nestedrecyclerview.data.Story
import com.android.nestedrecyclerview.databinding.AddStoryBinding
import com.android.nestedrecyclerview.databinding.StoryLayoutBinding
import com.google.android.material.snackbar.Snackbar

class StoriesAdapter(private val items : List<Story>) :
    RecyclerView.Adapter<StoriesAdapter.StoryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
             val view = LayoutInflater.from(parent.context).inflate(R.layout.story_layout,parent,false)
             return StoryViewHolder(view)
    }
    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentStory = items[position]
        holder.binding.apply {
            imgStory.setImageResource(currentStory.imgUrl)
        }
    }
    override fun getItemCount(): Int = items.size
    class StoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = StoryLayoutBinding.bind(viewItem)
    }
}