package com.example.deka.fragments.stud_perfor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.deka.R

class StudPerforFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stud_perfor, container, false)
        // Add new subject
        val addSubject = view.findViewById(R.id.addSubject) as Button
        addSubject.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addSubjectFragment, null))
        // Remove subject
        val removeSubject = view.findViewById(R.id.removeSubject) as Button
        removeSubject.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.removeSubjectFragment, null))
        // Add / change grades
        val addChangeGrade = view.findViewById(R.id.addGrades) as Button
        addChangeGrade.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addGradesFragment, null))
        return view
    }
}