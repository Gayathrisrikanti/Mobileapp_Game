package com.example.gayathrisrikantilab3
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


class CustomTextView(context: Context, attrs: AttributeSet?) :
    AppCompatTextView(context, attrs) {
    var showLongDate: String? = null

    init {
        val a = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomTextView,
            0, 0
        )
        try {
            val `set-longDate`= a.getString(R.styleable.CustomTextView_longDate)
        } finally {
            a.recycle()
        }
    }

    fun setlongDate(): Boolean {
        return showLongDate === "longDate"
    }

    fun setlongDate(longDate: String?) {
        showLongDate = longDate
        invalidate()
        requestLayout()
    }
}
