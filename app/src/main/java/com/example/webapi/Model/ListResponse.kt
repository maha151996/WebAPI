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
    var FirstName:String,
    @SerializedName("lastName")
    var LastName:String,
    @SerializedName("phoneNo")
    var PhoneNo:String,
    @SerializedName("email")
    var Email:String,
    @SerializedName("marks")
    var Marks: Double,
    @SerializedName("isActive")
    var IsActive:Boolean,


    )