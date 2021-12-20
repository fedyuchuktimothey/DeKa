package com.example.deka.fragments.students_functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.deka.R

class StudFunctionsFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stud_functions, container, false)

        //Add student button
        val addStud = view.findViewById(R.id.addStud) as Button
        addStud.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addStudentFragment, null))

        //Remove student button
        val removeStud = view.findViewById(R.id.removeStud) as Button
        removeStud.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.removeStudentFragment, null))

        //Edit student button
        val changeStudent = view.findViewById(R.id.changeStud) as Button
        changeStudent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.changeStudentInfoFragment, null))

        // All students button
        val showAllStud = view.findViewById(R.id.showAllStud) as Button
        showAllStud.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.allStudentsListFragment, null))

        return view
    }
}