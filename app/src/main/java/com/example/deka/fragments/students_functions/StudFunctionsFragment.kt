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

        //Add student button Button
        val addStud = view.findViewById(R.id.addStud) as Button
        val addStudentFragment = AddStudentFragment()
        addStud.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, addStudentFragment)?.addToBackStack("StudFunctionsFragment")?.commit()
        }

        return view
    }
}