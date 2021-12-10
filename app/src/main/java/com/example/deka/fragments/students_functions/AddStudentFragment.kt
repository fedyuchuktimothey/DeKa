package com.example.deka.fragments.students_functions

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddStudentFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        val studName = view.findViewById<EditText>(R.id.studName).text.toString()
        val studSurname = view.findViewById<EditText>(R.id.studSurname).text.toString()
        val studGroup = view.findViewById<EditText>(R.id.studGroupNumber).text.toString()
        val addNewStud = view.findViewById(R.id.addNewStud) as Button
        val db = Firebase.firestore
        val fullName = "$studSurname $studName"
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )
        addNewStud.setOnClickListener(){
            db.collection("Students")
                .add(user)
                .addOnSuccessListener {
                    val toast = Toast.makeText(activity?.applicationContext, "Well", Toast.LENGTH_SHORT)
                    toast.show()
                    System.out.println("hhhhhhhhhhhh")

                }
                .addOnFailureListener {
                    val toast = Toast.makeText(activity?.applicationContext, "Bad", Toast.LENGTH_SHORT)
                    toast.show()
                    System.out.println("gggggggggggggg")

                }
        }

        return view
    }

}