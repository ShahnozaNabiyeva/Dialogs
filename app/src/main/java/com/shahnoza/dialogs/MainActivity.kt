package com.shahnoza.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var btnDataPickerDialog:Button
    lateinit var btnTimePickerDialog:Button
    lateinit var btnBottomSheetDialoig:Button
    lateinit var btnSnackBarDialog:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        btnTimePickerDialog=findViewById(R.id.btntimePicker)
        btnDataPickerDialog.setOnClickListener {
            val dataPickerDialog=DatePickerDialog(this)
            dataPickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->

                Toast.makeText(this, "yil: $year oy: $month kun: $dayOfMonth", Toast.LENGTH_SHORT).show()

            }
        }



        btnDataPickerDialog=findViewById(R.id.btnDataPicker)
        btnTimePickerDialog.setOnClickListener {
            val timePicker=TimePickerDialog(this,object :TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                }
            },24,60,true)
            timePicker.updateTime(19,50)
            timePicker.show()
        }




        btnBottomSheetDialoig=findViewById(R.id.btnBottomSheetsDialog)
        btnBottomSheetDialoig.setOnClickListener {
            val bottomSheetDialog=BottomSheetDialog(this)
            val view = LayoutInflater.from(this).inflate(R.layout.item_bottom_sheets_dialog,null,false)
            bottomSheetDialog.setContentView(view)
            view.findViewById<MaterialButton>(R.id.btnSaqlash).setOnClickListener {
                val raqam = view.findViewById<TextInputEditText>(R.id.edtNumber).text.toString()
                Toast.makeText(this, "$raqam", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.show()
        }


        btnSnackBarDialog=findViewById(R.id.btnSnackBar)
        btnSnackBarDialog.setOnClickListener {
            val snackBar=Snackbar.make(it,"Tiklash",Snackbar.LENGTH_LONG)
            snackBar.setAction("O'chirilyapti",object :View.OnClickListener{
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Bosildi", Toast.LENGTH_SHORT).show()
                }

            })
            snackBar.show()
        }


    }
}