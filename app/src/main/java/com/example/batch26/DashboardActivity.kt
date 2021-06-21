package com.example.batch26

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    private lateinit var btnAdd : Button
    private lateinit var btnListview : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        btnAdd = findViewById(R.id.btnAdd)
        btnListview = findViewById(R.id.btnListview)


        btnAdd.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }

        btnListview.setOnClickListener {
            startActivity(Intent(this,CountryActivity::class.java))
        }
    }
}