package com.example.signinwithgogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            /** If user is not authenticated, send him to signInPage to authenticate first.
             * else send him to HomePage */
            if (user != null){
                val homepageintent = Intent(this,HomePage::class.java)
                startActivity(homepageintent)
                finish()
            }else{
                val signInIntent = Intent(this, SignInPage::class.java)
                startActivity(signInIntent)
                finish()
            }

        }, 2000)

    }

}