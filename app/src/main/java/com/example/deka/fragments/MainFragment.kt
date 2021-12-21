package com.example.deka.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.deka.R
import com.example.deka.fragments.find.FindFragment
import com.example.deka.fragments.groups_functions.GroupsFunctionsFragment
import com.example.deka.fragments.stud_perfor.StudPerforFragment
import com.example.deka.fragments.students_functions.StudFunctionsFragment

class MainFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        //Students Functions Button
        val studFunc = view.findViewById(R.id.studFunc) as Button
        studFunc.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.studFunctionsFragment, null))

        // Find Button
        val find = view.findViewById(R.id.find) as Button
        find.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.findFragment, null))

        //Students Performance Button
        val studPerfor = view.findViewById(R.id.studPerfor) as Button
        studPerfor.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.studPerforFragment, null))

        //Groups Functions Button
        val groupFunc = view.findViewById(R.id.groupFunc) as Button
        groupFunc.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.groupsFunctionsFragment, null))


        return view
    }
}