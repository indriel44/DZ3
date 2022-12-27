package com.example.dz3.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.dz3.R

class FriendsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.friends_fragment, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val friends_button: ImageView = view.findViewById(R.id.friends_img)
        val main_button: ImageView = view.findViewById(R.id.main_img)
        main_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.friends_fragment, MainFragment.newInstance())
            transaction?.commit()

        }
        val profile_button: ImageView = view.findViewById(R.id.profile_img)
        profile_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.friends_fragment, ProfileFragment.newInstance())
            transaction?.commit()

        }

    }
    companion object {
        fun newInstance() = FriendsFragment()
    }
}