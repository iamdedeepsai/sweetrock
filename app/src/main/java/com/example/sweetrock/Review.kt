package com.example.sweetrock

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.sweetrock.databinding.FragmentReviewBinding
import com.example.sweetrock.databinding.FragmentReviewListBinding


class Review : Fragment() {
    private var _binding: FragmentReviewListBinding? = null
    private lateinit var binding2: FragmentReviewBinding
    private var listItems = ArrayList<String>()
    private var selectedDate: String = ""
    private lateinit var dialog: Dialog
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var myListView: ListView

    val fakeReviews = arrayOf(
        "This product is amazing! I can't believe how well it works!",
        "I was skeptical at first, but this product really surprised me with its quality.",
        "I've tried other similar products before, but this one is by far the best.",
        "I'm so happy I decided to give this product a try. It has exceeded all my expectations.",
        "This is a game changer! I don't know how I ever lived without it.",
        "I'm impressed with how durable this product is. It has held up great over time.",
        "I love the design of this product. It's both stylish and functional.",
        "I was hesitant to buy this product because of the price, but it's worth every penny.",
        "I've recommended this product to all my friends and family. It's that good.",
        "This product has made my life so much easier. I can't imagine going back to the way things were before."
    )


    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListView = _binding!!.dynamic

        for (i in 0..9) {
            listItems.add("Rating: " + (Math.random() * 2 + 4).toInt() + "\nReview: " + fakeReviews[i])
        }

        adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, listItems)
        myListView.adapter = adapter
        val fab = binding.floatingActionButton
        fab.setOnClickListener { view ->
            binding2 = FragmentReviewBinding.inflate(layoutInflater)
            var dialog = Dialog(requireContext())
            dialog.setContentView(binding2.root)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
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