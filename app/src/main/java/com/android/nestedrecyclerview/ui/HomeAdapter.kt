package com.android.nestedrecyclerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.nestedrecyclerview.HomeItemType
import com.android.nestedrecyclerview.R
import com.android.nestedrecyclerview.data.HomeItem
import com.android.nestedrecyclerview.data.Post
import com.android.nestedrecyclerview.data.Story
import com.android.nestedrecyclerview.databinding.AddStoryBinding
import com.android.nestedrecyclerview.databinding.ItemPostBinding
import com.android.nestedrecyclerview.databinding.ItemStoriesBinding

class HomeAdapter(private  val items : List<HomeItem<Any>>)
    : RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        //على حسب النوع ترجع الفيو هولدر

        return when (viewType) {
            VIEW_TYPE_STORIES -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_stories,
                    parent,
                    false)
                StoriesViewHolder(view)
            }
            VIEW_TYPE_NEW_POST -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.add_story,parent,
                    false)
                NewPostViewHolder(view)
            }
            VIEW_TYPE_POST -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_post,parent,
                    false)
                PostViewHolder(view)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type){
            HomeItemType.TYPE_STORIES -> VIEW_TYPE_STORIES
            HomeItemType.TYPE_NEW_POST -> VIEW_TYPE_NEW_POST
            HomeItemType.TYPE_POST -> VIEW_TYPE_POST
        }
    }


    override fun getItemCount() = items.size

    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)


    class StoriesViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemStoriesBinding.bind(viewItem)
    }
    class NewPostViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = AddStoryBinding.bind(viewItem)
    }
    class PostViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemPostBinding.bind(viewItem)
    }
    companion object {
        const val VIEW_TYPE_STORIES = 13
        const val VIEW_TYPE_NEW_POST = 14
        const val VIEW_TYPE_POST = 15
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder) {
            is StoriesViewHolder -> bindStories(holder,position)
            is NewPostViewHolder -> bindNewPost(holder,position)
            is PostViewHolder -> bindPost(holder,position)
        }
    }
    private fun bindStories(holder: StoriesViewHolder,position: Int) {
        val stories = items[position].item as List<Story>
        val adapter = StoriesAdapter(stories)
        holder.binding.apply {
            recyclerViewStories.adapter = adapter
        }
    }
    private fun bindNewPost(holder: NewPostViewHolder, position: Int) {
        val hintText = items[position].item as String
        holder.binding.apply {
            etStory.hint = hintText
        }
    }
    private fun bindPost(holder : PostViewHolder,position: Int) {
        val currentPost = items[position].item as Post
        holder.binding.apply {
            nameText.text = currentPost.username
            date.text = currentPost.date
            imgProfile.setImageResource(currentPost.profileImg)
            imgPost.setImageResource(currentPost.postImg)
        }
    }
}