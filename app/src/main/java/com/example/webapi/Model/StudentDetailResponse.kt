package com.example.webapi.Model

import com.google.gson.annotations.SerializedName

data class StudentDetailResponse (
    val status:Boolean,
    @SerializedName("result")
    val StudentList:Student
        )