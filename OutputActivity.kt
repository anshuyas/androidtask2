package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.RecyclerAdapter
import com.example.myapplication.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding

    // Data for RecyclerView
    private val imageList = arrayListOf(
        R.drawable.espresso, R.drawable.caramel, R.drawable.icedcoffee, R.drawable.peachicedtea,
        R.drawable.oreoshake, R.drawable.americano, R.drawable.cappuccino,
    )
    private val titleList = arrayListOf("Espresso Affogato", "Caramel Latte", "Iced coffee", "Peach Iced Tea",
        "Oreo Shake","Americano", "Cappuccino")
    private val descList = arrayListOf(
        "This is Espresso affogato", "This is Caramel latte", "This is Iced coffee", "This is Peach iced tea",
        "This is Oreo Shake", "This is Americano", "This is Cappuccino",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve Data from Intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")

        // Display Received Data
        binding.nameDisplay.text = name
        binding.emailDisplay.text = email
        binding.genderDisplay.text = gender
        binding.countryDisplay.text = country
        binding.cityDisplay.text = city

        // RecyclerView Setup
        val adapter = RecyclerAdapter(imageList, titleList, descList)
        binding.recycler.layoutManager = GridLayoutManager(this, 2)
        binding.recycler.adapter = adapter
    }
}