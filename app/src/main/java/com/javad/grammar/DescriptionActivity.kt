package com.javad.grammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val image: ImageView = findViewById(R.id.descriptionImageView)
        val text: TextView = findViewById(R.id.descriptionTextView)

        val bundle:Bundle? = intent.extras
        val getDescription=bundle!!.getString("description")
        val getImage=bundle.getInt("image")

        image.setImageResource(getImage)
        text.text=getDescription
    }
}