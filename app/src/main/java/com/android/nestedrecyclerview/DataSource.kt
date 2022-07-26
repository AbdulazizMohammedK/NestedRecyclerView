package com.android.nestedrecyclerview

import com.android.nestedrecyclerview.data.Post
import com.android.nestedrecyclerview.data.Story

object DataSource {
    fun getStories() : List<Story> = listOf(
        Story(false,R.drawable.app)

        ,Story(false,R.drawable.app)
        ,
        Story(false,R.drawable.app),

        Story(false,R.drawable.app),

        Story(false,R.drawable.app),

        Story(false,R.drawable.app),

        Story(false,R.drawable.app),

        Story(false,R.drawable.app)
    )
    fun getPost() : List<Post> = listOf(
        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app),

        Post(username = "Aziz", date = "2022/6/5",R.drawable.ic_baseline_person_24,R.drawable.app)
    )
}