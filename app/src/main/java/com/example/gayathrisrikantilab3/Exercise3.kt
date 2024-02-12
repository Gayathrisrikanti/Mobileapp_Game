package com.example.gayathrisrikantilab3


import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity


class Exercise3 : AppCompatActivity() {
    private lateinit var start_stop2: ToggleButton
    private lateinit var moonImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.excercise3)
        moonImageView = findViewById(R.id.moon)
        moonImageView.setImageResource(R.drawable.moon)

        start_stop2 = findViewById<ToggleButton>(R.id.toggleButton2)
        start_stop2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                startAnimation()
            } else {
                stopAnimation()
            }
        }
    }

    private fun startAnimation() {
        val moonAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.moon_animation).apply {
            repeatCount = Animation.INFINITE
            repeatMode = Animation.RESTART
        }
        moonImageView.startAnimation(moonAnimation)
    }

    private fun stopAnimation() {
        moonImageView.clearAnimation()
    }
}