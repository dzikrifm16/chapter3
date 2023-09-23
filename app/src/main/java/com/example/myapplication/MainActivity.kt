package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val menuItems = listOf(
            MenuItem("Ayam Goreng", 40000, R.drawable.ayam_goreng, "Deskripsi Ayam Goreng", "Lokasi Ayam Goreng"),
            MenuItem("Ayam Bakar", 50000, R.drawable.ayam_bakar, "Deskripsi Ayam Bakar", "Lokasi Ayam Bakar"),
            MenuItem("Sate Ayam", 20000, R.drawable.sate_ayam, "Deskripsi Sate Ayam", "Lokasi Sate Ayam"),
            MenuItem("Sate Kambing", 30000, R.drawable.sate_kambing, "Deskripsi Sate Kambing", "Lokasi Sate Kambing")
        )


        val adapter = MenuAdapter(menuItems)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener { menuItem ->
            val googleMapsUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl))
            intent.setPackage("com.google.android.apps.maps") // Membuka dengan aplikasi Google Maps jika tersedia
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Handle jika Google Maps tidak tersedia di perangkat
                Toast.makeText(
                    this,
                    "Google Maps tidak tersedia di perangkat Anda",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
