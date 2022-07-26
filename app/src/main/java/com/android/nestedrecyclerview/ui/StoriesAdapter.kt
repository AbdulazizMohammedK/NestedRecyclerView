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
    RecyclerView.Adapter<StoriesAdapter.BaseStoryViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseStoryViewHolder {
        return when(viewType){
            VIEW_ADD_STORY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.add_story,parent,false)
                AddStoryViewHolder(view)
            }
            VIEW_STORY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stories,parent,false)
                StoryViewHolder(view)
            }
            else ->  throw Exception("Unknown")
        }
    }

    override fun onBindViewHolder(holder: BaseStoryViewHolder, position: Int) {
        when(holder) {
            is AddStoryViewHolder -> bindAddStory(holder,position)
            is StoryViewHolder -> bindStory(holder,position)
        }
    }

    private fun bindAddStory (holder: AddStoryViewHolder,position: Int){
    }
    private fun bindStory(holder : StoryViewHolder,position: Int){
        val currentStory = items[position - 1]
        holder.binding.apply {
            imgStory.setImageResource(currentStory.imgUrl)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> VIEW_ADD_STORY
            else -> VIEW_STORY
        }
    }

    override fun getItemCount(): Int = items.size + 1

    abstract class BaseStoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)
    class AddStoryViewHolder(viewItem: View) : BaseStoryViewHolder(viewItem) {
        val binding = AddStoryBinding.bind(viewItem)
    }
    class StoryViewHolder(viewItem: View) : BaseStoryViewHolder(viewItem) {
        val binding = StoryLayoutBinding.bind(viewItem)
    }
    companion object{
        const val VIEW_ADD_STORY = 0
        const val VIEW_STORY = 1
    }
}