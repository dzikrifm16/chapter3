package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuItems: List<MenuItem>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private var itemClickListener: ((MenuItem) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.menuItemName)
        val itemPrice: TextView = itemView.findViewById(R.id.menuItemPrice)
        val itemImage: ImageView = itemView.findViewById(R.id.menuItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]

        holder.itemName.text = menuItem.nama
        holder.itemPrice.text = "Rp. ${menuItem.harga}"
        holder.itemImage.setImageResource(menuItem.gambarId)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    // Menetapkan tindakan saat item diklik
    fun setOnItemClickListener(listener: (MenuItem) -> Unit) {
        itemClickListener = listener
    }
}
