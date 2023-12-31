package com.example.dogslist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogslist.adapter.DogAdapter
import com.example.dogslist.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val dogAdapter = DogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
        setupSearchView()
        setupRecycler()
    }

    private fun setupObservers() {
        viewModel.dogDataLD.observe(this) { dogAdapter.setData(it) }
    }

    private fun setupSearchView() {
        binding.svDogs.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchByName(query.lowercase(Locale.ROOT))
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    private fun setupRecycler() {
        with(binding) {
            recyclerDogs.adapter = dogAdapter
            recyclerDogs.setHasFixedSize(true)
            recyclerDogs.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}
