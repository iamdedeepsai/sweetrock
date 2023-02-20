package com.example.sweetrock

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sweetrock.databinding.FragmentAboutBinding
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
    private lateinit var myListView: ListView
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
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            try {
                replace(R.id.flFragment, fragment)
                commit()
            } catch (e: Exception) {
                print(e.stackTraceToString())
            }
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_about -> {
                val builder = AlertDialog.Builder(this)
                builder.setView(FragmentAboutBinding.inflate(layoutInflater).root)
                builder.setCancelable(true)
                builder.setTitle(getString(R.string.about_title))
                builder.setPositiveButton(R.string.alert_about){
                        dialog, which ->
                    run {
                    }
                }
                builder.create().show()
            }
        }
        return true
    }
}