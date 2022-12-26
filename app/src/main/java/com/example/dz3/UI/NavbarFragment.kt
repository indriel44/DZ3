package com.example.dz3.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.dz3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NavbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.navbar, container, false)
        //var viewOfLayout = inflater.inflate(R.layout.main_fragment, container, false)
        //viewOfLayout.findViewById<ImageView>(R.id.main_img)
        //return viewOfLayout
    }
    companion object {
        fun newInstance() = NavbarFragment()
    }
}