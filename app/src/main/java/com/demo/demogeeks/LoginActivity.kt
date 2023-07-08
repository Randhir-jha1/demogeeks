package com.demo.demogeeks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var edtEmail:EditText
    lateinit var edtPass:EditText
    lateinit var SignIn:Button
    lateinit var strEmail:String
    lateinit var strPassword:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()
        onClick()

    }
    private fun initUi(){
        edtEmail= findViewById(R.id.edtEmail)
        edtPass= findViewById(R.id.edtPassword)
        SignIn= findViewById(R.id.SignIn)
    }

    private fun onClick(){


        SignIn.setOnClickListener(){
            strEmail= edtEmail.text.toString()
            strPassword= edtPass.text.toString()
//             if(checkCondition()
//             ){
//                 //Toast.makeText(this,strEmail+" "+strPassword,Toast.LENGTH_LONG).show()
//
//             }

            //Simple move from one activity to other

            //            val intent= Intent(this@LoginActivity,IntentDemoActivity::class.java)
//                 startActivity(intent)
            //Pass value to other Activity


//            val intent= Intent(this@LoginActivity,IntentDemoActivity::class.java)
//            intent.putExtra("Email",strEmail)
//            intent.putExtra("Password",strPassword)
//            startActivity(intent)

            // Paassing dataclass from one activity to Another

            val students = Students("Randhir",28)
            val intent= Intent(this@LoginActivity,IntentDemoActivity::class.java)
             intent.putExtra("studentData",students)
            startActivity(intent)
        }


    }

    private fun checkCondition():Boolean{
        if(strEmail.length<5){
            edtEmail.error= getString(R.string.invalid_email)
            return false
        }
        else{
            return true
        }

    }
//    private fun isValidation(): Boolean{
//        if(binding.edtEmail.text.toString().trim().length==0){
//            binding.edtEmail.requestFocus()
//            binding.edtEmail.error=getString(R.string.please_enter_email)
//            return false
//        }
//        if(binding.edtPassword.text.toString().trim().length==0){
//            binding.edtPassword.requestFocus()
//            binding.edtPassword.error=getString(R.string.please_enter_password)
//            return false
//        }
//        return true
//    }
}