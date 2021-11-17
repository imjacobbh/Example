package com.jacob.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jacob.example.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val contactList = listOf<Contact>(
        Contact("Jacob Bonilla", "449 279 6244", "https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png"),
        Contact("Dulce Bonilla", "449 291 3366", "https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png"),
        Contact("Fatima Huerta", "449 278 8688", "https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png"),
        Contact("Candy","449 288 8688", "https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        recyclerViewInit()

    }
    private fun recyclerViewInit(){
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = ContactAdapter(this,contactList)

    }
}