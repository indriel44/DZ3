package com.example.dz3.UI

import androidx.recyclerview.widget.DiffUtil
import com.example.dz3.objects.Friend

class FriendDifferentCallback: DiffUtil.ItemCallback<Friend>() {
    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Friend, newItem:Friend): Boolean {
        return oldItem.imageId() == newItem.imageId()
    }
}