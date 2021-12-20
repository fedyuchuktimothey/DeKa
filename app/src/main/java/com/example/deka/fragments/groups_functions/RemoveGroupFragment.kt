package com.example.deka.fragments.groups_functions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.deka.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RemoveGroupFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_remove_group, container, false)
        val groupNumber = view.findViewById(R.id.removeGroupNumber) as EditText
        val removeGroup = view.findViewById(R.id.removeConcreteGroup) as Button
        val db = Firebase.firestore
        removeGroup.setOnClickListener{
            val arrayList = ArrayList<String>()
            db.collection("Students")
                .whereEqualTo("group", groupNumber.text.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        db.collection("Students").document(document.id).delete()

                    }
                }
                .addOnFailureListener { exception ->
                }
            NavHostFragment.findNavController(this).navigate(R.id.groupsFunctionsFragment)
        }
        return view
    }
}