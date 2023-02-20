package com.example.sweetrock

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(val chpsList: ArrayList<Items>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val cont = context
    val arr = arrayOf(
        R.drawable.caramel_latte,
        R.drawable.iced_coffee,
        R.drawable.matcha_latte,
        R.drawable.hot_chocolate,
        R.drawable.mocha_frappuccino,
        R.drawable.cappuccino,
        R.drawable.americano,
        R.drawable.chai_latte,
        R.drawable.white_chocolate_mocha,
        R.drawable.cold_brew,
        R.drawable.espresso,
        R.drawable.fruit_smoothie,
        R.drawable.green_juice
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        try {
            val v: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_layout, parent, false)
            return ViewHolder(v)
        } catch (e: Exception) {
            Log.e("RecyclerAdapter", e.stackTraceToString())
            throw e
        }
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItems(chpsList[position])
    }

    override fun getItemCount() = chpsList.size

    // The class holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetails: TextView
        private val arr = arrayOf(
            R.drawable.caramel_latte,
            R.drawable.iced_coffee,
            R.drawable.matcha_latte,
            R.drawable.hot_chocolate,
            R.drawable.mocha_frappuccino,
            R.drawable.cappuccino,
            R.drawable.americano,
            R.drawable.chai_latte,
            R.drawable.white_chocolate_mocha,
            R.drawable.cold_brew,
            R.drawable.espresso,
            R.drawable.fruit_smoothie,
            R.drawable.green_juice
        )
        private val intArr =
            arrayOf(4.99, 2.99, 3.99, 4.49, 5.49, 3.99, 2.99, 4.49, 4.99, 3.49, 2.49, 4.99, 5.49)
        lateinit var cont: Context

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetails = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { view ->
                val pos = adapterPosition + 1
                val nerd: Intent = Intent(itemView.context, CardActivity::class.java)
                nerd.putExtra("name", itemTitle.text)
                nerd.putExtra("details", itemDetails.text)
                nerd.putExtra("image", arr[pos - 1])
                nerd.putExtra("price", "" + intArr[pos - 1])

                itemView.context.startActivity(nerd)
                Snackbar.make(view, "Click detected on item $pos", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

        fun bindItems(chp: Items) {
            itemTitle.text = chp.title
            itemDetails.text = chp.detail
            itemImage.setImageResource(chp.images)
        }
    }
}