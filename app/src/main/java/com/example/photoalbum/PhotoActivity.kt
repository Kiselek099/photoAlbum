package com.example.photoalbum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PhotoActivity : AppCompatActivity() {
    private val photos = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5
    )
    private var currentIndex = 0
    lateinit var photoIV:ImageView
    lateinit var nextBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        photoIV=findViewById(R.id.photoIV)
        nextBTN=findViewById(R.id.nextBTN)
        photoIV.setImageResource(photos[currentIndex])

        nextBTN.setOnClickListener {
            currentIndex++
            if (currentIndex < photos.size) {
                photoIV.setImageResource(photos[currentIndex])
            } else {
                val intent = Intent(this, EndActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}