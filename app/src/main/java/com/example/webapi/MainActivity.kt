package com.example.webapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webapi.StudentList.StudentListActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StudentList.setOnClickListener {
            val i = Intent(this, StudentListActivity::class.java)
            startActivity(i)
        }
        AddStudent.setOnClickListener {

        }
    }
}