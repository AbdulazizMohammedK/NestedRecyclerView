package com.android.nestedrecyclerview

import com.android.nestedrecyclerview.data.HomeItem
import com.android.nestedrecyclerview.data.Post

fun Post.toHomeItem() : HomeItem<Any> {
    return HomeItem(this,HomeItemType.TYPE_POST)
}