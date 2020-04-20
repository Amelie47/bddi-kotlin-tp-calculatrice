package com.gmail.ameliemouillacpro.testandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children

class MainActivity : AppCompatActivity() {

    // Calculs
    lateinit var calculus:Calculus

    // Result
    lateinit var result:Button
    lateinit var displaybar:TextView

    // Clear
    lateinit var clearbtn:Button

    // Historique
    lateinit var historique:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        displaybar = findViewById<TextView>(R.id.displayBar)

        result = findViewById<Button>(R.id.btnResult)
        result.setOnClickListener { resultClicked() }

        clearbtn = findViewById(R.id.btnClear)
        clearbtn.setOnClickListener { clearClicked() }

        calculus = Calculus()
        historique = mutableListOf<String>()

        event()
    }

    private fun event() {
        var parent = findViewById<ConstraintLayout>(R.id.parent)

        parent.children.forEach { it ->
            if(it.tag == "nb") {
                it.setOnClickListener { valueButtonClicked(it as Button) }
            }
            if(it.tag == "op") {
                it.setOnClickListener { operationButtonClicked(it as Button) }
            }
        }
    }

    //numbers
    private fun valueButtonClicked(btn:Button) {
        val txt = btn.text.toString()
        val value = txt.toDouble()
        calculus.addValue(value)
        displaybar.setText(calculus.stringRepresentation())
    }

    //operations
    private fun operationButtonClicked(btn:Button) {
        val txt = btn.text.toString()
        calculus.setOperator(txt)
        displaybar.setText(calculus.stringRepresentation())
    }

    //calcul
    private fun resultClicked() {
        val result = calculus.execute()
        displaybar.setText(result.toString())
        calculus.clear()
        historique.add("${calculus.stringRepresentation()} = $result")
    }

    //clear
    private fun clearClicked() {
        calculus.clear()
        displaybar.text = "0"
    }
}
