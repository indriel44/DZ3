package com.example.dz3.UI


import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.dz3.R
import com.example.dz3.objects.Friend
import kotlin.math.roundToInt


class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val image by lazy { view.findViewById<ImageView>(R.id.avatar) }
    protected val imageLoader by lazy { Picasso.get() }
    protected val name_txt = view.findViewById<TextView>(R.id.name)
    protected val steps_txt = view.findViewById<TextView>(R.id.steps)
    protected val place_txt = view.findViewById<TextView>(R.id.number)
    protected val image_medal by lazy { view.findViewById<ImageView>(R.id.medal) }


    fun bind(friend: Friend) {
        val url = friend.imageId()
        val name = friend.name()
        val steps = friend.steps().roundToInt()
        val place = friend.place().roundToInt()
       // Log.d("TEST", steps.toString())
        place_txt.text = place.toString()
        name_txt.text = name
        steps_txt.text = steps.toString()
        imageLoader.load(url).into(image).toString()

    }
}