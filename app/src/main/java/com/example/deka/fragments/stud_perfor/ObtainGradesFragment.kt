package com.example.deka.fragments.stud_perfor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ObtainGradesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_obtain_grades, container, false)
        val studName = view.findViewById(R.id.studNameObtain) as EditText
        val studSurname = view.findViewById(R.id.studSurnameObtain) as EditText
        val showList = view.findViewById(R.id.showObjectsList) as Button
        val listview = view.findViewById(R.id.listViewSubjects) as ListView
        val db = Firebase.firestore
        val arrayList = ArrayList<String>()
        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(
            view.context, android.R.layout.simple_list_item_1, arrayList)
        showList.setOnClickListener {
            db.collection("Students").document("${studName.text} ${studSurname.text}").get().addOnSuccessListener { document ->
                if (document != null) {
                } else {
                }
            }
                .addOnFailureListener { exception ->
                }
            listview.adapter = adapter

        }
        return view
    }
}