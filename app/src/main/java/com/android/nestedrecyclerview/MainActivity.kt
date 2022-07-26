package com.android.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.nestedrecyclerview.DataSource.getPost
import com.android.nestedrecyclerview.DataSource.getStories
import com.android.nestedrecyclerview.data.HomeItem
import com.android.nestedrecyclerview.databinding.ActivityMainBinding
import com.android.nestedrecyclerview.ui.HomeAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemsList : MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(HomeItem(DataSource.getPost(),HomeItemType.TYPE_STORIES))
        itemsList.add(HomeItem("Update Your Post",HomeItemType.TYPE_NEW_POST))
        itemsList.addAll(DataSource.getPost().map { it.toHomeItem() })
        adapter = HomeAdapter(itemsList)
        binding.recyclerViewBase.adapter = adapter
    }

    private fun setupRecyclerView(){
        val itemsList : MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(HomeItem(getStories(),HomeItemType.TYPE_STORIES))
        itemsList.add(HomeItem("Update Your Post",HomeItemType.TYPE_NEW_POST))
        itemsList.addAll(getPost().map { it.toHomeItem() })
        adapter = HomeAdapter(itemsList)
        binding.recyclerViewBase.adapter = adapter
    }
}