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
            btn0.id -> currentOp += Numbers.zero
            btn1.id -> currentOp += Numbers.one
            btn2.id -> currentOp += Numbers.two
            btn3.id -> currentOp += Numbers.three
            btn4.id -> currentOp += Numbers.four
            btn5.id -> currentOp += Numbers.five
            btn6.id -> currentOp += Numbers.six
            btn7.id -> currentOp += Numbers.seven
            btn8.id -> currentOp += Numbers.eight
            btn9.id -> currentOp += Numbers.nine
            btnDot.id ->  currentOp = dotLogic(currentOp)
            btnPlusMinus.id -> currentOp = plusMinusLogic(currentOp)
        }

        etShowOp.setText(currentOp)

    }

    private fun dotLogic(currentOp: String):String {

        if (currentOp.indexOf(Numbers.dot) == -1 ){

            return currentOp + Numbers.dot
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
            btnMul.id -> op = Operators.multiply
            btnDiv.id -> op = Operators.divide
            btnSub.id -> op = Operators.subtract
            btnPlus.id -> op = Operators.add
        }

        oldNumber = etShowOp.text.toString()
        isNewOP = true

    }

        var finalNum: Double? = null

    fun btnEqualsEvent(view:View){

        val newNumber = etShowOp.text.toString()
       

        when(op){
            Operators.multiply ->  finalNum = oldNumber.toDouble() * newNumber.toDouble()
            Operators.divide -> finalNum = oldNumber.toDouble() / newNumber.toDouble()
            Operators.add -> finalNum = oldNumber.toDouble() + newNumber.toDouble()
            Operators.subtract -> finalNum = oldNumber.toDouble() - newNumber.toDouble()
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
