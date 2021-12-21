package com.example.deka.fragments.stud_perfor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.deka.R
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RemoveSubjectFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_remove_subject, container, false)
        val studName = view.findViewById(R.id.removeStudName) as EditText
        val studSurname = view.findViewById(R.id.removeStudSurname) as EditText
        val removeSubjectName = view.findViewById(R.id.removeSubjectName) as EditText
        val subjectRemove = view.findViewById(R.id.subjectRemove) as Button
        val db = Firebase.firestore
        subjectRemove.setOnClickListener{
            val updates = hashMapOf<String, Any>(
                removeSubjectName.text.toString() to FieldValue.delete())
            db.collection("Students").document("${studSurname.text} ${studName.text}").update(updates)
            NavHostFragment.findNavController(this).navigate(R.id.studPerforFragment)
        }
        return view
    }
}