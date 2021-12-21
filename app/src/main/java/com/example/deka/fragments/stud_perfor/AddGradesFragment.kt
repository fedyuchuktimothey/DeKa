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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddGradesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_grades, container, false)
        val studName = view.findViewById(R.id.studNameGrade) as EditText
        val studSurname = view.findViewById(R.id.studSurnameGrade) as EditText
        val subjectName = view.findViewById(R.id.subjectsNameGrade) as EditText
        val date = view.findViewById(R.id.date) as EditText
        val grade = view.findViewById(R.id.grade) as EditText
        val addChangeGrade = view.findViewById(R.id.addChangeGrade) as Button
        val db = Firebase.firestore
        addChangeGrade.setOnClickListener{
            val data = hashMapOf(date.text.toString() to grade.text.toString())

            db.collection("Students").document("${studSurname.text} ${studName.text}").update("${subjectName.text}", data)
            NavHostFragment.findNavController(this).navigate(R.id.studPerforFragment)
        }
        return view
    }
}