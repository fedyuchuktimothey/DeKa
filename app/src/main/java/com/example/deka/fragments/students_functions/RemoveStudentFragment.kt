package com.example.deka.fragments.students_functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.HashMap

class RemoveStudentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_remove_student, container, false)
        val studNameRemove = view.findViewById<EditText>(R.id.studNameRemove)
        val studSurnameRemove = view.findViewById<EditText>(R.id.studSurnameRemove)
        val removeStudent = view.findViewById(R.id.removeStudent) as Button
        val db = Firebase.firestore
        removeStudent.setOnClickListener(){
            db.collection("Students").document("${studSurnameRemove.text} ${studNameRemove.text}")
                .delete()
                .addOnSuccessListener { documentReference ->
                    //  Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    // Log.w(TAG, "Error adding document", e)
                }
            NavHostFragment.findNavController(this).navigate(R.id.studFunctionsFragment)
        }

        return view
    }

}