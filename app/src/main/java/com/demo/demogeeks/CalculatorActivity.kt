package com.demo.demogeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private var number:String?= null
    private var firstNumber:Double=0.0
    private var lastNumber:Double=0.0
    private var status:String?=null
    private var operator:Boolean= false
    private var myFormatter = DecimalFormat("#####.#####")
    private var history:String?=null
    private var currentResult:String?=null
    private var dot:Boolean= true
    private var btnAcControl:Boolean= true
    private var btnEqualsControl:Boolean= false

    private lateinit var textViewResult:TextView
    private lateinit var texViewHistory:TextView
    private lateinit var btnDel:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        textViewResult = findViewById(R.id.textViewResult)
        texViewHistory = findViewById(R.id.textViewHistory)
        btnDel = findViewById(R.id.btnDel)

    }

    override fun onClick(v: View?) {
        if(v !=null){
            when(v.id){
                R.id.btn0 ->{
                    numberClick("0")
                }
                R.id.btn1 ->{
                    numberClick("1")
                }
                R.id.btn2 ->{
                    numberClick("2")
                }
                R.id.btn3 ->{
                    numberClick("3")
                }
                R.id.btn4 ->{
                    numberClick("4")
                }
                R.id.btn5 ->{
                    numberClick("5")
                }
                R.id.btn6 ->{
                    numberClick("6")
                }
                R.id.btn7 ->{
                    numberClick("7")
                }
                R.id.btn8 ->{
                    numberClick("8")
                }
                R.id.btn9 ->{
                    numberClick("9")
                }
                R.id.btnAC->{
                 number=null
                    status=null
                    textViewResult.text="0"
                    texViewHistory.text=""
                    firstNumber=0.0
                    lastNumber=0.0
                    dot= true
                    btnAcControl=true

                }
                R.id.btnDel->{
                   if (btnAcControl){
                       textViewResult.text="0"
                   }
                    else{
                        number=number?.substring(0,number!!.length-1)
                        if (number?.isEmpty()==true){
                            btnDel.isClickable=false
                        }else dot=!number?.contains(".")!!
                       textViewResult.text=number
                   }
                }
                R.id.btnPlus->{
                    history= texViewHistory.text.toString()
                    currentResult= textViewResult.text.toString()
                    texViewHistory.text ="$history$currentResult"
                    plus()
                    status="sum"
                    operator=false
                    number=null
                }
                R.id.btnMinus->{
                    history= texViewHistory.text.toString()
                    currentResult= textViewResult.text.toString()
                    texViewHistory.text ="$history$currentResult"
                    minus()
                    status="subtraction"
                    operator=false
                    number=null
                }
                R.id.btnMultiple->{
                    history= texViewHistory.text.toString()
                    currentResult= textViewResult.text.toString()
                    texViewHistory.text ="$history$currentResult"
                    multiply()
                    status="multiplication"
                    operator=false
                    number=null
                } R.id.btnDivide->{
                history= texViewHistory.text.toString()
                currentResult= textViewResult.text.toString()
                texViewHistory.text ="$history$currentResult"
                divide()
                status="division"
                operator=false
                number=null
                }
                R.id.btnEquals->{
                  if (operator){
                      when(status){
                          "sum"->{
                              plus()
                          }
                          "subtraction"->{
                              minus()
                          }
                          "multiplication"->{
                              multiply()
                          }
                          "division"->{
                              divide()
                          }
                          else->{
                            firstNumber= (textViewResult.text.toString()).toDouble()
                          }
                      }
                  }
                    operator=false
                    btnEqualsControl=true
                    texViewHistory.text=""
                }
                R.id.btnDot->{
                 if(dot){
                     if (number==null){
                         number="0."
                     }
                     else{
                         number+="."
                     }
                 }
                    textViewResult.text=number
                    dot=false
                }
            }
        }

    }

    private fun numberClick(value: String) {
       when{
           number==null->{
               number=value
           }
           btnEqualsControl->{
               firstNumber =0.0
               lastNumber=0.0
               number= value
           }
           else->{
               number+=value
           }
       }
       textViewResult.text =number
       operator=true
       btnAcControl=false
       btnDel.isClickable=true
       btnEqualsControl=false
    }


    private fun plus(){
     lastNumber = (textViewResult.text.toString()).toDouble()
        firstNumber+=lastNumber
        textViewResult.text=myFormatter.format(firstNumber)
        dot=true
    }
    private fun minus(){
      if (firstNumber==0.0){
          firstNumber = (textViewResult.text.toString()).toDouble()
      }else{
          lastNumber = (textViewResult.text.toString()).toDouble()
          firstNumber -= lastNumber
      }
        textViewResult.text=myFormatter.format(firstNumber)
        dot=true
    }
    private fun multiply(){
        if (firstNumber==0.0){
            firstNumber=1.0
            lastNumber = (textViewResult.text.toString()).toDouble()
            firstNumber*=lastNumber
        }else{
            lastNumber = (textViewResult.text.toString()).toDouble()
            firstNumber *= lastNumber
        }
        textViewResult.text=myFormatter.format(firstNumber)
        dot=true
    }
    private fun divide(){
        if (firstNumber==0.0){
            lastNumber = (textViewResult.text.toString()).toDouble()
            firstNumber=lastNumber/1
        }else{
            lastNumber = (textViewResult.text.toString()).toDouble()
            firstNumber /= lastNumber
        }
        textViewResult.text=myFormatter.format(firstNumber)
        dot=true
    }
}