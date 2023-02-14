package com.example.sweetrock

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sweetrock.databinding.FragmentReviewBinding
import com.example.sweetrock.databinding.FragmentReviewListBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var listItems = ArrayList<String>()
    private lateinit var dialog: Dialog
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var myListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val catalogFragment = Catalog()
        setCurrentFragment(catalogFragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.catalog -> setCurrentFragment(catalogFragment)
                R.id.signin -> setCurrentFragment(SignIn())
                R.id.review -> setCurrentFragment(Review())
                R.id.about -> setCurrentFragment(About())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            try {
                replace(R.id.flFragment, fragment)
                commit()
            }
            catch (e: Exception){
                print(e.stackTraceToString())
            }
        }
}