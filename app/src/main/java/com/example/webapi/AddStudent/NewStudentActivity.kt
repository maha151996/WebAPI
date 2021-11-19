package com.example.webapi.AddStudent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.webapi.Model.AddStudentResponse
import com.example.webapi.Model.Student
import com.example.webapi.Network.ThetaService
import com.example.webapi.R
import com.example.webapi.StudentList.StudentListActivity
import kotlinx.android.synthetic.main.activity_new_student.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        //val URL=stdFirstName.text.toString() + ".com"
        submit.setOnClickListener {
            val std: Student?=Student(0,stdFirstName.text.toString(),stdLastName.text.toString(),stdPhoneNo.text.toString(),stdEmail.text.toString(),stdMArks.text.toString().toDouble(),true)
//val Student1=Student(
//    0,
//    "tooba",
//"ALi",
//    "03234567890",
//    "maha2gmail.com",
//    450.0,
//    true
//
//)
            SubmitStudent(std)

        }
    }

    fun SubmitStudent(std: Student?) {
       val retrofit=ThetaService.getretrofitInstance()
        val call: Call<AddStudentResponse>? = retrofit?.AddStudentDetails(std)
        call?.enqueue(object : Callback<AddStudentResponse> {
            override fun onResponse(call: Call<AddStudentResponse>, response: Response<AddStudentResponse>) {
             Toast.makeText(applicationContext,response.body()?.Message,Toast.LENGTH_LONG).show()
                val i = Intent(applicationContext, StudentListActivity::class.java)
                startActivity(i)
            }

            override fun onFailure(call: Call<AddStudentResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"Error!",Toast.LENGTH_LONG).show()


            }

        })
    }
}


