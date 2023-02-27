package com.example.github_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add The Data To Firestore
        // Test To Update 
        save.setOnClickListener {
            var name = myName.text.toString()
            var email = email.text.toString()
            var age = age.text.toString()
            val person = hashMapOf(
                "name" to name,
                "email" to email,
                "age" to age )
            db.collection("All Person").add(person)
                .addOnSuccessListener { id ->
                    Toast.makeText(this,"This is ID : $id" , Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"I am Sorry This Operation is Failure" , Toast.LENGTH_LONG).show()
                }
        }

    }
}