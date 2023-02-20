package com.example.sweetrock

import android.annotation.SuppressLint
import android.os.Bundle
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
        setContentView(R.layout.activity_card)
        val textView: TextView = findViewById(R.id.details)
        val nameTextView: TextView = findViewById(R.id.nameText)
        val textView2: TextView = findViewById(R.id.costTag)
        val cardPhoto: ImageView = findViewById(R.id.cardPhoto)
        nameTextView.text = str
        textView.text = details
        textView2.text = intent.getStringExtra("price")
        cardPhoto.setImageResource(intent.getIntExtra("image", 0))

        val count: TextView = findViewById(R.id.number)

        findViewById<AppCompatImageButton>(R.id.addBtn).setOnClickListener {
            count.text = (count.text.toString().toInt() + 1).toString()
        }

        findViewById<AppCompatImageButton>(R.id.minusBtn).setOnClickListener {
            count.text = (count.text.toString().toInt() - 1).toString()
        }
    }


}