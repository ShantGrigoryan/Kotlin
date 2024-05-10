package com.example.todolist

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class UserPage : AppCompatActivity() {

    private lateinit var hourHand: ImageView
    private lateinit var minuteHand: ImageView
    private lateinit var secondHand: ImageView

    @SuppressLint("Range", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_page)
        var TaskList: MutableList<Tasks> = mutableListOf()
        val imageView: ImageView = findViewById(R.id.image_view)
        val tasks: LinearLayout = findViewById(R.id.LinLayout)
        val add_task: ImageButton = findViewById(R.id.append_task)
        var Welcome_text: TextView = findViewById(R.id.Welcome_Text)
        var checkBox: CheckBox
        var textView: TextView
        var linearLayout: LinearLayout

        hourHand = findViewById(R.id.hour_hand)
        minuteHand = findViewById(R.id.minute_hand)
        secondHand = findViewById(R.id.second_hand)

        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                updateClock()
                for (i in TaskList) {
                    if (i.checkBox.isChecked) {
                        i.status = true
                        if (!i.task.getPaint().isStrikeThruText()) {
                            i.task.setPaintFlags(i.task.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG);
                        }
                        else{
                            i.task.setPaintFlags(i.task.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG);

                        }
                    }
                }

                handler.postDelayed(this, 1000) // Update every second
            }
        })
 imageView.setOnClickListener{
     Welcome_text.text = Welcome_text.text.toString() + "User"
 }
        
        add_task.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enter Text")

            val input = EditText(this)
            builder.setView(input)

            builder.setPositiveButton("OK") { _, _ ->
                val enteredText = input.text.toString()

                linearLayout = LinearLayout(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(20, 10, 0, 20) // Set margins (left, top, right, bottom)
                    }
                    isClickable = true
                    orientation = LinearLayout.HORIZONTAL
                }
                checkBox = CheckBox(this).apply {
                    isChecked = false
                }
                textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    gravity = Gravity.CENTER
                    text = enteredText
                    textSize = 15F
                }

                TaskList.add(
                    Tasks(
                        textView.text.toString(), checkBox.isChecked,
                        checkBox, textView
                    )
                )
                linearLayout.addView(checkBox)
                linearLayout.addView(textView)
                tasks.addView(linearLayout)
            }

            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()

        }





    }
    private fun updateClock() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY) % 12 // 12-hour format
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)

        val hourRotation = hour * 30 + minute / 2
        val minuteRotation = minute * 6
        val secondRotation = second * 6

        hourHand.rotation = hourRotation.toFloat()
        minuteHand.rotation = minuteRotation.toFloat()
        secondHand.rotation = secondRotation.toFloat()
    }

}