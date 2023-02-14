package com.example.sweetrock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sweetrock.databinding.FragmentCatalogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Catalog.newInstance] factory method to
 * create an instance of this fragment.
 */
class Catalog : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val chpsList = ArrayList<Items>()
    private lateinit var adapter: RecyclerAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = GridLayoutManager(activity,2)
        recyclerView.layoutManager = layoutManager
        chpsList.add(Items("Chapter One", "Introduction to Android App Development", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Two", "Android Layouts, Views and View Groups", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Three", "Android App Building and Event Handling", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Four", "Android Action Bars; Scrollable and Tabbed Layouts", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Five", "Elements of UX in App Design", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Six", "Intents on Fragments and Activities; Navigation", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Seven", "Advanced Internal System Components and APIs", R.drawable.ic_launcher_foreground))
        chpsList.add(Items("Chapter Eight", "PiP Transitions and Animations", R.drawable.ic_launcher_foreground))
        adapter = context?.let { RecyclerAdapter(chpsList, it) }!!
        recyclerView.adapter = adapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Catalog.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Catalog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}