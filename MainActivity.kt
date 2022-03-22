package com.example.mycalculator

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null

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


    fun onDecimalPoint(view: View) {
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

fun onOperator(view: View){
    tvInput?.text?.let {

        if(lastNumeric && !isOperatorAdded(it.toString())){
            tvInput?.append((view as Button).text)
        }
    }
}


// To add a prefix, select options after value and enter in ""
// added operartors to limit the values of math calc
    private fun isOperatorAdded(value : String) : Boolean {
        return if(value.startsWith("-")){
            false
        }else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
    
    private fun isOperatorAdded(value : String) : Boolean {
        return if(value.startsWith("-")){
            false
        }else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
    
}
