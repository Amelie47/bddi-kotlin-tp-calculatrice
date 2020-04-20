package com.gmail.ameliemouillacpro.fragmenttest;

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.second_fragment.*

@Parcelize
class ComputationFragment: Fragment(), Parcelable {

    val operation: String by lazy {
        arguments?.getString(ARGS_OPERATION, "+") ?: "+"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment,container,false)
    }

    companion object {
        const val ARGS_OPERATION = "ARGS_OPERATION"
        fun newInstance(operation: String):ComputationFragment {
            return ComputationFragment().apply {
                //On sauvegarde l’opération dans les arguments,
                //Si le fragment se recrée, la valeur sera restaurée
                arguments = bundleOf(ARGS_OPERATION to operation)
            }
        }
    }

   /** override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(arguments?.getString(ARGS_OPERATION),ComputationFragment())

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        var myClass = savedInstanceState.getParcelable("hop")
    }**/

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nb1 = view.findViewById<EditText>(R.id.first_nb)
        val nb2 = view.findViewById<EditText>(R.id.second_nb)
        view.findViewById<Button>(R.id.btnresult).setOnClickListener {
            text_result.text = "Voici le résultat : ${nb1.text} ${arguments?.getString(ARGS_OPERATION)} ${nb2.text}"
        }
    }
}