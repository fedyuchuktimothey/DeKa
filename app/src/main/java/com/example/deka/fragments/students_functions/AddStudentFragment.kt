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
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.deka.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.HashMap

class AddStudentFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        val studName = view.findViewById<EditText>(R.id.studName)
        val studSurname = view.findViewById<EditText>(R.id.studSurname)
        val studGroup = view.findViewById<EditText>(R.id.studGroupNumber)
        val addNewStud = view.findViewById(R.id.addNewStud) as Button
        val db = Firebase.firestore
        addNewStud.setOnClickListener{

            val student = HashMap<String, Any>()
            student["name"] = studName.text.toString()
            student["surname"] = studSurname.text.toString()
            student["group"] = studGroup.text.toString()
            db.collection("Students").document("${studSurname.text} ${studName.text}")
                .set(student)
                .addOnSuccessListener { documentReference ->
                  //  Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                   // Log.w(TAG, "Error adding document", e)
                }
            findNavController(this).navigate(R.id.studFunctionsFragment)
        }
        return view
    }
}