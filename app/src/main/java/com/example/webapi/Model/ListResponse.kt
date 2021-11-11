package com.example.webapi.Model

import com.google.gson.annotations.SerializedName

data class ListResponse (
    val status:Boolean,
    @SerializedName("result")
    val StudentList:List<Student>
        )
data class Student(
    val id: Int,
    @SerializedName("firstName")
    val FirstName:String,
    val lastName:String,
    val phoneNo:String,
    val email:String,
    val marks:Float,
    val isActive:Boolean,


)