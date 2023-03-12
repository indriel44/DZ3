package com.example.dz3.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dz3.R
import com.example.dz3.objects.Friend

class ProfileAdapter :  ListAdapter<Friend, ProfileViewHolder>(FriendDifferentCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_fragment, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val friend = getItem(position)
        holder.bind(friend)
    }
}