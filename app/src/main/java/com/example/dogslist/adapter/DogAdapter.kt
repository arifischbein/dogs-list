package com.example.dogslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogslist.databinding.ItemDogBinding
import kotlin.properties.Delegates

class DogAdapter : RecyclerView.Adapter<DogViewHolder>() {
    private var items: MutableList<String> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }

    fun setData(data: List<String>) {
        this.items = data.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.render(items[position])
    }
}
