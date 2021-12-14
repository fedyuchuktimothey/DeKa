package com.example.deka.fragments.students_functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.HashMap

class ChangeStudentInfoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_change_student_info, container, false)
        val oldStudName = view.findViewById<EditText>(R.id.oldStudName)
        val newStudName = view.findViewById<EditText>(R.id.newStudName)
        val oldStudSurname = view.findViewById<EditText>(R.id.oldStudSurname)
        val newStudSurname = view.findViewById<EditText>(R.id.newStudSurname)
        val newStudGroup = view.findViewById<EditText>(R.id.newStudGroup)
        val updateStudInfo = view.findViewById(R.id.updateStudInfo) as Button
        val db = Firebase.firestore
        updateStudInfo.setOnClickListener(){
            val student = HashMap<String, Any>()
            student["name"] = newStudName.text.toString()
            student["surname"] = newStudSurname.text.toString()
            student["group"] = newStudGroup.text.toString()
            db.collection("Students").document("${oldStudSurname.text} ${oldStudName.text}")
                .delete()
                .addOnSuccessListener { documentReference ->
                    //  Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    // Log.w(TAG, "Error adding document", e)
                }
            db.collection("Students").document("${newStudSurname.text} ${newStudName.text}")
                .set(student)
                .addOnSuccessListener { documentReference ->
                    //  Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    // Log.w(TAG, "Error adding document", e)
                }
        }
        return view
    }
}