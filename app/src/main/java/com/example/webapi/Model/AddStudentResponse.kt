package com.example.webapi.Model

import com.google.gson.annotations.SerializedName

class AddStudentResponse (
    val status:Boolean,
    @SerializedName("result")
    val Message:String
    )