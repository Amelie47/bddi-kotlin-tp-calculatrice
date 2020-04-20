package com.gmail.ameliemouillacpro.fragmenttest;

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.children
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gmail.ameliemouillacpro.location.R
import kotlinx.android.synthetic.main.location_fragment.*
import java.util.jar.Manifest

class LocationFragment: Fragment() {

    lateinit var text_info:TextView
    private var locationManager : LocationManager? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.location_fragment,container,false).apply {
            text_info = findViewById(R.id.text_view_info)

            if(ContextCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Verifier si l'utilisateur a déjà refusé la permission
                if(ActivityCompat.shouldShowRequestPermissionRationale(
                        activity as Activity,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    // utilisateur a deja refusé la permission, popup d'explication
                    text_info.text = "La permission a déjà été refusée (popup)"
                    var popup = fragmentManager?.let { AlertMissedPermission().show(it,"test") }
                } else {
                    // Demander la permission
                    text_info.text = "Il faut demander la permission"
                    ActivityCompat.requestPermissions(
                        activity as Activity,
                        arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                        0
                    )
                }
            } else {
                // Continuer car la permission est accordée
                text_info.text = "La permission a déjà été accordée, donc là on peut voir la map"
            }
        }

        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            0 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED))  {
                    // Permission accordée
                    text_info.text = "La permission a été accordée : on peut voir la position."

                } else {
                    // Permission refusée
                    // Désactiver certaines fonctionalités
                    // Afficher un message d'erreur
                    text_info.text = "La permission a été refusée : on ne peut pas voir la position."
                }
            }
            else -> {
                // le code ne concerne pas la permission, on ignore
            }
        }
    }
}

// Popup class
class AlertMissedPermission : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.popup_message)
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Demander la permission
                        ActivityCompat.requestPermissions(
                            activity as Activity,
                            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                            0
                        )
                    })
                .setNegativeButton("Annuler",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}