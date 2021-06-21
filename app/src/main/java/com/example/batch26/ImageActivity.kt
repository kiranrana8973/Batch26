package com.example.batch26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import com.bumptech.glide.Glide

class ImageActivity : AppCompatActivity() {

    private lateinit var rdoDahayang : RadioButton
    private lateinit var rdoBhuwanKC : RadioButton
    private lateinit var rdoRajeshHamal : RadioButton

    private lateinit var profileImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

//        val first = 2
//        val second = 4
//        val result = first + first


        profileImage = findViewById(R.id.img)
        rdoDahayang = findViewById(R.id.rdoDahayang)
        rdoBhuwanKC = findViewById(R.id.rdoBhuwan)
        rdoRajeshHamal = findViewById(R.id.rdoRajesh)

        rdoDahayang.setOnClickListener {
            profileImage.setImageResource(R.drawable.dahayangrai)
        }

        rdoRajeshHamal.setOnClickListener {
            profileImage.setImageResource(R.drawable.rajeshhamal)
        }

        rdoBhuwanKC.setOnClickListener {
            Glide.with(this)
                .load("https://www.celebrityborn.com/admin/assets/images/people/bhuwan_k.c._519.jpg")
                .centerCrop()
                .into(profileImage)

        }

    }
}