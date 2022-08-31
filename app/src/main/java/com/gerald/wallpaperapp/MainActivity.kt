package com.gerald.wallpaperapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gerald.wallpaperapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var wallpapers = ArrayList<Wallpaper>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSearch = findViewById<Button>(R.id.button)
        btnSearch.setOnClickListener {

        }

        wallpapers.add(
            Wallpaper(
                "Beach",
                "https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            )
        )
        wallpapers.add(
            Wallpaper(
                "Mountain",
                "https://images.pexels.com/photos/1261728/pexels-photo-1261728.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            )
        )
        wallpapers.add(
            Wallpaper(
                "Field",
                "https://images.pexels.com/photos/35857/amazing-beautiful-breathtaking-clouds.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            )
        )
        wallpapers.add(
            Wallpaper(
                "Clouds",
                "https://images.pexels.com/photos/2088205/pexels-photo-2088205.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            )
        )
        wallpapers.add(
            Wallpaper(
                "Condensation",
                "https://images.pexels.com/photos/891030/pexels-photo-891030.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            )
        )

        val adapter = WallpaperViewAdapter(wallpapers)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter
    }
}