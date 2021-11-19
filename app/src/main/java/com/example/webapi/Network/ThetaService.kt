package com.example.webapi.Network

import com.example.webapi.Model.AddStudentResponse
import com.example.webapi.Model.ListResponse
import com.example.webapi.Model.Student
import com.example.webapi.Model.StudentDetailResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ThetaService {

   @GET("Home/StudentList")
   fun getStudentist(): Call<ListResponse>
@GET("/Home/GetStudentDetail")
   fun GetStudentDetail(
    @Query("id") id: Int?):Call<StudentDetailResponse>
@POST("Home/AddStudent")
fun AddStudentDetails(
    @Body() student: Student?
):Call<AddStudentResponse>

    companion object{
        private var retrofit: Retrofit? =null

        fun getretrofitInstance(): ThetaService? {
            if(retrofit==null)
            {
                retrofit=Retrofit.Builder()
                    .baseUrl("http://androidwebapi.somee.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit?.create(ThetaService::class.java)
        }

    }

}