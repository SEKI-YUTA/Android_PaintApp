package com.example.paintapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClear:Button = findViewById(R.id.btnClear)
        val myView:MyView = findViewById(R.id.myView)

        btnClear.setOnClickListener {
            myView.clearCanvas()
        }
    }

    fun onRadioButtonClicked(view: View) {
        val myView: MyView = findViewById(R.id.myView)
        if(view is RadioButton) {
            val checked = view.isChecked

            when(view.getId()){
                R.id.radioCBlue -> if(checked) {
                    myView.changePaintColor(Color.BLUE)
                }
                R.id.radioCRed -> if(checked) {
                    myView.changePaintColor(Color.RED)
                }
            }
        }
    }


}