package com.example.todolist

import android.widget.CheckBox
import android.widget.TextView

data class Tasks(
    var task_text : String,
    var status : Boolean = false ,
    var checkBox: CheckBox,
    var task: TextView

)
