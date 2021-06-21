package com.example.batch26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountryActivity : AppCompatActivity() {

    val countriesCapitals = mapOf(
        "Nepal" to "Kathmandu",
        "India" to "New Delhi",
        "China" to "Beijing"
    )

    val students = arrayOf("Kiran", "Salman", "Katrina")
    private lateinit var lstView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        lstView = findViewById(R.id.listCountry)
        
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countriesCapitals.keys.toTypedArray()
        )
//       val adapter = ArrayAdapter(
//           this,
//           android.R.layout.simple_list_item_1,
//           students
//       )
//
        lstView.adapter = adapter

        lstView.setOnItemClickListener { parent, view, position, id ->
            val country = parent.getItemAtPosition(position).toString()
            val capital = countriesCapitals.get(country)

            Toast.makeText(this, "$country capital is $country", Toast.LENGTH_SHORT).show()
        }

    }
}