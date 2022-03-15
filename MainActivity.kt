package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null

    // dot is now treated as a dot instead of as a number. This due to the boolean value being false.

    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)

    }


    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }


    fun onClear(view: View) {
        tvInput?.text = ""
    }


    // execute code to append now and Flags, it will help us know what is active.
    fun onDecimalPoint(view: View) {
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
// To adda prefix, select options after value and enter in ""
    private fun isOperartorAdded(value : String) : Boolean {
        return if(value.startsWith("-")){
            false
        }
    }
}
