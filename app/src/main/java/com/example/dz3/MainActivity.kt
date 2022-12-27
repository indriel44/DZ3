package com.example.dz3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz3.UI.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_screen, MainFragment.newInstance())
                .commitNow()
        }

    }

}