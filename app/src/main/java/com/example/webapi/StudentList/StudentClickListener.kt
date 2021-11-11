package com.example.webapi.StudentList

import com.example.webapi.Model.Student

interface StudentClickListener {
    fun clickStudent(student: Student)
    fun studentdelete(student: Student)
    fun studentmodify(student: Student)
}