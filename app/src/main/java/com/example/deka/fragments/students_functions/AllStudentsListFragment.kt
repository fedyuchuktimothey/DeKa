package com.example.deka.fragments.students_functions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import android.widget.SimpleAdapter




class AllStudentsListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_groups_list, container, false)
        val db = Firebase.firestore
        val studentslist = ArrayList<HashMap<String, String>>()
        val student = HashMap<String,String >()
        val simpleAdapter = SimpleAdapter(
            activity, studentslist,
            R.layout.multilines_list, arrayOf("fullname", "group"), intArrayOf(R.id.full_name, R.id.group)
        )

        db.collection("Students")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val name = document.getString("name").toString()
                    val surname= document.getString("surname").toString()
                    val group = document.getString("group").toString()
                    Log.d("Name",name)
                    student.put("fullname", "$surname $name")
                    student.put("group", group)
                    studentslist.add(student)
                    val listview=activity?.findViewById(R.id.listView) as ListView
                    listview.adapter=simpleAdapter
                }
            }
            .addOnFailureListener { exception ->
            }

        return view
    }
}