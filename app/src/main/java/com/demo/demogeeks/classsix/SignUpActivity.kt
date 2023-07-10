package com.demo.demogeeks.classsix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.demogeeks.R
import com.demo.demogeeks.databinding.ActivitySignInBinding
import com.demo.demogeeks.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        binding.tvAlreadyRegistered.setOnClickListener(){
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.SignUp.setOnClickListener(){
            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPassword.text.toString()
            val confirmPass = binding.edtConfirmPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass==confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this,"Signup successfully",Toast.LENGTH_LONG).show()
                             val intent = Intent(this, SignInActivity::class.java)
                             startActivity(intent)
                             finish()

                        }
                    }
                }else{
                    Toast.makeText(this,"Password is not matching",Toast.LENGTH_LONG).show()

                }

            }else{
                Toast.makeText(this,"Empty fields not allowed",Toast.LENGTH_LONG).show()
            }
        }


    }
}