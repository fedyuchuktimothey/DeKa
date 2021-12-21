package com.example.deka.fragments.groups_functions

import android.os.Bundle
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
import java.util.HashMap

class AddGroupFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_group, container, false)
        val studName = view.findViewById(R.id.addOneStudName) as EditText
        val studSurname = view.findViewById(R.id.addOneStudSurname) as EditText
        val addConcreteGroup = view.findViewById(R.id.addConcreteGroup) as Button
        val db = Firebase.firestore
        addConcreteGroup.setOnClickListener{
            val student = HashMap<String, Any>()
            student["name"] = studName.text.toString()
            student["surname"] = studSurname.text.toString()
            student["group"] = addConcreteGroup.text.toString()
            db.collection("Students").document("${studSurname.text} ${studName.text}")
                .set(student)
                .addOnSuccessListener { documentReference ->
                    //  Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    // Log.w(TAG, "Error adding document", e)
                }
            NavHostFragment.findNavController(this).navigate(R.id.studFunctionsFragment)
        }
        return view
    }
}