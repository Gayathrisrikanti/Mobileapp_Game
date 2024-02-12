package com.example.gayathrisrikantilab3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


internal class MainActivity : AppCompatActivity() {
    var activities =
        arrayOf("Exercise1", "Exercise2", "Exercise3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1, activities
        )
        val list = findViewById<View>(R.id.list) as ListView
        list.adapter = adapter
        list.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->
                if (position == 0) {
                    val intent = Intent(applicationContext, Exercise1::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Exercise1 started",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 1) {
                    val intent = Intent(applicationContext, Exercise2::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Exercise2 started",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (position == 2) {
                    val intent = Intent(applicationContext, Exercise3::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Exercise3 started",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}