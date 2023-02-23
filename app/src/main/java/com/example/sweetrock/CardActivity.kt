package com.example.sweetrock

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class CardActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val str: String? = intent.getStringExtra("name")
        val details: String? = intent.getStringExtra("details")
        val category: String? = intent.getStringExtra("category")
        setContentView(R.layout.activity_card)

        val textView: TextView = findViewById(R.id.details)
        val nameTextView: TextView = findViewById(R.id.nameText)
        val textView2: TextView = findViewById(R.id.costTag)
        val cardPhoto: ImageView = findViewById(R.id.cardPhoto)
        nameTextView.text = str + " ($category)"
        textView.text = details
        textView2.text = intent.getStringExtra("price")
        cardPhoto.setImageResource(intent.getIntExtra("image", 0))

        val count: TextView = findViewById(R.id.number)

        findViewById<AppCompatImageButton>(R.id.addBtn).setOnClickListener {
            count.text = (count.text.toString().toInt() + 1).toString()
        }

        findViewById<AppCompatImageButton>(R.id.minusBtn).setOnClickListener {
            if (count.text != "0") count.text = (count.text.toString().toInt() - 1).toString()
        }

        findViewById<Button>(R.id.add2Cart).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.backBtn).setOnClickListener {
            finish()
        }
    }


}