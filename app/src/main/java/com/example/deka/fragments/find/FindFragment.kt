package com.example.deka.fragments.find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.deka.R

class FindFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_find, container, false)
        // Find student by data
        val findStudentData = view.findViewById(R.id.findStudentData) as Button
        findStudentData.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.dataStudFormFragment, null))
        //Find all group's students
        val allGroupStudentsFind = view.findViewById(R.id.allGroupStudentsFind) as Button
        allGroupStudentsFind.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.allGroupStudentFragment, null))
        // Find successful students
        val succsessStudFind = view.findViewById(R.id.succsessStudFind) as Button
        succsessStudFind.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.successStudFragment, null))
        // Find unsuccessful students
        val unsuccessStudFind = view.findViewById(R.id.unsuccessStudFind) as Button
        unsuccessStudFind.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.unsuccessStudFragment, null))
        // Find students by score
        val scoreStudFind = view.findViewById(R.id.scoreStudFind) as Button
        scoreStudFind.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.scoreStudFormFragment, null))
        return view
    }
}