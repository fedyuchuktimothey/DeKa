package com.example.deka.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.deka.R

class MainFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        //Students Functions Button
        val studFunc = view.findViewById(R.id.studFunc) as Button
        val studFunctionsFragment = StudFunctionsFragment()
        studFunc.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, studFunctionsFragment)?.addToBackStack("MainFragment")?.commit()
        }

        // Find Button
        val find = view.findViewById(R.id.find) as Button
        val findFragment = FindFragment()
        find.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, findFragment)?.addToBackStack("MainFragment")?.commit()
        }

        //Students Performance Button
        val studPerfor = view.findViewById(R.id.studPerfor) as Button
        val studPerforFragment = StudPerforFragment()
        studPerfor.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, studPerforFragment)?.addToBackStack("MainFragment")?.commit()
        }

        //Groups Functions Button
        val groupFunc = view.findViewById(R.id.groupFunc) as Button
        val groupsFunctionsFragment = GroupsFunctionsFragment()
        groupFunc.setOnClickListener() {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, groupsFunctionsFragment)?.addToBackStack("MainFragment")?.commit()
        }

        return view
    }
}