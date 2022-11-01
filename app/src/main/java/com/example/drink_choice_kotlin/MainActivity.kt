package com.example.drink_choice_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            val tv_meal = findViewById<TextView>(R.id.tv_meal)
            if(requestCode == 1 && resultCode == Activity.RESULT_OK){
                tv_meal.text = "飲料:${it.getString("drink")}\n\n" + "甜度:${it.getString("sugar")}\n\n" + "冰塊:${it.getString("ice")}"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_choice = findViewById<Button>(R.id.btn_choice)
        btn_choice.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent,1)
        }
    }
}
