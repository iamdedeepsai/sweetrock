package com.example.sweetrock

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val str: String? = intent.getStringExtra("name")
        setContentView(R.layout.activity_card)
        val textView: TextView = findViewById(R.id.tagText)
        textView.text = str
    }
}