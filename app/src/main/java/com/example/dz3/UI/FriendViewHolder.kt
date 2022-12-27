package com.example.dz3.UI


import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.dz3.R
import com.example.dz3.objects.Friend


class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val image by lazy { view.findViewById<ImageView>(R.id.avatar) }
    protected val imageLoader by lazy { Picasso.get() }

    fun bind(friend: Friend) {
        val url = friend.imageId()
        imageLoader.load(url).into(image)

    }
}