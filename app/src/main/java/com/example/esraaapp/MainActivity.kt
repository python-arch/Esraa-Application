package com.example.esraaapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    private lateinit var database: DatabaseReference
// ...
    database = Firebase.database.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Get Post object and use the values to update the UI
            val post = dataSnapshot.getValue<Post>()
            // ...
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
        }
    }
    postReference.addValueEventListener(postListener)


    mDatabase.child("users").child(userId).get().addOnSuccessListener {
        Log.i("firebase", "Got value ${it.value}")
    }.addOnFailureListener{
        Log.e("firebase", "Error getting data", it)
    }
}