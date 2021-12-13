package com.example.deka.fragments.students_functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
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
        val addStudentFragment = AddStudentFragment()
        addStud.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, addStudentFragment)?.addToBackStack("StudFunctionsFragment")?.commit()
        }
        //Remove student button
        val removeStud = view.findViewById(R.id.removeStud) as Button
        val removeStudentFragment = RemoveStudentFragment()
        removeStud.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, removeStudentFragment)?.addToBackStack("StudFunctionsFragment")?.commit()
        }
        //Edit student button
        val changeStudent = view.findViewById(R.id.changeStud) as Button
        val changeStudentInfo = ChangeStudentInfo()
        changeStudent.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, changeStudentInfo)?.addToBackStack("StudFunctionsFragment")?.commit()
        }

        return view
    }
}