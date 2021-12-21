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
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddSubjectFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_subject, container, false)
        val studName = view.findViewById(R.id.subjectStudName) as EditText
        val studSurname = view.findViewById(R.id.subjectStudSurname) as EditText
        val newSubject = view.findViewById(R.id.newSubject) as EditText
        val addNewSubject = view.findViewById(R.id.addNewSubject) as Button
        val db = Firebase.firestore
        addNewSubject.setOnClickListener{
            val data = hashMapOf("System" to "System")

            db.collection("Students").document("${studSurname.text} ${studName.text}").update("${newSubject.text}", data)
            NavHostFragment.findNavController(this).navigate(R.id.studPerforFragment)
        }
        return view
    }
}