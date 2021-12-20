package com.example.deka.fragments.groups_functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.deka.R

class GroupsFunctionsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_groups_functions, container, false)
        // Remove certain group
        val findStudentData = view.findViewById(R.id.findStudentData) as Button
        findStudentData.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.dataStudFormFragment, null))
        return view
    }
}