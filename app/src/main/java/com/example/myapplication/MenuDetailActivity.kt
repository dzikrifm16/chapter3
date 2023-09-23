package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuDetailActivity : AppCompatActivity() {

    private var quantity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val menuDetailImage: ImageView = findViewById(R.id.menuDetailImage)
        val menuDetailName: TextView = findViewById(R.id.menuDetailName)
        val menuDetailPrice: TextView = findViewById(R.id.menuDetailPrice)
        val menuDetailDescription: TextView = findViewById(R.id.menuDetailDescription)
        val menuDetailLocation: TextView = findViewById(R.id.menuDetailLocation)
        val addToCartButton: Button = findViewById(R.id.addToCartButton)
        val incrementButton: Button = findViewById(R.id.incrementButton)
        val decrementButton: Button = findViewById(R.id.decrementButton)
        val quantityText: TextView = findViewById(R.id.quantityText)

        // Ambil data menu makanan dari Intent
        val intent = intent
        val menuItem = intent.getParcelableExtra<MenuItem>("menu_item")

        // Set data ke tampilan
        menuItem?.let {
            menuDetailImage.setImageResource(it.gambarId)
            menuDetailName.text = it.nama
            menuDetailPrice.text = "Rp. ${it.harga}"
            menuDetailDescription.text = it.deskripsi
            menuDetailLocation.text = it.lokasi
        }

        // Tambahkan onClickListener untuk membuka Google Maps
        menuDetailLocation.setOnClickListener {
            val googleMapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            val mapsIntent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl))
            mapsIntent.setPackage("com.google.android.apps.maps") // Membuka dengan aplikasi Google Maps jika tersedia
            if (mapsIntent.resolveActivity(packageManager) != null) {
                startActivity(mapsIntent)
            } else {
                // Handle jika Google Maps tidak tersedia di perangkat
            }
        }

        // Tambahkan tindakan ketika tombol "Tambah ke Keranjang" diklik
        addToCartButton.setOnClickListener {
            // Lakukan tindakan tambah ke keranjang di sini
        }

        // Tindakan saat tombol "+" diklik
        incrementButton.setOnClickListener {
            quantity++
            quantityText.text = quantity.toString()
        }

        // Tindakan saat tombol "-" diklik
        decrementButton.setOnClickListener {
            if (quantity > 0) {
                quantity--
                quantityText.text = quantity.toString()
            }
        }
    }
}
