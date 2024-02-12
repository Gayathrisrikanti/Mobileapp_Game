package com.example.gayathrisrikantilab3

import android.annotation.SuppressLint
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Exercise1: AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var x = 50
    var y = 50
    var thickness = 0
    var color = Color.RED
    var imgVCanvas: ImageView? = null
    var paths = ArrayList<Path>()
    var paints = ArrayList<Paint>()
    var thick = arrayOf("20", "25", "30", "35", "40")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise01)
        //add spinner values
        val spinnerThickness = findViewById<View>(R.id.spnrThick) as Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, thick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerThickness.adapter = adapter
        spinnerThickness.onItemSelectedListener = this

        //get radio buttons value
        val rBtnRed = findViewById<View>(R.id.rBtnRed) as RadioButton
        val rBtnYellow = findViewById<View>(R.id.rBtnYellow) as RadioButton
        val rBtnCyan = findViewById<View>(R.id.rBtnCyan) as RadioButton
        val radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup
        radioGroup.setOnCheckedChangeListener { _, _ ->
            color =
                if (rBtnRed.isChecked) Color.RED else if (rBtnYellow.isChecked) Color.GREEN else if (rBtnCyan.isChecked) Color.YELLOW else Color.WHITE
        }
        imgVCanvas = findViewById<View>(R.id.imageView) as ImageView
        updateCoordinate()
        val buttonRight = findViewById<View>(R.id.btnRight) as Button
        buttonRight.setOnClickListener {
            if (x + thickness * 2 <= imgVCanvas!!.width) {
                val p = Path()
                p.moveTo(x.toFloat(), y.toFloat())
                x += thickness
                p.lineTo(x.toFloat(), y.toFloat())
                val paint = Paint()
                paint.style = Paint.Style.STROKE
                setPaint(paint)
                paint.color = color
                paint.strokeWidth = thickness.toFloat()
                paths.add(p)
                paints.add(paint)
                updateCoordinate()
                draw()
            }
        }
        val buttonDown = findViewById<View>(R.id.btnDown) as Button
        buttonDown.setOnClickListener {
            if (y + thickness * 2 <= imgVCanvas!!.height) {
                val p = Path()
                p.moveTo(x.toFloat(), y.toFloat())
                y += thickness
                p.lineTo(x.toFloat(), y.toFloat())
                val paint = Paint()
                paint.style = Paint.Style.STROKE
                setPaint(paint)
                paint.color = color
                paint.strokeWidth = thickness.toFloat()
                paths.add(p)
                paints.add(paint)
                updateCoordinate()
                draw()
            }
        }
        val buttonUp = findViewById<View>(R.id.btnUp) as Button
        buttonUp.setOnClickListener {
            if (y - thickness * 2 >= 0) {
                val p = Path()
                p.moveTo(x.toFloat(), y.toFloat())
                y -= thickness
                p.lineTo(x.toFloat(), y.toFloat())
                val paint = Paint()
                setPaint(paint)
                paint.color = color
                paint.strokeWidth = thickness.toFloat()
                paths.add(p)
                paints.add(paint)
                updateCoordinate()
                draw()
            }
        }
        val buttonLeft = findViewById<View>(R.id.btnLeft) as Button
        buttonLeft.setOnClickListener {
            if (x - thickness * 2 >= 0) {
                val p = Path()
                p.moveTo(x.toFloat(), y.toFloat())
                x -= thickness
                p.lineTo(x.toFloat(), y.toFloat())
                val paint = Paint()
                setPaint(paint)
                paint.color = color
                paint.strokeWidth = thickness.toFloat()
                paths.add(p)
                paints.add(paint)
                updateCoordinate()
                draw()
            }
        }
        val buttonClear = findViewById<View>(R.id.btnClear) as Button
        buttonClear.setOnClickListener {
            x = thickness
            y = thickness
            paths.clear()
            paints.clear()
            updateCoordinate()
            draw()
        }
    }

    fun setPaint(paint: Paint) {
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND // set the join to round you want
        paint.strokeCap = Paint.Cap.ROUND // set the paint cap to round too
        paint.pathEffect = CornerPathEffect(5F) // set the path effect when they join.
        paint.isAntiAlias = true // set anti alias so it smooths
    }

    fun draw() {
        val bitmap =
            Bitmap.createBitmap(imgVCanvas!!.width, imgVCanvas!!.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        imgVCanvas!!.setImageBitmap(bitmap)
        var i = 0
        while (i < paths.size && i < paints.size) {
            canvas.drawPath(paths[i], paints[i])
            i++
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateCoordinate() {
        val txtVCoordinate = findViewById<TextView>(R.id.txtVCoord)
        txtVCoordinate.text = "x:$x y:$y"
    }

    //get spinner value
    override fun onItemSelected(parent: AdapterView<*>?, view: View, i: Int, id: Long) {
        thickness = thick[i].toInt()
        x = thickness
        y = thickness
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
    }

