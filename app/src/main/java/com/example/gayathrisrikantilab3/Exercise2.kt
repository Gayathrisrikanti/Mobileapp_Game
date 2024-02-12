package com.example.gayathrisrikantilab3
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class Exercise2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise2)

        val tv: CustomTextView = findViewById<View>(R.id.textView) as CustomTextView
        val c = Calendar.getInstance().time
        println("Current time => $c")
        val df = SimpleDateFormat("dd-MMMM-yyyy", Locale.getDefault())
        val formattedDate = df.format(c)
        tv.setText(formattedDate)
    }

}
