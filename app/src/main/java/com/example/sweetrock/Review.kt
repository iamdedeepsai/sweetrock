package com.example.sweetrock

import android.app.Dialog
import android.app.NotificationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.sweetrock.databinding.FragmentReviewBinding
import com.example.sweetrock.databinding.FragmentReviewListBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList


class Review : Fragment() {
    private var _binding: FragmentReviewListBinding? = null
    private lateinit var binding2: FragmentReviewBinding
    private var listItems = ArrayList<String>()
    private var selectedDate: String = ""
    private lateinit var dialog: Dialog
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var myListView : ListView

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentReviewListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListView = _binding!!.dynamic
        adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, listItems)
        myListView.adapter = adapter
        val fab = binding.floatingActionButton
        fab.setOnClickListener { view ->
            binding2 = FragmentReviewBinding.inflate(layoutInflater)
            var dialog = Dialog(requireContext())
            dialog.setContentView(binding2.root);
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false)
            dialog.show()
            binding2.button.setOnClickListener {
                listItems.add("Rating: " + binding2.rating.rating + "\nReview: " + binding2.editTextText.text)
                dialog.cancel()
                adapter.notifyDataSetChanged()
            }
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}