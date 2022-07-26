package com.android.nestedrecyclerview.data

import com.android.nestedrecyclerview.HomeItemType

data class HomeItem<T> (
    val item : T,
    val type : HomeItemType
)