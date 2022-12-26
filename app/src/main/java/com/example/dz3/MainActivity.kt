package com.example.dz3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.dz3.UI.FriendsFragment
import com.example.dz3.UI.MainFragment
import com.example.dz3.UI.NavbarFragment
import com.example.dz3.UI.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_screen, ProfileFragment.newInstance())
                .commitNow()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_screen, NavbarFragment.newInstance())
                .commitNow()


        }
    }

}