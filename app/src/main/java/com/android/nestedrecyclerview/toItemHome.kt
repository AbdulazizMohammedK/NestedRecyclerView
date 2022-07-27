package com.android.nestedrecyclerview

import com.android.nestedrecyclerview.data.HomeItem
import com.android.nestedrecyclerview.data.Post
import com.android.nestedrecyclerview.data.Story

fun Story.toItemHome() : HomeItem<Any> {
    return HomeItem(this, HomeItemType.TYPE_STORIES)
}