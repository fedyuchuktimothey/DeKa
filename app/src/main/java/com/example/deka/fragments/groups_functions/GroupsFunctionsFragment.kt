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
        val groupRemove = view.findViewById(R.id.groupRemove) as Button
        groupRemove.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.removeGroupFragment, null))
        // Add  group
        val addGroup = view.findViewById(R.id.addGroup) as Button
        addGroup.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addGroupFragment, null))
        return view
    }
}