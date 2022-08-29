package com.javad.grammar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val recyclerViewIntent = Intent(this, MainActivity::class.java)
        val recyclerViewNoteIntent = Intent(this, NoteActivity::class.java)

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_dashboard -> startActivity(recyclerViewIntent)
                R.id.ic_settings -> startActivity(recyclerViewNoteIntent)
                R.id.ic_info -> startActivity(recyclerViewIntent)
            }
            true
        }





    }
}