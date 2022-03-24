package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

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
// since we are using let, we have to use it and if for operator
fun onOperator(view: View){
    tvInput?.text?.let {
// the numbers has to be set after a equation is set, so that no other operator can be added.
        if(lastNumeric && !isOperatorAdded(it.toString())){
            tvInput?.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }
}
// takes string into text for value
    fun onEqual(view : View){
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()
// prevents app from crashing using the try method. Then it will print into the case when errors
            var prefix = ""
            try{
                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1) // this will remove first value
                }
                val splitValue = tvValue.split("-")
                var one = splitValue[0] // example 99
                var two = splitValue[1] // example 1
 // this is going to split the entries.
 // use double to make the answer into a decimal number. 00.0
                tvInput?.text = (one.toInt() - two.toInt()).toString()


            }catch(e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }


// To add a prefix, select options after value and enter in ""
    private fun isOperatorAdded(value : String) : Boolean {
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
                    || value.contains("=")
        }
    }
