package com.example.webapi.StudentList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webapi.Model.ListResponse
import com.example.webapi.Model.Student
import com.example.webapi.Model.StudentDetailResponse
import com.example.webapi.Network.ThetaService
import com.example.webapi.R
import kotlinx.android.synthetic.main.activity_student_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentListActivity : AppCompatActivity() {
    var studentadapter= StudentAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        studentListRecyclerView.apply{
            layoutManager=
                LinearLayoutManager(this@StudentListActivity, LinearLayoutManager.VERTICAL,false)
            adapter=studentadapter
        }

    }

fun getStudentList(){
    val retrofit = ThetaService.getretrofitInstance()
    //val call: Call<ListResponse>? = retrofit?.AddStudentDetails(Student)
    val call: Call<ListResponse>? = retrofit?.getStudentist()
    //val call: Call<StudentDetailResponse>? = retrofit?.GetStudentDetail(2)

    call?.enqueue(object : Callback<ListResponse> {
        override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {

            response.body()?.StudentList?.let { studentadapter.studentList(it) }
        }

        override fun onFailure(call: Call<ListResponse>, t: Throwable) {
            TODO()

        }

    })
}

}