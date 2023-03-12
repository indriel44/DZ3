package com.example.dz3.UI

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.dz3.R
import com.example.dz3.objects.Friend

class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val image_av by lazy { view.findViewById<ImageView>(R.id.avatar) }
    //protected val image_bk by lazy { view.findViewById<ImageView>(R.id.profile_back_picture) }
    protected val imageLoader by lazy { Picasso.get() }
    //lol

    fun bind (friend: Friend) {
        val url = friend.imageId()
        imageLoader.load(url).error(R.drawable.medal_1).into(image_av)

    }
}