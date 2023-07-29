package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    lateinit var boxOneText : TextView
    lateinit var boxTwoText : TextView
    lateinit var boxThreeText : TextView
    lateinit var boxFourText : TextView
    lateinit var boxFiveText : TextView
    lateinit var boxSixText : TextView
    lateinit var boxSevenText : TextView
    lateinit var boxEightText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        boxOneText = findViewById<TextView>(R.id.box_one_text)
        boxTwoText = findViewById<TextView>(R.id.box_two_text)
        boxThreeText = findViewById<TextView>(R.id.box_three_text)
        boxFourText = findViewById<TextView>(R.id.box_four_text)
        boxFiveText = findViewById<TextView>(R.id.box_five_text)
        boxSixText = findViewById<TextView>(R.id.box_six_text)
        boxSevenText = findViewById<TextView>(R.id.box_seven_text)
        boxEightText = findViewById<TextView>(R.id.box_eight_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, boxSixText,
                boxSevenText, boxEightText, rootConstraintLayout
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        // Boxes using Color class colors for the background
        boxOneText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxTwoText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxThreeText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxFourText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxFiveText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxSixText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxSevenText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        boxEightText.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
        view.setBackgroundColor(Color.parseColor('#' + createRandomIntegerString(0x08)))
    }

    private fun createRandomIntegerString(length: Int): String {
        val stringBuilder = StringBuilder()
        val hexInterpolation = "0123456789abcdef"
        for (i in 0 until length) {
            val tmpInt = Random.nextInt()
            val x = abs(tmpInt) % 16
            stringBuilder.append(hexInterpolation[x])
        }
        return stringBuilder.toString()
    }
}