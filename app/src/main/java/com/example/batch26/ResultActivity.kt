package com.example.batch26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResult : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tvResult = findViewById(R.id.tvResult)
//        val result = intent.getIntExtra("result",0)
//
//        tvResult.text ="Sum is : ${result}"

        var a : Int = 0
        if(intent.getStringArrayListExtra("lst") != null){
            val result  = intent.getStringArrayListExtra("lst")!! as ArrayList<Student>
            for(student in result){
                a += student.api!!
            }
            val c = a
        }


        tvResult.text = a.toString()

    }
}