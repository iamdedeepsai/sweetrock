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

    val menu = arrayOf(
        mapOf(
            "name" to "Caramel Latte",
            "description" to "Espresso with steamed milk, caramel sauce, and whipped cream.",
            "price" to 4.99,
            "image" to R.drawable.caramel_latte
        ),
        mapOf(
            "name" to "Iced Coffee",
            "description" to "Chilled coffee with your choice of milk and sweetener.",
            "price" to 2.99,
            "image" to R.drawable.iced_coffee
        ),
        mapOf(
            "name" to "Matcha Latte",
            "description" to "Green tea powder with steamed milk and honey.",
            "price" to 3.99,
            "image" to R.drawable.matcha_latte
        ),
        mapOf(
            "name" to "Hot Chocolate",
            "description" to "Rich chocolate with steamed milk and whipped cream.",
            "price" to 4.49,
            "image" to R.drawable.hot_chocolate
        ),
        mapOf(
            "name" to "Mocha Frappuccino",
            "description" to "Blended coffee with chocolate syrup and whipped cream.",
            "price" to 5.49,
            "image" to R.drawable.mocha_frappuccino
        ),
        mapOf(
            "name" to "Cappuccino",
            "description" to "Espresso with equal parts steamed milk and frothed milk.",
            "price" to 3.99,
            "image" to R.drawable.cappuccino
        ),
        mapOf(
            "name" to "Americano",
            "description" to "Espresso shots with hot water, similar to drip coffee.",
            "price" to 2.99,
            "image" to R.drawable.americano
        ),
        mapOf(
            "name" to "Chai Latte",
            "description" to "Black tea with steamed milk, cinnamon, and other spices.",
            "price" to 4.49,
            "image" to R.drawable.chai_latte
        ),
        mapOf(
            "name" to "White Chocolate Mocha",
            "description" to "Espresso with white chocolate sauce and steamed milk.",
            "price" to 4.99,
            "image" to R.drawable.white_chocolate_mocha
        ),
        mapOf(
            "name" to "Cold Brew",
            "description" to "Slow-steeped coffee with a smooth, rich flavor.",
            "price" to 3.49,
            "image" to R.drawable.cold_brew
        ),
        mapOf(
            "name" to "Espresso",
            "description" to "A concentrated shot of coffee, perfect for a quick caffeine boost.",
            "price" to 2.49,
            "image" to R.drawable.espresso
        ),
        mapOf(
            "name" to "Fruit Smoothie",
            "description" to "A delicious blend of fresh fruit, yogurt, and ice.",
            "price" to 4.99,
            "image" to R.drawable.fruit_smoothie
        ),
        mapOf(
            "name" to "Green Juice",
            "description" to "A refreshing and healthy drink made with kale, spinach, and other greens.",
            "price" to 5.49,
            "image" to R.drawable.green_juice
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = GridLayoutManager(activity, 2)
        recyclerView.layoutManager = layoutManager

        for (i in menu.indices) {
            chpsList.add(
                Items(
                    menu[i]["name"] as String,
                    menu[i]["description"] as String,
                    menu[i]["image"] as Int
                )
            )
        }

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