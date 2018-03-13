package com.example.sangnguyen.colorpicker3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun pickColor (view : View){
        // create the color picker intent
        val colorIntent = Intent(this, ColorPicker::class.java)

        startActivityForResult(colorIntent, 1)
    }

    fun pickSecondColor(view : View){
        val secondColorIntent = Intent(this, ColorPicker::class.java)
        startActivityForResult(secondColorIntent,2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            var color = data!!.getIntExtra("Color", 0)
            firstWidget.setBackgroundColor(color)
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK){
            var color = data!!.getIntExtra("Color", 0)
            secondWidget.setBackgroundColor(color)
        }
    }
}
