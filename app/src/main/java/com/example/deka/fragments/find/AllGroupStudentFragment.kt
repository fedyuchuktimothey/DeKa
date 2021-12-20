package com.example.deka.fragments.find

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AllGroupStudentFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_group_student, container, false)
        val listview=view.findViewById(R.id.listVIew2) as ListView
        val showList = view.findViewById(R.id.showListFind) as Button
        val groupFind = view.findViewById(R.id.groupFind) as EditText
        val arrayList = ArrayList<String>()
        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(
            view.context, android.R.layout.simple_list_item_1, arrayList)
        val db = Firebase.firestore
        showList.setOnClickListener {
            //TODO need fix dublicate list
            db.collection("Students")
                .whereEqualTo("group", groupFind.text.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        arrayList.add(document.id)

                        Log.d("All documents", "${document.id} => ${document.data["group"]}")

                    }
                }
                .addOnFailureListener { exception ->
                }
            listview.adapter = adapter

        }
        return view
    }
}