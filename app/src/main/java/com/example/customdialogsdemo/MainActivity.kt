package com.example.customdialogsdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.ib_imageButton)
        imageButton.setOnClickListener {view->
            Snackbar.make(view,"You Clicked Image Button",Snackbar.LENGTH_LONG).show()
        }
        val alertDialog :Button = findViewById(R.id.btn_alertDialog)
        alertDialog.setOnClickListener {view->
            alertDialogFunction()
        }
        val alertCustomDialog: Button = findViewById(R.id.btn_customDialog)
        alertCustomDialog.setOnClickListener {view->
            customAlertDialog()
        }
        val customProgressDialog: Button = findViewById(R.id.btn_customProgressDialog)
        customProgressDialog.setOnClickListener {
            customProgressDialog()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")

        builder.setMessage("This is Alert Dialog. Which is used to show alert Dialog")

        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){ dialogInterface,which->
            Toast.makeText(this,"Clicked Yes",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){ dialogInterface,which->
            Toast.makeText(this,"Clicked Cancel \n Operation Cancel",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){ dialogInterface,which->
            Toast.makeText(this,"Clicked No",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    private fun customAlertDialog(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.custom_dialog)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener{
            Toast.makeText(this,"SUBMIT CLICKED",Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener{
            Toast.makeText(this,"CANCEL CLICKED",Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun customProgressDialog(){
        val progressDialog = Dialog(this)
        progressDialog.setContentView(R.layout.progress_dialog)
        progressDialog.show()
    }
}