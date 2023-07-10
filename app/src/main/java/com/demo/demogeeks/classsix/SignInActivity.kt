package com.demo.demogeeks.classsix

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()

        binding.tvRegister.setOnClickListener(){
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
         binding.SignIn.setOnClickListener(){
             val email = binding.edtEmail.text.toString()
             val pass = binding.edtPassword.text.toString()

             if (email.isNotEmpty() && pass.isNotEmpty()){

                 firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                     if (it.isSuccessful){
                       val intent = Intent(this, HomeAuthActivity::class.java)
                       startActivity(intent)
                     }else{
                         Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()

                     }
                 }

             }else{
                 Toast.makeText(this,"Empty fields not allowed", Toast.LENGTH_LONG).show()
             }
         }
    }

    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser!=null){
            val intent = Intent(this, HomeAuthActivity::class.java)
            startActivity(intent)
        }
    }
}