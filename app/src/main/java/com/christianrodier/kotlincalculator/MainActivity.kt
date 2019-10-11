package com.christianrodier.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumEvent(view: View){
        if (isNewOP){
            etShowOp.setText("")
        }
        isNewOP = false

        var btnSelected = view as Button

        var currentOp:String = etShowOp.text.toString()

        when(btnSelected.id){
            btn0.id -> currentOp += "0"
            btn1.id -> currentOp += "1"
            btn2.id -> currentOp += "2"
            btn3.id -> currentOp += "3"
            btn4.id -> currentOp += "4"
            btn5.id -> currentOp += "5"
            btn6.id -> currentOp += "6"
            btn7.id -> currentOp += "7"
            btn8.id -> currentOp += "8"
            btn9.id -> currentOp += "9"
            btnDot.id ->  currentOp = dotLogic(currentOp)
            btnPlusMinus.id -> currentOp = plusMinusLogic(currentOp)
        }

        etShowOp.setText(currentOp)

    }

    private fun dotLogic(currentOp: String):String {

        if (currentOp.indexOf('.') == -1 ){

            return currentOp + "."
        }
        return currentOp

    }

    private fun plusMinusLogic(currentOp: String):String {

        try {
            return (currentOp.toDouble() * -1).toString()
        }
        catch (e: Exception)
        {
             return (finalNum!! * -1).toString()

        }

    }

    var op = "*"
    var oldNumber = ""
    var isNewOP = true

    fun btnOpEvent(view: View){

        var btnSelected = view as Button

        when(btnSelected.id){
            btnMul.id -> op="*"
            btnDiv.id -> op="/"
            btnSub.id -> op = "-"
            btnPlus.id -> op = "+"
        }

        oldNumber = etShowOp.text.toString()
        isNewOP = true

    }

        var finalNum: Double? = null

    fun btnEqualsEvent(view:View){

        val newNumber = etShowOp.text.toString()
       // var finalNum:Double? = null

        when(op){
            "*"->  finalNum = oldNumber.toDouble() * newNumber.toDouble()
            "/"-> finalNum = oldNumber.toDouble() / newNumber.toDouble()
            "+"-> finalNum = oldNumber.toDouble() + newNumber.toDouble()
            "-"-> finalNum = oldNumber.toDouble() - newNumber.toDouble()
        }

        etShowOp.setText(finalNum.toString())
        isNewOP = true


    }

    fun btnPercent(view:View){

        val number = etShowOp.text.toString().toDouble() / 100

        etShowOp.setText(number.toString())

    }

    fun btnClean(view: View){
        etShowOp.setText("")
        isNewOP = true
    }


}
