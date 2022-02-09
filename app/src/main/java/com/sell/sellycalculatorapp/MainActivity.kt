package com.sell.sellycalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        clearBtn.setOnClickListener{
            numbersInput.text=""
            result.text=""
        }

        openBracket.setOnClickListener{
            numbersInput.text= addToInputText("(")
        }

        closeBracket.setOnClickListener{
            numbersInput.text= addToInputText(")")
        }

        zero.setOnClickListener{
            numbersInput.text= addToInputText("0")
        }

        one.setOnClickListener{
            numbersInput.text= addToInputText("1")
        }

        two.setOnClickListener{
            numbersInput.text= addToInputText("2")
        }

        three.setOnClickListener{
            numbersInput.text= addToInputText("3")
        }

        four.setOnClickListener{
            numbersInput.text= addToInputText("4")
        }

        five.setOnClickListener{
            numbersInput.text= addToInputText("5")
        }

        six.setOnClickListener{
            numbersInput.text= addToInputText("6")
        }

        seven.setOnClickListener{
            numbersInput.text= addToInputText("7")
        }

        eight.setOnClickListener{
            numbersInput.text= addToInputText("8")
        }

        nine.setOnClickListener{
            numbersInput.text= addToInputText("9")
        }

        dot.setOnClickListener{
            numbersInput.text= addToInputText(".")
        }

        add.setOnClickListener{
            numbersInput.text= addToInputText("+")
        }

        multiply.setOnClickListener{
            numbersInput.text= addToInputText("×") // ALT + 0215
        }

        divide.setOnClickListener{
            numbersInput.text= addToInputText("÷") // ALT + 0247
        }

        minus.setOnClickListener{
            numbersInput.text= addToInputText("-")
        }

        equals.setOnClickListener{
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String{
        return "${numbersInput.text}$buttonValue"
    }

    private fun getInput(): String{
        var expression= numbersInput.text.replace(Regex("÷"), "/")
        expression= expression.replace(Regex("×"), "*")
        return expression

    }

    private fun showResult(){
        try {
            val expression= getInput()
            val output= Expression(expression).calculate()

            if (output.isNaN()){
                // Showing error message
                result.text= "ERROR"
                result.setTextColor(ContextCompat.getColor(this, R.color.red1))

            } else{

                result.text= DecimalFormat("0.######").format(output).toString()
                result.setTextColor(ContextCompat.getColor(this, R.color.white))
            }

        } catch (e:Exception){
            result.text= "ERROR"
            result.setTextColor(ContextCompat.getColor(this, R.color.red1))



        }

    }

}