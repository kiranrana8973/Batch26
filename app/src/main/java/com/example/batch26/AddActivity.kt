package com.example.batch26

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.util.*

class AddActivity : AppCompatActivity() {
    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnTime: Button
    private lateinit var btnDate: Button
    private lateinit var tvOutput: TextView

    private lateinit var spinner: Spinner
    private lateinit var autoCompleteTextView: AutoCompleteTextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        btnAdd = findViewById(R.id.btnAdd)
        spinner = findViewById(R.id.spinner)
        autoCompleteTextView = findViewById(R.id.autoComplete)
        btnTime = findViewById(R.id.btnTime)
        btnDate = findViewById(R.id.btnDate)
        tvOutput = findViewById(R.id.tvOutput)


        btnDate.setOnClickListener {
            loadDate()
        }

        btnTime.setOnClickListener {
            loadTime()
        }

        val array = arrayOf("item1", "item2", "item3")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            array
        )
        spinner.adapter = adapter
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.threshold = 1



        btnAdd.setOnClickListener {

            addStudent()

//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("Addition")
//            builder.setMessage("Are you sure you want to add ?")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//            builder.setPositiveButton("Yes")
//            { _,_ ->
//                val first = etFirst.text.toString().toInt()
//                val second  = etSecond.text.toString().toInt()
//                val result = first + second
//
//                startActivity(Intent(this,ResultActivity::class.java).also {
//                    it.putExtra("result",result)
//                })
//                Toast.makeText(this, "clicked yes", Toast.LENGTH_SHORT).show()
//            }
//            builder.setNegativeButton("No"){
//                _,_ ->
//                Toast.makeText(this, "clicked no", Toast.LENGTH_SHORT).show()
//            }
//
//            val alertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
        }
    }

    private fun addStudent() {
        val lstStudent = ArrayList<Student>()
        lstStudent.add(Student(1, "Kiran", 1, 2, 3))
        lstStudent.add(Student(134, "Kiran", 1, 2, 3))
        lstStudent.add(Student(13, "Kiran", 1, 2, 3))


        startActivity(Intent(this, ResultActivity::class.java).also {
            it.putParcelableArrayListExtra("lst",lstStudent)
        })
    }

    private fun loadTime() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                tvOutput.text = "$hour : $minute"
            },
            hour,
            minute,
            true
        ).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tvOutput.text = "Selected date : ${dayOfMonth + 1} - $month - $year"
            },
            year,
            month,
            day
        ).show()
    }
}