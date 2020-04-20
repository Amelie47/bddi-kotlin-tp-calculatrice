package com.gmail.ameliemouillacpro.fragmenttest;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment

class ChoiceFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first,container,false).apply {}

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var parent = view.findViewById<ConstraintLayout>(R.id.parent)
        parent.children.forEach { it ->
            if(it.tag == "btn") {
                it.setOnClickListener {
                    activity?.change(ComputationFragment.newInstance((it as Button).text as String))
                }
            }
        }
    }


    /**override fun onDestroyView() {
        super.onDestroyView()
        arguments?.putString("OPERATION", current)
    }**/

}