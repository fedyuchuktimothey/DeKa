package com.example.deka.fragments.groups_functions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GroupInfoFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_group_info, container, false)
        val groupNumberInfo = view.findViewById(R.id.groupNumberInfo) as EditText
        val showInfo = view.findViewById(R.id.showInfo) as Button
        val studentsCount = view.findViewById(R.id.studentsCount) as TextView
        val successStud = view.findViewById(R.id.successStud) as TextView
        val unsuccessStud = view.findViewById(R.id.unsuccessStud) as TextView
        val db = Firebase.firestore
        Log.d("Step 1", "is done")

        showInfo.setOnClickListener {
            Log.d("Step 2", "is done")

            var i = 0
            db.collection("Students")
                .whereEqualTo("group", groupNumberInfo.text.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        i++
                        Log.d("Count",i.toString())
                        Log.d("All documents", "${document.id} => ${document.data["group"]}")


                    }
                    studentsCount.text = i.toString()

                }
                .addOnFailureListener { exception ->
                    Log.d("Error", "can't download file")

                }

        }
        return view
    }
}