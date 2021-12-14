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
        var listview:ListView
        val db = Firebase.firestore
        val studentslist = ArrayList<HashMap<String, String>>()
        val simpleAdapter = SimpleAdapter(
            activity, studentslist,
            R.layout.multilines_list, arrayOf("fullname", "group"), intArrayOf(R.id.full_name, R.id.group)
        )

        db.collection("Students")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val student = HashMap<String,String >()
                    student["fullname"] = document.id
                    student["group"] = document.data["group"].toString()
                    studentslist.add(student)
                    listview=activity?.findViewById(R.id.listView) as ListView
                    listview.adapter=simpleAdapter
                    Log.d("All documents", "${document.id} => ${document.data["group"]}")
                    Log.d("Student", student.toString())

                }
            }
            .addOnFailureListener { exception ->
            }
        return view
    }
}